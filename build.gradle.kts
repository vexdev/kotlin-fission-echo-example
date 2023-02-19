plugins {
    kotlin("multiplatform") version "1.8.0"
}

group = "me.lucavitucci"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    mavenLocal()
}

kotlin {
    val hostOs = System.getProperty("os.name")
    val nativeTarget = linuxX64("native")

    nativeTarget.apply {
        binaries {
            executable {
                entryPoint = "main"
            }
        }
    }
    sourceSets {
        val nativeMain by getting {
            dependencies {
                implementation("com.vexdev:kotlin-fission:1.0.0")
            }
        }
        val nativeTest by getting
    }
}
