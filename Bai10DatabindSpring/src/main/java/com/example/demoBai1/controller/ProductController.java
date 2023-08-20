package com.example.demoBai1.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demoBai1.model.Product;
import com.example.demoBai1.service.ProductService;
import com.example.demoBai1.service.ProductServiceImpl;

@Controller
public class ProductController {
	
	 private ProductService productService = new ProductServiceImpl();
	 
	 //--------------------------------------------
	    @GetMapping("/")
	    public String index(Model model,RedirectAttributes redirect) {
	        model.addAttribute("products", productService.findAll());
	        redirect.addFlashAttribute("success", "");
	        return "index";
	    }
	    // -- cach viet sd databilding -- form:form / path
	    @GetMapping("/")
	    public String index2(Model model,RedirectAttributes redirect) {
	    	List<Product> productList = productService.findAll();
	        model.addAttribute("productList", productList);
	        redirect.addFlashAttribute("success", "");
	        return "index";
	    }
	    
	    
	    
	  //--------------------------------------------
	    @GetMapping("/product/create")
	    public String create(Model model) {
	        model.addAttribute("product", new Product());
	        return "create";
	    }

	    @PostMapping("/product/save")
	    public String save(Product product, RedirectAttributes redirect) {
	        product.setId((int)(Math.random() * 10000));
	        productService.save(product);
	        redirect.addFlashAttribute("success", "Saved product successfully!");
	        return "redirect:/";
	    }
		  //--------------------------------------------
	    @GetMapping("/product/{id}/edit")
	    public String edit(@PathVariable int id, Model model) {
	        model.addAttribute("product", productService.findById(id));
	        return "edit";
	    }

	    @PostMapping("/product/update")
	    public String update(Product product, RedirectAttributes redirect) {
	        productService.update(product.getId(), product);
	        redirect.addFlashAttribute("success", "Modified product successfully!");
	        return "redirect:/";
	    }
		  //--------------------------------------------
	    @GetMapping("/product/{id}/delete")
	    public String delete(@PathVariable int id, Model model) {
	        model.addAttribute("product", productService.findById(id));
	        return "delete";
	    }

	    @PostMapping("/product/delete")
	    public String delete(Product product, RedirectAttributes redirect) {
	        productService.remove(product.getId());
	        redirect.addFlashAttribute("success", "Removed product successfully!");
	        return "redirect:/";
	    }
		  //--------------------------------------------
	    @GetMapping("/product/{id}/view")
	    public String view(@PathVariable int id, Model model) {
	        model.addAttribute("product", productService.findById(id));
	        return "view";
	    }
	    // -- cach2
	    @GetMapping("/product/{id}/view")
	    public String view2(@PathVariable int id, Model model) {
	    	Product product = productService.findById(id);  	
	        model.addAttribute("productDetail",product);
	        return "view";
	    }
}