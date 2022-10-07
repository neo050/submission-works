package graphics;

import animals.*;
import mobility.Point;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AddAnimalDialog  extends JDialog implements ActionListener
{
    static private String []Colors={"natural","red","blue"};
    static private String []Types={"lion","Bear","Elephant","Giraffe","Turtle"};
    private String Type="lion";
    private int size=50;
    private int horizontalSpeedV=1;
    private int verticalSpeedV=1;
    private String color="n";
    private Animal animal;
   private JPanel panel;
   private JTextField textField;
   private String humaName="";
   private ArrayList<Animal> animals;
    public AddAnimalDialog(Frame frame,JPanel panel,ArrayList<Animal> animals)
    {
        super(frame,"Add Animal", true);
        this.animals=animals;
        this.panel=panel;
        this.setSize(585,300);
        this.setLayout(new GridLayout(6, 2));
        JComboBox<String> ATypes=new JComboBox<>(Types);
        ATypes.setEditable(true);
        ATypes.setSelectedIndex(0);
        ATypes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i=  ATypes.getSelectedIndex();
                if(i==0)
                {
                    Type="lion";
                } else if (i==1) {

                    Type="Bear";
                }
               else if (i==2) {

                Type="Elephant";
              }
                else if (i==3) {

                    Type="Giraffe";
                }
                else if (i==4) {

                    Type="Turtle";
                }
                System.out.println(Type);
            }
        });
        this.add(new JLabel("Select the type of animal:"));
        this.add(ATypes);
        this.add(new JLabel("Select the size (50 to 300) of the animal:"));
        JComboBox<Integer> Sizes=new JComboBox<>();
        Sizes.setEditable(true);
        for (int i=50;i<301;++i)
            Sizes.addItem(i);
        Sizes.setSelectedIndex(0);
        Sizes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                size=Sizes.getSelectedIndex()+50;
            }
        });
        this.add(Sizes);
        this.add(new JLabel("Select the horizontal speed (1 to 10) of the animal:"));
        JComboBox<Integer> horizontalSpeed=new JComboBox<>();
        horizontalSpeed.setEditable(true);
        JComboBox<Integer> verticalSpeed=new JComboBox<>();
        verticalSpeed.setEditable(true);

        for (int i=1;i<11;++i) {
            horizontalSpeed.addItem(i);
            verticalSpeed.addItem(i);
        }
        horizontalSpeed.setSelectedIndex(0);
        verticalSpeed.setSelectedIndex(0);
        horizontalSpeed. addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                horizontalSpeedV=horizontalSpeed.getSelectedIndex()+1;
            }
        });
        verticalSpeed. addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                verticalSpeedV= verticalSpeed.getSelectedIndex()+1;
            }
        });
        this.add(horizontalSpeed);
        this.add(new JLabel("Select the vertical speed (1 to 10) of the animal:"));
        this.add( verticalSpeed);
        this.add(new JLabel("Choose the color of the animal:"));
        JComboBox<String> AColors=new JComboBox<>(Colors);
        AColors.setEditable(true);
        AColors.setSelectedIndex(0);
        this.add(AColors);
        AColors.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i=  AColors.getSelectedIndex();
                if (i==0)
                    color="n";
                else if (i==1) {
                    color="r";
                }
                else
                    color="b";
                System.out.println(color);
            }
        });
        //horizontal speed
        //vertical speed
        //this.add(new JLabel("Choose a unique name for the animal: "));
        //this.add(textField=new JTextField());
        this.add(new JLabel("Click the button when you are done choosing:"));
        JButton OKJButton =new JButton("OK(:");
        OKJButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                sendAnimal();
            }
        });
        this.add(OKJButton);
        this.setVisible(true);
        //pack();
    }




    protected void sendAnimal()
    {

        switch (Type){
            case "lion":
            {
               animal= new Lion("lio",new Point(900,900),color,size,panel,horizontalSpeedV,verticalSpeedV);
               break;
            }
            case "Bear":
            {
                animal= new Bear("bea",new Point(900,900),color,size,panel,horizontalSpeedV,verticalSpeedV);
                break;
            }
            case "Elephant":
            {
                animal= new Elephant("elf",new Point(900,900),color,size,panel,horizontalSpeedV,verticalSpeedV);
                break;
            }
            case "Giraffe":
            {
                animal= new Giraffe("grf",new Point(900,900),color,size,panel,horizontalSpeedV,verticalSpeedV);
                break;

            }
            case "Turtle":
            {
                animal= new Turtle("trt",new Point(900,900),color,size,panel,horizontalSpeedV,verticalSpeedV);
                break;
            }
        }
        setVisible(false);
        animals.add(animal);

    }


    @Override
    public void actionPerformed(ActionEvent e)
    {

    }


}
