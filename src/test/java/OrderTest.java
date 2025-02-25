import client.OrderClient;
import io.qameta.allure.Feature;
import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import step.OrderSteps;

import static org.apache.http.HttpStatus.SC_CREATED;
import static org.hamcrest.Matchers.notNullValue;

@Feature("Создание заказа")
@RunWith(Parameterized.class)
public class OrderTest {
    private OrderSteps orderSteps;
    private String colorStr;
    private Integer track; // Поле для хранения идентификатора заказа

    public OrderTest(String colorStr) {
        this.colorStr = colorStr;
    }

    @Before
    public void setUp() {
        orderSteps = new OrderSteps(new OrderClient());
    }

    @After
    public void tearDown() {
        if (track != null) {
            orderSteps.deleteOrder(track); // Удаление созданного заказа
        }
    }

    @Parameterized.Parameters
    public static Object[][] getColors() {
        return new Object[][]{
                {""},
                {"BLACK"},
                {"GREY"},
                {"BLACK,GREY"}
        };
    }

    @Test
    @DisplayName("Проверка заказа с различным набором цветов")
    public void testCreateOrder() {
        String firstName = RandomStringUtils.random(10);
        String lastName = RandomStringUtils.random(10);
        String address = RandomStringUtils.random(10);
        String metroStation = RandomStringUtils.random(10);
        String phone = RandomStringUtils.random(10);
        int rentTime = 5;
        String deliveryDate = "2024-02-02";
        String comment = RandomStringUtils.random(10);

        // Создаем заказ и сохраняем его идентификатор
        track = orderSteps.createOrder(firstName, lastName, address, metroStation, phone, rentTime, deliveryDate, comment, colorStr.split(","))
                .extract()
                .path("track");

        // Проверяем статус и наличие трек-идентификатора
        orderSteps.createOrder(firstName, lastName, address, metroStation, phone, rentTime, deliveryDate, comment, colorStr.split(","))
                .statusCode(SC_CREATED)
                .body("track", notNullValue());
    }
}
