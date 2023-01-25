import org.gradle.api.artifacts.dsl.DependencyHandler

fun DependencyHandler.implementation(vararg dependencies: Any) =
    addNamed("implementation", *dependencies)

fun DependencyHandler.debugImplementation(vararg dependencies: Any) =
    addNamed("debugImplementation", *dependencies)

fun DependencyHandler.androidTestImplementation(vararg dependencies: Any) =
    addNamed("androidTestImplementation", *dependencies)

fun DependencyHandler.testImplementation(vararg dependencies: Any) =
    addNamed("testImplementation", *dependencies)

fun DependencyHandler.addNamed(name: String, vararg dependencies: Any) {
    for (dependency in dependencies) {
        if (dependency is Iterable<*>) {
            dependency.forEach { add(name, it as Any) }
        } else {
            add(name, dependency)
        }
    }
}
