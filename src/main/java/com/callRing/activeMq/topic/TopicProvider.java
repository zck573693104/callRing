package com.callRing.activeMq.topic;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import com.callRing.common.po.Interset;
import com.callRing.common.po.UserIntersetRelation;
import com.callRing.common.service.serviceImpl.IntersetServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import java.util.Date;

public class TopicProvider {



  @Autowired
  private JmsTemplate jmsTemplate;

  /**
   * 向指定的topic发布消息
   * 
   * @param topic
   * @param msg
   */
  public void publish(final Destination topic, final String msg) {

    jmsTemplate.send(topic, new MessageCreator() {
      public Message createMessage(Session session) throws JMSException {
        //intersetService.insert(getInterset(topic,msg));
        System.out.println("TopicProvider 发布了主题：\t" + topic.toString() + "，发布消息内容为:\t" + msg);
        return session.createTextMessage(msg);
      }
    });
  }

  private Interset getInterset(Destination topic,final String msg) {
    Date date = new Date();
    Interset interset = new Interset();
    interset.setName(topic.toString());
    interset.setContext(msg);
    interset.setLastUpTime(date);
    interset.setFirTime(date);
    interset.setDescription("");
    return interset;
  }

  public void setTopicJmsTemplate(JmsTemplate topicJmsTemplate) {
    this.jmsTemplate = topicJmsTemplate;
  }

}
