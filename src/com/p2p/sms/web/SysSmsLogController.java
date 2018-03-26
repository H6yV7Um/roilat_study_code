����   3)  com/hansy/apis/utils/RSAEncrypt  java/lang/Object HEX_CHAR [C <clinit> ()V Code	     LineNumberTable LocalVariableTable <init>
     this !Lcom/hansy/apis/utils/RSAEncrypt; 
genKeyPair (Ljava/lang/String;)V  RSA
    java/security/KeyPairGenerator   getInstance 4(Ljava/lang/String;)Ljava/security/KeyPairGenerator;
     &java/security/NoSuchAlgorithmException !  printStackTrace # java/security/SecureRandom
 " 
  & ' ( 
initialize  (ILjava/security/SecureRandom;)V
  * + , generateKeyPair ()Ljava/security/KeyPair;
 . 0 / java/security/KeyPair 1 2 
getPrivate ()Ljava/security/PrivateKey; 4 &java/security/interfaces/RSAPrivateKey
 . 6 7 8 	getPublic ()Ljava/security/PublicKey; : %java/security/interfaces/RSAPublicKey 9 < = > 
getEncoded ()[B
 @ B A &org/apache/commons/codec/binary/Base64 C D encodeBase64String ([B)Ljava/lang/String; 3 < G java/io/FileWriter I java/lang/StringBuilder
 K M L java/lang/String N O valueOf &(Ljava/lang/Object;)Ljava/lang/String;
 H Q   S /publicKey.keystore
 H U V W append -(Ljava/lang/String;)Ljava/lang/StringBuilder;
 H Y Z [ toString ()Ljava/lang/String;
 F Q ^ /privateKey.keystore ` java/io/BufferedWriter
 _ b  c (Ljava/io/Writer;)V
 _ e f  write
 _ h i  flush
 _ k l  close
 F k
 o   p java/lang/Exception filePath Ljava/lang/String; 
keyPairGen  Ljava/security/KeyPairGenerator; e (Ljava/security/NoSuchAlgorithmException; keyPair Ljava/security/KeyPair; 
privateKey (Ljava/security/interfaces/RSAPrivateKey; 	publicKey 'Ljava/security/interfaces/RSAPublicKey; publicKeyString privateKeyString pubfw Ljava/io/FileWriter; prifw pubbw Ljava/io/BufferedWriter; pribw Ljava/lang/Exception; StackMapTable loadPublicKeyByFile &(Ljava/lang/String;)Ljava/lang/String; 
Exceptions � java/io/BufferedReader � java/io/FileReader
 � Q
 � �  � (Ljava/io/Reader;)V
 H 
 � � � [ readLine
 � k � 公钥数据流读取错误
 o Q � 公钥输入流为空 � java/io/IOException � java/lang/NullPointerException path br Ljava/io/BufferedReader; sb Ljava/lang/StringBuilder; Ljava/io/IOException;  Ljava/lang/NullPointerException; loadPublicKeyByStr ;(Ljava/lang/String;)Ljava/security/interfaces/RSAPublicKey;
 @ � � � decodeBase64 (Ljava/lang/String;)[B
 � � � java/security/KeyFactory  � .(Ljava/lang/String;)Ljava/security/KeyFactory; � %java/security/spec/X509EncodedKeySpec
 � �  � ([B)V
 � � � � generatePublic 7(Ljava/security/spec/KeySpec;)Ljava/security/PublicKey; � 无此算法 � 公钥非法 � 公钥数据为空 � *java/security/spec/InvalidKeySpecException publicKeyStr buffer [B 
keyFactory Ljava/security/KeyFactory; keySpec 'Ljava/security/spec/X509EncodedKeySpec; ,Ljava/security/spec/InvalidKeySpecException; loadPrivateKeyByFile � 私钥数据读取错误 � 私钥输入流为空 loadPrivateKeyByStr <(Ljava/lang/String;)Ljava/security/interfaces/RSAPrivateKey; � &java/security/spec/PKCS8EncodedKeySpec
 � �
 � � � � generatePrivate 8(Ljava/security/spec/KeySpec;)Ljava/security/PrivateKey; � 私钥非法 � 私钥数据为空 privateKeyStr (Ljava/security/spec/PKCS8EncodedKeySpec; encrypt -(Ljava/security/interfaces/RSAPublicKey;[B)[B � 加密公钥为空, 请设置
 � � � javax/crypto/Cipher  � )(Ljava/lang/String;)Ljavax/crypto/Cipher;
 � � � � init (ILjava/security/Key;)V
 � � � � doFinal ([B)[B � 无此加密算法
 �   � #javax/crypto/NoSuchPaddingException � 加密公钥非法,请检查 � 明文长度非法 � 明文数据已损坏 � !java/security/InvalidKeyException � &javax/crypto/IllegalBlockSizeException   javax/crypto/BadPaddingException plainTextData cipher Ljavax/crypto/Cipher; output %Ljavax/crypto/NoSuchPaddingException; #Ljava/security/InvalidKeyException; (Ljavax/crypto/IllegalBlockSizeException; "Ljavax/crypto/BadPaddingException; � .(Ljava/security/interfaces/RSAPrivateKey;[B)[B 加密私钥为空, 请设置 加密私钥非法,请检查 decrypt 解密私钥为空, 请设置 无此解密算法 解密私钥非法,请检查 密文长度非法 密文数据已损坏 
cipherData 解密公钥为空, 请设置 解密公钥非法,请检查 byteArrayToString
 H! V" (C)Ljava/lang/StringBuilder; data stringBuilder i I 
SourceFile RSAEncrypt.java !                	   �      b�Y0UY1UY2UY3UY4UY5UY6UY7UY8UY	9UY
aUYbUYcUYdUYeUYfU� 
�           ! + " ^ ! a "           	   /     *� �                        	    	       �L� L� M,� + � "Y� $� %+� )M,� -� 3N,� 5� 9:� ; � ?:-� E � ?:� FY� HY*� J� PR� T� X� \:� FY� HY*� J� P]� T� X� \:� _Y� a:	� _Y� a:
	� d
� d	� g	� j� m
� g
� j� m� 
:� n�      4 � � o     f    )  +  ,  .  1  3 # 5 + 7 4 : @ < K > g ? � @ � A � B � C � D � E � F � G � H � I � J � K � M    �    � q r    � s t    u v  # � w x  + � y z  4 � { |  @ � } r  K z ~ r  g ^  �  � B � �  � 7 � � 	 � , � � 
 �  u �  �   - �   K   � �  K  . 3 9  o 	 � �  �     o 	  #     ]� �Y� �Y� HY*� J� PR� T� X� �� �LM� HY� �N� 	-,� TW+� �YM���+� �-� X�L� oY�� ��L� oY�� ��    F G �   F R �     :    Y  Z  Y " [ $ \ , ] / ^ 5 ] > ` B a G b H c R d S e    >    ] � r   " % � �  $ # � r  ,  � �  H 
 u �  S 
 u �  �     � / � K H�   K  �J � 	 � �  �     o 	   �     >*� �L� �M� �Y+� �N,-� �� 9�L� oY�� ��L� oY�� ��L� oY�� ��          ( �    3 �     * 
   t  u  v  w  x  y ( z ) { 3 | 4 }    H    > � r     � �    � �   	 � �   
 u v  ) 
 u �  4 
 u �  �    ] J �J � 	 � �  �     o 	  #     ]� �Y� �Y� HY*� J� P]� T� X� �� �LM� HY� �N� 	-,� TW+� �YM���+� �-� X�L� oY̷ ��L� oYη ��    F G �   F R �     :    �  �  � " � $ � , � / � 5 � > � B � G � H � R � S �    >    ] � r   " % � �  $ # � r  ,  � �  H 
 u �  S 
 u �  �     � / � K H�   K  �J � 	 � �  �     o 	   �     >*� �L� �Y+� �M� �N-,� �� 3�L� oY�� ��L� oYٷ ��L� oY۷ ��          ( �    3 �     * 
   �  �  �  �  �  � ( � ) � 3 � 4 �    H    > � r     � �   