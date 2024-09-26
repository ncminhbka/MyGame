package main;

import java.awt.Color;
import java.awt.Dimension;

import java.awt.Graphics;

import javax.swing.JPanel;

import entity.Player;

public class GamePanel extends JPanel implements Runnable{
	final int screenWidth = 768;
	final int screenHeight = 576;
	Thread thread;
	KeyHandler keyHandler = new KeyHandler();
	Player player = new Player(keyHandler);
	public GamePanel() {
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(Color.white);
		this.setDoubleBuffered(true);
		this.addKeyListener(keyHandler);
		this.setFocusable(true);
		thread = new Thread(this);
		thread.start();
	}
	@Override
	public void run() {
		while(true) {
			player.update();
			try {
				thread.sleep(20);
			} catch (InterruptedException e) {}
			repaint();
		}
	}
	// commit
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g); // xóa màn hình 
		player.drawPlayer(g);
	}
}
