package org.lepro.storeprojet.controller;

import java.util.List;

import org.lepro.storeprojet.entities.Categorie;
import org.lepro.storeprojet.entities.Client;
import org.lepro.storeprojet.entities.Produit;
import org.lepro.storeprojet.entities.Role;
import org.lepro.storeprojet.entities.Users;
import org.lepro.storeprojet.metier.IAdminMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author derrick.kaffo
 *
 */

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/admin")
public class AdminController {

	@Autowired
	IAdminMetier metier;

	/**
	 * Client
	 */

	@RequestMapping(value = "/client/clients", method = RequestMethod.GET)
	public List<Client> getClients() {
		return metier.listClient();
	}

	@RequestMapping(value = "/client/{id}", method = RequestMethod.GET)
	public Client getClient(@PathVariable Long id) {
		return metier.getClient(id);
	}

	/*
	 * Product
	 */

	@RequestMapping(value = "/product/all", method = RequestMethod.GET)
	public List<Produit> getProduits() {
		return metier.listProduit();
	}

	@RequestMapping(value = "/product/select", method = RequestMethod.GET)
	public List<Produit> getProduitsSeleled() {
		return metier.produitsSelectionnes();
	}

	@RequestMapping(value = "/product/cat/{idCat}", method = RequestMethod.GET)
	public List<Produit> getProduitsSeleled(@PathVariable Long idCat) {
		Categorie cat = metier.getCategorie(idCat);
		return metier.produitsParCategorie(cat);
	}

	@RequestMapping(value = "/product/productsMc", method = RequestMethod.GET)
	public List<Produit> getProduitsMcle(@RequestParam(name = "mc", defaultValue = "") String mc) {
		return metier.produitsParMotCle(mc);
	}

	@SuppressWarnings("deprecation")
	@RequestMapping(value = "/product/searchProduct", method = RequestMethod.GET)
	public Page<Produit> seachProduct(@RequestParam(name = "mc", defaultValue = "") String mc,
			@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "12") int size) {

		return metier.searchProduit(mc, new PageRequest(page, size));
	}

	@RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
	public Produit getProduit(@PathVariable Long id) {
		return metier.getProduit(id);
	}

	@RequestMapping(value = "/product/add", method = RequestMethod.POST)
	public Long ajouterProduit(@RequestBody Produit p) {
		return metier.ajouterProduit(p, p.getCategorie().getIdCategorie());
	}

	@RequestMapping(value = "/product/{id}", method = RequestMethod.DELETE)
	public boolean delecteProduct(@PathVariable Long id) {
		metier.supprimerProduit(id);
		return true;
	}

	@RequestMapping(value = "/product/{id}", method = RequestMethod.PUT)
	public void updateProduct(@PathVariable Long id, @RequestBody Produit p) {
		p.setIdProduit(id);
		metier.modifierProduit(p);
	}

	/**
	 * Category
	 */

	@RequestMapping(value = "/category/{id}", method = RequestMethod.GET)
	public Categorie getCategorie(@PathVariable Long id) {
		return metier.getCategorie(id);
	}

	@RequestMapping(value = "/category/add", method = RequestMethod.POST)
	public Long ajouterCategorie(@RequestBody Categorie c) {
		return metier.ajouterCategorie(c);
	}

	@RequestMapping(value = "/category/{id}", method = RequestMethod.DELETE)
	public boolean delecteCategorie(@PathVariable Long id) {
		metier.supprimerCategorie(id);
		return true;
	}

	@RequestMapping(value = "/category/{id}", method = RequestMethod.PUT)
	public void updateCategorie(@PathVariable Long id, @RequestBody Categorie c) {
		c.setIdCategorie(id);
		metier.modifierCategorie(c);
	}

	@RequestMapping(value = "/category/all", method = RequestMethod.GET)
	public List<Categorie> getCategories() {
		return metier.listCategories();
	}

	@SuppressWarnings("deprecation")
	@RequestMapping(value = "/Category/searchCategory", method = RequestMethod.GET)
	public Page<Categorie> seachCategory(@RequestParam(name = "mc", defaultValue = "") String mc,
			@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "12") int size) {

		return metier.searchCategorie(mc, new PageRequest(page, size));
	}

	/**
	 * Users
	 */

	@RequestMapping(value = "/user/add", method = RequestMethod.POST)
	public void addUser(@RequestBody Users u) {
		metier.ajouterUser(u);
	}

	@RequestMapping(value = "/role/add/{id}", method = RequestMethod.POST)
	public void attribRole(@RequestBody Role r, @PathVariable Long idUsr) {
		metier.attribuerRole(r, idUsr);
	}
}
