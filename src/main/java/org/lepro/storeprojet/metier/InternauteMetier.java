package org.lepro.storeprojet.metier;

import java.util.List;

import org.lepro.storeprojet.entities.Categorie;
import org.lepro.storeprojet.entities.Client;
import org.lepro.storeprojet.entities.Commande;
import org.lepro.storeprojet.entities.Panier;
import org.lepro.storeprojet.entities.Produit;

public interface InternauteMetier {

	public List<Categorie> listCategories();

	public Categorie getCategorie(Long idCat);

	public List<Produit> listProduit();

	public List<Produit> produitsParCategorie(Categorie c);

	public List<Produit> produitsParMotCle(String mc);

	public List<Produit> produitsSelectionnes();

	public Produit getProduit(Long idP);

	public Commande enregistrerCommande(Panier p, Client c);

}
