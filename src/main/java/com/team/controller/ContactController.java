package com.team.controller;

import javax.validation.Valid;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jayway.jsonpath.internal.function.text.Length;
import com.team.domain.Contact;
import com.team.domain.Product;
import com.team.domain.Sale;
import com.team.service.ContactService;
import com.team.service.ProductService;
import com.team.service.SaleService;

@Controller
public class ContactController {
	
	@Autowired
	private ContactService contactService;
	@Autowired
	private ProductService productService;
	@Autowired
	private SaleService saleService;
	
    @GetMapping("/admin")
    public String index_admin(Model model) {
        return "admin/index";
    }
    
    @GetMapping("/admin/login")
    public String admin_login(Model model) {
        return "admin/login";
    }
    
    @GetMapping("/market")
    public String index(Model model) {
        /*model.addAttribute("contacts", contactService.findAll());*/
        return "index";
    }
    
    @GetMapping("/market/create")
    public String create(Model model) {
        model.addAttribute("contact", new Contact());
        return "form";
    }
    @GetMapping("/market/help")
    public String help(Model model) {
        return "help";
    }
    @GetMapping("/market/card")
    public String card(Model model) {
        return "card";
    }
    @GetMapping("/market/contact")
    public String contact(Model model) {
        return "contact";
    }
    @GetMapping("/market/about")
    public String about(Model model) {
        return "about";
    }
    @GetMapping("/market/faq")
    public String faq(Model model) {
        return "faq";
    }
    @GetMapping("/market/marketplace")
    public String marketplace(Model model) {
        return "marketplace";
    }
    @GetMapping("/market/offers")
    public String offers(Model model) {
        return "offers";
    }
    @GetMapping("/market/privacy")
    public String privacy(Model model) {
        return "privacy";
    }
    @GetMapping("/market/signup")
    public String signup(Model model) {
        return "signup";
    }
    @GetMapping("/market/sitemap")
    public String sitemap(Model model) {
        return "sitemap";
    }
    @GetMapping("/market/value")
    public String value(Model model) {
        return "value";
    }
    @GetMapping("/market/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("contact", contactService.findOne(id));
        return "form";
    }
    
    @PostMapping("/market/save")
    public String save(@Valid Contact contact, BindingResult result, RedirectAttributes redirect) {
        if (result.hasErrors()) {
            return "form";
        }
        contactService.save(contact);
        redirect.addFlashAttribute("success", "Saved contact successfully!");
        return "redirect:/market";
    }
    
    @GetMapping("/market/{id}/delete")
    public String delete(@PathVariable int id, RedirectAttributes redirect) {
        contactService.delete(id);
        redirect.addFlashAttribute("success", "Deleted contact successfully!");
        return "redirect:/market";
     }
    
    @GetMapping("/market/search")
    public String search(@RequestParam("q") String q, Model model) {
        if (q.equals("")) {
            return "redirect:/market";
        }
        
        model.addAttribute("contacts", contactService.search(q));
        return "list";
    }
    
    @GetMapping("/market/products")
    public String products(Model model) {
    	model.addAttribute("products",productService.findAll());
        return "products";
    }
    
    @GetMapping("/market/{id}/single")
    public String single(@PathVariable int id, Model model) throws Exception {
    	Product p=new Product();
    	p=productService.findOne(id);
    	if(p.getIs_sale()==1)
    	{
    		Sale s=new Sale();
    		s=saleService.findByIdproduct(p.getId());
    		p.setIs_sale(s.getPercent_sale());
    		model.addAttribute("product", p);
    		model.addAttribute("end_sale_date", s.getTo_date());
    	}
    	else
    	{
    		model.addAttribute("product", p);
    		model.addAttribute("end_sale_date", "null");
    	}
    	String p_price_unit="$";
    	if(p.getPrice_unit()==1)
    	{
    		 p_price_unit=" VND";
    	}
    	String[] arrImage=p.getImages().split(",");
    	for(int i=0;i<arrImage.length;i++)
    	{
    		arrImage[i]=arrImage[i].trim();
    	}
    	model.addAttribute("images",  arrImage);
    	model.addAttribute("listPrType",  productService.findTop10ByType(p.getType()));
    	model.addAttribute("product_price_unit",  p_price_unit);
        return "single";
    }
    
    @GetMapping("/market/login")
    public String login(Model model) {
        return "login";
    }
}
