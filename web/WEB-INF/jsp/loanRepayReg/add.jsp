}, 
			</if>
			<if test="registerTime != null">
				REGISTER_TIME = #{registerTime, jdbcType=TIMESTAMP}, 
			</if>
			<if test="registerAssets != null and registerAssets !='' ">
				REGISTER_ASSETS = #{registerAssets, jdbcType=DECIMAL }, 
			</if>
			<if test="HONOR != null and HONOR !='' ">
				HONOR = #{HONOR, jdbcType=VARCHAR}, 
			</if>
			<if test="PRJEXPERIENCE != null and PRJEXPERIENCE !='' ">
				PRJEXPERIENCE = #{PRJEXPERIENCE, jdbcType=VARCHAR}, 
			</if>
			<if test="CREATOR != null and CREATOR !='' ">
				CREATOR = #{CREATOR, jdbcType=INTEGER}, 
			</if>
			<if test="CREATETIME != null">
				CREATETIME = #{CREATETIME, jdbcType=TIMESTAMP}, 
			</if>
			<if test="MODIFIER != null and MODIFIER !='' ">
				MODIFIER = #{MODIFIER, jdbcType=INTEGER}, 
			</if>
			<if test="MODIFYTIME != null">
				MODIFYTIME = #{MODIFYTIME, jdbcType=TIMESTAMP}, 
			</if>
			<if test="approveResult != null and approveResult !='' ">
				APPROVE_RESULT = #{approveResult, jdbcType=CHAR}, 
			</if>
			<if test="departmentId != null and departmentId !='' ">
				DEPARTMENT_ID = #{departmentId, jdbcType=INTEGER}
			</if>
		</set>
			WHERE CSN = #{CSN, jdbcType=INTEGER} and APPROVE_RESULT in ('2','3')
	</update>
	
	
	<update id="editByCsn" parameterType="CorpInfoTmp">
		UPDATE T_CORP_INFO_TMP 
		<!-- 各种更改的字段 --> 
		<set>
			<if test="CORPNAME != null and CORPNAME !='' ">
				CORPNAME = #{CORPNAME, jdbcType=VARCHAR}, 
			</if>
			<if test="ENCORPNAME != null and ENCORPNAME !='' ">
				ENCORPNAME = #{ENCORPNAME, jdbcType=VARCHAR}, 
			</if>
			<if test="entCertNo != null and entCertNo !='' ">
				ENT_CERT_NO = #{entCertNo, jdbcType=CHAR}, 
			</if>
			<if test="LOGO != null and LOGO !='' ">
				LOGO = #{LOGO, jdbcType=VARCHAR}, 
			</if>
			<if test="ABSTRACT != null and ABSTRACT !='' ">
				ABSTRACT = #{ABSTRACT, jdbcType=VARCHAR}, 
			</if>
			<if test="MAINBIZ != null and MAINBIZ !='' ">
				MAINBIZ = #{MAINBIZ, jdbcType=VARCHAR}, 
			</if>
			<if test="busiOperSite != null and busiOperSite !='' ">
				BUSI_OPER_SITE = #{busiOperSite, jdbcType=VARCHAR}, 
			</if>
			<if test="registerTime != null">
				REGISTER_TIME = #{registerTime, jdbcType=TIMESTAMP}, 
			</if>
			<if test="registerAssets != null and registerAssets !='' ">
				REGISTER_ASSETS = #{registerAssets, jdbcType=DECIMAL }, 
			</if>
			<if test="HONOR != null and HONOR !='' ">
				HONOR = #{HONOR, jdbcType=VARCHAR}, 
			</if>
			<if test="PRJEXPERIENCE != null and PRJEXPERIENCE !='' ">
				PRJEXPERIENCE = #{PRJEXPERIENCE, jdbcType=VARCHAR}, 
			</if>
			<if test="CREATOR != null and CREATOR !='' ">
				CREATOR = #{CREATOR, jdbcType=INTEGER}, 
			</if>
			<if test="CREATETIME != null">
				CREATETIME = #{CREATETIME, jdbcType=TIMESTAMP}, 
			</if>
			<if test="MODIFIER != null and MODIFIER !='' ">
				MODIFIER = #{MODIFIER, jdbcType=INTEGER}, 
			</if>
			<if test="MODIFYTIME != null">
				MODIFYTIME = #{MODIFYTIME, jdbcType=TIMESTAMP}, 
			</if>
			<if test="approveResult != null and approveResult !='' ">
				APPROVE_RESULT = #{approveResult, jdbcType=CHAR}, 
			</if>
			<if test="departmentId != null and departmentId !='' ">
				DEPARTMENT_ID = #{departmentId, jdbcType=INTEGER}
			</if>
		</set>
			WHERE CSN = #{CSN, jdbcType=INTEGER}
	</update>
	
	<update id="approveInfo" parameterType="CorpInfoTmp">
		UPDATE T_CORP_INFO_TMP 
		<!-- 各种更改的字段 --> 
		<set>
			<if test="CORPNAME != null and CORPNAME !='' ">
				CORPNAME = #{CORPNAME, jdbcType=VARCHAR}, 
			</if>
			<if test="ENCORPNAME != null and ENCORPNAME !='' ">
				ENCORPNAME = #{ENCORPNAME, jdbcType=VARCHAR}, 
			</if>
			<if test="entCertNo != null and entCertNo !='' ">
				ENT_CERT_NO = #{entCertNo, jdbcType=CHAR}, 
			</if>
			<if test="LOGO != null and LOGO !='' ">
				LOGO = #{LOGO, jdbcType=VARCHAR}, 
			</if>
			<if test="ABSTRACT != null and ABSTRACT !='' ">
				ABSTRACT = #{ABSTRACT, jdbcType=VARCHAR}, 
			</if>
			<if test="MAINBIZ != null and MAINBIZ !='' ">
				MAINBIZ = #{MAINBIZ, jdbcType=VARCHAR}, 
			</if>
			<if test="busiOperSite != null and busiOperSite !='' ">
				BUSI_OPER_SITE = #{busiOperSite, jdbcType=VARCHAR}, 
			</if>
			<if test="registerTime != null">
				REGISTER_TIME = #{registerTime, jdbcType=TIMESTAMP}, 
			</if>
			<if test="registerAssets != null and registerAssets !='' ">
				REGISTER_ASSETS = #{registerAssets, jdbcType=DECIMAL }, 
			</if>
			<if test="HONOR != null and HONOR !='' ">
				HONOR = #{HONOR, jdbcType=VARCHAR}, 
			</if>
			<if test="PRJEXPERIENCE != null and PRJEXPERIENCE !='' ">
				PRJEXPERIENCE = #{PRJEXPERIENCE, jdbcType=VARCHAR}, 
			</if>
			<if test="CREATOR != null and CREATOR !='' ">
				CREATOR = #{CREATOR, jdbcType=INTEGER}, 
			</if>
			<if test="CREATETIME != null">
				CREATETIME = #{CREATETIME, jdbcType=TIMESTAMP}, 
			</if>
			<if test="MODIFIER != null and MODIFIER !='' ">
				MODIFIER = #{MODIFIER, jdbcType=INTEGER}, 
			</if>
			<if test="MODIFYTIME != null">
				MODIFYTIME = #{MODIFYTIME, jdbcType=TIMESTAMP}, 
			</if>
			<if test="approveResult != null and approveResult !='' ">
				APPROVE_RESULT = #{approveResult, jdbcType=CHAR}, 
			</if>
			<if test="departmentId != null and departmentId !='' ">
				DEPARTMENT_ID = #{departmentId, jdbcType=INTEGER}
			</if>
		</set>
			WHERE CSN = #{CSN, jdbcType=INTEGER} and APPROVE_RESULT = '1'
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
                                                                                                                                                                                                                                                                                 