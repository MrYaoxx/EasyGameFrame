package io.github.mryaoxx.EasyGameFrame.util;

/**
 * 文件处理类
 *
 * @author MrYaoxx
 */

public class FileUtil {
    /**
     * 传入路径，返回是否是绝对路径
     * <br>
     * 绝对路径:
     *   <i>包含':'</i>
     *
     * @param path 路径
     * @return 绝对路径: true <br>相对路径: false
     */
    public static boolean isAbsolutePath(String path) {
        return path.indexOf(":") > 0;
    }
}
