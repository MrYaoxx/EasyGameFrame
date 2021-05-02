package io.github.mryaoxx.EasyGameFrame.util;

import java.lang.reflect.Array;

/**
 * 数组工具类
 *
 * @author MrYaoxx
 */

public class ArrayUtil {
    public static Object[] objectToArray(Object object) {
        if (object != null) {
            if (object.getClass().isArray()) {
                int len = Array.getLength(object);
                Object[] obj = new Object[len];
                for (int i = 0; i < len; i++) {
                    obj[i] = Array.get(obj, i);
                }
                return obj;
            }
        }
        return null;
    }
}
