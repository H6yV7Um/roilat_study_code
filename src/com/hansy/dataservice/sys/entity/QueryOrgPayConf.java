����   3A  (com/hansy/fsoa/sys/web/SysRoleController  java/lang/Object sysRoleService +Lcom/hansy/fsoa/sys/service/SysRoleService; RuntimeVisibleAnnotations Ljavax/annotation/Resource; name idGeneratorService /Lcom/hansy/fsoa/sys/service/IdGeneratorService; log  Lorg/apache/commons/logging/Log; <init> ()V Code
    
    %org/apache/commons/logging/LogFactory   getLog 3(Ljava/lang/Class;)Lorg/apache/commons/logging/Log;	     LineNumberTable LocalVariableTable this *Lcom/hansy/fsoa/sys/web/SysRoleController; ajaxPage �(Ljavax/servlet/http/HttpServletRequest;Ljavax/servlet/http/HttpServletResponse;Lcom/hansy/fsoa/sys/entity/SysRole;)Lcom/hansy/base/BaseReslt; 
Exceptions # java/lang/Exception 	Signature �(Ljavax/servlet/http/HttpServletRequest;Ljavax/servlet/http/HttpServletResponse;Lcom/hansy/fsoa/sys/entity/SysRole;)Lcom/hansy/base/BaseReslt<Lcom/hansy/base/mybatis/Pager<Lcom/hansy/fsoa/sys/entity/SysRole;>;>; 8Lorg/springframework/web/bind/annotation/RequestMapping; value 	/ajaxPage "Lcom/hansy/base/interceptor/DoLog; 	cnContent 角色分页查询 opType )Lcom/hansy/base/interceptor/DoLog$OPTYPE; RETRIEVE 'Lcom/hansy/base/interceptor/Permission; sysRole.ajaxPage 6Lorg/springframework/web/bind/annotation/ResponseBody; 3 com/hansy/base/BaseReslt
 2  6 com/hansy/base/mybatis/Pager
 5  9 pageNo ; = < %javax/servlet/http/HttpServletRequest > ? getParameter &(Ljava/lang/String;)Ljava/lang/String; A 1
 C E D java/lang/Integer F G parseInt (Ljava/lang/String;)I
 5 I J K 	setPageNo (I)V M pageSize
 5 O P K setPageSize	  R   T V U )com/hansy/fsoa/sys/service/SysRoleService W X search a(Lcom/hansy/base/mybatis/Pager;Lcom/hansy/fsoa/sys/entity/SysRole;)Lcom/hansy/base/mybatis/Pager;
 2 Z [ \ setObj (Ljava/lang/Object;)V request 'Ljavax/servlet/http/HttpServletRequest; response (Ljavax/servlet/http/HttpServletResponse; sysRole #Lcom/hansy/fsoa/sys/entity/SysRole; result Lcom/hansy/base/BaseReslt; p Lcom/hansy/base/mybatis/Pager; currentPage Ljava/lang/String; pager LocalVariableTypeTable _Lcom/hansy/base/BaseReslt<Lcom/hansy/base/mybatis/Pager<Lcom/hansy/fsoa/sys/entity/SysRole;>;>; CLcom/hansy/base/mybatis/Pager<Lcom/hansy/fsoa/sys/entity/SysRole;>; StackMapTable o &javax/servlet/http/HttpServletResponse q !com/hansy/fsoa/sys/entity/SysRole s java/lang/String addauthorityrole �(Ljavax/servlet/http/HttpServletRequest;Ljavax/servlet/http/HttpServletResponse;Lcom/hansy/fsoa/sys/entity/SysRoleVO;)Lcom/hansy/base/BaseReslt; �(Ljavax/servlet/http/HttpServletRequest;Ljavax/servlet/http/HttpServletResponse;Lcom/hansy/fsoa/sys/entity/SysRoleVO;)Lcom/hansy/base/BaseReslt<Lcom/hansy/fsoa/sys/entity/SysRoleVO;>; /addauthorityrole 添加系统角色 CREATE sysRole.addauthorityrole "RuntimeVisibleParameterAnnotations 5Lorg/springframework/web/bind/annotation/RequestBody;
 2 ~  � 
setSuccess (Z)V � 参数为空
 2 � � � setMsg (Ljava/lang/String;)V
 � � � com/hansy/base/util/SessionUtil � � getCurrentLoginUser )()Lcom/hansy/fsoa/login/entity/LoginUser;
 � � � %com/hansy/fsoa/login/entity/LoginUser � � 
getSysUser %()Lcom/hansy/fsoa/sys/entity/SysUser;
 � � � !com/hansy/fsoa/sys/entity/SysUser � � 	getUserId ()Ljava/math/BigInteger;
 � � � #com/hansy/fsoa/sys/entity/SysRoleVO � � setCreateBy (Ljava/math/BigInteger;)V
 � � � � setUpdateBy � java/util/Date
 � 
 � � � � setCreateDt (Ljava/util/Date;)V
 � � � � setUpdateDt	  � 
 	 � � � )com/hansy/fsoa/sys/service/impl/TableName � � 
t_sys_role +Lcom/hansy/fsoa/sys/service/impl/TableName; � � � -com/hansy/fsoa/sys/service/IdGeneratorService � � queryID @(Lcom/hansy/fsoa/sys/service/impl/TableName;)Ljava/lang/Integer; � java/math/BigInteger � java/lang/StringBuilder
 � 
 � � � � append -(Ljava/lang/Object;)Ljava/lang/StringBuilder;
 � � � � toString ()Ljava/lang/String;
 � �  �
 � � � � 	setRoleId
 � � � � getRoleName
 � � � com/hansy/base/util/StringUtil � � isEmpty (Ljava/lang/String;)Z � 角色名称为空 T � � � createAuthority J(Lcom/hansy/fsoa/sys/entity/SysRoleVO;)Lcom/hansy/base/common/BusinessMap;
 � � � !com/hansy/base/common/BusinessMap � � 	getIsSucc ()Z
 � � � � getMsg 	sysRoleVO %Lcom/hansy/fsoa/sys/entity/SysRoleVO; br user 'Lcom/hansy/fsoa/login/entity/LoginUser; upby Ljava/math/BigInteger; id Ljava/lang/Integer; bm #Lcom/hansy/base/common/BusinessMap; ALcom/hansy/base/BaseReslt<Lcom/hansy/fsoa/sys/entity/SysRoleVO;>; JLcom/hansy/base/common/BusinessMap<Lcom/hansy/fsoa/sys/entity/SysRoleVO;>; editup �(Ljavax/servlet/http/HttpServletRequest;Ljavax/servlet/http/HttpServletResponse;Lcom/hansy/fsoa/sys/entity/SysRoleVO;)Lcom/hansy/base/BaseReslt<Lcom/hansy/base/common/BusinessMap<Lcom/hansy/fsoa/sys/entity/SysRoleVO;>;>; /upauthorityrole 编辑系统角色 UPDATE sysRole.upauthorityrole � 参数为空！ � � � org/apache/commons/logging/Log � \ error T � � � fLcom/hansy/base/BaseReslt<Lcom/hansy/base/co