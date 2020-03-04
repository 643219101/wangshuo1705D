package com.wangshuo.opencartstore.vo;

public class OrderProductVo {
    private  Integer productId;
    private   Integer quantity;
    private  Double unitPrice;
   private  Double    totalPrice;
    private Integer unitRewordPoints;
    private Integer totalRewordPoints;
    private  String productCode;
    private  String productNmae;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getUnitRewordPoints() {
        return unitRewordPoints;
    }

    public void setUnitRewordPoints(Integer unitRewordPoints) {
        this.unitRewordPoints = unitRewordPoints;
    }

    public Integer getTotalRewordPoints() {
        return totalRewordPoints;
    }

    public void setTotalRewordPoints(Integer totalRewordPoints) {
        this.totalRewordPoints = totalRewordPoints;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductNmae() {
        return productNmae;
    }

    public void setProductNmae(String productNmae) {
        this.productNmae = productNmae;
    }
}
