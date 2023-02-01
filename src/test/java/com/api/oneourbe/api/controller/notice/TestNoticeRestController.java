package com.api.oneourbe.api.controller.notice;

import com.api.oneourbe.api.util.BaseOfApiControllerTest;
import net.minidev.json.JSONObject;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.restdocs.payload.JsonFieldType;
import org.springframework.restdocs.snippet.Snippet;

import static com.epages.restdocs.apispec.RestAssuredRestDocumentationWrapper.document;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;

public class TestNoticeRestController extends BaseOfApiControllerTest {

    private static final Snippet REQUEST_FIELDS = requestFields(
            fieldWithPath("type").type(JsonFieldType.STRING).description("공지사항_타입")
    );

    private static final Snippet RESPONSE_FIELDS = responseFields(
            fieldWithPath("success").type(JsonFieldType.BOOLEAN).description("statusCode").optional(),
            fieldWithPath("alert").type(JsonFieldType.BOOLEAN).description("ALERT").optional(),
            fieldWithPath("errCode").type(JsonFieldType.OBJECT).description("ERROR_CODE").optional(),
            fieldWithPath("errMsg").type(JsonFieldType.OBJECT).description("ERROR_MESSAGE").optional(),
            fieldWithPath("sessionId").type(JsonFieldType.STRING).description("sessionId").ignored(),
            fieldWithPath("timestamp").type(JsonFieldType.STRING).description("timestamp").ignored(),
            fieldWithPath("data").type(JsonFieldType.ARRAY).description("공지사항_List"),
            fieldWithPath("data[].cp_noti_seq").type(JsonFieldType.NUMBER).description("공지사항_SEQ"),
            fieldWithPath("data[].type").type(JsonFieldType.STRING).description("공지사항_종류"),
            fieldWithPath("data[].title").type(JsonFieldType.STRING).description("공지사항_제목"),
            fieldWithPath("data[].content").type(JsonFieldType.STRING).description("공지사항_내용"),
            fieldWithPath("data[].view_cnt").type(JsonFieldType.NUMBER).description("공지사항_조회수")

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
