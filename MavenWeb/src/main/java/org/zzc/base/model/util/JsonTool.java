/** */
package org.zzc.base.model.util;

import org.apache.log4j.Logger;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @功能:
 * @项目名:bdfarm
 * @作者:wangjz
 * @日期:2015年7月6日下午2:11:55
 */
public class JsonTool {
	/** 日志对象 */
	protected static Logger logger = Logger.getLogger(JsonTool.class);

	public static void main(String[] args) {

	}

	/***
	 * 将对象转换成json字符串
	 * 
	 * @param o
	 * @return
	 */
	public static String getJsonString(Object o) {
		ObjectMapper objMapper = new ObjectMapper();
		try {
			// objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(o);// 美化输出字符串
			return objMapper.writeValueAsString(o);
		} catch (Exception ex) {
			logger.error("将对象转换成json字符串失败", ex);
		}
		return "";
	}

	/***
	 * 将字符串转换成对象
	 * 
	 * @param str
	 * @param obj
	 * @return
	 */
	public static <T> T getObjByJsonStr(String str, Class<T> obj) {
		ObjectMapper objMapper = new ObjectMapper();
		objMapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
		objMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
		try {
			return objMapper.readValue(str, obj);
		} catch (Exception ex) {
			logger.error("解析json失败:" + str, ex);
		}
		return null;
	}
}
