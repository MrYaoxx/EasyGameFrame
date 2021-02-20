package org.GameFrame.frame;

import java.awt.*;

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
     * 是否可见
     */
    public boolean visible;


    /**
     * 构造窗口信息
     *
     * @param title          标题
     * @param size      尺寸
     * @param point          坐标
     * @param closeOperation 窗口关闭时的操作
     * @param undecorated    是否隐藏边框
     * @param visible        窗口是否可见
     */
    public FrameInfo(String title, Dimension size, Point point, int closeOperation, boolean undecorated, boolean visible) {
        this.title = title;
        this.size = size;
        this.point = point;
        this.closeOperation = closeOperation;
        this.undecorated = undecorated;
        this.visible = visible;
    }
}
