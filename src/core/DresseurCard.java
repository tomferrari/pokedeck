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
public class DresseurCard extends Card {
	
	private String information;
	private DresseurType dresseurType;
	
	public DresseurCard(String cardName, String information, DresseurType dresseurType){
		super(cardName);
		this.information = information;
		this.dresseurType = dresseurType;
	}
	
	public String getInformation() {
		return information;
	}


	public DresseurType getDiversType() {
		return dresseurType;
	}
	
}
