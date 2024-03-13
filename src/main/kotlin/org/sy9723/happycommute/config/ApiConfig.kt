package org.sy9723.happycommute.config

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.annotation.Order
import retrofit2.Retrofit
import java.time.Duration

@Configuration
class ApiConfig {

    @Value("\${api.baseUrl}")
    lateinit var apiBaseUrl: String

    @Bean
    @Order
    fun okHttpClient(): OkHttpClient {
        return OkHttpClient().newBuilder()
            .addNetworkInterceptor(HttpLoggingInterceptor {
                logger.info(it)
            }.setLevel(HttpLoggingInterceptor.Level.BASIC))
            .connectTimeout(Duration.ofSeconds(5))
            .readTimeout(Duration.ofSeconds(5))
            .writeTimeout(Duration.ofSeconds(5))
            .build()
    }

    @Bean
    fun retrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(apiBaseUrl)
            .client(okHttpClient())
            .build()
    }

    companion object {
        private val logger = LoggerFactory.getLogger(this::class.java)
    }
}