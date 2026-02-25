package com.adminPanel.app.controller;

import com.adminPanel.app.model.Product;
import com.adminPanel.app.model.ProductDetails;
import com.adminPanel.app.util.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showHomePage(Model productModel){
        List<Product> productList = productService.getAllProducts();
        productModel.addAttribute("productList", productList);
        return "homePage";
    }

    @RequestMapping(value = "/showProductDetails", method = RequestMethod.GET)
    public String showViewDetailsPage(@RequestParam("item") Product product, Model productDetailsModel){
        productDetailsModel.addAttribute("productDetails", product.getProductDetails());
        return "viewDetailsPage";
    }

    @RequestMapping(value = "/updateProduct", method = RequestMethod.GET)
    public String showUpdateDetailsForm(@RequestParam("item") Product product, Model productDetailsModel){
        productDetailsModel.addAttribute("productDetailsModel", product.getProductDetails());
        return "updateDetailsForm";
    }

    @RequestMapping(value = "/deleteProduct", method = RequestMethod.GET)
    public String deleteProduct(@RequestParam("item") Product product, Model productModel){
        productService.deleteById(product.getId());
        List<Product> productList = productService.getAllProducts();
        productModel.addAttribute("productList", productList);
        return "redirect:/";
    }

    @RequestMapping(value = "/addProduct", method = RequestMethod.POST)
    public String addProduct(Model productModel){
        productModel.addAttribute("productModel", new ProductDetails());
        return "addProductForm";
    }

    @RequestMapping(value = "/processUpdateProductForm", method = RequestMethod.POST)
    public String updateProductForm(@ModelAttribute("productDetailsModel") ProductDetails productDetails, Model productModel){
        productService.update(productDetails);
        //if(result.equals("Success!")) {
        List<Product> productList = productService.getAllProducts();
        productModel.addAttribute("productList", productList);
        return "homePage";
        /*
        }

        else{
            return "addProductForm";
        } */
    }

    @RequestMapping(value = "/processAddProduct", method = RequestMethod.POST)
    public String addProductForm(@ModelAttribute("productDetailsModel") ProductDetails productDetails, Model productModel){
        productService.insert(productDetails);
        //if(result.equals("Success!")) {
        List<Product> productList = productService.getAllProducts();
        productModel.addAttribute("productList", productList);
        return "homePage";
        /*}
        else{
            return "addProductForm";
        }*/
    }

    @RequestMapping(value = "/viewBackHome", method = RequestMethod.GET)
    public String viewBackHome(Model productModel){
        List<Product> productList = productService.getAllProducts();
        productModel.addAttribute("productList", productList);
        return "homePage";
    }

    @RequestMapping(value = "/updateBackHome", method = RequestMethod.GET)
    public String updateBackHome(Model productModel){
        List<Product> productList = productService.getAllProducts();
        productModel.addAttribute("productList", productList);
        return "homePage";
    }

    @RequestMapping(value = "/addBackHome", method = RequestMethod.GET)
    public String addBackHome(Model productModel){
        List<Product> productList = productService.getAllProducts();
        productModel.addAttribute("productList", productList);
        return "homePage";
    }

    @InitBinder
    public void initBinder(WebDataBinder dataBinder){
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }
}
