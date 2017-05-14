package com.team.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
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
import com.team.domain.User;
import com.team.service.ContactService;
import com.team.service.ProductService;
import com.team.service.SaleService;
import com.team.service.UserDetailsService;
import com.team.service.UserService;

@Controller
public class ContactController {
	
	@Autowired
	private ContactService contactService;
	@Autowired
	private ProductService productService;
	@Autowired
	private SaleService saleService;
	@Autowired
	private UserService userDetailsService;
	
	
	//đăng kí đăng nhập
		@GetMapping("/test")
		public String index_page(Model model) {
			model.addAttribute("user", getUserLogin());
			return "/test/index";
		}

		
		@GetMapping("/test/admin") 
		public String admin() {
			return "/test/admin";
		}
		
		@GetMapping("/test/403")
		public String accessDenied() {
			return "/test/403";
		}
		
		@GetMapping("/test/login") 
		public String getLogin() {
			
			return "/test/login";
		}
		
		
		@GetMapping("logout")
		public String logout(HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		    if (auth != null) {
		        new SecurityContextLogoutHandler().logout(request, response, auth);
		        redirectAttributes.addFlashAttribute("logoutMes","you are logout");
		    }
		    return "redirect:/market";
		}
		
		//
	    @GetMapping("/market/login")
	    public String login(Model model) {
	        return "login";
	    }
	    
		@GetMapping("/login") 
		public String getLogin_() {
			
			return "login";
		}
		
		@GetMapping("/signup") 
		public String getSignup() {
			
			return "signup";
		}
	    
	
	
	
	
    @GetMapping("/admin")
    public String index_admin(Model model) {
        return "admin/index";
    }
    
    @GetMapping("/admin/login")
    public String admin_login(Model model) {
        return "admin/login";
    }
    
    //hàm này sẽ lấy người dùng đã đăng nhập và trả về đối tựng người dùng đó
    public User getUserLogin(){
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    	String name = auth.getName();
    	User u=userDetailsService.findByEmail(name);
    	return u;
    }
    @GetMapping("/market")
    public String index(Model model) {
    	model.addAttribute("user", getUserLogin());
        return "index";
    }
    
    @GetMapping("/market/create")
    public String create(Model model) {
    	model.addAttribute("user", getUserLogin());
        model.addAttribute("contact", new Contact());
        return "form";
    }
    @GetMapping("/market/help")
    public String help(Model model) {
    	model.addAttribute("user", getUserLogin());
        return "help";
    }
    @GetMapping("/market/card")
    public String card(Model model) {
    	model.addAttribute("user", getUserLogin());
        return "card";
    }
    @GetMapping("/market/contact")
    public String contact(Model model) {
    	model.addAttribute("user", getUserLogin());
        return "contact";
    }
    @GetMapping("/market/about")
    public String about(Model model) {
    	model.addAttribute("user", getUserLogin());
        return "about";
    }
    @GetMapping("/market/faq")
    public String faq(Model model) {
    	model.addAttribute("user", getUserLogin());
        return "faq";
    }
    @GetMapping("/market/marketplace")
    public String marketplace(Model model) {
    	model.addAttribute("user", getUserLogin());
        return "marketplace";
    }
    @GetMapping("/market/offers")
    public String offers(Model model) {
    	model.addAttribute("user", getUserLogin());
        return "offers";
    }
    @GetMapping("/market/privacy")
    public String privacy(Model model) {
    	model.addAttribute("user", getUserLogin());
        return "privacy";
    }
    @GetMapping("/market/signup")
    public String signup(Model model) {
    	model.addAttribute("user", getUserLogin());
        return "signup";
    }
    @GetMapping("/market/sitemap")
    public String sitemap(Model model) {
    	model.addAttribute("user", getUserLogin());
        return "sitemap";
    }
    @GetMapping("/market/value")
    public String value(Model model) {
    	model.addAttribute("user", getUserLogin());
        return "value";
    }
    @GetMapping("/market/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
    	model.addAttribute("user", getUserLogin());
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
        model.addAttribute("user", getUserLogin());
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
    	model.addAttribute("user", getUserLogin());
        return "single";
    }
    

    
    
}
