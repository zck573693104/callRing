package com.callRing.jieba;

import com.huaban.analysis.jieba.JiebaSegmenter;
import org.junit.Test;

/**
 * Created by kcz on 2017/4/8.
 */
public class TestJieBa {
    /**
     * 词语、词频（可省略）、词性（可省略），用空格隔开
     * Search模式，用于对用户查询词分词
     * Index模式，用于对索引文档分词
     */
    @Test
    public void testDemo() {
        JiebaSegmenter segmenter = new JiebaSegmenter();
        String[] sentences =
                new String[] {"天才"};
        for (String sentence : sentences) {

            System.out.println(segmenter.process(sentence, JiebaSegmenter.SegMode.INDEX).toString());
            System.out.println("-----------------------------");
            System.out.println(segmenter.sentenceProcess(sentence));
        }
    }
}
