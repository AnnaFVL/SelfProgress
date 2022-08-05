package com.example.selfprogresscompose

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.selfprogresscompose.ui.theme.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val fileName = "selfProgressSharedPreferences"
        val context : Context = baseContext
        val sharedPreferences = context.getSharedPreferences(fileName, Context.MODE_PRIVATE)

        setContent {
            SelfProgressComposeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    SelfProgressScreen(sharedPreferences)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {

    Column(modifier = Modifier.padding(start = 20.dp, end = 20.dp)) {
        DrawTitle()
        /*
        DrawTable(
            basicList = selfProgressVM.basicTasks,
            onCheckedBasicTask = {},
            cardioList = selfProgressVM.cardioTasks,
            onCheckedCardioTask = {},
            pressList = selfProgressVM.pressTasks,
            onCheckedPressTask = {},
            stretchingList = selfProgressVM.stretchingTasks,
            onCheckedStretchingTask = {},
        )*/
        DrawResultLayout(
            resultText = "Test Text",
            resultColor = Color.Blue,
            onButtonClick = {  },
            onNewWeekClick = { })
    }

}