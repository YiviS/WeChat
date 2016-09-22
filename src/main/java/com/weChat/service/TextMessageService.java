package com.weChat.service;

import com.weChat.entity.message.req.ReqTextMessage;
import com.weChat.entity.message.resp.RespBaseMessage;
import com.weChat.entity.message.resp.RespTextMessage;
import com.weChat.util.MessageUtil;
import com.weChat.util.ToolsUtil;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @Author Xg
 * @Date 2016-09-21 9:53
 * @Desc 文本消息处理
 */
@Service
public class TextMessageService{

    /**
     *   文本消息
     *
     * @param xmlMap
     * @Author Xg
     * @Date 2016/9/22 13:29
     */
    public String  service(Map<String ,String > xmlMap){
        RespTextMessage textMessage = new RespTextMessage();
        textMessage.setToUserName(xmlMap.get("FromUserName")); // 接收方帐号（收到的OpenID）
        textMessage.setFromUserName(xmlMap.get("ToUserName"));  // 开发者微信号
        textMessage.setCreateTime(System.currentTimeMillis());
        textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
        textMessage.setContent(ToolsUtil.tulingRobot(xmlMap.get("Content")));
        return MessageUtil.messageToXml(textMessage);
    }

}
