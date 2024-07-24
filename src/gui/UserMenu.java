package gui;

import api.Systemm;
import api.User;
import api.UserSystem;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.basic.BasicArrowButton;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserMenu extends JFrame{
    private Systemm system;
    private UserSystem userSystem;
    private User user;
    private static JButton SearchButton;
    private static JButton DashboardButton;
    private static JButton logoutButton;


    public UserMenu(Systemm system, UserSystem userSystem){
        this.userSystem=userSystem;
        this.user=userSystem.getUser();
        this.system=system;
    }
    //close page
    public void closeButton(){
        this.setVisible(false);
    }
    //make user menu GUI
    public void makeUserMenu() {
        //create JFrame
        setTitle("User options");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setSize(300, 200);

        //make login panel
        JPanel panel =new JPanel();
        TitledBorder border=BorderFactory.createTitledBorder("Functions");
        panel.setBorder(border);
        GridLayout layout=new GridLayout(4,2);
        panel.setLayout(layout);

        //make search button
        SearchButton=new JButton("Search for Accommodation");
        panel.add(SearchButton);
        SearchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Search s=new Search(userSystem,system);
                s.makeSearchFrame();
            }
        });

        //dashboard button
        DashboardButton=new JButton("Your dashboard");
        panel.add(DashboardButton);
        DashboardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UserDashboard ud=new UserDashboard(user,userSystem);
                ud.makeDashboard();
            }
        });

        //logout button
        logoutButton=new JButton("Log-out");
        panel.add(logoutButton);
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                closeButton();
            }
        });
        //add panel to frame
        add(panel,BorderLayout.CENTER);

        setVisible(true);
    }
}
