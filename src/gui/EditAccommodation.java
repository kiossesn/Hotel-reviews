package gui;

import api.Accomodation;
import api.Facilities;
import api.ProviderSystem;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditAccommodation extends JFrame {
    private Accomodation a;
    private ProviderSystem providerSystem;
    Facilities facilities;
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

    public EditAccommodation(Accomodation a, ProviderSystem providerSystem){
        this.a=a;
        this.facilities=a.getFacilities();
        this.providerSystem=providerSystem;
    }

    //label when there are gaps
    public void fillin(){
        success.setText("Fill in the required fields!");
    }
    //close page
    public void closeButton(){this.setVisible(false);}

    public void makeEdit() {
        //create JFrame
        setTitle("Edit Accommodation page");
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
        nameText.setText(a.getName());
        panel.add(nameText);

        //Address label
        addressLabel = new JLabel("Address");
        panel.add(addressLabel);
        //address textfield
        addressText = new JTextField(10);
        addressText.setText(a.getLocation().getAddress());
        panel.add(addressText);
        //City label
        cityLabel = new JLabel("City");
        panel.add(cityLabel);
        //city textfield
        cityText = new JTextField(10);
        cityText.setText(a.getLocation().getCity());
        panel.add(cityText);
        //Tk label
        tkLabel = new JLabel("Postal code");
        panel.add(tkLabel);
        //tk textfield
        tkText = new JTextField(10);
        tkText.setText(String.valueOf(a.getLocation().getTk()));
        panel.add(tkText);

        //Description label
        descriptionLabel = new JLabel("Description");
        panel.add(descriptionLabel);
        //description textfield
        descriptionText = new JTextField(10);
        descriptionText.setText(a.getDescription());
        panel.add(descriptionText);

        //make radio buttons
        hotelRadioButton = new JRadioButton("hotel");
        flatRadioButton = new JRadioButton("flat");
        maisonetteRadioButton = new JRadioButton("maisonette");
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(hotelRadioButton);
        buttonGroup.add(flatRadioButton);
        buttonGroup.add(maisonetteRadioButton);
        if(a.getType().equals("Hotel")){
            hotelRadioButton.doClick();
            radio = 1;
        }
        else if(a.getType().equals("Apartment")){
            flatRadioButton.doClick();
            radio=2;
        }
        else{
            maisonetteRadioButton.doClick();
            radio=3;
        }
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
        facilitiesButton=new JButton("edit facilities");
        facilitiesButton.setBounds(100, 210, 200, 20);
        panel.add(facilitiesButton);
        facilitiesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FacilitiesCheckBox fcb=new FacilitiesCheckBox(a.getFacilities());
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
                if (e.getActionCommand().equals("Register")) {
                    String name = nameText.getText();
                    String address = addressText.getText();
                    String city = cityText.getText();
                    String tkk = tkText.getText();
                    int tk;
                    if(tkk.equals(""))tk=0;
                    else tk=Integer.valueOf(tkk);
                    String description = descriptionText.getText();
                    if(name.equals("")||address.equals("")||city.equals("")||tkk.equals("")) fillin();
                    else {
                    providerSystem.editAccommodation(a,name,radio,a.getLocation(),address,city,tk,description,facilities);
                    closeButton();
                    }
                }
            }
        });


        //add panel for buttons on frame
        add(panelButtons, BorderLayout.PAGE_END);


        setVisible(true);
    }
}
