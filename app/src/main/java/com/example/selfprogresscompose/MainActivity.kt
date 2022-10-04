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
import androidx.room.Room
import com.example.selfprogresscompose.Data.SelfProgressDB
import com.example.selfprogresscompose.ui.theme.*


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //val context : Context = baseContext
        val selfProgressDB : SelfProgressDB = Room.databaseBuilder(applicationContext, SelfProgressDB::class.java, "tasksDB").allowMainThreadQueries().build()

        setContent {
            SelfProgressComposeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    SelfProgressScreen(selfProgressDB)
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