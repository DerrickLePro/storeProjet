package org.lepro.storeprojet.controller;

import java.util.List;

import org.lepro.storeprojet.entities.Client;
import org.lepro.storeprojet.entities.Produit;
import org.lepro.storeprojet.metier.IAdminMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/admin")
public class AdminController {

	@Autowired
	IAdminMetier metier;

	@RequestMapping(value = "/clients", method = RequestMethod.GET)
	public List<Client> getClients() {
		return metier.listClient();
	}

	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public List<Produit> getProduits() {
		return metier.listProduit();
	}

	Page<Produit> reslt;

	@RequestMapping(value = "/searchProduct", method = RequestMethod.GET)
	public Page<Produit> seachProduct(@RequestParam(name = "mc", defaultValue = "") String mc,
			@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "12") int size) {

		return null;
	}
}
