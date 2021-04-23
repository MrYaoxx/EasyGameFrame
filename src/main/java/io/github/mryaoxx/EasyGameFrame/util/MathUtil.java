package io.github.mryaoxx.EasyGameFrame.util;

import java.awt.*;

/**
 * 数学工具类
 *
 * @author MrYaoxx
 */
public class MathUtil {
    /**
     * 生成[a,b)区间内的随机数
     *
     * @param a a
     * @param b b
     * @return [a, b)区间内的随机数
     */
    public static int randomBetween(int a, int b) {
        if (a > b) {
            int t = a;
            a = b;
            b = t;
        }
        return (int) (Math.random() * (b - a) + a);
    }
}
