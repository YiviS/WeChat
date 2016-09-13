package com.weChat.message.resp;

/**
 * @Author Xg
 * @Date 2016-09-13 15:16
 * @Desc 媒体消息
 */
public class ImageMessage extends BaseMessage{
    // 媒体
    private Image Image;

    public Image getImage() {
        return Image;
    }

    public void setImage(Image image) {
        Image = image;
    }
}
