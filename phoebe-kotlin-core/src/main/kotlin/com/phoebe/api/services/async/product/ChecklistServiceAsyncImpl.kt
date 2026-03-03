// File generated from our OpenAPI spec by Stainless.

package com.phoebe.api.services.async.product

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
import com.phoebe.api.models.product.checklist.ChecklistViewParams
import com.phoebe.api.models.product.checklist.ChecklistViewResponse

/**
 * The product end-points make it easy to get the information shown in various pages on the eBird
 * web site: 1. The Top 100 contributors on a given date. 2. The checklists submitted on a given
 * date. 3. The most recent checklists submitted. 4. A summary of the checklists submitted on a
 * given date. 5. The details and all the observations of a checklist.
 */
class ChecklistServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    ChecklistServiceAsync {

    private val withRawResponse: ChecklistServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): ChecklistServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: (ClientOptions.Builder) -> Unit): ChecklistServiceAsync =
        ChecklistServiceAsyncImpl(clientOptions.toBuilder().apply(modifier).build())

    override suspend fun view(
        params: ChecklistViewParams,
        requestOptions: RequestOptions,
    ): ChecklistViewResponse =
        // get /product/checklist/view/{subId}
        withRawResponse().view(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        ChecklistServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: (ClientOptions.Builder) -> Unit
        ): ChecklistServiceAsync.WithRawResponse =
            ChecklistServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier).build()
            )

        private val viewHandler: Handler<ChecklistViewResponse> =
            jsonHandler<ChecklistViewResponse>(clientOptions.jsonMapper)

        override suspend fun view(
            params: ChecklistViewParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ChecklistViewResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("subId", params.subId())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("product", "checklist", "view", params._pathParam(0))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.executeAsync(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { viewHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }
    }
}
