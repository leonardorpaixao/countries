import Versions.ktorVersion

object Versions {

    const val kotlin = "1.4.21"
    const val kotlinCoroutines = "1.4.1"
    const val okhttp3 = "4.6.0"
    const val retrofit2 = "2.8.1"
    const val ktxConverter = "0.8.0"
    const val ktxSerialization = "1.0.1"
    const val kotlinter = "3.3.0"
    const val gmsSupport = "4.3.3"
    const val androidGradleSupport = "4.1.1"
    const val materialDesign = "1.2.0-alpha03"
    const val androidxRecyclerView = "1.1.0"


    const val kodeinDI = "7.2.0"

    const val androidxAppCompat = "1.1.0"
    const val groupie = "2.8.0"

    const val jUnit4 = "4.13"
    const val assertJ29 = "2.9.1"
    const val androidxConstraintLayout = "2.0.0-beta3"
    const val mockk = "1.10.0"

    const val ktorVersion = "1.5.2"
    const val dalek = "1.0.2"
    const val androidxLifecycle = "2.2.0"
}

object Dependencies {

    val dalek = "com.github.adrielcafe:dalek:${Versions.dalek}"

    val androidxAppCompat = "androidx.appcompat:appcompat:${Versions.androidxAppCompat}"
    val kotlinStdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlin}"
    val kotlinxSerialization =
        "org.jetbrains.kotlinx:kotlinx-serialization-json:${Versions.ktxSerialization}"
    val kotlinCoroutinesRx =
        "org.jetbrains.kotlinx:kotlinx-coroutines-rx2:${Versions.kotlinCoroutines}"
    val kotlinCoroutines =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.kotlinCoroutines}"

    val okhttp = "com.squareup.okhttp3:okhttp:${Versions.okhttp3}"
    val okhttpInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okhttp3}"
    val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit2}"
    val retrofitRxAdapter = "com.squareup.retrofit2:adapter-rxjava2:${Versions.retrofit2}"
    val KtxConverter =
        "com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:${Versions.ktxConverter}"

    val groupie = "com.xwray:groupie:${Versions.groupie}"
    val materialDesign = "com.google.android.material:material:${Versions.materialDesign}"
    val androidxRecyclerView = "androidx.recyclerview:recyclerview:${Versions.androidxRecyclerView}"


    val groupieKTX = "com.xwray:groupie-kotlin-android-extensions:${Versions.groupie}"
    val androidxConstraintLayout =
        "androidx.constraintlayout:constraintlayout:${Versions.androidxConstraintLayout}"

    val jUnit = "junit:junit:${Versions.jUnit4}"
    val assertJ = "org.assertj:assertj-core:${Versions.assertJ29}"
    val kotlinReflect = "org.jetbrains.kotlin:kotlin-reflect:${Versions.kotlin}"
    val mockk = "io.mockk:mockk:${Versions.mockk}"
    val kotlinCoroutinesTest =
        "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.kotlinCoroutines}"


    val kodein = "org.kodein.di:kodein-di:${Versions.kodeinDI}"
    val kodeinConf = "org.kodein.di:kodein-di-conf-jvm:${Versions.kodeinDI}"
    val kodeinAndroid = "org.kodein.di:kodein-di-framework-android-x:${Versions.kodeinDI}"

    val ktorServerNetty = "io.ktor:ktor-server-netty:$ktorVersion"
    val ktorClientCore = "io.ktor:ktor-client-core:$ktorVersion"
    val ktorClientCoreJvm = "io.ktor:ktor-client-core-jvm:$ktorVersion"
    val ktorJson = "io.ktor:ktor-client-json-jvm:$ktorVersion"
    val ktorGson = "io.ktor:ktor-client-gson:$ktorVersion"
    val ktorClientHttp = "io.ktor:ktor-client-okhttp:$ktorVersion"
    val androidxLifecycleViewModel =
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.androidxLifecycle}"
    val androidxLifecycleCommonJava8 =
        "androidx.lifecycle:lifecycle-common-java8:${Versions.androidxLifecycle}"
    val androidxLifecycleExtensions =
        "androidx.lifecycle:lifecycle-extensions:${Versions.androidxLifecycle}"
    val androidxLifeCycleRunTime =
        "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.androidxLifecycle}"

}

object CoreModule {
    val main = listOf(
        Dependencies.kotlinStdlib,
        Dependencies.kotlinCoroutines,
        Dependencies.kotlinCoroutinesRx,
        Dependencies.kodein,
        Dependencies.kodeinConf
    )

    val unitTesting = listOf(
        Dependencies.jUnit,
        Dependencies.assertJ,
        Dependencies.mockk,
        Dependencies.kotlinReflect,
        Dependencies.kotlinCoroutinesTest
    )
}

object Network {
    val main = listOf(
        Dependencies.kotlinxSerialization,
        Dependencies.okhttp,
        Dependencies.okhttpInterceptor,
        Dependencies.retrofit,
        Dependencies.retrofitRxAdapter,
        Dependencies.KtxConverter,
        Dependencies.kotlinCoroutines,
        Dependencies.kotlinCoroutinesRx,
        Dependencies.kotlinStdlib,
        Dependencies.ktorServerNetty,
        Dependencies.ktorClientCore,
        Dependencies.ktorClientCoreJvm,
        Dependencies.ktorJson,
        Dependencies.ktorGson,
        Dependencies.ktorClientHttp
    )

}

object AndroidModule {
    val main = listOf(
        Dependencies.groupie,
        Dependencies.groupieKTX,
        Dependencies.materialDesign,
        Dependencies.androidxRecyclerView,
        Dependencies.androidxAppCompat,
        Dependencies.androidxConstraintLayout,
        Dependencies.kodeinAndroid,
        Dependencies.kodein,
        Dependencies.kodeinConf,
        Dependencies.dalek,
        Dependencies.androidxLifecycleViewModel,
        Dependencies.androidxLifecycleCommonJava8,
        Dependencies.androidxLifecycleExtensions,
        Dependencies.androidxLifeCycleRunTime
    )

    val testing = listOf(
        Dependencies.jUnit,
        Dependencies.assertJ,
        Dependencies.mockk,
        Dependencies.kotlinReflect
    )
}

object BuildPlugins {
    val androidGradlePlugin = "com.android.tools.build:gradle:${Versions.androidGradleSupport}"
    val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    val kotlinxSerializiationPlugin = "org.jetbrains.kotlin:kotlin-serialization:${Versions.kotlin}"
    val kotlinter = "org.jmailen.gradle:kotlinter-gradle:${Versions.kotlinter}"
    val gmsPlugin = "com.google.gms:google-services:${Versions.gmsSupport}"

}