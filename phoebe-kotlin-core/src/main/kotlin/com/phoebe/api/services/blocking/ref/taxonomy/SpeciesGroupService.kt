// File generated from our OpenAPI spec by Stainless.

package com.phoebe.api.services.blocking.ref.taxonomy

import com.google.errorprone.annotations.MustBeClosed
import com.phoebe.api.core.ClientOptions
import com.phoebe.api.core.RequestOptions
import com.phoebe.api.core.http.HttpResponseFor
import com.phoebe.api.models.ref.taxonomy.speciesgroups.SpeciesGroupListParams
import com.phoebe.api.models.ref.taxonomy.speciesgroups.SpeciesGroupListResponse

interface SpeciesGroupService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: (ClientOptions.Builder) -> Unit): SpeciesGroupService

    /**
     * Get the list of species groups, e.g. terns, finches, etc. #### Notes Merlin puts like birds
     * together, with Falcons next to Hawks, whereas eBird follows taxonomic order.
     */
    fun list(
        speciesGrouping: SpeciesGroupListParams.SpeciesGrouping,
        params: SpeciesGroupListParams = SpeciesGroupListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): List<SpeciesGroupListResponse> =
        list(params.toBuilder().speciesGrouping(speciesGrouping).build(), requestOptions)

    /** @see [list] */
    fun list(
        params: SpeciesGroupListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): List<SpeciesGroupListResponse>

    /** @see [list] */
    fun list(
        speciesGrouping: SpeciesGroupListParams.SpeciesGrouping,
        requestOptions: RequestOptions,
    ): List<SpeciesGroupListResponse> =
        list(speciesGrouping, SpeciesGroupListParams.none(), requestOptions)

    /**
     * A view of [SpeciesGroupService] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: (ClientOptions.Builder) -> Unit
        ): SpeciesGroupService.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /ref/sppgroup/{speciesGrouping}`, but is otherwise
         * the same as [SpeciesGroupService.list].
         */
        @MustBeClosed
        fun list(
            speciesGrouping: SpeciesGroupListParams.SpeciesGrouping,
            params: SpeciesGroupListParams = SpeciesGroupListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<List<SpeciesGroupListResponse>> =
            list(params.toBuilder().speciesGrouping(speciesGrouping).build(), requestOptions)

        /** @see [list] */
        @MustBeClosed
        fun list(
            params: SpeciesGroupListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<List<SpeciesGroupListResponse>>

        /** @see [list] */
        @MustBeClosed
        fun list(
            speciesGrouping: SpeciesGroupListParams.SpeciesGrouping,
            requestOptions: RequestOptions,
        ): HttpResponseFor<List<SpeciesGroupListResponse>> =
            list(speciesGrouping, SpeciesGroupListParams.none(), requestOptions)
    }
}
