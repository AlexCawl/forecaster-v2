package org.alexcawl.forecaster.plugins.core

import kotlinx.coroutines.runBlocking
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

abstract class BaseTask : DefaultTask() {
    @TaskAction
    fun run() = runBlocking {
        onPrepare()
        onAction()
    }

    abstract fun onPrepare()

    abstract suspend fun onAction()
}