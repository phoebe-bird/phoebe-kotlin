// File generated from our OpenAPI spec by Stainless.

package com.phoebe.api.models.ref.taxonomy.speciesgroups

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.phoebe.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SpeciesGroupListResponseTest {

    @Test
    fun create() {
        val speciesGroupListResponse =
            SpeciesGroupListResponse.builder()
                .groupName("Waterfowl")
                .groupOrder(1L)
                .taxonOrderBounds(
                    listOf(
                        listOf(211.0f, 579.0f),
                        listOf(1968.0f, 2063.0f),
                        listOf(16549.0f, 16613.0f),
                    )
                )
                .build()

        assertThat(speciesGroupListResponse.groupName()).isEqualTo("Waterfowl")
        assertThat(speciesGroupListResponse.groupOrder()).isEqualTo(1L)
        assertThat(speciesGroupListResponse.taxonOrderBounds())
            .containsExactly(
                listOf(211.0f, 579.0f),
                listOf(1968.0f, 2063.0f),
                listOf(16549.0f, 16613.0f),
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val speciesGroupListResponse =
            SpeciesGroupListResponse.builder()
                .groupName("Waterfowl")
                .groupOrder(1L)
                .taxonOrderBounds(
                    listOf(
                        listOf(211.0f, 579.0f),
                        listOf(1968.0f, 2063.0f),
                        listOf(16549.0f, 16613.0f),
                    )
                )
                .build()

        val roundtrippedSpeciesGroupListResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(speciesGroupListResponse),
                jacksonTypeRef<SpeciesGroupListResponse>(),
            )

        assertThat(roundtrippedSpeciesGroupListResponse).isEqualTo(speciesGroupListResponse)
    }
}
