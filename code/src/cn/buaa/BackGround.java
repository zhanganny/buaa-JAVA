package cn.buaa;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class BackGround {
    //当前场景需要显示的图像
    private BufferedImage bgImage = null;

    //记录当前是第几个场景
    private int sort;


    //用于存放所有的障碍物
    private List<Prop> propList = new ArrayList<>();

    //用于存放冰河
    private List<Prop> ice_river_List = new ArrayList<>();

    //用于存放火河
    private List<Prop> fire_river_List = new ArrayList<>();


    //用于存放泥沼
    private List<Prop> mud_river_List = new ArrayList<>();
    //放砖块
    private List<Prop> brickList = new ArrayList<>();



    //放红钻
    private List<Prop> redDiamondList = new ArrayList<>();
    //放蓝钻
    private List<Prop> blueDiamondList = new ArrayList<>();
    //放火门
    private List<Prop> fireGateList1 = new ArrayList<>();
    private List<Prop> fireGateList2 = new ArrayList<>();
    //放冰门
    private List<Prop> iceGateList1 = new ArrayList<>();
    private List<Prop> iceGateList2 = new ArrayList<>();
    //创建空参构造
    public BackGround() {
    }




    public BackGround(int sort) {
        this.sort = sort;

        //开始页面
        if(sort == 0) {
            bgImage = StaticValue.bg0;
        }
        //第一关
        if (sort == 1) {
                bgImage = StaticValue.bg1;
                //绘制第一关的地面      1:brick
                for (int i = 0; i < 19; i++) {
                    brickList.add(new Prop(20+i*40,520,0,this));
                }



                for (int i = 16; i < 19; i++) {
                    brickList.add(new Prop(20+i*40,480,0,this));
                }

                for (int i = 17; i < 19; i++) {
                    brickList.add(new Prop(20+i*40,440,0,this));
                }

                for (int i = 0; i < 6; i++) {
                    brickList.add(new Prop(20+i*40,430,0,this));
                }

                for (int i = 9; i < 17; i++) {
                    brickList.add(new Prop(20+i*40,380,0,this));
                }

            mud_river_List.add(new Prop(500,380,7,this));//泥河

                for (int i =3; i < 9; i++) {
                    brickList.add(new Prop(20+i*40,340,0,this)); //i=0->2  放升降台
                }

            propList.add(new Prop(235,330,2,this));

            propList.add(new Prop(235,210,2,this));

                for (int i = 3; i < 9; i++) {
                    brickList.add(new Prop(20+i*40,220,0,this));
                }

                for (int i = 10; i < 19; i++) {
                    brickList.add(new Prop(20+i*40,180,0,this));
                }

                for (int i = 0; i < 14; i++) {
                    brickList.add(new Prop(20+i*40,110,0,this));
                }

            fireGateList1.add(new Prop(80,42,10,this));//火门

            fireGateList2.add(new Prop(90,50,8,this));//火门

            iceGateList1.add(new Prop(140,42,11,this));//冰门

            iceGateList2.add(new Prop(150,50,9,this));//冰门


            blueDiamondList.add(new Prop(525,430,4,this));//蓝钻

            blueDiamondList.add(new Prop(70,250,4,this));//蓝钻

            blueDiamondList.add(new Prop(722,120,4,this));//蓝钻

            redDiamondList.add(new Prop(40,75,3,this));//红钻

            redDiamondList.add(new Prop(625,330,3,this));//红钻

            redDiamondList.add(new Prop(325,430,3,this));//红钻

            ice_river_List.add(new Prop(280,520,5,this));//冰河

            fire_river_List.add(new Prop(480,520,6,this));//火河
            }
        if (sort==2) {
            bgImage = StaticValue.bg2;
        }
        if (sort==3) {
            for (int i = 0; i < 19; i++) {
                brickList.add(new Prop(20+i*40,520,0,this));
            }

            for (int i = 3; i < 5; i++) {
                brickList.add(new Prop(20+i*40,470,0,this));
            }

            for (int i = 14; i < 19; i++) {
                brickList.add(new Prop(20+i*40,470,0,this));
            }

            for (int i = 5; i < 10; i++) {
                brickList.add(new Prop(20+i*40,440,0,this));
            }
            for (int i = 10; i < 16; i++) {
                brickList.add(new Prop(20+i*40,420,0,this));
            }
            for (int i = 2; i < 6; i++) {
                brickList.add(new Prop(20+i*40,380,0,this));
            }

            for (int i = 17; i < 19; i++) {
                brickList.add(new Prop(20+i*40,330,0,this));
            }

            for (int i = 0; i < 5; i++) {
                brickList.add(new Prop(20+i*40,330,0,this));
            }

            for (int i = 7; i < 12; i++) {
                brickList.add(new Prop(20+i*40,330,0,this));
            }

            for (int i = 13; i < 15; i++) {
                brickList.add(new Prop(20+i*40,350,0,this));
            }


            for (int i = 0; i < 2; i++) {
                brickList.add(new Prop(20+i*40,220,0,this));
            }

            for (int i = 3; i < 8; i++) {
                brickList.add(new Prop(20+i*40,270,0,this));
            }

            for (int i = 6; i < 9; i++) {
                brickList.add(new Prop(20+i*40,200,0,this));
            }

            for (int i = 10; i < 19; i++) {
                brickList.add(new Prop(20+i*40,180,0,this));
            }

            for (int i = 8; i < 9; i++) {
                brickList.add(new Prop(20+i*40,150,0,this));
            }

            for (int i = 0; i < 8; i++) {
                brickList.add(new Prop(20+i*40,110,0,this));
            }

            fireGateList1.add(new Prop(80,42,10,this));//火门

            fireGateList2.add(new Prop(90,50,8,this));//火门

            iceGateList1.add(new Prop(140,42,11,this));//冰门

            iceGateList2.add(new Prop(150,50,9,this));//冰门

            redDiamondList.add(new Prop(50,50,3,this));//红钻

            redDiamondList.add(new Prop(330,100,3,this));//红钻

            redDiamondList.add(new Prop(722,120,3,this));

            redDiamondList.add(new Prop(70,280,3,this));

            redDiamondList.add(new Prop(725,260,3,this));//红钻

            redDiamondList.add(new Prop(590,310,3,this));//红钻

            redDiamondList.add(new Prop(500,370,3,this));

            redDiamondList.add(new Prop(335,360,3,this));//红钻

            redDiamondList.add(new Prop(335,280,3,this));//红钻

            redDiamondList.add(new Prop(225,220,3,this));//红钻

            redDiamondList.add(new Prop(205,50,3,this));//红钻


            blueDiamondList.add(new Prop(525,430,4,this));//蓝钻

            blueDiamondList.add(new Prop(70,250,4,this));//蓝钻

            blueDiamondList.add(new Prop(722,120,4,this));//蓝钻

            blueDiamondList.add(new Prop(110,60,4,this));//蓝钻

            blueDiamondList.add(new Prop(625,330,4,this));//蓝钻

            blueDiamondList.add(new Prop(325,430,4,this));//蓝钻

            blueDiamondList.add(new Prop(625,430,4,this));//蓝钻

            blueDiamondList.add(new Prop(40,250,4,this));//蓝钻

            blueDiamondList.add(new Prop(322,120,4,this));//蓝钻

            blueDiamondList.add(new Prop(50,60,4,this));//蓝钻

            blueDiamondList.add(new Prop(615,330,4,this));//蓝钻

            blueDiamondList.add(new Prop(125,430,4,this));//蓝钻
        }


        if (sort==4) {
            for (int i = 0; i < 19; i++) {
                brickList.add(new Prop(20+i*40,520,0,this));
            }

            for (int i = 3; i < 5; i++) {
                brickList.add(new Prop(20+i*40,470,0,this));
            }

            for (int i = 14; i < 19; i++) {
                brickList.add(new Prop(20+i*40,470,0,this));
            }

            for (int i = 5; i < 10; i++) {
                brickList.add(new Prop(20+i*40,440,0,this));
            }
            for (int i = 10; i < 16; i++) {
                brickList.add(new Prop(20+i*40,420,0,this));
            }
            for (int i = 2; i < 6; i++) {
                brickList.add(new Prop(20+i*40,380,0,this));
            }

            for (int i = 17; i < 19; i++) {
                brickList.add(new Prop(20+i*40,330,0,this));
            }

            for (int i = 0; i < 5; i++) {
                brickList.add(new Prop(20+i*40,330,0,this));
            }

            for (int i = 7; i < 12; i++) {
                brickList.add(new Prop(20+i*40,330,0,this));
            }

            for (int i = 13; i < 15; i++) {
                brickList.add(new Prop(20+i*40,350,0,this));
            }


            for (int i = 0; i < 2; i++) {
                brickList.add(new Prop(20+i*40,220,0,this));
            }

            for (int i = 3; i < 8; i++) {
                brickList.add(new Prop(20+i*40,270,0,this));
            }

            for (int i = 6; i < 9; i++) {
                brickList.add(new Prop(20+i*40,200,0,this));
            }

            for (int i = 10; i < 19; i++) {
                brickList.add(new Prop(20+i*40,180,0,this));
            }

            for (int i = 8; i < 9; i++) {
                brickList.add(new Prop(20+i*40,150,0,this));
            }

            for (int i = 0; i < 8; i++) {
                brickList.add(new Prop(20+i*40,110,0,this));
            }

            fireGateList1.add(new Prop(80,42,10,this));//火门

            fireGateList2.add(new Prop(90,50,8,this));//火门

            redDiamondList.add(new Prop(50,50,3,this));//红钻

            redDiamondList.add(new Prop(330,100,3,this));//红钻

            redDiamondList.add(new Prop(722,120,3,this));

            redDiamondList.add(new Prop(70,280,3,this));

            redDiamondList.add(new Prop(725,260,3,this));//红钻

            redDiamondList.add(new Prop(590,310,3,this));//红钻

            redDiamondList.add(new Prop(500,370,3,this));

            redDiamondList.add(new Prop(335,360,3,this));//红钻

            redDiamondList.add(new Prop(335,280,3,this));//红钻

            redDiamondList.add(new Prop(225,220,3,this));//红钻

            redDiamondList.add(new Prop(205,50,3,this));//红钻

            redDiamondList.add(new Prop(50,50,3,this));//红钻

            redDiamondList.add(new Prop(330,100,3,this));//红钻

            redDiamondList.add(new Prop(722,120,3,this));

            redDiamondList.add(new Prop(70,280,3,this));

            redDiamondList.add(new Prop(725,260,3,this));//红钻

            redDiamondList.add(new Prop(590,310,3,this));//红钻

            redDiamondList.add(new Prop(500,370,3,this));

            redDiamondList.add(new Prop(335,360,3,this));//红钻

            redDiamondList.add(new Prop(335,280,3,this));//红钻

            redDiamondList.add(new Prop(225,220,3,this));//红钻

            redDiamondList.add(new Prop(205,50,3,this));//红钻

        }

        }



    public BufferedImage getBgImage() {
        return bgImage;
    }

    public int getSort() {
        return sort;
    }


    public List<Prop> getPropList() {
        return propList;
    }

    public List<Prop> getBrickList() {
        return brickList;
    }

    public List<Prop> getFire_river_List() {
        return fire_river_List;
    }

    public List<Prop> getMud_river_List() {
        return mud_river_List;
    }

    public List<Prop> getIce_river_List() {
        return ice_river_List;
    }

    public List<Prop> getRedDiamondList() {
        return redDiamondList;
    }

    public List<Prop> getBlueDiamondList() {
        return blueDiamondList;
    }

    public void setFireGateList1(List<Prop> fireGateList1) {
        this.fireGateList1 = fireGateList1;
    }

    public List<Prop> getFireGateList1() {
        return fireGateList1;
    }

    public List<Prop> getFireGateList2() {
        return fireGateList2;
    }

    public List<Prop> getIceGateList1() {
        return iceGateList1;
    }

    public List<Prop> getIceGateList2() {
        return iceGateList2;
    }

}
