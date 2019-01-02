package com.first.shopify.dao;

import java.util.*;
import javax.persistence.*;

import org.springframework.transaction.annotation.Transactional;

import com.first.shopify.entities.*;
import com.first.shopify.interfaces.*;

@Transactional
public class ShopDAO implements IShopify{
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void ajouterUser(User user) {
		em.persist(user);
		
	}

	@Override
	public void attribueRole(Role r, Long idUser) {
		User user=em.find(User.class, idUser);
		user.getRoles().add(r);
		em.persist(r);
	}

	@Override
	public Commande enregistrerCommande(Panier panier, Client client) {
		em.persist(client);
		Commande commande=new Commande();
		commande.setDateCommande(new Date());
		commande.setLignecommande(panier.getItems());
		for(LigneCommande ligne:panier.getItems()) {
			em.persist(ligne);
		}
		em.persist(commande);
		return commande;
	}

	@Override
	public Long ajouterProduit(Produit p, Long idCat) {
		Categories categorie = getCategorie(idCat);
		p.setCategorie(categorie);
		em.persist(p);
		return p.getIdproduit();
	}

	@Override
	public List<Produit> listProduits() {
		Query query = em.createQuery("select p from Produit p");
		return query.getResultList();
	}

	@Override
	public List<Produit> produitsParMotCle(String mc) {
		Query query = em.createQuery("select p from Produit p where p.description like :x or p.nomProduit like :x");
		query.setParameter("x","%"+mc+"%");
		return query.getResultList();
	}

	@Override
	public List<Produit> produitsParCategorie(Long idCat) {
		Query query = em.createQuery("select p from Produit p where p.categories.IdCategorie = :x ");
		query.setParameter("x",idCat);
		return query.getResultList();
	}

	@Override
	public List<Produit> produitsSelectionnes() {
		Query query = em.createQuery("select p from Produit p where p.selected=true");
		return query.getResultList();
	}

	@Override
	public Produit getProduit(Long idProd) {
		return em.find(Produit.class, idProd);
	}

	@Override
	public void supprimerProduit(Long idProd) {
		Produit produit=getProduit(idProd);
		em.remove(produit);
	}

	@Override
	public void modifierProduit(Produit p) {
		em.merge(p);
		
	}

	@Override
	public Long ajouterCategorie(Categories c) {
		em.persist(c);
		return c.getIdcategorie();
	}

	@Override
	public List<Categories> listCategories() {
		Query request = em.createQuery("select c from Categories c");
		return request.getResultList();
	}

	@Override
	public Categories getCategorie(Long idCat) {
		return em.find(Categories.class, idCat);
	}

	@Override
	public void supprimerCategorie(Long idCat) {
		Categories categorie = em.find(Categories.class, idCat);
		em.remove(categorie);
		
	}

	@Override
	public void modifierCategorie(Categories categorie) {
		em.merge(categorie);
		
	}

}
