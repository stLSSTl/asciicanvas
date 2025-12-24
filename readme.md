# 使用说明

一个轻量级的 Spring Boot Starter，用于在应用启动时显示自定义的 ASCII 艺术字横幅。

## ✨ 特性

- 🎨 在 Spring Boot 应用启动时显示精美的 ASCII 艺术字
- ⚙️ 支持通过注解或配置文件自定义内容
- 🖼️ 自动添加边框装饰
- 🔧 简单易用，零配置上手
- 🎯 与 Spring Boot 无缝集成



## 🌹环境配置

| 工具        | 版本号  |
| ----------- | ------- |
| Java        | 17      |
| Maven       | 3.9.9   |
| Lombok      | 1.18.36 |
| Spring Boot | 3.2.0   |



## 📦 安装

```shell
# 1. 克隆项目到本地
git clone https://github.com/stLSSTl/asciicanvas.git

# 2. 安装到本地 Maven 仓库
cd asciicanvas
mvn install

# 3. 在项目中添加依赖
```

```xml
<dependency>
    <groupId>com.stlsstl</groupId>
    <artifactId>asciicanvas</artifactId>
    <version>1.0.5</version>
</dependency>
```



## 🔧使用方法

在启动类上加上@ascii注解，参数如下：

- content = "自定义内容"
- font = “字体样式” ，1.0.5版本支持**standard、doh、larry3d** 三种样式
- border = "边框样式" 一共有7种
  - BorderEnums.THIN --------->细边框
  - BorderEnums.DOUBLE--------->加粗边框
  - BorderEnums.BLOCK--------->实行块
  - BorderEnums.ROUNDED--------->圆角边框
  - BorderEnums.BOLD--------->粗线边框
  - BorderEnums.STAR--------->星星边框
  - BorderEnums.UNENABLED--------->不启用边框

```java
@SpringBootApplication
@Ascii(content = "hello world",font = "doh",border = BorderEnums.THIN)// 在此设置您的自定义
public class SpringbootTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootTestApplication.class, args);
    }

}
```



## 🍎效果展示

启动应用后，您将在控制台中看到类似以下效果：

```
  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/

 :: Spring Boot ::                (v4.0.1)

2025-12-22T23:00:54.579+08:00  INFO 14422 --- [springbootTest] [           main] c.s.s.SpringbootTestApplication          : Starting SpringbootTestApplication using Java 17.0.15 with PID 14422 
2025-12-22T23:00:54.581+08:00  INFO 14422 --- [springbootTest] [           main] c.s.s.SpringbootTestApplication          : No active profile set, falling back to 1 default profile: "default"
2025-12-22T23:00:54.712+08:00  INFO 14422 --- [springbootTest] [           main] c.s.s.SpringbootTestApplication          : Started SpringbootTestApplication in 0.258 seconds (process running for 0.413)
2025-12-22T23:00:54.715+08:00  INFO 14422 --- [springbootTest] [           main] c.s.a.autoconfig.AsciiAutoConfig         : 
╔═════════════════════════════════════════════════════════════════════════╗
║   _              _   _                                       _       _  ║
║  | |__     ___  | | | |   ___     __      __   ___    _ __  | |   __| | ║
║  | '_ \   / _ \ | | | |  / _ \    \ \ /\ / /  / _ \  | '__| | |  / _` | ║
║  | | | | |  __/ | | | | | (_) |    \ V  V /  | (_) | | |    | | | (_| | ║
║  |_| |_|  \___| |_| |_|  \___/      \_/\_/    \___/  |_|    |_|  \__,_| ║
║                                                                         ║
╚═════════════════════════════════════════════════════════════════════════╝

2025-12-22T23:00:54.715+08:00  INFO 14422 --- [springbootTest] [           main] c.s.a.autoconfig.AsciiAutoConfig         : Spring Boot Application Started Successfully!
2025-12-22T23:00:54.715+08:00  INFO 14422 --- [springbootTest] [           main] c.s.a.autoconfig.AsciiAutoConfig         : ==============================================


```



## 📔版本日志

| 版本    | 说明        |
|-------|-----------|
| 1.0.3 | 以标准模式输出ascii艺术字 |
| 1.0.4 | 新增两种艺术字字体，larry3d 和 doh |
| 1.0.5 | 新增七种边框样式  |



## 📝备注

本项目基于**JFiglet：Java版FIGlet艺术字生成库**实现。

本项目所涉及的字体文件来源于：**https://www.figlet.org/**



## 📮邮箱

如有问题或建议，请联系：

```
shr1nk@foxmail.com
```
