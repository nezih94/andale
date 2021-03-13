/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    primary = primary_darkTheme,
    primaryVariant = primaryVariant_darkTheme,
    secondary = secondary_darkTheme,
    background = background_darkTheme,
    surface = surface_darkTheme,
    onPrimary = onprimary_darkTheme,
    onSecondary = onsecondary_darkTheme,
    onBackground = onbackground_darkTheme,
    onSurface = onsurface_darkTheme
)

private val LightColorPalette = lightColors(
    primary = primary_lightTheme,
    primaryVariant = primaryVariant_lightTheme,
    secondary = secondary_lightTheme,
    background = background_lightTheme,
    surface = surface_lightTheme,
    onPrimary = onprimary_lightTheme,
    onSecondary = onsecondary_lightTheme,
    onBackground = onbackground_lightTheme,
    onSurface = onsurface_lightTheme
)

@Composable
fun MyTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable() () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = typography,
        shapes = shapes,
        content = content
    )
}
