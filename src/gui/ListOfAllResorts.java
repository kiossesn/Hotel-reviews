package gui;

import api.Accomodation;
import api.Systemm;
import api.UserSystem;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ListOfAllResorts extends JFrame {
    private UserSystem userSystem;
    private Systemm system;
    private static JPanel panel;
    private static JLabel name;
    private static JLabel type;
    private static JLabel location;
    private static JLabel avgScore;
    private static JButton view;
    private static JButton back;
    private static JLabel empty;

    public ListOfAllResorts(UserSystem userSystem,Systemm system){
        this.userSystem=userSystem;
        this.system=system;
    }

    //empty list
    public void emptyLabel(){
        empty=new JLabel("No results!");
        panel.add(empty);
    }
    //close page
    public void closeButton(){
        this.setVisible(false);
    }
    //make GUI
    public void makeListOfAllResorts(ArrayList<Accomodation> list) {
        //create JFrame
        setTitle("Available accommodation");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        //make panel
        panel = new JPanel();
        TitledBorder border = BorderFactory.createTitledBorder("All accommodation");
        panel.setBorder(border);

        //make labels
        for(Accomodation accomodation:list){
            name=new JLabel("    "+accomodation.getName());
            type=new JLabel("    "+accomodation.getType());
            location=new JLabel("    "+accomodation.getLocation().returnLocation());
            avgScore=new JLabel("      Avg score: "+accomodation.averageScore());
            view=new JButton("view");
            panel.add(name);
            panel.add(type);
            panel.add(location);
            panel.add(avgScore);
            panel.add(view);
            view.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    ResortPreview rp=new ResortPreview(accomodation,userSystem);
                    rp.makePreview();
                }
            });
        }
        //no results occasion
        if(list.size()==0)emptyLabel();

        //add panel to frame
        panel.setLayout(new GridLayout(system.getListOfResorts().size(),5));
        add(panel,BorderLayout.CENTER);

        //make panel for back button
        JPanel panel2 = new JPanel();
        back=new JButton("back");
        panel2.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                closeButton();
            }
        });

        //add panel2 to frame
        GridLayout layout = new GridLayout(list.size(), 5);
        panel.setLayout(layout);
        add(panel2,BorderLayout.PAGE_END);

        pack();
        setVisible(true);
    }
}
