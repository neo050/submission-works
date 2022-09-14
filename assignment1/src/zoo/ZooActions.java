package zoo;

import animals.*;
import food.IEdible;
import mobility.Point;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ZooActions {
   static String arr[]={"1","2","3","4","5"};
    public static boolean eat(Object animal , IEdible food )
    {
        if (animal instanceof Animal)
            return ((Animal)animal).eat(food);
        return false;
    }
   public static boolean move(Object animal, Point point)
    {
        if (animal instanceof Animal)
        {
            if (Point.checkBoundaries(point)) {
                ((Animal) animal).move(point);
                return true;
            }

        }
        return false;
    }
    public static void main(String args [])
    {
        Scanner scanner =new Scanner(System.in);
        System.out.print("Enter the size for animal array: ");
        int size =scanner.nextInt();
        if (size <3)
            size=3;
        List<Animal>animals=new ArrayList<Animal>();
        String name ;String furColor;int x,y;boolean bool=false;double trunkLength;
        for (int i=0;i<size;++i)
        {
            String c="pop";
            System.out.print("\n");
            while(!(c.equals("1")||c.equals("2")||c.equals("3")||c.equals("4")||c.equals("5"))){
                System.out.println("Enter 1 -> Bear\nEnter 2 -> Elephant\nEnter 3 -> Giraffe\nEnter 4-> Lion\nEnter 5 -> Turtle\n");
                c =scanner.next();
            }
            System.out.println("Enter the x for the point");
            x =scanner.nextInt();
            System.out.println("Enter the y for the point");
            y=scanner.nextInt();
            System.out.println("Enter the name for the animal");
            name =scanner.next();
            bool=Point.checkBoundaries(new Point(x,y));

            switch (c)
            {
                case "1":
                {
                    System.out.println("Enter a furColor for the Bear");
                    furColor =scanner.next();
                    animals.add( new Bear(name,furColor));
                    break;
                }
                case "2":
                {
                    System.out.println("Enter the size of a trunkLength for the Elephant");
                    trunkLength =scanner.nextDouble();
                    animals.add(new Elephant(name,trunkLength));
                    break;
                }
                case "3":
                {
                    System.out.println("Enter the size of a neckLength for the Giraffe");
                    trunkLength =scanner.nextDouble();
                    animals.add(new Elephant(name,trunkLength));
                    break;
                }
                case "4":
                {


                    animals.add(new Lion(name));
                    break;
                }
                case "5":
                {
                    System.out.println("Enter the Age of the Turtle");
                    trunkLength =scanner.nextDouble();
                    animals.add(new Turtle(name,trunkLength));
                    break;
                }
            }

            if (bool)
                animals.get(i).setLocation(new Point(x,y));

        }
        for (Animal animal:animals)
        {
            move(animal,new Point(animal.getLocation().getX()+10,animal.getLocation().getY()+10));
        }
        int size1=animals.size()/2;
        for(int i=0;i<size1;++i)
        {
            Random rand =new Random();
            int x1 =rand.nextInt(0, arr.length);
            int x2 =rand.nextInt(0, arr.length);
            if (x1==x2)
                continue;
            if(eat(animals.get(x1),animals.get(x2)))
                animals.remove(animals.get(x2));
        }
    }

}
