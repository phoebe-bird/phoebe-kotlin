plugins {
    id("phoebe.kotlin")
    application
}

dependencies {
    implementation(project(":phoebe-kotlin-core"))
    implementation(project(":phoebe-kotlin-client-okhttp"))
}

application {
    // Use `./gradlew :phoebe-kotlin-example:run` to run `Main`
    // Use `./gradlew :phoebe-kotlin-example:run -Pexample=Something` to run `SomethingExample`
    mainClass = "com.phoebe.api.example.${
        if (project.hasProperty("example"))
            "${project.property("example")}ExampleKt"
        else
            "MainKt"
    }"
}
