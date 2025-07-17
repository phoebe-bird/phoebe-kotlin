plugins {
    id("phoebe.kotlin")
    application
}

dependencies {
    implementation(project(":phoebe-kotlin"))
}

application {
    // Use `./gradlew :phoebe-kotlin-example:run` to run `Main`
    // Use `./gradlew :phoebe-kotlin-example:run -Dexample=Something` to run `SomethingExample`
    mainClass = "com.phoebe.api.example.${
        if (project.hasProperty("example"))
            "${project.property("example")}ExampleKt"
        else
            "MainKt"
    }"
}
