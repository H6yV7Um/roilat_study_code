����   3	  &com/hansy/base/mybatis/PageInterceptor  java/lang/Object  $org/apache/ibatis/plugin/Interceptor logger  Lorg/apache/commons/logging/Log; dialectClass Ljava/lang/String; <init> ()V Code
    
    %org/apache/commons/logging/LogFactory   getLog 3(Ljava/lang/Class;)Lorg/apache/commons/logging/Log;	     LineNumberTable LocalVariableTable this (Lcom/hansy/base/mybatis/PageInterceptor; setProperties (Ljava/util/Properties;)V 	
   " ! java/util/Properties # $ getProperty &(Ljava/lang/String;)Ljava/lang/String;	  & 	 
 
properties Ljava/util/Properties; 	intercept 9(Lorg/apache/ibatis/plugin/Invocation;)Ljava/lang/Object; 
Exceptions - java/lang/Throwable
 / 1 0 #org/apache/ibatis/plugin/Invocation 2 3 	getTarget ()Ljava/lang/Object; 5 #org/apache/ibatis/executor/Executor
 / 7 8 9 getArgs ()[Ljava/lang/Object; ; )org/apache/ibatis/mapping/MappedStatement = #org/apache/ibatis/session/RowBounds ? 'org/apache/ibatis/session/ResultHandler
 : A B C getBoundSql 8(Ljava/lang/Object;)Lorg/apache/ibatis/mapping/BoundSql; E java/util/Map D G H I entrySet ()Ljava/util/Set; K M L java/util/Set N O iterator ()Ljava/util/Iterator; Q S R java/util/Iterator T 3 next V java/util/Map$Entry U X Y 3 getValue [ com/hansy/base/mybatis/Pager Q ] ^ _ hasNext ()Z
 Z a b c 	getPageNo ()I
 Z e f c getPageSize 4 h i j getTransaction -()Lorg/apache/ibatis/transaction/Transaction; l n m )org/apache/ibatis/transaction/Transaction o p getConnection ()Ljava/sql/Connection;
  r s t 
getDialect D(Ljava/sql/Connection;)Lcom/hansy/base/mybatis/pagedialect/IDialect;
 v x w "org/apache/ibatis/mapping/BoundSql y z getSql ()Ljava/lang/String; | ~ } +com/hansy/base/mybatis/pagedialect/IDialect  $ getCountString
 Z � � � getStart ()J | � � � getPagedString ((Ljava/lang/String;II)Ljava/lang/String; � � � java/sql/Connection � � prepareStatement 0(Ljava/lang/String;)Ljava/sql/PreparedStatement; � java/lang/StringBuilder � search sql:
 � �  � (Ljava/lang/String;)V
 � � � � append -(Ljava/lang/String;)Ljava/lang/StringBuilder;
 � � � z toString � � � org/apache/commons/logging/Log � � debug (Ljava/lang/Object;)V � search count sql:
  � � � copyFromBoundSql �(Lorg/apache/ibatis/mapping/MappedStatement;Lorg/apache/ibatis/mapping/BoundSql;Ljava/lang/String;)Lorg/apache/ibatis/mapping/BoundSql;
  � � � setParameters �(Ljava/sql/PreparedStatement;Lorg/apache/ibatis/mapping/MappedStatement;Lorg/apache/ibatis/mapping/BoundSql;Ljava/lang/Object;)V � � � java/sql/PreparedStatement � � executeQuery ()Ljava/sql/ResultSet; � � � java/sql/ResultSet T _ � � � � getInt (I)I � � �  close � �
 Z � � � 	setPageNo (I)V
 Z � � � setTotal (J)V
 Z � � � setStart (II)V � sql
 � � � !com/hansy/base/util/ReflectHelper � � setValueByFieldName 9(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;)V 4 � � � query �(Lorg/apache/ibatis/mapping/MappedStatement;Ljava/lang/Object;Lorg/apache/ibatis/session/RowBounds;Lorg/apache/ibatis/session/ResultHandler;Lorg/apache/ibatis/cache/CacheKey;Lorg/apache/ibatis/mapping/BoundSql;)Ljava/util/List;
 Z � � � setRows (Ljava/util/List;)V 
invocation %Lorg/apache/ibatis/plugin/Invocation; executor %Lorg/apache/ibatis/executor/Executor; mappedStatement +Lorg/apache/ibatis/mapping/MappedStatement; paramObject Ljava/lang/Object; 	rowBounds %Lorg/apache/ibatis/session/RowBounds; resultHandler )Lorg/apache/ibatis/session/ResultHandler; boundSql $Lorg/apache/ibatis/mapping/BoundSql; map Ljava/util/Map; pages Ljava/util/Iterator; page Lcom/hansy/base/mybatis/Pager; mapPage Ljava/util/Map$Entry; pageNo I pageSize dialect -Lcom/hansy/base/mybatis/pagedialect/IDialect; countSql pageSql 
connection Ljava/sql/Connection; 	countStmt Ljava/sql/PreparedStatement; countBS rs Ljava/sql/ResultSet; count 
totalCount totalPageCount list Ljava/util/List; 