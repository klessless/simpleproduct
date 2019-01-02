package com.first.shopify.interfaces;

import java.util.List;

import com.first.shopify.entities.*;

public interface Internaute {
	
	public List<Categories> listCategories();
	public Categories getCategorie(Long idCat);
	public List<Produit> listProduits();
	public List<Produit> produitParMotCle(String mc);
	public List<Produit> produitParCategorie(Long idCat);
	public List<Produit> produitsSelectionnes();
	public Produit getProduit(Long idProduit);
	public Commande enregistrerCommande(Panier panier, Client client);
	
}
