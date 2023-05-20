### Итоги автоматизированного тестирования
#### Краткое описание
Автоматизированы запланированные (_Plan.md_) позитивные и негативные сценарии покупки тура.

Разработаны тесты:
* UI-тесты - классы _TravelTest, TravelCreditTest_;
* API-тесты - классы _DBTest_, _TravelApiTest_;
* по результатам прогона тестов получены репорты Allure.
#### Общее количество тест-кейсов: 38.
* _TravelTest_ - 16,
* _TravelCreditTest - 16,
* _DBTest_ - 4,
* _TravelApiTest_ - 2.
#### Процент успешных и не успешных тест-кейсов: 34% успешных, 66% неуспешных.
* _TravelTest_ - 37,5% успешных, 62,5% неуспешных,
* _TravelCreditTest_ - 44% успешных, 56% неуспешных,
* _DBTest_ - 100% неуспешных,
* _TravelApiTest_ - 100% неуспешных.

Репорты Allure:

  ![img.png](images/img.png)
  ![img_3.png](images/img_3.png)
  ![img_1.png](images/img_1.png)
  ![img_2.png](images/img_2.png)

 

#### Bag-репорты: открыты 5 issues.
* [В поле "Владелец" можно ввести цифры, любые знаки, буквы не латинского алфавита в неограниченном количестве #1](https://github.com/KomarovaN/QA50-diplom/issues/1),
* [В поле "Месяц" можно ввести значение больше 12 #2](https://github.com/KomarovaN/QA50-diplom/issues/2),
* [В ответ на запрос POST симулятору сервисов банка, отправленному с валидными данными, возвращается код ошибки сервера 500 #3](https://github.com/KomarovaN/QA50-diplom/issues/3),
* [В базе данных нет записей о статусе оплаты после получения ответа от симулятора сервисов банка #4](https://github.com/KomarovaN/QA50-diplom/issues/4),
* [Если поля "Месяц" и "Номер карты" пустые, то выводится сообщение "Неверный формат" вместо сообщения "Поле обязательно для заполнения" #5](https://github.com/KomarovaN/QA50-diplom/issues/5).

#### Общие рекомендации.
Тесты приложения (_class TravelTest_) с проверкой отображения сообщений банка о результатах выпонения операции:
* shouldPayCardValidApproved(),
* shouldNotPayCardValidApproved(),
* shouldCreditCardValidApproved(),
* shouldNotCreditCardValidApproved(),
* shouldPayCardValidDeclined(),
* shouldNotPayCardValidDeclined(),
* shouldCreditCardValidDeclined(),
* shouldNotCreditCardValidDeclined();

а также все тесты с запросами к БД (_class DBTest_) для проверки внесенных приложением данных
о том, успешно ли был совершён платёж и каким способом,
необходимо повторить после устранения ошибки запроса к симулятору сервисов банка с кодом 500,
то есть когда симулятор сервисов банка вернет код выполнения запроса 200,
и API-тесты (_class TravelApiTest_) пройдут успешно.

![img_6.png](images/img_6.png)
![img_7.png](images/img_7.png)


