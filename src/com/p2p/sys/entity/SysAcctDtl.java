<?xml version="1.0" encoding="utf-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.hansy.dataservice.sys.mapper.BusiCodeMapper">
	<!-- 1、配置返回结果Map和参数Map -->
	<resultMap type="BusiCode" id="baseBusiCodeResultMap">
		<id property="id" column="ID"/>
		<result property="bizTypeCode" column="BIZ_TYPE_CODE"/>
		<result property="bizCodeValue" column="BIZ_CODE_VALUE"/>
		<result property="bizCodeName" column="BIZ_CODE_NAME"/>	
	</resultMap>
	<resultMap type="BusiCode" id="busiCodeResultMap" extends="baseBusiCodeResultMap">
	</resultMap>
	<!-- <parameter property="deptId" javaType="string" jdbcType="VARCHAR"/> -->
	<parameterMap type="BusiCode" id="busiCodeParameterMap">
		<parameter property="bizTypeCode" javaType="string" jdbcType="VARCHAR"/>
		<parameter property="bizCodeValue" javaType="string" jdbcType="VARCHAR"/>
		<parameter property="bizCodeName" javaType="string" jdbcType="VARCHAR"/>
		<parameter property="id" javaType="string" jdbcType="VARCHAR"/>
	</parameterMap>

	<!-- 2、各个SeqID -->
	<insert id="add" parameterMap="busiCodeParameterMap">
		<selectKey keyProperty="id" resultType="string" order="BEFORE">
			SELECT SEQ_BUSI_CODE.nextval from dual
		</selectKey>
		INSERT INTO T_BUSI_CODE (BIZ_TYPE_CODE, BIZ_CODE_VALUE, BIZ_CODE_NAME, ID) VALUES (
			#{bizTypeCode, jdbcType=VARCHAR}, 
			#{bizCodeValue, jdbcType=VARCHAR}, 
			#{bizCodeName, jdbcType=VARCHAR}, 
			#{id, jdbcType=VARCHAR}
		)
	</insert>
	<!-- 判断不可重复的属性是否已经存在，这里默认只判断deptName属性，具体的业务再进行修改添加 -->
	
	<select id="isExists" resultType="integer" parameterMap="busiCodeParameterMap">
		SELECT COUNT(1) FROM T_BUSI_CODE WHERE 1 = 1
		<if test="bizCodeName != null and bizCodeName !='' ">
			<![CDATA[ AND BIZ_CODE_NAME = #{bizCodeName, jdbcType=VARCHAR} ]]>
		</if>
		<if test="bizCodeValue != null and bizCodeValue !='' ">
			<![CDATA[ AND BIZ_CODE_VALUE = #{bizCodeValue, jdbcType=VARCHAR} ]]>
		</if>
	</select>
	
	<select id="getById" resultMap="busiCodeResultMap" parameterType="string">
		SELECT * FROM T_BUSI_CODE WHERE ID = #{value}
	</select>
	<select id="getParamByCode" resultMap="busiCodeResultMap" parameterType="string">
		SELECT * FROM T_BUSI_CODE WHERE BIZ_CODE_VALUE = #{value}
	</select>
<select id="getByTypeCode" parameterType="string" resultMap="busiCodeResultMap">
		SELECT * FROM T_BUSI_CODE WHERE BIZ_TYPE_CODE = #{value}
</select>	<select id="page" resultMap="busiCodeResultMap" parameterType="BusiCode">
		select * FROM T_BUSI_CODE where 1=1
		<if test="bizTypeCode != null and bizTypeCode !=''">
		and BIZ_TYPE_CODE = #{bizTypeCode}
		</if>
		<if test="bizCodeName != null and bizCodeName !=''">
		and BIZ_CODE_NAME like concat(concat('%',#{bizCodeName}),'%')
		</if>
		<!-- 各种条件 --> 
		<!--
		<if test="deptName != null and deptName !='' ">
			<![CDATA[ AND DEPT_NAME LIKE CONCAT(CONCAT('%', #{deptName}),'%')]]>
		</if>
		-->
	</select>
	<select id="pager" resultType="com.hansy.dataservice.sys.bo.BizBusiCode" parameterType="java.util.Map">
		select a.TYPE_NAME bizTypeName,b.BIZ_TYPE_CODE bizTypeCode,
		b.BIZ_CODE_VALUE bizCodeValue,b.BIZ_CODE_NAME bizCodeName,b.ID id  from T_BIZ_TYPE a,T_BUSI_CODE b where a.TYPE_CODE = B.BIZ_TYPE_CODE
		<if test="bizTypeCode != null and bizTypeCode !=''">
		and BIZ_TYPE_CODE = #{bizTypeCode}
		</if>
		<if test="bizCodeName != null and bizCodeName !=''">
		and BIZ_CODE_NAME like concat(concat('%',#{bizCodeName}),'%')
		</if>
		<!-- 各种条件 --> 
		<!--
		<if test="deptName != null and deptName !='' ">
			<![CDATA[ AND DEPT_NAME LIKE CONCAT(CONCAT('%', #{deptName}),'%')]]>
		</if>
		-->
	</select>
		<select id="getTotal" resultType="long" parameterType="java.util.Map">
		SELECT COUNT(1) FROM T_BUSI_CODE WHERE 1=1
		<if test="bizTypeCode != null and bizTypeCode !=''">
		and BIZ_TYPE_CODE = #{bizTypeCode}
		</if>
		<if test="bizCodeName != null and bizCodeName !=''">
		and BIZ_CODE_NAME like concat(concat('%',#{bizCodeName}),'%')
		</if>
		<!-- 各种条件 --> 
		<!--
		<if test="deptName != null and deptName !='' ">
			<![CDATA[ AND DEPT_NAME LIKE CONCAT(CONCAT('%', #{deptName}),'%')]]>
		</if>
		-->
	</select>
	<delete id="deleteById" parameterType="string">
		DELETE FROM T_BUSI_CODE WHERE ID = #{value}
	</delete>
	<update id="edit" parameterType="BusiCode">
		UPDATE T_BUSI_CODE 
		<!-- 各种更改的字段 --> 
		<set>
			<if test="bizCodeValue != null and bizCodeValue !='' ">
				BIZ_CODE_VALUE = #{bizCodeValue, jdbcType=VARCHAR}, 
			</if>
			<if test="bizCodeName != null and bizCodeName !='' ">
				BIZ_CODE_NAME = #{bizCodeName, jdbcType=VARCHAR}, 
			</if>
			<if test="id != null and id !='' ">
				 BIZ_TYPE_CODE = #{bizTypeCode, jdbcType=VARCHAR}
			</if>
			WHERE ID = #{id, jdbcType=VARCHAR}		</set>
	</update>
	
	<update id="update" parameterType="java.util.Map">
	UPDATE T_BUSI_CODE set BIZ_TYPE_CODE = #{bizTypeCode}
	where BIZ_TYPE_CODE = #{bizTypeCode1}
	</update>

</mapper>
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             