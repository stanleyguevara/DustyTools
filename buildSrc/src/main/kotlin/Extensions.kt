import org.gradle.api.artifacts.dsl.DependencyHandler

fun DependencyHandler.implementation(vararg dependencies: Any) =
    addNamed("implementation", *dependencies)

fun DependencyHandler.debugImplementation(vararg dependencies: Any) =
    addNamed("debugImplementation", *dependencies)

fun DependencyHandler.androidTestImplementation(vararg dependencies: Any) =
    addNamed("androidTestImplementation", *dependencies)

fun DependencyHandler.testImplementation(vararg dependencies: Any) =
    addNamed("testImplementation", *dependencies)

fun DependencyHandler.kapt(vararg dependencies: Any) =
    addNamed("kapt", *dependencies)

/**
 * Centralized dependency management is quite nice but I was missing AndroidStudio hints about new dependencies.
 * To find dependency updates run ./gradlew module:dependencyUpdates
 * Remember to add id("com.github.ben-manes.versions") to plugins in module's build.gradle.kts
 *
 * @param print An alternative to the above, probably slower. Flip the boolean to true,
 * then you can just paste dependencies wherever they belong and see highlighted new versions like before.
 */
fun DependencyHandler.addNamed(name: String, vararg dependencies: Any, print: Boolean = false) {
    for (dependency in dependencies) {
        if (dependency is Iterable<*>) {
            dependency.forEach {
                add(name, it as Any)
                if (print) printDependency(name, it)
            }
        } else {
            add(name, dependency)
            if (print) printDependency(name, dependency)
        }
    }
}

fun printDependency(name: String, dependency: Any) {
    println("$name(\"$dependency\")")
}
