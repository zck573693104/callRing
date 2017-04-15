package com.callRing.activeMq.topic;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * 和队列监听的代码一样。
 */
public class TopicMessageListener implements MessageListener {
  /**
   * 被监听就是被订阅被消费
   * @param message
   */
  public void onMessage(Message message) {
    TextMessage tm = (TextMessage) message;
    try {
      System.out.println("TopicMessageListener 监听到消息：\t" + tm.getText());
    } catch (JMSException e) {
      e.printStackTrace();
    }
  }

}
