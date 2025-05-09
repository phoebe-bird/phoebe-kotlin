// File generated from our OpenAPI spec by Stainless.

package com.phoebe.api.models.product.top100

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.phoebe.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class Top100RetrieveResponseTest {

    @Test
    fun create() {
        val top100RetrieveResponse =
            Top100RetrieveResponse.builder()
                .numCompleteChecklists(0)
                .numSpecies(0)
                .profileHandle("profileHandle")
                .rowNum(0)
                .userDisplayName("userDisplayName")
                .userId("userId")
                .build()

        assertThat(top100RetrieveResponse.numCompleteChecklists()).isEqualTo(0)
        assertThat(top100RetrieveResponse.numSpecies()).isEqualTo(0)
        assertThat(top100RetrieveResponse.profileHandle()).isEqualTo("profileHandle")
        assertThat(top100RetrieveResponse.rowNum()).isEqualTo(0)
        assertThat(top100RetrieveResponse.userDisplayName()).isEqualTo("userDisplayName")
        assertThat(top100RetrieveResponse.userId()).isEqualTo("userId")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val top100RetrieveResponse =
            Top100RetrieveResponse.builder()
                .numCompleteChecklists(0)
                .numSpecies(0)
                .profileHandle("profileHandle")
                .rowNum(0)
                .userDisplayName("userDisplayName")
                .userId("userId")
                .build()

        val roundtrippedTop100RetrieveResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(top100RetrieveResponse),
                jacksonTypeRef<Top100RetrieveResponse>(),
            )

        assertThat(roundtrippedTop100RetrieveResponse).isEqualTo(top100RetrieveResponse)
    }
}
