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

rootProject.name = "FirstApp"
include(":first_lab")
include(":first_lab:businesscard")
include(":first_lab:composearticle")
include(":first_lab:composequadrants")
include(":first_lab:taskmanager")
include(":first_lab:happybirthdayapp")
include(":second_lab")
include(":second_lab:lemonade")
include(":second_lab:diceroller")
