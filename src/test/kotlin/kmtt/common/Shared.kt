package kmtt.common

import io.github.resilience4j.ratelimiter.RateLimiterConfig
import io.ktor.client.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import kmtt.base.ktor.HttpClientAdapter
import kmtt.base.ktor.IHttpClient
import kmtt.models.EntryComment
import java.time.Duration

object Shared {
    val httpClient: IHttpClient
    val baseUrl: String = "https://api.dtf.ru/v1.9"
    val token: String = ""

    val comments: List<EntryComment> = listOf(
        EntryComment(1123335, 16158631),
        EntryComment(1110947, 15994992)
    )

    init {
        val rateLimitConfig = RateLimiterConfig
            .custom()
            .limitRefreshPeriod(Duration.ofSeconds(1))
            .limitForPeriod(3)
            .timeoutDuration(Duration.ofHours(100))
            .build()

        httpClient = HttpClientAdapter(HttpClient() {
            install(JsonFeature) {
                serializer = KotlinxSerializer(kotlinx.serialization.json.Json {
                    ignoreUnknownKeys = true
                })
            }
        }, rateLimitConfig)
    }
}
