/*/package graphics;

import javax.swing.*;
import java.awt.*;

public class ZooPanel  extends JPanel implements Runnable
{
    private Image BackgroundImage=null;
    private JPanel bottomPanel;

    private static int Xmax=1900,Ymax=765;
    JDialog dialog;
    @Override
    public void run() {

    }
    public ZooPanel()
    {

        this.setLayout(new BorderLayout());
        this.bottomPanel = new JPanel();
        this.bottomPanel.setBackground(Color.cyan);
        //bottomPanel.setLayout(new BoxLayout(this.bottomPanel, BoxLayout.LINE_AXIS));
        //BoxLayout myBorderLayout = new BoxLayout(this.bottomPanel, BoxLayout.LINE_AXIS);
        //myBorderLayout new FlowLayout(FlowLayout.LEFT,5,5
        bottomPanel.setLayout(new FlowLayout(FlowLayout.LEADING,5,5));
        JButton add_animal =new JButton("Add Animal");
        JButton move_animal=new JButton("Move Animal");
        JButton clear=new JButton("Clear");
        JButton food=new JButton("Food");
        JButton info=new JButton("Info");
        JButton exit=new JButton("Exit");

        add_animal.setFont(new Font("Comic Sans",Font.BOLD,12));
        move_animal.setFont(new Font("Comic Sans",Font.BOLD,12));
        clear.setFont(new Font("Comic Sans",Font.BOLD,12));
        food.setFont(new Font("Comic Sans",Font.BOLD,12));
        info.setFont(new Font("Comic Sans",Font.BOLD,12));
        exit.setFont(new Font("Comic Sans",Font.BOLD,12));

        add_animal.setFocusable(false);
        move_animal.setFocusable(false);
        clear.setFocusable(false);
        food.setFocusable(false);
        info.setFocusable(false);
        exit.setFocusable(false);

        bottomPanel.add(add_animal);
        bottomPanel.add(move_animal);
        bottomPanel.add(clear);
        bottomPanel.add(food);
        bottomPanel.add(info);
        bottomPanel.add(exit);
      this.add(bottomPanel,BorderLayout.SOUTH);

    }
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g) ;
        Graphics2D g2D=(Graphics2D) g;
        setLayout(new FlowLayout());
        g2D.drawImage(BackgroundImage,0,0,getWidth(),getHeight(), this);
    }
    public boolean setBackgroundImage()
    {
        if(BackgroundImage==null) {
            try {

                BackgroundImage = new ImageIcon(IDrawable.PICTURE_PATH + "savanna.png").getImage();
                repaint();

                return true;
            } catch (Exception o) {
                return false;
            }

        }
        repaint();
        return true;
    }
    public void setNULLBackground()
    {
        BackgroundImage=null;
        repaint();


    }
    public void setBackground(Color Color)
    {
      super. setBackground(Color);
    }
}
//

 */
package graphics;

