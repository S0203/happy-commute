package org.sy9723.happycommute.retrofit

import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider
import org.springframework.core.type.filter.AnnotationTypeFilter

/**
 * basePackage 아래에 RetrofitApi 어노테이션이 붙어있는 클래스만 검색
 * @see RetrofitApi
 */
object RetrofitApiComponentProvider : ClassPathScanningCandidateComponentProvider(false) {
    init {
        addIncludeFilter(AnnotationTypeFilter(RetrofitApi::class.java))
    }

    override fun isCandidateComponent(beanDefinition: AnnotatedBeanDefinition): Boolean {
        return beanDefinition.metadata.isInterface
    }
}
