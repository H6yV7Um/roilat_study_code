����   3 �  Acom/hansy/base/exception/AnnotationHandlerMethodExceptionResolver  Worg/springframework/web/servlet/mvc/method/annotation/ExceptionHandlerExceptionResolver log  Lorg/apache/commons/logging/Log; defaultErrorView Ljava/lang/String; exceptionMappings Ljava/util/Properties; <clinit> ()V Code
    %org/apache/commons/logging/LogFactory   getLog 3(Ljava/lang/Class;)Lorg/apache/commons/logging/Log;	     LineNumberTable LocalVariableTable <init>
     this CLcom/hansy/base/exception/AnnotationHandlerMethodExceptionResolver; getDefaultErrorView ()Ljava/lang/String;	      setDefaultErrorView (Ljava/lang/String;)V doResolveHandlerMethodException �(Ljavax/servlet/http/HttpServletRequest;Ljavax/servlet/http/HttpServletResponse;Lorg/springframework/web/method/HandlerMethod;Ljava/lang/Exception;)Lorg/springframework/web/servlet/ModelAndView;
 & ( ' ,org/springframework/web/method/HandlerMethod ) * 	getMethod ()Ljava/lang/reflect/Method;
 , . - java/lang/Exception /  printStackTrace 1   3 5 4 org/apache/commons/logging/Log 6 7 error *(Ljava/lang/Object;Ljava/lang/Throwable;)V
  9 # $ ; 4org/springframework/web/bind/annotation/ResponseBody
 = ? > 3org/springframework/core/annotation/AnnotationUtils @ A findAnnotation N(Ljava/lang/reflect/Method;Ljava/lang/Class;)Ljava/lang/annotation/Annotation; C XMLHttpRequest E X-Requested-With G I H %javax/servlet/http/HttpServletRequest J K 	getHeader &(Ljava/lang/String;)Ljava/lang/String;
 M O N java/lang/String P Q equals (Ljava/lang/Object;)Z S ,org/springframework/web/servlet/ModelAndView U @org/springframework/web/servlet/view/json/MappingJacksonJsonView
 T 
 R X  Y )(Lorg/springframework/web/servlet/View;)V [ 2com/hansy/base/exception/DataServiceLoginException
 , ] ^  
getMessage ` b a &javax/servlet/http/HttpServletResponse c d 	setStatus (I)V f 	HS000001F h /com/hansy/base/exception/IllegalAccessExcepiton j 	HS000004F l java/lang/StringBuilder n 系统异常:
 k p  "
 k r s t append -(Ljava/lang/String;)Ljava/lang/StringBuilder;
 k v w  toString y 	HS000003F { code
 R } ~  	addObject T(Ljava/lang/String;Ljava/lang/Object;)Lorg/springframework/web/servlet/ModelAndView; � msg	  � 	 

 � � � java/util/Properties � � entrySet ()Ljava/util/Set; � � � java/util/Set � � iterator ()Ljava/util/Iterator; � � � java/util/Iterator � � next ()Ljava/lang/Object; � java/util/Map$Entry
 � � � java/lang/Object � � getClass ()Ljava/lang/Class;
 � � � java/lang/Class �  getName � � � � getKey � java/util/HashMap
 � 
 � � � $org/springframework/util/StringUtils � Q isEmpty � 系统异常！ � errorMsg � � � java/util/Map � � put 8(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; � � � � getValue
 � v
 R �  � $(Ljava/lang/String;Ljava/util/Map;)V � � � � hasNext ()Z ` � �  reset request 'Ljavax/servlet/http/HttpServletRequest; response (Ljavax/servlet/http/HttpServletResponse; handlerMethod .Lorg/springframework/web/method/HandlerMethod; 	exception Ljava/lang/Exception; method Ljava/lang/reflect/Method; returnValue .Lorg/springframework/web/servlet/ModelAndView; responseBodyAnn 6Lorg/springframework/web/bind/annotation/ResponseBody; jsonView e eSet Ljava/util/Set; entry Ljava/util/Map$Entry; param Ljava/util/Map; LocalVariableTypeTable LLjava/util/Set<Ljava/util/Map$Entry<Ljava/lang/Object;Ljava/lang/Object;>;>; ;Ljava/util/Map$Entry<Ljava/lang/Object;Ljava/lang/Object;>; 5Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>; StackMapTable � java/lang/reflect/Method getExceptionMappings ()Ljava/util/Properties; setExceptionMappings (Ljava/util/Properties;)V 
SourceFile -AnnotationHandlerMethodExceptionResolver.java InnerClasses Entry !      
           	 
           )      	� � �           5              /     *� �           4                    /     *� �           :              ! "     >     *+� �       
    >  ?                    # $    =    �-� �-� %:� �� +� 0� 2 *+,-� 8::� <� ::B+D� F � L� � �� RY� TY� V� W:0:	:
� Z� � \:	,�� _ e:
� E� g� � \:	,�� _ i:
� &� kYm� o� \� q� u:	,�� _ x:
z
� |W�	� |W�:�*� �� �*� �� �:� � :
� d
� � � �:	� �� �	� � � L� C� �Y� �:� \:� �� �:�� � W� RY	� � � �� �:� 
� � ���� -� �Y� �:��� � W,� � � RY*� � �:�  P � � ,     � 0   F  G  J  L  M  Q  S $ U / W ; Y P \ ` ] d ^ g ` o a v b  c � d � e � f � g � h � i � j � k � m � n � o � q � r � w � x � y z  {) |0 }8 ~< �H �] �` yj �o �x �� �� �� �    �   �      � � �   � � �   � � �   � � �  � � �  /m � �  ;a � �  `  � �  d { �  	 g x {  
 �  � �  � w � �  U � � 	) 7 � � 0 0 �  x ! � �  �   *  � w � �  U � � 	) 7 � � x ! � �  �   � �  �� < R :� 5 R M M"�    G ` & , � R :  ,�    G ` & , � R : �  �  � <   G ` & , � R : � � � � M  � #   G ` & , � R : �  �  � 	   G ` & , � R :  .  � �     /     *� ��           �              � �     >     *+� ��       
    �  �                	 
   �    � �   
  � � �	                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            