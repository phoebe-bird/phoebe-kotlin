// File generated from our OpenAPI spec by Stainless.

package com.phoebe.api.models.data.observations

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.phoebe.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ObservationTest {

    @Test
    fun create() {
        val observation =
            Observation.builder()
                .id(0L)
                .comName("comName")
                .firstname("firstname")
                .howMany(0L)
                .lastname("lastname")
                .lat(0.0)
                .lng(0.0)
                .locationPrivate(true)
                .locId("locId")
                .locName("locName")
                .obsDt("obsDt")
                .obsReviewed(true)
                .obsValid(true)
                .sciName("sciName")
                .speciesCode("speciesCode")
                .subId("subId")
                .build()

        assertThat(observation.id()).isEqualTo(0L)
        assertThat(observation.comName()).isEqualTo("comName")
        assertThat(observation.firstname()).isEqualTo("firstname")
        assertThat(observation.howMany()).isEqualTo(0L)
        assertThat(observation.lastname()).isEqualTo("lastname")
        assertThat(observation.lat()).isEqualTo(0.0)
        assertThat(observation.lng()).isEqualTo(0.0)
        assertThat(observation.locationPrivate()).isEqualTo(true)
        assertThat(observation.locId()).isEqualTo("locId")
        assertThat(observation.locName()).isEqualTo("locName")
        assertThat(observation.obsDt()).isEqualTo("obsDt")
        assertThat(observation.obsReviewed()).isEqualTo(true)
        assertThat(observation.obsValid()).isEqualTo(true)
        assertThat(observation.sciName()).isEqualTo("sciName")
        assertThat(observation.speciesCode()).isEqualTo("speciesCode")
        assertThat(observation.subId()).isEqualTo("subId")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val observation =
            Observation.builder()
                .id(0L)
                .comName("comName")
                .firstname("firstname")
                .howMany(0L)
                .lastname("lastname")
                .lat(0.0)
                .lng(0.0)
                .locationPrivate(true)
                .locId("locId")
                .locName("locName")
                .obsDt("obsDt")
                .obsReviewed(true)
                .obsValid(true)
                .sciName("sciName")
                .speciesCode("speciesCode")
                .subId("subId")
                .build()

        val roundtrippedObservation =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(observation),
                jacksonTypeRef<Observation>(),
            )

        assertThat(roundtrippedObservation).isEqualTo(observation)
    }
}
