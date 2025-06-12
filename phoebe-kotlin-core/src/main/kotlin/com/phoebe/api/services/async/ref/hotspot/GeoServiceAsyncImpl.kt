// File generated from our OpenAPI spec by Stainless.

package com.phoebe.api.services.async.ref.hotspot

import com.phoebe.api.core.ClientOptions
import com.phoebe.api.core.JsonValue
import com.phoebe.api.core.RequestOptions
import com.phoebe.api.core.handlers.errorHandler
import com.phoebe.api.core.handlers.jsonHandler
import com.phoebe.api.core.handlers.withErrorHandler
import com.phoebe.api.core.http.HttpMethod
import com.phoebe.api.core.http.HttpRequest
import com.phoebe.api.core.http.HttpResponse.Handler
import com.phoebe.api.core.http.HttpResponseFor
import com.phoebe.api.core.http.parseable
import com.phoebe.api.core.prepareAsync
import com.phoebe.api.models.ref.hotspot.geo.GeoRetrieveParams
import com.phoebe.api.models.ref.hotspot.geo.GeoRetrieveResponse

class GeoServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    GeoServiceAsync {

    private val withRawResponse: GeoServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): GeoServiceAsync.WithRawResponse = withRawResponse

    override suspend fun retrieve(
        params: GeoRetrieveParams,
        requestOptions: RequestOptions,
    ): List<GeoRetrieveResponse> =
        // get /ref/hotspot/geo
        withRawResponse().retrieve(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        GeoServiceAsync.WithRawResponse {

        private val errorHandler: Handler<JsonValue> = errorHandler(clientOptions.jsonMapper)

        private val retrieveHandler: Handler<List<GeoRetrieveResponse>> =
            jsonHandler<List<GeoRetrieveResponse>>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override suspend fun retrieve(
            params: GeoRetrieveParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<List<GeoRetrieveResponse>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("ref", "hotspot", "geo")
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.executeAsync(request, requestOptions)
            return response.parseable {
                response
                    .use { retrieveHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.forEach { it.validate() }
                        }
                    }
            }
        }
    }
}
