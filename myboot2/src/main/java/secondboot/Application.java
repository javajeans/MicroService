package secondboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 作者： Jonathan
 * 创建时间： 2016/9/20 ${Time}.
 * Application的描述：${DESCRIPTION}
 */
@EnableSwagger2
@SpringBootApplication
public class Application implements EmbeddedServletContainerCustomizer{

    public static void main(String[] args){
        SpringApplication.run(Application.class,args);
    }

    /**
     * EmbeddedServletContainerCustomizer 接口的未实现方法
     * 制定容器的启动端口，之后再浏览器输入localhost:8081/swagger-ui.hmtl即可
     * @param container
     */
    public void customize(ConfigurableEmbeddedServletContainer container){
        container.setPort(8081);
    }
}
