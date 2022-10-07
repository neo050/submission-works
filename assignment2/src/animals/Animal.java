package animals;

import diet.IDiet;
import food.EFoodType;
import food.IEdible;
import graphics.IAnimalBehavior;
import graphics.IDrawable;
import mobility.Mobile;
import mobility.Point;
import utilities.MessageUtility;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public abstract class Animal extends Mobile implements IEdible, IAnimalBehavior
, IDrawable {
    private String name;
    private String humaName;
    private double weight;
    private IDiet diet;
    private final int EAT_DISTANCE = 10;
    private int size;
    private String col;
    private int horSpeed;
    private int verSpeed;
    private boolean coordChanged;
    private Thread thread;
    private int x_dir;
    private int y_dir;
    private int eatCount;
    private JPanel pan;
    private BufferedImage img1, img2;
    private static  String[] LegalColors = new String[]{"n", "b", "r"};
    public Animal(String name , Point point)
    {
        super(point);
        x_dir=1;
        MessageUtility.logConstractor("Animal",name);
        this.name =name;
        //setLegalColor(col);
        this.size=50;
        this.pan=pan;
    }

    public Animal(String name , Point point,String col,int size,JPanel pan, int horSpeed, int verSpeed)
    {
        super(point);
        this.pan=pan;
        x_dir=1;
        this.name =name;
        setLegalColor(col);
        loadImages(name+"_"+this.col+"_1");
        this.size=size;
        this.horSpeed=horSpeed;
        this.verSpeed=verSpeed;
        MessageUtility.logConstractor("Animal",name);
    }

     public abstract void makeSound();


    public boolean eat(IEdible food)
    {
        double more =getDiet().eat(this,food);
        if(more>0)
        {
            setWeight(getWeight()+more);
            makeSound();
            eatInc();
            return true;
        }
        return false;
    }
    public EFoodType getFoodtype()
    {
        MessageUtility.logGetter(name,"getFoodtype",EFoodType.MEAT);
        return EFoodType.MEAT;
    }
    protected boolean setDiet(IDiet diet)
    {
        MessageUtility.logSetter(name,"setDiet",diet ,true);
        this.diet=diet;
        return true;
    }
    public IDiet getDiet()
    {
        MessageUtility.logGetter(name,"getDiet",diet);
        return this.diet ;
    }
    public boolean setWeight(double newWeight)
    {
        MessageUtility.logSetter(name,"setWeight",newWeight ,true);
        this.weight=newWeight;
        return true;
    }
    public double getWeight()
    {
        MessageUtility.logGetter(name,"setWeight",weight);
        return this.weight;
    }
    public boolean setHumaName(String humaName)
    {
        MessageUtility.logSetter(name,"humaName",humaName,true);
        this.humaName=humaName;
        return true;
    }
    public String getHumaName()
    {
        MessageUtility.logGetter(name,"humaName",humaName);
        return this.humaName;
    }
    public String getName()
    {
        MessageUtility.logGetter(name,"getName",name);
        return name;
    }
    public boolean setName(String newName)
    {
        MessageUtility.logSetter(newName,"setName",newName ,true);
         this.name=newName;
         return true;
    }
    public double move(Point point )
    {
        double distance =super.move(point);
        setWeight(getWeight() -(distance*getWeight()*00025.0));
        setChanges(true);
        return distance;
    }
    public abstract String toString();
    public String getAnimalName()
    {
     return this.name;
    }
    public int getSize()
    {
        return this.size;
    }
    public void eatInc()
    {
        this.eatCount+=1;
    }
    public int getEatCount()
    {
        return this.eatCount;
    }
    public boolean getChanges ()
    {
        return this.coordChanged;
    }
    public void setChanges (boolean state)
    {
        this.coordChanged=state;
    }
    public void loadImages(String nm)
    {
         try
         {
             img1 = ImageIO.read(new File(IDrawable.PICTURE_PATH+nm+".png"));
             pan.repaint();
         }

    catch (IOException e) { System.out.println("Cannot load image"); }
    }

    public String getColor()
    {
        if(col.equals("n"))
            return "natural";
        if(col.equals("r"))
            return  "red";
        return "blue";
    }
    public void drawObject (Graphics g)
    {

        if(x_dir==1) // goes to the right side
            g.drawImage(img1, getLocation().getX(), getLocation().getY(), size, size, pan);
        else // goes to the left side
            g.drawImage(img2,getLocation().getX(), getLocation().getY(), size, size, pan);
        setChanges(false);
    }
    public boolean setLegalColor(String col)
    {
        for(String string:LegalColors) {
            if (string.equals(col)) {
                this.col=col;
                loadImages(name+"_"+col+"_1");
                MessageUtility.logSetter(getName(),"setLegalColor",col,true);
                return true;
            }
        }
        this.col="n";
        MessageUtility.logSetter(getName(),"setLegalColor","n",false);
        return  false;
    }
    public int getEAT_DISTANCE()
    {
        return this.EAT_DISTANCE;
    }
    public int getHorSpeed(){return horSpeed;}
    public int getVerSpeed(){return verSpeed;}
}
