# igenerator

## 简介
该项目用于生成MySQL数据库表对应的POJO类，以及DAO、Mapper文件。其中POJO类包含类注释、字段注释，这些注释取自表对应的注释，因而表内是需要有注释哦。

## 使用方法
### 修改配置文件
**根据自身操作系统，修改配置文件resources/generatorMacOSConfig.xml 或 resources/generatorWindowsConfig.xml**

- 修改注释author
```xml
<!-- 自定义注释生成器 -->
<commentGenerator type="igenerator.comment.MySQLCommentGenerator">
    <property name="author" value="itoak"/>
    <property name="dateFormat" value="yyyy/MM/dd"/>
</commentGenerator>
```

- 修改数据库配置
```xml
 <!-- 数据库链接URL、用户名、密码；需要自定义connectionURL、userId、password -->
<jdbcConnection driverClass="com.mysql.cj.jdbc.Driver"
                connectionURL="jdbc:mysql://127.0.0.1:3306/my_database"
                userId="userId"
                password="password">
    <property name="useInformationSchema" value="true"/>
</jdbcConnection>
```

- 修改POJO类包路径
```xml
<!-- 生成模型的包名和位置；需要自定义targetPackage -->
<javaModelGenerator targetPackage="cn.itoak.po" targetProject="src/main/java">
    <property name="enableSubPackages" value="true"/>
    <property name="trimStrings" value="true"/>
</javaModelGenerator>
```

- 修改Mapper文件包路径
```xml
<!-- 生成的映射文件包名和位置；需要自定义targetPackage -->
<sqlMapGenerator targetPackage="cn.itoak.sqlmap" targetProject="src/main/java">
    <property name="enableSubPackages" value="true"/>
</sqlMapGenerator>
```

- 修改DAO文件包路径
```xml
<!-- 生成DAO的包名和位置；需要自定义targetPackage -->
<javaClientGenerator type="XMLMAPPER" targetPackage="cn.itoak.dao" targetProject="src/main/java">
    <property name="enableSubPackages" value="true"/>
</javaClientGenerator>
```

- 填写需要生成的表信息
```xml
<table schema="dispatch" tableName="lb_dual_call" domainObjectName="DualCallPO" mapperName="DualCallDAO">
    <generatedKey column="id" sqlStatement="MySql" identity="true"/>
    <!-- 将tinyint转换为Integer类型 -->
    <columnOverride column="asr_flag" javaType="java.lang.Integer" jdbcType="TINYINT"/>
</table>
<table schema="dispatch" tableName="lb_data" domainObjectName="DataPO" mapperName="DataDAO">
    <generatedKey column="id" sqlStatement="MySql" identity="true"/>
</table>
```
- 运行程序

运行igenerator.IGenerator.main()。系统会自动识别并读取配置文件

- 结果

如果程序运行成功，生成的代码在包igenerator同级目录下。

1.代码结构图：

![代码结构图](https://raw.githubusercontent.com/OakWang/igenerator/master/src/main/resources/static/result.png)

2.POJO类效果图:

![POJO类效果图](https://raw.githubusercontent.com/OakWang/igenerator/master/src/main/resources/static/pojo.png)