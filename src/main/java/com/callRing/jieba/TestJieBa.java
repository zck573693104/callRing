package com.callRing.jieba;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.huaban.analysis.jieba.JiebaSegmenter;

/**
 * Created by kcz on 2017/4/8.
 */
public class TestJieBa {

    @Autowired
    private JiebaSegmenter jiebaSegmenter;
    /**
     * 词语、词频（可省略）、词性（可省略），用空格隔开
     * Search模式，用于对用户查询词分词
     * Index模式，用于对索引文档分词
     */

    @Test
    public void testDemo() {
        String[] sentences =
                new String[] {"天才"};
        for (String sentence : sentences) {

            System.out.println(jiebaSegmenter.process(sentence, JiebaSegmenter.SegMode.INDEX).toString());
            System.out.println("-----------------------------");
            System.out.println(jiebaSegmenter.sentenceProcess(sentence));
        }
    }
}
