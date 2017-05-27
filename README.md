# springboot-mysql-demo
## 项目建立步骤
- 提供的代码为临时的【mysql-demo】项目
- 下文将介绍实现思路
### 1. 初始化项目包
- 访问官方网址[https://start.spring.io/](https://start.spring.io/)， 设置 **Dependencies** 为 **【MySQL】【JPA】【Web】** ，其余自定义，然后下载
### 2. 引用项目
- 下载的zip文件，解压后，import到eclipse，IDEA等软件中
### 3. 修改application配置文件(application.yml)
```yml
spring:
  datasource:
    driverClassName: com.mysql.jdbc.Driver
    url: jdbc:mysql://localhost:3306/note_db
    username: user
    password: pwd

  jpa:
    hibernate.ddl-auto: update
    generate-ddl: true
    show-sql: true
```
- 也可用application.properties来设置
### 4. 修改launch文件
```java
package com.user.project.mysqldemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@EnableJpaRepositories(basePackages = "com.user.project.mysqldemo.repository") // 增加jpa默认repository路径
@SpringBootApplication
public class MysqlDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(MysqlDemoApplication.class, args);
    }
}

```
### 5. 编写model|entity|bean
```java
package com.user.project.mysqldemo.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by user on 2017/05/27.
 *
 *  db-sql:
 *    create user 'user'@'%' identified by 'pwd';
 *    show grants for 'user@%';
 *    create database note_db;
 *    grant all on note_db.* to 'user'@'%';
 *    # login mysql by user
 *    use note_db;
 *    create table user (
 *        id int[10] auto_increment primary key not null,
 *        name varchar[50]
 *    );
 */
@Entity
@Table(name = "user")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;
  
    /**
     * constructor
     */
     public User() {
    }

    public User(String name) {
        this.name = name;
    }

    /**
     * getter and setter
     */
}

```

### 6. 编写Repository接口
```java
package com.user.project.mysqldemo.repository;

import com.user.project.mysqldemo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by user on 2017/05/27.
 */
public interface UserRepository  extends JpaRepository<User,Integer>{

}

```

### 7. 编写Controller类
```java
package com.user.project.mysqldemo.controller;

import com.user.project.mysqldemo.model.User;
import com.user.project.mysqldemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 2017/05/27.
 */
@RestController
@RequestMapping(value = "/rest/user")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "save", method = {RequestMethod.POST })
    public Iterable<User> save(@RequestBody final User user){
        userRepository.save(user);
        return userRepository.findAll();
    }

    @RequestMapping("/all")
    public Iterable<User> findAll(){
        return userRepository.findAll();
    } 
}

```

### 8. 注意。
- 针对maven，需要终端运行
```shell
mvn clean install
```
