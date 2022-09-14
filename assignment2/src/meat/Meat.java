package meat;

import food.EFoodType;
import food.IEdible;
import graphics.IDrawable;
import graphics.ZooFrame;
import graphics.ZooPanel;
import mobility.Ilocatable;
import mobility.Point;
import utilities.MessageUtility;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public  class Meat implements IEdible, Ilocatable, IDrawable {
    /**
     *
     */
    private double height;
    /**
     *
     */
    private Point location;
    /**
     *
     */
    private double weight;

    /**
     *
     */
    private BufferedImage img1;
    private ZooPanel pan;
    private ZooFrame frame;
    public Meat(ZooPanel pan, ZooFrame frame) {
        int x = 400;
        int y = 300;
        this.location = new Point(x, y);
        this.pan=pan;
        MessageUtility.logConstractor("Meat", "Meat");
        this.frame=frame;
        loadImages("meat");
        pan.repaint();
    }

    /*
     * (non-Javadoc)
     *
     * @see food.IFood#getFoodtype()
     */
    @Override
    public EFoodType getFoodtype() {
        MessageUtility.logGetter(this.getClass().getSimpleName(), "getFoodType", EFoodType.MEAT);
        return EFoodType.MEAT;
    }

    /**
     * @return
     */
    public double getHeight() {
        MessageUtility.logGetter(this.getClass().getSimpleName(), "getHeight", this.height);
        return this.height;
    }

    /*
     * (non-Javadoc)
     *
     * @see mobility.ILocatable#getLocation()
     */
    @Override
    public Point getLocation() {
        MessageUtility.logGetter(this.getClass().getSimpleName(), "getLocation", this.location);
        return this.location;
    }

    /**
     * @return
     */
    public double getWeight() {
        MessageUtility.logGetter(this.getClass().getSimpleName(), "getWeight", this.weight);
        return weight;
    }

    /**
     * @param height
     * @return
     */
    public boolean setHeight(double height) {

        boolean isSuccess = (height >= 0);
        if (isSuccess) {
            this.height = height;
        } else {
            this.height = 0;
        }
        MessageUtility.logSetter(this.getClass().getSimpleName(), "setHeight", height, isSuccess);
        return isSuccess;
    }

    /*
     * (non-Javadoc)
     *
     * @see mobility.ILocatable#setLocation(mobility.Point)
     */
    @Override
    public boolean setLocation(Point newLocation) {
        boolean isSuccess = Point.checkBoundaries(newLocation);
        if (isSuccess) {
            this.location = newLocation;
        }
        MessageUtility.logSetter(this.getClass().getSimpleName(), "setLocation", newLocation, isSuccess);
        return isSuccess;
    }

    /**
     * @param weight
     * @return
     */
    public boolean setWeight(double weight) {
        boolean isSuccess = (weight >= 0);
        if (isSuccess) {
            this.weight = weight;
        } else {
            this.weight = 0;
        }
        MessageUtility.logSetter(this.getClass().getSimpleName(), "setWeight", weight, isSuccess);

        return isSuccess;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "[" + this.getClass().getSimpleName() + "] ";
    }

    public void loadImages(String nm)
    {
        try { img1 = ImageIO.read(new File(IDrawable.PICTURE_PATH+nm+".png")); }
        catch (IOException e) { System.out.println("Cannot load image"); }
    }

    public String getColor()
    {
        return "natural";
    }
    public void drawObject (Graphics g)
    {
        //g.drawImage(img1, pan.getWidth()/2, pan.getHeight()/2, pan);
        ((Graphics2D)g).drawImage(img1,location.getX(), location.getY(), 50,50, pan);
    }
}