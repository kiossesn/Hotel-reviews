package gui;

import api.*;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewAccommodationRegister extends JFrame {
    private ProviderSystem providerSystem;
    private Facilities facilities;
    private static int radio;
    private static JLabel nameLabel;
    private static JLabel addressLabel;
    private static JLabel cityLabel;
    private static JLabel tkLabel;
    private static JLabel descriptionLabel;
    private static JTextField nameText;
    private static JTextField cityText;
    private static JTextField tkText;
    private static JTextField addressText;
    private static JTextField descriptionText;
    private static JButton registerButton;
    private static JButton facilitiesButton;
    private static JLabel success;
    private static JRadioButton hotelRadioButton;
    private static JRadioButton flatRadioButton;
    private static JRadioButton maisonetteRadioButton;

    public NewAccommodationRegister(ProviderSystem providerSystem){
        facilities=null;
        this.providerSystem=providerSystem;
    }

    //label when there are gaps
    public void fillin(){
        success.setText("Fill in the required fields!");
    }
    //register approved label
    public void approve(){
        success.setText("Register approved!");
    }

    //close page
    public void closeButton(){this.setVisible(false);}

    public void makeRegister() {
        //create JFrame
        setTitle("Register Accommodation");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setSize(350, 250);

        //make panel
        JPanel panel = new JPanel();
        TitledBorder border = BorderFactory.createTitledBorder("Registration form");
        panel.setBorder(border);
        GridLayout layout = new GridLayout(8, 2);
        panel.setLayout(layout);

        //name label
        nameLabel = new JLabel("Name");
        panel.add(nameLabel);
        //name textfield
        nameText = new JTextField(10);
        panel.add(nameText);

        //Address label
        addressLabel = new JLabel("Address");
        panel.add(addressLabel);
        //address textfield
        addressText = new JTextField(10);
        panel.add(addressText);
        //City label
        cityLabel = new JLabel("City");
        panel.add(cityLabel);
        //city textfield
        cityText = new JTextField(10);
        panel.add(cityText);
        //Tk label
        tkLabel = new JLabel("Postal code");
        panel.add(tkLabel);
        //tk textfield
        tkText = new JTextField(10);
        panel.add(tkText);

        //Description label
        descriptionLabel = new JLabel("Description");
        panel.add(descriptionLabel);
        //description textfield
        descriptionText = new JTextField(10);
        panel.add(descriptionText);

        //make radio buttons
        hotelRadioButton = new JRadioButton("hotel");
        flatRadioButton = new JRadioButton("flat");
        maisonetteRadioButton = new JRadioButton("maisonette");
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(hotelRadioButton);
        buttonGroup.add(flatRadioButton);
        buttonGroup.add(maisonetteRadioButton);
        hotelRadioButton.doClick();
        radio = 1;
        panel.add(hotelRadioButton);
        panel.add(flatRadioButton);
        panel.add(maisonetteRadioButton);
        ActionListener listener=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(hotelRadioButton.isSelected())radio=1;
                if(flatRadioButton.isSelected())radio=2;
                if(maisonetteRadioButton.isSelected())radio=3;
            }
        };
        hotelRadioButton.addActionListener(listener);
        flatRadioButton.addActionListener(listener);
        maisonetteRadioButton.addActionListener(listener);

        //empty label
        JLabel empty = new JLabel("");
        panel.add(empty);

        //success label
        success=new JLabel("");
        success.setBounds(10,110,300,25);
        panel.add(success);

        //facilities button
        facilitiesButton=new JButton("add facilities");
        facilitiesButton.setBounds(100, 210, 200, 20);
        panel.add(facilitiesButton);
        facilitiesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                facilities=new Facilities();
                FacilitiesCheckBox fcb=new FacilitiesCheckBox(facilities);
                facilities=fcb.makeFacilities();
            }
        });

        //add panel to frame
        add(panel, BorderLayout.CENTER);

        //make panel for register button
        JPanel panelButtons = new JPanel();

        //register button
        registerButton = new JButton("Register");
        registerButton.setBounds(100, 210, 200, 20);
        registerButton.setForeground(Color.BLACK);
        registerButton.setBackground(Color.WHITE);
        panelButtons.add(registerButton);
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameText.getText();
                String address = addressText.getText();
                String city = cityText.getText();
                String tkk = tkText.getText();
                int tk;
                if(tkk.equals(""))tk=0;
                else tk=Integer.valueOf(tkk);
                String description = descriptionText.getText();
                if(nameText.getText().isEmpty()||address.equals("")||city.equals("")||tkk.equals("")) fillin();
                else {
                    providerSystem.accommodationRegister(providerSystem.getProvider(),name,radio,address,city,tk,description,facilities);
                    approve();
                    closeButton();
                }
            }
        });

        //add panel for buttons on frame
        add(panelButtons, BorderLayout.PAGE_END);

        setVisible(true);
    }

}
