package com.api.oneourbe.api.controller.banner;

import com.api.oneourbe.api.domain.notice.NoticeDAO;
import com.api.oneourbe.api.util.BaseOfApiControllerTest;
import com.api.oneourbe.util.ApiResponse;
import net.minidev.json.JSONObject;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.restdocs.payload.JsonFieldType;
import org.springframework.restdocs.snippet.Snippet;

import static com.epages.restdocs.apispec.RestAssuredRestDocumentationWrapper.document;
import static io.restassured.RestAssured.given;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;

public class TestBannerRestController extends BaseOfApiControllerTest {

    private static final Snippet REQUEST_FIELDS = requestFields(
            fieldWithPath("success").type(JsonFieldType.BOOLEAN).description("공지사항_List").optional(),
            fieldWithPath("alert").type(JsonFieldType.BOOLEAN).description("공지사항_List").optional(),
            fieldWithPath("errCode").type(JsonFieldType.OBJECT).description("공지사항_List").optional(),
            fieldWithPath("errMsg").type(JsonFieldType.OBJECT).description("공지사항_List").optional(),
            fieldWithPath("sessionId").type(JsonFieldType.STRING).description("공지사항_List").optional(),
            fieldWithPath("timestamp").type(JsonFieldType.STRING).description("공지사항_List").optional(),
            fieldWithPath("cp_noti_seq").type(JsonFieldType.NUMBER).description("공지사항_타입").optional(),
            fieldWithPath("type").type(JsonFieldType.STRING).description("공지사항_타입").optional(),
            fieldWithPath("title").type(JsonFieldType.STRING).description("공지사항_타입").optional(),
            fieldWithPath("content").type(JsonFieldType.STRING).description("공지사항_타입").optional(),
            fieldWithPath("view_cnt").type(JsonFieldType.NUMBER).description("공지사항_타입").optional()
    );

    private static final Snippet RESPONSE_FIELDS = responseFields(
            fieldWithPath("success").type(JsonFieldType.BOOLEAN).description("공지사항_List").ignored(),
            fieldWithPath("alert").type(JsonFieldType.BOOLEAN).description("공지사항_List").ignored(),
            fieldWithPath("errCode").type(JsonFieldType.OBJECT).description("공지사항_List").ignored(),
            fieldWithPath("errMsg").type(JsonFieldType.OBJECT).description("공지사항_List").ignored(),
            fieldWithPath("sessionId").type(JsonFieldType.STRING).description("공지사항_List").ignored(),
            fieldWithPath("timestamp").type(JsonFieldType.STRING).description("공지사항_List").ignored(),
            fieldWithPath("data").type(JsonFieldType.ARRAY).description("공지사항_List"),
            fieldWithPath("data[].cp_noti_seq").type(JsonFieldType.NUMBER).description("공지사항_List"),
            fieldWithPath("data[].type").type(JsonFieldType.STRING).description("공지사항_List"),
            fieldWithPath("data[].title").type(JsonFieldType.STRING).description("공지사항_List"),
            fieldWithPath("data[].content").type(JsonFieldType.STRING).description("공지사항_List"),
            fieldWithPath("data[].view_cnt").type(JsonFieldType.NUMBER).description("공지사항_List")

    );

    @Test
    void get_api_noti_true() {
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

                .then()
                    .statusCode(HttpStatus.OK.value())
                    .body("success", Matchers.equalTo(type))
                        .body("alert", Matchers.equalTo(type))
                        .body("errCode", Matchers.equalTo(type))
                        .body("errMsg", Matchers.equalTo(type))
                        .body("sessionId", Matchers.equalTo(type))
                        .body("timestamp", Matchers.equalTo(type))
                        .body("data", Matchers.equalTo(type))
                        .body("data.[].cp_noti_seq", Matchers.equalTo(type))
                        .body("data.[].type", Matchers.equalTo(type))
                        .body("data.[].title", Matchers.equalTo(type))
                        .body("data.[].content", Matchers.equalTo(type))
                        .body("data.[].view_cnt", Matchers.equalTo(type));
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
