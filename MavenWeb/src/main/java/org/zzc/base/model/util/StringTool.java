/** */
package org.zzc.base.model.util;

import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Formatter;

import org.apache.log4j.Logger;

/**
 * @功能:
 * @项目名:bdfarm
 * @作者:wangjz
 * @日期:2015年7月6日下午2:13:42
 */
public class StringTool {
    /**
     * 日志对象
     */
    protected static Logger logger = Logger.getLogger(StringTool.class);

    /**
     * 产生length长度的一个随机数
     *
     * @param length
     * @return
     */
    public static String bringValidateCode(int length) {
        StringBuffer s = new StringBuffer();
        for (int i = 0; i < length; i++) {
            Double d = Math.random() * 10;
            s.append(d.intValue());
        }
        return s.toString();
    }

    /**
     * 是否不为空
     *
     * @param str
     * @return
     */
    public static boolean isNotEmpty(String str) {
        if (str != null) {
            if (str.length() == 0) {
                return false;
            } else {
                return true;
            }
        }
        return false;
    }

    /**
     * 获取交易时的批次号、交易号等等
     *
     * @param prefix     前缀如 DD、PC...
     * @param dateFormat 时间格式 如 yyyyMMddHHmmssSSS
     * @param suffixLen  末尾追加的随即串长度
     * @return
     */
    public static String getTimeCode(String prefix, String dateFormat, int suffixLen) {
        return prefix + new SimpleDateFormat(dateFormat).format(new Date()) + bringValidateCode(suffixLen);
    }

    /**
     * 在字符前加0，达到一定的位数，目前最长支持补10位零
     *
     * @param oldStr
     * @param length
     * @return
     */
    public static String fillZero(String oldStr, int length) {
        String[] zeorArray = new String[]{"", "0", "00", "000", "0000", "00000", "000000", "0000000", "00000000",
                "000000000", "0000000000"};
        if (length < oldStr.length()) {
            return oldStr;
        }
        return zeorArray[length - oldStr.length()] + oldStr;
    }

    /**
     * md5加密
     *
     * @param str
     * @return
     */
    public static String MD5Encode(String str, String charsetname) {
        StringBuffer resultSb = new StringBuffer();
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] arr = md.digest(str.getBytes(charsetname));
            String[] hexDigits = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"};
            for (int b : arr) {
                if (b < 0) {
                    b = 256 + b;
                }
                int d1 = b / 16;
                int d2 = b % 16;
                resultSb.append(hexDigits[d1] + hexDigits[d2]);
            }

            return resultSb.toString();
        } catch (Exception ex) {
            logger.error("md5加密失败！", ex);
        }
        return null;
    }

    /**
     * sha1加密
     *
     * @param str
     * @return
     */
    public static String sha1Encode(String str) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            md.reset();
            md.update(str.getBytes("UTF-8"));
            byte[] arr = md.digest();

            Formatter formatter = new Formatter();
            for (byte b : arr) {
                formatter.format("%02x", b);
            }
            String result = formatter.toString();
            formatter.close();
            return result;
        } catch (Exception ex) {
            logger.error("SHA-1加密失败！", ex);
        }
        return null;
    }

    public static void main(String[] args) {
        // System.out.println(StringTool.MD5Encode("wangjz", "UTF-8"));
        /*
         * System.out
		 * .println(StringTool
		 * .sha1Encode(
		 * "jsapi_ticket=sM4AOVdWfPE4DxkXGEs8VMuApKnx14tsael2MZAh50tImfPVrl8kwf5hMIPkXw7b83GX24kcPeh7TioghYaoQg&noncestr=bb6db48f-842d-474a-894c-248eaaa772e6&timestamp=1438914866&url=http://www.baidu.com"
		 * ));
		 */
        String token = "baodouhz";
        // 签名
        String signature = "74C953681AF813E5CD61AC477D7F70602F0BC5BD";

        String timestamp = "20150814171425005";
        String nonce = "99";
        String[] arr = new String[]{token, timestamp, nonce};
        // 将token、timestamp、nonce三个参数进行字典序排序
        Arrays.sort(arr);
        StringBuilder content = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            content.append(arr[i]);
        }
        String result = sha1Encode(content.toString());
        System.out.println(result);
        if (result != null && result.equalsIgnoreCase(signature)) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }

    }
}
