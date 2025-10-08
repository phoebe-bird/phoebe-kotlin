// File generated from our OpenAPI spec by Stainless.

package com.phoebe.api.services.async.product

import com.google.errorprone.annotations.MustBeClosed
import com.phoebe.api.core.ClientOptions
import com.phoebe.api.core.RequestOptions
import com.phoebe.api.core.http.HttpResponseFor
import com.phoebe.api.models.product.checklist.ChecklistViewParams
import com.phoebe.api.models.product.checklist.ChecklistViewResponse

interface ChecklistServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: (ClientOptions.Builder) -> Unit): ChecklistServiceAsync

    /**
     * Get the details and observations of a checklist.
     *
     * #### Notes Do NOT use this to download large amounts of data. You will be banned if you do.
     * In the fields for each observation, the following fields are duplicates or obsolete and will
     * be removed at a future date: *howManyAtleast*, *howManyAtmost*, *hideFlags*, *projId*,
     * *subId*, *subnational1Code* and *present*.
     */
    suspend fun view(
        subId: String,
        params: ChecklistViewParams = ChecklistViewParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ChecklistViewResponse = view(params.toBuilder().subId(subId).build(), requestOptions)

    /** @see view */
    suspend fun view(
        params: ChecklistViewParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ChecklistViewResponse

    /** @see view */
    suspend fun view(subId: String, requestOptions: RequestOptions): ChecklistViewResponse =
        view(subId, ChecklistViewParams.none(), requestOptions)

    /**
     * A view of [ChecklistServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: (ClientOptions.Builder) -> Unit
        ): ChecklistServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /product/checklist/view/{subId}`, but is otherwise
         * the same as [ChecklistServiceAsync.view].
         */
        @MustBeClosed
        suspend fun view(
            subId: String,
            params: ChecklistViewParams = ChecklistViewParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ChecklistViewResponse> =
            view(params.toBuilder().subId(subId).build(), requestOptions)

        /** @see view */
        @MustBeClosed
        suspend fun view(
            params: ChecklistViewParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ChecklistViewResponse>

        /** @see view */
        @MustBeClosed
        suspend fun view(
            subId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ChecklistViewResponse> =
            view(subId, ChecklistViewParams.none(), requestOptions)
    }
}
