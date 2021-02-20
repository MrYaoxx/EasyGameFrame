package org.GameFrame.util;

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
     * 旋转图片
     *
     * @param bufferedImage 图片
     * @param angle         旋转角度
     * @return
     */
    public static BufferedImage rotateImage(BufferedImage bufferedImage, int angle) {
        if (bufferedImage == null) {
            return null;
        }
        if (angle < 0) {
            // 将负数角度，纠正为正数角度
            angle = angle + 360;
        }
        int imageWidth = bufferedImage.getWidth(null);
        int imageHeight = bufferedImage.getHeight(null);
        // 计算重新绘制图片的尺寸
        Rectangle rectangle = calculatorRotatedSize(new Rectangle(new Dimension(imageWidth, imageHeight)), angle);
        // 获取原始图片的透明度
        int type = bufferedImage.getColorModel().getTransparency();
        BufferedImage newImage = null;
        newImage = new BufferedImage(rectangle.width, rectangle.height, type);
        Graphics2D graphics = newImage.createGraphics();
        // 平移位置
        graphics.translate((rectangle.width - imageWidth) / 2, (rectangle.height - imageHeight) / 2);
        // 旋转角度
        graphics.rotate(Math.toRadians(angle), imageWidth / 2, imageHeight / 2);
        // 绘图
        graphics.drawImage(bufferedImage, null, null);
        return newImage;
    }

    /**
     * 旋转图片
     *
     * @param image 图片
     * @param angle 旋转角度
     * @return
     */
    public static BufferedImage rotateImage(Image image, int angle) {
        if (image == null) {
            return null;
        }
        if (angle < 0) {
            // 将负数角度，纠正为正数角度
            angle = angle + 360;
        }
        int imageWidth = image.getWidth(null);
        int imageHeight = image.getHeight(null);
        Rectangle rectangle = calculatorRotatedSize(new Rectangle(new Dimension(imageWidth, imageHeight)), angle);
        BufferedImage newImage = null;
        newImage = new BufferedImage(rectangle.width, rectangle.height, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = newImage.createGraphics();
        // transform
        graphics.translate((rectangle.width - imageWidth) / 2, (rectangle.height - imageHeight) / 2);
        graphics.rotate(Math.toRadians(angle), imageWidth / 2, imageHeight / 2);
        graphics.drawImage(image, null, null);
        return newImage;
    }

    /**
     * 计算旋转后的尺寸
     *
     * @param src   资源
     * @param angle 旋转角度
     * @return
     */
    private static Rectangle calculatorRotatedSize(Rectangle src, int angle) {
        if (angle >= 90) {
            if (angle / 90 % 2 == 1) {
                int temp = src.height;
                src.height = src.width;
                src.width = temp;
            }
            angle = angle % 90;
        }
        double r = Math.sqrt(src.height * src.height + src.width * src.width) / 2;
        double len = 2 * Math.sin(Math.toRadians(angle) / 2) * r;
        double angel_alpha = (Math.PI - Math.toRadians(angle)) / 2;
        double angel_dalta_width = Math.atan((double) src.height / src.width);
        double angel_dalta_height = Math.atan((double) src.width / src.height);

        int len_dalta_width = (int) (len * Math.cos(Math.PI - angel_alpha - angel_dalta_width));
        int len_dalta_height = (int) (len * Math.cos(Math.PI - angel_alpha - angel_dalta_height));
        int des_width = src.width + len_dalta_width * 2;
        int des_height = src.height + len_dalta_height * 2;
        return new java.awt.Rectangle(new Dimension(des_width, des_height));
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
