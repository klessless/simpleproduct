package com.first.shopify.metier;

import java.util.List;

import com.first.shopify.entities.*;
import com.first.shopify.interfaces.*;

public class ShopifyMetier implements IAdminCategorie{
	private IShopify dao;
	
	public IShopify getDao() {
		return dao;
	}

	public void setDao(IShopify dao) {
		this.dao = dao;
	}

	@Override
	public Long ajouterProduit(Produit produit, Long idCat) {
		return dao.ajouterProduit(produit, idCat);
	}

	@Override
	public void supprimerProduit(Long idProduit) {
		dao.supprimerProduit(idProduit);
	}

	@Override
	public void modifierProduit(Produit produit) {
		dao.modifierProduit(produit);
	}

	@Override
	public List<Categories> listCategories() {
		return dao.listCategories();
	}

	@Override
	public Categories getCategorie(Long idCat) {
		return dao.getCategorie(idCat);
	}

	@Override
	public List<Produit> listProduits() {
		return dao.listProduits();
	}

	@Override
	public List<Produit> produitParMotCle(String mc) {
		return dao.produitsParMotCle(mc);
	}

	@Override
	public List<Produit> produitParCategorie(Long idCat) {
		return dao.produitsParCategorie(idCat);
	}

	@Override
	public List<Produit> produitsSelectionnes() {
		return dao.produitsSelectionnes();
	}

	@Override
	public Produit getProduit(Long idProduit) {
		return dao.getProduit(idProduit);
	}

	@Override
	public Commande enregistrerCommande(Panier panier, Client client) {
		return dao.enregistrerCommande(panier, client);
	}

	@Override
	public Long ajouterCategorie(Categories categorie) {
		return dao.ajouterCategorie(categorie);
	}

	@Override
	public void supprimerCategorie(Long idCat) {
		dao.supprimerCategorie(idCat);
	}

	@Override
	public void modifierCategorie(Categories categorie) {
		dao.modifierCategorie(categorie);
	}

	@Override
	public void ajouterUser(User user) {
		dao.ajouterUser(user);
	}

	@Override
	public void attribuerRole(Role role, Long idUser) {
		dao.attribueRole(role, idUser);
	}
	
}
