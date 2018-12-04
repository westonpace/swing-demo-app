package com.mycompany.swingdemo.components;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JComponent;
import javax.swing.JPanel;

public class AppComponent extends JPanel {
    
    private JComponent sidebar;
    private JComponent content;

    public AppComponent(JComponent sidebar, JComponent content) {
        this.sidebar = sidebar;
        this.content = content;
        this.initialize();
    }

    public void initialize() {
        // Make a row, 25% sidebar and 75% content
        // sidebar max width set to 300px
        this.sidebar.setMinimumSize(new Dimension(300, 0));
        this.sidebar.setPreferredSize(new Dimension(300, 0));

        this.setLayout(new GridBagLayout());
        var constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.BOTH;
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weightx = 0;
        constraints.weighty = 1;

        this.add(this.sidebar, constraints);

        constraints.weightx = 0.75;
        constraints.gridwidth = 3;
        constraints.gridx = 1;
        this.add(this.content, constraints);
    }

}