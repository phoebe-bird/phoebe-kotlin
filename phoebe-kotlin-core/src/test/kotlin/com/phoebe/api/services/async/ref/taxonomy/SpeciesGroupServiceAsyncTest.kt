// File generated from our OpenAPI spec by Stainless.

package com.phoebe.api.services.async.ref.taxonomy

import com.phoebe.api.TestServerExtension
import com.phoebe.api.client.okhttp.PhoebeOkHttpClientAsync
import com.phoebe.api.models.ref.taxonomy.speciesgroups.SpeciesGroupListParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class SpeciesGroupServiceAsyncTest {

    @Test
    suspend fun list() {
        val client =
            PhoebeOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val speciesGroupServiceAsync = client.ref().taxonomy().speciesGroups()

        val speciesGroups =
            speciesGroupServiceAsync.list(
                SpeciesGroupListParams.builder()
                    .speciesGrouping(SpeciesGroupListParams.SpeciesGrouping.MERLIN)
                    .groupNameLocale("groupNameLocale")
                    .build()
            )

        speciesGroups.forEach { it.validate() }
    }
}
