// File generated from our OpenAPI spec by Stainless.

package com.phoebe.api.services.blocking.product

import com.google.errorprone.annotations.MustBeClosed
import com.phoebe.api.core.ClientOptions
import com.phoebe.api.core.RequestOptions
import com.phoebe.api.core.http.HttpResponseFor
import com.phoebe.api.models.product.lists.ListRetrieveParams
import com.phoebe.api.models.product.lists.ListRetrieveResponse
import com.phoebe.api.services.blocking.product.lists.HistoricalService

interface ListService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: (ClientOptions.Builder) -> Unit): ListService

    fun historical(): HistoricalService

    /** Get information on the most recently submitted checklists for a region. */
    fun retrieve(
        regionCode: String,
        params: ListRetrieveParams = ListRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): List<ListRetrieveResponse> =
        retrieve(params.toBuilder().regionCode(regionCode).build(), requestOptions)

    /** @see [retrieve] */
    fun retrieve(
        params: ListRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): List<ListRetrieveResponse>

    /** @see [retrieve] */
    fun retrieve(regionCode: String, requestOptions: RequestOptions): List<ListRetrieveResponse> =
        retrieve(regionCode, ListRetrieveParams.none(), requestOptions)

    /** A view of [ListService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: (ClientOptions.Builder) -> Unit): ListService.WithRawResponse

        fun historical(): HistoricalService.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /product/lists/{regionCode}`, but is otherwise the
         * same as [ListService.retrieve].
         */
        @MustBeClosed
        fun retrieve(
            regionCode: String,
            params: ListRetrieveParams = ListRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<List<ListRetrieveResponse>> =
            retrieve(params.toBuilder().regionCode(regionCode).build(), requestOptions)

        /** @see [retrieve] */
        @MustBeClosed
        fun retrieve(
            params: ListRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<List<ListRetrieveResponse>>

        /** @see [retrieve] */
        @MustBeClosed
        fun retrieve(
            regionCode: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<List<ListRetrieveResponse>> =
            retrieve(regionCode, ListRetrieveParams.none(), requestOptions)
    }
}
