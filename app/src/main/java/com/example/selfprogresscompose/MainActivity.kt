package com.example.selfprogresscompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.expandHorizontally
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.selfprogresscompose.ui.theme.SelfProgressComposeTheme

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
//import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            Text(text="Мои спортивные успехи",
                fontSize = 18.sp,
                modifier = Modifier.padding(start=20.dp, top=10.dp))
            Column(
                modifier = Modifier
                    .padding(start = 20.dp, top = 40.dp, end = 20.dp)
                    .background(Color.Gray)
            ) {

                Row(
                    modifier = Modifier
                        .background(Color.Blue)
                        .height(20.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Column(
                        modifier = Modifier
                            .background(Color.Green)
                            .width(80.dp),
                    ) {
                        Box(
                            modifier = Modifier
                                .background(Color.Yellow)
                                .size(20.dp)
                        )
                    }
                    Column(
                        modifier = Modifier
                            .background(Color.Magenta)
                            .weight(1f)
                    ) {
                        Text("зарядка", fontSize = 8.sp,
                            modifier = Modifier.fillMaxSize())
                    }
                    Column(
                        modifier = Modifier
                            .background(Color.Magenta)
                            .weight(1f)
                    ) {
                        Text("кардио", fontSize = 8.sp)
                    }
                    Column(modifier = Modifier
                        .background(Color.Magenta)
                        .weight(1f)
                    ) {
                        Text("пресс", fontSize = 8.sp)
                    }
                    Column(modifier = Modifier
                        .background(Color.Magenta)
                        .weight(1f)
                    ) {
                        Text("растяжка", fontSize = 8.sp)
                    }

                }
                Row(
                ) {
                    Column(
                        modifier = Modifier
                            .background(Color.Red)
                            .height(330.dp)
                            .width(80.dp),
                        verticalArrangement = Arrangement.SpaceAround
                    ) {
                        Text("понедельник", fontSize = 8.sp)
                        Text("вторник", fontSize = 8.sp)
                        Text("среда", fontSize = 8.sp)
                        Text("четверг", fontSize = 8.sp)
                        Text("пятница", fontSize = 8.sp)
                        Text("суббота", fontSize = 8.sp)
                        Text("воскресенье", fontSize = 8.sp)

                    }
                    Column(
                        modifier = Modifier
                            .background(Color.Cyan)
                            .height(330.dp)
                            .weight(1f),
                        verticalArrangement = Arrangement.Top
                    ) {
                        Checkbox(checked = false, onCheckedChange = {  })
                        Checkbox(checked = false, onCheckedChange = {  })
                        Checkbox(checked = false, onCheckedChange = {  })
                        Checkbox(checked = false, onCheckedChange = {  })
                        Checkbox(checked = false, onCheckedChange = {  })
                        Checkbox(checked = false, onCheckedChange = {  })
                        Checkbox(checked = false, onCheckedChange = {  })

                    }
                    Column(
                        modifier = Modifier
                            .background(Color.Cyan)
                            .height(330.dp)
                            .weight(1f),
                        verticalArrangement = Arrangement.Top
                    ) {
                        Checkbox(checked = false, onCheckedChange = {  })
                        Checkbox(checked = false, onCheckedChange = {  })
                        Checkbox(checked = false, onCheckedChange = {  })
                        Checkbox(checked = false, onCheckedChange = {  })
                        Checkbox(checked = false, onCheckedChange = {  })
                        Checkbox(checked = false, onCheckedChange = {  })
                        Checkbox(checked = false, onCheckedChange = {  })

                    }
                    Column(
                        modifier = Modifier
                            .background(Color.Cyan)
                            .height(330.dp)
                            .weight(1f),
                        verticalArrangement = Arrangement.Top
                    ) {
                        Checkbox(checked = false, onCheckedChange = {  })
                        Checkbox(checked = false, onCheckedChange = {  })
                        Checkbox(checked = false, onCheckedChange = {  })
                        Checkbox(checked = false, onCheckedChange = {  })
                        Checkbox(checked = false, onCheckedChange = {  })
                        Checkbox(checked = false, onCheckedChange = {  })
                        Checkbox(checked = false, onCheckedChange = {  })

                    }
                    Column(
                        modifier = Modifier
                            .background(Color.Cyan)
                            .height(330.dp)
                            .weight(1f),
                        verticalArrangement = Arrangement.Top
                    ) {
                        Checkbox(checked = false, onCheckedChange = {  })
                        Checkbox(checked = false, onCheckedChange = {  })
                        Checkbox(checked = false, onCheckedChange = {  })
                        Checkbox(checked = false, onCheckedChange = {  })
                        Checkbox(checked = false, onCheckedChange = {  })
                        Checkbox(checked = false, onCheckedChange = {  })
                        Checkbox(checked = false, onCheckedChange = {  })

                    }

                }
            }
            Button(
                onClick = {  },
                modifier = Modifier.padding(start=20.dp, top=400.dp, end=20.dp).fillMaxWidth()) {
                Text("Посчитать прогресс", fontSize = 18.sp)
            }
            Text(text="Результат",
                fontSize = 10.sp,
                modifier = Modifier.padding(start=20.dp, top=450.dp))
            Text(text="Сейчас посчитаем...",
                fontSize = 18.sp,
                modifier = Modifier.padding(start=20.dp, top=470.dp))

        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
 /*
    Text(text="Мои спортивные успехи",
        fontSize = 18.sp,
        modifier = Modifier.padding(start=20.dp, top=10.dp))
    Column(
        modifier = Modifier
            .padding(start = 20.dp, top = 40.dp, end = 20.dp)
            .background(Color.Gray)
    ) {

        Row(
            modifier = Modifier
                .background(Color.Blue)
                .height(20.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Column(
                modifier = Modifier
                    .background(Color.Green)
                    .width(80.dp),
            ) {
                Box(
                    modifier = Modifier
                        .background(Color.Yellow)
                        .size(20.dp)
                )
            }
            Column(
                modifier = Modifier
                    .background(Color.Magenta)
                    .weight(1f)
            ) {
                Text("зарядка", fontSize = 8.sp,
                modifier = Modifier.fillMaxSize())
            }
            Column(
                modifier = Modifier
                    .background(Color.Magenta)
                    .weight(1f)
            ) {
                Text("кардио", fontSize = 8.sp)
            }
            Column(modifier = Modifier
                .background(Color.Magenta)
                .weight(1f)
            ) {
                Text("пресс", fontSize = 8.sp)
            }
            Column(modifier = Modifier
                .background(Color.Magenta)
                .weight(1f)
            ) {
                Text("растяжка", fontSize = 8.sp)
            }

        }
        Row(
        ) {
            Column(
                modifier = Modifier
                    .background(Color.Red)
                    .height(330.dp)
                    .width(80.dp),
                verticalArrangement = Arrangement.SpaceAround
            ) {
                Text("понедельник", fontSize = 8.sp)
                Text("вторник", fontSize = 8.sp)
                Text("среда", fontSize = 8.sp)
                Text("четверг", fontSize = 8.sp)
                Text("пятница", fontSize = 8.sp)
                Text("суббота", fontSize = 8.sp)
                Text("воскресенье", fontSize = 8.sp)

            }
            Column(
                modifier = Modifier
                    .background(Color.Cyan)
                    .height(330.dp)
                    .weight(1f),
                verticalArrangement = Arrangement.Top
            ) {
                Checkbox(checked = false, onCheckedChange = {  })
                Checkbox(checked = false, onCheckedChange = {  })
                Checkbox(checked = false, onCheckedChange = {  })
                Checkbox(checked = false, onCheckedChange = {  })
                Checkbox(checked = false, onCheckedChange = {  })
                Checkbox(checked = false, onCheckedChange = {  })
                Checkbox(checked = false, onCheckedChange = {  })

            }
            Column(
                modifier = Modifier
                    .background(Color.Cyan)
                    .height(330.dp)
                    .weight(1f),
                verticalArrangement = Arrangement.Top
            ) {
                Checkbox(checked = false, onCheckedChange = {  })
                Checkbox(checked = false, onCheckedChange = {  })
                Checkbox(checked = false, onCheckedChange = {  })
                Checkbox(checked = false, onCheckedChange = {  })
                Checkbox(checked = false, onCheckedChange = {  })
                Checkbox(checked = false, onCheckedChange = {  })
                Checkbox(checked = false, onCheckedChange = {  })

            }
            Column(
                modifier = Modifier
                    .background(Color.Cyan)
                    .height(330.dp)
                    .weight(1f),
                verticalArrangement = Arrangement.Top
            ) {
                Checkbox(checked = false, onCheckedChange = {  })
                Checkbox(checked = false, onCheckedChange = {  })
                Checkbox(checked = false, onCheckedChange = {  })
                Checkbox(checked = false, onCheckedChange = {  })
                Checkbox(checked = false, onCheckedChange = {  })
                Checkbox(checked = false, onCheckedChange = {  })
                Checkbox(checked = false, onCheckedChange = {  })

            }
            Column(
                modifier = Modifier
                    .background(Color.Cyan)
                    .height(330.dp)
                    .weight(1f),
                verticalArrangement = Arrangement.Top
            ) {
                Checkbox(checked = false, onCheckedChange = {  })
                Checkbox(checked = false, onCheckedChange = {  })
                Checkbox(checked = false, onCheckedChange = {  })
                Checkbox(checked = false, onCheckedChange = {  })
                Checkbox(checked = false, onCheckedChange = {  })
                Checkbox(checked = false, onCheckedChange = {  })
                Checkbox(checked = false, onCheckedChange = {  })

            }

        }
    }
    Button(
        onClick = {  },
        modifier = Modifier.padding(start=20.dp, top=400.dp, end=20.dp).fillMaxWidth()) {
        Text("Посчитать прогресс", fontSize = 18.sp)
    }
    Text(text="Результат",
        fontSize = 10.sp,
        modifier = Modifier.padding(start=20.dp, top=450.dp))
    Text(text="Сейчас посчитаем...",
        fontSize = 18.sp,
        modifier = Modifier.padding(start=20.dp, top=470.dp))
*/


/*val count = remember{mutableStateOf(0)}

    Text(text="Clicks: ${count.value}",
        fontSize = 18.sp,
        modifier = Modifier.background(Color.Yellow).size(300.dp, 100.dp).clickable { count.value += 1 }
    )*/
    /*
    SelfProgressComposeTheme {
        Greeting("Android")
    }*/
}