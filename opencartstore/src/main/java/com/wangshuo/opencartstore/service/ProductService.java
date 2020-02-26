package com.wangshuo.opencartstore.service;

import com.wangshuo.opencartstore.dto.in.ProductCreateInDTO;
import com.wangshuo.opencartstore.dto.in.ProductUpdateInDTO;

public interface ProductService {
    Integer create(ProductCreateInDTO productCreateInDTO);
   void update(ProductUpdateInDTO productUpdateInDTO);
}
