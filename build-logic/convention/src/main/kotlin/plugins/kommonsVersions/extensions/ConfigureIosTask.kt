/*
 * ConfigureIosTask.kt
 * Copyright (c) 2026. All rights reserved
 */
package plugins.kommonsVersions.extensions

import org.gradle.api.Project
import plugins.kommonsVersions.EXT_NAME
import plugins.kommonsVersions.model.IosBuildTypes
import plugins.kommonsVersions.model.IosConfig

internal fun Project.registerIosTask(iosConfig: IosConfig) {

    val commonVersionsIos = tasks.register("${EXT_NAME}Ios") {

        val projectFolderName = iosConfig.projectFolderName
        val dir = rootDir.resolve("${projectFolderName}/Configuration")
        val schemas = iosConfig.schemas

        val content = getIosConfigContent(
            teamId = iosConfig.teamId,
            bundleId = iosConfig.bundleId,
            currentVersion = iosConfig.currentVersion,
            marketingVersion = iosConfig.marketingVersion,
            appName = iosConfig.appName,
        )

        generateFile(
            outputDir = dir,
            fileName = "Config.xcconfig",
            fileContent = content,
        )

        if (schemas.isNotEmpty()) {
            schemas.forEach { schema ->
                IosBuildTypes.values().forEach { iosBuildType ->
                    val content = getIosConfigContent(
                        teamId = iosConfig.teamId,
                        bundleId = "${iosConfig.bundleId}.${schema.schemaBundleSuffix}",
                        schemaName = schema.schemaName,
                        buildType = iosBuildType.nameForFile,
                        currentVersion = iosConfig.currentVersion,
                        marketingVersion = iosConfig.marketingVersion,
                        appName = "${iosConfig.appName}${schema.schemaAppNameSuffix}",
                    )
                    generateFile(
                        outputDir = dir,
                        fileName = "${iosBuildType.nameForFile}-${schema.schemaName}.xcconfig",
                        fileContent = content,
                    )
                }
            }
        }
    }

    tasks.matching { task ->
        task.name.contains("ios", ignoreCase = true) && (
                task.name.contains("Link", ignoreCase = true) ||
                task.name.contains("Sync", ignoreCase = true) ||
                task.name.contains("Pack", ignoreCase = true)
        )
    }.configureEach {
        dependsOn(commonVersionsIos)
    }

    tasks.matching { task ->
        task.name.startsWith("compile") && task.name.contains(
            "Kotlin",
            ignoreCase = true,
        )
    }.configureEach { dependsOn(commonVersionsIos) }
}

private fun getIosConfigContent(
    teamId: String = "",
    bundleId: String = "",
    appName: String = "",
    buildType: String = "",
    schemaName: String = "",
    marketingVersion: String = "",
    currentVersion: String = "",
) = buildString {
    appendLine("TEAM_ID=${teamId}")
    appendLine("PRODUCT_BUNDLE_IDENTIFIER=${bundleId}")
    appendLine("PRODUCT_NAME=${appName}")
    appendLine("MARKETING_VERSION=${marketingVersion}")
    appendLine("CURRENT_PROJECT_VERSION=${currentVersion}")
    if (schemaName.isNotEmpty()) {
        appendLine("KOTLIN_FRAMEWORK_BUILD_TYPE=${buildType}")
        appendLine("XCODE_CONFIGURATION=${buildType}-${schemaName}")
        appendLine("APP_SCHEME=${schemaName}")
    }
}
