<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/include.inc.jsp" %>
<c:import url="/WEB-INF/jsp/_frag/pager/pagerForm.jsp"></c:import>

<h2 class="contentTitle">商品详情</h2>

<div class="pageFormContent" layoutH="60">
	<fieldset>
		<dl>
			<dt>ID：</dt>
			<dd><input type="text" name="id" value="${product.id}" readonly="true"/></dd>
		</dl>
		<dl>
			<dt>商品遍号：</dt>
			<dd><input type="text" name="productNo" value="${product.productNo}" readonly="true"/></dd>
		</dl>
		<dl>
			<dt>商品名称：</dt>
			<dd><input type="text" name="productName" value="${product.productName}" readonly="true"/></dd>
		</dl>
		<dl>
			<dt>商品分类：</dt>
			<dd><input type="text" name="catalogNo" value="${product.catalogName}" readonly="true"/></dd>
		</dl>
		<dl>
			<dt>商品规格：</dt>
			<dd><input type="text" name="description" value="${product.description}" readonly="true"/></dd>
		</dl>
		<dl>
			<dt>定价：</dt>
			<dd><input type="text" name="price" value="${product.price}" readonly="true"/></dd>
		</dl>
		<dl>
			<dt>现价：</dt>
			<input type="text" name="nowPrice" value="${product.nowPrice}" readonly="true"/>
		</dl>
		<dl>
			<dt>状态：</dt>
			<%--<dd><input type="text" name="status" value="${product.status}" readonly="true"/></dd>--%>
			<dd>
				<c:choose>
					<c:when test="${product.status eq 0}">
						<input type="text" name="status" value="新增" readonly="true">
					</c:when>
					<c:when test="${product.status eq 1}">
						<input type="text" name="status" value="上架" readonly="true">
					</c:when>
					<c:when test="${product.status eq 2}">
						<input type="text" name="status" value="下架" readonly="true">
					</c:when>
					<c:when test="${product.status eq 3}">
						<input type="text" name="status" value="删除" readonly="true">
					</c:when>
					<c:otherwise>
						<input type="text" name="status" value="${product.status}" readonly="true">
					</c:otherwise>
				</c:choose>
			</dd>
		</dl>
		<dl>
			<dt>配送类型：</dt>
			<dd><input type="text" name="deliveryType" value="${product.deliveryType}" readonly="true"/></dd>
		</dl>
		<dl>
			<dt>创建时间：</dt>
			<dd><input type="text" name="" value="${product.createTime}" readonly="true"/></dd>
		</dl>
	</fieldset>

	<fieldset>
		<dl class="nowrap">
			<dt>商品缩略图：</dt>
			<dd><textarea name="icon" cols="80" rows="1" readonly="true">${product.icon}</textarea></dd>
		</dl>
		<dl class="nowrap">
			<dt>商品主图：</dt>
			<dd><textarea name="detail" cols="80" rows="1" readonly="true">${product.detail}</textarea></dd>
		</dl>
		<dl class="nowrap">
			<dt>商品详情页：</dt>
			<dd><textarea name="images" cols="80" rows="10" readonly="true">${product.images}</textarea></dd>
		</dl>
	</fieldset>

	<fieldset>
		<dl class="nowrap">
			<dt>操作：</dt>
			<dd>
				<div class="buttonActive">
					<div class="buttonContent">
						<a href="<c:url value='product/edit/${product.id}'/>" target="navTab" rel="product">点击修改</a>
					</div>
				</div>
			</dd>
		</dl>
	</fieldset>
</div>