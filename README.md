# SpringBoot-HouseMarket 房屋市场系统

## 项目介绍
SpringBoot-HouseMarket是一个基于Spring Boot开发的房屋市场管理系统，提供房屋信息发布、查询、预约看房、收藏等功能，支持管理员、房东和租户三种角色。

## 技术栈

### 后端技术
- **Spring Boot** 3.2.4 - 核心框架
- **Java** 21 - 开发语言
- **Spring Web** - Web服务支持
- **Spring Security + JWT** - 身份认证与授权
- **MyBatis Plus** - ORM框架
- **Spring Data JPA** - 数据访问层
- **MySQL** - 数据库
- **SpringDoc OpenAPI** - API文档生成
- **Spring Cache** - 缓存支持
- **Lombok** - 简化Java开发

### 前端技术
- **HTML/CSS/JavaScript** - 静态页面开发

## 功能模块

1. **用户管理**
   - 用户注册、登录
   - 用户信息管理
   - 角色权限控制（管理员、房东、租户）

2. **房屋管理**
   - 房屋信息发布与编辑
   - 房屋查询与筛选
   - 房屋详情查看

3. **预约管理**
   - 预约看房
   - 预约记录管理

4. **收藏管理**
   - 房屋收藏与取消收藏
   - 收藏列表查看

5. **注册请求管理**
   - 注册请求审核（管理员功能）

## 环境要求

- JDK 21+
- Maven 3.6+
- MySQL 8.0+

## 安装和运行

### 1. 克隆项目
```bash
git clone https://github.com/yourusername/SpringBoot-HouseMarket.git
cd SpringBoot-HouseMarket
```

### 2. 配置数据库

1. 创建MySQL数据库：
   ```sql
   CREATE DATABASE `房源市场` CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
   ```

2. 配置数据库连接：
   - 创建 `application-private.yml` 文件（可选），添加数据库用户名和密码：
     ```yaml
     spring:
       datasource:
         username: your_username
         password: your_password
     ```
   - 或者直接修改 `application.yml` 中的数据库配置
   - 或者设置环境变量 `DB_USERNAME` 和 `DB_PASSWORD`

### 3. 构建和运行

```bash
# 构建项目
mvn clean package

# 运行项目
mvn spring-boot:run
```

## 项目结构

```
├── src/main/java/com/springboot/springboothousemarket/
│   ├── Config/          # 配置类
│   ├── Controller/      # 控制器
│   ├── Entity/          # 实体类
│   ├── Mapper/          # Mapper接口
│   ├── Service/         # 服务层
│   ├── Util/            # 工具类
│   ├── dto/             # 数据传输对象
│   └── SpringBootHouseMarketApplication.java  # 主启动类
├── src/main/resources/
│   ├── mapper/          # MyBatis XML映射文件
│   ├── static/          # 静态资源（HTML、CSS、JS）
│   └── application.yml  # 应用配置文件
└── pom.xml              # Maven依赖配置
```

## API文档

项目集成了SpringDoc OpenAPI，运行项目后可通过以下地址访问API文档：

```
http://localhost:8082/swagger-ui.html
```

## 浏览器访问

项目启动后会自动打开浏览器访问登录页面：

```
http://localhost:8082/login.html
```

### 主要页面
- 登录页面：`/login.html`
- 注册页面：`/register.html`
- 管理员页面：`/admin.html`
- 房东页面：`/landlord.html`
- 租户页面：`/tenant.html`
- 房屋详情页面：`/house-detail.html`

## 端口配置

项目默认使用8082端口，可在 `application.yml` 中修改：

```yaml
server:
  port: 8082
```

## 开发说明

1. 项目使用MyBatis Plus的MapperScan注解，扫描路径为 `com.springboot.springboothousemarket.Mapper`
2. 全局异常处理类 `GlobalExceptionHandler` 统一处理系统异常
3. 跨域配置类 `CorsConfig` 支持跨域请求
4. JWT过滤器 `JwtFilter` 实现Token验证
5. 静态资源存放在 `src/main/resources/static` 目录下

## 许可证

MIT License
