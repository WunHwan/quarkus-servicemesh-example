description = "base on servicemesh of quarkus example project."

plugins {
    java
    id("io.quarkus")
}

val quarkusPlatformGroupId: String by project
val quarkusPlatformArtifactId: String by project
val quarkusPlatformVersion: String by project

allprojects {
    group = "com.wunhwan.quarkus"
    version = "2022.05.1"

    extra.apply {
        set("Version.quarkus", quarkusPlatformVersion)
    }
}

subprojects {
    apply(plugin = "java-library")

    configure<JavaPluginExtension> {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    repositories {
        mavenLocal()
        maven(url = "https://maven.aliyun.com/repository/public")
        mavenCentral()
    }

    dependencies {
        implementation(enforcedPlatform("${quarkusPlatformGroupId}:${quarkusPlatformArtifactId}:${quarkusPlatformVersion}"))
    }

    configurations.all {
        resolutionStrategy {
            // make fail when dependency version conflict
            failOnVersionConflict()
        }
    }

    tasks.withType<JavaCompile> {
        options.encoding = "UTF-8"
        options.compilerArgs.add("-parameters")
    }

    tasks.withType<GenerateModuleMetadata> {
        enabled = false
    }

    tasks.withType<Test> {
        testLogging.showExceptions = true

        useJUnitPlatform()
    }
}