<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/include.inc.jsp" %>
<c:import url="/WEB-INF/jsp/_frag/pager/pagerForm.jsp"></c:import>

<div class=”layoutBox”>
    <div>
        <form method="post" rel="pagerForm" action="<c:url value='order/list'/>"
              onsubmit="return navTabSearch(this)">
            <div class="pageHeader">
                <div class="searchBar">
                    <table class="searchContent" width="100%">
                        <tr>
                            <td>
                                <label>订单号:</label>
                                <input type="text" name="orderNo" value="${orderNo}" style="width:100px"/>
                            </td>
                            <td>
                                <label style="width:50px">订单状态:</label>
                                <select name="status" style="width:100px">
                                    <option value="" ${"" eq status ? 'selected="selected"' : ''}>--请选择--</option>
                                    <option value="0" ${"0" eq status ? 'selected="selected"' : ''}>支付处理中</option>
                                    <option value="1" ${"1" eq status ? 'selected="selected"' : ''}>支付成功</option>
                                    <option value="2" ${"2" eq status ? 'selected="selected"' : ''}>服务中</option>
                                    <option value="3" ${"3" eq status ? 'selected="selected"' : ''}>订单结束</option>
                                </select>
                            </td>
                            <td>
                                <label>开始日期:</label>
                                <input type="text" name="startDate" class="date" dateFmt="yyyy-MM-dd" readonly="true" value="${startDate}" style="width:100px"/>
                                <a class="inputDateButton" href="#">选择</a>
                            </td>
                            <td>
                                <label>结束日期:</label>
                                <input type="text" name="endDate" class="date" dateFmt="yyyy-MM-dd" readonly="true" value="${endDate}" style="width:100px"/>
                                <a class="inputDateButton" href="#">选择</a>
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
                <%--<li><a class="add" href="<c:url value='catalog/add'/>" target="navTab"><span>新增品类</span></a></li>--%>
                <li class="line">line</li>
            </ul>
        </div>
        <table class="table" width="200%" layoutH="138">
            <thead>
            <tr>
                <th width="50">序号</th>
                <th width="100">订单号</th>
                <th width="100">创建时间</th>
                <th width="100">订单状态</th>
                <th width="100">用户UID</th>
                <th width="100">商品编号</th>
                <th width="100">服务月数</th>
                <th width="100">订单金额</th>
                <th width="100">商品总数量</th>
                <th width="100">配送次数</th>
                <th width="100">单次配送数量</th>
                <th width="100">已完成配送次数</th>
                <th width="100">下次配送单号</th>
                <th width="100">下次配送时间</th>
                <th width="100">操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="item" items="${orderVoList}" varStatus="s">
                <tr target="slt_objId" rel="${item.id }">
                    <td>${s.index + 1}</td>
                    <td>${item.orderNo}</td>
                    <td>${item.createTime}</td>
                    <c:choose>
                        <c:when test="${item.status eq 0}">
                            <td>支付处理中</td>
                        </c:when>
                        <c:when test="${item.status eq 1}">
                            <td>支付成功</td>
                        </c:when>
                        <c:when test="${item.status eq 2}">
                            <td>服务中</td>
                        </c:when>
                        <c:when test="${item.status eq 3}">
                            <td>订单结束</td>
                        </c:when>
                        <c:otherwise>
                            <td>${item.status}</td>
                        </c:otherwise>
                    </c:choose>
                    <td>${item.uid}</td>
                    <td>${item.productNo}</td>
                    <td>${item.serviceAtomCount}</td>
                    <td>${item.totalAmount}</td>
                    <td>${item.totalQuantity}</td>
                    <td>${item.totalSub}</td>
                    <td>${item.subQuantity}</td>
                    <td>${item.finishSub}</td>
                    <td>${item.nextSub}</td>
                    <td>${item.nextSubTime}</td>
                    <td><a href="<c:url value='order/detail/${item.id}'/>" target="navTab" rel="catalog">订单详情</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <c:import url="/WEB-INF/jsp/_frag/pager/panelBar.jsp"></c:import>
</div>