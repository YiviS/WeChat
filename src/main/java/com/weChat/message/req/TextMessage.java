package com.weChat.message.req;

/**
 * @Author Xg
 * @Date 2016-09-13 15:01
 * @Desc 文本消息
 */
public class TextMessage extends BaseMessage{
    // 消息内容
    private String Content;

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }
}
