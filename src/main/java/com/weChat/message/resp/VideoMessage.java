package com.weChat.message.resp;

/**
 * @Author Xg
 * @Date 2016-09-13 15:21
 * @Desc 视频消息
 */
public class VideoMessage extends BaseMessage {
    // 视频
    private Video Video;

    public Video getVideo() {
        return Video;
    }

    public void setVideo(Video video) {
        Video = video;
    }
}
