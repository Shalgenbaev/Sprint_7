package client;

import dto.OrderCreateRequest;
import io.restassured.response.Response;
import io.qameta.allure.Step; // Импортируем аннотацию @Step

public class OrderClient extends RestClient {

    @Step("Создание заказа")
    public Response createOrder(OrderCreateRequest orderCreateRequest) {
        return getDefaultRequestSpecification()
                .body(orderCreateRequest)
                .when()
                .post("/orders");
    }

    @Step("Удаление заказа с трек-идентификатором: {trackId}")
    public Response deleteOrder(int trackId) {
        return getDefaultRequestSpecification()
                .when()
                .delete("/orders/" + trackId); // Путь с ID заказа
    }
}
