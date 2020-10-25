package club.huashuikun.springboot.demo01;

import club.huashuikun.springboot.demo01.entity.FooProperties;
import club.huashuikun.springboot.demo01.entity.PostInfo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.bind.Bindable;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.context.ApplicationContext;

import java.util.List;

/**
 *
 *
 *
 项目元数据：创建时候输入的Project Metadata部分，也就是Maven项目的基本元素，包括：groupId、artifactId、version、name、description等
 parent：继承spring-boot-starter-parent的依赖管理，控制版本与打包等内容
 dependencies：项目具体依赖，这里包含了spring-boot-starter-web用于实现HTTP接口（该依赖中包含了Spring MVC）；spring-boot-starter-test用于编写单元测试的依赖包。更多功能模块的使用我们将在后面的教程中逐步展开。
 build：构建配置部分。默认使用了spring-boot-maven-plugin，配合spring-boot-starter-parent就可以把Spring Boot应用打包成JAR来直接运行。

 */
@SpringBootApplication
public class Demo01Application {

    public static void main(String[] args) {
        ApplicationContext context=SpringApplication.run(Demo01Application.class, args);

        Binder binder = Binder.get(context.getEnvironment());

        // 绑定简单配置
        FooProperties foo = binder.bind("club.huashuikun", Bindable.of(FooProperties.class)).get();
        System.out.println(foo.getUsername());

        List<PostInfo> infos=binder.bind("club.huashuikun.infos", Bindable.listOf(PostInfo.class)).get();

        for(PostInfo a:infos){
            System.out.println(a.getInfo1());
            System.out.println(a.getInfo2());
            System.out.println(a.getInfo3());
        }

    }

}
