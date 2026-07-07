plugins {
    id("java")
}

version = "1.0-SNAPSHOT"

group = "ru.raiffeisen.fi"

java {
    sourceCompatibility = JavaVersion.VERSION_17
}
repositories {
    maven {
        url = uri("https://artifactory.raiffeisen.ru/artifactory/repo1")
        credentials {
            username = project.findProperty("artifactoryUser") as String
            password = project.findProperty("artifactoryPassword") as String
        }
    }
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter:5.11.0")
}

tasks.test {
    useJUnitPlatform()
}