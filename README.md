# Sprint_7

1. Создание курьера
   Проверь:
   курьера можно создать;
   нельзя создать двух одинаковых курьеров;
   чтобы создать курьера, нужно передать в ручку все обязательные поля;
   запрос возвращает правильный код ответа;
   успешный запрос возвращает ok: true;
   если одного из полей нет, запрос возвращает ошибку;
   если создать пользователя с логином, который уже есть, возвращается ошибка.
   mvn clean test -Dtest=CourierTest

2. Логин курьера
   Проверь:
   курьер может авторизоваться;
   для авторизации нужно передать все обязательные поля;
   система вернёт ошибку, если неправильно указать логин или пароль;
   если какого-то поля нет, запрос возвращает ошибку;
   если авторизоваться под несуществующим пользователем, запрос возвращает ошибку;
   успешный запрос возвращает id.
   mvn clean test -Dtest=LoginTest

3. Создание заказа
   Проверь, что когда создаёшь заказ:
   можно указать один из цветов — BLACK или GREY;
   можно указать оба цвета;
   можно совсем не указывать цвет;
   тело ответа содержит track.
   mvn clean test -Dtest=OrderTest

4. Список заказов
   Проверь, что в тело ответа возвращается список заказов.

   mvn clean test -Dtest=GetOrderTest

5. Отчёт Allure
   Сгенерируй его и запушь в репозиторий.# Sprint_7
