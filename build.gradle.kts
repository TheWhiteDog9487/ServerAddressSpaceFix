plugins {
    id("net.fabricmc.fabric-loom") version "1.15-SNAPSHOT"
    id("maven-publish")
}

version = project.extra["mod_version"] as String
group = project.extra["maven_group"] as String

base {
    archivesName.set(project.extra["archives_base_name"] as String)
}

repositories {
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
        create("twd-sasf") {
            sourceSet(sourceSets["main"])
            sourceSet(sourceSets["client"])
        }
    }

    accessWidenerPath = file("src/main/resources/twd-sasf.classtweaker")
}

dependencies {
    // To change the versions see the gradle.properties file
    minecraft("com.mojang:minecraft:${project.extra["minecraft_version"]}")
    implementation("net.fabricmc:fabric-loader:${project.extra["loader_version"]}")

    // Fabric API. This is technically optional, but you probably want it anyway.
    implementation("net.fabricmc.fabric-api:fabric-api:${project.extra["fabric_api_version"]}")

    // Uncomment the following line to enable the deprecated Fabric API modules. 
    // These are included in the Fabric API production distribution and allow you to update your mod to the latest modules at a later more convenient time.
    // "modImplementation"("net.fabricmc.fabric-api:fabric-api-deprecated:${project.extra["fabric_version"]}")

    implementation("com.terraformersmc:modmenu:${project.extra["modmenu_version"]}")
    implementation("dev.isxander:yet-another-config-lib:${project.extra["yacl_version"]}")
}

tasks.processResources {
    inputs.property("version", project.version)
    filesMatching("fabric.mod.json") {
        expand("version" to project.version)
    }
}

tasks.withType<JavaCompile> {
    options.release.set(25)
}

java {
    withSourcesJar()
    sourceCompatibility = JavaVersion.VERSION_25
    targetCompatibility = JavaVersion.VERSION_25
}

tasks.jar {
    from("LICENSE") {
        rename { "${it}_${project.base.archivesName.get()}" } }

    // https://docs.gradle.org/current/dsl/org.gradle.api.tasks.bundling.Jar.html#org.gradle.api.tasks.bundling.Jar:archiveFileName
    archiveFileName = "${project.base.archivesName.get()}-${project.version} mc${project.extra["compatible_with"]}.jar"}

tasks.named<Jar>("sourcesJar") {
    archiveFileName = "${project.base.archivesName.get()}-${project.version} mc${project.extra["compatible_with"]}-sources.jar"}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            from(components["java"])
        }
    }

    repositories {
        // Add repositories to publish to here.
        // Notice: This block does NOT have the same function as the block in the top level.
        // The repositories here will be used for publishing your artifact, not for retrieving dependencies.
    }
}