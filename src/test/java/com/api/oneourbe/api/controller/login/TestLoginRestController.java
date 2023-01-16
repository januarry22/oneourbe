package com.api.oneourbe.api.controller.login;

import com.api.oneourbe.api.service.notice.NoticeService;
import com.api.oneourbe.api.util.BaseOfApiControllerTest;
import net.minidev.json.JSONObject;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.restdocs.payload.JsonFieldType;
import org.springframework.restdocs.snippet.Snippet;

import static com.epages.restdocs.apispec.RestAssuredRestDocumentationWrapper.document;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;

public class TestLoginRestController extends BaseOfApiControllerTest {

    @Autowired
    NoticeService noticeService;

    private static final Snippet REQUEST_FIELDS = requestFields(
            fieldWithPath("email").type(JsonFieldType.STRING).description("login_EMAIl")
    );

    private static final Snippet RESPONSE_FIELDS = responseFields(
            fieldWithPath("success").type(JsonFieldType.BOOLEAN).description("statusCode").optional(),
            fieldWithPath("alert").type(JsonFieldType.BOOLEAN).description("ALERT").optional(),
            fieldWithPath("errCode").type(JsonFieldType.OBJECT).description("ERROR_CODE").optional(),
            fieldWithPath("errMsg").type(JsonFieldType.OBJECT).description("ERROR_MESSAGE").optional(),
            fieldWithPath("sessionId").type(JsonFieldType.STRING).description("sessionId").ignored(),
            fieldWithPath("timestamp").type(JsonFieldType.STRING).description("timestamp").ignored(),
    );

    @Test
    void get_api_noti_true() throws Exception {
        String type = "CS_NOTI";

        JSONObject requestBody = new JSONObject();
        requestBody.put("type", type);

                given(spec)
                    .filter(document(DEFAULT_RESTDOC_PATH, REQUEST_FIELDS, RESPONSE_FIELDS)) // API 문서 관련 필터 추가
                    .accept(MediaType.APPLICATION_JSON_VALUE)
                    .header("Content-type", "application/json")
                    .body(requestBody)
                    .log().all()

                .when()
                    .post("/api/v1/noti")

                .then().assertThat()
                    .statusCode(HttpStatus.OK.value())
                        .body("success", Matchers.equalTo(true)).and()
                        .body("data.cp_noti_seq", hasItem(1))
                        .body("data.type", hasItem("CS_NOTI"))
                        .body("data.title", hasItem("8월의 멘토모집"))
                        .body("data.content", hasItem("8월의 멘토모집"))
                        .body("data.view_cnt", hasItem(0));
    }

    /* TODO : type 데이터를 db에서 검증후 테스트 케이스로 입력되게 수정 필요
    @Test
    void get_api_banner_false() {
        String type = "FALSE_TYPE";

        JSONObject requestBody = new JSONObject();
        requestBody.put("type", type);

        given(spec)
                .filter(document(DEFAULT_RESTDOC_PATH, REQUEST_FIELDS, RESPONSE_FIELDS)) // API 문서 관련 필터 추가
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .header("Content-type", "application/json")
                .body(requestBody)
                .log().all()

                .when()
                .post("/api/v1/noti")

                .then()
                .statusCode(HttpStatus.OK.value())
                .body("type", Matchers.equalTo(type));
    }*/
}
