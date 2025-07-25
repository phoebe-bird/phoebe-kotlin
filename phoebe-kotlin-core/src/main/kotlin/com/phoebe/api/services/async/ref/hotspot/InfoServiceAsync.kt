// File generated from our OpenAPI spec by Stainless.

package com.phoebe.api.services.async.ref.hotspot

import com.google.errorprone.annotations.MustBeClosed
import com.phoebe.api.core.ClientOptions
import com.phoebe.api.core.RequestOptions
import com.phoebe.api.core.http.HttpResponseFor
import com.phoebe.api.models.ref.hotspot.info.InfoRetrieveParams
import com.phoebe.api.models.ref.hotspot.info.InfoRetrieveResponse

interface InfoServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: (ClientOptions.Builder) -> Unit): InfoServiceAsync

    /**
     * Get information on the location of a hotspot. #### Notes This API call only works for
     * hotspots. If you pass the location code for a private location or an invalid location code
     * then an HTTP 410 (Gone) error is returned.
     */
    suspend fun retrieve(
        locId: String,
        params: InfoRetrieveParams = InfoRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): InfoRetrieveResponse = retrieve(params.toBuilder().locId(locId).build(), requestOptions)

    /** @see retrieve */
    suspend fun retrieve(
        params: InfoRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): InfoRetrieveResponse

    /** @see retrieve */
    suspend fun retrieve(locId: String, requestOptions: RequestOptions): InfoRetrieveResponse =
        retrieve(locId, InfoRetrieveParams.none(), requestOptions)

    /** A view of [InfoServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: (ClientOptions.Builder) -> Unit): InfoServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /ref/hotspot/info/{locId}`, but is otherwise the
         * same as [InfoServiceAsync.retrieve].
         */
        @MustBeClosed
        suspend fun retrieve(
            locId: String,
            params: InfoRetrieveParams = InfoRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<InfoRetrieveResponse> =
            retrieve(params.toBuilder().locId(locId).build(), requestOptions)

        /** @see retrieve */
        @MustBeClosed
        suspend fun retrieve(
            params: InfoRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<InfoRetrieveResponse>

        /** @see retrieve */
        @MustBeClosed
        suspend fun retrieve(
            locId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<InfoRetrieveResponse> =
            retrieve(locId, InfoRetrieveParams.none(), requestOptions)
    }
}
