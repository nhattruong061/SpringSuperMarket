package com.team.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product_whishlist")
public class ProductWhishlist implements Serializable{
	
	 private static final long serialVersionUID = 1L;
	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	 @Column(name = "id", nullable = false)
	 private int id;
	 
	 @Column(name = "idProduct", nullable = false)
	 private int idProduct;
	 
	 @Column(name = "idUser", nullable = false)
	 private int idUser;
	 
	 @Column(name = "isWhishlist", nullable = false)
	 private int isWhishlist;
	 
	 @Column(name = "created", nullable = false)
	 private String created;
	 
	 @Column(name = "modified", nullable = false)
	 private String modified;
	 
	 public ProductWhishlist() {
		 super();
	}

	public ProductWhishlist(int id, int idProduct, int idUser, int isWhishlist,  String created, String modified) {
		super();
		this.id = id;
		this.idProduct=idProduct;
		this.idUser=idUser;
		this.isWhishlist=isWhishlist;
		this.created=created;
		this.modified=modified;
	}
	
	public ProductWhishlist(int idProduct, int idUser, int isWhishlist,  String created, String modified) {
		super();
		this.idProduct=idProduct;
		this.idUser=idUser;
		this.isWhishlist=isWhishlist;
		this.created=created;
		this.modified=modified;
	}
	
	public int getId(){
		return id;
	}
	
	public void setId(int id){
		this.id =id;
	}
	
	public int getId_product(){
		return idProduct;
	}
	
	public void setId_product(int id_product){
		this.idProduct =id_product;
	}

	public int getId_user(){
		return idUser;
	}
	
	public void setId_user(int id_user){
		this.idUser =id_user;
	}
	
	public int getIs_whishlist(){
		return isWhishlist;
	}
	
	public void setIs_whishlist(int is_whishlist){
		this.isWhishlist =is_whishlist;
	}
	
	
	public String getCreated(){
		return created;
	}
	
	public void setCreated(String created){
		this.created=created;
	}
	
	public String getModified(){
		return modified;
	}
	
	public void setModified(String modified){
		this.modified=modified;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
