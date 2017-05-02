package com.team.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product_rating")
public class ProductRating implements Serializable{
	
	 private static final long serialVersionUID = 1L;
	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	 @Column(name = "id", nullable = false)
	 private int id;
	 
	 @Column(name = "id_product", nullable = false)
	 private int id_product;
	 
	 @Column(name = "id_user", nullable = false)
	 private int id_user;
	 
	 @Column(name = "rating", nullable = false)
	 private int rating;
	 
	 @Column(name = "comment_title", nullable = false)
	 private String comment_title;
	 
	 @Column(name = "comment_text", nullable = false)
	 private String comment_text;
	 
	 @Column(name = "created", nullable = false)
	 private String created;
	 
	 @Column(name = "modified", nullable = false)
	 private String modified;
	 
	 public ProductRating() {
		 super();
	}

	public ProductRating(int id, int id_product, int id_user, int rating, String comment_title, String comment_text, String created, String modified) {
		super();
		this.id = id;
		this.id_product=id_product;
		this.id_user=id_user;
		this.rating=rating;
		this.comment_title=comment_title;
		this.comment_text=comment_text;
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
	
	public int getRating(){
		return rating;
	}
	
	public void setRating(int rating){
		this.rating =rating;
	}
	
	public String getComment_title(){
		return comment_title;
	}
	
	public void setComment_title(String comment_title){
		this.comment_title =comment_title;
	}
	
	public String getComment_text(){
		return comment_text;
	}
	
	public void setComment_text(String comment_text){
		this.comment_text =comment_text;
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
