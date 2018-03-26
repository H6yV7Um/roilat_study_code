����   3 �  8com/hansy/apis/server/component/InfoBodyArgumentResolver  java/lang/Object  Dorg/springframework/web/method/support/HandlerMethodArgumentResolver <init> ()V Code
     LineNumberTable LocalVariableTable this :Lcom/hansy/apis/server/component/InfoBodyArgumentResolver; supportsParameter -(Lorg/springframework/core/MethodParameter;)Z  )com/hansy/apis/server/annotation/InfoBody
    (org/springframework/core/MethodParameter   hasParameterAnnotation (Ljava/lang/Class;)Z 	parameter *Lorg/springframework/core/MethodParameter; resolveArgument �(Lorg/springframework/core/MethodParameter;Lorg/springframework/web/method/support/ModelAndViewContainer;Lorg/springframework/web/context/request/NativeWebRequest;Lorg/springframework/web/bind/support/WebDataBinderFactory;)Ljava/lang/Object; 
Exceptions   java/lang/Exception " %javax/servlet/http/HttpServletRequest $ & % 8org/springframework/web/context/request/NativeWebRequest ' ( getNativeRequest %(Ljava/lang/Class;)Ljava/lang/Object; ! * + , getContentType ()Ljava/lang/String; . application/json
 0 2 1 java/lang/String 3 4 contains (Ljava/lang/CharSequence;)Z 6 java/lang/RuntimeException 8  不是json的请求-------------
 5 :  ; (Ljava/lang/String;)V = desEcryBody ! ? @ A getAttribute &(Ljava/lang/String;)Ljava/lang/Object; C 报文体为空------------- E 1com/hansy/apis/server/component/JSONObjectWrapper
  G H I getParameterType ()Ljava/lang/Class;
 K M L java/lang/Class N  isAssignableFrom
 P R Q com/alibaba/fastjson/JSON S T parseObject 5(Ljava/lang/String;)Lcom/alibaba/fastjson/JSONObject;
 D V  W $(Lcom/alibaba/fastjson/JSONObject;)V
  Y Z [ getGenericParameterType ()Ljava/lang/reflect/Type;
  ] ^ _ readObj h(Lorg/springframework/core/MethodParameter;Ljava/lang/reflect/Type;Ljava/lang/String;)Ljava/lang/Object; mavContainer >Lorg/springframework/web/method/support/ModelAndViewContainer; 
webRequest :Lorg/springframework/web/context/request/NativeWebRequest; binderFactory ;Lorg/springframework/web/bind/support/WebDataBinderFactory; request 'Ljavax/servlet/http/HttpServletRequest; Ljava/lang/String; 	paramType Ljava/lang/reflect/Type; result Ljava/lang/Object; StackMapTable o :org/springframework/web/HttpMediaTypeNotSupportedExce