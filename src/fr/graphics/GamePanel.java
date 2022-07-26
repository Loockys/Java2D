package fr.graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

import javax.swing.JPanel;

import fr.entity.Player;
import fr.main.Main;

@SuppressWarnings("serial")
public class GamePanel extends JPanel {

	private Player player;
	public int centerX, centerY;
	
	public GamePanel() {
		this.setBackground(Color.black);
		

		this.centerX = Main.jf.getWidth() /2;
		this.centerY = Main.jf.getHeight() /2;
		
		this.player = new Player(centerX - 16, centerY - 16, 32, 32);
		this.addMouseListener(player);
		this.addMouseMotionListener(player);
		
		
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		
		this.centerX = Main.jf.getWidth() /2;
		this.centerY = Main.jf.getHeight() /2;
		this.player.x = centerX;
		this.player.y = centerY;
		
		update();
		draw(g2d);
		
		repaint();
	}
	
	public void update() {
		
	}
	
	public void draw(Graphics2D g2d) {
		
		
		this.player.draw(g2d);
		
		
		Ellipse2D circle = new Ellipse2D.Double(centerX -4, centerY -4, 8, 8);
		g2d.setColor(Color.green);
		g2d.fill(circle);
		
	}
}
