package org.lepro.storeprojet.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Panier implements Serializable {

	private Map<Long, LigneCommande> items = new HashMap<>();

	public void addArticle(Produit p, int quantity) {
		if (items.get(p.getIdProduit()) == null) {
			LigneCommande lc = new LigneCommande();
			lc.setProduit(p);
			lc.setQuantity(quantity);
			lc.setPrix(p.getPrix());
		} else {
			LigneCommande lc = items.get(p.getIdProduit());
			lc.setQuantity(lc.getQuantity() + quantity);
		}
	}

	public Collection<LigneCommande> getItems() {
		return items.values();
	}

	public double getTotal() {
		double total = 0;
		for (LigneCommande lc : items.values()) {
			total += lc.getPrix() * lc.getQuantity();
		}
		return total;
	}

	public int getSize() {
		return items.size();
	}

	public void deleteItem(Long idProduit) {
		items.remove(idProduit);
	}
}
