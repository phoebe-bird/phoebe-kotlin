// File generated from our OpenAPI spec by Stainless.

package com.phoebe.api.services.async.ref.region

import com.google.errorprone.annotations.MustBeClosed
import com.phoebe.api.core.RequestOptions
import com.phoebe.api.core.http.HttpResponseFor
import com.phoebe.api.models.ref.region.list.ListListParams
import com.phoebe.api.models.ref.region.list.ListListResponse

interface ListServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Get the list of sub-regions for a given country or region. #### Notes Not all combinations of
     * region type and region code are valid. You can fetch all the subnational1 or subnational2
     * regions for a country however you can only specify a region type of 'country' when using
     * 'world' as a region code.
     */
    suspend fun list(
        params: ListListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): List<ListListResponse>

    /** A view of [ListServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a raw HTTP response for `get /ref/region/list/{regionType}/{parentRegionCode}`,
         * but is otherwise the same as [ListServiceAsync.list].
         */
        @MustBeClosed
        suspend fun list(
            params: ListListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<List<ListListResponse>>
    }
}
