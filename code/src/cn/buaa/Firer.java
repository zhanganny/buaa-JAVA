package cn.buaa;

import java.awt.image.BufferedImage;

public class Firer implements Runnable{
    //用于表示横纵坐标
    private int x;
    private int y;
    //用于表示当前的状态
    private String status;

    //用于显示当前状态对应的图像
    private BufferedImage show = null;


    //定义一个BackGround对象，用来获取障碍物的信息
    private BackGround backGround = new BackGround();
    //用于实现火人的动作
    private Thread thread = null;
    //火人的移动速度
    private int xSpeed;
    //火人的跳跃速度
    private int ySpeed;
    //定义一个索引，用于获得运动图像
    private int index;
    //表示上升时间
    private int upTime =0 ;
    private int now_brick_y=0;
    private int numOfRedDiamond=0;

    //火人死亡
    private boolean isDeath = false;
    private boolean isOnLifter = false;
    private boolean isGetGround = false;

    private boolean isWithBox = false;
    public Firer () {

    }
    public Firer (int x, int y) {
        this.x = x;
        this.y = y;
        show = StaticValue.firer_stand;
        this.status = "stop";
        thread = new Thread(this);
        thread.start();
    }



    //火人向左移动
    public void leftMove() {
        //改变速度
        xSpeed = -13;
        //判断是否在空中
        if (status.indexOf("jump") != -1) {
            if (ySpeed < 0) {
                status = "jump--up--left";
            }else {
                status = "jump--down--left";
            }
        }else {
            status = "move--left";
        }
    }
    //火人向右移动
    public void rightMove() {
        //改变速度
        xSpeed = 13;
        //判断是否在空中
        if (status.indexOf("jump") != -1) {
            if (ySpeed < 0) {
                status = "jump--up--right";
            }else {
                status = "jump--down--right";
            }
        }else {
            status = "move--right";
        }
    }
    //火人向左停止
    public void leftStop() {
        xSpeed = 0;
        if (status.indexOf("jump") != -1) {
            status = "jump--down--left";
        }else {
            status = "stop";
        }
    }
    //火人向右停止
    public void rightStop() {
        xSpeed = 0;
        if (status.indexOf("jump") != -1) {
            status = "jump--down--right";
        } else {
            status = "stop";
        }
    }

    //上升
    public void jump() {
        if (status.indexOf("jump") == -1) {
            if (status.indexOf("left") != -1) {
                status = "jump--left--up";
            }else {
                status = "jump--right--up";
            }
            ySpeed = - 10;
            upTime = 7;
        }
    }

    //下落
    public void fall () {
        if (status.indexOf("left") != -1) {
            status = "jump--left--down";
        } else {
            status = "jump--right--down";
        }
        ySpeed = 10;
    }

    //死亡
    public void death() {
        isDeath = true;
    }

    public void getGround() {
        isGetGround=true;
    }
    public void getOffGround() {
        isGetGround=false;
    }
    public void onLifter() {
        isOnLifter = true;
        ySpeed = -1;
    }
    public void offLifter() {
        isOnLifter = false;
    }

    public void withBox() {
        isWithBox = true;
    }

    public void offBox() {
        isWithBox = false;
    }




