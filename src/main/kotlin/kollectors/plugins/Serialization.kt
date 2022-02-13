package kollectors.plugins

import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.plugins.*
import kotlinx.serialization.json.Json
import org.litote.kmongo.id.serialization.IdKotlinXSerializationModule


private val CurrentJson = Json(DefaultJson) {
    prettyPrint = true
    serializersModule = IdKotlinXSerializationModule
}

fun Application.configureSerialization() {
    install(ContentNegotiation) {
        json(CurrentJson)
    }
}
