����   3 �  Dcom/hansy/dataservice/sys/service/impl/QueryOrgRegistServiceImplTest  java/lang/Object queryOrgRegistService 9Lcom/hansy/dataservice/sys/service/QueryOrgRegistService; RuntimeVisibleAnnotations Ljavax/annotation/Resource; name <init> ()V Code
   
  LineNumberTable LocalVariableTable this FLcom/hansy/dataservice/sys/service/impl/QueryOrgRegistServiceImplTest; 
testCreate Lorg/junit/Test;  /com/hansy/dataservice/sys/entity/QueryOrgRegist
  	        7com/hansy/dataservice/sys/service/QueryOrgRegistService   create Y(Lcom/hansy/dataservice/sys/entity/QueryOrgRegist;)Lcom/hansy/base/exception/BusinessMap;
 ! # " $com/hansy/base/exception/BusinessMap $ % 	getIsSucc ()Z	 ' ) ( java/lang/System * + out Ljava/io/PrintStream;
 - / . java/io/PrintStream 0  println 2 添加成功
 - 4 0 5 (Ljava/lang/String;