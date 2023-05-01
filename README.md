## Проверка с postgresql
В IntelliJ IDEA 
1. Выполнить в первом терминале команду:

docker-compose up
2. Открыть второй терминал и выполнить команду:

java -jar artifacts/aqa-shop.jar
3. Открыть третий терминал и выполнить команды:

.\gradlew clean test

.\gradlew allureserve
4. Посмотреть результаты прохождения тестов в отчете Allure.
5. Выполнить <Ctrl+C> для команды .\gradlew allureserve, ввести на запрос "y".
6. Во втором терминале выполнить <Ctrl+C> для команды java -jar artifacts/aqa-shop.jar.
7. В первом терминале выполнить <Ctrl+C> и команду:

docker-compose down.  
8. В каталоге проекта удалить каталог data.

## Проверка с mysql
1. В файле application.properties изменить значение spring.datasource.url на jdbc:mysql://localhost:3306/data
2. В файле docker-compose.yml убрать комментарии с блока mysql
1. Выполнить в первом терминале команду:

docker-compose up
2. Во втором терминале выполнить команду:

java -jar artifacts/aqa-shop.jar
3. В третьем терминале выполнить команды:

.\gradlew clean test

.\gradlew allureserve

4. Посмотреть результаты прохождения тестов в AllureReport.
5. Выполнить <Ctrl+C> для команды .\gradlew allureserve, ввести на запрос "y".
6. Во втором терминале выполнить <Ctrl+C> для команды java -jar artifacts/aqa-shop.jar.
7. В первом терминале выполнить <Ctrl+C> и команду:

docker-compose down.
8. В каталоге проекта удалить каталог data.