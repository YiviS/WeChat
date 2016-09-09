package com.weChat.utils;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Author Xg
 * @Date 2016/9/9 13:55
 * @Desc HttpClient 工具类
 */
public class HttpClientUtils {
    private static Logger log = LoggerFactory.getLogger(HttpClientUtils.class);

    /**
     *  @描述 创建httpclient
     *  @param null
     *  @Author Xg
     *  @Date 2016/9/9 13:56
     */
    public static CloseableHttpClient getHttpClient(){
        //创建一个HttpClient
        RequestConfig requestConfig = RequestConfig.custom().setCookieSpec(CookieSpecs.STANDARD_STRICT).build();
        CloseableHttpClient httpClient = HttpClients.custom().setDefaultRequestConfig(requestConfig).build();
        return httpClient;
    }
    /**
     *  @描述 获取httpResponse
     *  @param url
     *  @Author Xg
     *  @Date 2016/9/8 13:13
     */
    public static CloseableHttpResponse getHttpResponse(String url) throws IOException {
        CloseableHttpClient httpClient = HttpClientUtils.getHttpClient();
        HttpGet get = new HttpGet(url);
        CloseableHttpResponse httpResponse = httpClient.execute(get);
        return httpResponse;
    }
    /**
     *  @描述 发送http post请求返回数据
     *  @param url,httpClient,httpentity
     *  @Author Xg
     *  @Date 2016/9/8 11:16
     */
    public static String executeHttpPost(String url, HttpEntity httpentity)throws IOException{
        CloseableHttpClient httpClient = HttpClientUtils.getHttpClient();
        HttpPost httpPost = new HttpPost(url);
        httpPost.setEntity(httpentity);
        String response = null;
        CloseableHttpResponse httpResponse = null;
        try {
            httpResponse = httpClient.execute(httpPost);
            HttpEntity entity = httpResponse.getEntity();
            response = EntityUtils.toString(entity,"UTF-8");
        }catch (Exception e){
            log.error("发起http post请求返回数据错误,我也不知道原因",e);
        }finally {
            httpResponse.close();
        }
        return  response;
    }
    /**
     *  @描述 发送http get请求返回数据
     *  @param url,httpClient
     *  @Author Xg
     *  @Date 2016/9/8 11:18
     */
    public static String executeHttpGet(String url) throws IOException {
        CloseableHttpClient httpClient = HttpClientUtils.getHttpClient();
        HttpGet httpGet = new HttpGet(url);
        String response = null;
        CloseableHttpResponse httpResponse = null;
        try {
            httpResponse  = httpClient.execute(httpGet);
            HttpEntity entity = httpResponse.getEntity();
            response = EntityUtils.toString(entity,"UTF-8");
        } catch (IOException e) {
            log.error("发起http get请求返回数据错误,我也不知道原因",e);
        }finally {
            httpResponse.close();
        }
        return response;
    }
    /**
     *  @描述 UrlEncodedFormEntity创建
     *  @param map（不能为空）
     *  @Author Xg
     *  @Date 2016/9/9 14:21
     */
    public UrlEncodedFormEntity getEntity(Map<String,String> map){

        UrlEncodedFormEntity entity = null;
        List<NameValuePair> valuePairs = new LinkedList<NameValuePair>();
        Set<Map.Entry<String, String>> entryseSet = map.entrySet();
        try {
            for (Map.Entry<String, String> entry:entryseSet) {
                valuePairs.add(new BasicNameValuePair(entry.getKey() ,entry.getKey()));
            }
            entity = new UrlEncodedFormEntity(valuePairs, Consts.UTF_8);
        }catch (Exception e){
            log.info("获取UrlEncodedFormEntity entity错误："+ ExceptionUtils.getErrorInfo(e));
        }
        return entity;
    }
}
