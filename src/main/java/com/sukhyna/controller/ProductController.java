package com.sukhyna.controller;

import com.sukhyna.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductController {

    @Autowired
    public ProductService productService;

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public ModelAndView getAllById(@RequestParam("c_id") Long id, ModelAndView mv){
        mv.addObject("products", productService.getAllByCategory_Id(id).get());
        mv.setViewName("products");
        return mv;
    }

}
