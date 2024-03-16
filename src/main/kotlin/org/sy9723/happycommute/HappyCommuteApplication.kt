package org.sy9723.happycommute

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.sy9723.happycommute.retrofit.EnableRetrofitApi

@SpringBootApplication
@EnableRetrofitApi
class HappyCommuteApplication

fun main(args: Array<String>) {
    runApplication<HappyCommuteApplication>(*args)
}
