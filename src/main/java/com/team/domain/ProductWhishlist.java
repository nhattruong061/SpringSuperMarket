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
	 
	 @Column(name = "id_product", nullable = false)
	 private int id_product;
	 
	 @Column(name = "id_user", nullable = false)
	 private int id_user;
	 
	 @Column(name = "is_whishlist", nullable = false)
	 private int is_whishlist;
	 
	 @Column(name = "created", nullable = false)
	 private String created;
	 
	 @Column(name = "modified", nullable = false)
	 private String modified;
	 
	 public ProductWhishlist() {
		 super();
	}

	public ProductWhishlist(int id, int id_product, int id_user, int is_whishlist,  String created, String modified) {
		super();
		this.id = id;
		this.id_product=id_product;
		this.id_user=id_user;
		this.is_whishlist=is_whishlist;
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
		return id_product;
	}
	
	public void setId_product(int id_product){
		this.id_product =id_product;
	}

	public int getId_user(){
		return id_user;
	}
	
	public void setId_user(int id_user){
		this.id_user =id_user;
	}
	
	public int getIs_whishlist(){
		return is_whishlist;
	}
	
	public void setIs_whishlist(int is_whishlist){
		this.is_whishlist =is_whishlist;
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
