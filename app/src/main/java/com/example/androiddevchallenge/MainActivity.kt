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
package com.example.androiddevchallenge

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.ui.theme.MyTheme
import dev.chrisbanes.accompanist.insets.ProvideWindowInsets
import dev.chrisbanes.accompanist.insets.navigationBarsPadding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            MyTheme {
                ProvideWindowInsets {
                    MyApp()
                }
            }
        }
    }
}

// Start building your app here!
@Composable
fun MyApp() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "welcome") {
        composable("welcome") { Welcome(navController = navController) }
        composable("login") { Login(navController = navController) }
        composable("home") { Home() }
    }
}

@Composable
fun Welcome(navController: NavController) {
    Surface(color = MaterialTheme.colors.background) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
        ) {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_welcome),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )

            Column(
                modifier = Modifier.align(Alignment.Center),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    imageVector = ImageVector.vectorResource(id = R.drawable.ic_logo),
                    contentDescription = null,
                    contentScale = ContentScale.Crop
                )

                Button(
                    onClick = {},
                    modifier = Modifier
                        .padding(top = 32.dp, start = 16.dp, end = 16.dp)
                        .fillMaxWidth()
                        .requiredHeight(72.dp),
                    colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.primary),
                    shape = MaterialTheme.shapes.medium
                ) {
                    Text(
                        text = "SIGN UP",
                        style = MaterialTheme.typography.button,
                        color = MaterialTheme.colors.onPrimary
                    )
                }
                Button(
                    onClick = { navController.navigate("login") },
                    modifier = Modifier
                        .padding(top = 8.dp, start = 16.dp, end = 16.dp)
                        .fillMaxWidth()
                        .requiredHeight(72.dp),
                    colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.secondary),
                    shape = MaterialTheme.shapes.medium
                ) {
                    Text(
                        text = "LOG IN",
                        style = MaterialTheme.typography.button,
                        color = MaterialTheme.colors.onSecondary
                    )
                }
            }
        }
    }
}

@Composable
fun Login(navController: NavController) {
    Surface(color = MaterialTheme.colors.background) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
        ) {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_welcome),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )

            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    modifier = Modifier.paddingFromBaseline(top = 200.dp, bottom = 32.dp),
                    text = "LOG IN",
                    style = MaterialTheme.typography.h1,
                    color = MaterialTheme.colors.onBackground
                )

                TextField(
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .fillMaxWidth()
                        .requiredHeight(56.dp),
                    value = "",
                    onValueChange = { },
                    label = {
                        Text(
                            "Email address",
                            style = MaterialTheme.typography.body1,
                            color = MaterialTheme.colors.onSurface,
                            modifier = Modifier.padding(horizontal = 16.dp)
                        )
                    },
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = MaterialTheme.colors.surface,
                        unfocusedIndicatorColor = MaterialTheme.colors.onSurface
                    ),
                    shape = RoundedCornerShape(topStart = 4.dp, topEnd = 4.dp)
                )
                TextField(
                    modifier = Modifier
                        .padding(start = 16.dp, end = 16.dp, top = 8.dp)
                        .fillMaxWidth()
                        .requiredHeight(56.dp),
                    value = "",
                    onValueChange = { },
                    label = {
                        Text(
                            "Password",
                            style = MaterialTheme.typography.body1,
                            color = MaterialTheme.colors.onSurface,
                            modifier = Modifier.padding(horizontal = 16.dp, vertical = 0.dp)
                        )
                    },
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = MaterialTheme.colors.surface,
                        unfocusedIndicatorColor = MaterialTheme.colors.onSurface
                    ),
                    shape = RoundedCornerShape(topStart = 4.dp, topEnd = 4.dp)
                )
                Button(
                    onClick = { navController.navigate("home") },
                    modifier = Modifier
                        .padding(top = 8.dp, start = 16.dp, end = 16.dp)
                        .fillMaxWidth()
                        .requiredHeight(72.dp),
                    colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.primary),
                    shape = MaterialTheme.shapes.medium
                ) {
                    Text(
                        text = "LOG IN",
                        style = MaterialTheme.typography.button,
                        color = MaterialTheme.colors.onPrimary
                    )
                }
                val annotatedString =
                    AnnotatedString.Builder("Don't have an account? Sign up")
                        .apply {
                            addStyle(
                                style = SpanStyle(textDecoration = TextDecoration.Underline),
                                23,
                                30
                            )
                        }
                Text(
                    text = annotatedString.toAnnotatedString(),
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .paddingFromBaseline(top = 32.dp, bottom = 0.dp),
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colors.onBackground,
                    style = MaterialTheme.typography.body1
                )
            }
        }
    }
}

