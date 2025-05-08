package com.phoebe.api.errors

open class PhoebeException(message: String? = null, cause: Throwable? = null) :
    RuntimeException(message, cause)
