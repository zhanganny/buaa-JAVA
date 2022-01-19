package cn.buaa;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StaticValue {
    //背景
    public static BufferedImage bg0 = null;

    public static BufferedImage bg1 = null;

    public static BufferedImage bg2 = null;

    //火娃站立
    public static BufferedImage firer_stand = null;

    //火娃向左跑
    public static BufferedImage firer_run_L = null;
    //火娃向右跑
    public static BufferedImage firer_run_R = null;

    //火娃向左上跳跃
    public static BufferedImage firer_jump_up_L = null;
    //火娃向左下跳跃
    public static BufferedImage firer_jump_down_L = null;
    //火娃向右上跳跃
    public static BufferedImage firer_jump_up_R = null;
    //火娃向右下跳跃
    public static BufferedImage firer_jump_down_R = null;

    //火娃向上
    public static BufferedImage firer_jump_up = null;
    //火娃向下
    public static BufferedImage firer_jump_down = null;

    //====================================================
    //冰娃站立
    public static BufferedImage icer_stand = null;

    //冰娃向左跑
    public static BufferedImage icer_run_L = null;
    //冰娃向右跑
    public static BufferedImage icer_run_R = null;

    //冰娃向左上跳跃
    public static BufferedImage icer_jump_up_L = null;
    //冰娃向左下跳跃
    public static BufferedImage icer_jump_down_L = null;
    //冰娃向右上跳跃
    public static BufferedImage icer_jump_up_R = null;
    //冰娃向右下跳跃
    public static BufferedImage icer_jump_down_R = null;

    //冰娃向上
    public static BufferedImage icer_jump_up = null;
    //冰娃向下
    public static BufferedImage icer_jump_down = null;


    //lifter
    public static BufferedImage updown = null;


    //box
    public static BufferedImage box = null;

    //===============================================================
    public static List<BufferedImage> prop = new ArrayList<>(); //道具
    //路径
    public static String path = System.getProperty("user.dir") + "/code/src/images/";

    //初始化方法
    public static void init() {
        try {
            //加载背景图片
            bg0 = ImageIO.read(new File(path + "background0.png"));

            bg1 = ImageIO.read(new File(path + "background1.png"));

            bg2 = ImageIO.read(new File(path + "background2.png"));

            //加载火娃站立
            firer_stand = ImageIO.read(new File(path + "firer_stand.png"));

            //加载火娃向左跑
            firer_run_L = ImageIO.read(new File(path + "firer_run_L.png"));

            //加载火娃向右跑
            firer_run_R = ImageIO.read(new File(path + "firer_run_R.png"));

            //加载冰娃站立
            icer_stand = ImageIO.read(new File(path + "icer_stand.png"));

            //加载冰娃向左跑
            icer_run_L = ImageIO.read(new File(path + "icer_run_L.png"));

            //加载冰娃向右跑
            icer_run_R = ImageIO.read(new File(path + "icer_run_R.png"));

            updown = ImageIO.read(new File(path+"updown.png"));

            box = ImageIO.read(new File(path + "stone.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            //加载火娃向上跳跃
            firer_jump_up = ImageIO.read(new File(path + "firer_jumpup.png"));

            //加载火娃向下跳跃
            firer_jump_down = ImageIO.read(new File(path + "firer_jumpdown.png"));

            //加载火娃向左上跳跃
            firer_jump_up_L = ImageIO.read(new File(path + "firer_jumpup_L.png"));

            //加载火娃向左下跳跃
            firer_jump_down_L = ImageIO.read(new File(path + "firer_jumpdown_L.png"));

            //加载火娃向右上跳跃
            firer_jump_up_R = ImageIO.read(new File(path + "firer_jumpup_R.png"));

            //加载火娃向右下跳跃
            firer_jump_down_R = ImageIO.read(new File(path + "firer_jumpdown_R.png"));

            //===========================
            //加载冰娃向上跳跃
            icer_jump_up = ImageIO.read(new File(path + "icer_jumpup.png"));

            //加载冰娃向下跳跃
            icer_jump_down = ImageIO.read(new File(path + "icer_jumpdown.png"));

            //加载冰娃向左上跳跃
            icer_jump_up_L = ImageIO.read(new File(path + "icer_jumpup_L.png"));

            //加载冰娃向左下跳跃
            icer_jump_down_L = ImageIO.read(new File(path + "icer_jumpdown_L.png"));

            //加载冰娃向右上跳跃
            icer_jump_up_R = ImageIO.read(new File(path + "icer_jumpup_R.png"));

            //加载冰娃向右下跳跃
            icer_jump_down_R = ImageIO.read(new File(path + "icer_jumpdown_R.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }


        //加载砖块
        try {
            prop.add(ImageIO.read(new File(path + "brick.png"))); //type=0

            prop.add(ImageIO.read(new File(path + "updown.png"))); //type=1

            prop.add(ImageIO.read(new File(path + "button.png"))); //type=2

            prop.add(ImageIO.read(new File(path + "red_diamond.png"))); //type=3

            prop.add(ImageIO.read(new File(path + "blue_diamond.png"))); //type=4

            prop.add(ImageIO.read(new File(path + "fire_river.png"))); //type=5

            prop.add(ImageIO.read(new File(path + "ice_river.png"))); //type=6

            prop.add(ImageIO.read(new File(path + "mud_river.png"))); //type=7

            prop.add(ImageIO.read(new File(path + "fire_gate.png")));//type=8

            prop.add(ImageIO.read(new File(path + "ice_gate.png")));//type=9

            prop.add(ImageIO.read(new File(path + "fire_gate_on.png")));//type 10

            prop.add(ImageIO.read(new File(path + "ice_gate_on.png")));//type 11

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
