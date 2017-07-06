package com.abitty.admin.vo.request;

/**
 * Created by yak on 17/7/1.
 */
public class ProductSearchVo extends BasePageVo {

    private String productNo;

    private String productName;

    private String catalogNo;

    private String status;

    public String getProductNo() {
        return productNo;
    }

    public void setProductNo(String productNo) {
        this.productNo = productNo;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCatalogNo() {
        return catalogNo;
    }

    public void setCatalogNo(String catalogNo) {
        this.catalogNo = catalogNo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CatalogSearchVo{");
        sb.append(super.toString()).append('\'');
        sb.append("productNo='").append(productNo).append('\'');
        sb.append(", productName='").append(productName).append('\'');
        sb.append(", catalogNo='").append(catalogNo).append('\'');
        sb.append(", status='").append(status).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
