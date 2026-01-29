Feature: Pruebas con JSONPlaceholder

  Background:
    * url baseUrl

  Scenario: Validar datos del primer usuario
    Given path 'users/1'
    When method get
    Then status 200
    And match response.name == 'Leanne Graham'
    And match response.email == 'Sincere@april.biz'
    And match response.address.city == 'Gwenborough'

  Scenario: Crear un nuevo post
    Given path 'posts'
    And request { title: 'Mi primer test', body: 'Karate es genial', userId: 1 }
    When method post
    Then status 201
    And match response == { id: '#number', title: 'Mi primer test', body: 'Karate es genial', userId: 1 }

  Scenario: Obtener y confirmar ciudad del usuario 1
    Given path 'users/1'
    When method get
    Then status 200

    * def cityName = response.address.city

    And param address.city = cityName 
    When method get
    Then status 200

    Scenario: Validar que los posts devueltos pertenecen al usuario correcto
    Given path 'users/1'
    When method get
    * def targetUserId = response.id

    Given path 'posts'
    And param userId = targetUserId
    When method get
    Then status 200
    
    And match response[0].userId == targetUserId

  Scenario: Validar esquema del objeto company del usuario 1
    Given path 'users/1'
    When method get
    Then status 200

    * def companySchema = read('company-schema.json')
    And match response.company == companySchema

  Scenario Outline: Crear multiples posts
    Given path 'posts'
    And request { title: '<title>', body: '<body>', userId: <userId> }
    When method post
    Then status 201
    And match response.title == '<title>'
    And match response.body == '<body>'
    And match response.userId == <userId>
    Examples:
      | title            | body                | userId |
      | Test Karate 1    | Body del post 1     | 1      |
      | Test Karate 2    | Body del post 2     | 2      |
