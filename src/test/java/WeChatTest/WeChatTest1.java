package WeChatTest;

import com.wechat.pojo.Token;
import com.wechat.utils.CommonUtils;
import com.wechat.utils.Urls;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author Xg
 * @Date 2016/9/9 12:54
 * @Desc
 */
public class WeChatTest1 {

    private static Logger log = LoggerFactory.getLogger(WeChatTest1.class);

    /**
     * 获取凭证Token
     */
    @Test
    public void getToken(){
        // 调用接口获取凭证
        Token token = CommonUtils.getToken(Urls.appId, Urls.appSecret);
        //Token token = CommonUtils.getTokenByHttpClient(appId, appSecret);
        System.out.println("Token:"+token.getAccessToken());
        System.out.println("ExpiresIn"+token.getExpiresIn());
    }
    /**
     * 获取微信服务器IP
     */
    @Test
    public void getID(){
        // 调用接口获取凭证
        Token token = CommonUtils.getToken(Urls.appId, Urls.appSecret);
        String IP = CommonUtils.getIP(token.getAccessToken());
        System.out.println(IP);
    }
}
