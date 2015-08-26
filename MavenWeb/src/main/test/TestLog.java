import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * 测试log4j
 * Created by zhoumeiqin on 15/8/25.
 */
public class TestLog {
    private static Logger logger = Logger.getLogger(TestLog.class);
//    @Test
//    public void testLog() {
//        logger.info("这是一个测试");
//    }
    public static void main(String[] args) {
        logger.info("测试");
    }
}
