http/Consts UTF_8 Ljava/nio/charset/Charset;
 n java/nio/charset/Charset
 � 	 %(Ljava/util/List;Ljava/lang/String;)V executing downfile request： downfile respose status :  flag } getFirstHeader ,(Ljava/lang/String;)Lorg/apache/http/Header; 00000002 org/apache/http/Header ( getValue
 � 7 equals 文件不存在
 �!" F 
getContent
 � 
 �%& + 
setExtName
 �()* setFileDownInputStream (Ljava/io/InputStream;)V
 �,- + setSavePath
 �/0 + setUuidFileName2 文件下载成功4 0000006 文件下载失败： params entity 4Lorg/apache/http/client/entity/UrlEncodedFormEntity; 
flagHeader Lorg/apache/http/Header; fileInputStream Ljava/io/InputStream; $Lcom/hansy/base/file/model/FileInfo; 1Ljava/util/List<Lorg/apache/http/NameValuePair;>;A org/apache/http/HttpEntity main ([Ljava/lang/String;)V 
ExceptionsF java/io/FileNotFoundExceptionH $java/io/UnsupportedEncodingExceptionJ 9http://127.0.0.1:8099/fileServer/servlet/AccessFileUploadL asdfasdfadsf00000adfadfad11111N D:/test/P .jpgR 	测试图T java/io/FileInputStreamV java/io/FileX d:/
U *
S[ \ (Ljava/io/File;)V
 $^ _ r(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/io/InputStream;)V
 a  	ced java/lang/Systemfg out Ljava/io/PrintStream;
ikj java/io/PrintStreaml u println args [Ljava/lang/String; 
fileUpAddr uuidFileName savePath extName originalFileName tBody r 
SourceFile FileUpDownHelper.java !                	   )      	� 
� �           ,           	   /     *� �           *             	    	  n    	L� M� !Y*� #� )N:� ,Y� .:*� /� 2 W*� 8� 2 W*� ;� 2 W*� >� 2 W� AY*� C� G� M:� P:-V� X-� \� � `Yb� d-� e� i� m� p ,-� v:� | :� � `Y�� d� i� m� p � �  Ƞ >� � :		� �� �Y	� �:

�� �:�� �� �L+� �*� >� �� ѻ �Y��� �L� �:� � `Y�� d� �� �� m� � � �� �Y� `Y�� d� �� �� m�� �L� 
� � ,� �,� Ƨ �:� � `YǷ d� ɶ �� m� � � ̧ |:� 
� � ,� -,� Ƨ &:� � `YǷ d� ɶ �� m� � � ��� 
� � ,� -,� Ƨ &:� � `YǷ d� ɶ �� m� � � �+�  N �Qeh � NQ�  ��� ���� �     � 6   2  3  4  5  8  9 * : 6 ; B < N ? ^ @ e A m B s C � D � E � F � G � H � I � J � K � L � M � O � P R S- T2 UQ XV Y] Za [e \j ]� ^� V� X� Y� Z� [� \� ]� ^� `� X� Y� Z� [� \� ] ^ a    �   	 � �    � �   � �  � � �  � � �  � � �  ^ � � �  e � � �  � n � �  � / � � 	 �  � � 
 �  � �  @ � � j ! � � � ! � � � ! � �  �     � � �  �   � � � 	 $ � w ! } 3 A � �  �   $ � w ! } 3  �� MJ �e ��   $ � w ! } 3       �  J �"�   $ � w ! } 3  J �" 	 �   	  ,    tL� M� !Y*� � )N:� ,Y� .:� `Y*� /� � d*� ;� �� m� 2 W*� 8� 2 W� P:� ,Y� .:� �Y�� �� 2 W� �Y� ���:-� \� � `Y
� d-� e� i� m� p ,-� v:� | :	� � `Y� d	� i� m� p 	� �  Ƞ �� � :
� :� %� �� � �Y� �L�(
�#� �Y
� �:� :� �Y�#:*� ;�$�'*� 8�+*� /�.� �Y13� �L� ӻ �Y��� �L� �:� � `Y5� d� �� �� m� � � �� �Y� `Y5� d� �� �� m�� �L� 
� � ,� �,� Ƨ �:� � `YǷ d� ɶ �� m� � � ̧ |:� 
� � ,� -,� Ƨ &:� � `YǷ d� ɶ �� m� � � ��� 
� � ,� -,� Ƨ &:� � `YǷ d� ɶ �� m� � � �+�  Jux ���� � J��  � �8LO �     � =   i  j  k  l  o  p > r J u Q v Z w m x ~ y � z � { � | � } � ~ �  � � � � � � � �# �* �3 �< �C �L �U �e �h �u 