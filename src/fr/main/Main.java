package fr.main;

import javax.swing.JFrame;

import fr.graphics.GamePanel;

public class Main {

	public static GamePanel gp1;
	public static JFrame jf;
	
	public static void main(String[] args) {
		jf = new JFrame();
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setTitle("Jeu de tir");
		jf.setSize(1200, 800);
		
		gp1 = new GamePanel();
		jf.add(gp1);
		
		
		jf.setLocationRelativeTo(null);
		jf.setVisible(true);
		
	}

}
