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

tlias-pojo和tlias-web-management两者打包方式为jar（默认方式），tlias-parent打包方式为pom，
即在生命坐标时，进行如下制定
```angular2html
<groupId>com.iebya</groupId>
<artifactId>tlias-parent</artifactId>
<version>1.0-SNAPSHOT</version>
<packaging>pom</packaging> <!-- 这里这里 -->
```

`<modules>` 标签用于maven聚合。这样在操作parent的时候，同时操作了其下的其他module，
这里是pojo和web-management,尤其是在install时，可以有效处理依赖的顺序问题。

`<dependencyManagement>`标签用于版本管理，在父pom文件中指定依赖的版本，虽然并不会给父pom文件引入依赖，
但是子pom文件在引入依赖时，只需要指定组织id和组件id，作用是方便多个maven模块使用同一版本的依赖。

`<properties>`下统一声明 `*.version` ，在引入依赖的时候使用`${*.version}`，可以方便修改版本。
