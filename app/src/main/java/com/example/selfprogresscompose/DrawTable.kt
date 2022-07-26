package com.example.selfprogresscompose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Checkbox
import androidx.compose.material.CheckboxDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.selfprogresscompose.ui.theme.DarkOrange
import com.example.selfprogresscompose.ui.theme.LightPurple
import com.example.selfprogresscompose.ui.theme.Orange
import com.example.selfprogresscompose.ui.theme.Typography


@Composable
fun DrawTable(basicList: List<SportTask>,
              onCheckedBasicTask: (SportTask, Boolean) -> Unit,
              cardioList: List<SportTask>,
              onCheckedCardioTask: (SportTask, Boolean) -> Unit,
              pressList: List<SportTask>,
              onCheckedPressTask: (SportTask, Boolean) -> Unit,
              stretchingList: List<SportTask>,
              onCheckedStretchingTask: (SportTask, Boolean) -> Unit,
              modifier: Modifier = Modifier) {
//fun DrawTable(checkBoxValue: Boolean, onValueChange: (Boolean) -> Unit) {
//fun DrawTable(checkBoxList: List<MutableState<Boolean>>, onValueChange: (Boolean) -> Unit) {
    val heightOfFirstRaw = 20.dp
    val widthOfFirstColumn = 80.dp
    val tableHeight = 350.dp

    Row(modifier.background(Color.White)
        .fillMaxWidth()
        .height(tableHeight)) {

        DrawWeekDayColumn(widthOfFirstColumn, heightOfFirstRaw, modifier)

        DrawActivityColumn("зарядка", heightOfFirstRaw, basicList, onCheckedBasicTask, modifier)
        DrawActivityColumn("кардио", heightOfFirstRaw, cardioList, onCheckedCardioTask, modifier)
        DrawActivityColumn("пресс", heightOfFirstRaw, pressList, onCheckedPressTask, modifier)
        DrawActivityColumn("растяжка", heightOfFirstRaw, stretchingList, onCheckedStretchingTask, modifier)

        /*
        for (activityItem in SportActivities.sportList) {
            Column(modifier = Modifier.weight(1f)) {
                DrawActivityColumn(activityItem, heightOfFirstRaw, checkBoxValue, onValueChange)
            }
        }*/
    }
}

@Composable
fun DrawWeekDayColumn(widthOfFirstColumn: Dp, heightOfFirstRaw: Dp, modifier: Modifier = Modifier) {
    Column(modifier.background(LightPurple)
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
}

@Composable
fun DrawActivityColumn(activity: String, heightOfFirstRaw: Dp, list: List<SportTask>, onCheckedTask: (SportTask, Boolean) -> Unit, modifier: Modifier = Modifier) {
// fun DrawActivityColumn(activity: String, heightOfFirstRaw: Dp, checkBoxList: List<MutableState<Boolean>>, onValueChange: (Boolean) -> Unit)
    Column(modifier.width(60.dp)) { //1f
        Box(
            modifier = Modifier
                .background(LightPurple)
                .height(heightOfFirstRaw)
                .fillMaxWidth()
        ) {
            Text(
                text = activity,
                style = Typography.subtitle2,
                modifier = Modifier
                    .padding(top = 2.dp)
                    .fillMaxWidth(1f),
                textAlign = TextAlign.Center
            )
        }
        for (index in list.indices) {
            //var currentCheckBox : Boolean = checkBoxList[dayIndex].value
            Checkbox(checked = list.get(index).checked,
                onCheckedChange = { checked -> onCheckedTask(list.get(index), checked)},
                colors  = CheckboxDefaults.colors(Orange, DarkOrange),
                modifier = Modifier.fillMaxWidth(1f))
        }
    }
}


object WeekDays {
    val dayList = listOf("понедельник", "вторник", "среда", "четверг", "пятница", "суббота", "воскресенье")
}

/*
object SportActivities {
    val sportList = listOf("зарядка", "кардио", "пресс", "растяжка")
}*/