# TestRepository3
## 环境配置

该项目要求使用自配Maven,在官网Maven[Welcome to Apache Maven – Maven](https://maven.apache.org/)中选择Downloads Maven的3.9.9版本,安装好之后需要配置环境变量，请在系统变量中新增，变量名MAVEN_HOME,值则为安装maven的路径，到apache-maven-3.9.9即可，接着需要配置Maven,在apache-maven-3.9.9目录下--conf--settings.xml，请按照文档中Maven配置中进行配置。

然后在idea中克隆该项目，在项目中选择文件--设置--构建，执行，部署--构建工具--Maven下配置Maven主路径和用户设置文件。![image-20250601162553936](./README.assets/image-20250601162553936.png)

接着需要同步你的所有Maven项目，然后就可以运行程序了。

## 项目说明

本项目完成了绝大多数的API，不过是仅关注于api的后端实现，没有前端控制，需要在src下的APP中启动，然后利用Apifox进行接口测试，绝大部分功能可以实现。

配置好环境之后，克隆到idea中可以直接启动运行测试APi，注意8080端口不要被占用，默认8080端口。

项目中druid.properties是缓存池的配置，application.properties是spring boot启动的配置，因为时间紧迫，在此仅说出未完成的部分。

1. 登录后的权限控制
2. 登出功能
3. 分配教师权限
4. 处理权限申请
5. 处理课程状态变更
6. 数据库对象视图，存储对象触发器

其余功能均已实现。

## 数据库设计说明

数据库按照建表以后，各自独立存储，在学生属性中含有课程，其余则用主键列联系(如学生专业--no--01--专业)

## 使用说明

源码中controller为控制层，api注解地方，分为登录，管理员，学生，教师的api

dao层中定义了5个接口分别为实现学生，教师，专业，院系，课程api接口提供

然后BaseDao则是将JDBC封装成一个类供impl层下的各个数据库管理处使用增删查改。

model层是各个实体类

util是工具层JDBC缓冲池，统一响应和统一异常还有密码加密功能

resources下则是俩个配置文件（上文已提到，不在描述）

pom.xml为依赖

直接启动类APP即可启动程序

## 测试说明

启动程序，运用apifox进行测试即可，在文件中测试文档有部分测试（最开始测试的时候忘记写了，所以只有一点点）
