package org.sy9723.happycommute.retrofit

import org.springframework.beans.factory.support.BeanDefinitionRegistry
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar
import org.springframework.core.type.AnnotationMetadata
import org.springframework.util.ClassUtils

/**
 * RetrofitApi 어노테이션이 붙어있는 인터페이스를 beanDefinition에 등록
 * @see RetrofitApiComponentProvider
 */
class RetrofitApiRegistrar: ImportBeanDefinitionRegistrar {
    override fun registerBeanDefinitions(importingClassMetadata: AnnotationMetadata, registry: BeanDefinitionRegistry) {
        val basePackage = ClassUtils.getPackageName(importingClassMetadata.className)

        RetrofitApiComponentProvider.findCandidateComponents(basePackage).forEach {
            val beanClass = Class.forName(it.beanClassName)
            registry.registerBeanDefinition(beanClass.name, it)
        }
    }
}