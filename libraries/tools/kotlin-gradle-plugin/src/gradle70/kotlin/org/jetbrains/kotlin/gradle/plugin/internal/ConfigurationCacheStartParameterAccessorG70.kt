/*
 * Copyright 2010-2023 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.gradle.plugin.internal

import org.gradle.api.Project
import org.gradle.api.internal.StartParameterInternal
import org.gradle.api.invocation.Gradle

internal class ConfigurationCacheStartParameterAccessorG70(
    private val gradle: Gradle,
) : ConfigurationCacheStartParameterAccessor {
    override val isConfigurationCacheRequested by lazy {
        (gradle.startParameter as StartParameterInternal).isConfigurationCache
    }

    internal class Factory : ConfigurationCacheStartParameterAccessor.Factory {
        override fun getInstance(project: Project) = ConfigurationCacheStartParameterAccessorG70(project.gradle)
    }
}
