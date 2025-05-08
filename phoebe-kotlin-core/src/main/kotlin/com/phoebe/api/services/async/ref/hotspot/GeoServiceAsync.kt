// File generated from our OpenAPI spec by Stainless.

package com.phoebe.api.services.async.ref.hotspot

import com.google.errorprone.annotations.MustBeClosed
import com.phoebe.api.core.RequestOptions
import com.phoebe.api.core.http.HttpResponseFor
import com.phoebe.api.models.ref.hotspot.geo.GeoRetrieveParams
import com.phoebe.api.models.ref.hotspot.geo.GeoRetrieveResponse

interface GeoServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Get the list of hotspots, within a radius of up to 50 kilometers, from a given set of
     * coordinates.
     */
    suspend fun retrieve(
        params: GeoRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): List<GeoRetrieveResponse>

    /** A view of [GeoServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a raw HTTP response for `get /ref/hotspot/geo`, but is otherwise the same as
         * [GeoServiceAsync.retrieve].
         */
        @MustBeClosed
        suspend fun retrieve(
            params: GeoRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<List<GeoRetrieveResponse>>
    }
}
