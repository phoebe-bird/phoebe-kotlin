// File generated from our OpenAPI spec by Stainless.

package com.phoebe.api.services.async.ref.taxonomy

import com.google.errorprone.annotations.MustBeClosed
import com.phoebe.api.core.ClientOptions
import com.phoebe.api.core.RequestOptions
import com.phoebe.api.core.http.HttpResponseFor
import com.phoebe.api.models.ref.taxonomy.ebird.EbirdRetrieveParams
import com.phoebe.api.models.ref.taxonomy.ebird.EbirdRetrieveResponse

interface EbirdServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: (ClientOptions.Builder) -> Unit): EbirdServiceAsync

    /**
     * Get the taxonomy used by eBird. #### Notes Each entry in the taxonomy contains a species code
     * for example, barswa for Barn Swallow. You can download the taxonomy for selected species
     * using the _species_ query parameter with a comma separating each code. Otherwise the full
     * taxonomy is downloaded.
     */
    suspend fun retrieve(
        params: EbirdRetrieveParams = EbirdRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): List<EbirdRetrieveResponse>

    /** @see [retrieve] */
    suspend fun retrieve(requestOptions: RequestOptions): List<EbirdRetrieveResponse> =
        retrieve(EbirdRetrieveParams.none(), requestOptions)

    /** A view of [EbirdServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: (ClientOptions.Builder) -> Unit
        ): EbirdServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /ref/taxonomy/ebird`, but is otherwise the same as
         * [EbirdServiceAsync.retrieve].
         */
        @MustBeClosed
        suspend fun retrieve(
            params: EbirdRetrieveParams = EbirdRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<List<EbirdRetrieveResponse>>

        /** @see [retrieve] */
        @MustBeClosed
        suspend fun retrieve(
            requestOptions: RequestOptions
        ): HttpResponseFor<List<EbirdRetrieveResponse>> =
            retrieve(EbirdRetrieveParams.none(), requestOptions)
    }
}
