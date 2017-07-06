<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/include.inc.jsp" %>
<c:import url="/WEB-INF/jsp/_frag/pager/pagerForm.jsp"></c:import>

<h2 class="contentTitle">新增品类</h2>

<div class="pageFormContent" layoutH="60">
    <div>
        <form method="post" rel="pagerForm" action="<c:url value='catalog/save'/>"
              onsubmit="return navTabSearch(this)">
            <fieldset>
                <dl>
                    <dt>品类遍号：</dt>
                    <dd><input type="text" name="catalogNo" class="required"/></dd>
                </dl>
                <dl>
                    <dt>品类名称：</dt>
                    <dd><input type="text" name="name" class="required"/></dd>
                </dl>
                <dl>
                    <dt>品类简介：</dt>
                    <dd><input type="text" name="description" class="required"/></dd>
                </dl>
                <dl class="nowrap">
                    <dt>品类缩略图：</dt>
                    <dd><textarea name="icon" cols="80" rows="1"></textarea></dd>
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
        </form>
    </div>
</div>