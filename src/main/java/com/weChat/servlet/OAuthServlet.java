package com.weChat.servlet;

import com.weChat.pojo.SNSUserInfo;
import com.weChat.pojo.WeixinOauth2Token;
import com.weChat.utils.AdvancedUtils;
import com.weChat.utils.Urls;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author Xg
 * @Date 2016-09-18 16:23
 * @Desc 授权后的回调请求处理
 */
public class OAuthServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("gb2312");
        response.setCharacterEncoding("gb2312");

        // 用户同意授权后，能获取到code
        String code = request.getParameter("code");

        // 用户同意授权
        if (!"authdeny".equals(code)) {
            // 获取网页授权access_token
            WeixinOauth2Token weixinOauth2Token = AdvancedUtils.getOauth2AccessToken(Urls.appId, Urls.appSecret, code);
            // 网页授权接口访问凭证
            String accessToken = weixinOauth2Token.getAccessToken();
            // 用户标识
            String openId = weixinOauth2Token.getOpenId();
            // 获取用户信息
            SNSUserInfo snsUserInfo = AdvancedUtils.getSNSUserInfo(accessToken, openId);

            // 设置要传递的参数123123
            request.setAttribute("snsUserInfo", snsUserInfo);
        }
        // 跳转到index.jsp
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
