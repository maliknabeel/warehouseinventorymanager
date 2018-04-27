package com.pwi.services;

import com.pwi.entities.CategoriesEntity;
import com.pwi.repositories.ICategoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServices {

    @Autowired
    ICategoriesRepository categoriesRepository;

    public List<CategoriesEntity> getCategoriesList() {
        return categoriesRepository.findAll();
    }

    public CategoriesEntity getCategoryById(int categoryId) {
        return categoriesRepository.findById(categoryId).orElseThrow(() -> new RuntimeException("Category ID not found"));
    }

    public CategoriesEntity createOrUpdateCategory(CategoriesEntity categoriesEntity) {
        return categoriesRepository.save(categoriesEntity);
    }

    public void deleteCategory(CategoriesEntity categoriesEntity) {
        categoriesRepository.delete(categoriesEntity);
    }
}
