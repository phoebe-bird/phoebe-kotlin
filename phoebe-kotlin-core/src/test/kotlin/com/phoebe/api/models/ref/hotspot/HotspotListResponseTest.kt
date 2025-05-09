// File generated from our OpenAPI spec by Stainless.

package com.phoebe.api.models.ref.hotspot

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.phoebe.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class HotspotListResponseTest {

    @Test
    fun create() {
        val hotspotListResponse =
            HotspotListResponse.builder()
                .countryCode("countryCode")
                .lat(0.0)
                .latestObsDt("latestObsDt")
                .lng(0.0)
                .locId("locId")
                .locName("locName")
                .numSpeciesAllTime(0)
                .subnational1Code("subnational1Code")
                .subnational2Code("subnational2Code")
                .build()

        assertThat(hotspotListResponse.countryCode()).isEqualTo("countryCode")
        assertThat(hotspotListResponse.lat()).isEqualTo(0.0)
        assertThat(hotspotListResponse.latestObsDt()).isEqualTo("latestObsDt")
        assertThat(hotspotListResponse.lng()).isEqualTo(0.0)
        assertThat(hotspotListResponse.locId()).isEqualTo("locId")
        assertThat(hotspotListResponse.locName()).isEqualTo("locName")
        assertThat(hotspotListResponse.numSpeciesAllTime()).isEqualTo(0)
        assertThat(hotspotListResponse.subnational1Code()).isEqualTo("subnational1Code")
        assertThat(hotspotListResponse.subnational2Code()).isEqualTo("subnational2Code")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val hotspotListResponse =
            HotspotListResponse.builder()
                .countryCode("countryCode")
                .lat(0.0)
                .latestObsDt("latestObsDt")
                .lng(0.0)
                .locId("locId")
                .locName("locName")
                .numSpeciesAllTime(0)
                .subnational1Code("subnational1Code")
                .subnational2Code("subnational2Code")
                .build()

        val roundtrippedHotspotListResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(hotspotListResponse),
                jacksonTypeRef<HotspotListResponse>(),
            )

        assertThat(roundtrippedHotspotListResponse).isEqualTo(hotspotListResponse)
    }
}
