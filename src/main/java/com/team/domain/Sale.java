package com.team.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sale")
public class Sale implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	 @Column(name = "id", nullable = false)
	 private int id;
	 
	 @Column(name = "id_product", nullable = false)
	 private int id_product;
	 
	 @Column(name = "percent_sale", nullable = false)
	 private int percent_sale;
	 
	 @Column(name = "form_date", nullable = false)
	 private String form_date;
	 
	 @Column(name = "to_date", nullable = false)
	 private String to_date;
	 
	 @Column(name = "created", nullable = false)
	 private String created;
	 
	 @Column(name = "modified", nullable = false)
	 private String modified;
	 
	 public Sale(){
		 super();
	 }
	 
	 public Sale(int id, int id_product, int percent_sale, String form_date, String to_date, String created, String modified){
		 super();
		 this.id=id;
		 this.id_product=id_product;
		 this.percent_sale=percent_sale;
		 this.form_date=form_date;
		 this.to_date=to_date;
		 this.created=created;
		 this.modified=modified;
	 }
	 
	 public int getId(){
		 return this.id;
	 }
	 
	 public void setId(int id){
		 this.id=id;
	 }
	 
	 public int getId_product(){
		 return this.id_product;
	 }
	 
	 public void setId_product(int id_product){
		 this.id_product=id_product;
	 }
	 
	 public int getPercent_sale(){
		 return this.percent_sale;
	 }
	 
	 public void setPercent_sale(int percent_sale){
		 this.percent_sale=percent_sale;
	 }
	 
	 public String getForm_date(){
		 return this.form_date;
	 }
	 
	 public void setForm_date(String form_date){
		 this.form_date=form_date;
	 }
	 
	 public String getTo_date(){
		 return this.to_date;
	 }
	 
	 public void setTo_date(String to_date){
		 this.to_date=to_date;
	 }
	 
	 public String getCreated(){
		 return this.created;
	 }
	 
	 public void setCreated(String created){
		 this.created=created;
	 }
	 
	 public String getModified(){
		 return this.modified;
	 }
	 
	 public void setModified(String modified){
		 this.modified=modified;
	 }
	 
	 public static long getSerialversionuid() {
			return serialVersionUID;
	}
}
