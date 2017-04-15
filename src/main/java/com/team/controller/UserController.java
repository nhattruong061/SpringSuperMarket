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
import com.team.domain.User;
import com.team.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;

    @GetMapping("/admin/user")
    public String index(Model model) {
        model.addAttribute("users", userService.findAll());
    	return "/admin/user";
    }

/*    @GetMapping("/admin/user/create")
    public String create(Model model) {
        model.addAttribute("contact", new Contact());
        return "form";
    }*/
    
/*    @GetMapping("/admin/user/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("contact", userService.findOne(id));
        return "form";
    }
    */
   /* @PostMapping("/market/save")
    public String save(@Valid Contact contact, BindingResult result, RedirectAttributes redirect) {
        if (result.hasErrors()) {
            return "form";
        }
        contactService.save(contact);
        redirect.addFlashAttribute("success", "Saved contact successfully!");
        return "redirect:/market";
    }*/
    
    @GetMapping("/admin/user/{id}/delete")
    public String delete(@PathVariable int id, RedirectAttributes redirect) {
        userService.delete(id);
        redirect.addFlashAttribute("success", "Deleted user successfully!");
        return "redirect:/admin/user";
     }
}
