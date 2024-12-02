package com.kimsisters.saju8ja.global.interceptor

import jakarta.servlet.FilterChain
import jakarta.servlet.ServletRequest
import jakarta.servlet.ServletResponse
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import mu.KotlinLogging
import org.springframework.stereotype.Component
import org.springframework.web.servlet.HandlerInterceptor
import org.springframework.web.util.ContentCachingRequestWrapper
import org.springframework.web.util.ContentCachingResponseWrapper

@Component
class LoggingInterceptor : HandlerInterceptor {

    private val logger = KotlinLogging.logger {}

    override fun preHandle(request: HttpServletRequest, response: HttpServletResponse, handler: Any): Boolean {
        val cachingRequest = ContentCachingRequestWrapper(request)
        val requestBody = String(cachingRequest.contentAsByteArray)

        logger.info("Incoming Request: [${request.method}] ${request.requestURI}")
        logger.info("Headers: ${request.headerNames.toList().joinToString { "$it=${request.getHeader(it)}" }}")
        logger.info("Query Params: ${request.queryString ?: "None"}")

        logger.info("Request Body: $requestBody")
        return true
    }

    override fun afterCompletion(request: HttpServletRequest, response: HttpServletResponse, handler: Any, ex: Exception?) {
        val cachingResponse = ContentCachingResponseWrapper(response)

        logger.info("Outgoing Response: Status=${cachingResponse.status}")

        if (logger.isDebugEnabled) {
            val responseBody = String(cachingResponse.contentAsByteArray)
            logger.debug("Response Body: $responseBody")
        }

        cachingResponse.copyBodyToResponse()
    }
}