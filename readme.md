# 使用说明

一个轻量级的 Spring Boot Starter，用于在应用启动时显示自定义的 ASCII 艺术字横幅。

## ✨ 特性

- 🎨 在 Spring Boot 应用启动时显示精美的 ASCII 艺术字
- ⚙️ 支持通过注解或配置文件自定义内容
- 🖼️ 自动添加边框装饰
- 🔧 简单易用，零配置上手
- 🎯 与 Spring Boot 无缝集成

## 📦 安装

- 导入maven坐标

```maven
<dependency>
            <groupId>com.stlsstl</groupId>
            <artifactId>asciicanvas</artifactId>
            <version>1.0.2</version>
        </dependency>
```

- 在启动类上加上@ascii注解，参数为content = "自定义内容"

```java
@SpringBootApplication
@Ascii(content = "hello world")
public class SpringbootTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootTestApplication.class, args);
    }

}
```

- 效果如下（示例）：

```
  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/

 :: Spring Boot ::                (v4.0.1)

2025-12-22T23:00:54.579+08:00  INFO 14422 --- [springbootTest] [           main] c.s.s.SpringbootTestApplication          : Starting SpringbootTestApplication using Java 17.0.15 with PID 14422 (/Volumes/newdisk1/java_projects/springbootTest/target/classes started by shr1nk in /Volumes/newdisk1/java_projects/springbootTest)
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


