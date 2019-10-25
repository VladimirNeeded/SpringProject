package com.sukhyna.controller;

import com.sukhyna.model.Category;
import com.sukhyna.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collections;
import java.util.List;

@Controller
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "/categories", method = RequestMethod.GET)
    public ModelAndView getAll(ModelAndView mv){
        List<Category> categories = categoryService.getAll()
                .orElseGet(Collections::emptyList);
        mv.addObject("categories", categories);
        mv.setViewName("categories");
        return mv;
    }

    @RequestMapping(value = "/add-category", method = RequestMethod.POST)
    public ModelAndView create (@ModelAttribute Category category, ModelAndView mv) {
        categoryService.create(category);
        List<Category> categories = categoryService.getAll()
                .orElseGet(Collections::emptyList);
        mv.addObject("categories", categories);
        mv.setViewName("categories");
        return mv;
    }

    @RequestMapping(value = "add-category", method = RequestMethod.GET)
    public ModelAndView create (ModelAndView mv){
        mv.addObject("category", new Category());
        mv.setViewName("add-category");
        return mv;
    }

    @RequestMapping (value = "/edit-category", method = RequestMethod.GET)
    public ModelAndView edit (@RequestParam("c_id") Long id, ModelAndView mv){
        mv.addObject("category", categoryService.getByIdWithProducts(id).get());
        mv.setViewName("edit-category");
        return mv;
    }

    @RequestMapping (value = "/edit-category", method = RequestMethod.POST)
    public ModelAndView edit (@ModelAttribute Category category, ModelAndView mv){
        categoryService.update(category);
        return getCategories(mv);
    }

    @RequestMapping (value = "/delete-category", method = RequestMethod.GET)
    public ModelAndView delete(@RequestParam("c_id") Long id, ModelAndView mv){
        categoryService.delete(id);
        return getCategories(mv);
    }

    private ModelAndView getCategories(ModelAndView mv){
        List<Category> categories = categoryService.getAll().get();
        mv.addObject("categories", categories);
        mv.setViewName("categories");
        return mv;
    }


//    @ResponseBody
//    @RequestMapping(value = "/api/category", method = RequestMethod.GET)
//    public List<Category> getAllAsJson(){
//        return categoryService.getAll().orElseGet(Collections::emptyList);
//    }
}