����   3P  <com/hansy/dataservice/api/web/MerchantBlackListApiController  java/lang/Object log  Lorg/apache/commons/logging/Log; queryOrgRegistService 9Lcom/hansy/dataservice/sys/service/QueryOrgRegistService; RuntimeVisibleAnnotations Ljavax/annotation/Resource; queryOrgPayConfService :Lcom/hansy/dataservice/sys/service/QueryOrgPayConfService; merchantBlackListApiService ?Lcom/hansy/dataservice/api/service/MerchantBlackListApiService; <init> ()V Code
    
    %org/apache/commons/logging/LogFactory   getLog 3(Ljava/lang/Class;)Lorg/apache/commons/logging/Log;	     LineNumberTable LocalVariableTable this >Lcom/hansy/dataservice/api/web/MerchantBlackListApiController; exist �(Lcom/hansy/dataservice/api/vo/MerBlkListQueryVo;Ljavax/servlet/http/HttpServletRequest;)Lcom/hansy/dataservice/api/vo/APIResult; 8Lorg/springframework/web/bind/annotation/RequestMapping; value /merchant/exist method 7Lorg/springframework/web/bind/annotation/RequestMethod; GET 6Lorg/springframework/web/bind/annotation/ResponseBody; * java/lang/StringBuffer
 ) 
  - . / checkParams D(Lcom/hansy/dataservice/api/vo/MerBlkListQueryVo;)Ljava/lang/String;
 1 3 2 com/hansy/base/util/StringUtil 4 5 isEmpty (Ljava/lang/String;)Z 7 &com/hansy/dataservice/api/vo/APIResult	 9 ; : *com/hansy/dataservice/api/common/ApiStatus < = STATUS_PARAM_ERROR ,Lcom/hansy/dataservice/api/common/ApiStatus;
 9 ? @ A getCode ()Ljava/lang/String;
 6 C  D '(Ljava/lang/String;Ljava/lang/String;)V
 F H G .com/hansy/dataservice/api/vo/MerBlkListQueryVo I A getToken	  K   M O N 7com/hansy/dataservice/sys/service/QueryOrgRegistService P Q queryOrgRegistInfoByToken E(Ljava/lang/String;)Lcom/hansy/dataservice/sys/entity/QueryOrgRegist;	  S  
 U W V /com/hansy/dataservice/sys/entity/QueryOrgRegist X Y getOrgId ()Ljava/lang/Long; [ ] \ 8com/hansy/dataservice/sys/service/QueryOrgPayConfService ^ _ getById D(Ljava/lang/Long;)Lcom/hansy/dataservice/sys/entity/QueryOrgPayConf;
 a c b java/lang/Exception d  printStackTrace	 9 f g = STATUS_ACCT_NOT_EXIST
 6 i  j /(Lcom/hansy/dataservice/api/common/ApiStatus;)V
 U l m A 	getTicket
 ) o p q append ,(Ljava/lang/String;)Ljava/lang/StringBuffer;
 F s t A 
getMerArea
 F v w A 
getMerCity
 F y z A 
getMerName
 F | } A 
getMerProv
 )  � A toString
 � � � *com/hansy/dataservice/api/tools/TokenUtils � � signWithSHA &(Ljava/lang/String;)Ljava/lang/String;
 F � � A getSign
 � � � java/lang/String � � equals (Ljava/lang/Object;)Z	 9 � � = STATUS_SIGN_ERROR
 ) � � � 	setLength (I)V � B对查询的数据进行签名进行签名失败，请求信息：
 F  � � � org/apache/commons/logging/Log � � error *(Ljava/lang/Object;Ljava/lang/Throwable;)V	 9 � � = STATUS_SYS_ERROR
 � � � 0com/hansy/dataservice/sys/entity/QueryOrgPayConf � A getPayStandard
 � � � � getMonthlyPayEndTime ()Ljava/util/Date;
 � � � � getFeePerTime ()Ljava/math/BigDecimal;
 U � � � 
