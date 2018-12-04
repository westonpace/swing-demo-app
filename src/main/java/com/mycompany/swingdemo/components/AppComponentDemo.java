package com.mycompany.swingdemo.components;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class AppComponentDemo {

    public static void main(String args[]) {

        var sidebar = new JPanel();
        sidebar.setBackground(Color.RED);
        var content = new JPanel();
        content.setBackground(Color.BLUE);

        var appComponent = new AppComponent(sidebar, content);
        appComponent.setBackground(Color.YELLOW);

        var mainframe = new JFrame("AppComponent Demo");
        mainframe.getContentPane().setLayout(new GridBagLayout());
        var constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.BOTH;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weightx = 1;
        constraints.weighty = 1;
        mainframe.getContentPane().add(appComponent, constraints);
        mainframe.setSize(new Dimension(500, 500));
        mainframe.setVisible(true);
        mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}