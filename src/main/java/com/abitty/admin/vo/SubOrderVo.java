package com.abitty.admin.vo;

/**
 * Created by yak on 17/6/18.
 */
public class SubOrderVo {

    private Integer id;

    private String subOrderNo;

    private String orderNo;

    private String productNo;

    private Integer quantity;

    private Integer status;

    private String recvName;

    private String phone;

    private String address;

    private String deliveryTime;

    private Integer usedPercent;

    private String remark;

    private String createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSubOrderNo() {
        return subOrderNo;
    }

    public void setSubOrderNo(String subOrderNo) {
        this.subOrderNo = subOrderNo;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getProductNo() {
        return productNo;
    }

    public void setProductNo(String productNo) {
        this.productNo = productNo;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRecvName() {
        return recvName;
    }

    public void setRecvName(String recvName) {
        this.recvName = recvName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(String deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public Integer getUsedPercent() {
        return usedPercent;
    }

    public void setUsedPercent(Integer usedPercent) {
        this.usedPercent = usedPercent;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("SubOrderVo{");
        sb.append("id=").append(id);
        sb.append(", subOrderNo='").append(subOrderNo).append('\'');
        sb.append(", orderNo='").append(orderNo).append('\'');
        sb.append(", productNo='").append(productNo).append('\'');
        sb.append(", quantity=").append(quantity);
        sb.append(", status=").append(status);
        sb.append(", recvName='").append(recvName).append('\'');
        sb.append(", phone='").append(phone).append('\'');
        sb.append(", address='").append(address).append('\'');
        sb.append(", deliveryTime='").append(deliveryTime).append('\'');
        sb.append(", usedPercent=").append(usedPercent);
        sb.append(", remark='").append(remark).append('\'');
        sb.append(", createTime='").append(createTime).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
