package com.example.selfprogresscompose

import android.content.Context
import android.os.Bundle
import android.widget.Toast
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.selfprogresscompose.ui.theme.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        // Context
        val context = applicationContext //val context = LocalContext.current
        // ViewModel
        val model: MainActivityViewModel by viewModels()
        model.readSharePreferences(context)
        // UIState
        val uiState = model.uiState


        val weekDayList = listOf(getString(R.string.mon), getString(R.string.tue), getString(R.string.wed),
            getString(R.string.thur), getString(R.string.fri), getString(R.string.sat), getString(R.string.sun))
        /*
            stringResource(id = R.string.mon), stringResource(id = R.string.tue),
            stringResource(id = R.string.wed), stringResource(id = R.string.thur),
            stringResource(id = R.string.fri), stringResource(id = R.string.sat),
            stringResource(id = R.string.sun))*/
        val activityList = listOf(getString(R.string.basic), getString(R.string.cardio), getString(R.string.press), getString(R.string.stretching))
            /*stringResource(id = R.string.basic), stringResource(id = R.string.cardio),
            stringResource(id = R.string.press), stringResource(id = R.string.stretching))*/


        super.onCreate(savedInstanceState)
        setContent {

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

                            for (weekDayNumber in weekDayList.indices) {

                                // val mutableState = remember { mutableStateOf(значение) }
                                when (activityItem) {
                                    getString(R.string.basic) -> DrawCheckBox( uiState.basicList[weekDayNumber]) //model.getBasicList()[weekDayNumber] = it
                                    getString(R.string.cardio) -> DrawCheckBox( uiState.cardioList[weekDayNumber])
                                    getString(R.string.press) -> DrawCheckBox( uiState.pressList[weekDayNumber])
                                    getString(R.string.stretching) -> DrawCheckBox( uiState.stretchingList[weekDayNumber])
                                }

                            }

                    }

                }
            }

            //////
            // Кнопка
            //////
            Button(
                onClick = { /*caclResult(model, context)*/ },
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
            Text(text=model.resultText, // model.getCalculatedResult()
                fontSize = headerTextSize,
                color = goodTextColor,
                modifier = Modifier.padding(start=borderPadding, top=470.dp))

        }
    }
}

@Composable
fun DrawCheckBox(checkBoxState: Boolean) {

    val checkBoxColor: Color = Orange
    val checkBoxSubColor: Color = DarkOrange

    Checkbox(checked = checkBoxState,
        onCheckedChange = {
            //checkBoxState = it
        },
        colors  = CheckboxDefaults.colors(checkedColor = checkBoxColor, checkmarkColor = checkBoxSubColor))

    }


}

/*
fun caclResult(model: MainActivityViewModel, context: Context) {
    model.saveListsValues(context)
}*/

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {

}