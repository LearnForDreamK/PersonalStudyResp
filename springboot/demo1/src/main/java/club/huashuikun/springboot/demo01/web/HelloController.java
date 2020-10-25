package club.huashuikun.springboot.demo01.web;

import club.huashuikun.springboot.demo01.entity.FooProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private FooProperties info;

    @RequestMapping("/hello")
    public String index(){



        return "hello spring boot";

    }

    @RequestMapping("/getName")
    public String index2(){



        return info.getUsername();

    }

}
