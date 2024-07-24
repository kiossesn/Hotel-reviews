package gui;

import api.Facilities;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class FacilitiesCheckBox extends JFrame {
    private Facilities f;
    private JCheckBox button1;
    private JCheckBox button2;
    private JCheckBox button3;
    private JCheckBox button4;
    private JCheckBox button5;
    private JCheckBox button6;
    private JCheckBox button7;
    private JCheckBox button8;
    private JCheckBox button9;
    private JCheckBox button10;
    private JCheckBox button11;
    private JCheckBox button12;
    private JCheckBox button13;
    private JCheckBox button14;
    private JCheckBox button15;
    private JCheckBox button16;
    private JCheckBox button17;
    private JCheckBox button18;
    private JCheckBox button19;
    private JCheckBox button20;
    private JCheckBox button21;
    private JCheckBox button22;
    private JCheckBox button23;
    private JCheckBox button24;
    private JCheckBox button25;
    private JCheckBox button26;
    private JCheckBox button27;
    private JButton doneButton;

    public FacilitiesCheckBox(Facilities f){
        if(f==null)f=new Facilities();
        this.f=f;
    }

    //close page
    public void closeButton(){this.setVisible(false);}

    public Facilities makeFacilities(){
        //crete JFrame
        setTitle("Facilities");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setLayout(new FlowLayout());
        setSize(600,450);

        //panel1
        JPanel panel1=new JPanel();
        TitledBorder border1 = BorderFactory.createTitledBorder("View");
        panel1.setBorder(border1);
        GridLayout layout1 = new GridLayout(0, 1);
        panel1.setLayout(layout1);

        button1=new JCheckBox("Pool");
        button2=new JCheckBox("Beach");
        button3=new JCheckBox("Sea");
        button4=new JCheckBox("Port");
        button5=new JCheckBox("Mountain");
        button6=new JCheckBox("Street");
        if(f.selectedOrNot('a',1))button1.setSelected(true);
        if(f.selectedOrNot('a',2))button2.setSelected(true);
        if(f.selectedOrNot('a',3))button3.setSelected(true);
        if(f.selectedOrNot('a',4))button4.setSelected(true);
        if(f.selectedOrNot('a',5))button5.setSelected(true);
        if(f.selectedOrNot('a',6))button6.setSelected(true);
        panel1.add(button1);
        panel1.add(button2);
        panel1.add(button3);
        panel1.add(button4);
        panel1.add(button5);
        panel1.add(button6);

        //panel2
        JPanel panel2=new JPanel();
        TitledBorder border2 = BorderFactory.createTitledBorder("WC");
        panel2.setBorder(border2);
        panel2.setLayout(layout1);

        button7=new JCheckBox("Blow dryer");
        if(f.selectedOrNot('b',1))button7.setSelected(true);
        panel2.add(button7);

        //panel3
        JPanel panel3=new JPanel();
        TitledBorder border3 = BorderFactory.createTitledBorder("Clothes");
        panel3.setBorder(border3);
        panel3.setLayout(layout1);

        button8=new JCheckBox("Washing machine");
        if(f.selectedOrNot('c',1))button8.setSelected(true);
        panel3.add(button8);
        button9=new JCheckBox("Clothe dryer");
        if(f.selectedOrNot('c',2))button9.setSelected(true);
        panel3.add(button9);

        //panel4
        JPanel panel4=new JPanel();
        TitledBorder border4 = BorderFactory.createTitledBorder("Tv");
        panel4.setBorder(border4);
        panel4.setLayout(layout1);

        button10=new JCheckBox("Tv");
        if(f.selectedOrNot('d',1))button10.setSelected(true);
        panel4.add(button10);

        //panel5
        JPanel panel5=new JPanel();
        TitledBorder border5 = BorderFactory.createTitledBorder("Climate");
        panel5.setBorder(border5);
        panel5.setLayout(layout1);

        button11=new JCheckBox("Fireplace");
        if(f.selectedOrNot('e',1))button11.setSelected(true);
        panel5.add(button11);
        button12=new JCheckBox("A/C");
        if(f.selectedOrNot('e',2))button12.setSelected(true);
        panel5.add(button12);
        button13=new JCheckBox("Central heat");
        if(f.selectedOrNot('e',3))button13.setSelected(true);
        panel5.add(button13);

        //panel6
        JPanel panel6=new JPanel();
        TitledBorder border6 = BorderFactory.createTitledBorder("Internet");
        panel6.setBorder(border6);
        panel6.setLayout(layout1);

        button14=new JCheckBox("WiFi");
        if(f.selectedOrNot('f',1))button14.setSelected(true);
        panel6.add(button14);
        button15=new JCheckBox("Ethernet");
        if(f.selectedOrNot('f',2))button15.setSelected(true);
        panel6.add(button15);

        //panel7
        JPanel panel7=new JPanel();
        TitledBorder border7 = BorderFactory.createTitledBorder("Kitchen");
        panel7.setBorder(border7);
        panel7.setLayout(layout1);

        button16=new JCheckBox("Kitchen");
        if(f.selectedOrNot('g',1))button16.setSelected(true);
        panel7.add(button16);
        button17=new JCheckBox("Fridge");
        if(f.selectedOrNot('g',2))button17.setSelected(true);
        panel7.add(button17);
        button18=new JCheckBox("Microwave");
        if(f.selectedOrNot('g',3))button18.setSelected(true);
        panel7.add(button18);
        button19=new JCheckBox("Kitchen equipment");
        if(f.selectedOrNot('g',4))button19.setSelected(true);
        panel7.add(button19);
        button20=new JCheckBox("Dishes");
        if(f.selectedOrNot('g',5))button20.setSelected(true);
        panel7.add(button20);
        button21=new JCheckBox("Cutlery");
        if(f.selectedOrNot('g',6))button21.setSelected(true);
        panel7.add(button21);
        button22=new JCheckBox("Dish washer");
        if(f.selectedOrNot('g',7))button22.setSelected(true);
        panel7.add(button22);
        button23=new JCheckBox("Coffee machine");
        if(f.selectedOrNot('g',8))button23.setSelected(true);
        panel7.add(button23);

        //panel8
        JPanel panel8=new JPanel();
        TitledBorder border8 = BorderFactory.createTitledBorder("Outer space");
        panel8.setBorder(border8);
        panel8.setLayout(layout1);

        button24=new JCheckBox("Balcony");
        if(f.selectedOrNot('h',1))button24.setSelected(true);
        panel8.add(button24);
        button25=new JCheckBox("Back yard");
        if(f.selectedOrNot('h',2))button25.setSelected(true);
        panel8.add(button25);

        //panel9
        JPanel panel9=new JPanel();
        TitledBorder border9 = BorderFactory.createTitledBorder("Parking");
        panel9.setBorder(border9);
        panel9.setLayout(layout1);

        button26=new JCheckBox("Garage");
        if(f.selectedOrNot('i',1))button26.setSelected(true);
        panel9.add(button26);
        button27=new JCheckBox("Street parking");
        if(f.selectedOrNot('i',2))button27.setSelected(true);
        panel9.add(button27);

        //done button
        doneButton=new JButton("Done");
        add(doneButton);
        doneButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {closeButton();}
        });


        //add panels to frame
        add(panel1);
        add(panel2);
        add(panel3);
        add(panel4);
        add(panel5);
        add(panel6);
        add(panel7);
        add(panel8);
        add(panel9);

        //action listener for every checkbox
        ActionListener actionListener= new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                    f.setFacilitiesToFalse();
                    if (button1.isSelected()) {
                        f.addfacilities('a', 1);
                    }
                    if (button2.isSelected()) {
                        f.addfacilities('a', 2);
                    }
                    if (button3.isSelected()) {
                        f.addfacilities('a', 3);
                    }
                    if (button4.isSelected()) {
                        f.addfacilities('a', 4);
                    }
                    if (button5.isSelected()) {
                        f.addfacilities('a', 5);
                    }
                    if (button6.isSelected()) {
                        f.addfacilities('a', 6);
                    }
                    if (button7.isSelected()) {
                        f.addfacilities('b', 1);
                    }
                    if (button8.isSelected()) {
                        f.addfacilities('c', 1);
                    }
                    if (button9.isSelected()) {
                        f.addfacilities('c', 2);
                    }
                    if (button10.isSelected()) {
                        f.addfacilities('d', 1);
                    }
                    if (button11.isSelected()) {
                        f.addfacilities('e', 1);
                    }
                    if (button12.isSelected()) {
                        f.addfacilities('e', 2);
                    }
                    if (button13.isSelected()) {
                        f.addfacilities('e', 3);
                    }
                    if (button14.isSelected()) {
                        f.addfacilities('f', 1);
                    }
                    if (button15.isSelected()) {
                        f.addfacilities('f', 2);
                    }
                    if (button16.isSelected()) {
                        f.addfacilities('g', 1);
                    }
                    if (button17.isSelected()) {
                        f.addfacilities('g', 2);
                    }
                    if (button18.isSelected()) {
                        f.addfacilities('g', 3);
                    }
                    if (button19.isSelected()) {
                        f.addfacilities('g', 4);
                    }
                    if (button20.isSelected()) {
                        f.addfacilities('g', 5);
                    }
                    if (button21.isSelected()) {
                        f.addfacilities('g', 6);
                    }
                    if (button22.isSelected()) {
                        f.addfacilities('g', 7);
                    }
                    if (button23.isSelected()) {
                        f.addfacilities('g', 8);
                    }
                    if (button24.isSelected()) {
                        f.addfacilities('h', 1);
                    }
                    if (button25.isSelected()) {
                        f.addfacilities('h', 2);
                    }
                    if (button26.isSelected()) {
                        f.addfacilities('i', 1);
                    }
                    if (button27.isSelected()) {
                        f.addfacilities('i', 2);
                    }
            }
        };
        doneButton.addActionListener(actionListener);

        setVisible(true);
        return f;
    }
}
