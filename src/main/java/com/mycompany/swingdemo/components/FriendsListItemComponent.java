package com.mycompany.swingdemo.components;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.mycompany.Theme;
import com.mycompany.swingdemo.model.Friend;
import com.mycompany.swingdemo.services.ProfilePhotosService;

public class FriendsListItemComponent extends JPanel {

    private JLabel photo = new JLabel();
    private JLabel name = new JLabel();
    private JComponent spacer = new JLabel();
    private JLabel rightArrow = new JLabel(">");

    public FriendsListItemComponent(Friend friend, ProfilePhotosService profilePhotosService) {
        profilePhotosService.getProfilePhotoFor(friend.name).subscribe(profilePhoto -> {
            this.updateProfilePhoto(profilePhoto);
        });
        this.name.setText(friend.name);
        this.initialize();
    }

    private void initialize() {
        this.setBackground(Theme.PRIMARY);
        this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        this.setPreferredSize(new Dimension(-1, 64));
        this.setLayout(new GridBagLayout());
        var constraints = new GridBagConstraints();

        constraints.gridheight = 1;
        constraints.gridwidth = 1;
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weightx = 0;
        constraints.weighty = 0;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.insets = new Insets(16, 16, 16, 16);
        this.add(photo, constraints);

        constraints.gridx = 1;
        name.setForeground(Theme.PRIMARY_TEXT);
        this.add(name, constraints);

        constraints.gridx = 2;
        constraints.weightx = 1;
        this.add(spacer, constraints);

        constraints.gridx = 3;
        constraints.weightx = 0;
        rightArrow.setForeground(Theme.PRIMARY_TEXT);
        this.add(rightArrow, constraints);
    }

    private void updateProfilePhoto(BufferedImage profilePhoto) {
        if (profilePhoto == null) {
            photo.setIcon(null);
        } else {
            photo.setIcon(new ImageIcon(profilePhoto));
        }
        this.repaint();
    }

}