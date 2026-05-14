// File generated from our OpenAPI spec by Stainless.

package com.phoebe.api.services.async.data.observations.recent

import com.google.errorprone.annotations.MustBeClosed
import com.phoebe.api.core.ClientOptions
import com.phoebe.api.core.RequestOptions
import com.phoebe.api.core.http.HttpResponseFor
import com.phoebe.api.models.data.observations.Observation
import com.phoebe.api.models.data.observations.recent.historic.HistoricListParams

/**
 * The data/obs end-points are used to fetch observations submitted to eBird in checklists. There
 * are two categories of end-point: 1. Fetch observations for a specific country, region or
 * location. 2. Fetch observations for nearby locations - up to a distance of 50km. Each end-point
 * supports optional query parameters which allow you to filter the list of observations returned.
 */
interface HistoricServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: (ClientOptions.Builder) -> Unit): HistoricServiceAsync

    /**
     * Get a list of all taxa seen in a country, region or location on a specific date, with the
     * specific observations determined by the "rank" parameter (defaults to latest observation on
     * the date).
     *
     * #### Notes Responses may be cached for 30 minutes
     */
    suspend fun list(
        d: Long,
        params: HistoricListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): List<Observation> = list(params.toBuilder().d(d).build(), requestOptions)

    /** @see list */
    suspend fun list(
        params: HistoricListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): List<Observation>

    /**
     * A view of [HistoricServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: (ClientOptions.Builder) -> Unit
        ): HistoricServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /data/obs/{regionCode}/historic/{y}/{m}/{d}`, but is
         * otherwise the same as [HistoricServiceAsync.list].
         */
        @MustBeClosed
        suspend fun list(
            d: Long,
            params: HistoricListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<List<Observation>> =
            list(params.toBuilder().d(d).build(), requestOptions)

        /** @see list */
        @MustBeClosed
        suspend fun list(
            params: HistoricListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<List<Observation>>
    }
}
