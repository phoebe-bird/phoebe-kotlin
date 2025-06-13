// File generated from our OpenAPI spec by Stainless.

package com.phoebe.api.services.async.ref.region

import com.google.errorprone.annotations.MustBeClosed
import com.phoebe.api.core.ClientOptions
import com.phoebe.api.core.RequestOptions
import com.phoebe.api.core.http.HttpResponseFor
import com.phoebe.api.models.ref.region.adjacent.AdjacentListParams
import com.phoebe.api.models.ref.region.adjacent.AdjacentListResponse

interface AdjacentServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: (ClientOptions.Builder) -> Unit): AdjacentServiceAsync

    /**
     * Get the list of countries or regions that share a border with this one. #### Notes Only
     * subnational2 codes in the United States, New Zealand, or Mexico are currently supported
     */
    suspend fun list(
        regionCode: String,
        params: AdjacentListParams = AdjacentListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): List<AdjacentListResponse> =
        list(params.toBuilder().regionCode(regionCode).build(), requestOptions)

    /** @see [list] */
    suspend fun list(
        params: AdjacentListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): List<AdjacentListResponse>

    /** @see [list] */
    suspend fun list(
        regionCode: String,
        requestOptions: RequestOptions,
    ): List<AdjacentListResponse> = list(regionCode, AdjacentListParams.none(), requestOptions)

    /**
     * A view of [AdjacentServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: (ClientOptions.Builder) -> Unit
        ): AdjacentServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /ref/adjacent/{regionCode}`, but is otherwise the
         * same as [AdjacentServiceAsync.list].
         */
        @MustBeClosed
        suspend fun list(
            regionCode: String,
            params: AdjacentListParams = AdjacentListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<List<AdjacentListResponse>> =
            list(params.toBuilder().regionCode(regionCode).build(), requestOptions)

        /** @see [list] */
        @MustBeClosed
        suspend fun list(
            params: AdjacentListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<List<AdjacentListResponse>>

        /** @see [list] */
        @MustBeClosed
        suspend fun list(
            regionCode: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<List<AdjacentListResponse>> =
            list(regionCode, AdjacentListParams.none(), requestOptions)
    }
}
