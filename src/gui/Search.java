package gui;

import api.*;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Search extends JFrame {
    private UserSystem userSystem;
    private Systemm system;
    private Facilities facilities;
    private static int radio;
    private static JLabel nameLabel;
    private static JLabel addressLabel;
    private static JLabel cityLabel;
    private static JLabel tkLabel;
    private static JTextField nameText;
    private static JTextField cityText;
    private static JTextField tkText;
    private static JTextField addressText;
    private static JRadioButton hotelRadioButton;
    private static JRadioButton flatRadioButton;
    private static JRadioButton maisonetteRadioButton;
    private static JButton searchButton;
    private static JButton facilitiesButton;

    public Search(UserSystem userSystem,Systemm system){
        this.userSystem=userSystem;
        this.system=system;
    }

    //close page
    public void closeButton(){this.setVisible(false);}
    //make search GUI
    public void makeSearchFrame(){
        //create JFrame
        setTitle("Search Page");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setSize(350,250);

        //make panel
        JPanel panel =new JPanel();
        TitledBorder border=BorderFactory.createTitledBorder("Search filters");
        panel.setBorder(border);
        GridLayout layout=new GridLayout(6,2);
        panel.setLayout(layout);

        //make location panel
        JPanel panel1=new JPanel();
        TitledBorder border1=BorderFactory.createTitledBorder("Location");
        panel1.setBorder(border1);
        GridLayout layout1=new GridLayout(3,2);
        panel1.setLayout(layout1);

        //name label
        nameLabel=new JLabel("Name");
        panel.add(nameLabel);
        //name textfield
        nameText=new JTextField(10);
        panel.add(nameText);

        //Address label
        addressLabel = new JLabel("Address");
        panel1.add(addressLabel);
        //address textfield
        addressText = new JTextField(10);
        panel1.add(addressText);
        //City label
        cityLabel = new JLabel("City");
        panel1.add(cityLabel);
        //city textfield
        cityText = new JTextField(10);
        panel1.add(cityText);
        //Tk label
        tkLabel = new JLabel("Postal code");
        panel1.add(tkLabel);
        //tk textfield
        tkText = new JTextField(10);
        panel1.add(tkText);

        //make radio buttons
        hotelRadioButton = new JRadioButton("hotel");
        flatRadioButton = new JRadioButton("flat");
        maisonetteRadioButton = new JRadioButton("maisonette");
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(hotelRadioButton);
        buttonGroup.add(flatRadioButton);
        buttonGroup.add(maisonetteRadioButton);
        radio = 0;
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

        //make panel for button
        JPanel panelButtons = new JPanel();

        //search button
        searchButton = new JButton("Search");
        searchButton.setBounds(100, 210, 200, 20);
        searchButton.setForeground(Color.BLACK);
        searchButton.setBackground(Color.WHITE);
        panelButtons.add(searchButton);
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name=nameText.getText();
                String address = addressText.getText();
                String city = cityText.getText();
                String tkk = tkText.getText();
                int tk;
                if(tkk.equals(""))tk=0;
                else tk=Integer.valueOf(tkk);

                ArrayList<Accomodation> list=new ArrayList<>();
                list=userSystem.accommodationSearch(name,radio,address,city,tk,facilities);

                ListOfAllResorts loar=new ListOfAllResorts(userSystem,system);
                loar.makeListOfAllResorts(list);

                closeButton();
            }
        });

        //add panels
        add(panelButtons, BorderLayout.PAGE_END);
        add(panel,BorderLayout.CENTER);
        add(panel1,BorderLayout.AFTER_LINE_ENDS);

        setVisible(true);
    }
}
