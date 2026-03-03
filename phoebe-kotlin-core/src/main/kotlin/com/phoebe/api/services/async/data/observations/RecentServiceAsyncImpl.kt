// File generated from our OpenAPI spec by Stainless.

package com.phoebe.api.services.async.data.observations

import com.phoebe.api.core.ClientOptions
import com.phoebe.api.core.RequestOptions
import com.phoebe.api.core.checkRequired
import com.phoebe.api.core.handlers.errorBodyHandler
import com.phoebe.api.core.handlers.errorHandler
import com.phoebe.api.core.handlers.jsonHandler
import com.phoebe.api.core.http.HttpMethod
import com.phoebe.api.core.http.HttpRequest
import com.phoebe.api.core.http.HttpResponse
import com.phoebe.api.core.http.HttpResponse.Handler
import com.phoebe.api.core.http.HttpResponseFor
import com.phoebe.api.core.http.parseable
import com.phoebe.api.core.prepareAsync
import com.phoebe.api.models.data.observations.Observation
import com.phoebe.api.models.data.observations.recent.RecentListParams
import com.phoebe.api.services.async.data.observations.recent.HistoricServiceAsync
import com.phoebe.api.services.async.data.observations.recent.HistoricServiceAsyncImpl
import com.phoebe.api.services.async.data.observations.recent.NotableServiceAsync
import com.phoebe.api.services.async.data.observations.recent.NotableServiceAsyncImpl
import com.phoebe.api.services.async.data.observations.recent.SpecieServiceAsync
import com.phoebe.api.services.async.data.observations.recent.SpecieServiceAsyncImpl

/**
 * The data/obs end-points are used to fetch observations submitted to eBird in checklists. There
 * are two categories of end-point: 1. Fetch observations for a specific country, region or
 * location. 2. Fetch observations for nearby locations - up to a distance of 50km. Each end-point
 * supports optional query parameters which allow you to filter the list of observations returned.
 */
class RecentServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    RecentServiceAsync {

    private val withRawResponse: RecentServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val notable: NotableServiceAsync by lazy { NotableServiceAsyncImpl(clientOptions) }

    private val species: SpecieServiceAsync by lazy { SpecieServiceAsyncImpl(clientOptions) }

    private val historic: HistoricServiceAsync by lazy { HistoricServiceAsyncImpl(clientOptions) }

    override fun withRawResponse(): RecentServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: (ClientOptions.Builder) -> Unit): RecentServiceAsync =
        RecentServiceAsyncImpl(clientOptions.toBuilder().apply(modifier).build())

    /**
     * The data/obs end-points are used to fetch observations submitted to eBird in checklists.
     * There are two categories of end-point: 1. Fetch observations for a specific country, region
     * or location. 2. Fetch observations for nearby locations - up to a distance of 50km. Each
     * end-point supports optional query parameters which allow you to filter the list of
     * observations returned.
     */
    override fun notable(): NotableServiceAsync = notable

    /**
     * The data/obs end-points are used to fetch observations submitted to eBird in checklists.
     * There are two categories of end-point: 1. Fetch observations for a specific country, region
     * or location. 2. Fetch observations for nearby locations - up to a distance of 50km. Each
     * end-point supports optional query parameters which allow you to filter the list of
     * observations returned.
     */
    override fun species(): SpecieServiceAsync = species

    /**
     * The data/obs end-points are used to fetch observations submitted to eBird in checklists.
     * There are two categories of end-point: 1. Fetch observations for a specific country, region
     * or location. 2. Fetch observations for nearby locations - up to a distance of 50km. Each
     * end-point supports optional query parameters which allow you to filter the list of
     * observations returned.
     */
    override fun historic(): HistoricServiceAsync = historic

    override suspend fun list(
        params: RecentListParams,
        requestOptions: RequestOptions,
    ): List<Observation> =
        // get /data/obs/{regionCode}/recent
        withRawResponse().list(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        RecentServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        private val notable: NotableServiceAsync.WithRawResponse by lazy {
            NotableServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val species: SpecieServiceAsync.WithRawResponse by lazy {
            SpecieServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val historic: HistoricServiceAsync.WithRawResponse by lazy {
            HistoricServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: (ClientOptions.Builder) -> Unit
        ): RecentServiceAsync.WithRawResponse =
            RecentServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier).build()
            )

        /**
         * The data/obs end-points are used to fetch observations submitted to eBird in checklists.
         * There are two categories of end-point: 1. Fetch observations for a specific country,
         * region or location. 2. Fetch observations for nearby locations - up to a distance of
         * 50km. Each end-point supports optional query parameters which allow you to filter the
         * list of observations returned.
         */
        override fun notable(): NotableServiceAsync.WithRawResponse = notable

        /**
         * The data/obs end-points are used to fetch observations submitted to eBird in checklists.
         * There are two categories of end-point: 1. Fetch observations for a specific country,
         * region or location. 2. Fetch observations for nearby locations - up to a distance of
         * 50km. Each end-point supports optional query parameters which allow you to filter the
         * list of observations returned.
         */
        override fun species(): SpecieServiceAsync.WithRawResponse = species

        /**
         * The data/obs end-points are used to fetch observations submitted to eBird in checklists.
         * There are two categories of end-point: 1. Fetch observations for a specific country,
         * region or location. 2. Fetch observations for nearby locations - up to a distance of
         * 50km. Each end-point supports optional query parameters which allow you to filter the
         * list of observations returned.
         */
        override fun historic(): HistoricServiceAsync.WithRawResponse = historic

        private val listHandler: Handler<List<Observation>> =
            jsonHandler<List<Observation>>(clientOptions.jsonMapper)

        override suspend fun list(
            params: RecentListParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<List<Observation>> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("regionCode", params.regionCode())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("data", "obs", params._pathParam(0), "recent")
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.executeAsync(request, requestOptions)
            return errorHandler.handle(response).parseable {
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
