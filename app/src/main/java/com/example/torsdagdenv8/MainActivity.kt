package com.example.torsdagdenv8

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.torsdagdenv8.ui.theme.TorsdagDenV8Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TorsdagDenV8Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                 MyView1()
                }
            }
        }
    }
}

@Composable
fun MyView1(){
    val items = remember { mutableStateListOf<String>() }
    Column {
        Row(modifier = Modifier
            .background(Color.Blue)
            .height(75.dp)
            .fillMaxWidth(1F)
            .padding(horizontal = 30.dp)
        ) {

            Button(onClick = {
                items.add("X")
            }) {
                Text("X")
            }

            Button(onClick = {
                items.add("Y")
            }) {
                Text("Y")

            }

        }

                MyList(items)




            Button(onClick = {
                             items.clear()
            }){
                Text("Reat")
            }



        
    }

}

@Composable
fun MyList(items: List<String>) {
    // Exempel på en lista med hårdkodade data
    //val items = listOf("Item 1", "Item 2", "Item 3")

    // Visa listan med hjälp av LazyColumn
    LazyColumn {
        items(items.size) { index ->
            Text(
                text = items[index],
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
            )
            Divider() // Divider mellan varje element i listan
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TorsdagDenV8Theme {
       MyView1()
    }
}