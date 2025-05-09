// File generated from our OpenAPI spec by Stainless.

package com.phoebe.api.models.ref.hotspot.geo

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.phoebe.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class GeoRetrieveResponseTest {

    @Test
    fun create() {
        val geoRetrieveResponse =
            GeoRetrieveResponse.builder()
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

        assertThat(geoRetrieveResponse.countryCode()).isEqualTo("countryCode")
        assertThat(geoRetrieveResponse.lat()).isEqualTo(0.0)
        assertThat(geoRetrieveResponse.latestObsDt()).isEqualTo("latestObsDt")
        assertThat(geoRetrieveResponse.lng()).isEqualTo(0.0)
        assertThat(geoRetrieveResponse.locId()).isEqualTo("locId")
        assertThat(geoRetrieveResponse.locName()).isEqualTo("locName")
        assertThat(geoRetrieveResponse.numSpeciesAllTime()).isEqualTo(0)
        assertThat(geoRetrieveResponse.subnational1Code()).isEqualTo("subnational1Code")
        assertThat(geoRetrieveResponse.subnational2Code()).isEqualTo("subnational2Code")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val geoRetrieveResponse =
            GeoRetrieveResponse.builder()
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

        val roundtrippedGeoRetrieveResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(geoRetrieveResponse),
                jacksonTypeRef<GeoRetrieveResponse>(),
            )

        assertThat(roundtrippedGeoRetrieveResponse).isEqualTo(geoRetrieveResponse)
    }
}
