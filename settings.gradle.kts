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
include(":second_lab:tiptime")
include(":second_lab:artspace")
include(":kotlin2")
include(":fourth_lab")
include(":fourth_lab:affirmations")
include(":fourth_lab:courses")
include(":fifth_lab")
include(":fifth_lab:superheroes")
include(":fifth_lab:30days")
include(":fifth_lab:wooof")
include(":sixth_lab")
include(":sixth_lab:dessertclicker")
include(":sixth_lab:unscramble")
include(":seventh_lab")
include(":seventh_lab:cupcake")
include(":seventh_lab:lunch-tray")
include(":eighth_lab")
include(":eighth_lab:reply")
include(":eighth_lab:reply2")
include(":eighth_lab:training_sports")
include(":eighth_lab:mycity")
