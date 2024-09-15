pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "KotlinGraphicsExperiments5"
include(":app")
include(":lineextendarcrotview")
include(":linebreakarcrotview")
include(":arcintolinedownview")
include(":arctouprotview")
include(":linedoublearintoview")
include(":lineshiftrotjoinview")
include(":linemainbibentview")
include(":triarcjoinrotview")
include(":linearcopenrightview")
