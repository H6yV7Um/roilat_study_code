����   3M  ,com/hansy/dataservice/api/service/APIService  java/lang/Object log  Lorg/apache/commons/logging/Log; merchantApiUrl Ljava/lang/String; RuntimeVisibleAnnotations 4Lorg/springframework/beans/factory/annotation/Value; value ${merchant_api_url} personalApiUrl ${personal_api_url} <init> ()V Code
    
    %org/apache/commons/logging/LogFactory   getLog 3(Ljava/lang/Class;)Lorg/apache/commons/logging/Log;	     LineNumberTable LocalVariableTable this .Lcom/hansy/dataservice/api/service/APIService; apiInvokePersonal �(Ljavax/servlet/http/HttpServletRequest;Ljavax/servlet/http/HttpServletResponse;Lcom/hansy/dataservice/api/vo/PersBlkListQueryVo;Ljava/lang/String;)Lcom/hansy/base/BaseReslt; 	Signature �(Ljavax/servlet/http/HttpServletRequest;Ljavax/servlet/http/HttpServletResponse;Lcom/hansy/dataservice/api/vo/PersBlkListQueryVo;Ljava/lang/String;)Lcom/hansy/base/BaseReslt<Ljava/lang/String;>; % com/hansy/base/BaseReslt
 $ 
 $ ( ) * 
setSuccess (Z)V , 参数为空！
 $ . / 0 setMsg (Ljava/lang/String;)V
 2 4 3 /com/hansy/dataservice/api/vo/PersBlkListQueryVo 5 6 	getCertNo ()Ljava/lang/String;
 8 : 9 com/hansy/base/util/StringUtil ; < isEmpty (Ljava/lang/String;)Z
 2 > ? 6 
getPhoneNo A 0电话号码和身份证号码不能都为空！
 2 C D 6 getSign F 签名为空！
 2 H I 6 getToken K 访问票据为空！ M xml
 O Q P java/lang/String R S equals (Ljava/lang/Object;)Z
 U W V -org/apache/http/impl/client/HttpClientBuilder X Y create 1()Lorg/apache/http/impl/client/HttpClientBuilder;
 U [ \ ] build 3()Lorg/apache/http/impl/client/CloseableHttpClient; _ 'org/apache/http/client/methods/HttpPost	  a  
 ^ c  0 e content-type g application/xml;charset=UTF-8
 ^ i j k 	setHeader '(Ljava/lang/String;Ljava/lang/String;)V m Accept o application/xml q java/lang/Class
  s t u getClass ()Ljava/lang/Class;
 w y x javax/xml/bind/JAXBContext z { newInstance 0([Ljava/lang/Class;)Ljavax/xml/bind/JAXBContext;
 w } ~  createMarshaller ()Ljavax/xml/bind/Marshaller; � jaxb.formatted.output
 � � � java/lang/Boolean � � valueOf (Z)Ljava/lang/Boolean; � � � javax/xml/bind/Marshaller � � setProperty '(Ljava/lang/String;Ljava/lang/Object;)V � jaxb.encoding � UTF-8 � java/io/StringWriter
 �  � � � � marshal %(Ljava/lang/Object;Ljava/io/Writer;)V
 � � � 6 toString	 � � � java/lang/System � � out Ljava/io/PrintStream;
 � � � java/io/PrintStream � 0 println � #org/apache/http/entity/StringEntity
 � �  k
 ^ � � � 	setEntity (Lorg/apache/http/HttpEntity;)V � � � !org/apache/http/client/HttpClient � � execute O(Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse; � � � org/apache/http/HttpResponse � � 	getEntity ()Lorg/apache/http/HttpEntity;
 � � �  org/apache/http/util/EntityUtils � � B(Lorg/apache/http/HttpEntity;Ljava/lang/String;)Ljava/lang/String;
 $ � � � setObj (Ljava/lang/Object;)V � json
 � � � com/alibaba/fastjson/JSON � � toJSONString &(Ljava/lang/Object;)Ljava/lang/String; � application/json;charset=UTF-8 � application/json � 不支持的返回类型！ � 接口调用时出错 � � � org/apache/commons/logging/Log � � error *(Ljava/lang/Object;Ljava/lang/Throwable;)V
 � � � java/lang/Exception �  printStackTrace request 'Ljavax/servlet/http/HttpServletRequest; servletResponse (Ljavax/servlet/http/HttpServletResponse; persBlkListQueryVo 1Lcom/hansy/dataservice/api/vo/PersBlkListQueryVo; dType result Lcom/hansy/base/BaseReslt; client #Lorg/apache/http/client/HttpClient; post )Lorg/apache/http/client/methods/HttpPost; reqStr context Ljavax/xml/bind/JAXBContext; 
marshaller Ljavax/xml/bind/Marshaller; writer Ljava/io/StringWriter; response Lorg/apache/http/HttpResponse; tem e Ljava/lang/Exception; LocalVariableTypeTable .Lcom/hansy/base/BaseReslt<Ljava/lang/String;>; StackMapTable � %javax/servlet/http/HttpServletRequest � &javax/servlet/http/HttpServletResponse apiInvokeMerchant �(Ljavax/servlet/http/HttpServletRequest;Ljavax/servlet/http/HttpServletResponse;Lcom/hansy/dataservice/api/vo/MerBlkListQueryVo;Ljava/lang/String;)Lcom/hansy/base/BaseReslt; �(Ljavax/servlet/http/HttpServletRequest;Ljavax/servlet/http/HttpServletResponse;Lcom/hansy/dataservice/api/vo/MerBlkListQueryVo;Ljava/lang/String;)Lcom/hansy/base/BaseReslt<Ljava/lang/String;>;
 .com/hansy/dataservice/api/vo/MerBlkListQueryVo 6 
getMerArea 商户所在区或县为空！

 6 
getMerCity 商户所在城市为空！
 6 
getMerName 商户名称为空！
 6 
getMerProv 商户所在省为空！
 C
 H	  