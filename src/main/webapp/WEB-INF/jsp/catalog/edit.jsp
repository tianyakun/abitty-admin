<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/include.inc.jsp" %>
<c:import url="/WEB-INF/jsp/_frag/pager/pagerForm.jsp"></c:import>

<h2 class="contentTitle">编辑商品</h2>

<div class="pageFormContent" layoutH="60">
    <div>
        <form method="post" rel="pagerForm" action="<c:url value='catalog/update'/>"
              onsubmit="return navTabSearch(this)">
            <fieldset>
                <dl>
                    <dt>ID：</dt>
                    <dd><input type="text" name="id" value="${catalog.id}" readonly="true"/></dd>
                </dl>
                <dl>
                    <dt>品类遍号：</dt>
                    <dd><input type="text" name="catalogNo" value="${catalog.catalogNo}"/></dd>
                </dl>
                <dl>
                    <dt>品类名称：</dt>
                    <dd><input type="text" name="catalogName" value="${catalog.catalogName}"/></dd>
                </dl>
                <dl>
                    <dt>品类简介：</dt>
                    <dd><input type="text" name="description" value="${catalog.description}"/></dd>
                </dl>
                <dl>
                    <dt>品类状态：</dt>
                    <dd>
                        <select name="isDelete" >
                            <option value="0" ${"0" eq catalog.isDelete ? 'selected="selected"' : ''}>未删除</option>
                            <option value="1" ${"1" eq catalog.isDelete ? 'selected="selected"' : ''}>已删除</option>
                        </select>
                    </dd>
                </dl>
                <dl>
                    <dt>创建时间：</dt>
                    <dd><input type="text" name="" value="${catalog.createTime}" readonly="true"/></dd>
                </dl>
                <dl class="nowrap">
                    <dt>品类缩略图：</dt>
                    <dd><textarea name="icon" cols="80" rows="1">${catalog.icon}</textarea></dd>
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