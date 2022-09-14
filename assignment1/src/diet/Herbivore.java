


package diet;

        import animals.Animal;
        import food.EFoodType;
        import food.IEdible;
        import mobility.Point;
        import utilities.MessageUtility;

public  class Herbivore extends Animal implements IDiet {

    public Herbivore(String name, Point point)
    {
        super(name,point);

    }
    public boolean canEat(EFoodType food)
    {
        return food==EFoodType.VEGETABLE;
    }
    public double eat(Animal animal, IEdible food)
    {
        if(canEat(food.getFoodtype()))
        {

            return 0.07*animal.getWeight();
        }
        return 0;
    }

    public void makeSound()
    {
        this.chew();

    }

    public void chew()
    {
        MessageUtility.logSound(getName(),"chew");
    }
    public  String toString()
    {
        return "[Herbivore]:" +getName() ;
    }
}

