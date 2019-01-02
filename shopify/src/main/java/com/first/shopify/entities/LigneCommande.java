package com.first.shopify.entities;

import java.io.Serializable;

import javax.persistence.*;

@Entity
public class LigneCommande implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="idproduit")
	private Produit produit;
	private int quantite;
	private double prix;
	
	@ManyToOne
	@JoinColumn(name="idCommande")
	private Commande commande;
	
	
	public LigneCommande() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Produit getProduct() {
		return produit;
	}
	public void setProduct(Produit produit) {
		this.produit = produit;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public Commande getCommande() {
		return commande;
	}
	public void setCommande(Commande commande) {
		this.commande = commande;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public LigneCommande(Produit produit, int quantite, double prix) {
		super();
		this.produit = produit;
		this.quantite = quantite;
		this.prix = prix;
	}
	
}
