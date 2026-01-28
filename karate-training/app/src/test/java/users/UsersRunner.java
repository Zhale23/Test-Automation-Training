package users;

import com.intuit.karate.junit5.Karate;

class UsersRunner {
    @Karate.Test
    Karate testUsers() {
        // Ejecuta el archivo users.feature que está en esta misma carpeta
        return Karate.run("users").relativeTo(getClass());
    }
}