KEY IS NULL THEN
		'招标中'
	ELSE
		'已结标'
	END 'state'
	FROM
		t_bireq_publish bp
	INNER JOIN T_SYS_USER su ON bp.CREATOR = su.USER_ID
	INNER JOIN T_SYS_USER_DEPARTMENT ud ON su.USER_ID = ud.USER_ID
	INNER JOIN T_SYS_DEPARTMENT sd ON ud.DEPARTMENT_ID = sd.DEPARTMENT_ID
	LEFT JOIN t_tender_result tt ON bp.SN = tt.SN where bp.ISTENDER = '1'
    and tt.TABLE_KEY is NULL AND bp.stats='4' 
    <if test="bidName != null and bidName != ''">
     and bp.TITLE like concat(concat('%',#{bidName}),'%')
    </if>
     ORDER BY bp.MODIFYTIME desc
	</select>
	
    
    <select id="getTenderingListCount" parameterType="TenderQueryVo" resultType="long">
	SELECT
	count(1)
	FROM
		t_bireq_publish bp
	INNER JOIN T_SYS_USER su ON bp.CREATOR = su.USER_ID
	INNER JOIN T_SYS_USER_DEPARTMENT ud ON su.USER_ID = ud.USER_ID
	INNER JOIN T_SYS_DEPARTMENT sd ON ud.DEPARTMENT_ID = sd.DEPARTMENT_ID
	LEFT JOIN t_tender_result tt ON bp.SN = tt.SN where bp.ISTENDER = '1'
    and tt.TABLE_KEY is NULL AND bp.stats='4'
    <if test="bidName != null and bidName != ''">
     and bp.TITLE like concat(concat('%',#{bidName}),'%')
    </if>
	</select>
    
    
    
	<select id="getTenderEndList" parameterType="TenderQueryVo" resultType="TenderVo">
	SELECT
	bp.SN as 'bireqPublish.sn',
	bp.title as 'bireqPublish.title',
	bp.outline as 'bireqPublish.outline',
	bp.PUBLISHTIME as 'bireqPublish.publishtime',
	sd.DEPARTMENT_NAME as 'sysDepartment.departmentName',
	tt.IS_MEMBER_BID as 'tenderResult.isMemberBid',
	tt.CSN as 'tenderResult.csn',
	tt.BID_RESULT as 'tenderResult.bidResult',
	tt.BID_COMPANY_NAME as 'tenderResult.bidCompanyName',
	pe.EVAL_LEVEL as 'projectEval.evalLevel',
	pe.EVAL_DESC as 'projectEval.evalDesc',
	CASE WHEN tt.TABLE_KEY IS NULL THEN
		'招标中'
	ELSE
		'已结标'
	END 'state'
	FROM
		t_bireq_publish bp
	INNER JOIN T_SYS_USER su ON bp.CREATOR = su.USER_ID
	INNER JOIN T_SYS_USER_DEPARTMENT ud ON su.USER_ID = ud.USER_ID
	INNER JOIN T_SYS_DEPARTMENT sd ON ud.DEPARTMENT_ID = sd.DEPARTMENT_ID
	LEFT JOIN t_tender_result tt ON bp.SN = tt.SN
	LEFT JOIN T_PROJECT_EVAL pe ON tt.SN = pe.SN
    where bp.ISTENDER = '1' and tt.TABLE_KEY is not NULL  AND bp.stats='4' 
    <if test="bidName != null and bidName != ''">
     and bp.TITLE like concat(concat('%',#{bidName}),'%')
    </if>
     ORDER BY bp.MODIFYTIME desc
	</select>
	
	<select id="getTenderEndListCount" parameterType="TenderQueryVo" resultType="long">
	SELECT
	count(1)
	FROM
		t_bireq_publish bp
	INNER JOIN T_SYS_USER su ON bp.CREATOR = su.USER_ID
	INNER JOIN T_SYS_USER_DEPARTMENT ud ON su.USER_ID = ud.USER_ID
	INNER JOIN T_SYS_DEPARTMENT sd ON ud.DEPARTMENT_ID = sd.DEPARTMENT_ID
	LEFT JOIN t_tender_result tt ON bp.SN = tt.SN 
	where bp.ISTENDER = '1' and tt.TABLE_KEY is not NULL AND bp.stats='4'
	<if test="bidName != null and bidName != ''">
     and bp.TITLE like concat(concat('%',#{bidName}),'%')
    </if>
	</select>
</mapper>
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              ��示详细信息
				seajs.use("component/dialog", function (dialog) {
				    pubProdTypRatDialog = new dialog({
				        "width" : 800,
				        "height" : 600,
				        "contentType" : "iframe",
						"html" : "${ctx}/pubProdTypRat/toEdit.do?prodTyp="+prodTyp, // 内容
				        "title" : "编辑{beanCnName}详细信息" //标题
					});
				});
			});
			// 4、删除
			$("#tbwrap").delegate(".delete", "click", function () {
				var prodTyp = $(this).data("value");
				if (confirm('确定删除？')) {
					$.post("${ctx}/pubProdTypRat/delete.do", {prodTyp : prodTyp}, function (result) {
			            if ("succ" == result) {
			            	alert("操作成功");
							// 刷新列表页面
			                top.location.replace("${ctx}/pubProdTypRat/list.do?ts="+new Date().getTime()); //如果操作成功则跳到列表界面 
							// 关闭弹窗窗口
			    			parent.pubProdTypRatDialog.close();
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
		        $.post("${ctx}/pubProdTypRat/ajaxPage.do",
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
	                	$.post("${ctx}/pubProdTypRat/ajaxPage.do", { page: page,  deptCnName: deptCnName, deptEnName: deptEnName },
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
