import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main{
    public static void main(String[] args) {
        JFrame jFrame = getFrame();
        jFrame.add(new MyComponent());
    }

    static class MyComponent extends JComponent {
        private int xmerc = 220;
        private int ymerc = 296;
        private double tmerc = 0;
        private int xven = 200;
        private int yven = 294;
        private double tven = 0;
        private int xearth = 180;
        private int yearth = 294;
        private double tearth = 0;
        private int xmars = 165;
        private int ymars = 296;
        private double tmars = 0;
        private int xjup = 120;
        private int yjup = 278;
        private double tjup = 0;
        private int xsat = 60;
        private int ysat = 288;
        private double tsat = 0;
        private int xuran = 36;
        private int yuran = 290;
        private double turan = 0;
        private int xnep = 9;
        private int ynep = 292;
        private double tnep = 0;
        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;
            Timer timer = new Timer(400, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    repaint();
                }
            });
            try {
                BufferedImage sun = ImageIO.read(new File("Солнце.png"));
                BufferedImage merc = ImageIO.read(new File("Меркурий.png"));
                BufferedImage ven = ImageIO.read(new File("Венера.png"));
                BufferedImage earth = ImageIO.read(new File("Земля.png"));
                BufferedImage mars = ImageIO.read(new File("Марс.png"));
                BufferedImage jup = ImageIO.read(new File("Юпитер.png"));
                BufferedImage sat = ImageIO.read(new File("Сатурн.png"));
                BufferedImage uran = ImageIO.read(new File("Уран.png"));
                BufferedImage nep = ImageIO.read(new File("Нептун.png"));
                g2.drawImage(sun, 336, 336, this);
                g2.drawImage(merc, xmerc, ymerc, this);
                g2.drawImage(ven, xven, yven, this);
                g2.drawImage(earth, xearth, yearth, this);
                g2.drawImage(mars, xmars, ymars, this);
                g2.drawImage(jup, xjup, yjup, this);
                g2.drawImage(sat, xsat, ysat, this);
                g2.drawImage(uran, xuran, yuran, this);
                g2.drawImage(nep, xnep, ynep, this);
                timer.start();
                xmerc = 390 + (int) (70 * Math.cos(tmerc));
                ymerc = 391 + (int) (70 * Math.sin(tmerc));
                tmerc += 0.01;
                xven = 390 + (int) (90 * Math.cos(tven));
                yven = 389 + (int) (90 * Math.sin(tven));
                tven += 0.0074;
                xearth = 390 + (int) (112 * Math.cos(tearth));
                yearth = 389 + (int) (112 * Math.sin(tearth));
                tearth += 0.0063;
                xmars = 390 + (int) (132 * Math.cos(tmars));
                ymars = 391 + (int) (132 * Math.sin(tmars));
                tmars += 0.0051;
                xjup = 390 + (int) (179 * Math.cos(tjup));
                yjup = 373 + (int) (179 * Math.sin(tjup));
                tjup += 0.0028;
                xsat = 390 + (int) (219 * Math.cos(tsat));
                ysat = 383 + (int) (219 * Math.sin(tsat));
                tsat += 0.00205;
                xuran = 390 + (int) (284 * Math.cos(turan));
                yuran = 385 + (int) (284 * Math.sin(turan));
                turan += 0.0014;
                xnep = 390 + (int) (314 * Math.cos(tnep));
                ynep = 387 + (int) (314 * Math.sin(tnep));
                tnep += 0.00115;
            } catch (IOException ex){
                ex.printStackTrace();
            }
        }
    }
    static JFrame getFrame(){
        JFrame jFrame = new JFrame();
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        jFrame.setBounds(dimension.width / 2 - 400, dimension.height / 2 - 400, 800, 800);
        jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);
        jFrame.setTitle("Солнечная система");
        jFrame.getContentPane().setBackground(Color.BLACK);
        try {
            BufferedImage icon = ImageIO.read(new File("Солнце.png"));
            jFrame.setIconImage(icon);
        } catch (IOException ex){
            ex.printStackTrace();
        }
        jFrame.setVisible(true);
        return jFrame;
    }
}