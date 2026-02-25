package com.adminPanel.app.dao;

import com.adminPanel.app.model.Product;
import com.adminPanel.app.model.ProductDetails;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class ProductDaoImpl implements ProductDao{
    @Autowired
    SessionFactory sessionFactory;

    @Override
    @Transactional
    public void insert(ProductDetails productDetails){
        try{
            Session session = sessionFactory.getCurrentSession();
            Product product = new Product(productDetails.getName());
            product.setProductDetails(productDetails);
            session.save(productDetails);
            session.save(product);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    @Transactional
    public Product findById(int theId){
        try{
            Session session = sessionFactory.getCurrentSession();
            Product product = (Product) session.get(Product.class, theId);
            return product;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    @Transactional
    public void deleteById(int theId){
        try{
            Session session = sessionFactory.getCurrentSession();
            Product product = (Product) session.get(Product.class, theId);

            Query query = session.createQuery("delete ProductDetails where id=:productDetailsId");
            query.setParameter("productDetailsId", product.getProductDetails().getId());
            query.executeUpdate();

            query = session.createQuery("delete Product where id=:productId");
            query.setParameter("productId", product.getId());
            query.executeUpdate();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    @Transactional
    public void update(ProductDetails productDetails){
        try {
            Session session = sessionFactory.getCurrentSession();
            int productId = productDetails.getId();
            Query query = session.createQuery("update ProductDetails set name=:n, " +
                    "expirationDate=:e, manufacturer=:m, price=:p, available=:a where id=:i");
            query.setParameter("n", productDetails.getName());
            query.setParameter("e", productDetails.getExpirationDate());
            query.setParameter("m", productDetails.getManufacturer());
            query.setParameter("p", productDetails.getPrice());
            query.setParameter("a", productDetails.isAvailable());
            query.setParameter("i", productId);
            Product product = (Product) session.get(Product.class, productId);
            if(!product.getName().equals(productDetails.getName())){
                product.setName(productDetails.getName());
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    @Transactional
    public List<Product> getAllProducts(){
        try {
            Session session = sessionFactory.getCurrentSession();
            Query query = session.createQuery("from Product");
            List<Product> products = query.getResultList();
            return products;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
