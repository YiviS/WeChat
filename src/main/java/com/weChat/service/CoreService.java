package com.weChat.service;

import com.weChat.entity.message.req.ReqBaseMessage;
import com.weChat.entity.message.resp.RespTextMessage;
import com.weChat.util.MessageUtil;
import org.springframework.stereotype.Service;

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
    public static String  processRequest(ReqBaseMessage reqMessage) {

        String  respMessage = null;
        String msgType = reqMessage.getMsgType(); //获取消息类型

        if(MessageUtil.REQ_MESSAGE_TYPE_TEXT.equals(msgType)) { // 处理文本消息
            return null;
        }else{
            respMessage =  buildErrorRespMessage("请求处理异常，请稍候尝试！", reqMessage);
            return respMessage;
        }
    }
    /**
     *  请求异常处理方法
     *
     * @param
     * @Author Xg
     * @Date 2016/9/20 18:13
     */
    private static String  buildErrorRespMessage(String error,ReqBaseMessage reqMessage) {
        RespTextMessage respTextMessage = new RespTextMessage();
        respTextMessage.setContent(error);
        respTextMessage.setCreateTime(System.currentTimeMillis());
        respTextMessage.setFromUserName(reqMessage.getToUserName());
        respTextMessage.setToUserName(reqMessage.getFromUserName());
        return MessageUtil.messageToXml(respTextMessage);
    }
}
