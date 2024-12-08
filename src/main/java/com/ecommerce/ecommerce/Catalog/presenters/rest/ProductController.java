package com.ecommerce.ecommerce.Catalog.presenters.rest;


import com.ecommerce.ecommerce.Catalog.core.domain.category.Name;
import com.ecommerce.ecommerce.Catalog.core.domain.product.Price;
import com.ecommerce.ecommerce.Catalog.core.domain.product.Product;
import com.ecommerce.ecommerce.Catalog.core.domain.product.ProductId;
import com.ecommerce.ecommerce.Catalog.core.usecases.CreateProduct;
import com.ecommerce.ecommerce.Catalog.core.usecases.GetProductByCategory;
import com.ecommerce.ecommerce.Catalog.core.usecases.GetProductById;
import com.ecommerce.ecommerce.Catalog.core.usecases.GetProducts;
import com.ecommerce.ecommerce.Catalog.presenters.DTO.ProductCreateDTO;
import com.ecommerce.ecommerce.Catalog.presenters.DTO.ProductDTO;
import com.ecommerce.ecommerce.Catalog.presenters.mappers.CategoryMapper;
import com.ecommerce.ecommerce.Catalog.presenters.mappers.ProductMapper;
import com.ecommerce.ecommerce.Shared.core.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    private final CreateProduct createProductUseCase;
    private final GetProducts getProductsUseCase;
    private final GetProductByCategory getProductByCategoryUseCase;
    private final GetProductById getProductByIdUseCase;

    public ProductController(
            CreateProduct createProductUseCase,
            GetProducts getProductsUseCase,
            GetProductByCategory getProductByCategoryUseCase,
            GetProductById getProductByIdUseCase
    ) {
        this.createProductUseCase = createProductUseCase;
        this.getProductsUseCase = getProductsUseCase;
        this.getProductByCategoryUseCase = getProductByCategoryUseCase;
        this.getProductByIdUseCase = getProductByIdUseCase;
    }

    //create product
    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody ProductCreateDTO productRequest) {
        Product product = Product.createWithoutId(
                new Price(productRequest.getPrice()),
                CategoryMapper.mapToCategoryFromCategoryDTO(productRequest.getCategories()),
                productRequest.getTitle(),
                productRequest.getDescription()
        );
        createProductUseCase.execute(product);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    //delete product
    //get random
    @GetMapping("/random")
    public ResponseEntity<Page<ProductDTO>> getAll(@RequestParam int size, @RequestParam int page) {
        var products = getProductsUseCase.execute(size,page);
        Page<ProductDTO> res = new Page<>(page,size,products.getElements().stream().map(ProductMapper::FromProductToProductDTO).toList());
        return ResponseEntity.ok(res);
    }
    //get product by id
    @GetMapping("/get{id}")
    private ResponseEntity<ProductDTO> getById(@PathVariable String id) {
        Product response = getProductByIdUseCase.execute(new ProductId(id));
        return ResponseEntity.ok(ProductMapper.FromProductToProductDTO(response));
    }
    //get products by categories
    @GetMapping("/getbycategory")
    private ResponseEntity<Page<ProductDTO>> getByCategory(@RequestParam List<String> names, @RequestParam int size, @RequestParam int page) {
        Page<Product> products = getProductByCategoryUseCase.execute(names.stream().map(Name::new).toList(),page,size);
        Page<ProductDTO> res = new Page<>(page,size,products.getElements().stream().map(ProductMapper::FromProductToProductDTO).toList());
        return ResponseEntity.ok(res);
    }
}
