package client;

import dto.CourierCreateRequest;
import dto.CourierDeleteRequest;
import dto.CourierLoginRequest;
import io.restassured.response.Response;
import io.qameta.allure.Step; // Добавить импорт аннотации @Step

public class CourierClient extends RestClient {

    @Step("Создание курьера")
    public Response createCourier(CourierCreateRequest courierCreateRequest) {
        return getDefaultRequestSpecification()
                .body(courierCreateRequest)
                .when()
                .post("/courier");
    }

    @Step("Логин курьера")
    public Response loginCourier(CourierLoginRequest courierLoginRequest) {
        return getDefaultRequestSpecification()
                .body(courierLoginRequest)
                .when()
                .post("/courier/login");
    }

    @Step("Удаление курьера")
    public Response deleteCourier(CourierDeleteRequest courierDeleteRequest) {
        return getDefaultRequestSpecification()
                .body(courierDeleteRequest)
                .when()
                .delete("/courier/:id");
    }
}
