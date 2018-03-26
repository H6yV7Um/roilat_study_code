����   3 �  Dcom/hansy/dataservice/busi/service/impl/LoanBlackListServiceImplTest  java/lang/Object loanBlackListService 9Lcom/hansy/dataservice/busi/service/LoanBlackListService; RuntimeVisibleAnnotations Ljavax/annotation/Resource; name <init> ()V Code
   
  LineNumberTable LocalVariableTable this FLcom/hansy/dataservice/busi/service/impl/LoanBlackListServiceImplTest; 
testCreate Lorg/junit/Test;  /com/hansy/dataservice/busi/entity/LoanBlackList
  	        7com/hansy/dataservice/busi/service/LoanBlackListService   create Y(Lcom/hansy/dataservice/busi/entity/LoanBlackList;)Lcom/hansy/base/exception/BusinessMap;
 ! # " $com/hansy/base/exception/BusinessMap $ % 	getIsSucc ()Z	 ' ) ( java/lang/System * + out Ljava/io/PrintStream;
 - / . java/io/PrintStream 0  println 2 添加成功
 - 4 0 5 (Ljava/lang/String;)V
 7 9 8 java/lang/Exception :  printStackTrace loanBlackList 1Lcom/hansy/dataservice/busi/entity/LoanBlackList; bm &Lcom/hansy/base/exception/BusinessMap; e Ljava/lang/Exception; StackMapTable testIsExists
 D F E  com/bpnet/framework/util/IDUtils G H genUUID ()Ljava/lang/String;
  J K 5 setTableKey  M N O isExists 4(Lcom/hansy/dataservice/busi/entity/LoanBlackList;)Z
 - Q 0 R (Z)V testEdit  U V  edit X 修改成功 testGetById 
testDelete 
testSearch ] com/hansy/base/mybatis/Pager
 \ 
 \ ` a b setBeginPageIndex (I)V  d e f search o(Lcom/hansy/base/mybatis/Pager;Lcom/hansy/dataservice/busi/entity/LoanBlackList;)Lcom/hansy/base/mybatis/Pager;
 \ h i j getRows ()Ljava/util/List;
 - l 0 m (Ljava/lang/Object;)V
 \ o p q getTotal ()J
 - s 0 t (J)V
 \ v w q getTotalPageCount p Lcom/hansy/base/mybatis/Pager; pager 
SourceFile !LoanBlackListServiceImplTest.java Lorg/junit/runner/RunWith; value ALorg/springframework/test/context/junit4/SpringJUnit4ClassRunner; 9Lorg/springframework/test/context/TestExecutionListeners; SLorg/springframework/test/context/support/DependencyInjectionTestExecutionListener; 7Lorg/springframework/test/context/ContextConfiguration; 	locations "classpath*:/a