package test.weChat.main;

import com.weChat.entity.pojo.Token;
import com.weChat.util.CommonUtil;
import com.weChat.util.Contents;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author Xg
 * @Date 2016/9/9 12:54
 * @Desc 基础测试类
 */
public class WeChatTest {

    private static Logger log = LoggerFactory.getLogger(WeChatTest.class);

    /**
     * 获取凭证Token
     */
    @Test
    public void getToken(){
        // 调用接口获取凭证
        Token token = CommonUtil.getToken(Contents.appId, Contents.appSecret);
        System.out.println("Token:"+token.getAccessToken());
        System.out.println("ExpiresIn"+token.getExpiresIn());
    }
    /**
     * 获取微信服务器IP
     */
    @Test
    public void getID(){
        // 调用接口获取凭证
        Token token = CommonUtil.getToken(Contents.appId, Contents.appSecret);
        String IP = CommonUtil.getIP(token.getAccessToken());
        System.out.println(IP);
    }
}
