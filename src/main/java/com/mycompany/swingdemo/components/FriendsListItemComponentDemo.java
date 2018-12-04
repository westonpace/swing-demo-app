package com.mycompany.swingdemo.components;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;

import com.mycompany.swingdemo.model.Friend;
import com.mycompany.swingdemo.services.ProfilePhotosService;

public class FriendsListItemComponentDemo {

    public static void main(String args[]) throws Exception {

        var profilePhotoService = new ProfilePhotosService();
        var friend = new Friend();
        friend.name = "kittens";
        var friendsListItemComponent = new FriendsListItemComponent(friend, profilePhotoService);

        var mainframe = new JFrame("FriendsListItemComponent Demo");
        mainframe.getContentPane().setLayout(new GridBagLayout());
        var constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.BOTH;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weightx = 1;
        constraints.weighty = 0;
        mainframe.getContentPane().add(friendsListItemComponent, constraints);
        mainframe.setSize(new Dimension(600, 300));
        mainframe.setMaximumSize(new Dimension(300, -1));
        mainframe.setVisible(true);
        mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}