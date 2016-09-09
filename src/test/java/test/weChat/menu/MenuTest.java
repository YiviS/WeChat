package test.weChat.menu;

import com.weChat.pojo.Token;
import com.weChat.utils.CommonUtils;
import com.weChat.utils.MenuUtils;
import com.weChat.utils.Urls;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author Xg
 * @Date 2016-09-09 16:50
 * @Desc 菜单测试类
 */
public class MenuTest {

    private static Logger log = LoggerFactory.getLogger(MenuTest.class);
   /**
    * 创建菜单
    */
    @Test
    public void buidMenu(){
        // 调用接口获取凭证
        Token token = CommonUtils.getToken(Urls.appId, Urls.appSecret);
        if (null != token) {
            // 创建菜单
            boolean result = MenuUtils.createMenu(MenuList.getMenu(), token.getAccessToken());

            // 判断菜单创建结果
            if (result)
                log.info("菜单创建成功！");
            else
                log.info("菜单创建失败！");
        }
    }
    /**
     * 获取菜单
     */
    @Test
    public void getMenu(){
        Token token = CommonUtils.getToken(Urls.appId,Urls.appSecret);
        if(null != token){
            String menu = MenuUtils.getMenu(token.getAccessToken());
            log.info("菜单获取成功：");
            System.out.println(menu);
        }
    }
    /**
     * 删除菜单
     */
    @Test
    public void deleteMenu(){
        Token token = CommonUtils.getToken(Urls.appId,Urls.appSecret);
        if(null != token){
            boolean result = MenuUtils.deleteMenu(token.getAccessToken());
            if(result){
                log.info("删除菜单成功");
            }else{
                log.info("删除菜单失败");
            }
        }
    }
}
