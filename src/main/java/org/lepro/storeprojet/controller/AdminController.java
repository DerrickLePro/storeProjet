package org.lepro.storeprojet.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Base64;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.lepro.storeprojet.entities.Categorie;
import org.lepro.storeprojet.entities.Client;
import org.lepro.storeprojet.entities.Produit;
import org.lepro.storeprojet.entities.Role;
import org.lepro.storeprojet.entities.Users;
import org.lepro.storeprojet.metier.IAdminMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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

	private Logger logger = Logger.getLogger(AdminController.class);

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
		System.out.println(p.getDescription());
		System.out.println(p.getPhoto().getNomPhoto());
		metier.saveImage(p.getPhoto());
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
		System.out.println(c.getDescription());
		System.out.println(c.getPhoto().getNomPhoto());

		metier.saveImage(c.getPhoto());
		return metier.ajouterCategorie(c);
	}
	// @RequestMapping(value="/photoCat/{idCat}",
	// produces=MediaType.IMAGE_JPEG_VALUE, method = RequestMethod.GET)
	// public byte[] photoCategorie(@PathVariable Long idCat) throws
	// IOException{
	// Categorie c = metier.getCategorie(idCat);
	// System.out.println(IOUtils.toByteArray(new
	// ByteArrayInputStream(c.getPhoto())));
	// System.out.println(org.apache.tomcat.util.codec.binary.Base64.encodeBase64(IOUtils.toByteArray(new
	// ByteArrayInputStream(c.getPhoto()))));
	// return
	// org.apache.tomcat.util.codec.binary.Base64.encodeBase64(IOUtils.toByteArray(new
	// ByteArrayInputStream(c.getPhoto())));
	// }

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

	private static String encodeFileToBase64Binary(MultipartFile file) {
		String encodedfile = null;
		try {
			byte[] encoded = Base64.getEncoder().encode(file.getBytes());
			encodedfile = encoded.toString();
			System.out.println(encodedfile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return encodedfile;
	}
}
