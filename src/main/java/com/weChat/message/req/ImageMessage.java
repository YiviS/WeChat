package com.weChat.message.req;

/**
 * @Author Xg
 * @Date 2016-09-13 15:00
 * @Desc 图片消息
 */
public class ImageMessage extends BaseMessage{
    // 图片路径
    private String PicUrl;

    public String getPicUrl() {
        return PicUrl;
    }

    public void setPicUrl(String picUrl) {
        PicUrl = picUrl;
    }
}
