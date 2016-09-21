package com.weChat.controller;

import com.weChat.entity.WeChat;
import com.weChat.entity.message.req.ReqBaseMessage;
import com.weChat.entity.message.req.ReqMessageFactory;
import com.weChat.entity.message.resp.RespBaseMessage;
import com.weChat.service.CoreService;
import com.weChat.util.Contents;
import com.weChat.util.ExceptionUtil;
import com.weChat.util.MessageUtil;
import com.weChat.util.SignUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * @Author Xg
 * @Date 2016-09-13 15:57
 * @Desc 请求处理的核心类
 */
@Controller
@RequestMapping("/main")
public class CoreController extends HttpServlet {

    private static Logger log = LoggerFactory.getLogger(CoreController.class);
    @Autowired
    private CoreService coreService;
    /**
     * 处理微信服务器发来的验证请求
     * @return 验证成功返回随机字符串
     */
    @RequestMapping(value="/service.do",method = RequestMethod.GET, produces = "text/plain")
    @ResponseBody
    public String validate(WeChat weChat) throws ServletException, IOException {
        System.out.println("--------------- 偷偷的进来验证了 ---------------");
        // 请求校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败
        if (SignUtil.checkSignature(weChat, Contents.token)) {
            System.out.println("--------------- 验证经验通过了：Echostr（"+weChat.getEchostr()+"）---------------");
            return weChat.getEchostr();
        } else {
            System.out.println("--------------- 这是什么鬼？根本不是微信服务器发来的请求! ---------------");
            return null;
        }
    }
    /**
     * 处理微信服务器发来的请求
     *
     * @return 返回响应消息
     */
    @RequestMapping(value="/service.do",method = RequestMethod.POST)
    @ResponseBody
    public String getWeiXinMessage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("--------------- 窃取了你的微信消息 ---------------");
        request.setCharacterEncoding("UTF-8");  //微信服务器POST消息时用的是UTF-8编码，在接收时也要用同样的编码，否则中文会乱码；
        response.setCharacterEncoding("UTF-8"); //在响应消息（回复消息给用户）时，也将编码方式设置为UTF-8，原理同上；
        String respMessage = "";
        try {
            // 遍历求情中的所有字段转化为map
            Map<String, String> xmlMap = MessageUtil.parseXml(request);
            ReqBaseMessage reqMessage = ReqMessageFactory.build(xmlMap);
            respMessage = coreService.service(reqMessage);
        }catch (Exception e){
            log.info("解析请求发生错误："+ ExceptionUtil.getErrorInfo(e));
        }
        return respMessage;
    }
}
