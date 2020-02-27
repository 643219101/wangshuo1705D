package com.wangshuo.opencartstore.controller;

import com.github.pagehelper.Page;
import com.wangshuo.opencartstore.dto.in.ProductCreateInDTO;
import com.wangshuo.opencartstore.dto.in.ProductSearchInDTO;
import com.wangshuo.opencartstore.dto.in.ProductUpdateInDTO;
import com.wangshuo.opencartstore.dto.out.PageOutDTO;
import com.wangshuo.opencartstore.dto.out.ProductListOutDTO;
import com.wangshuo.opencartstore.dto.out.ProductShowOutDTO;

import com.wangshuo.opencartstore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@CrossOrigin
public class ProductController {


@Autowired
private  ProductService productService;

    @GetMapping("/search")
    public PageOutDTO<ProductListOutDTO> search(ProductSearchInDTO productSearchInDTO,
                                                @RequestParam(required = false,defaultValue = "1") Integer pageNum){
        Page<ProductListOutDTO> page = productService.search(pageNum);
        PageOutDTO<ProductListOutDTO> objectPageOutDTO = new PageOutDTO<>();
        objectPageOutDTO.setTotal((int) page.getTotal());
        objectPageOutDTO.setPageSize(page.getPageNum());
        objectPageOutDTO.setPageNum(page.getPageNum());
        objectPageOutDTO.setList(page);

        return objectPageOutDTO;
    }

    @GetMapping("/getById")
    public ProductShowOutDTO getById(@RequestParam Integer productId){
        ProductShowOutDTO productShowOutDTO = productService.getById(productId);
        return productShowOutDTO;
    }

    @PostMapping("/create")
    public Integer create(@RequestBody ProductCreateInDTO productCreateInDTO){
        Integer productId = productService.create(productCreateInDTO);
        return productId;
    }

    @PostMapping("/update")
    public void update(@RequestBody ProductUpdateInDTO productUpdateInDTO){
        productService.update(productUpdateInDTO);

    }

    @PostMapping("/delete")
    public void delete(@RequestBody Integer productId){
        productService.delete(productId);
    }

    @PostMapping("/batchDelete")
    public void batchDelete(@RequestBody List<Integer> productIds){
        productService.batchDelete(productIds);

    }

}
