package org.GameFrame.frame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * 游戏窗口类
 *
 * @author MrYaoxx
 */

public class GameFrame extends JFrame {
    public GameFrame(FrameInfo info) {
        // 设置窗口标题
        setTitle(info.title);

        // 设置窗口尺寸
        setSize(info.size);

        // 设置窗口坐标
        if (info.point == null) setLocationRelativeTo(null);
        else setLocation(info.point);

        // 设置窗口关闭时的操作
        setDefaultCloseOperation(info.closeOperation);

        // 设置是否显示边框
        setUndecorated(info.undecorated);

        // 设置是否可见
        setVisible(info.visible);
    }

    /**
     * 获取鼠标移动窗口的监听器
     *
     * @param p 区域左上角起点
     * @param d 区域尺寸
     * @return 监听器
     */
    public MouseAdapter getMouseDragWindowAdapter(Point p, Dimension d) {
        return new MouseAdapter() {
            Point origin;
            boolean canDrag = false;


            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);

                canDrag = isTouch(e.getPoint(), p, d);
                if (canDrag) origin = e.getPoint();
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                super.mouseDragged(e);

                if (canDrag) {
                    Point windowCurPoint = getLocation();
                    setLocation(windowCurPoint.x + e.getX() - origin.x, windowCurPoint.y + e.getY() - origin.y);
                }
            }


            /**
             * 判断鼠标是否进入某范围
             *
             * @param m 鼠标坐标
             * @param p 范围左上角坐标
             * @param d 范围尺寸
             * @return 是否进入范围
             */
            private boolean isTouch(Point m, Point p, Dimension d) {
                return m.x > p.x && m.x <= p.x + d.width
                        && m.y > p.y && m.y <= p.y + d.height;
            }
        };
    }

    /**
     * 添加鼠标在某区域内拖动窗口
     *
     * @param adapter 监听器
     */
    public void addMouseDragWindowAdapter(MouseAdapter adapter) {
        addMouseListener(adapter);
        addMouseMotionListener(adapter);
    }

    /**
     * 删除鼠标在某区域内拖动窗口
     *
     * @param adapter 监听器
     */
    public void removeMouseDragWindowAdapter(MouseAdapter adapter) {
        removeMouseListener(adapter);
        removeMouseMotionListener(adapter);
    }


    /**
     * 以百分比获取坐标
     *
     * @param XPercent X百分比
     * @param YPercent Y百分比
     * @return 坐标
     */
    public Point getPointByPercent(int XPercent, int YPercent) {
        return new Point((int) (XPercent / 100.0 * getWidth()), (int) (YPercent / 100.0 * getHeight()));
    }

    /**
     * 以百分比获取尺寸
     *
     * @param XPercent X百分比
     * @param YPercent Y百分比
     * @return 尺寸
     */
    public Dimension getDimensionByPercent(int XPercent, int YPercent) {
        return new Dimension((int) (XPercent / 100.0 * getWidth()), (int) (YPercent / 100.0 * getHeight()));
    }
}
