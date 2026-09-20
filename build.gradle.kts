plugins {
    id("java")
    id("io.spring.dependency-management") version "1.1.0"
    id("org.springframework.boot") version "3.1.1"
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
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation ("org.springframework.boot:spring-boot-starter-web")
}

tasks.test {
    useJUnitPlatform()
}