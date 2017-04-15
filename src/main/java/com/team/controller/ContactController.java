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
import com.team.service.ContactService;

@Controller
public class ContactController {
	
	@Autowired
	private ContactService contactService;

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
        return "products";
    }
    
    @GetMapping("/market/single")
    public String single(Model model) {
        return "single";
    }
    
    @GetMapping("/market/login")
    public String login(Model model) {
        return "login";
    }

}
