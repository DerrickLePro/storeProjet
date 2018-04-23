package org.lepro.storeprojet.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
public class Image implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPhoto;
	@NotEmpty
	@Size(min = 4, max = 45)
	private String nomPhoto;
	private String description;
	private String imageToShow;
	public Image(@NotEmpty @Size(min = 4, max = 45) String nomPhoto, String description, String imageToShow) {
		super();
		this.nomPhoto = nomPhoto;
		this.description = description;
		this.imageToShow = imageToShow;
	}
	public Image() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getIdPhoto() {
		return idPhoto;
	}
	public void setIdPhoto(Long idPhoto) {
		this.idPhoto = idPhoto;
	}
	public String getNomPhoto() {
		return nomPhoto;
	}
	public void setNomPhoto(String nomPhoto) {
		this.nomPhoto = nomPhoto;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImageToShow() {
		return imageToShow;
	}
	public void setImageToShow(String imageToShow) {
		this.imageToShow = imageToShow;
	}
	
	

}
