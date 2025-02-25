package client;

import dto.OrderListRequest;
import io.restassured.response.Response;
import io.qameta.allure.Step; // Импорт аннотации @Step

public class GetOrdersClient extends RestClient {

    @Step("Получение списка заказов")
    public Response getOrderList(OrderListRequest orderListRequest) {
        return getDefaultRequestSpecification()
                .body(orderListRequest)
                .when()
                .get("/orders");
    }

    @Step("Получение заказа по трек-идентификатору: {track}")
    public Response getOrderByTrackId(int track) {
        return getDefaultRequestSpecification()
                .queryParam("t", track)
                .when()
                .get("/orders/track");
    }
}
