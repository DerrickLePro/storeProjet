package org.lepro.storeprojet.dao;

import java.util.List;

import org.lepro.storeprojet.entities.Categorie;
import org.lepro.storeprojet.entities.Client;
import org.lepro.storeprojet.entities.Commande;
import org.lepro.storeprojet.entities.Panier;
import org.lepro.storeprojet.entities.Produit;
import org.lepro.storeprojet.entities.Role;
import org.lepro.storeprojet.entities.Users;

public interface StoreDao {

	public Long ajouterCategorie(Categorie c);

	public List<Categorie> listCategories();

	public Categorie getCategorie(Long idCat);

	public void supprimerCategorie(Long idCat);

	public void modifierCategorie(Categorie C);

	public Long ajouterProduit(Produit p, Long idCat);

	public List<Produit> listProduit();

	public List<Produit> produitsParCategorie(Categorie c);

	public List<Produit> produitsParMotCle(String mc);

	public List<Produit> produitsSelectionnes();

	public Produit getProduit(Long idP);

	public void supprimerProduit(Long idP);

	public void modifierProduit(Produit P);

	public void ajouterUser(Users u);

	public void attribuerRole(Role r, Long usersID);

	public Commande enregistrerCommande(Panier p, Client c);

	public Long ajouterClient(Client c);
}
