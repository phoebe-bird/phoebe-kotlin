// File generated from our OpenAPI spec by Stainless.

package com.phoebe.api.services.async.ref.region

import com.google.errorprone.annotations.MustBeClosed
import com.phoebe.api.core.RequestOptions
import com.phoebe.api.core.http.HttpResponseFor
import com.phoebe.api.models.ref.region.info.InfoRetrieveParams
import com.phoebe.api.models.ref.region.info.InfoRetrieveResponse

interface InfoServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Get information on the name and geographical area covered by a region.
     *
     * #### Notes
     *
     * Taking Madison County, New York, USA (location code US-NY-053) as an example the various
     * values for the regionNameFormat query parameter work as follows:
     *
     * |Value         |Description                               |Result                          |
     * |--------------|------------------------------------------|--------------------------------|
     * |detailed      |return a detailed description             |Madison County, New York, US    |
     * |detailednoqual|return the name to the subnational1 level |Madison, New York               |
     * |full          |return the full description               |Madison, New York, United States|
     * |namequal      |return the qualified name                 |Madison County                  |
     * |nameonly      |return only the name of the region        |Madison                         |
     * |revdetailed   |return the detailed description in reverse|US, New York, Madison County    |
     */
    suspend fun retrieve(
        regionCode: String,
        params: InfoRetrieveParams = InfoRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): InfoRetrieveResponse =
        retrieve(params.toBuilder().regionCode(regionCode).build(), requestOptions)

    /** @see [retrieve] */
    suspend fun retrieve(
        params: InfoRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): InfoRetrieveResponse

    /** @see [retrieve] */
    suspend fun retrieve(regionCode: String, requestOptions: RequestOptions): InfoRetrieveResponse =
        retrieve(regionCode, InfoRetrieveParams.none(), requestOptions)

    /** A view of [InfoServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a raw HTTP response for `get /ref/region/info/{regionCode}`, but is otherwise the
         * same as [InfoServiceAsync.retrieve].
         */
        @MustBeClosed
        suspend fun retrieve(
            regionCode: String,
            params: InfoRetrieveParams = InfoRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<InfoRetrieveResponse> =
            retrieve(params.toBuilder().regionCode(regionCode).build(), requestOptions)

        /** @see [retrieve] */
        @MustBeClosed
        suspend fun retrieve(
            params: InfoRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<InfoRetrieveResponse>

        /** @see [retrieve] */
        @MustBeClosed
        suspend fun retrieve(
            regionCode: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<InfoRetrieveResponse> =
            retrieve(regionCode, InfoRetrieveParams.none(), requestOptions)
    }
}
