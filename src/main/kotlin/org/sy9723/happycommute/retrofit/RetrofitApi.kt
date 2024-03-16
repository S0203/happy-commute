package org.sy9723.happycommute.retrofit

import org.springframework.stereotype.Component

/**
 * 해당 어노테이션이 붙어있는 RetrofitApi 인터페이스를 스캔하여
 * 구현체를 Bean 으로 등록
 */
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.CLASS)
@Component
annotation class RetrofitApi
