package org.GameFrame.util;

import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * 字体工具
 *
 * @author MrYaoxx
 */

public class FontUtil {
    /**
     * 读取自定义字体
     *
     * @param file 字体文件
     * @param size 字体大小
     * @return 字体
     */
    public static Font getFont(File file, int size) {
        Font font = null;
        try {
            font = Font.createFont(Font.TRUETYPE_FONT, file);
            font = font.deriveFont(Font.PLAIN, size);
        } catch (FontFormatException | IOException e) {
            return null;
        }
        return font;
    }



}
