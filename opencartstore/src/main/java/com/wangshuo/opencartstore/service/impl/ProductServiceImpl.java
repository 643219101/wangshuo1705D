package com.wangshuo.opencartstore.service.impl;

import com.alibaba.fastjson.JSON;
import com.wangshuo.opencartstore.dao.ProductDetailMapper;
import com.wangshuo.opencartstore.dao.ProductMapper;
import com.wangshuo.opencartstore.dto.in.ProductCreateInDTO;
import com.wangshuo.opencartstore.po.Product;
import com.wangshuo.opencartstore.po.ProductDetail;
import com.wangshuo.opencartstore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private ProductDetailMapper productDetailMapper;

    @Override
    @Transactional
    public Integer create(ProductCreateInDTO productCreateInDTO) {

        Product product =new Product();
        product.setProductCode(productCreateInDTO.getProductCode());
        product.setProductName(productCreateInDTO.getProductName());
        product.setPrice(productCreateInDTO.getPrice());
        product.setDiscount(productCreateInDTO.getDiscount());
        product.setStatus(productCreateInDTO.getStatus());
        product.setMainPicUrl(productCreateInDTO.getMainPicUrl());
        product.setRewordPoints(productCreateInDTO.getRewordPoints());
        product.setSortOrder(productCreateInDTO.getSortOrder());
        product.setStockQuantity(productCreateInDTO.getStockQuantity());
        String description = productCreateInDTO.getDescription();
       description.substring(0,Math.min(100,description.length()));
        product.setProductAbstract(description);
       productMapper.insertSelective(product);
        Integer productId = product.getProductId();
        ProductDetail productDetail = new ProductDetail();
        productDetail.setProductId(productId);
        productDetail.setDescription(productCreateInDTO.getDescription());

        List<String> otherPicUrls = productCreateInDTO.getOtherPicUrls();
        productDetail.setOtherPicUrls(JSON.toJSONString(otherPicUrls));
       productDetailMapper.insertSelective(productDetail);
        return productId;
    }
}
