package cn.buaa;

import javazoom.jl.decoder.JavaLayerException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class MyFrame extends JFrame implements KeyListener,Runnable, MouseListener {
    //用于存储所有的背景
    private List<BackGround> allBg = new ArrayList<>();
    //用于存储当前的场景
    private BackGround nowBg = new BackGround();
    //用于双缓存
    private Image offScreenImage = null;
    //升降台对象
    private Lifter lifter = new Lifter();
    //箱子对象
    private Box box = new Box();
    //火人对象
    private Firer firer = new Firer();
    //冰人对象
    private Icer icer = new Icer();
    //定义一个线程对象，用于实现运动
    private Thread thread = new Thread(this);
    //选择bg
    private int state=0;

    private boolean powerOn = true;

    private boolean attached_R = false;

    private boolean attached_L = false;

    //创建该类的空参构造
    public MyFrame() {
        //设置窗口的大小为800 * 600
        this.setSize(800, 600);
        //设置窗口居中显示
        this.setLocationRelativeTo(null);
        //设置点击窗口上的关闭键，结束程序
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //设置窗口大小不可变
        this.setResizable(false);
        //向窗口对象添加键盘监听器
        this.addKeyListener(this);
        //向窗口对象添加鼠标监听
        this.addMouseListener(this);
        //设置窗口名称
        this.setTitle("The Forest Temple by Ailing Zhang");
        //初始化图片
        StaticValue.init();
        //创建火人对象
        firer = new Firer(30,440);
        //创建冰人对象
        icer = new Icer(40, 440);
        //创建升降台
        lifter = new Lifter(20, 340);
        //创建箱子对象
        box = new Box(420, 140);
   //     box = new Box(680, 135);
        //创建全部的场景
        for (int i = 0; i <= 4; i++) {
            allBg.add(new BackGround(i));
        }
        //将第一个场景设置为当前场景
        nowBg = allBg.get(0);
        repaint();
        thread.start();
        //绘制图像
        //设置窗口的可见性
        this.setVisible(true);
        try {
            new Music();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (JavaLayerException e) {
            e.printStackTrace();
        }

//        else if (state == 1) {//单人模式，选择角色
//            //初始化火人
//            firer = new Firer(30,440);
//            firer.setBackGround(nowBg);
//            repaint();
//            //绘制图像
    }

    @Override
    public void paint(Graphics g) {
        if (offScreenImage == null) {
            offScreenImage = createImage(800, 600);
        }

        Graphics graphics = offScreenImage.getGraphics();

        graphics.fillRect(0,0,800,600);

        //绘制背景
        graphics.drawImage(nowBg.getBgImage(),0,0,this);


        if(state == 0) {
            graphics.setColor(Color.white);

            graphics.setFont(new Font("仿宋", Font.BOLD, 30));

            graphics.drawString("选择游戏模式", 290, 400);

            graphics.setColor(Color.yellow);

            graphics.drawString("单人暗黑模式", 300, 435);

            graphics.drawString("双人模式", 315, 470);
        }
        if(state==1 || state==2 || state==4) {
            for (Prop pr : nowBg.getBrickList()) {
                graphics.drawImage(pr.getShow(), pr.getX(), pr.getY(), this);
            }

            for (Prop pr : nowBg.getPropList()) {
                graphics.drawImage(pr.getShow(), pr.getX(), pr.getY(), this);
            }

            for (Prop pr : nowBg.getFireGateList1()) {
                graphics.drawImage(pr.getShow(), pr.getX(), pr.getY(), this);
            }

            for (Prop pr : nowBg.getFireGateList2()) {
                graphics.drawImage(pr.getShow(), pr.getX(), pr.getY(), this);
            }

            for (Prop pr : nowBg.getIceGateList1()) {
                graphics.drawImage(pr.getShow(), pr.getX(), pr.getY(), this);
            }

            for (Prop pr : nowBg.getIceGateList2()) {
                graphics.drawImage(pr.getShow(), pr.getX(), pr.getY(), this);
            }

            for (Prop pr : nowBg.getIce_river_List()) {
                graphics.drawImage(pr.getShow(), pr.getX(), pr.getY(), this);
            }

            for (Prop pr : nowBg.getMud_river_List()) {
                graphics.drawImage(pr.getShow(), pr.getX(), pr.getY(), this);
            }

            for (Prop pr : nowBg.getFire_river_List()) {
                graphics.drawImage(pr.getShow(), pr.getX(), pr.getY(), this);
            }

            for (Prop pr : nowBg.getBlueDiamondList()) {
                graphics.drawImage(pr.getShow(), pr.getX(), pr.getY(), this);
            }

            for (Prop pr : nowBg.getRedDiamondList()) {
                graphics.drawImage(pr.getShow(), pr.getX(), pr.getY(), this);
            }

            graphics.drawImage(firer.getShow(),firer.getX(),firer.getY(),this);
            if(state==2) {
                graphics.drawImage(lifter.getShow(), lifter.getX(), lifter.getY(), this);

                graphics.drawImage(box.getShow(),box.getX(),box.getY(),this);
            }
            if (state==2||state==4) {
                graphics.drawImage(icer.getShow(),icer.getX(),icer.getY(),this);
            }

            //添加蓝红钻得数
            Color c = graphics.getColor();

            graphics.setColor(Color.blue);

            graphics.setFont(new Font("黑体", Font.BOLD, 22));

            graphics.drawString("获得蓝钻数：" + icer.getNumOfBlueDiamond(),600,85);

            graphics.setColor(Color.red);

            graphics.setFont(new Font("黑体", Font.BOLD, 22));

            graphics.drawString("获得红钻数：" + firer.getNumOfRedDiamond(),600,55);

            graphics.setColor(c);
        }
            setVisible(true);

            g.drawImage(offScreenImage,0,0,this);

    }

    public static void main(String[] args) {
        System.out.println(System.getProperty("user.dir"));
        MyFrame myFrame = new MyFrame();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
  //      System.out.println(e.getKeyCode());
        //向左移动
        if (e.getKeyCode() == 37) {
            firer.leftMove();
        }

        //向右移动
        if (e.getKeyCode() == 39) {
            firer.rightMove();
        }

        //向上跳跃
        if (e.getKeyCode() == 38) {
            firer.jump();
        }

        //向左移动
        if (e.getKeyCode() == 65) {
            icer.leftMove();
        }

        //向右移动
        if (e.getKeyCode() == 68) {
            icer.rightMove();
        }

        //向上跳跃
        if (e.getKeyCode() == 87) {
            icer.jump();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //向左右停止
        if (e.getKeyCode() == 37) {
            firer.leftStop();
        }

        if (e.getKeyCode() == 39) {
            firer.rightStop();
        }

        //向左右停止
        if (e.getKeyCode() == 65) {
            icer.leftStop();
        }

        if (e.getKeyCode() == 68) {
            icer.rightStop();
        }
    }


    @Override
    public void mouseClicked(MouseEvent e) {
 //       System.out.println(e.getX());
  //      System.out.println(e.getY());
        if(e.getX()>=320 && e.getX()<=435 && e.getY()>=410 && e.getY()<=435){
            this.state=1;
        }

        if(e.getX()>=320 && e.getX()<=435 && e.getY()>=445 && e.getY()<=470){
            this.state=2;
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void run() {
        while (true) {
            repaint();
                try {
                    Thread.sleep(50);


                    if(state==1) {  //单人模式
                        nowBg = allBg.get(4);
                        firer.setBackGround(nowBg);
                    }

                    if(state==2) {
                        nowBg = allBg.get(1);
                        firer.setBackGround(nowBg);
                        icer.setBackGround(nowBg);
                    }

                    if (state==3) {
                        nowBg = allBg.get(2);
                    }

                    if (state==4) {
                        nowBg = allBg.get(3);
                        firer.setBackGround(nowBg);
                        icer.setBackGround(nowBg);
                    }


                    //判断火人死亡
                    if(firer.isDeath()) {
                        JOptionPane.showMessageDialog(this,"Game Over! The firer is killed");
                        System.exit(0);
                    }

                    //判断冰人死亡
                    if(icer.isDeath()) {
                        JOptionPane.showMessageDialog(this,"Game Over! The icer is killed");
                        System.exit(0);
                    }


                    //判断火人或冰人是否按下按钮
                    if((icer.getX()<220&&icer.getX()>190&&(icer.getY()==260||icer.getY()==140))||(firer.getX()<220&&firer.getX()>190&&(firer.getY()==260||firer.getY()==140))) {
                        lifter.upMove();
                        this.powerOn=true;
                    }
                    else {
                        lifter.downMove();
                        this.powerOn=false;
                    }


                    //判断火人是否上了升降台，若同时按钮按下，则升起升降台
                    if (firer.getY()==lifter.getY()-80 && (lifter.getX()-20 <= firer.getX() && lifter.getX()+130 >= firer.getX())) {
                        firer.getGround();
                        firer.setNow_brick_y(lifter.getY());
                        if(this.powerOn) {
                            firer.onLifter();
                        }
                    }
                    else {
                        firer.getOffGround();
                    }


                    //判断冰人是否上了升降台，若同时按钮按下，则升起升降台
                    if (icer.getY()==lifter.getY()-80 && (lifter.getX()-20 <= icer.getX() && lifter.getX()+130 >= icer.getX())) {
                        icer.getGround();
                        icer.setNow_brick_y(lifter.getY());
                        if(this.powerOn) {
                            icer.onLifter();
                        }
                    }
                    else {
                        icer.getOffGround();
                    }


                    //只有火人能推动箱子
                    if (attached_L) {
                        box.follow_L(firer.getX());
                    }

                    if (attached_R) {
                        box.follow_R(firer.getX());
                    }


                    if ((firer.getX()<=box.getX()+150&&firer.getX()>=box.getX()+130)&&firer.getY()==100) {
                        attached_R = true;
                    }
                    else {
                        attached_R = false;
                    }

                    if (firer.getX()<=box.getX()+10&&firer.getX()>=box.getX()&&firer.getY()==100) {
                        attached_L = true;
                    }
                    else {
                        attached_L = false;
                    }


                    //若是单人模式，判断火人是否到达火门，若到达则通关
                    //判断冰人火人是否都相应到达火门和冰门，若都到达则通关
                    if ((this.state==1&&firer.getY()==30&&firer.getX()<=90&&firer.getX()>=40)) {

                        this.state=3;

                        try {
                            Thread.sleep(150);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    if((this.state==2&&(firer.getY()==30&&firer.getX()<=90&&firer.getX()>=40)&&(icer.getY()==30&&icer.getX()<=160&&icer.getX()>=105))) {

                        this.state=4;

                        firer.setX(30);
                        firer.setY(440);
                        icer.setX(40);
                        icer.setY(440);

                        try {
                            Thread.sleep(150);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    if((this.state==4&&(firer.getY()==30&&firer.getX()<=90&&firer.getX()>=40)&&(icer.getY()==30&&icer.getX()<=160&&icer.getX()>=105))) {

                        this.state=3;

                        try {
                            Thread.sleep(150);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        }
    }
}
