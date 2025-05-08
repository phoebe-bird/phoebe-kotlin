// File generated from our OpenAPI spec by Stainless.

package com.phoebe.api.services.async.ref

import com.google.errorprone.annotations.MustBeClosed
import com.phoebe.api.core.RequestOptions
import com.phoebe.api.core.http.HttpResponseFor
import com.phoebe.api.models.ref.hotspot.HotspotListParams
import com.phoebe.api.models.ref.hotspot.HotspotListResponse
import com.phoebe.api.services.async.ref.hotspot.GeoServiceAsync
import com.phoebe.api.services.async.ref.hotspot.InfoServiceAsync

interface HotspotServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    fun geo(): GeoServiceAsync

    fun info(): InfoServiceAsync

    /** Hotspots in a region */
    suspend fun list(
        params: HotspotListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): List<HotspotListResponse>

    /**
     * A view of [HotspotServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        fun geo(): GeoServiceAsync.WithRawResponse

        fun info(): InfoServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /ref/hotspot/{regionCode}`, but is otherwise the
         * same as [HotspotServiceAsync.list].
         */
        @MustBeClosed
        suspend fun list(
            params: HotspotListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<List<HotspotListResponse>>
    }
}
