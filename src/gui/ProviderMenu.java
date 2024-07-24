package gui;

import api.Provider;
import api.ProviderSystem;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.basic.BasicArrowButton;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProviderMenu extends JFrame{
    private ProviderSystem providerSystem;
    private Provider provider;
    private static JButton RegistrationButton;
    private static JButton DashboardButton;
    private static JButton logoutButton;

    ProviderMenu(Provider provider,ProviderSystem providerSystem){
        this.providerSystem=providerSystem;
        this.provider=provider;
    }
    //close page
    public void closeButton(){
        this.setVisible(false);
    }
    public void makeProviderMenu() {
        //create JFrame
        setTitle("Provider options");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setSize(300, 300);

        //make login panel
        JPanel panel =new JPanel();
        TitledBorder border=BorderFactory.createTitledBorder("Functions");
        panel.setBorder(border);
        GridLayout layout=new GridLayout(5,1);
        panel.setLayout(layout);

        //make buttons
        RegistrationButton=new JButton("New accommodation register");
        panel.add(RegistrationButton);
        DashboardButton=new JButton("Your dashboard");
        panel.add(DashboardButton);
        //action listener for dashboard button
        DashboardButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                ProviderDashboard pd=new ProviderDashboard(providerSystem);
                pd.makeDashboard();
            }
        });
        logoutButton=new JButton("Log-out");
        panel.add(logoutButton);
        //action listener for logout button
        logoutButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                closeButton();
            }
        });
        //action listener for registration button
        ActionListener listener=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NewAccommodationRegister nar=new NewAccommodationRegister(providerSystem);
                nar.makeRegister();

            }
        };
        RegistrationButton.addActionListener(listener);


        //add panel to frame
        add(panel,BorderLayout.CENTER);

        setVisible(true);
    }

}
