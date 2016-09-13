package com.weChat.message.req;

/**
 * @Author Xg
 * @Date 2016-09-13 15:02
 * @Desc 视频消息
 */
public class VideoMessage extends BaseMessage{
    // 视频消息媒体id
    private String MediaId;
    // 视频消息缩略图的媒体id
    private String ThumbMediaId;

    public String getMediaId() {
        return MediaId;
    }

    public void setMediaId(String mediaId) {
        MediaId = mediaId;
    }

    public String getThumbMediaId() {
        return ThumbMediaId;
    }

    public void setThumbMediaId(String thumbMediaId) {
        ThumbMediaId = thumbMediaId;
    }
}
