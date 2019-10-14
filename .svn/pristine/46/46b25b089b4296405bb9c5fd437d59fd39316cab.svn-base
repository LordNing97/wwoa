package com.xy.wwoa.common.util;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * @Author leisurexi
 * @Description 生产验证码图片工具类
 * @Date 2019/9/11
 * @Time 9:17
 */
public class CodeImgUtil {

    public static final int width = 150, height = 48;
    private static final int fontsize = 36;
    private static final Font mFont = new Font("Kannada MN", Font.BOLD, fontsize);

    public static String createCodeImg(BufferedImage image) {
        Graphics g = image.getGraphics();
        Random random = new Random();
        g.setColor(getRandColor(200, 251));
        g.fillRect(1, 1, width - 1, height - 1);
        g.setColor(getRandColor(210, 251));
        g.drawRect(0, 0, width - 1, height - 1);
        g.setFont(mFont);

        g.setColor(getRandColor(160, 200));
        for (int i = 0; i < 155; i++) {
            int x = random.nextInt(width - 1);
            int y = random.nextInt(height - 1);
            int xl = random.nextInt(6) + 1;
            int yl = random.nextInt(12) + 1;
            g.drawLine(x, y, x + xl, y + yl);
        }
        for (int i = 0; i < 70; i++) {
            int x = random.nextInt(width - 1);
            int y = random.nextInt(height - 1);
            int xl = random.nextInt(12) + 1;
            int yl = random.nextInt(6) + 1;
            g.drawLine(x, y, x - xl, y - yl);
        }

        String code = "";
        for (int i = 0; i < 4; i++) {
            String tmp = getRandomChar();
            code += tmp;
            g.setColor(new Color(20 + random.nextInt(110), 20 + random.nextInt(110), 20 + random.nextInt(110)));
            g.drawString(tmp, 20 + (int) (fontsize * 0.8 * i + 4), fontsize);
        }
        g.dispose();
        return code;
    }

    private static Color getRandColor(int fc, int bc) {
        Random random = new Random();
        if (fc > 255) fc = 255;
        if (bc > 255) bc = 255;
        int r = fc + random.nextInt(bc - fc);
        int g = fc + random.nextInt(bc - fc);
        int b = fc + random.nextInt(bc - fc);
        return new Color(r, g, b);
    }

    private static String getRandomChar() {
        return String.valueOf(Math.round(Math.random() * 9));
    }

}
