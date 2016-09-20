package com.weChat.util;

import com.weChat.entity.WeChat;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 * @Author Xg
 * @Date 2016-09-13 16:02
 * @Desc 请求校验工具类
 */
public class SignUtil {
    /**
     *  校验签名
     *
     * @param signature 微信加密签名
     * @param timestamp 时间戳
     * @param nonce 随机数
     * @Author Xg
     * @Date 2016/9/13 16:03
     */
    public static boolean checkSignature(String signature, String timestamp, String nonce) {
        // 对token、timestamp和nonce按字典排序
        String[] paramArr = new String[] { Contents.token, timestamp, nonce };
        Arrays.sort(paramArr);

        // 将排序后的结果拼接成一个字符串
        String content = paramArr[0].concat(paramArr[1]).concat(paramArr[2]);

        String ciphertext = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            // 对接后的字符串进行sha1加密
            byte[] digest = md.digest(content.toString().getBytes());
            ciphertext = byteToStr(digest);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        // 将sha1加密后的字符串与signature进行对比
        return ciphertext != null ? ciphertext.equals(signature.toUpperCase()) : false;
    }
    /**
     *  校验签名
     *
     * @param WeChat 微信验证实体类
     * @Author Xg
     * @Date 2016/9/13 16:03
     */
    public static boolean checkSignature(WeChat weChat, String token) {

        String[] arr = new String[] { token, weChat.getTimestamp(), weChat.getNonce() };
        // 将token、timestamp、nonce三个参数进行字典序排序
        Arrays.sort(arr);
        StringBuilder content = new StringBuilder();
        for (String param : arr) {
            content.append(param);
        }
        MessageDigest md = null;
        String tmpStr = null;

        try {
            md = MessageDigest.getInstance("SHA-1");
            // 将三个参数字符串拼接成一个字符串进行sha1加密
            byte[] digest = md.digest(content.toString().getBytes());
            tmpStr = byteToStr(digest);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        content = null;
        // 将sha1加密后的字符串可与signature对比，标识该请求来源于微信
        return tmpStr != null ? tmpStr.equals(weChat.getSignature().toUpperCase()) : false;

    }
    /**
     *  将字节数组转换为十六进制字符串
     *
     * @param byteArray
     * @Author Xg
     * @Date 2016/9/13 16:04
     */
    private static String byteToStr(byte[] byteArray) {
        String strDigest = "";
        for (int i = 0; i < byteArray.length; i++) {
            strDigest += byteToHexStr(byteArray[i]);
        }
        return strDigest;
    }
    /**
     *  将字节转换为十六进制字符串
     *
     * @param mByte
     * @Author Xg
     * @Date 2016/9/13 16:04
     */
    private static String byteToHexStr(byte mByte) {
        char[] Digit = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
        char[] tempArr = new char[2];
        tempArr[0] = Digit[(mByte >>> 4) & 0X0F];
        tempArr[1] = Digit[mByte & 0X0F];

        String s = new String(tempArr);
        return s;
    }
}
