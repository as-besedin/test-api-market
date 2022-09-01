package specs;

import config.ProjectConfig;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.aeonbits.owner.ConfigFactory;

public class Specs {

    public static final ProjectConfig cfg = ConfigFactory.create(ProjectConfig.class);
    public static final String BASE_URI = cfg.baseUrl() + "api";

    public static RequestSpecification getRequestSpec() {
        return new RequestSpecBuilder()
                .setBaseUri(BASE_URI)
                .setContentType(ContentType.JSON)
                .log(LogDetail.ALL)
                .build();
    }

    public static ResponseSpecification getResponseSpec(int httpStatus) {
        return new ResponseSpecBuilder()
                .expectStatusCode(httpStatus)
                .log(LogDetail.ALL)
                .build();
    }
}
