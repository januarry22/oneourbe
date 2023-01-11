package com.api.oneourbe.api.controller.notice;

import com.api.oneourbe.api.domain.notice.NoticeDAO;
import com.api.oneourbe.api.service.notice.NoticeService;
import com.api.oneourbe.api.util.BaseOfApiControllerTest;
import com.api.oneourbe.util.ApiResponse;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.restdocs.payload.JsonFieldType;
import org.springframework.restdocs.snippet.Snippet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.epages.restdocs.apispec.RestAssuredRestDocumentationWrapper.document;
import static io.restassured.RestAssured.filters;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;

public class TestNoticeRestController extends BaseOfApiControllerTest {

    @Autowired
    NoticeService noticeService;

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
            fieldWithPath("success").type(JsonFieldType.BOOLEAN).description("공지사항_List").optional(),
            fieldWithPath("alert").type(JsonFieldType.BOOLEAN).description("공지사항_List").optional(),
            fieldWithPath("errCode").type(JsonFieldType.OBJECT).description("공지사항_List").optional(),
            fieldWithPath("errMsg").type(JsonFieldType.OBJECT).description("공지사항_List").optional(),
            fieldWithPath("sessionId").type(JsonFieldType.STRING).description("공지사항_List").optional(),
            fieldWithPath("timestamp").type(JsonFieldType.STRING).description("공지사항_List").optional(),
            fieldWithPath("data[]").type(JsonFieldType.ARRAY).description("공지사항_List"),
            fieldWithPath("data[].cp_noti_seq").type(JsonFieldType.NUMBER).description("공지사항_List"),
            fieldWithPath("data[].type").type(JsonFieldType.STRING).description("공지사항_List"),
            fieldWithPath("data[].title").type(JsonFieldType.STRING).description("공지사항_List"),
            fieldWithPath("data[].content").type(JsonFieldType.STRING).description("공지사항_List"),
            fieldWithPath("data[].view_cnt").type(JsonFieldType.NUMBER).description("공지사항_List")

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
                        .body("success", Matchers.equalTo(true))
                        .body("alert", Matchers.equalTo(true))
                        .body("errCode", Matchers.equalTo(null))
                        .body("errMsg", Matchers.equalTo(null))
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
