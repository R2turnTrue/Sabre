import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    // Apply the Kotlin JVM plugin to add support for Kotlin.
    id("org.jetbrains.kotlin.jvm") version "1.5.31"
    kotlin("plugin.serialization") version "1.5.31"
    id("com.github.johnrengelman.shadow") version "7.0.0"

    // Apply the application plugin to add support for building a jar
    java
}

repositories {
    // maven central
    mavenCentral()

    maven(url = "https://repo.spongepowered.org/maven")
    maven(url = "https://jitpack.io")
    maven(url = "https://repo.velocitypowered.com/snapshots")
    maven(url = "https://repo.minestom.com/repository/maven-public/")
}

dependencies {
    // Align versions of all Kotlin components
    implementation(platform("org.jetbrains.kotlin:kotlin-bom"))

    // Use the Kotlin JDK 8 standard library.
    implementation(kotlin("stdlib"))

    // Use the Kotlin reflect library.
    implementation(kotlin("reflect"))

    // Add support for kotlinx courotines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.2")

    // import kotlinx serialization
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.2.2")

    // Use the JUpiter test library.
    testImplementation("org.junit.jupiter:junit-jupiter:5.8.0")

    // Compile Minestom into project
    implementation("com.github.Minestom", "Minestom", "872a49d371")

    implementation("org.apache.logging.log4j:log4j-jul:2.14.1")

    // JLine
    implementation("org.jline:jline:3.20.0")

    // TerminalConsoleAppender
    implementation("net.minecrell:terminalconsoleappender:1.3.0")

    // Jansi
    implementation("org.jline:jline-terminal-jansi:3.20.0")
}

tasks {
    named<ShadowJar>("shadowJar") {
        manifest {
            attributes (
                    "Main-Class" to "world.cepi.sabre.SabreLoader",
                    "Multi-Release" to true
            )
        }

        transform(com.github.jengelman.gradle.plugins.shadow.transformers.Log4j2PluginsCacheFileTransformer::class.java)

        mergeServiceFiles()

        archiveBaseName.set("sabre")
    }

    test { useJUnitPlatform() }

    build { dependsOn(shadowJar) }

    withType<AbstractArchiveTask> {
        isPreserveFileTimestamps = false
        isReproducibleFileOrder = true
    }

}

configure<SourceSetContainer> {
    named("main") {
        java.srcDir("src/main/kotlin")
    }
}

java {
    sourceCompatibility = JavaVersion.VERSION_16
    targetCompatibility = JavaVersion.VERSION_16
}

configurations.all {
    resolutionStrategy {
        cacheChangingModulesFor(0, TimeUnit.SECONDS)
    }
}

tasks.withType<KotlinCompile> { kotlinOptions.jvmTarget = "16" }

sourceSets.create("demo") {
    java.srcDir("src/demo/java")
    java.srcDir("build/generated/source/apt/demo")
    resources.srcDir("src/demo/resources")
    compileClasspath += sourceSets.main.get().output + sourceSets.main.get().compileClasspath
    runtimeClasspath += sourceSets.main.get().output + sourceSets.main.get().runtimeClasspath
}