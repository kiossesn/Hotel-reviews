package gui;
import api.*;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.*;

public class Login extends JFrame {
    private Provider provider;
    private User user;

    private static JLabel usernameLabel;
    private static JTextField usernameText;
    private static JLabel passwordLabel;
    private static JPasswordField passwordText;
    private static JButton loginButton;
    private static JButton registerButton;
    private static JLabel success;
    private static JButton close;

    //login approved label
    public void approve(){
       success.setText("Login approved!");
    }
    //login failed label
    public void disapprove(){
        success.setText("Login failed, try again!");
    }
    //make login GUI
    public void makeLogin(Systemm system) {
        //create JFrame
        setTitle("Login Page");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setSize(300,200);

        //make login panel
        JPanel panel =new JPanel();
        TitledBorder border=BorderFactory.createTitledBorder("Log in");
        panel.setBorder(border);
        GridLayout layout=new GridLayout(4,2);
        panel.setLayout(layout);

        //username label
        usernameLabel=new JLabel("Username");
        panel.add(usernameLabel);
        //username textfield
        usernameText=new JTextField(10);
        panel.add(usernameText);

        //password label
        passwordLabel=new JLabel("Password");
        panel.add(passwordLabel);
        //password textfield
        passwordText=new JPasswordField(10);
        panel.add(passwordText);

        //success label
        success=new JLabel("");
        success.setBounds(10,110,300,25);
        panel.add(success);

        //add panel to frame
        add(panel,BorderLayout.CENTER);

        //make panel for buttons
        JPanel panelButtons=new JPanel();

        //login button
        loginButton=new JButton("Login");
        loginButton.setForeground(Color.WHITE);
        loginButton.setBackground(Color.BLACK);
        panelButtons.add(loginButton);

        //register button
        registerButton=new JButton("Register");
        registerButton.setBounds(100, 210, 200, 20);
        registerButton.setForeground(Color.BLACK);
        registerButton.setBackground(Color.WHITE);
        panelButtons.add(registerButton);

        //add panel for buttons on frame
        add(panelButtons,BorderLayout.PAGE_END);

        //action listener for the two buttons
        ActionListener listener=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getActionCommand().equals("Login")){
                    String username =usernameText.getText();
                    String password =passwordText.getText();
                    Person person = system.login(username,password);
                    if(person==null) disapprove();
                    else {
                        approve();
                        if(system.userOrProvider(person)==1){
                            provider=(Provider)person;
                            ProviderSystem providerSystem=new ProviderSystem(provider,system);
                            ProviderMenu providerMenu=new ProviderMenu(provider,providerSystem);
                            providerMenu.makeProviderMenu();
                        }
                        else{
                            user=(User)person;
                            UserSystem userSystem=new UserSystem(user,system);
                            UserMenu userMenu=new UserMenu(system,userSystem);
                            userMenu.makeUserMenu();
                        }
                    }
                }
                if(e.getActionCommand().equals("Register")){
                    Register register=new Register();
                    register.makeRegister(system);

                }
            }
        };
        loginButton.addActionListener(listener);
        registerButton.addActionListener(listener);

        //close button
        close=new JButton("Terminate");
        panelButtons.add(close);
        close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.saveInFiles();
                System.exit(0);
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        //make a system
        Systemm system= new Systemm();
        //make login GUI for the system
        Login lo=new Login();
        lo.makeLogin(system);
    }

}

