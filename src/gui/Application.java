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

import java.awt.LayoutManager;

import javax.swing.JPanel;

import core.Deck;

public abstract class Application {
	
	private Window window;
	protected Deck deck;
	protected JPanel panel;
	
	public Application(){
		this.window = Window.getInstance();
		this.deck = Deck.getInstance();
		this.panel = new JPanel();
		this.window.addPanel(panel);
	}
	
	abstract public void constructPanel();
	
	protected void changeWindowSize(int w, int h){
		this.window.changeSize(w, h);
	}
	
	protected void changeMainPanelLayoutManager(LayoutManager lm){
		this.panel.setLayout(lm);
	}
	
	protected void validateWindow(){
		this.window.validate();
	}
	
}
