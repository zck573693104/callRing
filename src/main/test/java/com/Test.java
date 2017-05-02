package com;

import com.callRing.activeMq.topic.TopicProvider;
import com.callRing.friend.service.MessageService;
import com.callRing.task.Job;
import com.huaban.analysis.jieba.JiebaSegmenter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.jms.Destination;
import java.util.Date;

/**
 * Created by kcz on 2017/4/29.
 */
public class Test extends BaseJunit4Test {
    @Autowired
    private TopicProvider topicProvider;
    @Autowired
    @Qualifier("topicDestination")
    private Destination destination;
    @Autowired
    private JiebaSegmenter jiebaSegmenter;
    @Autowired
    private MessageService messageService;
    @Autowired
    private Job job;
    @org.junit.Test
    public void test () throws Exception {
        Date date =  new Date();
        date.setHours(00);
        date.setMinutes(00);
       job.getContext();

    }


}
