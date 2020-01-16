package com.yangzg.java.group.client;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.util.Properties;

/**
 * Created by Sam on 2020/1/16.
 */
public class KaptchaTest {
    @Test
    public void test1() throws Exception {
        final DefaultKaptcha kaptcha = new DefaultKaptcha();
        kaptcha.setConfig(new Config(new Properties(){
            private static final long serialVersionUID = 1L;
            {
                put("kaptcha.border", "no");
                put("kaptcha.textproducer.char.length", "4");
                put("kaptcha.textproducer.font.names", "楷体,宋体,微软雅黑");
            }
        }));
        final BufferedImage image = kaptcha.createImage("杨振国");
        ImageIO.write(image, "jpeg", new FileOutputStream("haha.jpg"));
    }
}
