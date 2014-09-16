package com.zworks.launchericontool;

import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

import javax.imageio.ImageIO;

public class Main {

	public static void main(String[] args) {
		System.out.println(Boolean.toString(Collections.emptyList().equals(new LinkedList<Object>())));
		
		if (args.length < 1) {
			System.out.println("Specify image file name as an argument.");
			return;
		}

		BufferedImage image;
		try {
			image = ImageIO.read(new File(args[0]));
			
			// 512 x 512
			File file = new File("web_hi_res_512.png");
			file.mkdirs();
			image = getScaledImageStepped(image, 512);
			ImageIO.write(image, "png", file);

			// xxxhdpi
			file = new File("res/drawable-xxxhdpi/ic_launcher.png");
			file.mkdirs();
			BufferedImage newImage = getScaledImageStepped(image, 192);
			ImageIO.write(newImage, "png", file);

			// xxhdpi
			file = new File("res/drawable-xxhdpi/ic_launcher.png");
			file.mkdirs();
			newImage = getScaledImageStepped(image, 144);
			ImageIO.write(newImage, "png", file);

			// xhdpi
			file = new File("res/drawable-xhdpi/ic_launcher.png");
			file.mkdirs();
			newImage = getScaledImageStepped(image, 96);
			ImageIO.write(newImage, "png", file);

			// hdpi
			file = new File("res/drawable-hdpi/ic_launcher.png");
			file.mkdirs();
			newImage = getScaledImageStepped(image, 72);
			ImageIO.write(newImage, "png", file);

			// mdpi
			file = new File("res/drawable-mdpi/ic_launcher.png");
			file.mkdirs();
			newImage = getScaledImageStepped(image, 48);
			ImageIO.write(newImage, "png", file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static BufferedImage getScaledImageStepped(BufferedImage image, int size) {
		while (image.getWidth() > size * 2) {
			int newSize = image.getWidth() / 2; 
			image = getScaledImage(image, newSize, newSize);
		}
		image = getScaledImage(image, size, size);
		
		return image;
	}

	public static BufferedImage getScaledImage(BufferedImage image, int width,
			int height) {
		int imageWidth = image.getWidth();
		int imageHeight = image.getHeight();

		double scaleX = (double) width / imageWidth;
		double scaleY = (double) height / imageHeight;
		AffineTransform scaleTransform = AffineTransform.getScaleInstance(
				scaleX, scaleY);
		AffineTransformOp bilinearScaleOp = new AffineTransformOp(
				scaleTransform, AffineTransformOp.TYPE_BILINEAR);

		return bilinearScaleOp.filter(image, new BufferedImage(width, height,
				image.getType()));
	}
}
