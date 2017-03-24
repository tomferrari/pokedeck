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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Menu extends Application {

	private JButton addButton;
	private JButton exploreButton;
	private JButton exitButton;
	
	public Menu(){
		super();
		this.constructPanel();
		this.changeWindowSize(400, 100);
	}
	
	public void constructPanel() {
		this.addButton = new JButton("Ajouter une carte");
		this.addButton.addActionListener(new MenuEventManager());
		this.panel.add(this.addButton);
		
		this.exploreButton = new JButton("Deck");
		this.exploreButton.addActionListener(new MenuEventManager());
		this.panel.add(this.exploreButton);
		
		this.exitButton = new JButton("Quitter");
		this.exitButton.addActionListener(new MenuEventManager());
		this.panel.add(this.exitButton);
	}
	
	private class MenuEventManager implements ActionListener{
		
		public void actionPerformed(ActionEvent event) {
			switch(event.getActionCommand()){
				case "Ajouter une carte":
					new AddCard();
					break;
					
				case "Deck":
					new Search();
					break;
					
				case "Quitter":
					System.exit(0);
					break;
			}
		}
		
	}

}

