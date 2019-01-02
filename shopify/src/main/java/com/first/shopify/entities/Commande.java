package com.first.shopify.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.*;

@Entity
public class Commande implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idCommande;
	private Date dateCommande;
	
	@OneToMany(mappedBy="commande")
	private Collection<LigneCommande> lignecommande;
	
	@ManyToOne
	@JoinColumn(name="idClient")
	private Client client;
	
	
	public Commande() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getIdCommande() {
		return idCommande;
	}
	public void setIdCommande(Long idCommande) {
		this.idCommande = idCommande;
	}
	public Date getDateCommande() {
		return dateCommande;
	}
	public void setDateCommande(Date dateCommande) {
		this.dateCommande = dateCommande;
	}
	public Collection<LigneCommande> getLignecommande() {
		return lignecommande;
	}
	public void setLignecommande(Collection<LigneCommande> lignecommande) {
		this.lignecommande = lignecommande;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	
	
}
