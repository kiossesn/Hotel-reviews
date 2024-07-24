package gui;

import api.*;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserDashboard extends JFrame {
    private UserSystem userSystem;
    private User user;
    private static JLabel name;
    private static JLabel type;
    private static JLabel location;
    private static JLabel score;
    private static JLabel avgScore;
    private static JButton closePageButton;
    private static JLabel empty;
    private static JPanel panel;
    private static JPanel panel2;
    private static JButton view;

    public UserDashboard(User user,UserSystem userSystem){
        this.userSystem=userSystem;
        this.user=user;
    }
    //close page
    public void closeButton(){this.setVisible(false);}
    //empty list
    public void emptyLabel(){
        empty=new JLabel("You have no reviewed");
        panel.add(empty);
    }
    //make user dashboard GUI
    public void makeDashboard() {
        //create JFrame
        setTitle("Dashboard page");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setLayout(new GridLayout(2, 1));

        //make panel1
        panel = new JPanel();
        TitledBorder border = BorderFactory.createTitledBorder("Reviewed");
        panel.setBorder(border);

        //make labels
        double sum=0.0;
        int k=0;
        if (user.getMyReviewed().size() != 0) {
            for (Accomodation a : user.getMyReviewed()) {
                k++;
                name = new JLabel("    " + a.getName());
                type = new JLabel("    " + a.getType());
                location = new JLabel("    " + a.getLocation().returnLocation());
                panel.add(name);
                panel.add(type);
                panel.add(location);
                //search listOfReviews of each resort
                for (Review b : a.getListOfReviews()) {
                    if (b.getFirstName().equals(user.getName())) {
                        score = new JLabel("        My score: " + b.getScore());
                        panel.add(score);
                        sum += b.getScore();
                        break;
                    }
                }
                view= new JButton("view");
                panel.add(view);
                view.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        ResortPreview rp=new ResortPreview(a,userSystem);
                        rp.makePreview();
                    }
                });
            }
        }
        else emptyLabel();

        //set layout
        GridLayout layout = new GridLayout(k, 5);
        panel.setLayout(layout);
        //add panel on frame
        add(panel,BorderLayout.CENTER);

        //make panel2
        panel2 = new JPanel();
        TitledBorder border2 = BorderFactory.createTitledBorder("Stats");
        panel2.setBorder(border2);

        //make labels
        if(user.getMyReviewed().size() != 0) avgScore=new JLabel("    Avg score: "+sum/user.getMyReviewed().size());
        else avgScore=new JLabel("    Avg score: "+0);
        panel2.add(avgScore);

        //make close button
        closePageButton = new JButton("back");
        panel2.add(closePageButton);
        //action listener for close button
        closePageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {closeButton();}
        });

        //add panel2 on frame
        if(k>=2)panel2.setLayout(layout);
        else panel2.setLayout(new GridLayout(2,1));
        add(panel2);

        pack();
        setVisible(true);
    }
}
