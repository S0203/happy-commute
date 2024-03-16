package org.sy9723.happycommute.retrofit

import org.springframework.context.annotation.Import

/**
 * 해당 어노테이션이 붙어있는 하위 패키지에서 RetrofitApi 를 검색하여 bean 으로 등록
 * @see RetrofitApi
 * @see RetrofitApiRegistrar
 */
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.CLASS)
@Import(RetrofitApiRegistrar::class)
annotation class EnableRetrofitApi