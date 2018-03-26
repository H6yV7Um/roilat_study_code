<?xml version="1.0" encoding="utf-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.hansy.dataservice.sys.mapper.MulLoanCustMapper">
	<!-- 1、配置返回结果Map和参数Map -->
	<resultMap type="MulLoanCust" id="baseMulLoanCustResultMap">
		<id property="custName" column="CUST_NAME"/>
		<result property="certType" column="CERT_TYPE"/>
		<result property="certNo" column="CERT_NO"/>
		<result property="mobileTel" column="MOBILE_TEL"/>
		<result property="loanCorp" column="LOAN_CORP"/>
		<result property="insertTime" column="INSERT_TIME"/>
		<result property="updateTime" column="UPDATE_TIME"/>
	</resultMap>
	<resultMap type="MulLoanCust" id="mulLoanCustResultMap" extends="baseMulLoanCustResultMap">
	</resultMap>
	<!-- <parameter property="deptId" javaType="string" jdbcType="VARCHAR"/> -->
	<parameterMap type="MulLoanCust" id="mulLoanCustParameterMap">
		<parameter property="custName" javaType="string" jdbcType="VARCHAR"/>
		<parameter property="certType" javaType="string" jdbcType="VARCHAR"/>
		<parameter property="certNo" javaType="string" jdbcType="VARCHAR"/>
		<parameter property="mobileTel" javaType="string" jdbcType="VARCHAR"/>
		<parameter property="loanCorp" javaType="string" jdbcType="VARCHAR"/>
		<parameter property="insertTime" javaType="date" jdbcType="TIMESTAMP"/>
		<parameter property="updateTime" javaType="date" jdbcType="TIMESTAMP"/>
	</parameterMap>

	<!-- 2、各个SeqID -->
	<insert id="add" parameterMap="mulLoanCustParameterMap">
		INSERT INTO T_MUL_LOAN_CUST (CUST_NAME, CERT_TYPE, CERT_NO, MOBILE_TEL, LOAN_CORP, INSERT_TIME, UPDATE_TIME) VALUES (
			#{custName, jdbcType=VARCHAR}, 
			#{certType, jdbcType=VARCHAR}, 
			#{certNo, jdbcType=VARCHAR}, 
			#{mobileTel, jdbcType=VARCHAR}, 
			#{loanCorp, jdbcType=VARCHAR}, 
			#{insertTime, jdbcType=TIMESTAMP}, 
			#{updateTime, jdbcType=TIMESTAMP}
		)
	</insert>
	<!-- 判断不可重复的属性是否已经存在，这里默认只判断deptName属性，具体的业务再进行修改添加 -->
	<!--
	<select id="isExists" resultType="integer" parameterMap="mulLoanCustParameterMap">
		SELECT COUNT(1) FROM T_MUL_LOAN_CUST WHERE DEPT_NAME=#{deptName}
		<if test="deptId != null and deptId !='' ">
			<![CDATA[ AND DEPT_ID <> #{deptId, jdbcType=VARCHAR} ]]>
		</if>
	</select>
	-->
	<select id="getById" resultMap="mulLoanCustResultMap" parameterType="string">
		SELECT * FROM T_MUL_LOAN_CUST WHERE CUST_NAME = #{value}
	</select>
	<select id="page" resultMap="mulLoanCustResultMap" parameterType="MulLoanCust">
		SELECT * FROM T_MUL_LOAN_CUST WHERE 1=1
		<!-- 各种条件 --> 
		<!--
		<if test="deptName != null and deptName !='' ">
			<![CDATA[ AND DEPT_NAME LIKE CONCAT(CONCAT('%', #{deptName}),'%')]]>
		</if>
		-->
	</select>
	<select id="getTotal" resultType="long" parameterType="MulLoanCust">
		SELECT COUNT(1) FROM T_MUL_LOAN_CUST WHERE 1=1
		<!-- 各种条件 --> 
		<!--
		<if test="deptName != null and deptName !='' ">
			<![CDATA[ AND DEPT_NAME LIKE CONCAT(CONCAT('%', #{deptName}),'%')]]>
		</if>
		-->
	</select>
	<delete id="deleteById" parameterType="string">
		DELETE FROM T_MUL_LOAN_CUST WHERE CUST_NAME = #{value}
	</delete>
	<update id="edit" parameterType="MulLoanCust">
		UPDATE T_MUL_LOAN_CUST 
		<!-- 各种更改的字段 --> 
		<set>
			<if test="certType != null and certType !='' ">
				CERT_TYPE = #{certType, jdbcType=VARCHAR}, 
			</if>
			<if test="certNo != null and certNo !='' ">
				CERT_NO = #{certNo, jdbcType=VARCHAR}, 
			</if>
			<if test="mobileTel != null and mobileTel !='' ">
				MOBILE_TEL = #{mobileTel, jdbcType=VARCHAR}, 
			</if>
			<if test="loanCorp != null and loanCorp !='' ">
				LOAN_CORP = #{loanCorp, jdbcType=VARCHAR}, 
			</if>
			<if test="insertTime != null and insertTime !='' ">
				INSERT_TIME = #{insertTime, jdbcType=TIMESTAMP}, 
			</if>
			<if test="updateTime != null and updateTime !='' ">
				UPDATE_TIME = #{updateTime, jdbcType=TIMESTAMP}, 
			</if>

			WHERE CUST_NAME = #{custName, jdbcType=VARCHAR} 
		</set>
	</update>
</mapper>
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              