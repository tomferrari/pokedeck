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

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import core.EnergyType;
import core.DresseurType;
import core.EnergyCard;
import core.PokemonCard;
import core.DresseurCard;
import java.awt.event.KeyEvent;

public class AddCard extends Application {

	private String[] cardTypes = new String[] {"Energie", "Dresseur", "Pokemon"};
	
	private JComboBox<String> cardTypeCombobox;
	private JComboBox<EnergyType> energyTypeComboBox;
	private JComboBox<DresseurType> dresseurTypeComboBox;
	
	private JPanel cardInfoPanel;
	private JPanel energyPanel;
	private JPanel dresseurPanel;
	private JPanel pokemonPanel;
	
	private JTextField cardName;
	private JTextField dresseurInformations;
	private JTextField pokemonPv;
	private JTextField pokemonStage;
	private JTextField pokemonCcn;
	
	public AddCard(){
		super();
		this.constructPanel();
		this.changeWindowSize(400, 300);
	}
	
	public void constructPanel() {		
		this.changeMainPanelLayoutManager(new BorderLayout());		
		
		this.panel.add(this.constructHeaderPanel(), BorderLayout.PAGE_START);		
		this.panel.add(this.constructCardInfoPanel(), BorderLayout.CENTER);		
		this.panel.add(this.constructButtonPanel(), BorderLayout.PAGE_END);
	}
	
	private JPanel constructHeaderPanel(){
		JPanel cardTypePanel = new JPanel();
		
		this.cardTypeCombobox = new JComboBox<String>(cardTypes);
		this.cardTypeCombobox.setSelectedIndex(0);
		this.cardTypeCombobox.addActionListener(new AddCardEventManager());
		
		cardTypePanel.add(new JLabel("Carte : "));
		cardTypePanel.add(this.cardTypeCombobox);
		
		return cardTypePanel;
	}
	
	private JPanel constructButtonPanel(){
		JPanel buttonsPanel = new JPanel();
		JButton menuButton = new JButton("Menu");
		JButton saveButton = new JButton("Save");
		
		menuButton.addActionListener(new AddCardEventManager());
		saveButton.addActionListener(new AddCardEventManager());
		
		buttonsPanel.add(menuButton);
		buttonsPanel.add(saveButton);
		
		return buttonsPanel;
	}
	
	private JPanel constructCardInfoPanel(){
		this.cardInfoPanel = new JPanel();		
		
		this.cardInfoPanel.add(this.constructEnergyPanel());
		
		return this.cardInfoPanel;
	}
	
	private JPanel constructEnergyPanel(){		
		this.energyPanel = new JPanel(new GridLayout(0, 2));
		this.energyTypeComboBox = new JComboBox<EnergyType>(EnergyType.values());
		
		this.energyPanel.add(new JLabel("Type :"));
		this.energyPanel.add(this.energyTypeComboBox);
		
		return this.energyPanel;
	}
	
	private JPanel constructDresseurPanel(){
		this.dresseurPanel = new JPanel(new GridLayout(0, 2));
		
		this.dresseurTypeComboBox = new JComboBox<DresseurType>(DresseurType.values());		
		this.cardName = new JTextField();
		this.dresseurInformations = new JTextField();
		
		this.dresseurPanel.add(new JLabel("Nom :"));
		this.dresseurPanel.add(this.cardName);
		
		this.dresseurPanel.add(new JLabel("Type :"));
		this.dresseurPanel.add(this.dresseurTypeComboBox);
		
		this.dresseurPanel.add(new JLabel("Informations :"));
		this.dresseurPanel.add(this.dresseurInformations);
		
		return this.dresseurPanel;
	}
	
	private JPanel constructPokemonPanel(){
		this.pokemonPanel = new JPanel(new GridLayout(0, 2));
		
		this.cardName = new JTextField();
		this.pokemonPv = new JTextField();
		this.energyTypeComboBox = new JComboBox<EnergyType>(EnergyType.values());
		
		this.pokemonPanel.add(new JLabel("Nom :"));
		this.pokemonPanel.add(this.cardName);
		
		this.pokemonPanel.add(new JLabel("Type :"));
		this.pokemonPanel.add(this.energyTypeComboBox);
		
		this.pokemonPanel.add(new JLabel("Pv :"));
		this.pokemonPanel.add(this.pokemonPv);
                
                
		
		return this.pokemonPanel;
	}
        
        public void keyTyped(KeyEvent k)  
        {
            if (! Character.isDigit(k.getKeyChar()))
            {
                k.consume();
            }
        }
	
	private void showCardInfoPanel(String cardType){
		this.cardInfoPanel.removeAll();
		
		switch(cardType){
			case "Energie":
				this.cardInfoPanel.add(this.constructEnergyPanel());
				break;
				
			case "Dresseur":
				this.cardInfoPanel.add(this.constructDresseurPanel());
				break;
				
			case "Pokemon":
				this.cardInfoPanel.add(this.constructPokemonPanel());
				break;
		}
		
		this.validateWindow();
		this.panel.repaint();
	}
	
	private void saveCard(String cardType){
		switch(cardType){
			case "Energie":
				this.deck.addCard(new EnergyCard("Energie - " + this.energyTypeComboBox.getSelectedItem().toString(),
								this.energyTypeComboBox.getItemAt( this.energyTypeComboBox.getSelectedIndex())));
				break;
				
			case "Dresseur":
				this.deck.addCard(new DresseurCard(this.cardName.getText(),
								this.dresseurInformations.getText(),
								this.dresseurTypeComboBox.getItemAt(this.dresseurTypeComboBox.getSelectedIndex())));
				break;
				
			case "Pokemon":
				int pv = Integer.parseInt(this.pokemonPv.getText());
				
				this.deck.addCard(new PokemonCard(this.cardName.getText(), pv,
								this.energyTypeComboBox.getItemAt( this.energyTypeComboBox.getSelectedIndex())));
				break;
		}
		
		this.showCardInfoPanel(cardType);
	}
	
	private class AddCardEventManager implements ActionListener{
		
		public void actionPerformed(ActionEvent event) {
			switch(event.getActionCommand()){
				case "Menu":
					new Menu();
					break;
					
				case "comboBoxChanged":
					if(event.getSource() == cardTypeCombobox)
						showCardInfoPanel(cardTypeCombobox.getSelectedItem().toString());
					break;
					
				case "Save":
					saveCard(cardTypeCombobox.getSelectedItem().toString());
					break;                  
			}
		}
		
	}
}

