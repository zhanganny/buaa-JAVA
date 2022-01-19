package cn.buaa;

import java.awt.image.BufferedImage;

public class Lifter implements Runnable{
    //用于表示横纵坐标
    private int x;
    private int y;
    //定义一个BackGround对象，用来获取障碍物的信息
    private BackGround backGround = new BackGround();
    //用于实现升降台升降
    private Thread thread = null;
    //表示上升时间
    private int upTime =0 ;
    private int ySpeed = 0;

    //用于显示升降台图像
    private BufferedImage show = null;



    public Lifter () {

    }

    public Lifter(int x, int y) {
        this.x = x;
        this.y = y;
        show = StaticValue.updown;
        thread = new Thread(this);
        thread.start();
    }

    public void upMove() {
        if (y!=221) {
            ySpeed = -1;
        }
    }

    public void downMove() {
        if(y!=340) {
            ySpeed = 1;
        }
    }




    @Override
    public void run() {
        while(true) {
            if(ySpeed<0 || ySpeed>0) {
                if(y<=221) {
                    y=221;
                }else {
                    y += ySpeed;
                }
                if(y>=340) {
                    y=340;
                } else {
                    y += ySpeed;
                }
            }
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public BufferedImage getShow() {
        return show;
    }
}
