package entity;


import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.KeyHandler;

public class Player extends Entity{
	KeyHandler keyHandler;
	public Player(KeyHandler kh) {
		this.keyHandler = kh;
		x = 100;
		y = 100;
		speed = 4;
		getPlayerImage();
		direction = "down";
	}
	public void update() {
		// ham update nay duoc goi khoang 50 lan trong 1 giay
		if(keyHandler.up == true) {
			direction = "up";
			y -= speed;
		}
		if(keyHandler.down == true) {
			direction = "down";
			y += speed;
		}
		if(keyHandler.left == true) {
			direction = "left";
			x -= speed;
		}
		if(keyHandler.right == true) {
			direction = "right";
			x += speed;
		}
		// moi lan update dc goi  thi se tang bien spriteCounter
		spriteCounter++;
		if(spriteCounter > 13) {
			spriteNum = 3 - spriteNum;
			// thay doi hinh anh buoc di
			spriteCounter = 0;
		}
	}
	public void getPlayerImage() {
		try {
			up1 = ImageIO.read(getClass().getResourceAsStream("/player/zph1_bk1.png"));
			up2 = ImageIO.read(getClass().getResourceAsStream("/player/zph1_bk2.png"));
			down1 = ImageIO.read(getClass().getResourceAsStream("/player/zph1_fr1.png"));
			down2 = ImageIO.read(getClass().getResourceAsStream("/player/zph1_fr2.png"));
			left1 = ImageIO.read(getClass().getResourceAsStream("/player/zph1_lf1.png"));
			left2 = ImageIO.read(getClass().getResourceAsStream("/player/zph1_lf2.png"));
			right1 = ImageIO.read(getClass().getResourceAsStream("/player/zph1_rt1.png"));
			right2 = ImageIO.read(getClass().getResourceAsStream("/player/zph1_rt2.png"));
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void drawPlayer(Graphics g) {
		BufferedImage image = null;
		switch(direction) {
		case "up":
			if(spriteNum == 1)
			image = up1;
			else image = up2;
			break;
		case "down":
			if(spriteNum == 1)
			image = down1;
			else image = down2;
			break;	
		case "left":
			if(spriteNum == 1)
			image = left1;
			else image = left2;
			break;
		case "right":
			if(spriteNum == 1)
			image = right1;
			else image = right2;
			break;	
		}
		if(keyHandler.stop == true) image = down1;
		g.drawImage(image, x, y, 48, 48, null);
	}
}
