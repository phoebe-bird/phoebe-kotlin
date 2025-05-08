package com.phoebe.api.errors

class PhoebeInvalidDataException(message: String? = null, cause: Throwable? = null) :
    PhoebeException(message, cause)
