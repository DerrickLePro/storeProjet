package org.lepro.storeprojet.metier;

import java.util.List;

import org.lepro.storeprojet.entities.Categorie;
import org.lepro.storeprojet.entities.Client;
import org.lepro.storeprojet.entities.Produit;
import org.lepro.storeprojet.entities.Role;
import org.lepro.storeprojet.entities.Users;

public interface IAdminMetier extends InternauteMetier {

	public Long ajouterProduit(Produit p, Long idCat);

	public void supprimerProduit(Long idP);

	public void modifierProduit(Produit P);

	public Long ajouterCategorie(Categorie c);

	public void supprimerCategorie(Long idCat);

	public void modifierCategorie(Categorie C);

	public void ajouterUser(Users u);

	public void attribuerRole(Role r, Long usersID);

	public Long ajouterClient(Client c);

	public List<Client> listClient();
}