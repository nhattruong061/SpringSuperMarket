package com.team.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.team.domain.Contact;
import com.team.domain.Product;
import com.team.service.ProductService;
import com.team.service.UserService;

@Controller
public class ProductController {
	
	@Autowired
	private ProductService productService;

    @GetMapping("/admin/product")
    public String index(Model model) {
        model.addAttribute("products", productService.findAll());
    	return "/admin/product";
    }
    
    @GetMapping("/admin/product/{id}/delete")
    public String delete(@PathVariable int id, RedirectAttributes redirect) {
        productService.delete(id);
        redirect.addFlashAttribute("success", "Deleted user successfully!");
        return "redirect:/admin/product";
     }
}
