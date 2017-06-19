# MyApplication
技术
- Spring-boot
- Gradle3.5

数据库
- MySql 5.7

前端技术
- Bootstrap 3.3.7    
> Bootstrap    
> 优点: 支持HTML5支持绝大多少的浏览器和设备    
> 缺点: 对IE8以下的浏览器支持不好    

先写个main method吧
利用DTO设置统一的反馈结果

#Spring boot 静态资源    
resources > static > bootstrap 
- 静态资源 static 系统默认放在 classpath:static中,所以在HTML中直接使用 bootstrap/css/* 指定文件

#Spring SL4J    
> sl4j 日志format输出 logger.info("输出参数1[{}],参数2[{}]", "A","B");   console: "输出参数1A,参数2B"    

#配置MySql连接    
> 添加 mysql-connector-java:6.0.6         
> 配置驱动路径的时候要注意 ** com.mysql.jdbc.Driver** 修改为  **com.mysql.cj.jdbc.Driver**     
> 配置URL jdbc:mysql://localhost:**3306/mydb**?useUnicode=true&characterEncoding=UTF-8&**useSSL=false**&**serverTimezone=UTC**    

## JdbcTemplate 使用query传参查询不到数据    
> 直接写完整的sql语句是可以查询到数据,但是改为 object[]{}传参就不可以啦;  **可能是使用了关键字user作为表明,导致的异常,换做其他表是不存在这个问题的**            

## 返回自定义异常 (导出db/20170614.sql)     

> 用户名不存在:UsernameNotFoundException;     
> 密码错误:BadCredentialException;     
> 帐户被锁:LockedException;     
> 帐户未启动:DisabledException;     
> 密码过期:CredentialExpiredException;    


 