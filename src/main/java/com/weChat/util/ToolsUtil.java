package com.weChat.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * @Author Xg
 * @Date 2016-09-22 11:59
 * @Desc 网页接口工具
 */
public class ToolsUtil {

    private static Logger log = LoggerFactory.getLogger(ToolsUtil.class);

    /**
     *   图灵机器人
     *
     * @param info 请求信息
     * @Author Xg
     * @Date 2016/9/22 14:30
     */
    public static String tulingRobot(String info){
        String result = "";
        try {
            String url = Urls.tuling_url.replace("APIKEY",Urls.APIkey).replace("INFO", URLEncoder.encode(info, "utf-8"));
            result = CommonUtil.httpRequest(url,"POST",null).get("text").toString();
        }catch (UnsupportedEncodingException e){
            log.info("机器人出现故障："+ExceptionUtil.getErrorInfo(e));
        }catch (Exception e){
            log.info("机器人出现故障："+ExceptionUtil.getErrorInfo(e));
        }
        return result;
    }

}
