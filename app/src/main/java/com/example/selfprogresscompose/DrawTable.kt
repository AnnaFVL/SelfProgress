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
import com.example.selfprogresscompose.ui.theme.*


@Composable
fun DrawTable(basicList: List<SportTask>,
              onCheckedBasicTask: (SportTask, Boolean) -> Unit,
              cardioList: List<SportTask>,
              onCheckedCardioTask: (SportTask, Boolean) -> Unit,
              pressList: List<SportTask>,
              onCheckedPressTask: (SportTask, Boolean) -> Unit,
              stretchingList: List<SportTask>,
              onCheckedStretchingTask: (SportTask, Boolean) -> Unit,
              modifier: Modifier = Modifier)
{
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

    }
}

@Composable
fun DrawWeekDayColumn(widthOfFirstColumn: Dp, heightOfFirstRaw: Dp, modifier: Modifier = Modifier) {
    Column(modifier.background(Aquamarine)
        .width(widthOfFirstColumn)) {
        Box(modifier = Modifier
            .background(PaleAquamarine)
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
    Column(modifier.width(60.dp)) { //1f
        Box(
            modifier = Modifier
                .background(Aquamarine)
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
            Checkbox(checked = list.get(index).checked,
                onCheckedChange = { checked -> onCheckedTask(list.get(index), checked)},
                colors  = CheckboxDefaults.colors(MintGreen, DarkPurple),
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