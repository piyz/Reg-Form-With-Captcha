package by.matrosov.capcthaservice;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

@WebServlet("/captcha-image")
public class CaptchaServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int iTotalChars = 6;
        int iHeight = 40;
        int iWidth = 150;

        Font fntStyle = new Font("Arial", Font.BOLD, 30);

        Random randChars = new Random();
        String sImageCode = (Long.toString(Math.abs(randChars.nextLong()), 36)).substring(0, iTotalChars);

        BufferedImage biImage = new BufferedImage(iWidth, iHeight, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2dImage = (Graphics2D) biImage.getGraphics();

        g2dImage.setFont(fntStyle);
        for (int i = 0; i < iTotalChars; i++) {
            g2dImage.setColor(new Color(randChars.nextInt(255), randChars.nextInt(255), randChars.nextInt(255)));
            if (i % 2 == 0){
                g2dImage.drawString(sImageCode.substring(i, i+1), 25 * i, 24);
            }else {
                g2dImage.drawString(sImageCode.substring(i, i+1), 25 * i, 35);
            }
        }

        ImageIO.setUseCache(false);

        resp.setContentType("image/jpg");

        OutputStream osImage = resp.getOutputStream();
        ImageIO.write(biImage, "jpeg", osImage);

        req.getSession().setAttribute("captcha_security", sImageCode);

        g2dImage.dispose();
    }
}
