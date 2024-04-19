tlias-parent为新建项目，其父maven项目为，relativePath需要指定父maven项目的xml文件。
这里的意思是从本地仓库寻找，因为spring-boot-starter-parent并不是自己创建。
```angular2html
<parent>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-parent</artifactId>
    <version>3.2.5</version>
    <relativePath/> <!-- lookup parent from repository -->
</parent>
```

tlias-pojo和tlias-web-management为新建模块，其中tlias-web-management生成器为Spring boot，
两者的父项目为：
```angular2html
<parent> 
    <groupId>com.iebya</groupId>
    <artifactId>tlias-parent</artifactId>
    <version>1.0-SNAPSHOT</version>
    <relativePath>../pom.xml</relativePath>
</parent>
```
这里的relativePath可以不指定，不指定即默认为前一级目录下的pom.xml文件。  

tlias-web-management需要在依赖中引用tlias-pojo,两者本质上是平级关系

打包时顺序：先给tlias-parent打包，因为tlias-pojo在创建时就制定了tlias-pojo的父包，所以只给
tlias-parent打包可以同时操作tlias-pojo。打包后install，安装到本地，不然在打包tlias-web-management
模块时会显示找不到tlias-parent和tlias-pojo依赖。  
tlias-pojo和tlias-web-management两者打包方式为jar（默认方式），tlias-parent打包方式为pom，
即在生命坐标时，进行如下制定
```angular2html
<groupId>com.iebya</groupId>
<artifactId>tlias-parent</artifactId>
<version>1.0-SNAPSHOT</version>
<packaging>pom</packaging> <!-- 这里这里 -->
```