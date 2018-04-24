项目介绍

mybatis CRUD代码生成工具
/mybatis-generator-3.4.4

sql
创建表语句


1、项目技术架构

spring + springMvc + mybatis + 
kisso（单点登录框架）  
velocity （视图显示）

spring版本：4.0.5
mybatis版本：3.2.0


2、启动准备工作——HOST配置

单点登录
127.0.0.1 sso.jjc.com

公司DEMO
127.0.0.1 jjc.demo.com


3、公用拦截器（根据需求打开关闭）
LanguageFilter（国际化配置）
SSOClientFilter（单点登录使用）


4、启动方式
使用Maven进行启动 设置8099端口
-Dmaven.tomcat.port=8099 tomcat:run

启动后访问：
http://localhost:8099/ssoClient


出现登录页面。 自行进行注册、登陆后、展示项目index。











