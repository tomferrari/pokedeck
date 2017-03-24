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
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import core.EnergyCard;
import core.PokemonCard;
import core.DresseurCard;
import core.Card;

public class Search extends Application {
	
	public Search(){
		super();
		this.constructPanel();
		this.changeWindowSize(1450, 550);
	}
	
	public void constructPanel() {		
		this.panel.add(this.constructHeaderPanel());		
		this.panel.add(this.constructCardTablesPanel());	
		this.panel.add(this.constructButtonPanel());
	}
	
	private JPanel constructHeaderPanel() {
		JPanel cardCountPanel = new JPanel();
		
		cardCountPanel.add(new JLabel(this.deck.numberOfCards() + " cartes"));
		
		return cardCountPanel;
	}
	
	private JPanel constructButtonPanel() {
		JPanel buttonsPanel = new JPanel();
		JButton menuButton = new JButton("Menu");
		
		menuButton.addActionListener(new ExploreEventManager());
		buttonsPanel.add(menuButton);
		
		return buttonsPanel;
	}
	
	private JPanel constructCardTablesPanel(){
		JPanel cardTablePanel = new JPanel();
		
		ArrayList<Card> cards = this.deck.getMyCards();
		ArrayList<EnergyCard> energyCards = new ArrayList<EnergyCard>();
		ArrayList<DresseurCard> dresseurCards = new ArrayList<DresseurCard>();
		ArrayList<PokemonCard> pokemonCards = new ArrayList<PokemonCard>();
		
		for(Card c : cards){
			if(c instanceof EnergyCard){
				energyCards.add((EnergyCard) c);
			}else if(c instanceof DresseurCard){
				dresseurCards.add((DresseurCard) c);
			}else if(c instanceof PokemonCard){
				pokemonCards.add((PokemonCard) c);
			}
		}
		
		cardTablePanel.add(new JScrollPane(this.constructEnergyCardTable(energyCards)));
		cardTablePanel.add(new JScrollPane(this.constructDresseurCardTable(dresseurCards)));
		cardTablePanel.add(new JScrollPane(this.constructPokemonCardTable(pokemonCards)));
		
		return cardTablePanel;
	}
	
	private JTable constructEnergyCardTable(ArrayList<EnergyCard> energyCards){
		String[] energyCardTableHeader = new String[] {"Nom", "Type"};
		String[][] energyCardsData = new String[energyCards.size()][energyCardTableHeader.length];
		JTable energyCardsTable = new JTable(energyCardsData, energyCardTableHeader);
		
		int index = 0;
		for(EnergyCard ec : energyCards){
			energyCardsData[index][0] = ec.getName();
			energyCardsData[index][1] = ec.getEnergyType().toString();
			
			index++;
		}
		
		return energyCardsTable;
	}
	
	private JTable constructDresseurCardTable(ArrayList<DresseurCard> dresseurCards){
		String[] dresseurCardTableHeader = new String[] {"Nom", "Type", "Informations"};
		String[][] dresseurCardsData = new String[dresseurCards.size()][dresseurCardTableHeader.length];
		JTable dresseurCardsTable = new JTable(dresseurCardsData, dresseurCardTableHeader);
		
		int index = 0;
		for(DresseurCard tc : dresseurCards){
			dresseurCardsData[index][0] = tc.getName();
			dresseurCardsData[index][1] = tc.getDiversType().toString();
			dresseurCardsData[index][2] = tc.getInformation();
			
			index++;
		}
		
		return dresseurCardsTable;
	}

	private JTable constructPokemonCardTable(ArrayList<PokemonCard> pokemonCards){
		String[] pokemonCardTableHeader = new String[] {"Nom", "Type", "Pv"};
		String[][] pokemonCardsData = new String[pokemonCards.size()][pokemonCardTableHeader.length];
		JTable pokemonCardsTable = new JTable(pokemonCardsData, pokemonCardTableHeader);
		
		int index = 0;
		for(PokemonCard pc : pokemonCards){
			pokemonCardsData[index][0] = pc.getName();
			pokemonCardsData[index][1] = pc.getEnergyType().toString();
			pokemonCardsData[index][2] = new Integer(pc.getPv()).toString();
			
			index++;
		}
		
		return pokemonCardsTable;
	}

	private class ExploreEventManager implements ActionListener{
		
		public void actionPerformed(ActionEvent event) {
			switch(event.getActionCommand()){
				case "Menu":
					new Menu();
					break;
			}
		}
		
	}
}

