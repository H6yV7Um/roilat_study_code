����   3 �  Icom/hansy/dataservice/busi/service/impl/LoanBlackPhoneListServiceImplTest  java/lang/Object loanBlackPhoneListService >Lcom/hansy/dataservice/busi/service/LoanBlackPhoneListService; RuntimeVisibleAnnotations Ljavax/annotation/Resource; name <init> ()V Code
   
  LineNumberTable LocalVariableTable this KLcom/hansy/dataservice/busi/service/impl/LoanBlackPhoneListServiceImplTest; 
testCreate Lorg/junit/Test;  4com/hansy/dataservice/busi/entity/LoanBlackPhoneList
  	        <com/hansy/dataservice/busi/service/LoanBlackPhoneListService   create ^(Lcom/hansy/dataservice/busi/entity/LoanBlackPhoneList;)Lcom/hansy/base/exception/BusinessMap;
 ! # " $com/hansy/base/exception/BusinessMap $ % 	getIsSucc ()Z	 ' ) ( java/lang/System * + out Ljava/io/PrintStream;
 - / . java/io/PrintStream 0  println 2 添加成功
 - 4 0 5 (Ljava/lang/String;)V
 7 9 8 java/lang/Exception :  printStackTrace loanBlackPhoneList 6Lcom/hansy/dataservice/busi/entity/LoanBlackPhoneList; bm &Lcom/hansy/base/exception/BusinessMap; e Ljava/lang/Exception; StackMapTable testIsExists
 D F E  com/bpnet/framework/util/IDUtils G H genUUID ()Ljava/lang/String;
  J K 5 setTableKey  M N O isExists 9(Lcom/ha