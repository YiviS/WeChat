package com.weChat.message.resp;

/**
 * @Author Xg
 * @Date 2016-09-13 15:19
 * @Desc 音乐消息
 */
public class MusicMessage extends BaseMessage{
    // 音乐
    private Music Music;

    public Music getMusic() {
        return Music;
    }

    public void setMusic(Music music) {
        Music = music;
    }
}
