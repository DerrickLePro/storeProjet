package org.lepro.storeprojet.dao;

import java.util.Date;
import java.util.List;

import org.lepro.storeprojet.entities.Categorie;
import org.lepro.storeprojet.entities.Client;
import org.lepro.storeprojet.entities.Commande;
import org.lepro.storeprojet.entities.LigneCommande;
import org.lepro.storeprojet.entities.Panier;
import org.lepro.storeprojet.entities.Produit;
import org.lepro.storeprojet.entities.Role;
import org.lepro.storeprojet.entities.Users;
import org.lepro.storeprojet.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class StoreDaoImpl implements StoreDao {

	@Autowired
	private CategorieRepository categorieRepository;
	@Autowired
	private ProduitRepository produitRepository;
	@Autowired
	private CommandeRepository commandeRepository;
	@Autowired
	private LigneCommandeRepository lcRepository;
	@Autowired
	private UsersRepository usersRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private ClientRepository clientRepository;

	@Override
	public Long ajouterCategorie(Categorie c) {
		categorieRepository.save(c);
		return c.getIdCategorie();
	}

	@Override
	public List<Categorie> listCategories() {
		// TODO Auto-generated method stub
		return categorieRepository.findAll();
	}

	@Override
	public Categorie getCategorie(Long idCat) {
		// TODO Auto-generated method stub
		return categorieRepository.findByIdC(idCat);
	}

	@Override
	public void supprimerCategorie(Long idCat) {
		categorieRepository.deleteById(idCat);

	}

	@Override
	public void modifierCategorie(Categorie C) {
		categorieRepository.save(C);

	}

	@Override
	public Long ajouterProduit(Produit p, Long idCat) {
		Categorie c = new Categorie();
		c.setIdCategorie(idCat);
		p.setCategorie(c);
		produitRepository.save(p);
		return p.getIdProduit();
	}

	@Override
	public List<Produit> listProduit() {

		return produitRepository.findAll();
	}

	@Override
	public List<Produit> produitsParCategorie(Categorie c) {
		// TODO Auto-generated method stub
		return produitRepository.findAllBycategorie(c);
	}

	@Override
	public List<Produit> produitsParMotCle(String mc) {
		// TODO Auto-generated method stub
		return produitRepository.findAllByMotCle("%" + mc + "%");
	}

	@Override
	public List<Produit> produitsSelectionnes() {
		// TODO Auto-generated method stub
		return produitRepository.listProduitSelected();
	}

	@Override
	public Produit getProduit(Long idP) {
		// TODO Auto-generated method stub
		return produitRepository.findByIdC(idP);
	}

	@Override
	public void supprimerProduit(Long idP) {
		produitRepository.deleteById(idP);

	}

	@Override
	public void modifierProduit(Produit P) {
		produitRepository.save(P);

	}

	@Override
	public void ajouterUser(Users u) {
		usersRepository.save(u);
	}

	@Override
	public void attribuerRole(Role r, Long usersID) {
		Users u = usersRepository.getOne(usersID);
		u.getRoles().add(r);
		roleRepository.save(r);

	}

	@Override
	public Commande enregistrerCommande(Panier p, Client c) {
		clientRepository.save(c);
		Commande commande = new Commande();
		commande.setDateCommande(DateUtils.convertDateToLocalDateTime(new Date()));
		commande.setItems(p.getItems());
		commande.setClient(c);
		for (LigneCommande lc : p.getItems()) {
			lcRepository.save(lc);
		}
		commandeRepository.save(commande);
		return commande;
	}

	@Override
	public Long ajouterClient(Client c) {
		clientRepository.save(c);
		return c.getIdClient();

	}

	@Override
	public List<Client> listClient() {
		// TODO Auto-generated method stub
		return clientRepository.findAll();
	}

	@Override
	public Page<Produit> searchProduit(String mc, Pageable pageable) {
		// TODO Auto-generated method stub
		return produitRepository.chercher(mc, pageable);
	}

	@Override
	public Page<Categorie> searchCategorie(String mc, Pageable pageable) {
		// TODO Auto-generated method stub
		return categorieRepository.chercher(mc, pageable);
	}

	@Override
	public Page<Client> searchClient(String mc, Pageable pageable) {
		// TODO Auto-generated method stub
		return clientRepository.chercher(mc, pageable);
	}

	@Override
	public Client getClient(Long idCl) {
		// TODO Auto-generated method stub
		return clientRepository.findByIdC(idCl);
	}

}