@Composable
fun Home() {
    Surface(color = MaterialTheme.colors.background) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 56.dp, bottom = 56.dp)
                .verticalScroll(
                    rememberScrollState()
                )
        ) {
            TextField(
                modifier = Modifier
                    .padding(start = 16.dp, end = 16.dp, top = 8.dp)
                    .fillMaxWidth()
                    .requiredHeight(56.dp),
                value = "",
                leadingIcon = {
                    Icon(
                        modifier = Modifier.requiredSize(18.dp),
                        imageVector = ImageVector.vectorResource(id = R.drawable.ic_baseline_search_24),
                        contentDescription = null
                    )
                },
                onValueChange = { },
                label = {
                    Text(
                        "Search",
                        style = MaterialTheme.typography.body1,
                        color = MaterialTheme.colors.onSurface,
                        modifier = Modifier.padding(horizontal = 0.dp, vertical = 0.dp)
                    )
                },
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = MaterialTheme.colors.surface,
                    unfocusedIndicatorColor = MaterialTheme.colors.onSurface
                ),
                shape = RoundedCornerShape(topStart = 4.dp, topEnd = 4.dp)
            )
            Text(
                "FAVORITE COLLECTIONS",
                style = MaterialTheme.typography.h2,
                color = MaterialTheme.colors.onBackground,
                modifier = Modifier
                    .padding(start = 8.dp)
                    .paddingFromBaseline(top = 40.dp)
            )

            LazyRow(
                modifier = Modifier.padding(top = 8.dp, bottom = 8.dp),
                contentPadding = PaddingValues(start = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                content = {
                    list1data.chunked(2) { (item1, item2) ->
                        item {
                            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                                Surface(
                                    modifier = Modifier.requiredWidth(width = 192.dp),
                                    color = MaterialTheme.colors.surface,
                                    shape = MaterialTheme.shapes.small
                                ) {
                                    Row() {
                                        Image(
                                            modifier = Modifier
                                                .requiredHeight(height = 56.dp)
                                                .requiredWidth(width = 56.dp)
                                                .clip(
                                                    RoundedCornerShape(
                                                        topStart = 4.dp,
                                                        bottomStart = 4.dp
                                                    )
                                                ),
                                            painter = painterResource(id = item1.imgRes),
                                            contentDescription = null,
                                            contentScale = ContentScale.Crop
                                        )
                                        Text(
                                            item1.title,
                                            style = MaterialTheme.typography.h3,
                                            color = MaterialTheme.colors.onSurface,
                                            modifier = Modifier
                                                .padding(
                                                    horizontal = 16.dp,
                                                    vertical = 0.dp
                                                )
                                                .align(Alignment.CenterVertically)
                                        )
                                    }
                                }

                                Surface(
                                    modifier = Modifier.requiredWidth(width = 192.dp),
                                    color = MaterialTheme.colors.surface,
                                    shape = MaterialTheme.shapes.small
                                ) {
                                    Row() {
                                        Image(
                                            modifier = Modifier
                                                .requiredHeight(height = 56.dp)
                                                .requiredWidth(width = 56.dp)
                                                .clip(
                                                    RoundedCornerShape(
                                                        topStart = 4.dp,
                                                        bottomStart = 4.dp
                                                    )
                                                ),
                                            painter = painterResource(id = item2.imgRes),
                                            contentDescription = null,
                                            contentScale = ContentScale.Crop
                                        )
                                        Text(
                                            item2.title,
                                            style = MaterialTheme.typography.h3,
                                            color = MaterialTheme.colors.onSurface,
                                            modifier = Modifier
                                                .padding(
                                                    horizontal = 16.dp,
                                                    vertical = 0.dp
                                                )
                                                .align(Alignment.CenterVertically)
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            )

            Text(
                "ALIGN YOUR BODY",
                style = MaterialTheme.typography.h2,
                color = MaterialTheme.colors.onBackground,
                modifier = Modifier
                    .padding(start = 8.dp)
                    .paddingFromBaseline(top = 40.dp, bottom = 8.dp)
            )

            LazyRow(
                modifier = Modifier.padding(top = 0.dp, bottom = 8.dp),
                contentPadding = PaddingValues(start = 16.dp, end = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                content = {

                    for (data in list2data) {
                        item {
                            Column(
                                Modifier.requiredWidth(width = 88.dp),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Image(
                                    modifier = Modifier
                                        .requiredHeight(height = 88.dp)
                                        .requiredWidth(width = 88.dp)
                                        .clip(
                                            RoundedCornerShape(44.dp)
                                        ),
                                    painter = painterResource(id = data.imgRes),
                                    contentDescription = null,
                                    contentScale = ContentScale.Crop
                                )

                                Text(
                                    data.title,
                                    style = MaterialTheme.typography.h3,
                                    color = MaterialTheme.colors.onSurface,
                                    modifier = Modifier
                                        .padding(
                                            horizontal = 0.dp,
                                            vertical = 0.dp
                                        )
                                        .paddingFromBaseline(top = 24.dp),
                                    maxLines = 1

                                )
                            }
                        }
                    }
                }
            )

            Text(
                "ALIGN YOUR MIND",
                style = MaterialTheme.typography.h2,
                color = MaterialTheme.colors.onBackground,
                modifier = Modifier
                    .padding(start = 8.dp)
                    .paddingFromBaseline(top = 40.dp, bottom = 8.dp)
            )

            LazyRow(
                modifier = Modifier.padding(top = 0.dp, bottom = 0.dp),
                contentPadding = PaddingValues(start = 16.dp, end = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                content = {

                    for (data in list3data) {
                        item {
                            Column(
                                Modifier.requiredWidth(width = 88.dp),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Image(
                                    modifier = Modifier
                                        .requiredHeight(height = 88.dp)
                                        .requiredWidth(width = 88.dp)
                                        .clip(
                                            RoundedCornerShape(44.dp)
                                        ),
                                    painter = painterResource(id = data.imgRes),
                                    contentDescription = null,
                                    contentScale = ContentScale.Crop
                                )

                                Text(
                                    data.title,
                                    style = MaterialTheme.typography.h3,
                                    color = MaterialTheme.colors.onSurface,
                                    modifier = Modifier
                                        .padding(
                                            horizontal = 0.dp,
                                            vertical = 0.dp
                                        )
                                        .paddingFromBaseline(top = 24.dp),
                                    maxLines = 1

                                )
                            }
                        }
                    }
                }
            )

            Spacer(modifier = Modifier.requiredHeight(112.dp))
        }

        Box(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
        ) {
            BottomNavigation(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .navigationBarsPadding(),
                elevation = 8.dp,
                backgroundColor = MaterialTheme.colors.background
            ) {
                BottomNavigationItem(
                    selected = true,
                    onClick = { },
                    icon = {
                        Icon(
                            modifier = Modifier.requiredSize(18.dp),
                            imageVector = ImageVector.vectorResource(id = R.drawable.ic_baseline_spa_24),
                            contentDescription = null
                        )
                    },
                    label = {
                        Text(
                            text = "HOME",
                            style = MaterialTheme.typography.caption,
                            color = MaterialTheme.colors.onBackground
                        )
                    }
                )

                BottomNavigationItem(
                    selected = false,
                    onClick = { },
                    icon = {
                        Icon(
                            modifier = Modifier.requiredSize(18.dp),
                            imageVector = ImageVector.vectorResource(id = R.drawable.ic_baseline_account_circle_24),
                            contentDescription = null
                        )
                    },
                    label = {
                        Text(
                            text = "PROFILE",
                            style = MaterialTheme.typography.caption,
                            color = Color.Gray
                        )
                    }
                )
            }

            Surface(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .navigationBarsPadding()
                    .requiredSize(56.dp)
                    .offset(y = -28.dp),
                color = MaterialTheme.colors.primary,
                elevation = 8.dp,
                shape = RoundedCornerShape(28.dp)
            ) {
                Icon(
                    modifier = Modifier
                        .requiredSize(24.dp),
                    imageVector = ImageVector.vectorResource(id = R.drawable.ic_baseline_play_arrow_24),
                    contentDescription = null, tint = MaterialTheme.colors.onPrimary
                )
            }
        }
    }
}

data class Item(val imgRes: Int, val title: String)

val list1data = listOf(
    Item(R.drawable.img5, "Short mantras"),
    Item(R.drawable.img1, "Nature meditations"),
    Item(R.drawable.img2, "Stress and anxiety"),
    Item(R.drawable.img3, "Self-massage"),
    Item(R.drawable.img7, "Overwhelmed"),
    Item(R.drawable.img5, "Nightly wind down")
)

val list2data = listOf(
    Item(R.drawable.img6, "Inversions"),
    Item(R.drawable.img17, "Quick yoga"),
    Item(R.drawable.img10, "Stretching"),
    Item(R.drawable.img16, "Tabata"),
    Item(R.drawable.img15, "HIIT"),
    Item(R.drawable.img4, "Pre-natal yoga")
)

val list3data = listOf(
    Item(R.drawable.img14, "Meditate"),
    Item(R.drawable.img11, "With kids"),
    Item(R.drawable.img12, "Aromatherapy"),
    Item(R.drawable.img13, "On the go"),
    Item(R.drawable.img8, "With pets"),
    Item(R.drawable.img9, "High stress")
)
