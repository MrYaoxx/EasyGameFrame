package org.GameFrame.frame;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * 窗口信息类
 *
 * @author MrYaoxx
 */

public class FrameInfo {
    /**
     * 标题
     */
    public String title;

    /**
     * 图标
     */
    public BufferedImage icon;

    /**
     * 尺寸
     */
    public Dimension size;

    /**
     * 坐标
     * <br>
     * 值为 {@code null} 时窗口居中
     */
    public Point point;

    /**
     * 窗口关闭时的操作
     */
    public int closeOperation;

    /**
     * 是否隐藏边框
     */
    public boolean undecorated;


    /**
     * 构造窗口信息
     *
     * @param title          标题
     * @param icon           图标 <i>值为 {@code null} 时显示原始图标</i>
     * @param size           尺寸
     * @param point          坐标
     * @param closeOperation 窗口关闭时的操作
     * @param undecorated    是否隐藏边框
     */
    public FrameInfo(String title, BufferedImage icon, Dimension size, Point point, int closeOperation, boolean undecorated) {
        this.title = title;
        this.icon = icon;
        this.size = size;
        this.point = point;
        this.closeOperation = closeOperation;
        this.undecorated = undecorated;
    }
}
