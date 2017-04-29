package com;

import com.callRing.activeMq.topic.TopicProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.jms.Destination;

/**
 * Created by kcz on 2017/4/29.
 */
public class Test extends BaseJunit4Test {
    @Autowired
    private TopicProvider topicProvider;
    @Autowired
    @Qualifier("topicDestination")
    private Destination destination;

    @org.junit.Test
    public void test (){
        topicProvider.publish(destination,"");
    }
}
