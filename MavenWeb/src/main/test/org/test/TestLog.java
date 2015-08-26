package org.test;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 测试log4j
 * Created by zhoumeiqin on 15/8/25.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-context.xml",
        "classpath:conf/*.xml"})
public class TestLog {
    private static Logger logger = Logger.getLogger(TestLog.class);
    @Test
    public void testLog() {
        logger.info("这是一个测试");
    }
  /*  public static void main(String[] args) {
        logger.info("测试");
    }*/
}
