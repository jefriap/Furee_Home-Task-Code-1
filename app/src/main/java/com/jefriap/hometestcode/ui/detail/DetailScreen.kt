package com.jefriap.hometestcode.ui.detail

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import android.content.Intent
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.ScrollableDefaults
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jefriap.hometestcode.R
import com.jefriap.hometestcode.data.ClothesData
import com.jefriap.hometestcode.data.DataDummy
import com.jefriap.hometestcode.ui.main.MainActivity
import com.jefriap.hometestcode.ui.theme.quicksand
import java.text.NumberFormat
import java.util.*

@Composable
fun DetailScreen(data: ClothesData) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {
        ImageItemDetail(data = data)

        Column(
           modifier = Modifier
               .fillMaxSize()
               .padding(top = 20.dp)
               .verticalScroll(rememberScrollState())
        ) {
            ProfileUser()

            TextDetail(data = data)

            PickSize()

            BtnAddToChart(data = data)
        }
    }
}

@Composable
fun BtnAddToChart(data: ClothesData) {
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .padding(top = 25.dp),
        shape = RoundedCornerShape(30.dp),
        onClick = {}
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically
        ) {

            val localeID = Locale("in", "ID")
            val numberFormat = NumberFormat.getCurrencyInstance(localeID)
            val price = numberFormat.format(data.price).toString()
            Text(
                text = price,
                fontSize = 16.sp,
                fontFamily = quicksand,
                fontWeight = FontWeight.ExtraBold,
                modifier = Modifier
                    .padding(end = 15.dp)
            )
            Surface(
                modifier = Modifier
                    .height(25.dp)
                    .width(2.dp),
                color = Color.White
            ) {}
            Text(
                text = "Add to cart",
                fontSize = 16.sp,
                fontFamily = quicksand,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier
                    .padding(start = 48.dp)
            )
        }
    }
}

@Composable
fun PickSize() {
    Column(
        modifier = Modifier.padding(top = 10.dp)
    ) {
        Text(
            text = "Select size",
            fontSize = MaterialTheme.typography.h6.fontSize,
            fontFamily = quicksand,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(end = 100.dp, bottom = 10.dp)
        )

        val size = listOf("S","M","L","XL")

        Row(
            modifier = Modifier
                .width(215.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            size.forEach() {
                ButtonSize(size = it)
            }
        }

    }
}

@Composable
fun ButtonSize(size: String) {
    Surface(
        modifier = Modifier
            .height(45.dp)
            .width(45.dp)
            .clip(CircleShape)
            .border(
                width = 1.dp,
                color = Color.Black,
                shape = RoundedCornerShape(50.dp)
            )
            .clickable(enabled = true) {},
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = size,
                fontSize = MaterialTheme.typography.h6.fontSize,
                fontFamily = quicksand,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}

@Composable
fun TextDetail(data: ClothesData){
    Column() {
        Text(
            text = data.productName,
            fontSize = MaterialTheme.typography.h6.fontSize,
            fontFamily = quicksand,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(end = 100.dp, bottom = 10.dp)
        )
        Text(
            text = stringResource(id = data.productDescription),
            fontSize = MaterialTheme.typography.subtitle1.fontSize,
            fontFamily = quicksand,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Justify
        )
    }
}

@Composable
fun ProfileUser() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Max)
            .padding(bottom = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Surface(
            modifier = Modifier
                .size(55.dp)
                .clip(CircleShape),
            color = Color.Cyan,

            ) {
            Box(
                modifier = Modifier
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "U",
                    color = Color.White,
                    fontSize = MaterialTheme.typography.h6.fontSize,
                    fontFamily = quicksand,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }

        Column(
            modifier = Modifier
                .padding(10.dp, 0.dp),
            verticalArrangement = Arrangement.SpaceAround
        ) {
            Text(
                text = "Ucito apparel",
                fontSize = MaterialTheme.typography.subtitle1.fontSize,
                fontFamily = quicksand,
                fontWeight = FontWeight.SemiBold
            )

            Text(
                text = "Official store",
                color = Color.DarkGray,
                fontSize = MaterialTheme.typography.subtitle2.fontSize,
                fontFamily = quicksand,
                fontWeight = FontWeight.Normal
            )
        }

        Surface(
            modifier = Modifier
                .padding(start = 30.dp)
                .height(40.dp)
                .width(140.dp)
                .border(
                    width = 1.dp,
                    color = Color.Green,
                    shape = RoundedCornerShape(50.dp)
                )
                .clickable(enabled = true) {},
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.CheckCircle,
                    contentDescription = "Check Icon",
                    tint = Color.Green
                )
                Text(
                    text = "Following",
                    color = Color.Green,
                    fontSize = MaterialTheme.typography.subtitle1.fontSize,
                    fontFamily = quicksand,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }
    }
}

@Composable
fun ImageItemDetail(data: ClothesData) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(371.dp),
        shape = RoundedCornerShape(20.dp)
    ) {
        val imageId = remember {
            mutableStateOf(data.imageProduct[0])
        }

        ImageItem(imageId = imageId)

        TopAppBar()

        AnotherImageItem(data = data){
            imageId.value = it
        }

    }
}

@Composable
fun ImageItem(
    imageId: MutableState<Int>
) {
    Image(
        modifier = Modifier
            .fillMaxSize(),
        painter = painterResource(id = imageId.value),
        contentDescription = "Image product"
    )
}

@Composable
fun TopAppBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp, 15.dp),
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        val context = LocalContext.current
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = "Button Back",
            modifier = Modifier
                .size(28.dp)
                .clickable {
                    context.findActivity()?.onBackPressed()
                }
        )
        Row() {
            val iconFav = remember {
                mutableStateOf(Icons.Default.FavoriteBorder)
            }
            val colorFav = remember {
                mutableStateOf(Color.Black)
            }
            val isSelected = remember {
                mutableStateOf(false)
            }
            Icon(
                imageVector = iconFav.value,
                contentDescription = "Button Favorite",
                tint = colorFav.value,
                modifier = Modifier
                    .size(30.dp)
                    .padding(end = 5.dp)
                    .clickable {
                        isSelected.value = !isSelected.value
                        if (isSelected.value) {
                            iconFav.value = Icons.Default.Favorite
                            colorFav.value = Color.Red
                        } else {
                            iconFav.value = Icons.Default.FavoriteBorder
                            colorFav.value = Color.Black
                        }
                    }
            )
            Icon(
                painter = painterResource(id = R.drawable.shopping_bag_outline),
                contentDescription = "Button Favorite",
                modifier = Modifier
                    .size(26.dp)
                    .clickable { }
            )

        }
    }
}

fun Context.findActivity(): Activity? {
    var context = this
    while (context is ContextWrapper) {
        if (context is Activity) return context
        context = context.baseContext
    }
    return null
}

@Composable
fun AnotherImageItem(
    data: ClothesData,
    imageId: (Int) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.End
    ) {
        data.imageProduct.forEach() {
            Image(
                painter = painterResource(id = it),
                contentDescription = "Image produck",
                modifier = Modifier
                    .padding(5.dp)
                    .size(50.dp)
                    .clip(CircleShape)
                    .clickable { imageId(it) }
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun DetailScreenPrev() {
    val data = DataDummy().getAllData()[0]
    DetailScreen(data)
}