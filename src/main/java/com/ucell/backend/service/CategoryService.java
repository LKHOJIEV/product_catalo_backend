package com.ucell.backend.service;

import com.ucell.backend.entity.Category;
import com.ucell.backend.repository.CategoryRepository;
import com.ucell.backend.response.ApiResponseV1;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;


    private UsersService usersService;

    public CategoryService(UsersService usersService) {
        this.usersService = usersService;
    }

    public ApiResponseV1 getCategoryList(String fields,Integer detail, Integer offset, Integer limit) throws Exception {


        Pageable pageable = PageRequest.of(offset,limit);

        Page<Category> categoryList =
                detail==1
                        ? categoryRepository.findAll(pageable)
                        : categoryRepository.findAllOnlyNode(pageable);

        return new ApiResponseV1(
                HttpStatus.ACCEPTED,
                categoryList.getTotalElements()>0 ? "success" : "data not found",
                CustomService.getFieldsByOrder(fields,categoryList),
                (long) CustomService.getFieldsByOrder(fields,categoryList).size(),
                offset,
                limit);

    }

    public ApiResponseV1 getCategoryById(String fields,String id, Integer detail, Integer offset, Integer limit) throws Exception {

            Pageable pageable = PageRequest.of(offset,limit);

            Page<Category> categories =
                    detail==1
                            ? categoryRepository.findByCategoryId(id,pageable)
                            : categoryRepository.findByCategoryIdOnlyNode(id,pageable);

            return new ApiResponseV1(
                    HttpStatus.ACCEPTED,
                    categories.getTotalElements()>0 ? "success" : "data not found",
                    CustomService.getFieldsByOrder(fields,categories),
                    (long) CustomService.getFieldsByOrder(fields,categories).size(),
                    offset,
                    limit);


    }


}
