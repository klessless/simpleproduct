package com.first.shopify.interfaces;

import java.util.List;

import com.first.shopify.entities.*;

public interface IShopify{
	
	public Long ajouterCategorie (Categories c);
	public List<Categories> listCategories();
	public Categories getCategorie(Long idCat);
	public void supprimerCategorie(Long idCat);
	public void modifierCategorie(Categories categorie);
	
	public Long ajouterProduit(Produit p,Long idCat);
	public List<Produit> listProduits();
	public List<Produit> produitsParMotCle(String mc);
	public List<Produit> produitsParCategorie(Long idCat);
	public List<Produit> produitsSelectionnes();
	public Produit getProduit(Long idProd);
	public void supprimerProduit(Long idProd);
	public void modifierProduit(Produit p);
	
	public void ajouterUser(User user);
	public void attribueRole(Role r,Long idUser);
	public Commande enregistrerCommande(Panier panier,Client client);
	
}
