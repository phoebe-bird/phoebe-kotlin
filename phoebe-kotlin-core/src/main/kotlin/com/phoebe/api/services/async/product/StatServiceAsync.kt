// File generated from our OpenAPI spec by Stainless.

package com.phoebe.api.services.async.product

import com.google.errorprone.annotations.MustBeClosed
import com.phoebe.api.core.RequestOptions
import com.phoebe.api.core.http.HttpResponseFor
import com.phoebe.api.models.product.stats.StatRetrieveParams
import com.phoebe.api.models.product.stats.StatRetrieveResponse

interface StatServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Get a summary of the number of checklist submitted, species seen and contributors on a given
     * date for a country or region.
     *
     * #### Notes The results are updated every 15 minutes.
     */
    suspend fun retrieve(
        d: Long,
        params: StatRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): StatRetrieveResponse = retrieve(params.toBuilder().d(d).build(), requestOptions)

    /** @see [retrieve] */
    suspend fun retrieve(
        params: StatRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): StatRetrieveResponse

    /** A view of [StatServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a raw HTTP response for `get /product/stats/{regionCode}/{y}/{m}/{d}`, but is
         * otherwise the same as [StatServiceAsync.retrieve].
         */
        @MustBeClosed
        suspend fun retrieve(
            d: Long,
            params: StatRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<StatRetrieveResponse> =
            retrieve(params.toBuilder().d(d).build(), requestOptions)

        /** @see [retrieve] */
        @MustBeClosed
        suspend fun retrieve(
            params: StatRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<StatRetrieveResponse>
    }
}
