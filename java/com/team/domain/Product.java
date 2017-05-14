package com.team.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product implements Serializable{
	
	 private static final long serialVersionUID = 1L;
	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	 @Column(name = "id", nullable = false)
	 private int id;
	 
	 @Column(name = "name")
	 private String name;
	 
	 @Column(name = "price")
	 private int price;
	 
	 @Column(name = "price_unit")
	 private int price_unit;
	 
	 @Column(name = "type")
	 private int type;
	 
	 @Column(name = "is_sale")
	 private int is_sale;
	 
	 @Column(name = "is_offer")
	 private int is_offer;
	 
	 @Column(name = "id_coupon")
	 private int id_coupon;
	 
	 @Column(name = "images")
	 private String images;
	 
	 @Column(name = "main_image")
	 private String main_image;
	 
	 @Column(name = "description")
	 private String description;
	 
	 @Column(name = "processing_time")
	 private String processing_time;
	 
	 @Column(name = "addtional_info")
	 private String addtional_info;
	 
	 @Column(name = "view")
	 private int view;
	 
	 @Column(name = "created")
	 private String created;
	 
	 @Column(name = "modified")
	 private String modified;
	 
	 public Product() {
		 super();
	}

	public Product(int id, String name, int price, int price_unit, int type, int is_sale, 
			int is_offer, int id_coupon, String images, String main_image, String desciption, 
			String processing_time,String addtional_info, String created, String modified) {
		super();
		this.id = id;
		this.name = name;
		this.price=price;
		this.price_unit=price_unit;
		this.type=type;
		this.is_sale=is_sale;
		this.is_offer=is_offer;
		this.id_coupon=id_coupon;
		this.images=images;
		this.main_image=main_image;
		this.description=desciption;
		this.processing_time=processing_time;
		this.addtional_info=addtional_info;
		this.created = created;
		this.modified = modified;
	}
	
	public int getId(){
		return id;
	}
	
	public void setId(int id){
		this.id =id;
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name=name;
	}
	
	public int getPrice(){
		return price;
	}
	
	public void setPrice(int price){
		this.price=price;
	}
	
	public int getPrice_unit(){
		return price_unit;
	}
	
	public void setPrice_unit(int price_unit){
		this.price_unit=price_unit;
	}
	
	public int getType(){
		return type;
	}
	
	public void setType(int type){
		this.type=type;
	}
	
	public int getIs_sale(){
		return is_sale;
	}
	
	public void setIs_sale(int is_sale){
		this.is_sale=is_sale;
	}
	
	public int getIs_offer(){
		return is_offer;
	}
	
	public void setIs_offer(int is_offer){
		this.is_offer=is_offer;
	}
	
	public int getId_coupon(){
		return id_coupon;
	}
	
	public void setId_coupon(int id_coupon){
		this.id_coupon=id_coupon;
	}
	
	public String getImages(){
		return images;
	}
	
	public void setImages(String images){
		this.images=images;
	}
	
	public String getMain_image(){
		return main_image;
	}
	
	public void setMain_image(String main_image){
		this.main_image=main_image;
	}
	
	public String getDescription(){
		return description;
	}
	
	public void setDescription(String description){
		this.description=description;
	}
	
	public String getProcessing_time(){
		return processing_time;
	}
	
	public void setProcessing_time(String processing_time){
		this.processing_time=processing_time;
	}
	
	public String getAddtional_info(){
		return addtional_info;
	}
	
	public void setAddtional_info(String addtional_info){
		this.addtional_info=addtional_info;
	}
	
	public int getView(){
		return view;
	}
	
	public void setView(int view){
		this.view=view;
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
