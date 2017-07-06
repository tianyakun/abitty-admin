<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/include.inc.jsp" %>
<c:import url="/WEB-INF/jsp/_frag/pager/pagerForm.jsp"></c:import>

<h2 class="contentTitle">编辑商品</h2>

<div class="pageFormContent" layoutH="60">
    <div>
        <form method="post" rel="pagerForm" action="<c:url value='product/update'/>"
              onsubmit="return navTabSearch(this)">
            <fieldset>
                <dl>
                    <dt>ID：</dt>
                    <dd><input type="text" name="id" value="${product.id}" readonly="true"/></dd>
                </dl>
                <dl>
                    <dt>商品遍号：</dt>
                    <dd><input type="text" name="productNo" value="${product.productNo}"/></dd>
                </dl>
                <dl>
                    <dt>商品名称：</dt>
                    <dd><input type="text" name="productName" value="${product.productName}"/></dd>
                </dl>
                <dl>
                    <dt>商品分类：</dt>
                    <%--<dd><input type="text" name="catalogNo" value="${product.catalogNo}"/></dd>--%>
                    <dd>
                        <select name="catalogNo">
                            <c:forEach var="item" items="${catalogList}" varStatus="s">
                                <option value="${item.catalogNo}" ${item.catalogNo eq product.catalogNo ? 'selected="selected"' : ''}>${item.catalogName}</option>
                            </c:forEach>
                        </select>
                    </dd>
                </dl>
                <dl>
                    <dt>商品规格：</dt>
                    <dd><input type="text" name="description" value="${product.description}"/></dd>
                </dl>
                <dl>
                    <dt>定价：</dt>
                    <dd><input type="text" name="price" value="${product.price}" class="number"/></dd>
                </dl>
                <dl>
                    <dt>现价：</dt>
                    <input type="text" name="nowPrice" value="${product.nowPrice}" class="number"/>
                </dl>
                <dl>
                    <dt>状态：</dt>
                    <dd>
                        <select name="status" >
                            <option value="0" ${"0" eq product.status ? 'selected="selected"' : ''}>新增</option>
                            <option value="1" ${"1" eq product.status ? 'selected="selected"' : ''}>上架</option>
                            <option value="2" ${"2" eq product.status ? 'selected="selected"' : ''}>下架</option>
                            <option value="3" ${"3" eq product.status ? 'selected="selected"' : ''}>删除</option>
                        </select>
                    </dd>
                </dl>
                <dl>
                    <dt>配送类型：</dt>
                    <%--<dd><input type="text" name="deliveryType" value="${product.deliveryType}"/></dd>--%>
                    <dd>
                        <select name="deliveryType" >
                            <option value="daily" ${"daily" eq product.deliveryType ? 'selected="selected"' : ''}>daily</option>
                            <option value="weekly" ${"weekly" eq product.deliveryType ? 'selected="selected"' : ''}>weekly</option>
                            <option value="monthly" ${"monthly" eq product.deliveryType ? 'selected="selected"' : ''}>monthly</option>
                            <option value="yearly" ${"yearly" eq product.deliveryType ? 'selected="selected"' : ''}>yearly</option>
                        </select>
                    </dd>
                    </dd>
                </dl>
                <dl>
                    <dt>创建时间：</dt>
                    <dd><input type="text" name="" value="${product.createTime}" readonly="true"/></dd>
                </dl>
            </fieldset>

            <fieldset>
                <dl class="nowrap">
                    <dt>商品缩略图：</dt>
                    <dd><textarea name="icon" cols="80" rows="1">${product.icon}</textarea></dd>
                </dl>
                <dl class="nowrap">
                    <dt>商品主图：</dt>
                    <dd><textarea name="detail" cols="80" rows="1">${product.detail}</textarea></dd>
                </dl>
                <dl class="nowrap">
                    <dt>商品详情页：</dt>
                    <dd><textarea name="images" cols="80" rows="10">${product.images}</textarea></dd>
                </dl>
            </fieldset>

            <fieldset>
                <dl class="nowrap">
                    <dt>操作：</dt>
                    <dd>
                        <div class="buttonActive">
                            <div class="buttonContent">
                                <button type="submit">保存</button>
                            </div>
                        </div>
                    </dd>
                </dl>
            </fieldset>
        </form>
    </div>
</div>