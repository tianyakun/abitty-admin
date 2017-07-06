<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<c:set var="targetType" value="${empty param.targetType ? 'navTab' : param.targetType}"/>
<div class="panelBar">
	<div class="pages">
		<span>Per Page</span>
		<select name="pageSize" onchange="dwzPageBreak({targetType:'${targetType}',data:{numPerPage:this.value}})">
			<c:forEach begin="50" end="200" step="50" varStatus="s">
				<option value="${s.index}" ${pageSize eq s.index ? 'selected="selected"' : ''}>${s.index}</option>
			</c:forEach>
		</select>

		<span>Total: ${totalCount}</span>
	</div>
	
	<div class="pagination" targetType="${targetType}" totalCount="${totalCount}" numPerPage="${pageSize}" pageNumShown="10" currentPage="${pageNum}"></div>
</div>