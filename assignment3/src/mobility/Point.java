package mobility;

import utilities.MessageUtility;

public class Point {
    private int x,y;
    public static int Xmax=800,Xmin=0,Ymin=0,Ymax=600;
     public static boolean checkBoundaries(Point point)
    {
        return point.getX()>=0 &&point.getX()<=800&&point.getY()>=0&&point.getY()<=600;
    }
    public  Point(int x,int y)
    {
        setX(x);
        setY(y);

    }
    public Point(Point point)
    {
        setX(point.getX());
        setY(point.getY());
    }
    public int getX()
    {
        MessageUtility.logGetter("Point","setX",x );
        return this.x;
    }
    public int getY()
    {
        MessageUtility.logGetter("Point","setY",y);
        return this.y;
    }
    public boolean setX(int x)
    {
        MessageUtility.logSetter("Point","setX",x ,true);
        this.x=x;
        return true;
    }
    public boolean setY(int y)
    {
        MessageUtility.logSetter("Point","setY",y ,true);
        this.y=y;
        return true;
    }
}

