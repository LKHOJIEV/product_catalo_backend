package com.ucell.backend.controller;

import com.ucell.backend.response.ApiResponseV1;
import com.ucell.backend.service.CategoryService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/")
public class CategoryController {


    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


    @GetMapping("api/category")
    public ApiResponseV1 getAllCategory(@RequestParam("user") String user,
                                        @RequestParam("secret") String password,
                                        @RequestParam(value = "details",defaultValue = "0") Integer detail,
                                        @RequestParam(value = "offset",defaultValue = "0") Integer offset,
                                        @RequestParam(value = "limit",defaultValue = "20") Integer limit) throws Exception {

        return categoryService.getCategoryList(user, password, detail,offset,limit);

    }

    @GetMapping("api/category/{id}")
    public ApiResponseV1 getCategoryById(@RequestParam("user") String user,
                                         @RequestParam("secret") String password,
                                         @PathVariable("id") String id,
                                         @RequestParam(value = "details",defaultValue = "0") Integer detail,
                                         @RequestParam(value = "offset",defaultValue = "0") Integer offset,
                                         @RequestParam(value = "limit",defaultValue = "20") Integer limit) throws Exception {

        return categoryService.getCategoryById(user, password, id, detail,offset,limit);

    }
}
