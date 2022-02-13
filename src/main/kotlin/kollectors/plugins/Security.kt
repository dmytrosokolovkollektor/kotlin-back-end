package kollectors.plugins

import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.sessions.*
import kotlin.collections.set

private const val AUTH_COOKIE = "client-cookie";

fun Application.configureSecurity() {
    authentication {
        basic(name = "myauth1") {
            realm = "Ktor Server"
            validate { credentials ->
                if (credentials.name == credentials.password) {
                    UserIdPrincipal(credentials.name)
                } else {
                    null
                }
            }
        }
    }
    install(Sessions) { //Enable Sessions
        cookie<UserIdPrincipal>( //Use UserIdPrincipal as user data principal container, and identifying it via cookies
            AUTH_COOKIE, // Just String constant with value: const val AUTH_COOKIE = "auth"
            storage = SessionStorageMemory() // We use default in-memory storage, but you can write your own realization and store sessions whereever you wish
        ) {
            cookie.path = "/" // We cookies should work
            cookie.extensions["SameSite"] = "lax"
        }
    }
}