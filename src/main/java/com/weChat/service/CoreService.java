package com.weChat.service;

import com.weChat.entity.message.req.ReqBaseMessage;
import com.weChat.entity.message.req.ReqTextMessage;
import com.weChat.entity.message.resp.RespBaseMessage;
import com.weChat.entity.message.resp.RespTextMessage;
import com.weChat.util.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Map;

/**
 * @Author Xg
 * @Date 2016-09-13 15:59
 * @Desc 核心服务类
 */
@Service
public class CoreService {
    @Autowired
    private TextMessageService textMessageService;
    /**
     *  处理微信发来的请求
     *
     * @param xmlMap
     * @Author Xg
     * @Date 2016/9/13 15:59
     */
    public String service(Map<String, String> xmlMap) {
        String respMessage = "";
        String msgType = xmlMap.get("MsgType"); //获取消息类型
        if(MessageUtil.REQ_MESSAGE_TYPE_TEXT.equals(msgType)) { // 处理文本消息
            respMessage = textMessageService.service(xmlMap);
        }else if(MessageUtil.REQ_MESSAGE_TYPE_VOICE.equals(msgType)){
            respMessage =  buildErrorRespMessage("这是一个语音消息", xmlMap);
        }else{
            respMessage =  buildErrorRespMessage("竟然报了一个异常，稍等我看一下！", xmlMap);
        }
        return respMessage;
    }
    /**
     *  请求异常处理方法
     *
     * @param
     * @Author Xg
     * @Date 2016/9/20 18:13
     */
    private static String buildErrorRespMessage(String error,Map<String, String> xmlMap) {
        RespTextMessage respTextMessage = new RespTextMessage();
        respTextMessage.setContent(error);
        respTextMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
        respTextMessage.setCreateTime(System.currentTimeMillis());
        respTextMessage.setFromUserName(xmlMap.get("ToUserName"));
        respTextMessage.setToUserName(xmlMap.get("FromUserName"));
        return MessageUtil.messageToXml(respTextMessage);
    }
}
