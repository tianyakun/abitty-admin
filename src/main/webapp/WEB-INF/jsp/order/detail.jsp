<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/include.inc.jsp" %>
<c:import url="/WEB-INF/jsp/_frag/pager/pagerForm.jsp"></c:import>

<h2 class="contentTitle">订单详情</h2>

<div class="pageFormContent" layoutH="60">
    <fieldset>
        <legend>订单详情</legend>
        <dl>
            <dt>ID：</dt>
            <dd><input type="text" name="id" value="${order.id}" readonly="true"/></dd>
        </dl>
        <dl>
            <dt>订单号：</dt>
            <dd><input type="text" name="productNo" value="${order.orderNo}" readonly="true"/></dd>
        </dl>
        <dl>
            <dt>用户UID：</dt>
            <dd><input type="text" name="productName" value="${order.uid}" readonly="true"/></dd>
        </dl>
        <dl>
            <dt>商品编号：</dt>
            <dd><input type="text" name="catalogNo" value="${order.productNo}" readonly="true"/></dd>
        </dl>
        <dl>
            <dt>订购月数：</dt>
            <dd><input type="text" name="serviceAtomCount" value="${order.serviceAtomCount}" readonly="true"/></dd>
        </dl>
        <dl>
            <dt>商品总数：</dt>
            <dd><input type="text" name="totalQuantity" value="${order.totalQuantity}" readonly="true"/></dd>
        </dl>
        <dl>
            <dt>订单金额：</dt>
            <dd><input type="text" name="totalAmount" value="${order.totalAmount}" readonly="true"/></dd>
        </dl>
        <dl>
            <dt>订单状态：</dt>
            <c:choose>
                <c:when test="${order.status eq 0}">
                    <dd><input type="text" name="status" value="支付处理中" readonly="true"/></dd>
                </c:when>
                <c:when test="${order.status eq 1}">
                    <dd><input type="text" name="status" value="支付成功" readonly="true"/></dd>
                </c:when>
                <c:when test="${order.status eq 2}">
                    <dd><input type="text" name="status" value="服务中" readonly="true"/></dd>
                </c:when>
                <c:when test="${order.status eq 3}">
                    <dd><input type="text" name="status" value="订单结束" readonly="true"/></dd>
                </c:when>
                <c:otherwise>
                    <dd><input type="text" name="status" value="${order.status}" readonly="true"/></dd>
                </c:otherwise>
            </c:choose>
        </dl>
        <dl>
            <dt>支付订单号：</dt>
            <dd><input type="text" name="payId" value="${order.payId}" readonly="true"/></dd>
        </dl>
        <dl>
            <dt>返回订单号：</dt>
            <dd><input type="text" name="payReturnId" value="${order.payReturnId}" readonly="true"/></dd>
        </dl>
        <dl>
            <dt>配送类型：</dt>
            <dd><input type="text" name="deliveryType" value="${order.deliveryType}" readonly="true"/></dd>
        </dl>
        <dl>
            <dt>配送次数：</dt>
            <dd><input type="text" name="totalSub" value="${order.totalSub}" readonly="true"/></dd>
        </dl>
        <dl>
            <dt>单次配送数量：</dt>
            <dd><input type="text" name="subQuantity" value="${order.subQuantity}" readonly="true"/></dd>
        </dl>
        <dl>
            <dt>配送完成次数：</dt>
            <dd><input type="text" name="finishSub" value="${order.finishSub}" readonly="true"/></dd>
        </dl>
        <dl>
            <dt>订单备注：</dt>
            <dd><input type="text" name="remark" value="${order.remark}" readonly="true"/></dd>
        </dl>
        <dl>
            <dt>错误码：</dt>
            <dd><input type="text" name="errorCode" value="${order.errorCode}" readonly="true"/></dd>
        </dl>
        <dl>
            <dt>错误信息：</dt>
            <dd><input type="text" name="errorMsg" value="${order.errorMsg}" readonly="true"/></dd>
        </dl>
        <dl>
            <dt>订单创建时间：</dt>
            <dd><input type="text" name="createTime" value="${order.createTime}" readonly="true"/></dd>
        </dl>
    </fieldset>

    <fieldset>
        <legend>配送订单列表</legend>

        <c:set var="subOrderList" value="${order.subOrderVoList}"/>
        <c:set var="nextSub" value="${order.nextSub}"/>

        <c:forEach var="subOrder" items="${subOrderList}" varStatus="s">
            <fieldset>
                <fieldset>
                    <dl>
                        <dt>ID：</dt>
                        <dd><input type="text" name="id" value="${subOrder.id}" readonly="true"/></dd>
                    </dl>
                    <dl>
                        <dt>子订单号：</dt>
                        <dd><input type="text" name="subOrderNo" value="${subOrder.subOrderNo}" readonly="true"/></dd>
                    </dl>
                    <dl>
                        <dt>商品编号：</dt>
                        <dd><input type="text" name="productNo" value="${subOrder.productNo}" readonly="true"/></dd>
                    </dl>
                    <dl>
                        <dt>配送数量：</dt>
                        <dd><input type="text" name="quantity" value="${subOrder.quantity}" readonly="true"/></dd>
                    </dl>
                    <dl>
                        <dt>状态：</dt>
                        <c:choose>
                            <c:when test="${subOrder.status eq 0}">
                                <dd><input type="text" name="status" value="未处理" readonly="true"/></dd>
                            </c:when>
                            <c:when test="${subOrder.status eq 1}">
                                <dd><input type="text" name="status" value="备货中" readonly="true"/></dd>
                            </c:when>
                            <c:when test="${subOrder.status eq 2}">
                                <dd><input type="text" name="status" value="已发货" readonly="true"/></dd>
                            </c:when>
                            <c:when test="${subOrder.status eq 3}">
                                <dd><input type="text" name="status" value="配送完成" readonly="true"/></dd>
                            </c:when>
                            <c:otherwise>
                                <dd><input type="text" name="status" value="${subOrder.status}" readonly="true"/></dd>
                            </c:otherwise>
                        </c:choose>
                    </dl>
                    <dl>
                        <dt>配送时间：</dt>
                        <dd><input type="text" name="deliveryTime" value="${subOrder.deliveryTime}" readonly="true"/>
                        </dd>
                    </dl>
                    <dl>
                        <dt>收货人姓名：</dt>
                        <dd><input type="text" name="recvName" value="${subOrder.recvName}" readonly="true"/></dd>
                    </dl>
                    <dl>
                        <dt>收货人手机号：</dt>
                        <dd><input type="text" name="phone" value="${subOrder.phone}" readonly="true"/></dd>
                    </dl>
                    <dl>
                        <dt>收货人地址：</dt>
                        <dd><input type="text" name="address" value="${subOrder.address}" readonly="true"/></dd>
                    </dl>
                    <dl>
                        <dt>备注：</dt>
                        <dd><input type="text" name="remark" value="${subOrder.remark}" readonly="true"/></dd>
                    </dl>
                    <dl>
                        <dt>创建时间：</dt>
                        <dd><input type="text" name="createTime" value="${subOrder.createTime}" readonly="true"/></dd>
                    </dl>
                </fieldset>

                <c:if test="${nextSub eq subOrder.subOrderNo}">
                    <fieldset>
                        <dl class="nowrap">
                            <dt>操作：</dt>
                            <c:choose>
                                <c:when test="${subOrder.status eq 0}">
                                    <dd><a href="<c:url value='order/sub/update/${order.id}/${subOrder.id}/1'/>" target="navTab" rel="catalog">备货</a></dd>
                                </c:when>
                                <c:when test="${subOrder.status eq 1}">
                                    <dd><a href="<c:url value='order/sub/update/${order.id}/${subOrder.id}/2'/>" target="navTab" rel="catalog">发货</a></dd>
                                </c:when>
                                <c:when test="${subOrder.status eq 2}">
                                    <dd><a href="<c:url value='order/sub/update/${order.id}/${subOrder.id}/3'/>" target="navTab" rel="catalog">确认收货</a></dd>
                                </c:when>
                            </c:choose>
                        </dl>
                    </fieldset>
                </c:if>
            </fieldset>
        </c:forEach>
    </fieldset>
</div>