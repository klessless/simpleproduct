package com.first.shopify.interfaces;

import com.first.shopify.entities.*;

public interface IAdminProduit extends Internaute {

	public Long ajouterProduit(Produit produit,Long idCat);
	public void supprimerProduit(Long idProduit);
	public void modifierProduit(Produit produit);
	
}
