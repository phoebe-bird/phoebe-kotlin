plugins {
    id("phoebe.kotlin")
    application
}

dependencies {
    implementation(project(":phoebe-kotlin"))
}

application {
    mainClass = "com.phoebe.api.example.MainKt"
}
