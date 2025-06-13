// File generated from our OpenAPI spec by Stainless.

package com.phoebe.api.services.async.ref.taxonomy

import com.phoebe.api.core.ClientOptions
import com.phoebe.api.core.JsonValue
import com.phoebe.api.core.RequestOptions
import com.phoebe.api.core.checkRequired
import com.phoebe.api.core.handlers.errorHandler
import com.phoebe.api.core.handlers.jsonHandler
import com.phoebe.api.core.handlers.withErrorHandler
import com.phoebe.api.core.http.HttpMethod
import com.phoebe.api.core.http.HttpRequest
import com.phoebe.api.core.http.HttpResponse.Handler
import com.phoebe.api.core.http.HttpResponseFor
import com.phoebe.api.core.http.parseable
import com.phoebe.api.core.prepareAsync
import com.phoebe.api.models.ref.taxonomy.speciesgroups.SpeciesGroupListParams
import com.phoebe.api.models.ref.taxonomy.speciesgroups.SpeciesGroupListResponse

class SpeciesGroupServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    SpeciesGroupServiceAsync {

    private val withRawResponse: SpeciesGroupServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): SpeciesGroupServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: (ClientOptions.Builder) -> Unit): SpeciesGroupServiceAsync =
        SpeciesGroupServiceAsyncImpl(clientOptions.toBuilder().apply(modifier).build())

    override suspend fun list(
        params: SpeciesGroupListParams,
        requestOptions: RequestOptions,
    ): List<SpeciesGroupListResponse> =
        // get /ref/sppgroup/{speciesGrouping}
        withRawResponse().list(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        SpeciesGroupServiceAsync.WithRawResponse {

        private val errorHandler: Handler<JsonValue> = errorHandler(clientOptions.jsonMapper)

        override fun withOptions(
            modifier: (ClientOptions.Builder) -> Unit
        ): SpeciesGroupServiceAsync.WithRawResponse =
            SpeciesGroupServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier).build()
            )

        private val listHandler: Handler<List<SpeciesGroupListResponse>> =
            jsonHandler<List<SpeciesGroupListResponse>>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override suspend fun list(
            params: SpeciesGroupListParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<List<SpeciesGroupListResponse>> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("speciesGrouping", params.speciesGrouping())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("ref", "sppgroup", params._pathParam(0))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.executeAsync(request, requestOptions)
            return response.parseable {
                response
                    .use { listHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.forEach { it.validate() }
                        }
                    }
            }
        }
    }
}
