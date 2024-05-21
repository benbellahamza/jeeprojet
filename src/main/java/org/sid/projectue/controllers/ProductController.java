package org.sid.projectue.controllers;

import org.sid.projectue.entities.Product;
import org.sid.projectue.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/Allproduct")
    public String allProducts(Model model,
                              @RequestParam(name = "Search", defaultValue = "") String kw,
<<<<<<< HEAD
                              @RequestParam(name = "size", defaultValue = "6") int size,
=======
                              @RequestParam(name = "size", defaultValue = "5") int size,
>>>>>>> 2e6dfdcff4c39999ebe6d5bb7d3fe55650525531
                              @RequestParam(name = "page", defaultValue = "0") int page) {
        Page<Product> pageProduct = productService.findProductByName(kw, page, size);
        model.addAttribute("products", pageProduct.getContent());
        model.addAttribute("pages", new int[pageProduct.getTotalPages()]);
        model.addAttribute("currentPage", page);
        model.addAttribute("Search", kw);
        return "productList";
    }

    @GetMapping("/{id}")
    public String getProduct(@PathVariable Long id, Model model) {
        Product product = productService.getProduct(id);
        model.addAttribute("product", product);
        return "productDetails";
    }

    @GetMapping("/Addproduct")
    public String addProduct(Model model) {
        return "addproduct";
    }

    @GetMapping("/UpdateViewProduct/{id}")
    public String updateProductView(@PathVariable("id") Long id, Model model) {
        model.addAttribute("product", productService.getProduct(id));
        model.addAttribute("modelProduct", new Product());
        return "updateProduct";
    }

    @PostMapping("/updateProduct/{id}")
    public String updateProduct(@PathVariable Long id, @ModelAttribute("product") Product product) {
        productService.modifyProduct(id, product);
        return "redirect:/product/Allproduct";
    }

    @PostMapping("/Addproduct")
    public String addProductPost(Model model,
                                 @RequestParam(name = "name") String name,
                                 @RequestParam(name = "description") String desc,
<<<<<<< HEAD
                                 @RequestParam(name = "imageurl") String imgUrl
                                    ,@RequestParam (name ="prix")float prix)
    {
        Product product = new Product();
        product.setName(name);
        product.setDescription(desc);
        product.setImageUrl(imgUrl);
        product.setPrix(prix);
=======
                                 @RequestParam(name = "imageurl") String imgUrl,
                                 @RequestParam(name = "url") String url) {
        Product product = new Product();
        product.setName(name);
        product.setDescription(desc);
        product.setUrl(url);
        product.setImageUrl(imgUrl);
>>>>>>> 2e6dfdcff4c39999ebe6d5bb7d3fe55650525531
        product.setDatePublication(new Date());
        productService.addProduct(product);
        return "redirect:/product/Allproduct";
    }

    @GetMapping("/deleteProduct/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return "redirect:/product/Allproduct";
    }
}
