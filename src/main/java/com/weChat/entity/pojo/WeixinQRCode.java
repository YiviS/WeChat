package com.weChat.entity.pojo;

/**
 * @Author Xg
 * @Date 2016-09-18 16:17
 * @Desc 临时二维码信息
 */
public class WeixinQRCode {
    // 获取的二维码ticket
    private String ticket;
    // 二维码的有效时间，单位为秒，最大不超过1800
    private int expireSeconds;

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public int getExpireSeconds() {
        return expireSeconds;
    }

    public void setExpireSeconds(int expireSeconds) {
        this.expireSeconds = expireSeconds;
    }
}
