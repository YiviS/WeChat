package com.weChat.message.resp;

/**
 * @Author Xg
 * @Date 2016-09-13 15:22
 * @Desc 语音消息
 */
public class VoiceMessage extends BaseMessage {
    // 语音
    private Voice Voice;

    public Voice getVoice() {
        return Voice;
    }

    public void setVoice(Voice voice) {
        Voice = voice;
    }
}
