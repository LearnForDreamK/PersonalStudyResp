package club.huashuikun.springboot.demo01;

import club.huashuikun.springboot.demo01.web.HelloController;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@SpringBootTest
class Demo01ApplicationTests {

    @Test
    void contextLoads() {
    }


    private MockMvc mvc;

/*    @Before
    public void setUp() throws Exception{
        mvc= MockMvcBuilders.standaloneSetup(new HelloController()).build();
    }

    public void getHello() throws Exception{
        mvc.perform(MockMvcRequestBuilders.get("/hello").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("Hello World")));
    }*/
}
