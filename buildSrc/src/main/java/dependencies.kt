import Versions.ktorVersion

object Versions {

    const val kotlin = "1.4.32"
    const val kotlinCoroutines = "1.4.1"
    const val okhttp3 = "4.6.0"
    const val retrofit2 = "2.8.1"
    const val ktxConverter = "0.8.0"
    const val ktxSerialization = "1.0.1"
    const val kotlinter = "3.3.0"
    const val gmsSupport = "4.3.3"
    const val androidGradleSupport = "7.1.0-alpha01"
    const val androidxAppCompat = "1.3.0-beta01"
    const val materialDesign = "1.3.0"


    const val kodeinDI = "7.2.0"
    const val jUnit4 = "4.13"
    const val assertJ29 = "2.9.1"
    const val mockk = "1.10.0"

    const val ktorVersion = "1.5.2"
    const val dalek = "1.0.2"
    const val androidxLifecycle = "2.2.0"
    const val compose = "1.0.0-beta07"
    const val composeLifeCycle = "1.0.0-alpha12"
    const val activityCompose = "1.3.0-alpha02"
    const val composeViewModel = "1.0.0-alpha02"
    const val composeConstraint = "1.0.0-alpha06"
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

    val okhttpInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okhttp3}"
    val retrofitRxAdapter = "com.squareup.retrofit2:adapter-rxjava2:${Versions.retrofit2}"
    val KtxConverter =
        "com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:${Versions.ktxConverter}"

    val materialDesign = "com.google.android.material:material:${Versions.materialDesign}"

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

    //region Compose


    val composeUi = "androidx.compose.ui:ui:${Versions.compose}"
    val composeTooling = "androidx.compose.ui:ui-tooling:${Versions.compose}"
    val composeFoundation = "androidx.compose.foundation:foundation:${Versions.compose}"
    val composeMaterialDesign = "androidx.compose.material:material:${Versions.compose}"
    val composeIntegration = "androidx.activity:activity-compose:${Versions.activityCompose}"
    val composeMaterialIconsExtended =
        "androidx.compose.material:material-icons-extended:${Versions.compose}"
    val composeMaterialIcons = "androidx.compose.material:material-icons-core:${Versions.compose}"
    val composeLifeCycle =
        "androidx.lifecycle:lifecycle-viewmodel-compose:${Versions.composeViewModel}"


    val composeRunTimeRxJava =
        "androidx.compose.runtime:runtime-rxjava2:${Versions.composeLifeCycle}"
    val composeRunTimeLiveData =
        "androidx.compose.runtime:runtime-livedata:${Versions.composeLifeCycle}"


    val composeConstraint = "androidx.constraintlayout:constraintlayout-compose:${Versions.composeConstraint}"
    val composeTest = "androidx.compose.ui:ui-test-junit4:${Versions.compose}"
    // endregion


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
        Dependencies.okhttpInterceptor,
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
        Dependencies.kodeinAndroid,
        Dependencies.materialDesign,
        Dependencies.kodein,
        Dependencies.kodeinConf,
        Dependencies.dalek,
        Dependencies.androidxLifecycleViewModel,
        Dependencies.androidxLifecycleCommonJava8,
        Dependencies.androidxLifecycleExtensions,
        Dependencies.androidxLifeCycleRunTime,
        Dependencies.androidxAppCompat
    )

    val testing = listOf(
        Dependencies.jUnit,
        Dependencies.assertJ,
        Dependencies.mockk,
        Dependencies.kotlinReflect
    )
}

object ComposeModule {
    val main = listOf(
        Dependencies.composeUi,
        Dependencies.composeTooling,
        Dependencies.composeFoundation,
        Dependencies.composeMaterialDesign,
        Dependencies.composeIntegration,
        Dependencies.composeMaterialIconsExtended,
        Dependencies.composeMaterialIcons,
        Dependencies.composeLifeCycle,
        Dependencies.composeRunTimeRxJava,
        Dependencies.composeRunTimeLiveData,
        Dependencies.composeConstraint
    )

    val testing = listOf(
        Dependencies.composeTest
    )

}

object BuildPlugins {
    val androidGradlePlugin = "com.android.tools.build:gradle:${Versions.androidGradleSupport}"
    val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    val kotlinxSerializiationPlugin = "org.jetbrains.kotlin:kotlin-serialization:${Versions.kotlin}"
    val kotlinter = "org.jmailen.gradle:kotlinter-gradle:${Versions.kotlinter}"
    val gmsPlugin = "com.google.gms:google-services:${Versions.gmsSupport}"
    val androidTools = "com.android.tools.build:gradle:7.0.0-alpha08"

}