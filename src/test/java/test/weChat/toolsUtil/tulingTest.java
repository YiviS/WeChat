package test.weChat.toolsUtil;

import com.weChat.util.CommonUtil;
import com.weChat.util.Urls;
import net.sf.json.JSONObject;
import org.junit.Test;

/**
 * @Author Xg
 * @Date 2016-09-22 12:45
 * @Desc 图灵接口测试
 */
public class tulingTest {
    @Test
    public void tulingTest(){
        String url = Urls.tuling_url.replace("APIKEY",Urls.APIkey).replace("INFO","测试");
        JSONObject jsonObject = CommonUtil.httpRequest(url,"POST",null);
        String result = jsonObject.toString();
        System.out.println(jsonObject.get("text").toString());
    }
}
