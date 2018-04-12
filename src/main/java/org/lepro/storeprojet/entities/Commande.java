package org.lepro.storeprojet.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Commande implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCommande;
	private LocalDateTime dateCommande;
	@OneToMany(mappedBy = "commande")
	private Collection<LigneCommande> items;
	@ManyToOne
	@JoinColumn(name = "client_id")
	private Client client;

	public Long getIdCommande() {
		return idCommande;
	}

	public void setIdCommande(Long idCommande) {
		this.idCommande = idCommande;
	}

	public LocalDateTime getDateCommande() {
		return dateCommande;
	}

	public void setDateCommande(LocalDateTime dateCommande) {
		this.dateCommande = dateCommande;
	}

	public Collection<LigneCommande> getItems() {
		return items;
	}

	public void setItems(Collection<LigneCommande> items) {
		this.items = items;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Commande() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Commande(LocalDateTime dateCommande, ArrayList<LigneCommande> items, Client client) {
		super();
		this.dateCommande = dateCommande;
		this.items = items;
		this.client = client;
	}

}
