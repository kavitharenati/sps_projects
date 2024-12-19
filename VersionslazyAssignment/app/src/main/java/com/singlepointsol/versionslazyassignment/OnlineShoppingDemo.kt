package com.singlepointsol.versionslazyassignment

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun OnlineShoppingDemo(modifier: Modifier = Modifier){
    LazyColumnDemo()
}
@Composable
fun LazyColumnDemo(){
    LazyColumn {
        itemsIndexed(items = getAllShopping(), itemContent = {index,item -> ShoppingItem(item = item) })
    }
}
@Composable
fun ShoppingItem(item: Shopping, modifier: Modifier = Modifier) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        shape = RoundedCornerShape(6.dp),
        elevation = CardDefaults.cardElevation(5.dp)
    ) {
        Row(
            Modifier.fillMaxSize().padding(16.dp)
                .background(color = MaterialTheme.colorScheme.inverseOnSurface)
                .size(96.dp).clip(RoundedCornerShape(16.dp))
        ) {
            Image(
                painter = painterResource(id = item.shoppingImage),
                contentDescription = item.shoppingName,
                Modifier.padding(8.dp).align(Alignment.CenterVertically)
            )
            Column(
                Modifier.fillMaxSize().padding(8.dp).align(Alignment.CenterVertically),
                Arrangement.Center
            ) {
                Text(
                    text = item.shoppingName,
                    style = TextStyle(
                        color = Color.Blue,
                        fontSize = 22.sp,
                        fontStyle = FontStyle.Italic
                    )
                )
                Text(
                    text = item.shoppingDetails,
                    style = TextStyle(
                        color = Color.Green,
                        fontSize = 16.sp,
                        fontStyle = FontStyle.Italic
                    )
                )
            }

        }
    }
}


