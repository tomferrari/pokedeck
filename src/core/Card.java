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

public abstract class Card {
	
	protected String name;
	
	public Card(String name){
		this.name = name;
	}
	
	public String getName(){
		return this.name;
	}
}
