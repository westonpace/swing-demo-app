package com.mycompany.swingdemo.components;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.mycompany.swingdemo.model.Friend;
import com.mycompany.swingdemo.services.ProfilePhotosService;

public class FriendsListItemComponent extends JPanel {

    private JLabel photo = new JLabel();

    public FriendsListItemComponent(Friend friend, ProfilePhotosService profilePhotosService) {
        profilePhotosService.getProfilePhotoFor(friend.name).subscribe(profilePhoto -> {
            this.updateProfilePhoto(profilePhoto);
        });
        this.initialize();
    }

    private void initialize() {
        this.setLayout(new GridBagLayout());
        var constraints = new GridBagConstraints();
        constraints.gridheight = 1;
        constraints.gridwidth = 1;
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weightx = 1;
        constraints.weighty = 1;
        constraints.fill = GridBagConstraints.BOTH;
        this.add(photo, constraints);
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