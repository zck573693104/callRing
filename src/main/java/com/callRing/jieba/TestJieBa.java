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
                new String[] {"这是一个伸手不见五指的黑夜。我叫孙悟空，我爱北京，我爱Python和C++。", "我不喜欢日本和服。", "雷猴回归人间。",
                        "工信处女干事每月经过下属科室都要亲口交代24口交换机等技术性器件的安装工作", "结果婚的和尚未结过婚的"};
        for (String sentence : sentences) {

            System.out.println(segmenter.process(sentence, JiebaSegmenter.SegMode.INDEX).toString());
            System.out.println("-----------------------------");
            System.out.println(segmenter.sentenceProcess(sentence));
        }
    }
}
