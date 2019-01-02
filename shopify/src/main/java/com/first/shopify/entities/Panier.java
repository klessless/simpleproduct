package com.first.shopify.entities;


import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Panier implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Map<Long, LigneCommande> items = new HashMap<Long, LigneCommande>();
	
	public void addProduct(Produit p, int quantite) {
		if(items.get(p.getIdproduit()) == null) {
			LigneCommande cmd = new LigneCommande();
			cmd.setProduct(p);
			cmd.setQuantite(quantite);
			cmd.setPrix(p.getPrix());
		} else {
			LigneCommande cmd = items.get(p.getIdproduit());
			cmd.setQuantite(cmd.getQuantite()+quantite);
		}
	}
	
	public Collection<LigneCommande> getItems(){
		return items.values();
	}
	
	public double getPrix() {
		double prixTotal = 0;
		for(LigneCommande cmd:items.values()) {
			prixTotal = prixTotal + cmd.getPrix()*cmd.getQuantite();
		}
		return prixTotal;
	}
	
	public int getSize() {
		return items.size();
	}
	
	public void deleteItem(Long idProduit) {
		items.remove(idProduit);
	}
	
	
}
