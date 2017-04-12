

package com.friend.websocket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

import javax.servlet.http.HttpSession;
import java.util.Map;


public class HandShake implements HandshakeInterceptor {

	private static final Logger log= LoggerFactory.getLogger(HandShake.class);

	public boolean beforeHandshake(ServerHttpRequest request,
								   ServerHttpResponse response,
								   WebSocketHandler wsHandler,
								   Map<String, Object> attributes)
			throws Exception {
		log.debug("Websocket:用户[名:" + ((ServletServerHttpRequest) request).getServletRequest().getSession(false).getAttribute("userName") + "]已经建立连接");
		if (request instanceof ServletServerHttpRequest) {
			ServletServerHttpRequest servletRequest = (ServletServerHttpRequest) request;
			// false若存在会话则返回该会话，否则返回NULL  true若存在会话则返回该会话，否则新建一个会话
			HttpSession session = servletRequest.getServletRequest().getSession(false);
			// 标记用户
			String userName = (String) session.getAttribute("userName");
			if(userName!=null){
				attributes.put("userName", userName);
			}else{
				return false;
			}
		}
		return true;
	}

	public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Exception exception) {
	}

}
