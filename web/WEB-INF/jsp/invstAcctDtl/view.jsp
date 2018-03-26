����   3 �  ?com/hansy/dataservice/sysmgr/service/impl/SysOrgServiceImplTest  java/lang/Object sysOrgService 4Lcom/hansy/dataservice/sysmgr/service/SysOrgService; RuntimeVisibleAnnotations Ljavax/annotation/Resource; name <init> ()V Code
   
  LineNumberTable LocalVariableTable this ALcom/hansy/dataservice/sysmgr/service/impl/SysOrgServiceImplTest; 
testsearch Lorg/junit/Test;  java/util/HashMap
    com/hansy/base/mybatis/Pager
  
     setBeginPageIndex (I)V	      " $ # 2com/hansy/dataservice/sysmgr/service/SysOrgService % & search M(Lcom/hansy/base/mybatis/Pager;Ljava/util/Map;)Lcom/hansy/base/mybatis/Pager;	 ( * ) java/lang/System + , out Ljava/io/PrintStream;
  . / 0 getRows ()Ljava/util/List;
 2 4 3 java/io/PrintStream 5 6 println (Ljava/lang/Object;)V
  8 9 : getTotal ()J
 2 < 5 = (J)V
  ? @ : getTotalPageCount map Ljava/util/Map; p Lcom/hansy/base/mybatis/Pager; pager LocalVariableTypeTable 5Ljava/util/Map<Ljava/lang/String;Ljava/lang/Object;>; 
testCreate J *com/hansy/dataservice/sysmgr/entity/SysOrg
 I 
 M O N java/lang/Integer P Q valueOf (I)Ljava/lang/Integer;
 I S T U setState (Ljava/lang/Integer;)V W  D35127801F284A5EAB43CC0B18942FC3
 I Y Z [ setOrgId (Ljava/lang/String;)V " ] ^ _ create T(Lcom/hansy/dataservice/sysmgr/entity/SysOrg;)Lcom/hansy/base/exception/BusinessMap;
 a c b $com/hansy/base/exception/BusinessMap d e 	getIsSucc ()Z
 2 g 5  i 添加成功
 2 k 5 [
 m o n java/lang/Exception p  printStackTrace sysOrg ,Lcom/hansy/dataservice/sysmgr/entity/SysOrg; bm &Lcom/hansy/base/exception/BusinessMap; e Ljava/lang/Exception; StackMapTable testEdit z  04CF2A62DC5449E785CD8942AE19C825 " | } _ edit  修改成功 testGetById � 10 " � � � getById @(Ljava/lang/String;)Lcom/hansy/dataservice/sysmgr/entity/SysOrg; 
testDelete " � � � delete '(Ljava/lang/String;)Ljava/lang/Boolean; 
SourceFile SysOrgServiceImplTest.java Lorg/junit/runner/RunWith; value ALorg/springframework/test/context/junit4/SpringJUnit4ClassRunner; 9Lorg/springframework/test/context/TestExecutionListeners; SLorg/springframework/test/context/support/DependencyInjectionTestExecutionListener; 7Lorg/springframework/test/context/ContextConfiguration; 	locations #classpath*:spring/spring-common.xml 'classpath*:spring/spring-datasource.xml &classpath*:spring/spring-hibernate.xml $classpath*:spring/spring-mybatis.xml (classpath*:spring/spring-transaction.xml "classpath*:spring/spring-beans.xml !                 	s    
      /     *� �           *                            �     @� Y� L� Y� M,� *� ,+� ! N� '-� -� 1� '-� 7� ;� '-� >� ;�      