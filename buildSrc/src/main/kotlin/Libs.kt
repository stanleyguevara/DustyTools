object Versions {
    const val compose = "1.3.2"
}

object Libs {

    val composeCore = listOf(
        "androidx.compose.ui:ui:${Versions.compose}",
        "androidx.compose.ui:ui-tooling-preview:${Versions.compose}",
        "androidx.compose.material3:material3:1.0.1"
    )

    val composeIcons = "androidx.compose.material:material-icons-extended:1.3.1"

    val androidTest = listOf(
        "androidx.test.ext:junit:1.1.5",
        "androidx.test.espresso:espresso-core:3.5.1",
        "androidx.compose.ui:ui-test-junit4:${Versions.compose}",
    )

    val debug = listOf(
        "androidx.compose.ui:ui-tooling:${Versions.compose}",
        "androidx.compose.ui:ui-test-manifest:${Versions.compose}",
    )
}
