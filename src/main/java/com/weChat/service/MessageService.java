package com.weChat.service;

import com.weChat.entity.message.req.ReqBaseMessage;
import com.weChat.entity.message.resp.RespBaseMessage;

/**
 * @Author Xg
 * @Date 2016-09-21 10:20
 * @Desc
 */
public interface MessageService<ReqMessage extends ReqBaseMessage> {
    RespBaseMessage service(ReqMessage reqMessage);
}
