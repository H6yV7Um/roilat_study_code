����   3  com/hansy/base/util/DateUtil  java/lang/Object <init> ()V Code
  	   LineNumberTable LocalVariableTable this Lcom/hansy/base/util/DateUtil; 
getDayTime ()Ljava/lang/String;  java/text/SimpleDateFormat  yyyy-MM-dd HH:mm:ss
     (Ljava/lang/String;)V
     
setLenient (Z)V  java/util/Date
  	
     ! format $(Ljava/util/Date;)Ljava/lang/String; tempDate Ljava/text/SimpleDateFormat; getDay & 
yyyy-MM-dd 
formatDate 6(Ljava/util/Date;Ljava/lang/String;)Ljava/lang/String; *   date Ljava/util/Date; pattern Ljava/lang/String; StackMapTable calendar %(Ljava/util/Date;I)Ljava/lang/String;
 3 5 4 java/util/Calendar 6 7 getInstance ()Ljava/util/Calendar;
 3 9 : ; setTime (Ljava/util/Date;)V
 3 = > ? add (II)V
 3 A B C getTime ()Ljava/util/Date; I 	canlandar Ljava/util/Calendar; getDaysInMonth
 3 I J K get (I)I M java/lang/StringBuilder
 O Q P java/lang/String R S valueOf (I)Ljava/lang/String;
 L  V -0
 L X Y Z append -(Ljava/lang/String;)Ljava/lang/StringBuilder;
 L \ Y ] (I)Ljava/lang/StringBuilder; _ -
 L a b  toString
 O d R e &(Ljava/lang/Object;)Ljava/lang/String; g 0 cal _year _month _day str 	getMthDay getDaysInMonthYd p 05 month 
getGapDays 4(Ljava/util/Date;Ljava/util/Date;)Ljava/lang/String;
  u B v ()J    &\ 
 O z R { (J)Ljava/lang/String; start end milliseconds1 J milliseconds2 diff diffDays getDaysForNextInMonth &(Ljava/lang/String;)Ljava/lang/String;
 � � � java/lang/Integer � � parseInt (Ljava/lang/String;)I mthDate 	isNumeric (Ljava/lang/String;)Z
 O � � � length ()I
 O � � � charAt (I)C
 � � � java/lang/Character � � isDigit (C)Z i StringToDate 6(Ljava/lang/String;Ljava/lang/String;)Ljava/util/Date;
 � � � java/text/DateFormat � � parse $(Ljava/lang/String;)Ljava/util/Date;
 � � � java/text/ParseException �  printStackTrace dateStr 	formatStr dd Ljava/text/DateFormat; e Ljava/text/ParseException; getQuot '(Ljava/lang/String;Ljava/lang/String;)J
  �      �       <        rq1 rq2 quot ft date1 date2 dateDiff '(Ljava/lang/String;Ljava/lang/String;)I 
Exceptions � java/lang/Exception � yyyyMMdd
 � � � java/lang/Math � � round (F)I
 � � �  
getMessage
 �  fromDate toDate days df from to accountDate
 O � � � split '(Ljava/lang/String;)[Ljava/lang/String; � 6输入的终止日期年份小于起始日期的年份 qsrq bjrq s1 [Ljava/lang/String; s2 year1 year2 a month1 month2 b day1 day2 c � 
dateValues '(Ljava/lang/String;I)Ljava/lang/String;
 O � � � 	substring (II)Ljava/lang/String;
 3 � � � set (III)V rq ts cl dateValues_MONTH toDayStartDate "(Ljava/util/Date;)Ljava/util/Date; sdf toDayEndDate
  �   (J)V tmp 
SourceFile DateUtil.java !               /     *� �    
       	             	       M     � Y� K*� *� Y� � �    
        
         
  " #   	 $      M     � Y%� K*� *� Y� � �    
        
         
  " #   	 ' (     z     "*� )�+� %L� Y+� M,� ,*� �    
                        " + ,     " - .    " #  /     	 0 1     z     "� Y%� M� 2N-*� 8-� <,-� @� �    
       % 
 &  '  (  )    *    " + ,     " - D  
  " #    E F  	 G     �     � 2K*� H<*� H`=*� H>� �>� 6� �>� )� � �>� � � 	�>� 	��):
