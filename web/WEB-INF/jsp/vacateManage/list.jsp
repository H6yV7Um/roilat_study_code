﻿<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询请休假管理列表</title>
<!-- 加载公共的样式，主要作用是清除浏览器的一些默认样式，页面公共排版，包括头部以及一些组件样式 -->
<link href="${ctx}/css/reset.css" rel="stylesheet" type="text/css" />

<link href="${ctx}/css/common.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/css/page.css" rel="stylesheet" type="text/css" />
<!-- css load end -->

<!-- 前端框架核心库加载放在 -->
<script src="${ctx}/js/lib/core.js" type="text/javascript"></script>
<script src="${ctx}/js/component/modal.js" type="text/javascript"></script>

<!-- 模块化框架配置 -->
<script type="text/javascript">
    // seajs 的简单配置
    seajs.config({
        base: "${ctx}/js",
        alias: {

        }
    });
</script>

</head>
<body>

	<div>
		<table class="table_list">
			<tr>
				<td>
					<!-- 查询条件 -->
					<input type="button" value="查询" id="searchBtn" />
					<input type="button" value="添加" id="addBtn" />
				</td>
			</tr>
		</table>
		<br/>
		<table id="tbwrap" class="table_list"></table>
		<div class="page eui-pager-custom" id="j_pager"></div>
	</div>
	
		<script type="text/html" id="tb_template">
		<thead>
			<tr>
				<th>主键ID</th>
				<th>员工编码</th>
				<th>员工姓名</th>
				<th>大区编码</th>
				<th>分公司编码</th>
				<th>营业部编码</th>
				<th>团队编码</th>
				<th>部门编码</th>
				<th>请假类型</th>
				<th>职务</th>
				<th>职级类别</th>
				<th>请假开始时间到结束的时间</th>
				<th>开始时间</th>
				<th>结束时间</th>
				<th>合计时间</th>
				<th>开始时间对应月份</th>
				<th>结束时间对应月份</th>
				<th>开始时间在月份的合计时间</th>
				<th>结束时间所在月份的时间</th>
				<th>请假原因</th>
				<th>状态</th>
				<th>审核意见</th>
				<th>请休假对应操作的月份</th>
				<th>创建人</th>
				<th>某个营业部登录并且录入城市经理时做记录</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody data-type="body">
			<!if(list.length>0) { !>
				<!for(var i=0,len=list.length;i<len;i++){
					var item = list[i],classItem = (i%2!=0)?"odd td_odd":"even";
				!>
				<tr class="gradeA <!=classItem!>">
					<td title="<!=item["priNumber"]!>"><!=item["priNumber"]!></td>
					<td title="<!=item["empNo"]!>"><!=item["empNo"]!></td>
					<td title="<!=item["empName"]!>"><!=item["empName"]!></td>
					<td title="<!=item["regionCode"]!>"><!=item["regionCode"]!></td>
					<td title="<!=item["filialeCode"]!>"><!=item["filialeCode"]!></td>
					<td title="<!=item["businessdeptCode"]!>"><!=item["businessdeptCode"]!></td>
					<td title="<!=item["teamCode"]!>"><!=item["teamCode"]!></td>
					<td title="<!=item["deptCode"]!>"><!=item["deptCode"]!></td>
					<td title="<!=item["leaveType"]!>"><!=item["leaveType"]!></td>
					<td title="<!=item["post"]!>"><!=item["post"]!></td>
					<td title="<!=item["rankType"]!>"><!=item["rankType"]!></td>
					<td title="<!=item["leaveInterval"]!>"><!=item["leaveInterval"]!></td>
					<td title="<!=item["startTime"]!>"><!=item["startTime"]!></td>
					<td title="<!=item["endTime"]!>"><!=item["endTime"]!></td>
					<td title="<!=item["totalTime"]!>"><!=item["totalTime"]!></td>
					<td title="<!=item["starttimeCorspmonth"]!>"><!=item["starttimeCorspmonth"]!></td>
					<td title="<!=item["endtimeCorspmonth"]!>"><!=item["endtimeCorspmonth"]!></td>
					<td title="<!=item["dayBystart"]!>"><!=item["dayBystart"]!></td>
					<td title="<!=item["dayByend"]!>"><!=item["dayByend"]!></td>
					<td title="<!=item["leaveReason"]!>"><!=item["leaveReason"]!></td>
					<td title="<!=item["status"]!>"><!=item["status"]!></td>
					<td title="<!=item["auditOpinion"]!>"><!=item["auditOpinion"]!></td>
					<td title="<!=item["dateofLeave"]!>"><!=item["dateofLeave"]!></td>
					<td title="<!=item["createUser"]!>"><!=item["createUser"]!></td>
					<td title="<!=item["salescreateflag"]!>"><!=item["salescreateflag"]!></td>
					<td>
						<a title="详情" data-value="<!=item["priNumber"]!>" class="detail">详情</a>
						<a title="修改" data-value="<!=item["priNumber"]!>" class="edit">修改</a>
						<a title="删除" data-value="<!=item["priNumber"]!>" class="delete">删除</a>
					</td>
				</tr>
			<!}!>
			<!}else{!>
				<tr>
					<td colspan="10"> 暂无数据</td>
				</tr>
			<!}!>
		</tbody>
	</script>


	<script type="text/javascript">
		var vacateManageDialog;
		$(function(){
			// 1、添加
			$("#addBtn").click(function(){
				seajs.use("component/dialog", function (dialog) {
				    vacateManageDialog = new dialog({
				        "width" : 800,
				        "height" : 600,
				        "contentType" : "iframe",
						"html" : "${ctx}/vacateManage/toAdd.do", // 内容
				        "title" : "添加请休假管理信息" //标题
					});
				});
			});
			// 2、详细
			$("#tbwrap").delegate(".detail", "click", function () {
				// 2.1 获取主键
				var priNumber = $(this).data("value");
				// 2.2 弹窗窗口，显示详细信息
				seajs.use("component/dialog", function (dialog) {
				    vacateManageDialog = new dialog({
				        "width" : 800,
				        "height" : 600,
				        "contentType" : "iframe",
						"html" : "${ctx}/vacateManage/view.do?priNumber="+priNumber, // 内容
				        "title" : "查看{beanCnName}详细信息" //标题
					});
				});
			});
			// 3、编辑
			$("#tbwrap").delegate(".edit", "click", function () {
				// 3.1 获取主键
				var priNumber = $(this).data("value");
				// 3.2 弹窗窗口，显示详细信息
				seajs.use("component/dialog", function (dialog) {
				    vacateManageDialog = new dialog({
				        "width" : 800,
				        "height" : 600,
				        "contentType" : "iframe",
						"html" : "${ctx}/vacateManage/toEdit.do?priNumber="+priNumber, // 内容
				        "title" : "编辑{beanCnName}详细信息" //标题
					});
				});
			});
			// 4、删除
			$("#tbwrap").delegate(".delete", "click", function () {
				var priNumber = $(this).data("value");
				if (confirm('确定删除？')) {
					$.post("${ctx}/vacateManage/delete.do", {priNumber : priNumber}, function (result) {
			            if ("succ" == result) {
			            	alert("操作成功");
							// 刷新列表页面
			                top.location.replace("${ctx}/vacateManage/list.do?ts="+new Date().getTime()); //如果操作成功则跳到列表界面 
							// 关闭弹窗窗口
			    			parent.vacateManageDialog.close();
			            } else {
			            	alert("操作失败");
			            }
			        }, "json");
				}
				
			});
			// 5、查询
			$("#searchBtn").click(function () {
				search();
	        });
		});
	
	</script>
	
	<script type="text/javascript">
		$(function () {
	        search();
	    });
		
		function strToObj(json){
		    return eval("("+json+")");
		}
		
		function search() {
			
	        seajs.use(["component/table"], function (uiTable) {
		        $.post("${ctx}/vacateManage/ajaxPage.do",
		        {
		        	page: 1
		        	// 其他查询条件
		        }, function (result) {
		        	result = strToObj(result);
		        	// alert("status="+result.status+", currentPage="+result.currentPage+", pageCount="+result.pageCount+", rowCount="+result.rowCount);
	            	var table = new uiTable({
	                	"con": "#tbwrap",
	                    "data": {
	                         "list": result.dataList
	                    },
	                    "template": "tb_template",
	                    "pager": {
	                    	"con": "#j_pager",
	                        "data": {
	                        	"currentPage": result.currentPage,
	                            "pageCount": result.pageCount,
	                            "rowCount": result.rowCount
	                        },
	                        template: '<a title="首页" class="page_first" data-role="first" href="#"></a><a title="上一页" class="page_prev" href="#" data-role="prev"></a><div data-value="pageNum"></div><a title="下一页" class="page_next" href="#" data-role="next"></a><a title="尾页" class="page_last" href="#" data-role="last"></a> 共<span data-target="rowCount"></span>条 跳转到 <input type="text" data-target="input" class="page_input"/><a href="#" data-role="go" class="go">GO</a>'
	                    }
	                });

	                table.getPager().bind("changePage", function (event, page, hander) {
	                	$.post("${ctx}/vacateManage/ajaxPage.do", { page: page,  deptCnName: deptCnName, deptEnName: deptEnName },
	                    function (result) {
	                    	result = strToObj(result);
	                    	table.render({ "list": result.dataList });
		                    hander({"currentPage": result.currentPage, "pageCount": result.pageCount, "rowCount": result.rowCount });
	                 	}, "json");
	                });
	        	}, "json");
	      	});
		}
	</script>

</body>
</html>
