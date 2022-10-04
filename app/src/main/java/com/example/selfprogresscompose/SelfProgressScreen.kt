package com.example.selfprogresscompose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.selfprogresscompose.Data.SelfProgressDB
import com.example.selfprogresscompose.Model.SelfProgressViewModel
import com.example.selfprogresscompose.Model.SportTask


@Composable
fun SelfProgressScreen(dataBase: SelfProgressDB, modifier: Modifier = Modifier) {

    val selfProgressVM: SelfProgressViewModel = viewModel()
    selfProgressVM.selfProgressDB = dataBase
    selfProgressVM.getAllTasksFromDBIfExists()

    Column(modifier = modifier.padding(start = 20.dp, end = 20.dp)) {
        DrawTitle()
        DrawTable(
            basicList = selfProgressVM.basicTasks,
            onCheckedBasicTask = {task : SportTask, checked -> selfProgressVM.changeBasicTaskChecked(task, checked)},
            cardioList = selfProgressVM.cardioTasks,
            onCheckedCardioTask = {task : SportTask, checked -> selfProgressVM.changeCardioTaskChecked(task, checked)},
            pressList = selfProgressVM.pressTasks,
            onCheckedPressTask = {task : SportTask, checked -> selfProgressVM.changePressTaskChecked(task, checked)},
            stretchingList = selfProgressVM.stretchingTasks,
            onCheckedStretchingTask = {task : SportTask, checked -> selfProgressVM.changeStretchingTaskChecked(task, checked)},
        )
        DrawResultLayout(
            resultText = selfProgressVM.resultText.value,
            resultColor = selfProgressVM.resultColor.value,
            onButtonClick = { selfProgressVM.calculateResult() },
            onNewWeekClick = { selfProgressVM.clearCheckBoxes()})
    }
}




