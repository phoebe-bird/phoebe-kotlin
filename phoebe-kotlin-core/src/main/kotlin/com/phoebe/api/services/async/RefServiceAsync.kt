// File generated from our OpenAPI spec by Stainless.

package com.phoebe.api.services.async

import com.phoebe.api.core.ClientOptions
import com.phoebe.api.services.async.ref.HotspotServiceAsync
import com.phoebe.api.services.async.ref.RegionServiceAsync
import com.phoebe.api.services.async.ref.TaxonomyServiceAsync

interface RefServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: (ClientOptions.Builder) -> Unit): RefServiceAsync

    fun region(): RegionServiceAsync

    fun hotspot(): HotspotServiceAsync

    fun taxonomy(): TaxonomyServiceAsync

    /** A view of [RefServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: (ClientOptions.Builder) -> Unit): RefServiceAsync.WithRawResponse

        fun region(): RegionServiceAsync.WithRawResponse

        fun hotspot(): HotspotServiceAsync.WithRawResponse

        fun taxonomy(): TaxonomyServiceAsync.WithRawResponse
    }
}
