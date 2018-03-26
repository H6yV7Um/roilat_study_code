<?xml version="1.0" encoding="utf-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.hansy.fsoa.corpmgr.mappers.CorpCertificationMapper">
	<!-- 1、配置返回结果Map和参数Map -->
	<resultMap type="CorpCertification" id="corpCertificationResultMap">
		<id property="tableKey" column="TABLE_KEY"/>
		<result property="CSN" column="CSN"/>
		<result property="certificationSrc" column="CERTIFICATION_SRC"/>
		<result property="certificationNo" column="CERTIFICATION_NO"/>
		<result property="certificationName" column="CERTIFICATION_NAME"/>
		<result property="STATS" column="STATS"/>
	</resultMap>
	<!-- <parameter property="deptId" javaType="string" jdbcType="VARCHAR"/> -->
	<parameterMap type="CorpCertification" id="corpCertificationParameterMap">
		<parameter property="tableKey" javaType="integer" jdbcType="INTEGER"/>
		<parameter property="CSN" javaType="integer" jdbcType="INTEGER"/>
		<parameter property="certificationSrc" javaType="string" jdbcType="CHAR"/>
		<parameter property="certificationNo" javaType="string" jdbcType="VARCHAR"/>
		<parameter property="certificationName" javaType="string" jdbcType="VARCHAR"/>
		<parameter property="STATS" javaType="string" jdbcType="CHAR"/>
	</parameterMap>

	<!-- 2、各个SeqID -->
	<insert id="add" parameterMap="corpCertificationParameterMap">
		INSERT INTO T_CORP_CERTIFICATION (TABLE_KEY, CSN, CERTIFICATION_SRC, CERTIFICATION_NO, CERTIFICATION_NAME, STATS) VALUES (
			#{tableKey, jdbcType=INTEGER}, 
			#{CSN, jdbcType=INTEGER}, 
			#{certificationSrc, jdbcType=CHAR}, 
			#{certificationNo, jdbcType=VARCHAR}, 
			#{certificationName, jdbcType=VARCHAR}, 
			#{STATS, jdbcType=CHAR}
		)
	</insert>
	<!-- 判断不可重复的属性是否已经存在，这里默认只判断deptName属性，具体的业务再进行修改添加 -->
	<!--
	<select id="isExists" resultType="integer" parameterMap="corpCertificationParameterMap">
		SELECT COUNT(1) FROM T_CORP_CERTIFICATION WHERE DEPT_NAME=#{deptName}
		<if test="deptId != null and deptId !='' ">
			<![CDATA[ AND DEPT_ID <> #{deptId, jdbcType=VARCHAR} ]]>
		</if>
	</select>
	-->
	<select id="getByCsn" resultMap="corpCertificationResultMap" parameterType="int">
		SELECT * FROM T_CORP_CERTIFICATION WHERE CSN = #{csn}
	</select>
	
	<select id="getCertListByCsn" parameterType="java.util.HashMap" resultMap="corpCertificationResultMap">
		SELECT * FROM T_CORP_CERTIFICATION WHERE CSN = #{csn} and STATS in 
		<foreach collection="status" open="(" close=")" separator="," item="s">
		#{s}
	</foreach> 
	</select>
	
	<select id="page" parameterType="map" resultType="java.util.LinkedHashMap">
	SELECT
		ci.CORPNAME AS 'name',
		count(cc.CSN) AS 'num',
		ci.CSN
	FROM
		T_CORP_INFO ci,
		T_CORP_CERTIFICATION cc
	WHERE
		ci.CSN = cc.CSN AND cc.STATS in 
		<foreach collection="status" open="(" close=")" separator="," item="s">
		#{s}
	</foreach> 
	GROUP BY 
		ci.CSN
	ORDER BY
		2 DESC
	</select>

	<!--会员指标统计资质数  -->	<select id="getTotal" resultType="long" parameterType="map">
		SELECT count(1)
		FROM
		(SELECT
			ci.CORPNAME
		FROM
			T_CORP_INFO ci,
			T_CORP_CERTIFICATION cc
		WHERE
			ci.CSN = cc.CSN AND cc.STATS in 
		<foreach collection="status" open="(" close=")" separator="," item="s">
		#{s}
	</foreach> 
		GROUP BY
		ci.CSN) cc
	</select>
	
	<!-- 获取资质名称列表 -->
	<select id="getCertList" parameterType="map" resultType="java.lang.String">
		SELECT
	cc.CERTIFICATION_NAME
	FROM
		T_CORP_INFO ci,
		T_CORP_CERTIFICATION cc
	WHERE
		ci.CSN = cc.CSN
	AND ci.CSN = #{CSN}	AND cc.STATS in 
		<foreach collection="status" open="(" close=")" separator="," item="s">
		#{s}
	</foreach> 
	</select>
	<delete id="deleteById" parameterType="string">
		DELETE FROM T_CORP_CERTIFICATION WHERE TABLE_KEY = #{value}
	</delete>
	<update id="edit" parameterType="CorpCertification">
		UPDATE T_CORP_CERTIFICATION 
		<!-- 各种更改的字段 --> 
		<set>
			<if test="CSN != null and CSN !='' ">
				CSN = #{CSN, jdbcType=INTEGER}, 
			</if>
			<if test="certificationSrc != null and certificationSrc !='' ">
				CERTIFICATION_SRC = #{certificationSrc, jdbcType=CHAR}, 
			</if>
			<if test="certificationNo != null and certificationNo !='' ">
				CERTIFICATION_NO = #{certificationNo, jdbcType=VARCHAR}, 
			</if>
			<if test="certificationName != null and certificationName !='' ">
				CERTIFICATION_NAME = #{certificationName, jdbcType=VARCHAR}, 
			</if>
			<if test="STATS != null and STATS !='' ">
				STATS = #{STATS, jdbcType=CHAR}, 
			</if>

		</set>
			WHERE TABLE_KEY = #{tableKey, jdbcType=INTEGER} 
	</update>
	
		<update id="editByCsn" parameterType="map">
		UPDATE T_CORP_CERTIFICATION 
			
			<set>
				<if test="stats != null and stats !='' ">
				STATS = #{stats}
			</if>
		</set>
			WHERE TABLE_KEY in 
        	<foreach item="item" index="index" collection="ids"
				open="(" separator="," close=")" >
				#{item}
			</foreach>	
			and STATS = 1
	</update>

<update id="batchUpdateCert" parameterType="java.util.Map">
		UPDATE T_CORP_CERTIFICATION set STATS = #{status}
		WHERE TABLE_KEY in 
	<foreach collection="keys" open="(" close=")" separator="," item="key">
			#{key,jdbcType=INTEGER}
	</foreach> 
	</update></mapper>
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         