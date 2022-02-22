package com.jefriap.hometestcode.ui.main.home

import android.content.Intent
import android.util.Log
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import com.jefriap.hometestcode.R
import com.jefriap.hometestcode.data.ClothesData
import com.jefriap.hometestcode.data.DataDummy
import com.jefriap.hometestcode.ui.detail.DetailScreenActivity
import com.jefriap.hometestcode.ui.theme.quicksand
import com.jefriap.hometestcode.ui.theme.roboto
import java.text.NumberFormat
import java.util.*

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
    ){
        TopAppBar()

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {

            CardSearch()

            ClothesCategory()

            StaggeredGrid()
        }

    }
}

@Composable
fun TopAppBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        IconButton(
            modifier = Modifier.alpha(ContentAlpha.medium),
            onClick = { Log.d("top_app_bar", "Ini btn menu") }
        ) {
            Icon(
                imageVector = Icons.Outlined.Menu,
                contentDescription = "Menu Icon Button")
        }
        IconButton(
            modifier = Modifier.alpha(ContentAlpha.medium),
            onClick = { Log.d("top_app_bar", "Ini btn shop") }
        ) {
            Icon(
                painter = painterResource(id = R.drawable.shopping_bag_outline),
                contentDescription = "Shopping bag Icon Button")
        }
    }
}

@Composable
fun CardSearch() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .height(200.dp),
        backgroundColor = Color.Cyan,
        shape = RoundedCornerShape(20.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(10.dp, 25.dp, 10.dp, 15.dp)
        ) {
            Text(
                text = "Find the best",
                fontSize = MaterialTheme.typography.h5.fontSize,
                fontFamily = quicksand,
                fontWeight = FontWeight.SemiBold,
                color = Color.DarkGray
            )
            Text(
                text = "clothes for you",
                fontSize = MaterialTheme.typography.h5.fontSize,
                fontFamily = quicksand,
                fontWeight = FontWeight.SemiBold,
                color = Color.DarkGray
            )
            Box(
                modifier = Modifier
                    .fillMaxSize(),
                contentAlignment = Alignment.BottomCenter
            ) {

                var search by remember { mutableStateOf("") }

                Surface(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 3.dp)
                        .height(50.dp),
                    shape = RoundedCornerShape(40.dp)
                ){}
                TextField(
                    value = search,
                    onValueChange = { newValue ->
                        search = newValue
                    },
                    textStyle = TextStyle(
                        fontSize = 16.sp,
                        fontFamily = quicksand,
                        fontWeight = FontWeight.Black,
                        color = Color.DarkGray
                    ),
                    placeholder = {
                        Text(
                            text = "Search your clothes",
                            fontFamily = quicksand,
                            fontWeight = FontWeight.SemiBold
                        )
                    },
                    leadingIcon = {
                        Icon(imageVector = Icons.Default.Search, contentDescription = "Search icon")
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp),
                    singleLine = true,
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent
                    )
                )
            }
        }
    }
}

@Composable
fun ClothesCategory() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp, 5.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "Categories",
            fontSize = 16.sp,
            fontFamily = quicksand,
            fontWeight = FontWeight.Normal
        )

        Button(
            onClick = {
                Log.d("ViewAll", "ViewAll is clicked.")
            },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Transparent,
            ),
            elevation = ButtonDefaults.elevation(0.dp)
        ){
            Text(
                text = "View all",
                fontFamily = quicksand,
                fontWeight = FontWeight.Normal
            )
        }
    }

    LazyRow(
        modifier = Modifier
            .fillMaxWidth(),
        contentPadding = PaddingValues(5.dp, 0.dp)
    ) {
        val clothesCategory = listOf(
            "Clothes",
            "Shoes",
            "Bags",
            "Shirts",
            "Jeans",
            "Jackets"
        )
        items(count = clothesCategory.size) {  clothes ->
            ButtonCategory(title = clothesCategory[clothes])
        }
    }
}

@Composable
fun ButtonCategory(
    title: String,
    bgColor: Color = Color.White
) {
    Button(
        onClick = {  },
        modifier = Modifier
            .height(35.dp)
            .width(IntrinsicSize.Max)
            .padding(5.dp, 0.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = bgColor,
        ),
        elevation = ButtonDefaults.elevation(2.dp),
        shape = RoundedCornerShape(30.dp)
    ) {
        Text(
            text = title,
            fontSize = 12.sp,
            color = Color.DarkGray
        )
    }
}

@Composable
fun StaggeredGrid() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp, 5.dp, 5.dp, 35.dp)
    ) {
        StaggeredVerticalGrid(
            numColumns = 2, //put the how many column you want
            modifier = Modifier.padding(5.dp)
        ) {

            val dataClothes: List<ClothesData> = DataDummy().getAllData()

            dataClothes.forEach { data ->
                ListClothes(data = data)
            }
        }
    }
}

@Composable
fun ListClothes(data: ClothesData) {
    val context = LocalContext.current
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp)
            .clickable {
                Log.d("Click_Item", "$data")
                val detailScreen = Intent(context, DetailScreenActivity::class.java)
                detailScreen.putExtra(DetailScreenActivity.EXTRA_DATA, data)
                ContextCompat.startActivity(context, detailScreen, null)
            },
        elevation = 3.dp,
        backgroundColor = Color.White,
        shape = RoundedCornerShape(20.dp),
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
        ) {
            Image(
                painter = painterResource(id = data.imageProduct[0]),
                contentDescription = "Image Clothes",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(176.dp)
            )

            Column(
                modifier = Modifier
                    .padding(10.dp)
            ) {

                Text(
                    text = data.productName,
                    fontSize = 14.sp,
                    fontFamily = quicksand,
                    fontWeight = FontWeight.SemiBold
                )

                val localeID = Locale("in", "ID")
                val numberFormat = NumberFormat.getCurrencyInstance(localeID)
                val price = numberFormat.format(data.price).toString()

                Text(
                    text = price,
                    fontSize = 14.sp,
                    fontFamily = quicksand,
                    fontWeight = FontWeight.Normal
                )
            }
        }
    }
}


@Composable
@Preview("prev1", showBackground = true)
fun HomeScreenPreview() {
    HomeScreen()
}


@Composable
@Preview("prev2", showBackground = true)
fun HomeScreenPreview2() {

}