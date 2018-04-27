package com.pwi.services;

import com.pwi.entities.CategoriesEntity;
import com.pwi.repositories.ICategoriesRepository;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;

public class CategoryServicesTests {
    @Mock
    ICategoriesRepository categoriesRepository;

    @InjectMocks
    CategoryServices categoryServices;

    @Spy
    private List<CategoriesEntity> categoryList = new ArrayList<>();

    @BeforeClass
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        initCategoryList();
    }

    @Test
    public void listAllCategories() {
        when(categoriesRepository.findAll()).thenReturn(categoryList);
        List<CategoriesEntity> categoryListMock = categoryServices.getCategoriesList();
        assertThat(categoryListMock).isEqualTo(categoryList);
    }

    @Test
    public void createCategory() {
        CategoriesEntity categoriesEntity = categoryList.get(1);
        categoryServices.createOrUpdateCategory(categoriesEntity);
        verify(categoriesRepository, atLeastOnce()).save(categoriesEntity);
    }

    @Test
    public void deleteCategory() {
        CategoriesEntity categoriesEntity = categoryList.get(1);
        categoryServices.deleteCategory(categoriesEntity);
        verify(categoriesRepository, atLeastOnce()).delete(categoriesEntity);
    }

    private void initCategoryList() {
        CategoriesEntity categoriesEntity;

        categoriesEntity = new CategoriesEntity();
        categoriesEntity.setIdCategory(5);
        categoriesEntity.setCategoryName("Test Category 5");
        categoriesEntity.setCategoryDescription("Test category description 5");
        categoryList.add(categoriesEntity);

        categoriesEntity = new CategoriesEntity();
        categoriesEntity.setIdCategory(6);
        categoriesEntity.setCategoryName("Test Category 6");
        categoriesEntity.setCategoryDescription("Test category description 6");
        categoryList.add(categoriesEntity);
    }
}
