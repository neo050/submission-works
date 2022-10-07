package mobility;

import utilities.MessageUtility;

public abstract class Mobile implements  Ilocatable{
   private Point location; //Current location
    private double totalDistance;
    public Mobile(Point point ,double totalDistance)
    {
        this.location=point;
        this.totalDistance=  totalDistance;
    }
    public Mobile(Point point )
    {
        this.location=point;
        this.totalDistance= 0;
    }
   private void addTotalDistance(double Distance)
    {
        this.totalDistance+=Distance;
    }
    public double calcDistance(Point point)
    {
        return Math.sqrt((point.getX()-this.location.getX())*(point.getX()-this.location.getX())+(point.getY()-this.location.getY())*(point.getY()-this.location.getY()));
    }
    public double move(Point point)
    {
        if(!Point.checkBoundaries(point)) return 0.0;
        double calc =calcDistance(point);
        addTotalDistance(calc);
        setLocation(point);
        return calc;

    }
    public synchronized boolean setLocation(Point point)
    {

            this.location.setX(point.getX());
            this.location.setY(point.getY());
            MessageUtility.logSetter("Mobile","setLocation",point ,true);
            return true;
    }
    public synchronized Point getLocation()
    {
        MessageUtility.logGetter("Mobile","getLocation",location);
        return location;
    }

}