getAcctBal
 U � � A getUserName	 � � � 4com/hansy/dataservice/api/common/DataServiceApiConts � � PAY_STANDARD_1 Ljava/lang/String;
 � � � java/math/BigDecimal � � doubleValue ()D	 9 � � = STATUS_ARREARAGE	 � � � � PAY_STANDARD_2	 � � � � PAY_STANDARD_3
 � � � com/hansy/base/util/DateUtil � � toDayEndDate "(Ljava/util/Date;)Ljava/util/Date;
 � � � java/util/Date � � getTime ()J
 �  � 
为用户[ � ]配置的收费方式为[ � 
]不存在 � � � � (Ljava/lang/Object;)V � java/util/HashMap
 �  � marName � � � java/util/Map � � put 8(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; � marProv � marArea � marCity	  �  
 � � � =com/hansy/dataservice/api/service/MerchantBlackListApiService � � queryMerBlkInfoByConditions (Ljava/util/Map;)I � *黑名单个人信息查询时发生异常 �  
 � �  saveInfoForQuery �(Lcom/hansy/dataservice/sys/entity/QueryOrgRegist;Lcom/hansy/dataservice/sys/entity/QueryOrgPayConf;Ljava/lang/String;Ljava/lang/String;ILcom/hansy/dataservice/api/vo/MerBlkListQueryVo;)Ljava/lang/String; <查询接口完成后，保存数据失败，错误信息：
 4com/hansy/base/exception/DataServiceAPIBusiException A 
getMessage
 1 0	 9 = 	STATUS_OK
 6  9(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V java/io/IOException merBlkListQueryVo 0Lcom/hansy/dataservice/api/vo/MerBlkListQueryVo; request 'Ljavax/servlet/http/HttpServletRequest; temp Ljava/lang/StringBuffer; 	errorInfo token 
orgRegInfo 1Lcom/hansy/dataservice/sys/entity/QueryOrgRegist; payConf 2Lcom/hansy/dataservice/sys/entity/QueryOrgPayConf; e2 Ljava/lang/Exception; ticket signStr newSign e Ljava/io/IOException; payStandard monthlyPayEndTime Ljava/util/Date; 
feePerTime Ljava/math/BigDecimal; acctBal userName map Ljava/util/Map; count I e1 re queryIp remark 6Lcom/hansy/base/exception/DataServiceAPIBusiException; isTarget LocalVariableTypeTable 5Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>; StackMapTable= %javax/servlet/http/HttpServletRequest? 参数异常为空A token为空C 签名信息为空E 商户名称为空G 商户所在省为空I 商户所在区或县为空K 商户所在城市为空 
SourceFile #MerchantBlackListApiController.java +Lorg/springframework/stereotype/Controller; /api/blacklist !               	     
       	     
       	     
           @     *� *� � �           %  &  %                !  	     "  #[ s $ %[ e & ' (     �    �� )Y� +N*+� ,:� 0� � 6Y� 8� >� B�+� E:*� J� L ::*� R� T� Z :� 
:� `� � � 6Y� e� h�� k:� )Y� +:		� n+� r� n+� u� n+� x� n+� {� n� nW	� ~� �:
+� �
� �� =� 6Y� �� h�:
-� �-�� n+� �� nW*� -� ~
� � � 6Y� �� h�� �:
� �:� �:� �:� �:� �
� �� � �� ��� �� 6Y� · h�� �
� �� � �� ��� u� 6Y� · h�� �
� �� '� ˶ ѻ �Y� ׸ ˶ є� F� 6Y� · h�-� �-ض n� nڶ n
� nܶ nW*� -� ~� � � 6Y� �� h�� �Y� �:�+� x� � W�+� {� � W�+� r� � W�+� u� � W*� �� �6� :*� �� � � 6Y� �� h��:�:*� �+