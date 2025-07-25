// File generated from our OpenAPI spec by Stainless.

package com.phoebe.api.services.async.data.observations.recent

import com.google.errorprone.annotations.MustBeClosed
import com.phoebe.api.core.ClientOptions
import com.phoebe.api.core.RequestOptions
import com.phoebe.api.core.http.HttpResponseFor
import com.phoebe.api.models.data.observations.Observation
import com.phoebe.api.models.data.observations.recent.notable.NotableListParams

interface NotableServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: (ClientOptions.Builder) -> Unit): NotableServiceAsync

    /**
     * Get the list of recent, notable observations (up to 30 days ago) of birds seen in a country,
     * region or location. Notable observations can be for locally or nationally rare species or are
     * otherwise unusual, e.g. over-wintering birds in a species which is normally only a summer
     * visitor.
     */
    suspend fun list(
        regionCode: String,
        params: NotableListParams = NotableListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): List<Observation> = list(params.toBuilder().regionCode(regionCode).build(), requestOptions)

    /** @see list */
    suspend fun list(
        params: NotableListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): List<Observation>

    /** @see list */
    suspend fun list(regionCode: String, requestOptions: RequestOptions): List<Observation> =
        list(regionCode, NotableListParams.none(), requestOptions)

    /**
     * A view of [NotableServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: (ClientOptions.Builder) -> Unit
        ): NotableServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /data/obs/{regionCode}/recent/notable`, but is
         * otherwise the same as [NotableServiceAsync.list].
         */
        @MustBeClosed
        suspend fun list(
            regionCode: String,
            params: NotableListParams = NotableListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<List<Observation>> =
            list(params.toBuilder().regionCode(regionCode).build(), requestOptions)

        /** @see list */
        @MustBeClosed
        suspend fun list(
            params: NotableListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<List<Observation>>

        /** @see list */
        @MustBeClosed
        suspend fun list(
            regionCode: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<List<Observation>> =
            list(regionCode, NotableListParams.none(), requestOptions)
    }
}
