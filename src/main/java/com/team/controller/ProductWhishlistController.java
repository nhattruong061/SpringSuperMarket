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

import com.team.domain.ProductWhishlist;
import com.team.service.ProductWhishlistService;

@Controller
public class ProductWhishlistController {
	
	@Autowired
	private ProductWhishlistService productWhishlistService;
	@GetMapping("/admin/product_whishlist")
	 public String index(Model model) {
		 model.addAttribute("productWhishlists", productWhishlistService.findAll());
		 return "/admin/product_whishlist";
	 }
	 
	@GetMapping("/admin/product_whishlist/create")
	    public String create(Model model) {
	    	model.addAttribute("productWhishlist", new ProductWhishlist());
	        return "/admin/product_whishlist_form";
	    }
	    
	    @GetMapping("/admin/product_whishlist/{id}/edit")
	    public String edit(@PathVariable int id, Model model) {
	        model.addAttribute("productWhishlist", productWhishlistService.findOne(id));
	        return "/admin/product_whishlist_form";
	    }
	    
	    @PostMapping("/admin/product_whishlist/save")
	    public String save(@Valid ProductWhishlist productWhishlist, BindingResult result, RedirectAttributes redirect) {
	        if (result.hasErrors()) {
	            return "/admin/product_whishlist_form";
	        }
	        productWhishlistService.save(productWhishlist);
	        redirect.addFlashAttribute("success", "Saved contact successfully!");
	        return "redirect:/admin/product_whishlist";
	    }
	    
	    @GetMapping("/admin/product_whishlist/{id}/delete")
	    public String delete(@PathVariable int id, RedirectAttributes redirect) {
	        productWhishlistService.delete(id);
	        redirect.addFlashAttribute("success", "Deleted user successfully!");
	        return "redirect:/admin/product_whishlist";
	    }
	
}
