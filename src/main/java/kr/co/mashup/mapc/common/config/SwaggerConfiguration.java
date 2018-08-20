package kr.co.mashup.mapc.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.common.collect.Lists;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * API document를 위한 Swagger 라이브러리 설정
 * <p>
 * Created by ethan.kim on 2018. 7. 1..
 */
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("kr.co.mashup.mapc")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.any())  // 현재 RequestMapping으로 할당된 모든 url 리스트 추출
                .paths(PathSelectors.ant("/**"))  // '/'로 시작하는 것만 문서화
                .build()
                .useDefaultResponseMessages(false)
                .globalResponseMessage(RequestMethod.POST,
                        Lists.newArrayList(internalServerError()))
                .globalResponseMessage(RequestMethod.GET,
                        Lists.newArrayList(internalServerError()))
                .globalResponseMessage(RequestMethod.PUT,
                        Lists.newArrayList(internalServerError()))
                .globalResponseMessage(RequestMethod.DELETE,
                        Lists.newArrayList(internalServerError()));
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("MapC")
                .description("Mash-Up 5기(2018-1) Team Project")
                .termsOfServiceUrl("https://github.com/Mash-Up-MapC")
                .contact(new Contact("opklnm102", "https://github.com/opklnm102", "opklnm102@gmail.com"))
                .license("Apache License Version 2.0")
                .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
                .version("1.0")
                .build();
    }

    private ResponseMessage internalServerError() {
        return new ResponseMessageBuilder()
                .code(500)
                .message("Internal Server Error")
                .responseModel(new ModelRef("Error"))
                .build();
    }
}

