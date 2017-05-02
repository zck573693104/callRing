package com.callRing.activeMq.topic;

import com.callRing.common.po.Interset;
import com.callRing.common.service.IntersetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import java.util.Date;
import java.util.UUID;

@Service
public class TopicProvider {

	@Autowired
	private IntersetService intersetService;

	@Autowired
	@Qualifier("topicJmsTemplate")
	private JmsTemplate jmsTemplate;

	@Autowired
	@Qualifier("topicDestination")
	private Destination destination;

	public void publish(final String msg) {

		jmsTemplate.send(destination, new MessageCreator() {
			public Message createMessage(Session session) throws JMSException {
				intersetService.insert(getInterset(destination, msg));
				System.out.println("TopicProvider 发布了主题：\t" + destination.toString() + "，发布消息内容为:\t" + msg);
				return session.createTextMessage(msg);
			}
		});
	}

	/**
	 * 向指定的topic发布消息
	 *
	 * @param topic
	 * @param msg
	 */
	public void publishByTopic(final Destination topic, final String msg) {

		jmsTemplate.send(topic, new MessageCreator() {
			public Message createMessage(Session session) throws JMSException {
				intersetService.insert(getInterset(topic, msg));
				System.out.println("TopicProvider 发布了主题：\t" + topic.toString() + "，发布消息内容为:\t" + msg);
				return session.createTextMessage(msg);
			}
		});
	}

	private Interset getInterset(Destination topic, final String msg) {
		Date date = new Date();
		Interset interset = new Interset();
		interset.setId(UUID.randomUUID().toString());
		interset.setName(topic.toString());
		interset.setLastUpTime(date);
		interset.setFirTime(date);
		return interset;
	}

}
