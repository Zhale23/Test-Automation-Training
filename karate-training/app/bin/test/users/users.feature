Feature: Pruebas con JSONPlaceholder

  Background:
    * url baseUrl

  Scenario: Validar datos del primer usuario
    Given path 'users/1'
    When method get
    Then status 200
    # Verificamos la estructura real de esta API
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