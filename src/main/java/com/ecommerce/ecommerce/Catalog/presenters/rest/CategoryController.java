package com.ecommerce.ecommerce.Catalog.presenters.rest;


import com.ecommerce.ecommerce.Catalog.core.domain.category.Category;
import com.ecommerce.ecommerce.Catalog.core.domain.category.Name;
import com.ecommerce.ecommerce.Catalog.core.usecases.CreateCategory;
import com.ecommerce.ecommerce.Catalog.core.usecases.GetCategories;
import com.ecommerce.ecommerce.Catalog.presenters.DTO.CategoryCreateDTO;
import com.ecommerce.ecommerce.Catalog.presenters.DTO.CategoryDTO;
import com.ecommerce.ecommerce.Catalog.presenters.mappers.CategoryMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {

    private final CreateCategory createCategoryUseCase;
    private final GetCategories getCategoriesUseCase;

    public CategoryController(CreateCategory createCategoryUseCase, GetCategories getCategoriesUseCase) {
        this.createCategoryUseCase = createCategoryUseCase;
        this.getCategoriesUseCase = getCategoriesUseCase;
    }

    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody CategoryCreateDTO categoryRequest) {
        Category category = Category.createWithoutId(new Name(categoryRequest.getName()));
        createCategoryUseCase.execute(category);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/all")
    public ResponseEntity<List<CategoryDTO>> getAll() {
        List<Category> categories = getCategoriesUseCase.execute();
        return ResponseEntity.ok(CategoryMapper.mapToCategoryResponseDTO(categories));
    }

}
