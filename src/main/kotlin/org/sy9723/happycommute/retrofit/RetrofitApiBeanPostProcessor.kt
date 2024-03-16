package org.sy9723.happycommute.retrofit

import org.springframework.beans.factory.BeanFactory
import org.springframework.beans.factory.BeanFactoryAware
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor
import org.springframework.stereotype.Component
import retrofit2.Retrofit

/**
 * RetrofitApi가 붙어있는 인터페이스의 beanDefinition을 가지고 instantiate 함
 */
@Component
class RetrofitApiBeanPostProcessor : InstantiationAwareBeanPostProcessor, BeanFactoryAware {
    private lateinit var beanFactory: BeanFactory

    override fun postProcessBeforeInstantiation(
        beanClass: Class<*>,
        beanName: String
    ): Any? {
        if (beanClass.isAnnotationPresent(PROCESSING_ANNOTATION)) {
            val retrofit = beanFactory.getBean(Retrofit::class.java)
            return retrofit.create(beanClass)
        }

        return null
    }

    override fun setBeanFactory(beanFactory: BeanFactory) {
        this.beanFactory = beanFactory
    }

    companion object {
        private val PROCESSING_ANNOTATION = RetrofitApi::class.java
    }
}
