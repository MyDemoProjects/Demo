/** */
package org.zzc.base.model.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.zzc.base.model.entity.MsgInfo;

/**
 * @功能:
 * @项目名:bdfarm
 * @作者:wangjz
 * @日期:2015年7月6日下午2:11:55
 */
public class HttpRequestTool {
	/** 日志对象 */
	protected static Logger logger = Logger.getLogger(HttpRequestTool.class);

	public static void main(String[] args) {

		/*
		 * String regCode = StringTool.bringValidateCode(4);// 验证码 String
		 * content = "您的验证码是：" + regCode + ",有效期限为30分钟 。请不要把验证码泄露给其他人。"; MsgInfo
		 * info = sendSms("13000000000", content); System.out.println(info);
		 */

		// String str =
		// "[{id:200046,\"type\":1,\"count\":2,\"dlyDate\":\"2015-07-10\",\"flag\":1},{\"id\":200046,\"type\":1,\"count\":1,\"dlyDate\":\"2015-07-11\",\"flag\":1}]";
		// ProductCookie[] productCookie = JsonTool.getObjByJsonStr(str, ProductCookie[].class);
		// System.out.println(productCookie[0].getDlyDate());
	}

	/**
	 * 发送短信
	 * 
	 * @param telNo
	 * @param content
	 * @return 2：提交成功
	 */
	public static MsgInfo sendSms(String telNo, String content) {
		String smsUrl = "http://106.ihuyi.cn/webservice/sms.php?method=Submit";// 短信发送url
		String result = null;
		MsgInfo info = new MsgInfo();
		try {
			String param = "account=cf_baodou&password=" + StringTool.MD5Encode("fengji800os", "UTF-8") + "&mobile="
					+ telNo + "&content=" + URLEncoder.encode(content, "UTF-8");
			result = httpRequest(smsUrl, "post", param, "utf-8");
			Document doc = DocumentHelper.parseText(result);
			Element root = doc.getRootElement();
			Element node = root.element("code");
			info.setId(new Integer(node.getTextTrim()));
			node = root.element("msg");
			if (info.getId() == 2) {
				info.setMsg("短信已发送成功！");
			} else if (info.getId() == 4085) {
				info.setMsg("每天每个手机号码只能发5条短信！");
			} else {
				info.setMsg(node.getTextTrim());
			}
			node = root.element("smsid");
			info.setRemark(node.getTextTrim());
		} catch (Exception ex) {
			info.setId(-1);
			info.setMsg("对不起，短信可能未发送成功。");
			logger.error("解析短信发送结果失败：" + result, ex);
		}
		return info;
	}

	/**
	 * 发送https请求
	 * 
	 * @param url 请求地址
	 * @param method 请求方式（GET、POST）
	 * @param param 提交的数据
	 * @return
	 */
	public static String httpsRequest(String url, String method, String param, String encode) {
		StringBuffer result = new StringBuffer();
		HttpsURLConnection conn = null;
		try {
			// 创建SSLContext对象，并使用我们指定的信任管理器初始化
			TrustManager[] tm = { new MyX509TrustManager() };
			SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
			sslContext.init(null, tm, new java.security.SecureRandom());
			SSLSocketFactory ssf = sslContext.getSocketFactory();

			conn = (HttpsURLConnection) new URL(url).openConnection();
			conn.setSSLSocketFactory(ssf);
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setUseCaches(false);
			conn.setRequestMethod(method.toUpperCase());
			if (param != null && param.length() > 0) { // 向页面传递参数。
				OutputStream out = conn.getOutputStream();
				out.write(param.getBytes("UTF-8"));
				out.flush();
				out.close();
			}
			// 读取返回的数据
			String line;
			BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), encode));
			while ((line = in.readLine()) != null) {
				result.append(line + "\r\n");
			}

			in.close();
			conn.disconnect();
		} catch (Exception ex) {
			logger.error("与服务器连接发生异常错误,连接地址是:" + url, ex);
		} finally {
			if (conn != null) {
				conn.disconnect();
			}
		}
		return result.toString();
	}

	/**
	 * 发送http请求
	 * 
	 * @param url 请求地址
	 * @param method 请求方式（GET、POST）
	 * @param param 提交的数据
	 * @param encode 字符编码
	 * @return
	 */
	public static String httpRequest(String url, String method, String param, String encode) {
		StringBuffer result = new StringBuffer();
		HttpURLConnection conn = null;
		try {
			conn = (HttpURLConnection) new URL(url).openConnection();
			conn.setRequestMethod(method.toUpperCase());
			conn.setDoOutput(true);// 这里是关键，表示我们要向链接里注入的参数
			conn.setDoInput(true);
			conn.setUseCaches(false);
			if (param != null && param.length() > 0) { // 向页面传递参数。
				OutputStream out = conn.getOutputStream();
				out.write(param.getBytes("UTF-8"));
				out.flush();
				out.close();
			}

			// 读取返回的数据
			String line;
			BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), encode));
			while ((line = in.readLine()) != null) {
				result.append(line + "\r\n");
			}
			in.close();
		} catch (Exception ex) {
			logger.error("与服务器连接发生异常错误,连接地址是:" + url, ex);
		} finally {
			if (conn != null) {
				conn.disconnect();
			}
		}
		return result.toString();
	}

	public static String getIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}

	/**
	 * 从客户端读取cookie，返回一个字符串
	 * 
	 * @param request
	 * @param cookieName cookie的名称
	 * @return
	 */
	public static String getStrFromCookie(HttpServletRequest request, String cookieName) {
		try {
			if (request.getCookies() != null) {
				for (Cookie c : request.getCookies()) {
					if (cookieName != null && cookieName.equals(c.getName())) {
						return URLDecoder.decode(c.getValue(), "utf-8");
					}
				}
			}
		} catch (Exception ex) {
			logger.error("从客户端读取cookie失败", ex);
		}
		return "";
	}

	/**
	 * 从客户端读取cookie，返回对象
	 * 
	 * @param request
	 * @param cookieName cookie的名称
	 * @param object
	 * @return
	 */
	public static <T> T getObjectFromCookie(HttpServletRequest request, String cookieName, Class<T> object) {
		String value = getStrFromCookie(request, cookieName);
		try {
			return JsonTool.getObjByJsonStr(value, object);
		} catch (Exception ex) {
			logger.error("从客户端读取cookie，返回对象失败", ex);
		}
		return null;
	}

	/**
	 * 证书信任管理器（用于https请求） 这个证书管理器的作用就是让它信任我们指定的证书，上面的代码意味着信任所有证书，不管是否权威机构颁发。
	 * 
	 * @author
	 * @date
	 */
	static class MyX509TrustManager implements X509TrustManager {

		public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {}

		public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {}

		public X509Certificate[] getAcceptedIssuers() {
			return null;
		}
	}

	/**
	 * 删除cookie
	 * 
	 * @param request
	 * @param response
	 * @param cookieName cookie的名字
	 */
	public static void deleteClientCookie(HttpServletResponse response, String cookieName) {
		try {
			Cookie myCookie = new Cookie(cookieName, null);
			myCookie.setMaxAge(0);
			myCookie.setPath("/");
			response.addCookie(myCookie);
		} catch (Exception ex) {
			logger.error("清空Cookies发生异常！", ex);
		}
	}
}
