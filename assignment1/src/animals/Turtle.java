package animals;
import diet.Herbivore;
import mobility.Point;
import utilities.MessageUtility;

public class Turtle extends Herbivore {
        private double Age;
        public Turtle(String name )
        {
            super(name,new Point(80,0));
            MessageUtility.logConstractor("Turtle",name);
            super.setDiet(this);
            super.setWeight(1);
            setAge(1);
        }
        public Turtle(String name ,double trunkLength)
        {
            super(name,new Point(80,0));
            MessageUtility.logConstractor("Turtle",name);
            super.setDiet(this);
            super.setWeight(1);
            if(!setAge(trunkLength))
                setAge(1);




        }
        public Turtle(String name ,Point point)
        {
            super(name,point);
            MessageUtility.logConstractor("Turtle",name);
            super.setDiet(this);
            super.setWeight(1);
            setAge(1);

        }
        public Turtle(String name ,Point point,double trunkLength)
        {
            super(name,point);
            MessageUtility.logConstractor("Turtle",name);
            super.setDiet(this);
            super.setWeight(1);
            if(!setAge(trunkLength))
                setAge(1);

        }
        public boolean setAge(double Age)
        {
            if (Age>=0&&Age<=500) {
                this.Age = Age;
                MessageUtility.logSetter(getName(),"setAge",Age,true);

                return true;
            }
            MessageUtility.logSetter(getName(),"setAge",Age,false);
            return  false;
        }
        public double getAge()
        {
            MessageUtility.logGetter(getName(),"getAge",Age);
            return this.Age;
        }
        public  String toString()
        {
            return "[Turtle]:" +getName() ;
        }
    }


