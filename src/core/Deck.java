/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

/**
 *
 * @author Thomas
 */

import java.util.ArrayList;


public class Deck {
	
	private static Deck instance = null;
	
	private ArrayList<Card> cards;
	
	public Deck(){
		this.cards = new ArrayList<Card>();
	}
	
	public int numberOfCards(){
		return this.cards.size();
	}
	
	public void addCard(Card c){
		this.cards.add(c);
	}
	
	public ArrayList<Card> getMyCards(){
		return this.cards;
	}
	
	public void modifyCard(Card c, int index){
		this.cards.set(index, c);
	}
	
	public static Deck getInstance(){
		if(instance == null)
			instance = new Deck();
		
		return instance;
	}
}

