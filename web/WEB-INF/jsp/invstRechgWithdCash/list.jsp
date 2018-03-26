﻿<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询充值提现记录列表</title>
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
				<th>rechgWithdNo</th>
				<th>custNo</th>
				<th>custName</th>
				<th>txDate</th>
				<th>acctNo</th>
				<th>txAmt</th>
				<th>BAL</th>
				<th>bankNo</th>
				<th>bankName</th>
				<th>cardNo</th>
				<th>txFee</th>
				<th>feeAcctNo</th>
				<th>feeAcctName</th>
				<th>txCod</th>
				<th>txStat</th>
				<th>txDesc</th>
				<th>instDate</th>
				<th>updtDate</th>
				<th>recordStat</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody data-type="body">
			<!if(list.length>0) { !>
				<!for(var i=0,len=list.length;i<len;i++){
					var item = list[i],classItem = (i%2!=0)?"odd td_odd":"even";
				!>
				<tr class="gradeA <!=classItem!>">
					<td title="<!=item["rechgWithdNo"]!>"><!=item["rechgWithdNo"]!></td>
					<td title="<!=item["custNo"]!>"><!=item["custNo"]!></td>
					<td title="<!=item["custName"]!>"><!=item["custName"]!></td>
					<td title="<!=item["txDate"]!>"><!=item["txDate"]!></td>
					<td title="<!=item["acctNo"]!>"><!=item["acctNo"]!></td>
					<td title="<!=item["txAmt"]!>"><!=item["txAmt"]!></td>
					<td title="<!=item["BAL"]!>"><!=item["BAL"]!></td>
					<td title="<!=item["bankNo"]!>"><!=item["bankNo"]!></td>
					<td title="<!=item["bankName"]!>"><!=item["bankName"]!></td>
					<td title="<!=item["cardNo"]!>"><!=item["cardNo"]!></td>
					<td title="<!=item["txFee"]!>"><!=item["txFee"]!></td>
					<td title="<!=item["feeAcctNo"]!>"><!=item["feeAcctNo"]!></td>
					<td title="<!=item["feeAcctName"]!>"><!=item["feeAcctName"]!></td>
					<td title="<!=item["txCod"]!>"><!=item["txCod"]!></td>
					<td title="<!=item["txStat"]!>"><!=item["txStat"]!></td>
					<td title="<!=item["txDesc"]!>"><!=item["txDesc"]!></td>
					<td title="<!=item["instDate"]!>"><!=item["instDate"]!></td>
					<td title="<!=item["updtDate"]!>"><!=item["updtDate"]!></td>
					<td title="<!=item["recordStat"]!>"><!=item["recordStat"]!></td>
					<td>
						<a title="详情" data-value="<!=item["rechgWithdNo"]!>" class="detail">详情</a>
						<a title="修改" data-value="<!=item["rechgWithdNo"]!>" class="edit">修改</a>
						<a title="删除" data-value="<!=item["rechgWithdNo"]!>" class="delete">删除</a>
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
		var invstRechgWithdCashDialog;
		$(function(){
			// 1、添加
			$("#addBtn").click(function(){
				seajs.use("component/dialog", function (dialog) {
				    invstRechgWithdCashDialog = new dialog({
				        "width" : 800,
				        "height" : 600,
				        "contentType" : "iframe",
						"html" : "${ctx}/invstRechgWithdCash/toAdd.do", // 内容
				        "title" : "添加充值提现记录信息" //标题
					});
				});
			});
			// 2、详细
			$("#tbwrap").delegate(".detail", "click", function () {
				// 2.1 获取主键
				var rechgWithdNo = $(this).data("value");
				// 2.2 弹窗窗口，显示详细信息
				seajs.use("component/dialog", function (dialog) {
				    invstRechgWithdCashDialog = new dialog({
				        "width" : 800,
				        "height" : 600,
				        "contentType" : "iframe",
						"html" : "${ctx}/invstRechgWithdCash/view.do?rechgWithdNo="+rechgWithdNo, // 内容
				        "title" : "查看{beanCnName}详细信息" //标题
					});
				});
			});
			// 3、编辑
			$("#tbwrap").delegate(".edit", "click", function () {
				// 3.1 获取主键
				var rechgWithdNo = $(this).data("value");
				// 3.2 弹窗窗口，显示详细信息
				seajs.use("component/dialog", function (dialog) {
				    invstRechgWithdCashDialog = new dialog({
				        "width" : 800,
				        "height" : 600,
				        "contentType" : "iframe",
						"html" : "${ctx}/invstRechgWithdCash/toEdit.do?rechgWithdNo="+rechgWithdNo, // 内容
				        "title" : "编辑{beanCnName}详细信息" //标题
					});
				});
			});
			// 4、删除
			$("#tbwrap").delegate(".delete", "click", function () {
				var rechgWithdNo = $(this).data("value");
				if (confirm('确定删除？')) {
					$.post("${ctx}/invstRechgWithdCash/delete.do", {rechgWithdNo : rechgWithdNo}, function (result) {
			            if ("succ" == result) {
			            	alert("操作成功");
							// 刷新列表页面
			                top.location.replace("${ctx}/invstRechgWithdCash/list.do?ts="+new Date().getTime()); //如果操作成功则跳到列表界面 
							// 关闭弹窗窗口
			    			parent.invstRechgWithdCashDialog.close();
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
		        $.post("${ctx}/invstRechgWithdCash/ajaxPage.do",
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
	                	$.post("${ctx}/invstRechgWithdCash/ajaxPage.do", { page: page,  deptCnName: deptCnName, deptEnName: deptEnName },
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
