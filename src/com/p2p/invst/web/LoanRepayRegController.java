/if>	 -->	
		<!-- 各种条件 --> 
		<!--
		<if test="deptName != null and deptName !='' ">
			<![CDATA[ AND DEPT_NAME LIKE CONCAT(CONCAT('%', #{deptName}),'%')]]>
		</if>
		-->
		<if test="mainbiz != null and mainbiz !='' ">
			<![CDATA[ AND info.MAINBIZ LIKE CONCAT(CONCAT('%', #{mainbiz}),'%')]]>
		</if>
		<if test="corpName != null and corpName !='' ">
			<![CDATA[ AND info.CORPNAME LIKE CONCAT(CONCAT('%', #{corpName}),'%')]]>
		</if>
	</select>
	<select id="getTotal" resultType="long" parameterType="CorpInfo">
		SELECT COUNT(1) from t_corp_info info ,t_sys_department dp 
		WHERE info.DEPARTMENT_ID = dp.DEPARTMENT_ID and dp.DEPARTMENT_CODE_PATH like '/004%'
		<!-- 各种条件 --> 
		<!--
		<if test="deptName != null and deptName !='' ">
			<![CDATA[ AND DEPT_NAME LIKE CONCAT(CONCAT('%', #{deptName}),'%')]]>
		</if>
		-->
		<if test="mainbiz != null and mainbiz !='' ">
			<![CDATA[ AND info.MAINBIZ LIKE CONCAT(CONCAT('%', #{mainbiz}),'%')]]>
		</if>
		<if test="corpName != null and corpName !='' ">
			<![CDATA[ AND info.CORPNAME LIKE CONCAT(CONCAT('%', #{corpName}),'%')]]>
		</if>
	</select>
	<delete id="deleteById" parameterType="string">
		DELETE FROM T_CORP_INFO WHERE CSN = #{value}
	</delete>
	<update id="edit" parameterType="CorpInfo">
		UPDATE T_CORP_INFO 
		<!-- 各种更改的字段 --> 
		<set>
			<if test="corName != null and corName !='' ">
				CORPNAME = #{CORPNAME, jdbcType=VARCHAR}, 
			</if>
			<if test="encorpName != null and encorpName !='' ">
				ENCORPNAME = #{ENCORPNAME, jdbcType=VARCHAR}, 
			</if>
			<if test="entCertNo != null and entCertNo !='' ">
				ENT_CERT_NO = #{entCertNo, jdbcType=CHAR}, 
			</if>
			<if test="logo != null and logo !='' ">
				LOGO = #{logo, jdbcType=VARCHAR}, 
			</if>
			<if test="abStract != null and abStract !='' ">
				ABSTRACT = #{abStract, jdbcType=VARCHAR}, 
			</if>
			<if test="mainbiz != null and mainbiz !='' ">
				MAINBIZ = #{mainbiz, jdbcType=VARCHAR}, 
			</if>
			<if test="busiOperSite != null and busiOperSite !='' ">
				BUSI_OPER_SITE = #{busiOperSite, jdbcType=VARCHAR}, 
			</if>
			<if test="registerTime != null and registerTime !='' ">
				REGISTER_TIME = #{registerTime, jdbcType=TIMESTAMP}, 
			</if>
			<if test="registerAssets != null and registerAssets !='' ">
				REGISTER_ASSETS = #{registerAssets, jdbcType=DECIMAL }, 
			</if>
			<if test="honor != null and honor !='' ">
				HONOR = #{honor, jdbcType=VARCHAR}, 
			</if>
			<if test="prjexperience != null and prjexperience !='' ">
				PRJEXPERIENCE = #{prjexperience, jdbcType=VARCHAR}, 
			</if>
			<if test="creator != null and creator !='' ">
				CREATOR = #{creator, jdbcType=INTEGER}, 
			</if>
			<if test="createTime != null and createTime !='' ">
				CREATETIME = #{createTime, jdbcType=TIMESTAMP}, 
			</if>
			<if test="modifier != null and modifier !='' ">
				MODIFIER = #{modifier, jdbcType=INTEGER}, 
			</if>
			<if test="modifyTime != null and modifyTime !='' ">
				MODIFYTIME = #{modifyTime, jdbcType=TIMESTAMP}, 
			</if>
		</set>
			WHERE CSN = #{csn, jdbcType=INTEGER} 
	</update>

	<update id="editCorpname" parameterType="map">
		UPDATE T_CORP_INFO_TMP 
		<set>
			<if test="corpName != null and corpName !='' ">
				CORPNAME = #{corpName}
			</if>
		</set>
			WHERE DEPARTMENT_ID = #{dpId}
	</update></mapper>
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     页面
	 * @creator: roilatD
	 * @createDate: 2016-06-24 
	 * @modifier:
	 * @modifiedDate:
	 * @param request
	 * @param response
	 * @param loanRepayReg
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/toEdit") @DoLog(cnContent="去到编辑还款记录页面") //@Permission(name="loanRepayReg.edit")
	public ModelAndView toEdit(HttpServletRequest request, HttpServletResponse response, LoanRepayReg loanRepayReg) throws Exception {
		LoanRepayReg result = loanRepayRegService.getById(loanRepayReg.getTxSeqNo());
		return new ModelAndView("loanRepayReg/edit").addObject("loanRepayReg",result);
	}
	
	/**
	 * 编辑还款记录
	 * @creator: roilatD
	 * @createDate: 2016-06-24 
	 * @modifier:
	 * @modifiedDate:
	 * @param request
	 * @param response
	 * @param loanRepayReg
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/edit") @DoLog(cnContent="编辑还款记录") //@Permission(name="loanRepayReg.edit")
	public String edit(HttpServletRequest request, HttpServletResponse response, LoanRepayReg loanRepayReg) throws Exception {
		BusinessMap bm = loanRepayRegService.edit(loanRepayReg);
		return this.ajax(response, bm.getIsSucc() ? Constants.SUCCESS : bm.getAlertMesg());
	}
	
	/**
	 * 查看还款记录信息
	 * @creator: roilatD
	 * @createDate: 2016-06-24 
	 * @modifier:
	 * @modifiedDate:
	 * @param request
	 * @param response
	 * @param loanRepayReg
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/view") @DoLog(cnContent="查看还款记录信息") //@Permission(name="loanRepayReg.view")
	public ModelAndView view(HttpServletRequest request, HttpServletResponse response, LoanRepayReg loanRepayReg) throws Exception {
		LoanRepayReg result = loanRepayRegService.getById(loanRepayReg.getTxSeqNo());
		return new ModelAndView("loanRepayReg/view").addObject("loanRepayReg",result);
	}
	
	/**
	 * 删除还款记录信息
	 * @creator: roilatD
	 * @createDate: 2016-06-24 
	 * @modifier:
	 * @modifiedDate:
	 * @param request
	 * @param response
	 * @param loanRepayReg
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/delete") @DoLog(cnContent="删除还款记录信息") //@Permission(name="loanRepayReg.delete")
	public String delete(HttpServletRequest request, HttpServletResponse response, LoanRepayReg loanRepayReg) throws Exception {
		boolean flag = loanRepayRegService.delete(loanRepayReg.getTxSeqNo());
		return this.ajax(response, flag ? Constants.SUCCESS : Constants.ERROR);
	}
	
}
