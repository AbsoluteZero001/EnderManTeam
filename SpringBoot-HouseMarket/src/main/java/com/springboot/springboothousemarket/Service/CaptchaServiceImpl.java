package com.springboot.springboothousemarket.Service.impl;

import com.springboot.springboothousemarket.Service.CaptchaService;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

@Service
public class CaptchaServiceImpl implements CaptchaService {

    @Override
    public BufferedImage createCaptcha() {
        int width = 100;
        int height = 40;
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(0, 0, width, height);

        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD, 24));
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuilder captchaText = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            char c = chars.charAt(random.nextInt(chars.length()));
            captchaText.append(c);
            g.drawString(String.valueOf(c), 15 * i + 10, 30);
        }
        g.dispose();
        return image;
    }
}
