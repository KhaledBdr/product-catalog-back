package com.fawry.productcatalog.configuration;
import com.fawry.productcatalog.entity.Category;
import com.fawry.productcatalog.entity.Product;
import com.fawry.productcatalog.repository.CategoryRepository;
import com.fawry.productcatalog.repository.ProductRepository;
import com.github.javafaker.Commerce;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataSeeder implements CommandLineRunner {

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ProductRepository productRepository;
    Faker faker = new Faker();

    public void addCategories(int n){
        List<Category> categories = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Category category = new Category();
            category.setName(faker.commerce().department());
            categories.add(category);
        }
        categoryRepository.saveAll(categories);
    }
    public void addProducts(int n){
        List<Product> products = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Commerce commerce = faker.commerce();
            StringBuilder productName = new StringBuilder(commerce.productName());
            Product product = new Product(
                    productName.toString(),
                    productName.toString(),
                    "Color is " + commerce.color()+"  and the material is " + commerce.material() +
                    " Promotion Code " + commerce.promotionCode(),
                    Double.valueOf(commerce.price() )+ 5.0,
                    n-i,
                    true,
                    new Category(1L , null , null)
            );
            products.add(product);
        }
        productRepository.saveAll(products);
    }

    @Override
    public void run(String... args) throws Exception {
        if (categoryRepository.count() == 0){
            addCategories(5);
        }
        if (productRepository.count() == 0){
            addProducts(10);
        }
    }
}
