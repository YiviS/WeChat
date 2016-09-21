package com.weChat.service;

import com.weChat.entity.message.req.ReqBaseMessage;
import com.weChat.entity.message.req.ReqTextMessage;
import com.weChat.entity.message.resp.RespBaseMessage;
import com.weChat.entity.message.resp.RespTextMessage;
import com.weChat.util.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * @Author Xg
 * @Date 2016-09-13 15:59
 * @Desc 核心服务类
 */
@Service
public class CoreService {
    /**
     *  处理微信发来的请求
     *
     * @param request
     * @Author Xg
     * @Date 2016/9/13 15:59
     */
    public String service(ReqBaseMessage reqMessage) {
        String respMessage = "";
        String msgType = reqMessage.getMsgType(); //获取消息类型

        if(MessageUtil.REQ_MESSAGE_TYPE_TEXT.equals(msgType)) { // 处理文本消息
            //RespBaseMessage textMessage = textMessageService.service((ReqTextMessage)reqMessage);
            //return MessageUtil.messageToXml(textMessage);
            respMessage =  buildErrorRespMessage("我就测试一下看看行不行！", reqMessage);
        }else{
            respMessage =  buildErrorRespMessage("竟然报了一个异常，稍等我看一下！", reqMessage);
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
    private static String buildErrorRespMessage(String error,ReqBaseMessage reqMessage) {
        RespTextMessage respTextMessage = new RespTextMessage();
        respTextMessage.setContent(error);
        respTextMessage.setMsgType(MessageUtil.REQ_MESSAGE_TYPE_TEXT);
        respTextMessage.setCreateTime(System.currentTimeMillis());
        respTextMessage.setFromUserName(reqMessage.getToUserName());
        respTextMessage.setToUserName(reqMessage.getFromUserName());
        return MessageUtil.messageToXml(respTextMessage);
    }
}
