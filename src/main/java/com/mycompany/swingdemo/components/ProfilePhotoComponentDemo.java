package com.mycompany.swingdemo.components;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import com.mycompany.swingdemo.services.ProfilePhotosService;

public class ProfilePhotoComponentDemo {

    public static void main(String args[]) throws Exception {

        var profilePhotoService = new ProfilePhotosService();
        var profilePhotoComponent = new ProfilePhotoComponent(profilePhotoService);

        var mainframe = new JFrame("ProfilePhotoComponent Demo");
        mainframe.getContentPane().setLayout(new GridBagLayout());
        var constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.BOTH;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weightx = 1;
        constraints.weighty = 1;
        mainframe.getContentPane().add(profilePhotoComponent, constraints);
        mainframe.setSize(new Dimension(300, 300));
        mainframe.setMaximumSize(new Dimension(300, -1));
        mainframe.setVisible(true);
        mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        var puppies = clipImage(ImageIO.read(ProfilePhotoComponentDemo.class.getResource("/assets/images/puppies.jpg")));
        var kittens = clipImage(ImageIO.read(ProfilePhotoComponentDemo.class.getResource("/assets/images/kittens.jpg")));
        var activeImage = puppies;

        while(true) {
            if (activeImage == puppies) {
                activeImage = kittens;
            } else {
                activeImage = puppies;
            }
            profilePhotoService.setCurrentUsersProfilePhoto(activeImage);
            Thread.sleep(3000);
        }
    }

    private static BufferedImage clipImage(BufferedImage image) {
        var width = image.getWidth();
        var xExcess = width - 128;
        var x = Math.round(xExcess / 2.0);
        
        var height = image.getHeight();
        var yExcess = height - 128;
        var y = Math.round(yExcess / 2.0);

        return image.getSubimage((int)x, (int)y, 128, 128);
    }

}