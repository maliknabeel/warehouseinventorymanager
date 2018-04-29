package com.pwi.controller;

import com.pwi.entities.CategoriesEntity;
import com.pwi.services.CategoryServices;
import com.pwi.utils.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.xml.ws.Response;

@Controller
@RequestMapping("category")
public class CategoryController {

    @Autowired
    CategoryServices categoryServices;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Object> getAllCategories(){
        return new ResponseEntity<>(categoryServices.getCategoriesList(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Object> addNewCategory(@RequestBody CategoriesEntity categoriesEntity){
        return new ResponseEntity<>(categoryServices.createOrUpdateCategory(categoriesEntity), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<Object> updateCategory(@RequestBody CategoriesEntity categoriesEntity){
        return new ResponseEntity<>(categoryServices.createOrUpdateCategory(categoriesEntity), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteCategory(@RequestBody CategoriesEntity categoriesEntity){
        categoryServices.deleteCategory(categoriesEntity);
        return new ResponseEntity<>(new ResponseBody(true, "Deletion Successful"), HttpStatus.OK);
    }
}
