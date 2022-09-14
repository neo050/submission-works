package graphics;

import animals.Animal;
import mobility.Point;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MoveAnimalDialog  extends JDialog implements ActionListener {
     private ArrayList<Animal> animals;
    private JTextField Xtext;
    private JTextField Ytext;
    private int X;
    private int Y;
    private JComboBox <String>animalsNames;
    public MoveAnimalDialog (Frame frame, ArrayList<Animal> animals)
    {
            super(frame,"Move Animal", true);
        this.animals=animals;
        this.setSize(1015,300);
        this.setLayout(new GridLayout(4, 2));
        this.add(new JLabel("Select the animal you want to move :"));
        String[] arr=new String[animals.size()];
        for(int i=0;i<animals.size();++i)
        {
            arr[i]=animals.get(i).getHumaName();
        }
       animalsNames=new JComboBox<>(arr);
        animalsNames.setSelectedIndex(0);
        animalsNames.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        this.add(animalsNames);
        this.setLocationRelativeTo(null);
        this.add(new JLabel("Enter an integer value for the X coordinate. The value can range from 0 to 800 inclusive: "));
        this.add(Xtext=new JTextField());
        this.add(new JLabel("Enter an integer value for the Y coordinate. The value can range from 0 to 600 inclusive: "));
        this.add(Ytext=new JTextField());
        this.add(new JLabel("Click the button when you are done submitting the required details: "));
        JButton moveAnimal=new JButton("Move Animal");
        moveAnimal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(setX()&&setY())
                {
                    setVisible(false);
                    setAnimaLocation();
                }
            }
        });
        this.add(moveAnimal);
        setVisible(true);
        ///     להוסית ליסינר לכפתור ולהמשיך את הלוגיקה של הפעולות
    }
    private boolean setX()
    {
        try
        {
            X= Integer.parseInt(Xtext.getText());
        }
        catch (Exception O)
        {
            JOptionPane.showMessageDialog(null, "You must Enter an integer value for the X coordinate. The value can range from 0 to 800 inclusive", "Message", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        if (X>=0&&X<=800)
            return true;
        JOptionPane.showMessageDialog(null, "You must Enter an integer value for the X coordinate. The value can range from 0 to 800 inclusive", "Message", JOptionPane.WARNING_MESSAGE);
        return false;
    }
    private boolean setY()
    {
        try
        {
            Y= Integer.parseInt(Ytext.getText());
        }
        catch (Exception O)
        {
            JOptionPane.showMessageDialog(null, "You must Enter an integer value for the Y coordinate. The value can range from 0 to 600 inclusive", "Message", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        if (Y>=0&&Y<=800)
            return true;
        JOptionPane.showMessageDialog(null, "You must Enter an integer value for the Y coordinate. The value can range from 0 to 600 inclusive", "Message", JOptionPane.WARNING_MESSAGE);
        return false;
    }
    private boolean setAnimaLocation()
    {
        for (Animal animal:animals)
        {
            if(animalsNames.getSelectedItem().equals(animal.getHumaName()))
            {
                animal.setLocation(new Point(X,Y));
                animal.setChanges(true);
                return true;
            }
        }
        return false;
    }

    public boolean UpdatingListAnimals()
    {
        animalsNames.removeAllItems();

        for(int i=0;i<animals.size();++i)
        {
            animalsNames.addItem(animals.get(i).getHumaName());
        }
        return true;
    }



    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
