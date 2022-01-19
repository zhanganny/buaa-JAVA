package cn.buaa;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class Prop {
    //用于表示坐标
    private int x;
    private int y;
    //用于记录道具类型
    private int type;
    //用于显示图像
    private BufferedImage show =null;
    //定义当前的场景对象
    private BackGround bg = null;
    //放火门
    private List<Prop> fireList = new ArrayList<>();
    //放冰门
    private List<Prop> iceList = new ArrayList<>();

    public Prop(int x, int y, int type, BackGround bg) {
        this.x = x;
        this.y = y;
        this.type = type;
        this.bg = bg;
        show = StaticValue.prop.get(type);
    }

    //蓝钻消失方法
    public void blueMissing() {
        this.bg.getBlueDiamondList().remove(this);
    }
    //红钻消失方法
    public void redMissing() {
        this.bg.getRedDiamondList().remove(this);
    }

    //冰火门
    public void arriveRedGate() {
        this.bg.getFireGateList2().remove(this);
    }

    public void arriveBlueGate() {
        this.bg.getIceGateList2().remove(this);
    }




    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getType() {
        return type;
    }

    public BufferedImage getShow() {
        return show;
    }

}
