/*/package graphics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ZooFrame extends JFrame implements ActionListener
{

    private ZooPanel zooPanel;
    private static int Xmax=1915,Ymax=774;
    public ZooFrame()
    {
        super("Neoray Zoo");
        //this.setLayout(null);
        setSize(Xmax,Ymax);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        zooPanel =new ZooPanel();
        zooPanel.setPreferredSize(new Dimension(1915,774 ));
        this.add(zooPanel,BorderLayout.SOUTH);
        //zooPanel.setBounds(0,675,1915,774);
        JMenuBar jmb=new JMenuBar();
        this.setJMenuBar(jmb);
        JMenu file=new JMenu("File");
        jmb.add(file);
        JMenuItem exit=new JMenuItem("Exit");
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                System.exit(0);
            }
        });

       // exit.addActionListener(this);
        file.add(exit);
        JMenu background=new JMenu("Background");
        JMenuItem image=new JMenuItem("Image");
        image.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                zooPanel.setBackground(Color.white);
                zooPanel.setBackgroundImage();
            }
        });
        JMenuItem green=new JMenuItem("Green");
        green.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {

                zooPanel.setNULLBackground();
                zooPanel.setBackground(Color.green);
            }
        });
        JMenuItem none=new JMenuItem("None");
        none.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {

                zooPanel.setNULLBackground();
                zooPanel.setBackground(Color.white);
            }
        });
        background.add(image);
        background.add(green);
        background.add(none);
        JMenu help=new JMenu("Help");
        help.addActionListener(this);
        JMenuItem Help=new JMenuItem("Help");
        Help.addActionListener(this);
        help.add(Help);
        jmb.add(background);
        jmb.add(help);

        //this.setLocationRelativeTo(null);
        this.setVisible(true);
       // pack();
    }
    public static void main(String []args)
    {
        new ZooFrame();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

}
//
 */
package graphics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ZooFrame extends JFrame implements ActionListener
{

    private ZooPanel zooPanel;
    private static int Xmax=1915,Ymax=774;
    public ZooFrame()
    {
        super("Neoray Zoo");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(850,650);
        zooPanel =new ZooPanel(this);
        this.add(zooPanel,BorderLayout.CENTER);
        //zooPanel.setBounds(0,675,1915,774);
        JMenuBar jmb=new JMenuBar();
        this.setJMenuBar(jmb);
        JMenu file=new JMenu("File");
        jmb.add(file);
        JMenuItem exit=new JMenuItem("Exit");
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                System.exit(0);
            }
        });

        // exit.addActionListener(this);
        file.add(exit);
        JMenu background=new JMenu("Background");
        JMenuItem image=new JMenuItem("Image");
        image.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                zooPanel.setBackground(Color.white);
                zooPanel.setBackgroundImage();
            }
        });
        JMenuItem green=new JMenuItem("Green");
        green.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {

                zooPanel.setNULLBackground();
                zooPanel.setBackground(Color.green);
            }
        });
        JMenuItem none=new JMenuItem("None");
        none.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {

                zooPanel.setNULLBackground();
                zooPanel.setBackground(Color.white  );
            }
        });
        background.add(image);
        background.add(green);
        background.add(none);
        JMenu help=new JMenu("Help");
        help.addActionListener(this);
        JMenuItem Help=new JMenuItem("Help");
        Help.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                JOptionPane.showMessageDialog(null,"Home Work 2 GUI","Message",JOptionPane.PLAIN_MESSAGE);
            }
        });
        Help.addActionListener(this);
        help.add(Help);
        jmb.add(background);
        jmb.add(help);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        //pack();
    }
    public static void main(String []args)
    {
        new ZooFrame();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

}
