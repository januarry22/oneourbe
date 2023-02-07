package com.api.oneourbe.api.controller.user;

import com.api.oneourbe.api.util.BaseOfApiControllerTest;
import net.minidev.json.JSONObject;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.restdocs.payload.JsonFieldType;
import org.springframework.restdocs.snippet.Snippet;
import org.springframework.transaction.annotation.Transactional;

import static com.epages.restdocs.apispec.RestAssuredRestDocumentationWrapper.document;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;

public class TestUserManageRestController extends BaseOfApiControllerTest {

    private static final Snippet REQUEST_FIELDS = requestFields(
            fieldWithPath("email").type(JsonFieldType.STRING).description("유저_ID"),
            fieldWithPath("name").type(JsonFieldType.STRING).description("유저_이름"),
            fieldWithPath("user_role").type(JsonFieldType.STRING).description("유저_패스워드")
    );

    private static final Snippet RESPONSE_FIELDS = responseFields(
            fieldWithPath("success").type(JsonFieldType.BOOLEAN).description("statusCode").optional(),
            fieldWithPath("alert").type(JsonFieldType.BOOLEAN).description("ALERT").optional(),
            fieldWithPath("errCode").type(JsonFieldType.OBJECT).description("ERROR_CODE").optional(),
            fieldWithPath("errMsg").type(JsonFieldType.OBJECT).description("ERROR_MESSAGE").optional(),
            fieldWithPath("sessionId").type(JsonFieldType.STRING).description("sessionId").ignored(),
            fieldWithPath("timestamp").type(JsonFieldType.STRING).description("timestamp").ignored(),
            fieldWithPath("data").type(JsonFieldType.OBJECT).description("유저 가입 데이터"),
            fieldWithPath("data.member_seq").type(JsonFieldType.NUMBER).description("유저_SEQ").optional(),
            fieldWithPath("data.email").type(JsonFieldType.STRING).description("유저_ID"),
            fieldWithPath("data.name").type(JsonFieldType.STRING).description("유저_이름"),
            fieldWithPath("data.user_role").type(JsonFieldType.STRING).description("유저_패스워드").optional()
    );

    @Test
    @Transactional
    void get_api_user_join() throws Exception {
        String email = "test_06";
        String name = "shinjiwon";
        String user_role = "me";

        JSONObject requestBody = new JSONObject();
        requestBody.put("email", email);
        requestBody.put("name", name);
        requestBody.put("user_role", user_role);

                given(spec)
                    .filter(document(DEFAULT_RESTDOC_PATH, REQUEST_FIELDS, RESPONSE_FIELDS))
                    .accept(MediaType.APPLICATION_JSON_VALUE)
                    .header("Content-type", "application/json")
                    .body(requestBody)
                    .log().all()

                .when()
                    .post("/api/v1/user/join")

                .then()
                        .statusCode(HttpStatus.OK.value())
                        .body("success", Matchers.equalTo(true))
                        .body("data.email", Matchers.equalTo(email))
                        .body("data.name", Matchers.equalTo(name));
    }

}
