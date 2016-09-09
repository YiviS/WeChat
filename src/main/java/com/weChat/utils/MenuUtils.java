package com.weChat.utils;

import com.weChat.entity.menu.Menu;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author Xg
 * @Date 2016/9/9 15:45
 * @Desc
 */
public class MenuUtils {

    private static Logger log = LoggerFactory.getLogger(MenuUtils.class);
    
    /**
     *  创建菜单
     *
     * @param menu 菜单实例
     * @param accessToken 凭证
     * @return true成功 false失败
     * @Author Xg
     * @Date 2016/9/9 15:54
     */
    public static boolean createMenu(Menu menu, String accessToken) {
        boolean result = false;
        String url = Urls.menu_create_url.replace("ACCESS_TOKEN", accessToken);
        // 将菜单对象转换成json字符串
        String jsonMenu = JSONObject.fromObject(menu).toString();
        // 发起POST请求创建菜单
        JSONObject jsonObject = CommonUtils.httpsRequest(url, "POST", jsonMenu);

        if (null != jsonObject) {
            int errorCode = jsonObject.getInt("errcode");
            String errorMsg = jsonObject.getString("errmsg");
            if (0 == errorCode) {
                result = true;
            } else {
                result = false;
                log.error("创建菜单失败 errcode:{} errmsg:{}", errorCode, errorMsg);
            }
        }
        return result;
    }
}
