package org.zzc.chat.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zzc.base.model.util.HttpRequestTool;
import org.zzc.base.model.util.JsonTool;
import org.zzc.user.entity.TuLingResult;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * tuLing chat controller
 * Created by Administrator on 2015/8/31 0031.
 */
@Controller
@RequestMapping("/chat")
public class TulingChat {
    private static Logger logger = Logger.getLogger(TulingChat.class);
    private static String KEY = "0d79b2ddcc992ae679e0661f4898ff2e";
    private static String INFO = "你好";
    /** ����ͼ�������ƽ̨�ӿ�
     *   ��Ҫ����İ���commons-logging-1.0.4.jar�� httpclient-4.3.1.jar��httpcore-4.3.jar
     */
    @RequestMapping("/getChatContainer")
    @ResponseBody
    public TuLingResult getTulingApi(ModelMap modelMap, String info , HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        String URL = "http://www.tuling123.com/openapi/api?key=" + TulingChat.KEY + "&info=" + URLEncoder.encode(info, "utf-8");
       /* HttpGet request = new HttpGet(requesturl);
        HttpResponse response = HttpClients.createDefault().execute(request);*/
        String resultStr = HttpRequestTool.httpRequest(URL, "GET", null, "UTF-8");
        logger.info("resultStr = " + resultStr);
        //200����ȷ�ķ�����
        /*if(response.getStatusLine().getStatusCode()==200){
            String result = EntityUtils.toString(response.getEntity());
            System.out.println("���ؽ����"+result);
        }*/
        TuLingResult resultData = JsonTool.getObjByJsonStr(resultStr, TuLingResult.class);
        return resultData;
    }
    @RequestMapping("/gotoChat")
    public String gotoChatView() {
        return "chat/tuling_chat";
    }

    public static void main(String[] args) throws UnsupportedEncodingException {
        INFO = URLEncoder.encode("你好", "utf-8");
        logger.info("INFO[" + INFO + "]");
        String URL = "http://www.tuling123.com/openapi/api?key=" + KEY + "&info=" + INFO;
        String resultStr = HttpRequestTool.httpRequest(URL, "GET", null, "UTF-8");
        logger.info("resultStr = " + resultStr);
        TuLingResult resultData = JsonTool.getObjByJsonStr(resultStr, TuLingResult.class);
        System.out.println(resultData);
    }
}
