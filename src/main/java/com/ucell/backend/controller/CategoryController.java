package com.ucell.backend.controller;

import com.ucell.backend.response.ApiResponseV1;
import com.ucell.backend.service.CategoryService;
import org.springframework.web.bind.annotation.*;

@RestController
public class CategoryController {


    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


    @GetMapping("/category")
    public ApiResponseV1 getAllCategory(@RequestParam(value = "authToken") String authToken,
                                        @RequestParam(value = "fields",defaultValue = "") String fields,
                                        @RequestParam(value = "details",defaultValue = "0") Integer detail,
                                        @RequestParam(value = "offset",defaultValue = "0") Integer offset,
                                        @RequestParam(value = "limit",defaultValue = "20") Integer limit) throws Exception {

        return categoryService.getCategoryList(fields,detail,offset,limit);

    }

    @GetMapping("/category/{id}")
    public ApiResponseV1 getCategoryById(@RequestParam(value = "authToken") String authToken,
                                         @RequestParam(value = "fields",defaultValue = "") String fields,
                                         @PathVariable("id") String id,
                                         @RequestParam(value = "details",defaultValue = "0") Integer detail,
                                         @RequestParam(value = "offset",defaultValue = "0") Integer offset,
                                         @RequestParam(value = "limit",defaultValue = "20") Integer limit) throws Exception {

        return categoryService.getCategoryById(fields,id, detail,offset,limit);

    }
}
