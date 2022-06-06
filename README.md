Приложение запускается через класс AlphaBankTestTaskApplication

После запуска приложения в браузере переходим по адресу http://localhost:8005/alphaApp/api/v1/rate/{Currency}
Где вместо {Currency} указываем 3х значный код валюты (в любом регистре). В результате увидим в браузере соответствующую гифку

Для получения json формата гифки используем адресс http://localhost:8005/alphaApp/api/v1/rate/{Currency}.json

Так же в файле httpRequest.http (лежит в корне проекта) через intellij idea можно запустить get запросы.

Все api keys и url адресса сторонних api расположены в application.properties. Если порт 8005 занят в application.properties
можно изменить номер порта