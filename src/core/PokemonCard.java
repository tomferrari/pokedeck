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

public class PokemonCard extends Card {
	
	private int pv;
	private EnergyType energyType;
	
	public PokemonCard(String cardName, int pv, EnergyType energyType){
		super(cardName);
		this.pv = pv;
		this.energyType = energyType;
	}
	
	public int getPv() {
		return pv;
	}

	public EnergyType getEnergyType() {
		return energyType;
	}
}
