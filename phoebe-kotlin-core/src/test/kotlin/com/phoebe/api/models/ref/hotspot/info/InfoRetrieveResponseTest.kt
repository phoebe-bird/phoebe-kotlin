// File generated from our OpenAPI spec by Stainless.

package com.phoebe.api.models.ref.hotspot.info

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.phoebe.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class InfoRetrieveResponseTest {

    @Test
    fun create() {
        val infoRetrieveResponse =
            InfoRetrieveResponse.builder()
                .countryCode("countryCode")
                .countryName("countryName")
                .hierarchicalName("hierarchicalName")
                .isHotspot(true)
                .lat(0.0)
                .latitude(0.0)
                .lng(0.0)
                .locId("locId")
                .locName("locName")
                .longitude(0.0)
                .name("name")
                .subnational1Code("subnational1Code")
                .subnational1Name("subnational1Name")
                .build()

        assertThat(infoRetrieveResponse.countryCode()).isEqualTo("countryCode")
        assertThat(infoRetrieveResponse.countryName()).isEqualTo("countryName")
        assertThat(infoRetrieveResponse.hierarchicalName()).isEqualTo("hierarchicalName")
        assertThat(infoRetrieveResponse.isHotspot()).isEqualTo(true)
        assertThat(infoRetrieveResponse.lat()).isEqualTo(0.0)
        assertThat(infoRetrieveResponse.latitude()).isEqualTo(0.0)
        assertThat(infoRetrieveResponse.lng()).isEqualTo(0.0)
        assertThat(infoRetrieveResponse.locId()).isEqualTo("locId")
        assertThat(infoRetrieveResponse.locName()).isEqualTo("locName")
        assertThat(infoRetrieveResponse.longitude()).isEqualTo(0.0)
        assertThat(infoRetrieveResponse.name()).isEqualTo("name")
        assertThat(infoRetrieveResponse.subnational1Code()).isEqualTo("subnational1Code")
        assertThat(infoRetrieveResponse.subnational1Name()).isEqualTo("subnational1Name")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val infoRetrieveResponse =
            InfoRetrieveResponse.builder()
                .countryCode("countryCode")
                .countryName("countryName")
                .hierarchicalName("hierarchicalName")
                .isHotspot(true)
                .lat(0.0)
                .latitude(0.0)
                .lng(0.0)
                .locId("locId")
                .locName("locName")
                .longitude(0.0)
                .name("name")
                .subnational1Code("subnational1Code")
                .subnational1Name("subnational1Name")
                .build()

        val roundtrippedInfoRetrieveResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(infoRetrieveResponse),
                jacksonTypeRef<InfoRetrieveResponse>(),
            )

        assertThat(roundtrippedInfoRetrieveResponse).isEqualTo(infoRetrieveResponse)
    }
}
