package com.jefriap.hometestcode.ui.getstarted

import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.util.lerp
import coil.compose.rememberImagePainter
import com.google.accompanist.pager.*
import com.jefriap.hometestcode.R
import com.jefriap.hometestcode.ui.theme.quicksand
import kotlinx.coroutines.delay
import kotlinx.coroutines.yield
import kotlin.math.absoluteValue


@ExperimentalPagerApi
@Composable
fun GetStartedScreen(onClicked: () -> Unit) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        val painter = rememberImagePainter(
            data = R.drawable.img
        )
        val painterState = painter.state
        Image(
            painter = painter,
            contentDescription = "Background Get Started",
            contentScale = ContentScale.FillHeight,
            modifier = Modifier.fillMaxSize())

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom
        ) {
            Card(
                modifier = Modifier
                    .width(330.dp)
                    .height(335.dp)
                    .padding(top = 0.dp, bottom = 40.dp),
                shape = RoundedCornerShape(12)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(12.dp)
                ) {
                    val pagerState =  rememberPagerState(
                        pageCount = getStartedList.size)

                    LaunchedEffect(Unit) {
                        while (true) {
                            yield()
                            delay(3000)
                            pagerState.animateScrollToPage(
                                page = (pagerState.currentPage + 1) % (pagerState.pageCount),
                                animationSpec = tween(600)
                            )
                        }
                    }

                    HorizontalPager(
                        state = pagerState,
                        modifier = Modifier
                            .padding(25.dp, 20.dp, 25.dp, 0.dp)
                            .height(130.dp),
                        verticalAlignment = Alignment.Top
                    ) { page ->
                        Box(
                            modifier = Modifier
                                .graphicsLayer {
                                    val pageOffSet =
                                        calculateCurrentOffsetForPage(page).absoluteValue

                                    lerp(
                                        start = 0.85f,
                                        stop = 1f,
                                        fraction = 1f - pageOffSet.coerceIn(0f, 1f)
                                    ).also {
                                        scaleX = it
                                        scaleY = it
                                    }
                                    alpha = lerp(
                                        start = 0.5f,
                                        stop = 1f,
                                        fraction = 1f - pageOffSet.coerceIn(0f, 1f)
                                    )
                                }
                                .fillMaxWidth()
                        ) {
                            val itemGetStarted = getStartedList[page]

                            Column(
                                modifier = Modifier
                                    .fillMaxWidth(),
                                verticalArrangement = Arrangement.Bottom
                            ) {
                                Text(
                                    modifier = Modifier.fillMaxWidth(),
                                    text = itemGetStarted.title,
                                    fontSize = MaterialTheme.typography.h6.fontSize,
                                    fontFamily = quicksand,
                                    fontWeight = FontWeight.Bold,
                                    textAlign = TextAlign.Center
                                )
                                Text(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(top = 10.dp),
                                    text = itemGetStarted.description,
                                    fontSize = MaterialTheme.typography.subtitle1.fontSize,
                                    fontFamily = quicksand,
                                    fontWeight = FontWeight.Normal,
                                    textAlign = TextAlign.Center
                                )
                            }
                        }
                    }

                    HorizontalPagerIndicator(
                        pagerState = pagerState,
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                    )

                    Row(
                        modifier = Modifier.fillMaxHeight(),
                        verticalAlignment = Alignment.Bottom
                    ) {
                        Button(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(20.dp, 0.dp, 20.dp, 10.dp)
                                .height(45.dp),
                            shape = RoundedCornerShape(50.dp),
                            colors = ButtonDefaults.buttonColors(
                                backgroundColor = Color.Blue
                            ),
                            onClick = { onClicked() },
                        ) {
                            Text(
                                text = "Get started",
                                fontSize = 18.sp,
                                color = Color.White,
                                fontFamily = FontFamily.SansSerif,
                                fontWeight = FontWeight.Normal
                            )
                        }

                    }
                }
            }
        }
    }
}

@ExperimentalPagerApi
@Composable
@Preview(showBackground = true)
fun GetStartedScreenPreview() {
//    GetStartedScreen(onClicked = ())
}