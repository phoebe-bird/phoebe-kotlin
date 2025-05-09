// File generated from our OpenAPI spec by Stainless.

package com.phoebe.api.models.ref.taxonomy.ebird

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.phoebe.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class EbirdRetrieveResponseTest {

    @Test
    fun create() {
        val ebirdRetrieveResponse =
            EbirdRetrieveResponse.builder()
                .addBandingCode("string")
                .category("category")
                .comName("comName")
                .addComNameCode("string")
                .familyCode("familyCode")
                .familyComName("familyComName")
                .familySciName("familySciName")
                .order("order")
                .sciName("sciName")
                .addSciNameCode("string")
                .speciesCode("speciesCode")
                .taxonOrder(0)
                .build()

        assertThat(ebirdRetrieveResponse.bandingCodes()).containsExactly("string")
        assertThat(ebirdRetrieveResponse.category()).isEqualTo("category")
        assertThat(ebirdRetrieveResponse.comName()).isEqualTo("comName")
        assertThat(ebirdRetrieveResponse.comNameCodes()).containsExactly("string")
        assertThat(ebirdRetrieveResponse.familyCode()).isEqualTo("familyCode")
        assertThat(ebirdRetrieveResponse.familyComName()).isEqualTo("familyComName")
        assertThat(ebirdRetrieveResponse.familySciName()).isEqualTo("familySciName")
        assertThat(ebirdRetrieveResponse.order()).isEqualTo("order")
        assertThat(ebirdRetrieveResponse.sciName()).isEqualTo("sciName")
        assertThat(ebirdRetrieveResponse.sciNameCodes()).containsExactly("string")
        assertThat(ebirdRetrieveResponse.speciesCode()).isEqualTo("speciesCode")
        assertThat(ebirdRetrieveResponse.taxonOrder()).isEqualTo(0)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val ebirdRetrieveResponse =
            EbirdRetrieveResponse.builder()
                .addBandingCode("string")
                .category("category")
                .comName("comName")
                .addComNameCode("string")
                .familyCode("familyCode")
                .familyComName("familyComName")
                .familySciName("familySciName")
                .order("order")
                .sciName("sciName")
                .addSciNameCode("string")
                .speciesCode("speciesCode")
                .taxonOrder(0)
                .build()

        val roundtrippedEbirdRetrieveResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(ebirdRetrieveResponse),
                jacksonTypeRef<EbirdRetrieveResponse>(),
            )

        assertThat(roundtrippedEbirdRetrieveResponse).isEqualTo(ebirdRetrieveResponse)
    }
}
