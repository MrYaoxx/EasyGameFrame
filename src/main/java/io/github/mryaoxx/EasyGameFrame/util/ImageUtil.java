package io.github.mryaoxx.EasyGameFrame.util;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * 图像工具类
 *
 * @author MrYaoxx
 */

public class ImageUtil {
    /**
     * 根据文件读取图片
     *
     * @param file 文件
     * @return 图片
     */
    public static BufferedImage getImage(File file) {
        try {
            return ImageIO.read(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 根据文件读取图片
     *
     * @param path 图片路径
     * @return 图片
     */
    public static BufferedImage getImage(String path) {
        try {
            return ImageIO.read(ImageIO.class.getResource(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 重置图像尺寸
     *
     * @param image 目标图像
     * @param w     宽
     * @param h     高
     * @return
     */
    public static BufferedImage resizeImage(final BufferedImage image,
                                            final int w, final int h) {
        int type = image.getColorModel().getTransparency();
        BufferedImage img;
        Graphics2D graphics2d;
        (graphics2d = (img = new BufferedImage(w, h, type)).createGraphics())
                .setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                        RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        graphics2d.drawImage(image, 0, 0, w, h, 0, 0,
                image.getWidth(), image.getHeight(), null);
        graphics2d.dispose();
        return img;
    }


    /**
     * 图像水平翻转
     *
     * @param image 原图像
     * @return 返回水平翻转后的图像
     */
    public static BufferedImage flipHorizontalImage(BufferedImage image) {
        int width = image.getWidth();
        int height = image.getHeight();

        BufferedImage dstImage = new BufferedImage(width, height, image.getType());

        AffineTransform affineTransform = new AffineTransform(-1, 0, 0, 1, width, 0);
        AffineTransformOp affineTransformOp = new AffineTransformOp(affineTransform, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);

        return affineTransformOp.filter(image, dstImage);
    }


    /**
     * 图像竖直翻转
     *
     * @param image 原图像
     * @return 返回竖直翻转后的图像
     */
    public static BufferedImage flipVerticalImage(BufferedImage image) {
        int width = image.getWidth();
        int height = image.getHeight();

        BufferedImage dstImage = new BufferedImage(width, height, image.getType());

        AffineTransform affineTransform = new AffineTransform(1, 0, 0, -1, 0, height);
        AffineTransformOp affineTransformOp = new AffineTransformOp(affineTransform, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);

        return affineTransformOp.filter(image, dstImage);
    }
}
