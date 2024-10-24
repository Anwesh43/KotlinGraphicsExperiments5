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
include(":singlerightlinebarview")
include(":lineuparcrotview")
include(":linehalfarcleftview")
include(":simplelinequarterarcview")
include(":lineslantrightview")
include(":arcconcverticalrotview")
include(":bilinequarterarcview")
include(":linearcrightdownview")
include(":altupdownlineview")
include(":linefloordownarcview")
include(":linejoinrotarcview")
include(":arcrotupdownview")
include(":arcaltlinerotview")
include(":rightarcanglejoinview")
include(":linerotupleftview")
include(":linearcextenddownview")
include(":linetriarccloseview")
include(":completearcfullview")
include(":linebreakupdownview")
include(":sidearcmiddownview")
include(":lineshiftrotlineview")
include(":linerotholderupview")
include(":arcrotdroplineview")
include(":arcaltsiderotview")
include(":trilinecloseupview")
include(":linemultirotleftview")
include(":openlinestrokerotview")
include(":linebentrottorightview")
include(":linedividearccontainview")
include(":parallellinejoinrotview")
include(":linebentmorearcview")
include(":arcfromrightupview")
