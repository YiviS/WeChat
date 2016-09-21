package com.weChat.service;

import com.weChat.entity.message.req.ReqTextMessage;
import com.weChat.entity.message.resp.RespBaseMessage;
import com.weChat.entity.message.resp.RespTextMessage;
import com.weChat.util.MessageUtil;
import org.springframework.stereotype.Service;

/**
 * @Author Xg
 * @Date 2016-09-21 9:53
 * @Desc 文本消息处理
 */
@Service
public class TextMessageService implements MessageService<ReqTextMessage>{


    public RespBaseMessage service(ReqTextMessage reqMessage){

        RespTextMessage textMessage = new RespTextMessage();
        textMessage.setToUserName(reqMessage.getFromUserName());
        textMessage.setFromUserName(reqMessage.getToUserName());
        textMessage.setCreateTime(System.currentTimeMillis());
        textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
        textMessage.setContent("这是文本消息/::)\n您发的文本消息为:" + reqMessage.getContent());
        return textMessage;
    }
}
