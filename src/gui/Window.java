/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

/**
 *
 * @author Thomas
 */

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Window {
	
	private static Window instance = null;
	
	private JFrame window;
	private int windowWidth = 400;
	private int windowHeight = 300;
	
	public Window(){
		this.window = new JFrame("Pokedeck");
		
		this.window.setSize(this.windowWidth, this.windowHeight);
		this.window.setResizable(true);
		this.window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.centerWindow();
		
		this.window.setVisible(true);
	}
	
	private void centerWindow(){
		Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
		
		int xOffset = ( screenDimension.width - this.windowWidth ) / 2;
		int yOffset = ( screenDimension.height - this.windowHeight ) / 2;
		
		this.window.setLocation(xOffset, yOffset);
	}
	
	public void changeSize(int w, int h){
		this.windowWidth = w;
		this.windowHeight = h;
		
		this.window.setSize(this.windowWidth, this.windowHeight);
		this.centerWindow();
	}
	
	public void addPanel(JPanel panel){
		this.window.getContentPane().removeAll();
		this.window.add(panel);
	}
	
	public void validate(){
		this.window.validate();
	}
	
	public static Window getInstance(){
		if(instance == null)
			instance = new Window();
		
		return instance;
	}
	
}
