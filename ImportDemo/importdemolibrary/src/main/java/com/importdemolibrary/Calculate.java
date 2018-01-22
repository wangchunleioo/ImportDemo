package com.importdemolibrary;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by wang on 2018/1/20 0020.
 */

public class Calculate {
    /**
     * 加法
     *
     * @param value1 被加数
     * @param value2 加数
     * @return 两数之和
     */
    public static Double add(String value1, String value2) {
        BigDecimal b1 = new BigDecimal(value1);
        BigDecimal b2 = new BigDecimal(value2);
        return b1.add(b2).doubleValue();
    }

    /**
     * 减法
     *
     * @param value1 被减数
     * @param value2 减数
     * @return 两数之差
     */
    public static Double sub(String value1, String value2) {
        BigDecimal b1 = new BigDecimal(value1);
        BigDecimal b2 = new BigDecimal(value2);
        return b1.subtract(b2).doubleValue();
    }

    /**
     * 乘法
     *
     * @param value1 被乘数
     * @param value2 乘数
     * @param scale  精确小数点几位
     * @return 两数之积
     */
    public static Double mul(String value1, String value2, Integer scale) throws IllegalAccessException {
        if (scale < 0) {
            throw new IllegalAccessException("The scale must be a positive integer or zero");
        }
        BigDecimal b1 = new BigDecimal(value1);
        BigDecimal b2 = new BigDecimal(value2);
        return b1.multiply(b2).setScale(scale, RoundingMode.HALF_UP).doubleValue();
    }

    /**
     * 除法
     *
     * @param value1 被除数
     * @param value2 除数
     * @param scale  精确小数点几位
     * @return 两数之商
     * @throws IllegalAccessException
     */
    public static Double divide(String value1, String value2, Integer scale) throws IllegalAccessException {
        if (scale < 0) {
            throw new IllegalAccessException("The scale must be a positive integer or zero");
        }
        BigDecimal b1 = new BigDecimal(value1);
        BigDecimal b2 = new BigDecimal(value2);
        return b1.divide(b2, scale, RoundingMode.HALF_UP).doubleValue();
    }
}
