package com.callRing.activeMq.queeue;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class ConsumerServiceImpl implements ConsumerService {
	@Autowired
	@Qualifier("queueJmsTemplate")
	private JmsTemplate jmsTemplate;

	/**
	 * 接受消息
	 */
	public void receive(Destination destination) {
		TextMessage tm = (TextMessage) jmsTemplate.receive(destination);
		try {
			System.out.println("ConsumerService从队列" + destination.toString() + "收到了消息：\t" + tm.getText());
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

}
