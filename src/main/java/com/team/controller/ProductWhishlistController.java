package com.team.controller;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	    
	@GetMapping("/admin/product_whishlist/create_single_page")
    public String create_single_page(Model model) {
    	model.addAttribute("productWhishlist", new ProductWhishlist());
        return "/admin/product_whishlist_form";
    }
	
    @PostMapping("/admin/product_whishlist/create_single_page")
    public ResponseEntity<?> createdWhistlist(
            @Valid @RequestBody int idUser, int idProduct) {
    	
    	SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd");//dd/MM/yyyy
        Date now = new Date();
        String strDate = sdfDate.format(now);
        //da kiem tra khi document ready
        //neu da co thi dung service lay ra va set lai bien is_whishlist
        //neu chua co thi tao moi nhu o duoi
        ProductWhishlist wl = new ProductWhishlist(idProduct,idUser,1,strDate,strDate);

        int result=1;

        return ResponseEntity.ok("abc");
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
