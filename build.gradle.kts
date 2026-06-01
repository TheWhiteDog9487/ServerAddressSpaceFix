plugins {
    id("net.fabricmc.fabric-loom")
    `maven-publish`
}

version = providers.gradleProperty("mod_version").get()
group = providers.gradleProperty("maven_group").get()

repositories {
    // Add repositories to retrieve artifacts from in here.
    // You should only use this when depending on other mods because
    // Loom adds the essential maven repositories to download Minecraft and libraries from automatically.
    // See https://docs.gradle.org/current/userguide/declaring_repositories.html
    // for more information about repositories.
    maven {
        name = "Xander Maven"
        url = uri("https://maven.isxander.dev/releases") }
    maven {
        name = "Terraformers"
        url = uri("https://maven.terraformersmc.com/releases") }
    maven {
        name = "Nucleoid"
        url = uri("https://maven.nucleoid.xyz/") } }

loom {
    splitEnvironmentSourceSets()

    mods {
        register("serveraddressspacefix") {
            sourceSet(sourceSets.main.get())
            sourceSet(sourceSets.getByName("client"))
        }
    }
    accessWidenerPath = file("src/main/resources/serveraddressspacefix.classtweaker")
}

dependencies {
    // To change the versions see the gradle.properties file
    minecraft("com.mojang:minecraft:${providers.gradleProperty("minecraft_version").get()}")

    implementation("net.fabricmc:fabric-loader:${providers.gradleProperty("loader_version").get()}")

    // Fabric API. This is technically optional, but you probably want it anyway.
    implementation("net.fabricmc.fabric-api:fabric-api:${providers.gradleProperty("fabric_api_version").get()}")

    implementation("com.terraformersmc:modmenu:${providers.gradleProperty("modmenu_version").get()}")
    implementation("dev.isxander:yet-another-config-lib:${providers.gradleProperty("yacl_version").get()}")
}

tasks.processResources {
    val version = version
    inputs.property("version", version)

    filesMatching("fabric.mod.json") {
        expand("version" to version)
    }
}

tasks.withType<JavaCompile>().configureEach {
    options.release = 25
}

java {
    // Loom will automatically attach sourcesJar to a RemapSourcesJar task and to the "build" task
    // if it is present.
    // If you remove this line, sources will not be generated.
    withSourcesJar()

    sourceCompatibility = JavaVersion.VERSION_25
    targetCompatibility = JavaVersion.VERSION_25
}

tasks.jar {
    val projectName = project.name
    inputs.property("projectName", projectName)

    from("LICENSE") {
        rename { "${it}_$projectName" }
    }
    archiveFileName = "ServerAddressSpaceFix-${project.version} mc${providers.gradleProperty("compatible_with").get()}.jar"
}

tasks.named<Jar>("sourcesJar") {
    archiveFileName = "ServerAddressSpaceFix-${project.version} mc${providers.gradleProperty("compatible_with").get()}-sources.jar"}


// configure the maven publication
publishing {
    publications {
        register<MavenPublication>("mavenJava") {
            from(components["java"])
        }
    }

    // See https://docs.gradle.org/current/userguide/publishing_maven.html for information on how to set up publishing.
    repositories {
        // Add repositories to publish to here.
        // Notice: This block does NOT have the same function as the block in the top level.
        // The repositories here will be used for publishing your artifact, not for
        // retrieving dependencies.
    }
}