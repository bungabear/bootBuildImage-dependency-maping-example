import org.gradle.nativeplatform.platform.internal.DefaultNativePlatform
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "3.0.2"
    id("io.spring.dependency-management") version "1.1.0"
    kotlin("jvm") version "1.7.22"
    kotlin("plugin.spring") version "1.7.22"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "17"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}



fun getBindingPath() : String {
    val p = "${getAbsolutePath()}/docker/bindings"
    logger.error(p)
    return p
}

fun getAbsolutePath(): String {
    val os = DefaultNativePlatform.getCurrentOperatingSystem()
    if(os.isWindows){
        return "cmd /c cd".runCommand()
    }
    else {
        return "pwd".runCommand()
    }
}

fun String.runCommand(workingDir: File = file("./")): String {
    val parts = this.split("\\s".toRegex())
    val proc = ProcessBuilder(*parts.toTypedArray())
        .directory(workingDir)
        .redirectOutput(ProcessBuilder.Redirect.PIPE)
        .redirectError(ProcessBuilder.Redirect.PIPE)
        .start()

    proc.waitFor(1, TimeUnit.MINUTES)
    return proc.inputStream.bufferedReader().readText().trim()
}

tasks.bootBuildImage {
//    spring boot >= 3.0
    runImage.set("paketobuildpacks/run@sha256:68810b51eea5f7c7f7f5d106b50a2bedde112ce029af004f5e873280fe68d92f")
    builder.set("paketobuildpacks/builder@sha256:3d431026a28afdfefc20ecf16d54b0ff1a280c4ae8cc6da10c21ea7e01624473")
    bindings.add("${getBindingPath()}:/platform/bindings")

//    spring boot < 3.0
//    runImage = "paketobuildpacks/run@sha256:68810b51eea5f7c7f7f5d106b50a2bedde112ce029af004f5e873280fe68d92f"
//    builder = "paketobuildpacks/builder@sha256:3d431026a28afdfefc20ecf16d54b0ff1a280c4ae8cc6da10c21ea7e01624473"
//    binding("${getBindingPath()}:/platform/bindings")
}
