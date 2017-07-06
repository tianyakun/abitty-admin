<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/include.inc.jsp" %>
<c:import url="/WEB-INF/jsp/_frag/pager/pagerForm.jsp"></c:import>

<div class=”layoutBox”>
    <div>
        <form method="post" rel="pagerForm" action="<c:url value='catalog/list'/>"
              onsubmit="return navTabSearch(this)">
            <div class="pageHeader">
                <div class="searchBar">
                    <table class="searchContent">
                        <tr>
                            <td>
                                <label>品类遍号:</label>
                                <input type="text" name="catalogNo" value="${catalogNo}"/>
                            </td>
                            <td>
                                <label>品类名称:</label>
                                <input type="text" name="catalogName" value="${catalogName}"/>
                            </td>
                            <td>
                                <label>品类状态:</label>
                                <select name="isDelete" style="width:100px">
                                    <option value="" ${"" eq isDelete ? 'selected="selected"' : ''}>--请选择--</option>
                                    <option value="0" ${"0" eq isDelete ? 'selected="selected"' : ''}>未删除</option>
                                    <option value="1" ${"1" eq isDelete ? 'selected="selected"' : ''}>已删除</option>
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
                <li><a class="add" href="<c:url value='catalog/add'/>" target="navTab"><span>新增品类</span></a></li>
                <li class="line">line</li>
            </ul>
        </div>
        <table class="table" width="100%" layoutH="138">
            <thead>
            <tr>
                <th width="100">序号</th>
                <th width="100">品类编号</th>
                <th width="100">品类名称</th>
                <th width="100">图标</th>
                <th width="100">简介</th>
                <th width="100">品类状态</th>
                <th width="100">创建时间</th>
                <th width="100">操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="item" items="${catalogList}" varStatus="s">
                <tr target="slt_objId" rel="${item.id }">
                    <td>${s.index + 1}</td>
                    <td>${item.catalogNo}</td>
                    <td>${item.catalogName}</td>
                    <td>${item.icon}</td>
                    <td>${item.description}</td>
                    <%--<td>${item.isDelete}</td>--%>
                    <c:choose>
                        <c:when test="${item.isDelete eq 0}">
                            <td>未删除</td>
                        </c:when>
                        <c:when test="${item.isDelete eq 1}">
                            <td>已删除</td>
                        </c:when>
                        <c:otherwise>
                            <td>${item.isDelete}</td>
                        </c:otherwise>
                    </c:choose>
                    <td>${item.createTime}</td>
                    <td><a href="<c:url value='catalog/edit/${item.id}'/>" target="navTab" rel="catalog">编辑</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <c:import url="/WEB-INF/jsp/_frag/pager/panelBar.jsp"></c:import>
</div>