import animals.Animal;
import food.EFoodType;
import meat.Meat;
import plants.Cabbage;
import plants.Lettuce;
import plants.Plant;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ZooPanel  extends JPanel implements Runnable, ActionListener {
    private Image BackgroundImage = null;
    private String[] responses = {"Lettuce", "Cabbage", "Meat"};
    private String[] infoRows={"Animal","Color","Weight","Hor.speed","Ver.speed","Eat counter"};
    private Image AnimalTest = null;
    private AddAnimalDialog addAnimalDialog = null;

    private ZooFrame zooFrame;
    private ArrayList<Animal> animals;
    private JLabel label;
    private static int Xmax = 1900, Ymax = 765;
    private JButton add_animal;
    private Plant plant;
    private Meat meat;
    private Thread controller;

    @Override
    public void run() {
        while (true)
        {
            manageZoo();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public ZooPanel(ZooFrame zooFrame) {
        this.setLayout(new BorderLayout());
        this.setSize(800,600);
        animals = new ArrayList<Animal>();
        label = new JLabel();
        label.setLayout(new FlowLayout(FlowLayout.LEADING, 5, 5));
        label.setPreferredSize(new Dimension(800, 35));
        label.setBackground(Color.cyan);
        label.setOpaque(true);
        this.add(label, BorderLayout.PAGE_END);
        //BorderLayout layout=new BorderLayout(5,5);
        //label.setBounds(0, (int) this.getBounds().getY()/10,20,20);
        // label.setLayout(layout);


        //bottomPanel.setLayout(new BoxLayout(this.bottomPanel, BoxLayout.LINE_AXIS));
        //BoxLayout myBorderLayout = new BoxLayout(this.bottomPanel, BoxLayout.LINE_AXIS);
        //myBorderLayout new FlowLayout(FlowLayout.LEFT,5,5
        ///bottomPanel.setLayout(new FlowLayout(FlowLayout.LEADING,5,5));
        add_animal = new JButton("Add Animal");
        ZooPanel me = this;
        JButton Sleep =new JButton("Sleep");
        Sleep.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {

                for(int i=0;i<animals.size();++i)
                {
                    animals.get(i).setSuspended();
                }
            }
        });
        JButton Wakeup =new JButton("Wake up");
        Wakeup.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                for(int i=0;i<animals.size();++i)
                {
                    animals.get(i).setResumed();
                }

            }
        });
        add_animal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (animals.size() < 10) {
                    if (addAnimalDialog != null) {
                        addAnimalDialog.setVisible(true);
                    }
                    else {
                        addAnimalDialog = new AddAnimalDialog(zooFrame,me,animals);
                    }

                    manageZoo();
                } else {
                    JOptionPane.showMessageDialog(null, "You cannot add more than 10 animals", "Message", JOptionPane.WARNING_MESSAGE);
                }
            }
        });


        JButton clear = new JButton("Clear All");
        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int size=animals.size();
                for(int i=0;i<size;++i)
                {
                  Animal animal=  animals.get(0);
                  animal.stop();
                  animals.remove(0);

                }
                repaint();

            }
        });
        JButton food = new JButton("Food");
        JButton info = new JButton("Info");
        JButton exit = new JButton("Exit");
        food.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (JOptionPane.showOptionDialog(null, "Please choosse food", "Food for animals", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, responses, 0)) {
                    case 0: {
                        plant = new Lettuce(me);

                        break;
                    }
                    case 1: {
                        plant = new Cabbage(me);

                        break;
                    }
                    case 2: {
                        meat = new Meat(me,zooFrame);

                        break;
                    }
                }
                manageZoo();
            }
        });
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        info.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String data [][]=new String[animals.size()+1][];
                int total=0;
                int j=0;
                int i;
                for(i=0;i<animals.size();++i)
                {
                    j=0;
                    data[i]=new String[6];
                    data[i][j]=animals.get(i).toString();
                    data[i][++j]=animals.get(i).getColor();
                    data[i][++j]=animals.get(i).getWeight()+"";
                    data[i][++j]=animals.get(i).getHorSpeed()+"";
                    data[i][++j]=animals.get(i).getVerSpeed()+"";
                    data[i][++j]=animals.get(i).getEatCount()+"";
                    total=total+animals.get(i).getEatCount();
                }
                if(animals.size()>0) {
                    data[i] = new String[6];
                    data[i][0] = "Total";
                    data[i][j] = total + "";
                    JTable jt = new JTable(data, infoRows)
                    {
                        public boolean isCellEditable(int data,int columns)
                        {
                            return false;
                        }
                    };

                    jt.setPreferredSize(new Dimension(500, 100));
                    jt.setFillsViewportHeight(true);
                    JFrame frame = new JFrame("Animals info");
                    frame.add(new JScrollPane(jt));
                    frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                    frame.pack();
                    frame.setVisible(true);
                }


            }
        });

        add_animal.setFont(new Font("Comic Sans", Font.BOLD, 12));
        clear.setFont(new Font("Comic Sans", Font.BOLD, 12));
        food.setFont(new Font("Comic Sans", Font.BOLD, 12));
        info.setFont(new Font("Comic Sans", Font.BOLD, 12));
        exit.setFont(new Font("Comic Sans", Font.BOLD, 12));
        Sleep.setFont(new Font("Comic Sans", Font.BOLD, 12));
        Wakeup.setFont(new Font("Comic Sans", Font.BOLD, 12));

        add_animal.setFocusable(false);
        clear.setFocusable(false);
        food.setFocusable(false);
        info.setFocusable(false);
        exit.setFocusable(false);
        Sleep.setFocusable(false);
        Wakeup.setFocusable(false);

        label.add(add_animal);
        label.add(Sleep);
        label.add(Wakeup);
        label.add(clear);
        label.add(food);
        label.add(info);
        label.add(exit);
        controller=new Thread(this);
        controller.start();

        //this.add(bottomPanel,BorderLayout.SOUTH);

    }

    public synchronized void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;
        g2D.drawImage(BackgroundImage, 0, 0, getWidth(), getHeight(), this);
        for (int i=0;i< animals.size();++i)
            animals.get(i).drawObject(g);
        if (plant != null)
        {
            plant.drawObject(g);
        }
        if (meat != null)
        {
            meat.drawObject(g);
        }
        //g2D.drawImage(AnimalTest,80,0,300,300, this);
    }
    private void oNOffFoodForAnimals(boolean bool, EFoodType food)
    {
        for (Animal animal :animals)
        {
            if (animal.getDiet().canEat(food))
                animal.foodOnPanel(bool);
        }
    }
    public boolean setBackgroundImage() {
        if (BackgroundImage == null) {
            try {
                BackgroundImage = new ImageIcon(IDrawable.PICTURE_PATH + "savanna.png").getImage();
                AnimalTest = new ImageIcon(IDrawable.PICTURE_PATH + "lio_n_1.png").getImage();
                repaint();
                return true;
            } catch (Exception o) {
                return false;
            }

        }
        repaint();
        return true;
    }

    public void setNULLBackground() {
        BackgroundImage = null;
        repaint();
    }

    public void setBackground(Color Color)
    {
        super.setBackground(Color);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {

    }

    public void manageZoo()
    {
            Animal animal=null;
            for (int i=0;i< animals.size();++i)
            {
               animal= animals.get(i);

                if (animal.getChanges())
                {
                    repaint();
                }

                if (plant != null) {
                    if (animals.size()>=1)
                        oNOffFoodForAnimals(true,EFoodType.VEGETABLE);
                    if (Math.abs(animal.getLocation().getX()-plant.getLocation().getX())< animal.getEAT_DISTANCE() && Math.abs(animal.getLocation().getY()-plant.getLocation().getY()) < animal.getEAT_DISTANCE()) {
                        if (animal.eat(plant))
                        {
                            plant = null;
                            oNOffFoodForAnimals(false,EFoodType.VEGETABLE);
                            repaint();
                        }
                    }
                }
                    if (meat != null) {
                        if (animals.size()>=1)
                            oNOffFoodForAnimals(true,EFoodType.MEAT);
                        if (Math.abs(animal.getLocation().getX()-meat.getLocation().getX())< animal.getEAT_DISTANCE() && Math.abs(animal.getLocation().getY()-meat.getLocation().getY()) < animal.getEAT_DISTANCE()) {

                                if (animal.eat(meat)) {
                                    meat = null;
                                    oNOffFoodForAnimals(false,EFoodType.MEAT);
                                    repaint();
                                }

                        }


                    }
                    //animal.calcDistance()

            }
            Animal animalI;
            Animal animalJ;
            for (int i = 0; i < animals.size(); ++i) {
                animalI = animals.get(i);
                for (int j = 0; j < animals.size(); ++j) {
                    animalJ = animals.get(j);
                    if (i != j) {
                        if (animalI.getDiet().canEat(animalJ.getFoodtype()) && animalI.getWeight() > 2 * animalJ.getWeight() && animalI.calcDistance(animalJ.getLocation()) < animalJ.getSize()) {
                            animalI.eat(animalJ);
                            animalJ.stop();
                            animals.remove(animalJ);
                            animalJ = null;
                            repaint();
                        }
                    }
                }
            }

        }
    }



