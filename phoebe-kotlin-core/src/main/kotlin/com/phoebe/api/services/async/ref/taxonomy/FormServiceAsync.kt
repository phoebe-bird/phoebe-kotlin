// File generated from our OpenAPI spec by Stainless.

package com.phoebe.api.services.async.ref.taxonomy

import com.google.errorprone.annotations.MustBeClosed
import com.phoebe.api.core.ClientOptions
import com.phoebe.api.core.RequestOptions
import com.phoebe.api.core.http.HttpResponseFor
import com.phoebe.api.models.ref.taxonomy.forms.FormListParams

interface FormServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: (ClientOptions.Builder) -> Unit): FormServiceAsync

    /**
     * For a species, get the list of subspecies recognised in the taxonomy. The results include the
     * species that was passed in.
     */
    suspend fun list(
        speciesCode: String,
        params: FormListParams = FormListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): List<String> = list(params.toBuilder().speciesCode(speciesCode).build(), requestOptions)

    /** @see [list] */
    suspend fun list(
        params: FormListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): List<String>

    /** @see [list] */
    suspend fun list(speciesCode: String, requestOptions: RequestOptions): List<String> =
        list(speciesCode, FormListParams.none(), requestOptions)

    /** A view of [FormServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: (ClientOptions.Builder) -> Unit): FormServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /ref/taxon/forms/{speciesCode}`, but is otherwise
         * the same as [FormServiceAsync.list].
         */
        @MustBeClosed
        suspend fun list(
            speciesCode: String,
            params: FormListParams = FormListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<List<String>> =
            list(params.toBuilder().speciesCode(speciesCode).build(), requestOptions)

        /** @see [list] */
        @MustBeClosed
        suspend fun list(
            params: FormListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<List<String>>

        /** @see [list] */
        @MustBeClosed
        suspend fun list(
            speciesCode: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<List<String>> = list(speciesCode, FormListParams.none(), requestOptions)
    }
}
