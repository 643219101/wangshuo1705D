package com.wangshuo.opencartback.controller;

import com.wangshuo.opencartback.dto.in.ProductCreateInDTO;
import com.wangshuo.opencartback.dto.in.ProductSearchInDTO;
import com.wangshuo.opencartback.dto.in.ProductUpdateInDTO;
import com.wangshuo.opencartback.dto.out.PageOutDTO;
import com.wangshuo.opencartback.dto.out.ProductListOutDTO;
import com.wangshuo.opencartback.dto.out.ProductShowOutDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    @GetMapping("/search")
    public PageOutDTO<ProductListOutDTO> search(ProductSearchInDTO productSearchInDTO
            ,@RequestParam Integer pageNum){
         return  null;
    }

    @PostMapping("/create")
    public  Integer  create(@RequestBody  ProductCreateInDTO productCreateInDTO){
    return  null;

    }

    @PostMapping("/update")
    public  void update(@RequestBody ProductUpdateInDTO productUpdateInDTO){

    }
    @GetMapping("/getById")
    public ProductShowOutDTO getById(@RequestParam Integer productId){

        return  null;
}

}
