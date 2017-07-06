package com.abitty.admin.vo.request;

/**
 * Created by yak on 17/7/1.
 */
public class CatalogSearchVo extends BasePageVo {

    private String catalogNo;

    private String catalogName;

    private String isDelete;

    public String getCatalogNo() {
        return catalogNo;
    }

    public void setCatalogNo(String catalogNo) {
        this.catalogNo = catalogNo;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CatalogSearchVo{");
        sb.append("catalogNo='").append(catalogNo).append('\'');
        sb.append(", catalogName='").append(catalogName).append('\'');
        sb.append(", isDelete='").append(isDelete).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
