package com.mycompany.swingdemo.components;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class SidebarComponentDemo {

    public static void main(String args[]) {

        var profile = new JPanel();
        profile.setBackground(Color.RED);
        var friendsList = new JPanel();
        friendsList.setBackground(Color.BLUE);

        var sidebarComponent = new SidebarComponent(profile, friendsList);
        sidebarComponent.setBackground(Color.YELLOW);

        var mainframe = new JFrame("SidebarComponent Demo");
        mainframe.getContentPane().setLayout(new GridBagLayout());
        var constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.BOTH;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weightx = 1;
        constraints.weighty = 1;
        mainframe.getContentPane().add(sidebarComponent, constraints);
        mainframe.setSize(new Dimension(300, 500));
        mainframe.setMaximumSize(new Dimension(300, -1));
        mainframe.setVisible(true);
        mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}