package com.team.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.team.domain.ProductRating;
import com.team.service.ProductRatingService;

@Controller
public class ProductRatingController {
	
	@Autowired
	private ProductRatingService productRatingService;
	
	 @GetMapping("/admin/product_rating")
	 public String index(Model model) {
		 model.addAttribute("productRatings", productRatingService.findAll());
		 return "/admin/product_rating";
	 }
	 
	@GetMapping("/admin/product_rating/create")
	    public String create(Model model) {
	    	model.addAttribute("productRating", new ProductRating());
	        return "/admin/product_rating_form";
	    }
	    
	    @GetMapping("/admin/product_rating/{id}/edit")
	    public String edit(@PathVariable int id, Model model) {
	        model.addAttribute("productRating", productRatingService.findOne(id));
	        return "/admin/product_rating_form";
	    }
	    
	    @PostMapping("/admin/product_rating/save")
	    public String save(@Valid ProductRating productRating, BindingResult result, RedirectAttributes redirect) {
	        if (result.hasErrors()) {
	            return "/admin/product_rating_form";
	        }
	        productRatingService.save(productRating);
	        redirect.addFlashAttribute("success", "Saved contact successfully!");
	        return "redirect:/admin/product_rating";
	    }
	    
	    @GetMapping("/admin/product_rating/{id}/delete")
	    public String delete(@PathVariable int id, RedirectAttributes redirect) {
	        productRatingService.delete(id);
	        redirect.addFlashAttribute("success", "Deleted user successfully!");
	        return "redirect:/admin/product_rating";
	    }
}
