package com.mycompany.swingdemo.commands;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class FetchProfileImageCommand extends Command<BufferedImage> {

    private String name;
    private int width;
    private int height;

    public FetchProfileImageCommand(String name, int width, int height) {
        this.name = name;
        this.width = width;
        this.height = height;
    }

    @Override
    protected BufferedImage runCommand() throws Exception {
        var imageUrl = FetchProfileImageCommand.class.getResource("/assets/images/" + this.name + ".jpg");
        if (imageUrl == null) {
            imageUrl = FetchProfileImageCommand.class.getResource("/assets/images/default.png");
        }
        return clipImage(ImageIO.read(imageUrl), this.width, this.height);
    }

    private BufferedImage clipImage(BufferedImage image, int desiredWidth, int desiredHeight) {
        var width = image.getWidth();
        var xExcess = width - desiredWidth;
        var x = Math.round(xExcess / 2.0);
        
        var height = image.getHeight();
        var yExcess = height - desiredHeight;
        var y = Math.round(yExcess / 2.0);

        return image.getSubimage((int)x, (int)y, desiredWidth, desiredHeight);
    }

}