package org.GameFrame.util;

import java.awt.*;

/**
 * 画笔工具类
 *
 * @author MrYaoxx
 */

public class GraphicsUtil {
    /**
     * 设置画笔渲染
     *
     * @param g2 画笔
     */
    public static void setRendering(Graphics2D g2) {
        //消除文字锯齿
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        //消除画图锯齿
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    }
}
