package com.api.oneourbe.api.controller.banner;

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

public class TestBannerRestController extends BaseOfApiControllerTest {

    @Autowired
    NoticeService noticeService;

    private static final Snippet REQUEST_FIELDS = requestFields(

    );

    private static final Snippet RESPONSE_FIELDS = responseFields(
            fieldWithPath("success").type(JsonFieldType.BOOLEAN).description("statusCode").optional(),
            fieldWithPath("alert").type(JsonFieldType.BOOLEAN).description("ALERT").optional(),
            fieldWithPath("errCode").type(JsonFieldType.OBJECT).description("ERROR_CODE").optional(),
            fieldWithPath("errMsg").type(JsonFieldType.OBJECT).description("ERROR_MESSAGE").optional(),
            fieldWithPath("sessionId").type(JsonFieldType.STRING).description("sessionId").ignored(),
            fieldWithPath("timestamp").type(JsonFieldType.STRING).description("timestamp").ignored(),
            fieldWithPath("data").type(JsonFieldType.ARRAY).description("배너_List"),
            fieldWithPath("data[].banner_seq").type(JsonFieldType.NUMBER).description("배너_SEQ"),
            fieldWithPath("data[].link_url").type(JsonFieldType.STRING).description("배너_연결링크"),
            fieldWithPath("data[].img_url").type(JsonFieldType.STRING).description("배너_이미지"),
            fieldWithPath("data[].comment").type(JsonFieldType.STRING).description("배너_설명").optional(),
            fieldWithPath("data[].alt").type(JsonFieldType.STRING).description("배너_ALT").optional()

    );

    @Test
    void get_api_banner_true() throws Exception {
        String type = "CS_NOTI";

        JSONObject requestBody = new JSONObject();
       // requestBody.put("type", type);

                given(spec)
                    .filter(document(DEFAULT_RESTDOC_PATH, REQUEST_FIELDS, RESPONSE_FIELDS)) // API 문서 관련 필터 추가
                    .accept(MediaType.APPLICATION_JSON_VALUE)
                    .header("Content-type", "application/json")
                    .body(requestBody)
                    .log().all()

                .when()
                    .get("/api/v1/banner")

                .then()
                        .statusCode(HttpStatus.OK.value())
                        .body("success", Matchers.equalTo(true))
                        .body("data.banner_seq", hasItem(1))
                        .body("data.link_url", hasItem("https://www.acmicpc.net/problem/1966"))
                        .body("data.img_url", hasItem("bnn7.jpg"))
                        .body("data.comment", hasItem("배너"))
                        .body("data.alt", hasItem("2"));
    }

}
