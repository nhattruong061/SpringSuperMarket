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

import com.team.domain.Sale;
import com.team.service.SaleService;

@Controller
public class SaleController {
	
	@Autowired
	private SaleService saleService;
	
	 @GetMapping("/admin/sale")
	 public String index(Model model) {
		 model.addAttribute("sales", saleService.findAll());
		 return "/admin/sale";
	 }
	 
	@GetMapping("/admin/sale/create")
	    public String create(Model model) {
	    	model.addAttribute("sale", new Sale());
	        return "/admin/sale_form";
	    }
	    
	    @GetMapping("/admin/sale/{id}/edit")
	    public String edit(@PathVariable int id, Model model) {
	        model.addAttribute("sale", saleService.findOne(id));
	        return "/admin/sale_form";
	    }
	    
	    @PostMapping("/admin/sale/save")
	    public String save(@Valid Sale sale, BindingResult result, RedirectAttributes redirect) {
	        if (result.hasErrors()) {
	            return "/admin/sale_form";
	        }
	        saleService.save(sale);
	        redirect.addFlashAttribute("success", "Saved contact successfully!");
	        return "redirect:/admin/sale";
	    }
	    
	    @GetMapping("/admin/sale/{id}/delete")
	    public String delete(@PathVariable int id, RedirectAttributes redirect) {
	        saleService.delete(id);
	        redirect.addFlashAttribute("success", "Deleted user successfully!");
	        return "redirect:/admin/sale";
	    }
}
