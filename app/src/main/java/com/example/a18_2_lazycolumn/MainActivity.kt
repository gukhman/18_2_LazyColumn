package com.example.a18_2_lazycolumn

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Start()
        }
    }
}

@Composable
fun Start() {

    val guns = listOf<Gun>(
        Gun(
            "Browning High-Power",
            "https://mgssk.ru/wp-content/uploads/2018/08/Browning-High-Power.jpg",
            "9x19"
        ),
        Gun(
            "Colt 1911",
            "https://mgssk.ru/wp-content/uploads/2019/03/colt-1911-norinco-WEB.png",
            ".45"
        ),
        Gun(
            "Пистолет Ярыгина",
            "https://mgssk.ru/wp-content/uploads/2013/09/Viking-gun-min.png",
            "9x19"
        ),
        Gun(
            "Sig — Sauer P226",
            "https://mgssk.ru/wp-content/uploads/2013/09/%D0%BF%D0%B8%D1%81%D1%82%D0%BE%D0%BB%D0%B5%D1%82-EZ-9.jpg",
            "9x19"
        ),
        Gun(
            "Colt M1873 PeaceMaker",
            "https://mgssk.ru/wp-content/uploads/2018/03/Sauer-City-Marshal.jpg",
            "9x19"
        )
    )

    val rifles = listOf<Rifle>(
        Rifle(
            "Снайперская винтовка Драгунова СВД",
            "https://mgssk.ru/wp-content/uploads/2013/09/tigr5-min.jpg",
            4.3F
        ),
        Rifle(
            "Автомат Калашникова (АКМ)",
            "https://mgssk.ru/wp-content/uploads/2013/09/akm-min.jpg",
            2.93F
        ),
        Rifle(
            "Винтовка SDI XR-15 (М-16)",
            "https://mgssk.ru/wp-content/uploads/2013/09/sdi-xr-15-min.jpg",
            3.4F
        ),
        Rifle(
            "Winchester 1892",
            "https://mgssk.ru/wp-content/uploads/2018/07/rossi92.jpg",
            2.25F
        ),
        Rifle(
            "Ружье помповое Remington 870",
            "https://mgssk.ru/wp-content/uploads/2018/03/Remington-870.jpg",
            2.7F
        )
    )


    Scaffold(
        content = { padding ->
            Column(
                modifier = Modifier
                    .padding(padding)
            ) {
                Column(Modifier.padding(all = 16.dp)) {
                    Text(
                        text = "Пистолеты:",
                        fontSize = 32.sp,
                    )
                    LazyRow {
                        items(guns) { gun ->
                            Card(modifier = Modifier.padding(8.dp)) {
                                Column(Modifier.fillMaxWidth()) {
                                    Text(
                                        text = gun.name,
                                        fontSize = 16.sp,
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .align(Alignment.Start)
                                            .padding(8.dp, 8.dp, 8.dp, 0.dp)
                                    )
                                    Text(
                                        text = "Калибр: " + gun.caliber,
                                        fontSize = 12.sp,
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .align(Alignment.Start)
                                            .padding(8.dp, 0.dp, 8.dp, 0.dp)
                                    )
                                    AsyncImage(
                                        model = gun.image,
                                        contentDescription = "",
                                        modifier = Modifier
                                            .padding(12.dp)
                                            .size(150.dp)
                                    )
                                }
                            }
                        }
                    }
                    Text(
                        text = "Винтовки:",
                        fontSize = 32.sp,
                    )
                    LazyColumn {
                        items(rifles) { rifle ->
                            Card(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(8.dp)
                            ) {
                                Row(
                                    //verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier
                                        .clickable {}
                                        .padding(8.dp)
                                ) {
                                    AsyncImage(
                                        model = rifle.image,
                                        contentDescription = "",
                                        modifier = Modifier
                                            .padding(4.dp)
                                            .size(150.dp)
                                        //.clip(CircleShape)

                                    )
                                    Column {
                                        Text(
                                            text = rifle.name,
                                            fontSize = 16.sp,
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .align(Alignment.Start)
                                                .padding(8.dp, 8.dp, 8.dp, 0.dp)
                                        )
                                        Text(
                                            text = "Вес: " + rifle.weight,
                                            fontSize = 12.sp,
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .align(Alignment.Start)
                                                .padding(8.dp, 0.dp, 8.dp, 0.dp)
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    )
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Preview() {
    Start()
}