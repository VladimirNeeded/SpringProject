package com.sukhyna.service;

import com.sukhyna.dao.ProductRepository;
import com.sukhyna.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    public ProductRepository productDao;

    @Override
    public Optional<List<Product>> getAllByCategory_Id(Long id) {
        return productDao.getAllByCategory_Id(id);
    }
}
