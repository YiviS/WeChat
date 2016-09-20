package com.weChat.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Set;

/**
 * @Author Xg
 * @Date 2016-09-20 17:59
 * @Desc
 */
public class ReflectionUtil {
    private static final String PREFIX_SET = "set";

    /**
     * 用于对类的字段赋值,即把Map中的值赋值到T对象中
     *
     * @param <T>
     */
    public static <T> T convertMap2Obj(Class<T> clazz,Map<String, String> data) {
        T t = null;
        try {
            t = clazz.newInstance();
        } catch (Exception e1) {
            return null;
        }
        Method[] methods = clazz.getMethods();
        Set<String> keys = data.keySet();

        for (String dataName : keys) {
            for (Method method : methods) {
                if (method.getName().equals(PREFIX_SET + dataName)) {
                    Class<?> firstParamType = method.getParameterTypes()[0];
                    String value = data.get(dataName);
                    try {
                        /**
                         * 如果是基本数据类型时（如int、float、double、byte、char、boolean）
                         * 需要先将Object转换成相应的封装类之后再转换成对应的基本数据类型 否则会报
                         * ClassCastException
                         **/
                        if (firstParamType == String.class) {
                            method.invoke(t, value);
                        } else if (firstParamType == long.class) {
                            method.invoke(t, Long.valueOf(value));
                        } else if (firstParamType == int.class) {
                            method.invoke(t, Integer.valueOf(value));
                        } else if (firstParamType == float.class) {
                            method.invoke(t, Float.valueOf(value));
                        } else if (firstParamType == double.class) {
                            method.invoke(t, Double.valueOf(value));
                        } else if (firstParamType == byte.class) {
                            method.invoke(t, Byte.valueOf(value));
                        } else if (firstParamType == char.class) {
                            method.invoke(t, value.charAt(0));
                        } else if (firstParamType == boolean.class) {
                            method.invoke(t, Boolean.valueOf(value));
                        } else {
                            method.invoke(t, firstParamType.cast(value));
                        }
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        return t;

    }
}
