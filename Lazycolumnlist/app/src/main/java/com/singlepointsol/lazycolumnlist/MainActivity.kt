package com.singlepointsol.lazycolumnlist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.singlepointsol.lazycolumnlist.ui.theme.LazycolumnListTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val friendslist = listOf("kavitha","Alekhya","Adilakshmi","sashank","akhilesh","anirudh")

            FriendsListDemo(friendslist)
        }

    }
}
@Composable
fun FriendsListDemo(friendsList: List<String>){
    LazyColumn(Modifier.fillMaxWidth().padding(16.dp)){
        items(friendsList){
            Text(text = it, style = TextStyle(color = Color.Blue, fontSize = 24.sp))
            Spacer(Modifier.height(10.dp))
        }
    }
}

