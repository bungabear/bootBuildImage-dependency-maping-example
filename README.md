# Spring Boot BootBuildImage Dependency-Mapping Example
Read this in other languages: [English](README.md), [한국어](README.ko.md)

## Project Spec
* Spring Boot 3.x
* Java 17

## Build Test
Tested on windows, linux
```shell
./gradlew bootBuildImage
```

## Description
Using Dependency-Mapping, Change dependency uri for jre, syft.  
[Detail info(Korean)](https://www.notion.so/bbear/BootBuildImage-dependency-mapping-3e8aa1b5efba4e03b3108a581b35db85)

## Sample Build Log
```
> Task :bootBuildImage
Building image 'docker.io/library/demo:0.0.1-SNAPSHOT'

 > Pulling builder image 'docker.io/paketobuildpacks/builder@sha256:3d431026a28afdfefc20ecf16d54b0ff1a280c4ae8cc6da10c21ea7e01624473' ..................................................
 > Pulled builder image 'paketobuildpacks/builder@sha256:3d431026a28afdfefc20ecf16d54b0ff1a280c4ae8cc6da10c21ea7e01624473'
 > Pulling run image 'docker.io/paketobuildpacks/run@sha256:68810b51eea5f7c7f7f5d106b50a2bedde112ce029af004f5e873280fe68d92f' ..................................................
 > Pulled run image 'paketobuildpacks/run@sha256:68810b51eea5f7c7f7f5d106b50a2bedde112ce029af004f5e873280fe68d92f'
 > Executing lifecycle version v0.15.3
 > Using build cache volume 'pack-cache-5cbe5692dbc4.build'

 > Running creator
    [creator]     ===> ANALYZING
    [creator]     Restoring data for SBOM from previous image
    [creator]     ===> DETECTING
    [creator]     ======== Output: paketo-buildpacks/git@1.0.1 ========
    [creator]     failed to load bindings from '/platform/bindings': failed to read binding 'binary': missing 'type'
    [creator]     err:  paketo-buildpacks/git@1.0.1 (1)
    [creator]     ======== Output: paketo-buildpacks/git@1.0.1 ========
    [creator]     failed to load bindings from '/platform/bindings': failed to read binding 'binary': missing 'type'
    [creator]     err:  paketo-buildpacks/git@1.0.1 (1)
    [creator]     6 of 24 buildpacks participating
    [creator]     paketo-buildpacks/ca-certificates   3.5.1
    [creator]     paketo-buildpacks/bellsoft-liberica 9.10.3
    [creator]     paketo-buildpacks/syft              1.23.0
    [creator]     paketo-buildpacks/executable-jar    6.5.0
    [creator]     paketo-buildpacks/dist-zip          5.4.0
    [creator]     paketo-buildpacks/spring-boot       5.22.1
    [creator]     ===> RESTORING
    [creator]     Restoring metadata for "paketo-buildpacks/ca-certificates:helper" from app image
    [creator]     Restoring metadata for "paketo-buildpacks/bellsoft-liberica:helper" from app image
    [creator]     Restoring metadata for "paketo-buildpacks/bellsoft-liberica:java-security-properties" from app image
    [creator]     Restoring metadata for "paketo-buildpacks/bellsoft-liberica:jre" from app image
    [creator]     Restoring metadata for "paketo-buildpacks/spring-boot:helper" from app image
    [creator]     Restoring metadata for "paketo-buildpacks/spring-boot:spring-cloud-bindings" from app image
    [creator]     Restoring metadata for "paketo-buildpacks/spring-boot:web-application-type" from app image
    [creator]     ===> BUILDING
    [creator]
    [creator]     Paketo Buildpack for CA Certificates 3.5.1
    [creator]       https://github.com/paketo-buildpacks/ca-certificates
    [creator]       Launch Helper: Reusing cached layer
    [creator]
    [creator]     Paketo Buildpack for BellSoft Liberica 9.10.3
    [creator]       https://github.com/paketo-buildpacks/bellsoft-liberica
    [creator]       Build Configuration:
    [creator]         $BP_JVM_JLINK_ARGS           --no-man-pages --no-header-files --strip-debug --compress=1  configure custom link arguments (--output must be omitted)
    [creator]         $BP_JVM_JLINK_ENABLED        false                                                        enables running jlink tool to generate custom JRE
    [creator]         $BP_JVM_TYPE                 JRE                                                          the JVM type - JDK or JRE
    [creator]         $BP_JVM_VERSION              11                                                           the Java version
    [creator]       Launch Configuration:
    [creator]         $BPL_DEBUG_ENABLED           false                                                        enables Java remote debugging support
    [creator]         $BPL_DEBUG_PORT              8000                                                         configure the remote debugging port
    [creator]         $BPL_DEBUG_SUSPEND           false                                                        configure whether to suspend execution until a debugger has attached
    [creator]         $BPL_HEAP_DUMP_PATH                                                                       write heap dumps on error to this path
    [creator]         $BPL_JAVA_NMT_ENABLED        true                                                         enables Java Native Memory Tracking (NMT)
    [creator]         $BPL_JAVA_NMT_LEVEL          summary                                                      configure level of NMT, summary or detail
    [creator]         $BPL_JFR_ARGS                                                                             configure custom Java Flight Recording (JFR) arguments
    [creator]         $BPL_JFR_ENABLED             false                                                        enables Java Flight Recording (JFR)
    [creator]         $BPL_JMX_ENABLED             false                                                        enables Java Management Extensions (JMX)
    [creator]         $BPL_JMX_PORT                5000                                                         configure the JMX port
    [creator]         $BPL_JVM_HEAD_ROOM           0                                                            the headroom in memory calculation
    [creator]         $BPL_JVM_LOADED_CLASS_COUNT  35% of classes                                               the number of loaded classes in memory calculation
    [creator]         $BPL_JVM_THREAD_COUNT        250                                                          the number of threads in memory calculation
    [creator]         $JAVA_TOOL_OPTIONS                                                                        the JVM launch flags
    [creator]         Using Java version 17 extracted from MANIFEST.MF
    [creator]       BellSoft Liberica JRE 17.0.6: Reusing cached layer
    [creator]       Launch Helper: Reusing cached layer
    [creator]       Java Security Properties: Reusing cached layer
    [creator]
    [creator]     Paketo Buildpack for Syft 1.23.0
    [creator]       https://github.com/paketo-buildpacks/syft
    [creator]         Downloading from file:///platform/bindings/binary/syft_0.62.1_linux_amd64.tar.gz
    [creator]         Verifying checksum
    [creator]         Writing env.build/SYFT_CHECK_FOR_APP_UPDATE.default
    [creator]
    [creator]     Paketo Buildpack for Executable JAR 6.5.0
    [creator]       https://github.com/paketo-buildpacks/executable-jar
    [creator]       Class Path: Contributing to layer
    [creator]         Writing env/CLASSPATH.delim
    [creator]         Writing env/CLASSPATH.prepend
    [creator]       Process types:
    [creator]         executable-jar: java org.springframework.boot.loader.JarLauncher (direct)
    [creator]         task:           java org.springframework.boot.loader.JarLauncher (direct)
    [creator]         web:            java org.springframework.boot.loader.JarLauncher (direct)
    [creator]
    [creator]     Paketo Buildpack for Spring Boot 5.22.1
    [creator]       https://github.com/paketo-buildpacks/spring-boot
    [creator]       Build Configuration:
    [creator]         $BP_SPRING_CLOUD_BINDINGS_DISABLED   false  whether to contribute Spring Boot cloud bindings support
    [creator]       Launch Configuration:
    [creator]         $BPL_SPRING_CLOUD_BINDINGS_DISABLED  false  whether to auto-configure Spring Boot environment properties from bindings
    [creator]         $BPL_SPRING_CLOUD_BINDINGS_ENABLED   true   Deprecated - whether to auto-configure Spring Boot environment properties from bindings
    [creator]       Creating slices from layers index
    [creator]         dependencies (22.4 MB)
    [creator]         spring-boot-loader (269.4 KB)
    [creator]         snapshot-dependencies (0.0 B)
    [creator]         application (36.2 KB)
    [creator]       Launch Helper: Reusing cached layer
    [creator]       Spring Cloud Bindings 1.11.0: Reusing cached layer
    [creator]       Web Application Type: Reusing cached layer
    [creator]       4 application slices
    [creator]       Image labels:
    [creator]         org.springframework.boot.version
    [creator]     ===> EXPORTING
    [creator]     Reusing layer 'paketo-buildpacks/ca-certificates:helper'
    [creator]     Reusing layer 'paketo-buildpacks/bellsoft-liberica:helper'
    [creator]     Reusing layer 'paketo-buildpacks/bellsoft-liberica:java-security-properties'
    [creator]     Reusing layer 'paketo-buildpacks/bellsoft-liberica:jre'
    [creator]     Reusing layer 'paketo-buildpacks/executable-jar:classpath'
    [creator]     Reusing layer 'paketo-buildpacks/spring-boot:helper'
    [creator]     Reusing layer 'paketo-buildpacks/spring-boot:spring-cloud-bindings'
    [creator]     Reusing layer 'paketo-buildpacks/spring-boot:web-application-type'
    [creator]     Reusing layer 'launch.sbom'
    [creator]     Reusing 5/5 app layer(s)
    [creator]     Reusing layer 'launcher'
    [creator]     Reusing layer 'config'
    [creator]     Reusing layer 'process-types'
    [creator]     Adding label 'io.buildpacks.lifecycle.metadata'
    [creator]     Adding label 'io.buildpacks.build.metadata'
    [creator]     Adding label 'io.buildpacks.project.metadata'
    [creator]     Adding label 'org.springframework.boot.version'
    [creator]     Setting default process type 'web'
    [creator]     Saving docker.io/library/demo:0.0.1-SNAPSHOT...
    [creator]     *** Images (180a9de7d52d):
    [creator]           docker.io/library/demo:0.0.1-SNAPSHOT
    [creator]     Adding cache layer 'paketo-buildpacks/syft:syft'
    [creator]     Adding cache layer 'cache.sbom'

Successfully built image 'docker.io/library/demo:0.0.1-SNAPSHOT'
```