package com.example.nerdsguide.bodyconstruction

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.nerdsguide.R
import com.example.nerdsguide.util.DrawerEvents
import kotlinx.coroutines.coroutineScope

@Composable
fun DrawerMenu(onEvent:(DrawerEvents)->Unit) {

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.drawer_list_bg),
            contentDescription = "Background",
            contentScale = ContentScale.Crop
        )
        Column(modifier = Modifier.fillMaxSize()) {
            Header()
            Body(){event->
                onEvent(event)

            }
        }
    }
}

@Composable
fun Body(onEvent: (DrawerEvents) -> Unit) {
    val list = stringArrayResource(id = R.array.drawer_list)

    LazyColumn(modifier = Modifier.fillMaxSize()) {
        itemsIndexed(list) { index, title ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(3.dp),
                backgroundColor = Color.LightGray
            ) {
                Text(text = title, modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        onEvent(DrawerEvents.OnItemClick(title, index))

                    }
                    .padding(2.dp)
                    .wrapContentWidth(), fontWeight = FontWeight.Bold)

            }
        }
    }
}

@Composable
fun Header() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(170.dp)
            .padding(5.dp), shape = RoundedCornerShape(10.dp), border = BorderStroke(
            1.dp,
            Color.Red
        )
    ) {
        Box(modifier = Modifier.fillMaxSize()) // needs content alignment//
        {
            Image(
                painter = painterResource(id = R.drawable.header_bg),
                contentDescription = "Header",
                modifier = Modifier.fillMaxSize(), contentScale = ContentScale.Crop
            )
            Text(
                text = "Nerds' Guide",
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Red)
                    .padding(10.dp),
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }
    }
}