package com.weChat.util;

/**
 * @Author Xg
 * @Date 2016/9/9 14:42
 * @Desc url地址
 */
public class Urls {

    /*-------------------------------------        获取接口调用凭证        -------------------------------------*/
    // 凭证获取（GET）
    public static String token_url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
    // http请求方式（GET）
    public static String ip_url = " https://api.weixin.qq.com/cgi-bin/getcallbackip?access_token=ACCESS_TOKEN ";

    /*-------------------------------------        菜单管理        -------------------------------------*/
    // 菜单创建（POST）
    public final static String menu_create_url = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";
    // 菜单查询（GET）
    public final static String menu_get_url = "https://api.weixin.qq.com/cgi-bin/menu/get?access_token=ACCESS_TOKEN";
    // 菜单删除（GET）
    public final static String menu_delete_url = "https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=ACCESS_TOKEN";

    /*-------------------------------------        消息管理        -------------------------------------*/
    // 客服接口--发消息（POST）
    public final static String custom_send_url = "https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=ACCESS_TOKEN";

    /*-------------------------------------        微信网页开发        -------------------------------------*/
    // 通过code获取网页授权凭证（GET）
    public final static String token_bycode_url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code";
    // 刷新网页授权凭证（GET）
    public final static String refresh_token_url = "https://api.weixin.qq.com/sns/oauth2/refresh_token?appid=APPID&grant_type=refresh_token&refresh_token=REFRESH_TOKEN";
    // 通过网页授权获取用户信息（GET）
    public final static String sns_userinfo_url = "https://api.weixin.qq.com/sns/userinfo?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";

    /*-------------------------------------        用户管理        -------------------------------------*/
    // 获取用户基本信息（GET）
    public final static String user_info_url = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";
    // 获取用户列表（GET）
    public final static String user_list_url = "https://api.weixin.qq.com/cgi-bin/user/get?access_token=ACCESS_TOKEN&next_openid=NEXT_OPENID";
    // 获取用户分组（GET）
    public final static String groups_ger_url = "https://api.weixin.qq.com/cgi-bin/groups/get?access_token=ACCESS_TOKEN";
    // 创建用户分组（POST）
    public final static String groups_create_url = "https://api.weixin.qq.com/cgi-bin/groups/create?access_token=ACCESS_TOKEN";
    // 修改分组名（POST）
    public final static String groups_update_url = "https://api.weixin.qq.com/cgi-bin/groups/update?access_token=ACCESS_TOKEN";
    // 移动用户分组（POST）
    public final static String groups_members_update_url = "https://api.weixin.qq.com/cgi-bin/groups/members/update?access_token=ACCESS_TOKEN";

    /*-------------------------------------        账户管理        -------------------------------------*/
    // 创建二维码ticket（POST）
    public final static String qrcode_create_url = "https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=TOKEN";
    // ticket换取二维码（GET）
    public final static String showqrcode_url = "https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=TICKET";

    /*-------------------------------------        素材管理        -------------------------------------*/
    //新增临时素材（POST/FORM）
    public final static String media_upload_url = "https://api.weixin.qq.com/cgi-bin/media/upload?access_token=ACCESS_TOKEN&type=TYPE";
    //获取临时素材（GET）
    public final static String media_get_url = "https://api.weixin.qq.com/cgi-bin/media/get?access_token=ACCESS_TOKEN&media_id=MEDIA_ID";

}
