## JSP Project


### Participants

πββοΈβοΈκΉλ―Όκ·
πββοΈβοΈμμλ¦°
πββοΈβοΈμ΄μ°¬νΈ
πββοΈβοΈμ€μμ€
πββοΈβοΈμ‘°μλΉ


### Tools

tomcat server -> 8.5

Jdk -> 11 ver.



#### π  Server Page μμ μ¬ν­ !! ν­μ νμΈνκΈ°
``` xml
<!-- MentoringDB : DBCP2-->
<Resource
    name = "jdbc/mentoringdb"
    auth = "Container"
    type = "javax.sql.DataSource"
    maxTotal = "8"
    maxIdle = "30"
    maxWaitMillis = "-1"
    username = "root"
    password = "qwer1234"
    driverClassName = "com.mysql.cj.jdbc.Driver"
    url = "jdbc:mysql://127.0.0.1/mentoringDB?serverTimezone=Asia/Seoul&amp;characterEncoding=utf8&amp;useSSL=false"
>

</Resource>
```
