package com.tests.services;

import com.tests.repositories.CategoryRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class CategoryService {

    @Inject
    CategoryRepository categoryRepository;

    public Long countCategories() {
        return categoryRepository.count();
    }
}
