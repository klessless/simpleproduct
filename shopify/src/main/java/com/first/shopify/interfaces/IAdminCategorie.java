package com.first.shopify.interfaces;

import com.first.shopify.entities.*;

public interface IAdminCategorie extends IAdminProduit{
	
	public Long ajouterCategorie(Categories categorie);
	public void supprimerCategorie(Long idCat);
	public void modifierCategorie(Categories categorie);
	public void ajouterUser(User user);
	public void attribuerRole(Role role,Long idUser);
	
}
