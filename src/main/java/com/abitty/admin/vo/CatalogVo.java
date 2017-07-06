package com.abitty.admin.vo;

import java.util.Date;

/**
 * Created by yak on 17/7/3.
 */
public class CatalogVo {

    private Integer id;

    private String catalogNo;

    private String catalogName;

    private String icon;

    private Integer pid;

    private String description;

    private String deliveryType;

    private Integer isDelete;

    private String createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(String deliveryType) {
        this.deliveryType = deliveryType;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CatalogVo{");
        sb.append("id=").append(id);
        sb.append(", catalogNo='").append(catalogNo).append('\'');
        sb.append(", catalogName='").append(catalogName).append('\'');
        sb.append(", icon='").append(icon).append('\'');
        sb.append(", pid=").append(pid);
        sb.append(", description='").append(description).append('\'');
        sb.append(", deliveryType='").append(deliveryType).append('\'');
        sb.append(", isDelete=").append(isDelete);
        sb.append(", createTime='").append(createTime).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
