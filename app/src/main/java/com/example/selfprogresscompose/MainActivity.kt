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
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.selfprogresscompose.ui.theme.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        // Context
        //val context = applicationContext //val context = LocalContext.current

        // ViewModel
        val model: MainActivityViewModel by viewModels()
        //model.readSharePreferences(context)
        // UIState
        //val uiState = model.uiState


        super.onCreate(savedInstanceState)
        setContent {

            Column () {
                StateContainer(model)
            }

        }
    }
}

@Composable
fun StateContainer(viewModel: MainActivityViewModel) {

    Column(Modifier.padding(start = 20.dp, end = 20.dp)) {
        DrawTitle()
        DrawTable(
            checkBoxValue = viewModel.boolCheck1.value,
            onValueChange = { viewModel.updateBool1(it) }
        )
        DrawResultLayout(
            resultText = viewModel.resultText.value,
            onButtonClick = { viewModel.сalculatedResult() })
    }

}

@Composable
fun DrawTitle() {
    Spacer(modifier = Modifier.height(10.dp))
    Text(text= stringResource(id = R.string.header_text),
        style = Typography.subtitle1)
    Spacer(modifier = Modifier.height(10.dp))
}

@Composable
fun DrawTable(checkBoxValue: Boolean, onValueChange: (Boolean) -> Unit) {
    val heightOfFirstRaw = 20.dp
    val widthOfFirstColumn = 80.dp
    val tableHeight = 350.dp

    Row(modifier = Modifier
        .background(Color.White)
        .fillMaxWidth()
        .height(tableHeight)) {
        Column(modifier = Modifier
            .background(LightPurple)
            .width(widthOfFirstColumn)) {
            Box(modifier = Modifier
                .background(DarkOrange)
                .height(heightOfFirstRaw)
                .width(widthOfFirstColumn)
            )
            Column(modifier = Modifier.fillMaxHeight(1f),
                verticalArrangement = Arrangement.SpaceAround) {
                for (day in WeekDays.dayList) {
                    Text(
                        text = day, style = Typography.subtitle2,
                        modifier = Modifier.padding(start = 8.dp)
                    )
                }
            }
        }
        for (activityItem in SportActivities.sportList) {
            Column(modifier = Modifier.weight(1f)) {
                Box(modifier = Modifier
                    .background(LightPurple)
                    .height(heightOfFirstRaw)
                    .fillMaxWidth()) {
                        Text(text = activityItem,
                        style = Typography.subtitle2,
                        modifier = Modifier
                            .padding(top = 2.dp)
                            .fillMaxWidth(1f),
                        textAlign = TextAlign.Center)
                }
                for (day in WeekDays.dayList) {
                    Checkbox(checked = checkBoxValue,
                        onCheckedChange = {
                            onValueChange(it)
                        },
                        colors  = CheckboxDefaults.colors(Orange, DarkOrange),
                        modifier = Modifier.fillMaxWidth(1f))

                }
            }
        }
    }
}


@Composable
fun DrawResultLayout(resultText: String, onButtonClick: () -> Unit) {
    Spacer(modifier = Modifier.height(10.dp))
    Button(
        onClick = { onButtonClick()}, //{ /*caclResult(model, context)*/ },
        colors = ButtonDefaults.buttonColors(backgroundColor = DarkPurple),
        modifier = Modifier.fillMaxWidth()) {
        Text(stringResource(id = R.string.result_calc_button), style = Typography.button)
    }

    Spacer(modifier = Modifier.height(6.dp))
    Text(text=stringResource(id = R.string.result_text),
        style = Typography.caption)

    Spacer(modifier = Modifier.height(6.dp))
    Text(text=resultText, //model.resultText, // model.getCalculatedResult()
        style = Typography.subtitle1)
    Spacer(modifier = Modifier.height(10.dp))
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {

    Column(Modifier.padding(start = 20.dp, end = 20.dp)) {
        DrawTitle()
        DrawTable(
            checkBoxValue = false,
            onValueChange = {})
        DrawResultLayout(
            resultText = "Test text",
            onButtonClick = {})
    }

}

object WeekDays {
    val dayList = listOf("понедельник", "вторник", "среда", "четверг", "пятница", "суббота", "воскресенье")
}

object SportActivities {
    val sportList = listOf("зарядка", "кардио", "пресс", "растяжка")
}