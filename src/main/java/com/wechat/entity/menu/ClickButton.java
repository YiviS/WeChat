package com.wechat.entity.menu;

/**
 * @Author Xg
 * @Date 2016-09-09 16:03
 * @Desc click类型的按钮
 */
public class ClickButton extends Button{
    private String type;
    private String key;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
