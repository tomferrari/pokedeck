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

public class EnergyCard extends Card {
	
	private EnergyType energyType;
	
	public EnergyCard(String cardName, EnergyType energyType){
		super(cardName);
		this.energyType = energyType;
	}
	
	public EnergyType getEnergyType(){
		return this.energyType;
	}
	
}
