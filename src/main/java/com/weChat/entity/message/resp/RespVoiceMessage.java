package com.weChat.entity.message.resp;

/**
 * @Author Xg
 * @Date 2016-09-13 15:22
 * @Desc 语音消息
 */
public class RespVoiceMessage extends RespBaseMessage {
    // 语音
    private Voice Voice;

    public Voice getVoice() {
        return Voice;
    }

    public void setVoice(Voice voice) {
        Voice = voice;
    }
}
