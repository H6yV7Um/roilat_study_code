����   3 �  @com/hansy/dataservice/sysmgr/service/impl/SysUserServiceImplTest  java/lang/Object sysUserService 5Lcom/hansy/dataservice/sysmgr/service/SysUserService; RuntimeVisibleAnnotations Ljavax/annotation/Resource; name <init> ()V Code
   
  LineNumberTable LocalVariableTable this BLcom/hansy/dataservice/sysmgr/service/impl/SysUserServiceImplTest; 
testsearch Lorg/junit/Test;  java/util/HashMap
    com/hansy/base/mybatis/Pager
  
     setBeginPageIndex (I)V	      " $ # 3com/hansy/dataservice/sysmgr/service/SysUserService % & search M(Lcom/hansy/base/mybatis/Pager;Ljava/util/Map;)Lcom/hansy/base/mybatis/Pager;	 ( * ) java/lang/System + , out Ljava/io/PrintStream;
  . / 0 getRows ()Ljava/util/List;
 2 4 3 java/io/PrintStream 5 6 println (Ljava/lang/Object;)V
  8 9 : getTotal ()J
 2 < 5 = (J)