� $� LY� N� TU� W� [^� W� `:� !� LY� N� T^� W� [^� W� `:
�  � LY� c� Tf� W� [� `:� � LY� c� T� [� `:�    
   v    1  2 
 3  4  5  9 ! : $ ; , < / = 1 > ? ? B @ E A T B W C Z E ` F c G f I j J p K � L � M � O � P � Q � R � T    4   � h F   
 � i D   � j D   � k D  j � l .  /    	� '  3  � * O" 	 m      �     Y� 2K*� H`<*� H=� �=� 6� �=� )� � �=� � � 	�=� N�    
   B    \  ]  ^  _  c  d  e & f ) g + h 9 i < j ? k N l Q m T o        U h F    M j D   G k D  /    � ! 3 	 n     	     n� 2K*� H<*� H`=�oN� 	��� LY� N� T� `:
� � LYf� T� [� `:� LY� N� T^� W� W^� W-� W� `�    
   2    s  t 
 u  v  x  y  z ! { $ } 4 ~ :  L �    4   j h F   
 d i D   \ j D   V k .  4 : q .  /    � $  3 O  � ' O 	 r s     �  
   *� tA+� t7 e7 wm7� y�    
       �  �  �  �  �    >     | ,      } ,    ~     �     �     �   	 � �    e     �� 2L+� H=+� H`>+� H6*� �� �� 	��):
� $� LY� N� TU� W� [^� W� `:� !� LY� N� T^� W� [^� W� `:*� �
� � LYf� T*� W� `K� LY� c� T*� W� `�    
   F    �  � 
 �  �  � " � % � + � . � 1 � 5 � ; � Y � \ � z � � � � �    >    � � .    � h F  
 � i D   � j D   � k D  5 s l .  /    � %  O 3  � * O 	 � �     o     *� �<� *� �� �� �������    
       �  �  �  �  �         l .     � D  /    �  	 � �     �     � Y+� MN,*� �N� 
:� �-�     �  
       � 	 �  �  �  �  �    4     � .      � .  	  � �    + ,    � �  /    �   O O �   � 	 � �     �     G	A� Y%� :*� �:+� �:� t� teA  �m �m �m �mA� 
:� � �   ; > �  
   & 	   �  �  �  �  � ) � ; � @ � E �    H    G � .     G � .   E �    : � #   & � ,    � ,  @  � �  /    � >  O O   � 	 � �  �     �    �     B=� Yķ N-*� �:-+� �:� t� te wm�� �=� :� �Y� ̷ Ͽ�   . 1 �  
   * 
   �  �     % ( . 3 @    H    B � .     B � .   @ � D   6 � #    � ,    � ,  3  � �  /    � 1  O O   � 	 � �  �     �   �     |*^� �M+^� �N,2� �6-2� �6d� � �Y۷ Ͽdh6,2� �6-2� �6d6	,2� �6
-2� �6	`6
d� 	``6�    
   B        & 0 : B J Q  Y! a" h# p$ y&    �    | � .     | � .   u � �   n � �   f � D   ^ � D  : B � D  B : � D  J 2 � D  Q + � D 	 Y # � D 
 a  � D  h  � D  /   3 � 0  O O � �  � H  O O � �   	 � �  �     �        �� 2M,*� � �*� � �d*
� � �� �,� <� LY,� H� N� T^� W,� H	� f� )� W,� H`� [^� W,� H
� f� )� W,� H� [� `�    
      1 2 (3 .4         � � .     � � D   � � F  /   ? � Q  O 3  L�   O 3  L O` L�   O 3  L O 	 � �  �     �        �� 2M,*� � �*� � �d*
� � �� �,� <� LY,� H� N� T^� W,� H	� f� )� W,� H`� [^� W,� H
� f� )� W,� H� [� `�    
      > ? (@ .A         � � .     � � D   � � F  /   ? � Q  O 3  L�   O 3  L O` L�   O 3  L O 	 � �     �     � Y%� L++*� � ��M�  
   �  
      J 
L M N          + ,   
  � #    � �  /    �      � 	 � �     �     .� Y%� LM++*� � �M� N�� Y,� t wa
e� ��     �  
      X 
Y [ \ ] _    *    . + ,   
 $ � #   " ,    � �  /    �       �                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            