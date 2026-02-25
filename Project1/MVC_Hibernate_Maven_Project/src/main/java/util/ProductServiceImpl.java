package com.adminPanel.app.util;

import com.adminPanel.app.dao.ProductDao;
import com.adminPanel.app.model.Product;
import com.adminPanel.app.model.ProductDetails;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.InitBinder;

import javax.validation.ConstraintValidator;
import java.util.List;
import java.util.Set;

@Service
public class ProductServiceImpl implements ProductService{

    //private javax.validation.Validator validator;

    @Autowired
    private ProductDao productDao;

    @Override
    public void insert(ProductDetails productDetails){
        /*if(bindingResult.hasErrors())
            return "Error!";
        else {*/
        productDao.insert(productDetails);
    /*        return "Success!";
        }*/
    }

    @Override
    public Product findById(int theId){
        return productDao.findById(theId);
    }

    @Override
    public void deleteById(int theId){
        productDao.deleteById(theId);
    }

    @Override
    public void update(ProductDetails productDetails){
        /*Set<ConstraintValidator<ProductDetails>> violations = validator.validate(productDetails);
        if(!violations.isEmpty()){
            throw
        }
        if(bindingResult.hasErrors())
            return "Error!";
        else {*/
        productDao.insert(productDetails);
        /*return "Success!";
        }*/
    }

    @Override
    public List<Product> getAllProducts(){
        return productDao.getAllProducts();
    }
}
