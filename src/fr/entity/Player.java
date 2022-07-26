package fr.entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import fr.main.Main;




public class Player extends JPanel implements MouseListener, MouseMotionListener {
	
	private static final long serialVersionUID = -4372738643315351111L;
	public int x, y, w, h;
	private Rectangle rect;
	private List<Bullet> listBullets;
	public double angle;
	
	private boolean isPressed = false, iscountdown = false;
	private MouseEvent mouseEvent;
	
	
	public int time1 = 200;
	public int time2 = 500;
	public int countdown = 40;
	
	public Player(int x, int y, int w, int h) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.rect = new Rectangle(this.x, this.y, this.w, this.h);
		this.listBullets = new ArrayList<>();
		
		new Thread(new Runnable() {

			@Override
			public void run() {
				while(true) {
					try {
						Thread.sleep(time1);
						
						if(isPressed) {
							shoot();
							countdown -= 5;
						}
						
						
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}).start();
		
		new Thread(new Runnable() {	
			@Override
			public void run() {
				while(true) {
					try {
						Thread.sleep(time2);
						
						if(countdown >= 0 & countdown <= 39) {
							countdown += 3;
						}
						
						if(countdown >= 0 & countdown <= 10) {
							time1 = 1000;
						} else if(countdown >= 10 & countdown <= 40) {
							time1 = 200;
						}
						
						if(countdown >= 40) {
							countdown = 40;
						} else if(countdown <= 0) {
							countdown = 0;
						}
						
						System.out.println("TICK ! " + countdown);
					
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}				
			}
		}).start();
	}
	
	// -- UPDATE AND DRAW
	public void update() {
		this.rect.x = this.x - this.w /2;
		this.rect.y = this.y - this.h /2;
		
		for (int i = 0; i < listBullets.size(); i++) {
			if(listBullets.get(i).getpX() < 0 || listBullets.get(i).getpX() > Main.jf.getWidth() || listBullets.get(i).getpY() < 0 || listBullets.get(i).getpY() > Main.jf.getHeight()) {
				listBullets.remove(i);
			}
		}
		
	}
	
	public void draw(Graphics2D g2d) {
		update();
		
		g2d.setColor(Color.RED);
		g2d.fill(rect);
		
		for (int i = 0; i < listBullets.size(); i++) {
			listBullets.get(i).update();
		}
		
		for (int i = 0; i < listBullets.size(); i++) {
			listBullets.get(i).draw(g2d);
		}
		
	}
	
	// -- SHOOT
	public void shoot() {
		
		this.angle = Math.atan2(Main.gp1.centerY - mouseEvent.getY(), Main.gp1.centerX - mouseEvent.getX()) + Math.PI * 3;
		listBullets.add(new Bullet(Main.gp1.centerX -4, Main.gp1.centerY -4, 8, 8, angle));
	}
	
	// -- MOUSELISTENER
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if(e.getButton() == MouseEvent.BUTTON1) {
			System.out.println("Nombre de balles :" + listBullets.size());
			mouseEvent = e;
			isPressed = true;		
		}	
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if(e.getButton() == MouseEvent.BUTTON1) {
			mouseEvent = e;
			isPressed = false;		
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	// -- Test Thread
	public void continuousShooting() {
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		mouseEvent = e;
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		
	}

}
