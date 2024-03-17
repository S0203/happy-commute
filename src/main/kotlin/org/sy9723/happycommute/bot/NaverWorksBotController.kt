package org.sy9723.happycommute.bot

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/worksmobile")
@RestController
class NaverWorksBotController {
    @PostMapping
    fun botCallback(
        @RequestBody req: Any
    ): ResponseEntity<Any?> {
        log.info("req: {}", req)
        return ResponseEntity.ok(null)
    }

    companion object {
        val log: Logger = LoggerFactory.getLogger(NaverWorksBotController::class.java)
    }
}
