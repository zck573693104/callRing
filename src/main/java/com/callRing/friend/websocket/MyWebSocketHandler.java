package com.callRing.friend.websocket;

import com.callRing.friend.po.Message;
import com.callRing.friend.service.MessageService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.*;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.*;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class MyWebSocketHandler implements WebSocketHandler {

	@Autowired
	private MessageService messageService;

	private static final Logger logger = LoggerFactory.getLogger(MyWebSocketHandler.class);

	public Map<String, WebSocketSession> userSocketSessionMap = new ConcurrentHashMap<>();

	/**
	 * 建立连接后
	 */
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		String userName = (String) session.getAttributes().get("userName");
		if (userSocketSessionMap.get(userName) == null) {
			userSocketSessionMap.put(userName, session);
		}
	}

	/**
	 * 消息处理，在客户端通过Websocket API发送的消息会经过这里，然后进行相应的处理
	 */
	public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
		if (message.getPayloadLength() == 0)
			return;
		Message messagePo = new Message();
		messagePo = new Gson().fromJson(message.getPayload().toString(), Message.class);
		messagePo.setSendDate(new Timestamp(new Date().getTime()));
		sendMessageToUser(messagePo,
				new TextMessage(new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create().toJson(messagePo)));// 消息发送通过这个方法
	}

	/**
	 * 消息传输错误处理
	 */
	public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
		if (session.isOpen()) {
			session.close();
		}
		Iterator<Entry<String, WebSocketSession>> it = userSocketSessionMap.entrySet().iterator();
		closeSocket(it, session);
	}

	/**
	 * 关闭连接后
	 */
	public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
		System.out.println("Websocket:" + session.getId() + "已经关闭");
		Iterator<Entry<String, WebSocketSession>> it = userSocketSessionMap.entrySet().iterator();
		closeSocket(it, session);
	}

	/**
	 * 移除会话
	 * 
	 * @param it
	 *            需要关闭的session的迭代器
	 * @param session
	 */
	public void closeSocket(Iterator<Entry<String, WebSocketSession>> it, WebSocketSession session) {
		// 移除Socket会话
		while (it.hasNext()) {
			Entry<String, WebSocketSession> entry = it.next();
			if (entry.getValue().getId().equals(session.getId())) {
				userSocketSessionMap.remove(entry.getKey());
				logger.debug("Socket会话已经移除:用户ID" + entry.getKey());
				break;
			}
		}
	}

	public boolean supportsPartialMessages() {
		return false;
	}

	/**
	 * 给所有在线用户发送消息
	 *
	 * @param message
	 * @throws IOException
	 */
	public void broadcast(final TextMessage message) throws IOException {
		Iterator<Entry<String, WebSocketSession>> it = userSocketSessionMap.entrySet().iterator();

		// 多线程群发
		while (it.hasNext()) {

			final Entry<String, WebSocketSession> entry = it.next();

			if (entry.getValue().isOpen()) {

				new Thread(new Runnable() {

					public void run() {
						try {
							WebSocketSession session = entry.getValue();
							if (session.isOpen()) {
								session.sendMessage(message);
							}
						} catch (IOException e) {
							e.printStackTrace();
						}
					}

				}).start();
			}

		}
	}

	/**
	 * 给某个用户发送消息
	 * 
	 * @param messagePo
	 * @param message
	 * @throws IOException
	 */
	public void sendMessageToUser(Message messagePo , TextMessage message) throws IOException {
		List<Message> messageList = new ArrayList<>();
		messagePo.setSendTimestamp(new Timestamp(System.currentTimeMillis()));
		messageList.add(messagePo);
		WebSocketSession session = userSocketSessionMap.get(messagePo.getFriendName());
		if (session != null && session.isOpen()) {
			session.sendMessage(message);// friendName的session 如果接收者不在线session是关闭的

		} else {
			try {
				messageService.insertMessage(messageList);
			} catch (Exception e) {
				logger.error("发送失败", e);
			}

			// new MessageQueue().saveMessageToRedis(friendName,message);
		}

	}

}
