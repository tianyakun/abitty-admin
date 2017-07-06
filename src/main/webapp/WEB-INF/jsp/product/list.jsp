<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/include.inc.jsp" %>
<c:import url="/WEB-INF/jsp/_frag/pager/pagerForm.jsp"></c:import>

<div class=”layoutBox”>
    <div>
        <form method="post" rel="pagerForm" action="<c:url value='product/list'/>"
              onsubmit="return navTabSearch(this)">
            <div class="pageHeader">
                <div class="searchBar">
                    <table class="searchContent">
                        <tr>
                            <td>
                                <label>商品遍号:</label>
                                <input type="text" name="productNo" value="${productNo}"/>
                            </td>
                            <td>
                                <label>商品名称:</label>
                                <input type="text" name="productName" value="${productName}"/>
                            </td>
                            <td>
                                <label>商品分类:</label>
                                <select name="catalogNo" style="width:100px">
                                    <option value="" ${"" eq catalogNo ? 'selected="selected"' : ''}>请选择</option>
                                    <c:forEach var="item" items="${catalogList}" varStatus="s">
                                        <option value="${item.catalogNo}" ${item.catalogNo eq catalogNo ? 'selected="selected"' : ''}>${item.catalogName}</option>
                                    </c:forEach>
                                </select>
                            </td>
                            <td>
                                <label>商品状态:</label>
                                <select name="status" style="width:100px">
                                    <option value="" ${"" eq status ? 'selected="selected"' : ''}>--请选择--</option>
                                    <option value="0" ${"0" eq status ? 'selected="selected"' : ''}>新增</option>
                                    <option value="1" ${"1" eq status ? 'selected="selected"' : ''}>上架</option>
                                    <option value="2" ${"2" eq status ? 'selected="selected"' : ''}>下架</option>
                                    <option value="3" ${"3" eq status ? 'selected="selected"' : ''}>删除</option>
                                </select>
                            </td>
                        </tr>
                    </table>
                    <div class="subBar">
                        <ul>
                            <li>
                                <div class="buttonActive">
                                    <div class="buttonContent">
                                        <button type="submit">搜索</button>
                                    </div>
                                </div>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </form>
    </div>
    <div class="pageContent">
        <div class="panelBar">
            <ul class="toolBar">
                <li class="line">line</li>
                <li><a class="add" href="<c:url value='product/add'/>" target="navTab"><span>新增商品</span></a></li>
                <li class="line">line</li>
            </ul>
        </div>
        <table class="table" width="100%" layoutH="138">
            <thead>
            <tr>
                <th width="50">序号</th>
                <th width="100">商品编号</th>
                <th width="100">商品名称</th>
                <th width="100">商品分类</th>
                <th width="100">商品状态</th>
                <th width="100">操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="item" items="${productList}" varStatus="s">
                <tr target="slt_objId" rel="${item.id }">
                    <td>${s.index + 1}</td>
                    <td>${item.productNo}</td>
                    <td>${item.productName}</td>
                    <td>${item.catalogName}</td>
                    <c:choose>
                        <c:when test="${item.status eq 0}">
                            <td>新增</td>
                        </c:when>
                        <c:when test="${item.status eq 1}">
                            <td>上架</td>
                        </c:when>
                        <c:when test="${item.status eq 2}">
                            <td>下架</td>
                        </c:when>
                        <c:when test="${item.status eq 3}">
                            <td>删除</td>
                        </c:when>
                        <c:otherwise>
                            <td>${item.status}</td>
                        </c:otherwise>
                    </c:choose>
                    <td><a href="<c:url value='product/view/${item.id}'/>" target="navTab" rel="product">查看详情</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <c:import url="/WEB-INF/jsp/_frag/pager/panelBar.jsp"></c:import>
</div>