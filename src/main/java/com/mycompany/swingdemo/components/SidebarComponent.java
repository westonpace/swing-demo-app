package com.mycompany.swingdemo.components;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JComponent;
import javax.swing.JPanel;

public class SidebarComponent extends JPanel {

    private JComponent profile;
    private JComponent friendsList;

    public SidebarComponent(JPanel profile, JPanel friendsList) {
        this.profile = profile;
        this.friendsList = friendsList;
        this.initialize();
    }

    public void initialize() {
        // Make a row, 25% sidebar and 75% content
        // sidebar max width set to 300px
        this.profile.setMinimumSize(new Dimension(300, 300));
        this.profile.setPreferredSize(new Dimension(300, 300));

        this.setLayout(new GridBagLayout());
        var constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.BOTH;
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weightx = 1;
        constraints.weighty = 0;

        this.add(this.profile, constraints);

        constraints.weighty = 1;
        constraints.gridheight = 3;
        constraints.gridy = 1;
        this.add(this.friendsList, constraints);
    }

}