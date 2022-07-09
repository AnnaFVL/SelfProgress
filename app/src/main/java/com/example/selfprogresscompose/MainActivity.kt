package com.example.selfprogresscompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.expandHorizontally
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.example.selfprogresscompose.ui.theme.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContent {

            val weekDayList = listOf(stringResource(id = R.string.mon), stringResource(id = R.string.tue),
                stringResource(id = R.string.wed), stringResource(id = R.string.thur),
                stringResource(id = R.string.fri), stringResource(id = R.string.sat),
                stringResource(id = R.string.sun))
            val activityList = listOf(stringResource(id = R.string.basic), stringResource(id = R.string.cardio),
                stringResource(id = R.string.press), stringResource(id = R.string.stretching))
            val basicCheckBoxList = remember {
                listOf(mutableStateOf(false), mutableStateOf(false), mutableStateOf(false),
                    mutableStateOf(false), mutableStateOf(false), mutableStateOf(false),
                    mutableStateOf(false))
            }
            val cardioCheckBoxList = remember {
                listOf(mutableStateOf(false), mutableStateOf(false), mutableStateOf(false),
                    mutableStateOf(false), mutableStateOf(false), mutableStateOf(false),
                    mutableStateOf(false))
            }
            val pressCheckBoxList = remember {
                listOf(mutableStateOf(false), mutableStateOf(false), mutableStateOf(false),
                    mutableStateOf(false), mutableStateOf(false), mutableStateOf(false),
                    mutableStateOf(false))
            }
            val stretchingCheckBoxList = remember {
                listOf(mutableStateOf(false), mutableStateOf(false), mutableStateOf(false),
                    mutableStateOf(false), mutableStateOf(false), mutableStateOf(false),
                    mutableStateOf(false))
            }

            val model: MainActivityViewModel by viewModels()

            val selfProgressResult = remember { mutableStateOf("Сейчас посчитаем...") }
            //val basic1CheckBox = remember { mutableStateOf(false) }

            //////
            // Настройка размеров и цветов
            //////
            val headerTextSize: TextUnit = 18.sp
            val captionTextSize: TextUnit = 10.sp
            val tableCaptionTextSize: TextUnit = 10.sp

            val basicTextColor: Color = DarkBlue
            val badTextColor: Color = Red
            val normalTextColor: Color = Yellow
            val goodTextColor: Color = Green
            val tableTextColor: Color = Color.White
            val checkBoxColor: Color = Orange
            val checkBoxSubColor: Color = DarkOrange
            val tableHeaderColor: Color = LightPurple
            val tableSubHeaderColor: Color = PalePurple
            val buttonColor: Color = DarkPurple

            val borderPadding = 20.dp
            val tableHeaderRowSize = 20.dp
            val tableHeaderColumnSize = 80.dp


            //////
            // Заголовок
            //////
            Text(text= stringResource(id = R.string.header_text),
                fontSize = headerTextSize,
                color = basicTextColor,
                modifier = Modifier.padding(start=borderPadding, top=10.dp))

            //////
            // Таблица
            //////
            Column(
                modifier = Modifier
                    .padding(start = borderPadding, top = 40.dp, end = borderPadding)
                    .background(Color.White)
            ) {

                Row(
                    modifier = Modifier
                        .background(tableHeaderColor)
                        .height(tableHeaderRowSize)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Box(
                        modifier = Modifier
                            .background(tableSubHeaderColor)
                            .size(tableHeaderColumnSize, tableHeaderRowSize)
                    )
                    for (activityItem in activityList) {
                        Box(
                            modifier = Modifier.weight(1f)
                        ) {
                            Text(activityItem, fontSize = tableCaptionTextSize,
                                modifier = Modifier.fillMaxSize(),
                                color = tableTextColor)
                        }
                    }
                }

                Row(
                ) {
                    Column(
                        modifier = Modifier
                            .background(tableHeaderColor)
                            .height(330.dp)
                            .width(tableHeaderColumnSize),
                        verticalArrangement = Arrangement.SpaceAround
                    ) {
                        for (weekDay in weekDayList) {
                            Text(weekDay, fontSize = tableCaptionTextSize, color = tableTextColor)
                        }
                    }
                    for (activityItem in activityList) {
                        Column(
                            modifier = Modifier
                                .height(330.dp)
                                .weight(1f),
                            verticalArrangement = Arrangement.Top
                        ) {
                            var currentCheckBoxList = listOf<MutableState<Boolean>>()
                            when (activityItem) {
                                stringResource(id = R.string.basic) -> currentCheckBoxList = basicCheckBoxList
                                stringResource(id = R.string.cardio) -> currentCheckBoxList = cardioCheckBoxList
                                stringResource(id = R.string.press) -> currentCheckBoxList = pressCheckBoxList
                                stringResource(id = R.string.stretching) -> currentCheckBoxList = stretchingCheckBoxList
                            }
                            for (weekDayNumber in weekDayList.indices) {
                                Checkbox(checked = currentCheckBoxList[weekDayNumber].value,
                                    onCheckedChange = {
                                        currentCheckBoxList[weekDayNumber].value = it
                                    },
                                    colors  = CheckboxDefaults.colors(checkedColor = checkBoxColor, checkmarkColor = checkBoxSubColor))
                            }
                            /*
                            for (weekDayNumber in weekDayList.indices) {
                                Checkbox(checked = basicCheckBoxList[weekDayNumber].value,
                                    onCheckedChange = { basicCheckBoxList[weekDayNumber].value = it })
                            }*/
                            //Checkbox(checked = basic1CheckBox.value, onCheckedChange = { basic1CheckBox.value = it })
                            //Checkbox(checked = false, onCheckedChange = {  })

                        }
                    }

                }
            }

            //////
            // Кнопка
            //////
            Button(
                onClick = {
                          val random = java.util.Random().nextInt(5)
                    when (random) {
                        0 -> selfProgressResult.value = "Надо больше стараться!"
                        1 -> selfProgressResult.value = "Неплохо! Может не все удалось, но ты старалась"
                        2 -> selfProgressResult.value = "Статус: герой ;)"
                        3 -> selfProgressResult.value = "Кто будет лениться, тот конфетки не ест ;)"
                        4 -> selfProgressResult.value = "Отлично! Все получилось!"
                    }
                },
                colors = ButtonDefaults.buttonColors(backgroundColor = buttonColor, contentColor = Color.White),
                modifier = Modifier
                    .padding(start = borderPadding, top = 400.dp, end = borderPadding)
                    .fillMaxWidth()) {
                Text(stringResource(id = R.string.result_calc_button), fontSize = headerTextSize)
            }

            //////
            // Результат
            //////
            Text(text=stringResource(id = R.string.result_text),
                fontSize = captionTextSize,
                color = basicTextColor,
                modifier = Modifier.padding(start=borderPadding, top=450.dp))
            Text(text=model.getCalculatedResult(), //selfProgressResult.value, // model.getCalculatedResult()
                fontSize = headerTextSize,
                color = goodTextColor,
                modifier = Modifier.padding(start=borderPadding, top=470.dp))

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

}