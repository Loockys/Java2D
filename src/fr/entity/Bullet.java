package fr.entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;

import javax.swing.JPanel;

public class Bullet extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8183723543179595372L;
	private double pX;
	private double pY;
	private double pW;
	private double pH;
	private Ellipse2D bullet;
	public double angle, speed = 1.5;
	
	
	public Bullet(double x, double y, double w, double h, double angle) {
		this.pX = x;
		this.pY = y;
		this.pW = w;
		this.pH = h;
		this.angle = angle;
		this.bullet = new Ellipse2D.Double(0, 0, this.pW, this.pH);
	}
	
	// GETTERS and SETTERS
	
	public double getpX() {
		return pX;
	}

	public void setpX(double pX) {
		this.pX = pX;
	}

	public double getpY() {
		return pY;
	}

	public void setpY(double pY) {
		this.pY = pY;
	}

	public double getpW() {
		return pW;
	}

	public void setpW(double pW) {
		this.pW = pW;
	}

	public double getpH() {
		return pH;
	}

	public void setpH(double pH) {
		this.pH = pH;
	}

	public Ellipse2D getBullet() {
		return bullet;
	}

	public void setBullet(Ellipse2D bullet) {
		this.bullet = bullet;
	}

	public double getAngle() {
		return angle;
	}

	public void setAngle(double angle) {
		this.angle = angle;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}
	
	public double getCenterPx() {
		return pX + pW /2;
	}
	
	public double getCenterPy() {
		return pY + pH /2;
	}
	

	// -- UPDATE AND DRAW

	public void update() {
		
		pX += Math.cos(angle) * speed;
		pY += Math.sin(angle) * speed;


		
	}	

	public void draw(Graphics2D g2d) {
		AffineTransform oldTransform = g2d.getTransform();
		g2d.setColor(Color.white);
		g2d.translate(pX, pY);
		g2d.fill(bullet);
		g2d.setTransform(oldTransform);
	}
	
	public boolean check(int width, int height) {
		if(pX < 0 || pX > width || pY < 0 || pY > height) {
			return true;
		} else {
			return false;
		}
	}
}
