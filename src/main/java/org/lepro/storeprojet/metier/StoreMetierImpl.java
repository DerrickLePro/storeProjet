package org.lepro.storeprojet.metier;

import java.util.List;

import org.lepro.storeprojet.dao.StoreDao;
import org.lepro.storeprojet.entities.Categorie;
import org.lepro.storeprojet.entities.Client;
import org.lepro.storeprojet.entities.Commande;
import org.lepro.storeprojet.entities.Panier;
import org.lepro.storeprojet.entities.Produit;
import org.lepro.storeprojet.entities.Role;
import org.lepro.storeprojet.entities.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoreMetierImpl implements IAdminMetier {

	@Autowired
	private StoreDao dao;

	@Override
	public List<Categorie> listCategories() {
		// TODO Auto-generated method stub
		return dao.listCategories();
	}

	@Override
	public Categorie getCategorie(Long idCat) {
		// TODO Auto-generated method stub
		return dao.getCategorie(idCat);
	}

	@Override
	public List<Produit> listProduit() {
		// TODO Auto-generated method stub
		return dao.listProduit();
	}

	@Override
	public List<Produit> produitsParCategorie(Categorie c) {
		// TODO Auto-generated method stub
		return dao.produitsParCategorie(c);
	}

	@Override
	public List<Produit> produitsParMotCle(String mc) {
		// TODO Auto-generated method stub
		return dao.produitsParMotCle(mc);
	}

	@Override
	public List<Produit> produitsSelectionnes() {
		// TODO Auto-generated method stub
		return dao.produitsSelectionnes();
	}

	@Override
	public Produit getProduit(Long idP) {
		// TODO Auto-generated method stub
		return dao.getProduit(idP);
	}

	@Override
	public Commande enregistrerCommande(Panier p, Client c) {
		// TODO Auto-generated method stub
		return dao.enregistrerCommande(p, c);
	}

	@Override
	public Long ajouterProduit(Produit p, Long idCat) {
		// TODO Auto-generated method stub
		return dao.ajouterProduit(p, idCat);
	}

	@Override
	public void supprimerProduit(Long idP) {
		dao.supprimerProduit(idP);
	}

	@Override
	public void modifierProduit(Produit P) {
		dao.modifierProduit(P);

	}

	@Override
	public Long ajouterCategorie(Categorie c) {

		return dao.ajouterCategorie(c);
	}

	@Override
	public void supprimerCategorie(Long idCat) {
		dao.supprimerCategorie(idCat);

	}

	@Override
	public void modifierCategorie(Categorie C) {
		dao.modifierCategorie(C);

	}

	@Override
	public void ajouterUser(Users u) {
		// TODO Auto-generated method stub
		dao.ajouterUser(u);

	}

	@Override
	public void attribuerRole(Role r, Long usersID) {
		// TODO Auto-generated method stub
		dao.attribuerRole(r, usersID);

	}

	public void setDao(StoreDao dao) {
		this.dao = dao;
	}

	@Override
	public Long ajouterClient(Client c) {
		// TODO Auto-generated method stub
		return dao.ajouterClient(c);
	}

	@Override
	public List<Client> listClient() {
		// TODO Auto-generated method stub
		return dao.listClient();
	}

}
