<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/include.inc.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=7" />
    <title>一点生活管理平台</title>

    <link href="<c:url value='/styles/dwz/themes/default/style.css'/>" rel="stylesheet" type="text/css" />
    <link href="<c:url value='/styles/dwz/themes/css/core.css'/>" rel="stylesheet" type="text/css" />
    <!--[if IE]>
    <link href="<c:url value='/styles/dwz/themes/css/ieHack.css'/>" rel="stylesheet" type="text/css" />
    <![endif]-->

    <script src="<c:url value='/styles/dwz/js/speedup.js'/>" type="text/javascript"></script>
    <script src="<c:url value='/styles/dwz/js/jquery-1.7.2.js'/>" type="text/javascript"></script>
    <script src="<c:url value='/styles/dwz/js/jquery.cookie.js'/>" type="text/javascript"></script>
    <script src="<c:url value='/styles/dwz/js/jquery.validate.js'/>" type="text/javascript"></script>
    <script src="<c:url value='/styles/dwz/js/jquery.bgiframe.js'/>" type="text/javascript"></script>
    <script src="<c:url value='/styles/xheditor/xheditor-1.2.1.min.js'/>" type="text/javascript"></script>
    <script src="<c:url value='/styles/xheditor/xheditor_lang/zh-cn.js'/>" type="text/javascript"></script>

    <script src="<c:url value='/styles/dwz/js/dwz.min.js'/>" type="text/javascript"></script>
    <script src="<c:url value='/styles/dwz/js/dwz.regional.zh.js'/>" type="text/javascript"></script>

    <script type="text/javascript">
        $(function(){
            DWZ.init("<c:url value='/styles/dwz/dwz.frag.xml'/>", {
                pageInfo:{pageNum:"pageNum", numPerPage:"pageSize", orderField:"orderField", orderDirection:"orderDirection"},
                debug:false,	// 调试模式 【true|false】
                callback:function(){
                    initEnv();
                    $("#themeList").theme({themeBase:"<c:url value='/styles/dwz/themes'/>"});
                }
            });
        });

    </script>
</head>

<body>
<div id="layout">
    <div id="header">
        <div class="headerNav">
            <a class="logo" href="javascript:void(0)">Logo</a>
            <ul class="themeList" id="themeList">
                <li theme="default"><div class="selected">blue</div></li>
                <li theme="green"><div>green</div></li>
                <li theme="purple"><div>purple</div></li>
                <li theme="silver"><div>silver</div></li>
                <li theme="azure"><div>azure</div></li>
            </ul>
        </div>
    </div>

    <div id="leftside">
        <div id="sidebar_s">
            <div class="collapse">
                <div class="toggleCollapse"><div></div></div>
            </div>
        </div>
        <div id="sidebar">
            <div class="toggleCollapse"><h2>菜单</h2><div>collapse</div></div>

            <div class="accordion" fillSpace="sideBar">
                <div class="accordionHeader">
                    <h2><span>Folder</span>商品管理</h2>
                </div>
                <div class="accordionContent">
                    <ul class="tree treeFolder">
                        <li><a href="<c:url value='catalog/list'/>" target="navTab" rel="catalog">品类列表</a></li>
                        <li><a href="<c:url value='product/list'/>" target="navTab" rel="product">商品列表</a></li>
                    </ul>
                </div>

                <div class="accordionHeader">
                    <h2><span>Folder</span>订单管理</h2>
                </div>
                <div class="accordionContent">
                    <ul class="tree treeFolder">
                        <li><a href="<c:url value='order/list'/>" target="navTab" rel="order">订单列表</a></li>
                    </ul>
                </div>
            </div>

        </div>
    </div>

    <div id="container">
        <div id="navTab" class="tabsPage">
            <div class="tabsPageHeader">
                <div class="tabsPageHeaderContent"><!-- 显示左右控制时添加 class="tabsPageHeaderMargin" -->
                    <ul class="navTab-tab">
                        <li tabid="main" class="main"><a href="javascript:void(0)"><span><span class="home_icon">My Home</span></span></a></li>
                    </ul>
                </div>
                <div class="tabsLeft">left</div><!-- 禁用只需要添加一个样式 class="tabsLeft tabsLeftDisabled" -->
                <div class="tabsRight">right</div><!-- 禁用只需要添加一个样式 class="tabsRight tabsRightDisabled" -->
                <div class="tabsMore">more</div>
            </div>
            <ul class="tabsMoreList">
                <li><a href="javascript:void(0)">My Home</a></li>
            </ul>
            <div class="navTab-panel tabsPageContent layoutBox">
                <div>
                    <div class="accountInfo">
                        <div class="right">
                            <p><fmt:formatDate value="${now}" pattern="dd MMMM yyyy, EEEE"/></p>
                        </div>
                        <p><span>Welcome, ${admin}!</span></p>
                    </div>
                    <div class="pageFormContent" layoutH="80">
                        <p>
                            <label>用户名:</label><span class="unit">${admin}</span>
                        </p>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>