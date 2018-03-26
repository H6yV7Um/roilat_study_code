����   3x  $com/hansy/base/file/FileUpDownHelper  java/lang/Object log  Lorg/apache/commons/logging/Log; <clinit> ()V Code
    %org/apache/commons/logging/LogFactory   getLog 3(Ljava/lang/Class;)Lorg/apache/commons/logging/Log;	     LineNumberTable LocalVariableTable <init>
     this &Lcom/hansy/base/file/FileUpDownHelper; 
fileUpload Q(Lcom/hansy/base/file/model/FileTransBody;)Lcom/hansy/base/file/model/FileResult;
    'org/apache/http/impl/client/HttpClients    createDefault 3()Lorg/apache/http/impl/client/CloseableHttpClient; " 'org/apache/http/client/methods/HttpPost
 $ & % 'com/hansy/base/file/model/FileTransBody ' ( getFileUpAddr ()Ljava/lang/String;
 ! *  + (Ljava/lang/String;)V - java/util/ArrayList
 , 
 $ 0 1 ( getUuidFileName 3 5 4 java/util/List 6 7 add (Ljava/lang/Object;)Z
 $ 9 : ( getSavePath
 $ < = ( 
getExtName
 $ ? @ ( getOriginalFileName B (org/apache/http/entity/InputStreamEntity
 $ D E F getFileUpInputStream ()Ljava/io/InputStream;	 H J I "org/apache/http/entity/ContentType K L APPLICATION_OCTET_STREAM $Lorg/apache/http/entity/ContentType;
 A N  O <(Ljava/io/InputStream;Lorg/apache/http/entity/ContentType;)V
 Q S R )com/hansy/base/file/util/FileTransferUtil T U encryptData $(Ljava/util/List;)Ljava/lang/String; W data
 ! Y Z [ 	addHeader '(Ljava/lang/String;Ljava/lang/String;)V
 ! ] ^ _ 	setEntity (Lorg/apache/http/HttpEntity;)V a java/lang/StringBuilder c executing upfile request：
 ` *
 ! f g h getURI ()Ljava/net/URI;
 ` j k l append -(Ljava/lang/Object;)Ljava/lang/StringBuilder;
 ` n o ( toString q s r org/apache/commons/logging/Log t u info (Ljava/lang/Object;)V
 w y x /org/apache/http/impl/client/CloseableHttpClient z { execute g(Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/client/methods/CloseableHttpResponse; }  ~ 4org/apache/http/client/methods/CloseableHttpResponse � � getStatusLine ()Lorg/apache/http/StatusLine; � upfile respose status :  � � � org/apache/http/StatusLine � � getStatusCode ()I } � � � 	getEntity ()Lorg/apache/http/HttpEntity; � )org/apache/http/entity/BufferedHttpEntity
 � �  _ � UTF-8
 � � �  org/apache/http/util/EntityUtils o � B(Lorg/apache/http/HttpEntity;Ljava/lang/String;)Ljava/lang/String; � $com/hansy/base/file/model/FileResult
 � � � com/alibaba/fastjson/JSON � � parseObject 7(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;
 � � � � getBody &()Lcom/hansy/base/file/model/FileInfo;
 � � � "com/hansy/base/file/model/FileInfo � + setOriginalFileName � 连接文件服务器异常 � 00000001
 � �  � K(Ljava/lang/String;Ljava/lang/String;Lcom/hansy/base/file/model/FileInfo;)V � 文件上传失败：
 � � � java/lang/Exception � ( 
getMessage
 ` � k � -(Ljava/lang/String;)Ljava/lang/StringBuilder; q � � u error
 � � �  printStackTrace � 文件上传失败 :  } � �  close
 w � � 资源关闭失败：
 � � � java/io/IOException
 � � 	transBody )Lcom/hansy/base/file/model/FileTransBody; result &Lcom/hansy/base/fi