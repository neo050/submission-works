package animals;

import diet.Omnivore;
import mobility.Point;
import utilities.MessageUtility;

import javax.swing.*;

public class Bear extends Omnivore {
    private String furColor ;
    private static  String[] LegalFurColors = new String[]{"n", "b", "r"};
    public Bear(String name )
    {
        super(name,new Point(100,5));
        MessageUtility.logConstractor("Bear",name);
        super.setDiet(this);
        super.setWeight(308.2);
        setFurColor("n");
    }
    public Bear(String name ,String furColor)
    {
        super(name,new Point(100,5));
        MessageUtility.logConstractor("Bear",name);
        super.setDiet(this);
        super.setWeight(308.2);
        if(!setFurColor(furColor))
            setFurColor("n");

    }
    public Bear(String name , Point point, String col, int size, JPanel pan, int horSpeed, int verSpeed)
    {
        super("bea",new Point(100,5),col,size,pan,horSpeed,verSpeed);
        MessageUtility.logConstractor("Bear",name);
        super.setDiet(this);
        super.setWeight(size*1.5);
        if(!setFurColor(col))
            setFurColor("n");
    }
    public Bear(String name ,Point point)
    {
        super(name,point);
        MessageUtility.logConstractor("Bear",name);
        super.setDiet(this);
        super.setWeight(308.2);
        setFurColor("n");

    }
    public Bear(String name ,Point point,String furColor)
    {
        super(name,point);
        MessageUtility.logConstractor("Bear",name);
        super.setDiet(this);
        super.setWeight(308.2);
        if(!setFurColor(furColor))
            setFurColor("n");

    }
    public boolean setFurColor(String newFurColor)
    {
        for(String string:LegalFurColors) {
            if (string.equals(newFurColor)) {
                this.furColor = newFurColor;
                MessageUtility.logSetter(getName(),"setFurColor",newFurColor,true);

                return true;
            }
        }
        MessageUtility.logSetter(getName(),"setFurColor",newFurColor,false);

        return  false;
    }
    public  String toString()
    {
        return "[Bear]:" +getName() ;
    }
}
