package cn.buaa;

import java.awt.image.BufferedImage;

public class Box{
    //用于表示横纵坐标
    public int x;
    public int y;
    //定义一个BackGround对象，用来获取障碍物的信息
    private BackGround backGround = new BackGround();
    //用于实现箱子移动
    private Thread thread = null;
    //用于显示箱子图像
    private BufferedImage show = StaticValue.box;
    private boolean attached = false;

    public Box () {

    }


    public Box(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void follow_R(int followed_x) {
        this.x = followed_x - 50;
    }

    public void follow_L(int followed_x) {
        this.x = followed_x + 50;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public BufferedImage getShow() {
        return show;
    }


}
