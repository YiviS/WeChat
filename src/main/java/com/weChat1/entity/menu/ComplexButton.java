package com.weChat1.entity.menu;

/**
 * @Author Xg
 * @Date 2016-09-09 16:04
 * @Desc 复合类型的按钮
 */
public class ComplexButton extends Button{
    private Button[] sub_button;

    public Button[] getSub_button() {
        return sub_button;
    }

    public void setSub_button(Button[] sub_button) {
        this.sub_button = sub_button;
    }
}
