package com.phoebe.api.errors

class PhoebeIoException(message: String? = null, cause: Throwable? = null) :
    PhoebeException(message, cause)
