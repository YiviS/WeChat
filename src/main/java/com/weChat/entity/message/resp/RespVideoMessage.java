package com.weChat.entity.message.resp;

/**
 * @Author Xg
 * @Date 2016-09-13 15:21
 * @Desc 视频消息
 */
public class RespVideoMessage extends RespBaseMessage {
    // 视频
    private Video Video;

    public Video getVideo() {
        return Video;
    }

    public void setVideo(Video video) {
        Video = video;
    }
}
