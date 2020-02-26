package com.wangshuo.opencartstore.service;

import com.github.pagehelper.Page;
import com.wangshuo.opencartstore.dto.in.ProductCreateInDTO;
import com.wangshuo.opencartstore.dto.in.ProductUpdateInDTO;
import com.wangshuo.opencartstore.dto.out.ProductListOutDTO;

import java.util.List;

public interface ProductService {
    Integer create(ProductCreateInDTO productCreateInDTO);
   void update(ProductUpdateInDTO productUpdateInDTO);

   void  delete(Integer productId);
   void batchDelete(List<Integer> productIds);

   Page<ProductListOutDTO> search(Integer pageNum);
}
