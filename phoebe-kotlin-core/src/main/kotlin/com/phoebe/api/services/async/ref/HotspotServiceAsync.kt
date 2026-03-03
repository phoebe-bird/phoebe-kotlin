// File generated from our OpenAPI spec by Stainless.

package com.phoebe.api.services.async.ref

import com.google.errorprone.annotations.MustBeClosed
import com.phoebe.api.core.ClientOptions
import com.phoebe.api.core.RequestOptions
import com.phoebe.api.core.http.HttpResponseFor
import com.phoebe.api.models.ref.hotspot.HotspotListParams
import com.phoebe.api.models.ref.hotspot.HotspotListResponse
import com.phoebe.api.services.async.ref.hotspot.GeoServiceAsync
import com.phoebe.api.services.async.ref.hotspot.InfoServiceAsync

/**
 * With the ref/hotspot end-points you can find the hotspots for a given country or region or nearby
 * hotspots
 */
interface HotspotServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: (ClientOptions.Builder) -> Unit): HotspotServiceAsync

    /**
     * With the ref/hotspot end-points you can find the hotspots for a given country or region or
     * nearby hotspots
     */
    fun geo(): GeoServiceAsync

    /**
     * With the ref/hotspot end-points you can find the hotspots for a given country or region or
     * nearby hotspots
     */
    fun info(): InfoServiceAsync

    /** Hotspots in a region */
    suspend fun list(
        regionCode: String,
        params: HotspotListParams = HotspotListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): List<HotspotListResponse> =
        list(params.toBuilder().regionCode(regionCode).build(), requestOptions)

    /** @see list */
    suspend fun list(
        params: HotspotListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): List<HotspotListResponse>

    /** @see list */
    suspend fun list(
        regionCode: String,
        requestOptions: RequestOptions,
    ): List<HotspotListResponse> = list(regionCode, HotspotListParams.none(), requestOptions)

    /**
     * A view of [HotspotServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: (ClientOptions.Builder) -> Unit
        ): HotspotServiceAsync.WithRawResponse

        /**
         * With the ref/hotspot end-points you can find the hotspots for a given country or region
         * or nearby hotspots
         */
        fun geo(): GeoServiceAsync.WithRawResponse

        /**
         * With the ref/hotspot end-points you can find the hotspots for a given country or region
         * or nearby hotspots
         */
        fun info(): InfoServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /ref/hotspot/{regionCode}`, but is otherwise the
         * same as [HotspotServiceAsync.list].
         */
        @MustBeClosed
        suspend fun list(
            regionCode: String,
            params: HotspotListParams = HotspotListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<List<HotspotListResponse>> =
            list(params.toBuilder().regionCode(regionCode).build(), requestOptions)

        /** @see list */
        @MustBeClosed
        suspend fun list(
            params: HotspotListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<List<HotspotListResponse>>

        /** @see list */
        @MustBeClosed
        suspend fun list(
            regionCode: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<List<HotspotListResponse>> =
            list(regionCode, HotspotListParams.none(), requestOptions)
    }
}
