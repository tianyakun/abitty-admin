package com.abitty.admin.entity;

import java.util.Date;

public class TblMessageInfo {
    private Integer id;

    private String messageId;

    private String channelMessageId;

    private Integer messageType;

    private String messageChannel;

    private String templateCode;

    private String messageAddress;

    private Integer sendStatus;

    private String resultCode;

    private String resultInfo;

    private String sendContent;

    private String vcode;

    private Integer validateStatus;

    private Date createTime;

    private Date sendTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getChannelMessageId() {
        return channelMessageId;
    }

    public void setChannelMessageId(String channelMessageId) {
        this.channelMessageId = channelMessageId;
    }

    public Integer getMessageType() {
        return messageType;
    }

    public void setMessageType(Integer messageType) {
        this.messageType = messageType;
    }

    public String getMessageChannel() {
        return messageChannel;
    }

    public void setMessageChannel(String messageChannel) {
        this.messageChannel = messageChannel;
    }

    public String getTemplateCode() {
        return templateCode;
    }

    public void setTemplateCode(String templateCode) {
        this.templateCode = templateCode;
    }

    public String getMessageAddress() {
        return messageAddress;
    }

    public void setMessageAddress(String messageAddress) {
        this.messageAddress = messageAddress;
    }

    public Integer getSendStatus() {
        return sendStatus;
    }

    public void setSendStatus(Integer sendStatus) {
        this.sendStatus = sendStatus;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultInfo() {
        return resultInfo;
    }

    public void setResultInfo(String resultInfo) {
        this.resultInfo = resultInfo;
    }

    public String getSendContent() {
        return sendContent;
    }

    public void setSendContent(String sendContent) {
        this.sendContent = sendContent;
    }

    public String getVcode() {
        return vcode;
    }

    public void setVcode(String vcode) {
        this.vcode = vcode;
    }

    public Integer getValidateStatus() {
        return validateStatus;
    }

    public void setValidateStatus(Integer validateStatus) {
        this.validateStatus = validateStatus;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TblMessageInfo{");
        sb.append("id=").append(id);
        sb.append(", messageId='").append(messageId).append('\'');
        sb.append(", channelMessageId='").append(channelMessageId).append('\'');
        sb.append(", messageType=").append(messageType);
        sb.append(", messageChannel='").append(messageChannel).append('\'');
        sb.append(", templateCode='").append(templateCode).append('\'');
        sb.append(", messageAddress='").append(messageAddress).append('\'');
        sb.append(", sendStatus=").append(sendStatus);
        sb.append(", resultCode='").append(resultCode).append('\'');
        sb.append(", resultInfo='").append(resultInfo).append('\'');
        sb.append(", sendContent='").append(sendContent).append('\'');
        sb.append(", vcode='").append(vcode).append('\'');
        sb.append(", validateStatus=").append(validateStatus);
        sb.append(", createTime=").append(createTime);
        sb.append(", sendTime=").append(sendTime);
        sb.append('}');
        return sb.toString();
    }
}