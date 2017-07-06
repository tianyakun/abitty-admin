<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/include.inc.jsp" %>
<c:import url="/WEB-INF/jsp/_frag/pager/pagerForm.jsp"></c:import>

<h2 class="contentTitle">新增商品</h2>

<div class="pageFormContent" layoutH="60">
    <div>
        <form method="post" action="<c:url value='product/save'/>" class="pageForm required-validate"
              onsubmit="return navTabSearch(this)">
            <div class="pageFormContent nowrap" layoutH="97">
                <fieldset>
                    <dl>
                        <dt>商品遍号：</dt>
                        <dd><input type="text" name="productNo" class="required"/></dd>
                    </dl>
                    <dl>
                        <dt>商品名称：</dt>
                        <dd><input type="text" name="productName" class="required"/></dd>
                    </dl>
                    <dl>
                        <dt>商品分类：</dt>
                        <%--<dd><input type="text" name="catalogNo" class="required"/></dd>--%>
                        <dd>
                            <select name="catalogNo" class="required">
                                <c:forEach var="item" items="${catalogList}" varStatus="s">
                                    <option value="${item.catalogNo}">${item.catalogName}</option>
                                </c:forEach>
                            </select>
                        </dd>
                    </dl>
                    <dl>
                        <dt>商品规格：</dt>
                        <dd><input type="text" name="description" class="required"/></dd>
                    </dl>
                    <dl>
                        <dt>定价：</dt>
                        <dd><input type="text" name="price" class="required number"/></dd>
                    </dl>
                    <dl>
                        <dt>现价：</dt>
                        <input type="text" name="nowPrice" class="required number"/>
                    </dl>
                    <dl>
                        <dt>配送类型：</dt>
                        <dd>
                            <select name="deliveryType" class="required">
                                <option value="daily" ${"daily" eq product.deliveryType ? 'selected="selected"' : ''}>
                                    daily
                                </option>
                                <option value="weekly" ${"weekly" eq product.deliveryType ? 'selected="selected"' : ''}>
                                    weekly
                                </option>
                                <option value="monthly" ${"monthly" eq product.deliveryType ? 'selected="selected"' : ''}>
                                    monthly
                                </option>
                                <option value="yearly" ${"yearly" eq product.deliveryType ? 'selected="selected"' : ''}>
                                    yearly
                                </option>
                            </select>
                        </dd>
                        </dd>
                    </dl>
                </fieldset>

                <fieldset>
                    <dl class="nowrap">
                        <dt>商品缩略图：</dt>
                        <dd><textarea name="icon" cols="80" rows="1" class="required"></textarea></dd>
                    </dl>
                    <dl class="nowrap">
                        <dt>商品主图：</dt>
                        <dd><textarea name="detail" cols="80" rows="1" class="required"></textarea></dd>
                    </dl>
                    <dl class="nowrap">
                        <dt>商品详情页：</dt>
                        <dd><textarea name="images" cols="80" rows="10" class="required"></textarea></dd>
                    </dl>
                </fieldset>

                <fieldset>
                    <dl class="nowrap">
                        <dt>操作：</dt>
                        <dd>
                            <div class="buttonActive">
                                <div class="buttonContent">
                                    <button type="submit">提交</button>
                                </div>
                            </div>
                            <div class="button">
                                <div class="buttonContent">
                                    <button type="button" class="close">取消</button>
                                </div>
                            </div>
                        </dd>
                    </dl>
                </fieldset>
            </div>
        </form>

    </div>
</div>