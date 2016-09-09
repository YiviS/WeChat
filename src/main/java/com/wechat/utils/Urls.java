package com.wechat.utils;

/**
 * @Author Xg
 * @Date 2016/9/9 14:42
 * @Desc url地址
 */
public class Urls {

    // 第三方用户唯一凭证
    public static String appId = "wx732c17bc12a1ae13";
    // 第三方用户唯一凭证密钥
    public static String appSecret = "7c8136ac5731f949ef2dc8d77fed414f";
    // 凭证获取（GET）
    public static String token_url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
    //http请求方式: GET
    public static String ip_url = " https://api.weixin.qq.com/cgi-bin/getcallbackip?access_token=ACCESS_TOKEN ";
    // 菜单创建（POST）
    public final static String menu_create_url = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";
    // 菜单查询（GET）
    public final static String menu_get_url = "https://api.weixin.qq.com/cgi-bin/menu/get?access_token=ACCESS_TOKEN";
    // 菜单删除（GET）
    public final static String menu_delete_url = "https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=ACCESS_TOKEN";
}
