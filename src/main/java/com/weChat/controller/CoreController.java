package com.weChat.controller;

import com.weChat.entity.WeChat;
import com.weChat.entity.message.req.ReqBaseMessage;
import com.weChat.entity.message.req.ReqMessageFactory;
import com.weChat.service.CoreService;
import com.weChat.util.Contents;
import com.weChat.util.ExceptionUtil;
import com.weChat.util.MessageUtil;
import com.weChat.util.SignUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
@RequestMapping("/wechat")
public class CoreController extends HttpServlet {

    private static Logger log = LoggerFactory.getLogger(CoreController.class);
    /**
     * 处理微信服务器发来的验证请求
     * @return 验证成功返回随机字符串
     */
    @RequestMapping(value="/service.do",method = RequestMethod.GET)
    @ResponseBody
    public String validate(WeChat weChat) throws ServletException, IOException {

        // 请求校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败
        if (SignUtil.checkSignature(weChat, Contents.token)) {
            return weChat.getEchostr();
        } else {
            System.out.println("----- 这是什么鬼？根本不是微信服务器发来的请求! ----");
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
    public String  getWeiXinMessage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 将请求、响应的编码均设置为UTF-8（防止中文乱码）
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String respMessage = "";
        try {
            // //遍历求情中的所有字段转化为map
            Map<String, String> xmlMap = MessageUtil.parseXml(request);
            ReqBaseMessage reqMessage = ReqMessageFactory.build(xmlMap);
            //初始化配置文件
            //调用CoreService类的processRequest方法接收、处理消息，并得到处理结果；
            respMessage = CoreService.processRequest(reqMessage);
        }catch (Exception e){
            log.info("解析请求发生错误："+ ExceptionUtil.getErrorInfo(e));
        }
        // 响应消息，调用response.getWriter().write()方法将消息的处理结果返回给用户
        return respMessage;
    }
}
