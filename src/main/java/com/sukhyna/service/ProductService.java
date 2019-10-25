package com.sukhyna.service;

import com.sukhyna.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    public Optional<List<Product>> getAllByCategory_Id(Long id);
}