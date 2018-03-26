<?xml version="1.0" encoding="utf-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.hansy.dataservice.sys.mapper.QueryOrgPayConfMapper">
	<!-- 1、配置返回结果Map和参数Map -->
	<resultMap type="QueryOrgPayConf" id="baseQueryOrgPayConfResultMap">
		<id property="orgId" column="ORG_ID"/>
		<result property="orgName" column="ORG_NAME"/>
		<result property="acctNo" column="ACCT_NO"/>
		<result property="insertTime" column="INSERT_TIME"/>
		<result property="payStandard" column="PAY_STANDARD"/>
		<result property="feePerTime" column="FEE_PER_TIME"/>
		<result property="monthlyPayStartTime" column="MONTHLY_PAY_START_TIME"/>
		<result property="monthlyPayEndTime" column="MONTHLY_PAY_END_TIME"/>
		<result property="updateTime" column="UPDATE_TIME"/>
	</resultMap>
	<resultMap type="QueryOrgPayConf" id="queryOrgPayConfResultMap" extends="baseQueryOrgPayConfResultMap">
	</resultMap>
	<!-- <parameter property="deptId" javaType="string" jdbcType="VARCHAR"/> -->
	<parameterMap type="QueryOrgPayConf" id="queryOrgPayConfParameterMap">
		<parameter property="orgId" javaType="long" jdbcType="BIGINT"/>
		<parameter property="orgName" javaType="string" jdbcType="VARCHAR"/>
		<parameter property="acctNo" javaType="string" jdbcType="VARCHAR"/>
		<parameter property="insertTime" javaType="date" jdbcType="TIMESTAMP"/>
		<parameter property="payStandard" javaType="string" jdbcType="VARCHAR"/>
		<parameter property="feePerTime" javaType="BigDecimal" jdbcType="DECIMAL"/>
		<parameter property="monthlyPayStartTime" javaType="date" jdbcType="TIMESTAMP"/>
		<parameter property="monthlyPayEndTime" javaType="date" jdbcType="TIMESTAMP"/>
		<parameter property="updateTime" javaType="date" jdbcType="TIMESTAMP"/>
	</parameterMap>

	<!-- 2、各个SeqID -->
	<insert id="add" parameterMap="queryOrgPayConfParameterMap">
		INSERT INTO T_QUERY_ORG_PAY_CONF (ORG_ID,ORG_NAME,ACCT_NO,INSERT_TIME,PAY_STANDARD,FEE_PER_TIME,MONTHLY_PAY_START_TIME,MONTHLY_PAY_END_TIME,UPDATE_TIME) VALUES (
			#{orgId, jdbcType=BIGINT}, 
			#{orgName, jdbcType=VARCHAR}, 
			#{acctNo, jdbcType=VARCHAR}, 
			#{insertTime, jdbcType=TIMESTAMP}, 
			#{payStandard, jdbcType=VARCHAR}, 
			#{feePerTime, jdbcType=DECIMAL}, 
			#{monthlyPayStartTime, jdbcType=TIMESTAMP}, 
			#{monthlyPayEndTime, jdbcType=TIMESTAMP}, 
			#{updateTime, jdbcType=TIMESTAMP}
		)
	</insert>
	<!-- 判断不可重复的属性是否已经存在，这里默认只判断deptName属性，具体的业务再进行修改添加 -->
	<!--
	<select id="isExists" resultType="integer" parameterMap="queryOrgPayConfParameterMap">
		SELECT COUNT(1) FROM T_QUERY_ORG_PAY_CONF WHERE DEPT_NAME=#{deptName}
		<if test="deptId != null and deptId !='' ">
			<![CDATA[ AND DEPT_ID <> #{deptId, jdbcType=VARCHAR} ]]>
		</if>
	</select>
	-->
	<select id="getById" resultMap="queryOrgPayConfResultMap" parameterType="string">
		SELECT * FROM T_QUERY_ORG_PAY_CONF WHERE  ORG_ID=#{value}
	</select>
	<select id="page" resultMap="queryOrgPayConfResultMap" parameterType="QueryOrgPayConf">
		SELECT * FROM T_QUERY_ORG_PAY_CONF WHERE 1=1
		<!-- 各种条件 --> 
		<!--
		<if test="deptName != null and deptName !='' ">
			<![CDATA[ AND DEPT_NAME LIKE CONCAT(CONCAT('%', #{deptName}),'%')]]>
		</if>
		-->
	</select>
	<select id="getTotal" resultType="long" parameterType="QueryOrgPayConf">
		SELECT COUNT(1) FROM T_QUERY_ORG_PAY_CONF WHERE 1=1
		<!-- 各种条件 --> 
		<!--
		<if test="deptName != null and deptName !='' ">
			<![CDATA[ AND DEPT_NAME LIKE CONCAT(CONCAT('%', #{deptName}),'%')]]>
		</if>
		-->
	</select>
	<delete id="deleteById" parameterType="string">
		DELETE FROM T_QUERY_ORG_PAY_CONF WHERE null = #{value}
	</delete>
	<update id="edit" parameterType="QueryOrgPayConf">
		UPDATE T_QUERY_ORG_PAY_CONF 
		<!-- 各种更改的字段 --> 
		<set>
				PAY_STANDARD = #{payStandard, jdbcType=VARCHAR}, 
				FEE_PER_TIME = #{feePerTime, jdbcType=DECIMAL}, 
				MONTHLY_PAY_START_TIME = #{monthlyPayStartTime, jdbcType=TIMESTAMP}, 
				MONTHLY_PAY_END_TIME = #{monthlyPayEndTime, jdbcType=TIMESTAMP}, 
				UPDATE_TIME = #{updateTime, jdbcType=TIMESTAMP}
				WHERE ORG_ID = #{orgId, jdbcType=BIGINT} 
		</set>
	</update>
</mapper>
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           