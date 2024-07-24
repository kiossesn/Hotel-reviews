package gui;

import api.Accomodation;
import api.Provider;
import api.ProviderSystem;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProviderDashboard extends JFrame {
    private ProviderSystem providerSystem;
    private Provider provider;
    private static JLabel totalReviews;
    private static JLabel totalAvgScore;
    private static JLabel name;
    private static JLabel type;
    private static JLabel location;
    private static JLabel avgScore;
    private static JButton closePageButton;
    private static JLabel empty;
    private static JPanel panel;
    private static JPanel panel2;
    private static JButton view;

    public ProviderDashboard(ProviderSystem providerSystem){
        this.providerSystem=providerSystem;
        this.provider=providerSystem.getProvider();
    }

    //close page
    public void closeButton(){this.setVisible(false);}
    //empty list
    public void emptyLabel(){
        empty=new JLabel("You have no registrations");
        panel.add(empty);
    }
    //make provider dashboard GUI
    public void makeDashboard() {
        //create JFrame
        setTitle("Dashboard page");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setLayout(new GridLayout(2,1));

        //make panel1
        panel = new JPanel();
        TitledBorder border = BorderFactory.createTitledBorder("Registrations");
        panel.setBorder(border);

        //make panel2
        panel2 = new JPanel();
        TitledBorder border2 = BorderFactory.createTitledBorder("Stats");
        panel2.setBorder(border2);

        int k=0;
        //make and add labels on panels
        if(provider.getMyResorts().size()!=0) {
            for (Accomodation a : provider.getMyResorts()) {
                k++;
                name = new JLabel("    " + a.getName());
                type = new JLabel("    " + a.getType());
                location = new JLabel("    " + a.getLocation().returnLocation());
                avgScore = new JLabel("      Avg score: " + a.averageScore());
                view=new JButton("view");

                panel.add(name);
                panel.add(type);
                panel.add(location);
                panel.add(avgScore);
                panel.add(view);
                view.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        ResortPreview rp=new ResortPreview(a,providerSystem);
                        rp.makePreview();
                    }
                });
            }
        }
        else{emptyLabel();}
        totalReviews=new JLabel("Total reviews: "+provider.getTotalReviews());
        totalAvgScore=new JLabel("Average score: "+provider.getAverageScore());
        panel2.add(totalReviews);
        panel2.add(totalAvgScore);

        //make close button and add on panel2
        closePageButton=new JButton("back");
        panel2.add(closePageButton);
        //action listener for close button
        closePageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {closeButton();}
        });

        //set layout
        GridLayout layout = new GridLayout(k,10);
        panel.setLayout(layout);
        if(k>=2)panel2.setLayout(layout);
        else panel2.setLayout(new GridLayout(2,1));

        //add panels
        add(panel);
        add(panel2);

        pack();
        setVisible(true);
    }
}
