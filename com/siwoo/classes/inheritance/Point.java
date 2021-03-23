package com.siwoo.classes.inheritance;

public class Point {
    protected int x, y;
    public Point(int x, int y) { this.x = x; this.y = y; }
    public int getX() { return x; }
    public int getY() { return y; }
    protected void move(int x, int y) { this.x =x; this.y = y; }

}


class ColorPoint extends Point{

    private String color;

    public ColorPoint(){
        this(0,0, "BLACK");
    }

    public ColorPoint(int x, int y) {
        super(x, y);
    }

    public ColorPoint(int x, int y, String color) {
        super(x,y);
        this.color = color;
    }
    private void setXY(int x, int y) {
        super.move(x,y);
    }

    private void setColor(String str) {
        this.color = str;
    }

    @Override
    public String toString() {

        return color+" 색의 (" + x + "," + y + ")의 점";

    }

    public static void main(String[] args) {
        ColorPoint cp = new ColorPoint(5, 5, "YELLOW");
        cp.setXY(10, 20);
        cp.setColor("RED");
        String str = cp.toString();
        System.out.println(str + "입니다. ");

        ColorPoint zeroPoint = new ColorPoint(); // (0,0) 위치의 BLACK 색 점
        System.out.println(zeroPoint.toString() + "입니다.");
        ColorPoint cd = new ColorPoint(10, 10); // (10,10) 위치의 BLACK 색 점
        cd.setXY(5,5);
        cd.setColor("RED");
        System.out.println(cd.toString()+"입니다.");

    }
}

class Point3D extends Point{

    private int z;

    public Point3D(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }

    public void moveUp(){
        z++;
    }
    public void moveDown(){
        z--;
    }

    //오버로딩
    public void move(int x, int y, int z) {
        super.move(x, y);
        this.z = z;
    }

    @Override
    public String toString() {

        return "(" + x + "," + y + "," + z + ")의 점";

    }

    public static void main(String[] args) {

        Point3D p = new Point3D(1,2,3); // 1,2,3은 각각 x, y, z축의 값.
        System.out.println(p.toString()+"입니다.");   //(1,2,3) 의 점입니다
        p.moveUp(); // z 축으로 위쪽 이동
        System.out.println(p.toString()+"입니다.");
        p.moveDown(); // z 축으로 아래쪽 이동
        p.move(10, 10); // x, y 축으로 이동
        System.out.println(p.toString()+"입니다.");
        p.move(100,  200, 300); // x, y, z축으로 이동
        System.out.println(p.toString()+"입니다.");

    }

}
