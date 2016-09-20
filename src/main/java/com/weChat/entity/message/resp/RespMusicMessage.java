package com.weChat.entity.message.resp;

/**
 * @Author Xg
 * @Date 2016-09-13 15:19
 * @Desc 音乐消息
 */
public class RespMusicMessage extends RespBaseMessage {
    // 音乐
    private Music Music;

    public Music getMusic() {
        return Music;
    }

    public void setMusic(Music music) {
        Music = music;
    }
}
