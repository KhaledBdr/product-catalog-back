package com.fawry.productcatalog.service.implemenation;

import com.fawry.productcatalog.dto.ProductDTO;
import com.fawry.productcatalog.dto.UpdateProductNameDTO;
import com.fawry.productcatalog.dto.UpdateProductPriceDTO;
import com.fawry.productcatalog.dto.UpdateProductQuantityDTO;
import com.fawry.productcatalog.entity.Category;
import com.fawry.productcatalog.entity.Product;
import com.fawry.productcatalog.exception.EntityNotFoundException;
import com.fawry.productcatalog.mapper.ProductMapper;
import com.fawry.productcatalog.mapper.UpdateProductMapper;
import com.fawry.productcatalog.repository.ProductRepository;
import com.fawry.productcatalog.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service

public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private UpdateProductMapper updateMapper;
    @Override
    public ProductDTO addProduct(ProductDTO productDTO) {
        Product product = productMapper.unmap(productDTO);
        return productMapper.map(productRepository.save(product));
    }

    @Override
    public ProductDTO getById(Long id) {
        Product product = productRepository
                .findById(id)
                .orElseThrow(()-> new EntityNotFoundException());
        return productMapper.map(product);
    }

    @Override
    public List<ProductDTO> getAll() {
        List<ProductDTO> productDTOList = productRepository
                .findAll()
                .stream()
                .map(productMapper::map)
                .collect(Collectors.toList());
        return productDTOList;
    }

    @Override
    public ProductDTO editProductQuantity(UpdateProductQuantityDTO productDTO) {
        int affectedRows = productRepository.updateProductQuantity(productDTO.getQuantity(), productDTO.getId());
        if (affectedRows == 0)
            throw new EntityNotFoundException();
        return productMapper.map(productRepository.findById(productDTO.getId()).get());
    }

    @Override
    public ProductDTO editProductPrice(UpdateProductPriceDTO productDTO) {
        int affectedRows = productRepository
                .updatePriceById(productDTO.getPrice(), productDTO.getId());
        if (affectedRows == 0)
            throw new EntityNotFoundException();
        return productMapper.map(productRepository.findById(productDTO.getId()).get());
    }
    public List<ProductDTO> filterByCategory(Long id){
        Category category = new Category();
        category.setId(id);
        List<ProductDTO> productDTOList = productRepository.
                findByCategory(category)
                .stream()
                .map(productMapper::map)
                .collect(Collectors.toList());
        return productDTOList;
    }
    @Override
    public ProductDTO editProductName(UpdateProductNameDTO updateProduct) {
       int affectedRows = productRepository.updateNameAndNameArById(
                        updateProduct.getName(),
                        updateProduct.getNameAr(),
                        updateProduct.getId());
       if (affectedRows == 0)
           throw new EntityNotFoundException();
        Product product = productRepository.findById(updateProduct.getId()).get();
        return productMapper.map(product);
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }
}
