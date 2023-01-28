object Versions {
    const val kotlinCoroutines = "1.6.4"
    const val kotlinImmutable = "0.3.5"
    const val dagger = "2.44.2"
    const val androidxCore = "1.9.0"
    const val androidxLifecycle = "2.5.1"
    const val androidxActivityCompose = "1.6.1"
    const val androidxNavigationCompose = "2.5.3"
    const val composeUi = "1.3.2"
    const val composeMaterial3 = "1.0.1"
    const val composeIcons = "1.3.1"
    const val timber = "5.0.1"
    const val jUnit = "4.13.2"
    const val androidxJunit = "1.1.5"
    const val androidxEspresso = "3.5.1"
}

object Libs {

    val kotlinCoroutines = listOf(
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.kotlinCoroutines}",
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.kotlinCoroutines}",
    )
    const val kotlinImmutable = "org.jetbrains.kotlinx:kotlinx-collections-immutable:${Versions.kotlinImmutable}"

    const val daggerHilt = "com.google.dagger:hilt-android:${Versions.dagger}"
    const val daggerCompiler = "com.google.dagger:hilt-compiler:${Versions.dagger}"

    const val androidxCore = "androidx.core:core-ktx:${Versions.androidxCore}"
    const val androidxLifecycle = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.androidxLifecycle}"
    const val androidxActivityCompose = "androidx.activity:activity-compose:${Versions.androidxActivityCompose}"
    const val androidxNavigationCompose = "androidx.navigation:navigation-compose:${Versions.androidxNavigationCompose}"

    val composeCore = listOf(
        "androidx.compose.ui:ui:${Versions.composeUi}",
        "androidx.compose.ui:ui-tooling-preview:${Versions.composeUi}",
        "androidx.compose.material3:material3:${Versions.composeMaterial3}"
    )
    const val composeIcons = "androidx.compose.material:material-icons-extended:${Versions.composeIcons}"

    const val timber = "com.jakewharton.timber:timber:${Versions.timber}"

    const val jUnit = "junit:junit:${Versions.jUnit}"

    val androidxTest = listOf(
        "androidx.test.ext:junit:${Versions.androidxJunit}",
        "androidx.test.espresso:espresso-core:${Versions.androidxEspresso}",
        "androidx.compose.ui:ui-test-junit4:${Versions.composeUi}",
    )

    val debug = listOf(
        "androidx.compose.ui:ui-tooling:${Versions.composeUi}",
        "androidx.compose.ui:ui-test-manifest:${Versions.composeUi}",
    )
}
