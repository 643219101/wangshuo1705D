package com.wangshuo.opencartstore.service;

import com.wangshuo.opencartstore.dto.in.ProductCreateInDTO;
import com.wangshuo.opencartstore.dto.in.ProductUpdateInDTO;

import java.util.List;

public interface ProductService {
    Integer create(ProductCreateInDTO productCreateInDTO);
   void update(ProductUpdateInDTO productUpdateInDTO);

   void  delete(Integer productId);
   void batchDelete(List<Integer> productIds);
}
