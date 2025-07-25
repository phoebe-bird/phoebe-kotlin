// File generated from our OpenAPI spec by Stainless.

package com.phoebe.api.services.blocking.data.observations

import com.google.errorprone.annotations.MustBeClosed
import com.phoebe.api.core.ClientOptions
import com.phoebe.api.core.RequestOptions
import com.phoebe.api.core.http.HttpResponseFor
import com.phoebe.api.models.data.observations.Observation
import com.phoebe.api.models.data.observations.recent.RecentListParams
import com.phoebe.api.services.blocking.data.observations.recent.HistoricService
import com.phoebe.api.services.blocking.data.observations.recent.NotableService
import com.phoebe.api.services.blocking.data.observations.recent.SpecieService

interface RecentService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: (ClientOptions.Builder) -> Unit): RecentService

    fun notable(): NotableService

    fun species(): SpecieService

    fun historic(): HistoricService

    /**
     * Get the list of recent observations (up to 30 days ago) of birds seen in a country, state,
     * county, or location. Results include only the most recent observation for each species in the
     * region specified.
     */
    fun list(
        regionCode: String,
        params: RecentListParams = RecentListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): List<Observation> = list(params.toBuilder().regionCode(regionCode).build(), requestOptions)

    /** @see list */
    fun list(
        params: RecentListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): List<Observation>

    /** @see list */
    fun list(regionCode: String, requestOptions: RequestOptions): List<Observation> =
        list(regionCode, RecentListParams.none(), requestOptions)

    /** A view of [RecentService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: (ClientOptions.Builder) -> Unit): RecentService.WithRawResponse

        fun notable(): NotableService.WithRawResponse

        fun species(): SpecieService.WithRawResponse

        fun historic(): HistoricService.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /data/obs/{regionCode}/recent`, but is otherwise the
         * same as [RecentService.list].
         */
        @MustBeClosed
        fun list(
            regionCode: String,
            params: RecentListParams = RecentListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<List<Observation>> =
            list(params.toBuilder().regionCode(regionCode).build(), requestOptions)

        /** @see list */
        @MustBeClosed
        fun list(
            params: RecentListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<List<Observation>>

        /** @see list */
        @MustBeClosed
        fun list(
            regionCode: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<List<Observation>> =
            list(regionCode, RecentListParams.none(), requestOptions)
    }
}
