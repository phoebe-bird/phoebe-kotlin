// File generated from our OpenAPI spec by Stainless.

package com.phoebe.api.services.async.data

import com.phoebe.api.core.ClientOptions
import com.phoebe.api.services.async.data.observations.GeoServiceAsync
import com.phoebe.api.services.async.data.observations.NearestServiceAsync
import com.phoebe.api.services.async.data.observations.RecentServiceAsync

interface ObservationServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: (ClientOptions.Builder) -> Unit): ObservationServiceAsync

    fun recent(): RecentServiceAsync

    fun geo(): GeoServiceAsync

    fun nearest(): NearestServiceAsync

    /**
     * A view of [ObservationServiceAsync] that provides access to raw HTTP responses for each
     * method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: (ClientOptions.Builder) -> Unit
        ): ObservationServiceAsync.WithRawResponse

        fun recent(): RecentServiceAsync.WithRawResponse

        fun geo(): GeoServiceAsync.WithRawResponse

        fun nearest(): NearestServiceAsync.WithRawResponse
    }
}