    @Override
    public void run() {
        while (true) {
//            System.out.println("火人什么鬼"+this.y);
            //判断是否处于障碍物上
            boolean onBrick = true;
            if (xSpeed < 0 || xSpeed > 0) {
                x += xSpeed;
                //判断是否到最左边
                if (x < 0) {
                    x = 0;
                }
                if (x > 800) {
                    x = 800;
                }
            }


            //判断是否在砖上
            if(!isGetGround) {
                this.now_brick_y=520;
                for (int i = 0; i < backGround.getBrickList().size(); i++) {
                    Prop pr = backGround.getBrickList().get(i);
//                System.out.println("aa_"+pr.getY());
//                System.out.println("火人"+this.y);
//                    System.out.println("判断火人是否位于砖块上");
//                    System.out.println(this.now_brick_y);
                    //判断火人是否位于砖块上
                    if ((pr.getY() == this.y + 80 && (pr.getX() >= this.x  && pr.getX() <= this.x + 40))) {
                        onBrick = true;
                        this.now_brick_y = pr.getY();
                        isOnLifter=false;
 //                       System.out.println("找到了"+now_brick_y);
                        break;
                    }
//                System.out.println("还在找");
                }
            }


//            System.out.println(now_brick_y+"啊啊啊啊");
            //判断是否在冰河或泥沼中
            boolean isIceRiver = false;
            boolean isMudRiver = false;
            for (int i = 0; i < backGround.getIce_river_List().size(); i++) {
                Prop pr = backGround.getIce_river_List().get(i);
                //判断火人是否位于冰河上
//                System.out.println("河"+pr.getX());
//                System.out.println("火人"+this.x);
                if (pr.getY() == this.y + 80 && (pr.getX() >= this.x -70 && pr.getX() <= this.x + 50)) {    //pr<=火人this.x<=pr+120  河240-350
                    isIceRiver = true;
                    break;
                }
            }
            for (int i = 0; i < backGround.getMud_river_List().size(); i++) {
                Prop pr = backGround.getMud_river_List().get(i);
                //判断火人是否位于泥河上
                if (pr.getY() == this.y + 80 && (pr.getX() >= this.x -70 && pr.getX() <= this.x + 50)) {
                    isMudRiver = true;
                    break;
                }
            }

            //火人死亡
            if(isIceRiver || isMudRiver) {
                death();
            }
            //火人捡到红钻
            for (int i = 0;i < backGround.getRedDiamondList().size();i++) {
                Prop pr = backGround.getRedDiamondList().get(i);
                //判断捡到钻石
                if ((pr.getY()-35 <= this.y && this.y <= pr.getY()) && (pr.getX() - 40 <= this.x && this.x <= pr.getX() + 35)) {
                        pr.redMissing();
                        numOfRedDiamond+=1;
                }
            }
            //火人到火门
            for (int i = 0; i < backGround.getFireGateList2().size(); i++) {
                Prop pr = backGround.getFireGateList2().get(i);
                if ((pr.getY()-35 <= this.y && this.y <= pr.getY()) && (pr.getX() - 40 <= this.x && this.x <= pr.getX() + 35)) {
                    pr.arriveRedGate();
                }
            }



            if(!isOnLifter) {
                //进行火人跳跃的操作
                if ((onBrick) && upTime == 0) {
                    //               System.out.println(isOnLifter);
                    if (status.indexOf("left") != -1) {
//                        System.out.println("这话】】】】】");
                        if (xSpeed != 0) {
                            status = "move--left";
                        } else {
                            status = "stop";
                        }
                    } else {
                        //                 System.out.println("///");
                        if (xSpeed != 0) {
                            status = "move--right";
                        } else {
                            status = "stop";
                        }
                    }
//                    System.out.println(this.now_brick_y+"这话");
                    if (this.y!=this.now_brick_y-80) {
                            //                  System.out.println("这话【【【【【");
//                    System.out.println("this.y" + this.y);
//                    System.out.println("now_brick_y"+now_brick_y);
                        fall();
//                        System.out.println(this.now_brick_y+"?");
                        y += ySpeed;
                    }
                } else {
                    if (upTime != 0) {
                        upTime--;
                    } else {
                        fall();
                    }
                    y += ySpeed;
                }
            }
            else {
                if (ySpeed<0 || ySpeed>0) {
                    if(y<=141) {
                        y=141;
                    }else {
                        y += ySpeed;
                    }
                    if(y>=260) {
                        y=260;
                    } else {
                        y += ySpeed;
                    }
                }
            }


            //判断是否是向左移动
            if ("move--left".equals(status)) {
                show = StaticValue.firer_run_L;
            }
            //判断是否向右移动
            if ("move--right".equals(status)) {
                show = StaticValue.firer_run_R;
            }
            //判断是否停止
            if ("stop".equals(status)) {
                show = StaticValue.firer_stand;
            }

            //判断是否向左上跳跃
            if("jump--left--up".equals(status)) {
                show = StaticValue.firer_jump_up_L;
            }
            //判断是否向左下跳跃
            if("jump--left".equals(status)) {
                show = StaticValue.firer_jump_down_L;
            }
            //判断是否向右上跳跃
            if("jump--right".equals(status)) {
                show = StaticValue.firer_jump_up_R;
            }
            //判断是否向右下跳跃
            if("jump--right".equals(status)) {
                show = StaticValue.firer_jump_down_R;
            }
            //判断是否向上跳跃
            if("jump--right".equals(status)) {
                show = StaticValue.firer_jump_up;
            }
            //判断是否向下跳跃
            if("jump--right".equals(status)) {
                show = StaticValue.firer_jump_down;
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

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public BufferedImage getShow() {
        return show;
    }

    public void setShow(BufferedImage show) {
        this.show = show;
    }

    public void setBackGround(BackGround backGround) {
        this.backGround = backGround;
    }

    public boolean isDeath() {
        return isDeath;
    }

    public void setNow_brick_y(int now_brick_y) {
        this.now_brick_y = now_brick_y;
    }

    public int getNumOfRedDiamond() {
        return numOfRedDiamond;
    }
}
