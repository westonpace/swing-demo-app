package com.mycompany.swingdemo.components;

import java.awt.GridBagLayout;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.mycompany.swingdemo.services.ProfilePhotosService;

public class ProfilePhotoComponent extends JPanel {

    private JLabel imageLabel;

    public ProfilePhotoComponent(ProfilePhotosService profilePhotoService) {
        profilePhotoService.getCurrentUsersProfilePhoto().subscribe(profilePhoto -> this.updateProfilePhoto(profilePhoto));
        this.initialize();
    }

    private void updateProfilePhoto(BufferedImage profilePhoto) {
        if(profilePhoto == null) {
            this.imageLabel.setIcon(null);
        } else {
            this.imageLabel.setIcon(new ImageIcon(profilePhoto));
        }
        this.repaint();
    }

    private void initialize() {
        this.imageLabel = new JLabel();
        this.setLayout(new GridBagLayout());
        this.add(imageLabel);
    }

}