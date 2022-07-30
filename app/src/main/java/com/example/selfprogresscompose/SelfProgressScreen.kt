package com.example.selfprogresscompose

import android.content.Context
import android.content.SharedPreferences
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel


@Composable
fun SelfProgressScreen(sharedPreferences: SharedPreferences, modifier: Modifier = Modifier) {

    val selfProgressVM: SelfProgressViewModel = viewModel()
    selfProgressVM.sharedPreferences = sharedPreferences
    selfProgressVM.readSharePreferences()

    Column(modifier = modifier.padding(start = 20.dp, end = 20.dp)) {
        DrawTitle()
        DrawTable(
            basicList = selfProgressVM.basicTasks,
            onCheckedBasicTask = {task, checked -> selfProgressVM.changeBasicTaskChecked(task, checked)},
            cardioList = selfProgressVM.cardioTasks,
            onCheckedCardioTask = {task, checked -> selfProgressVM.changeCardioTaskChecked(task, checked)},
            pressList = selfProgressVM.pressTasks,
            onCheckedPressTask = {task, checked -> selfProgressVM.changePressTaskChecked(task, checked)},
            stretchingList = selfProgressVM.stretchingTasks,
            onCheckedStretchingTask = {task, checked -> selfProgressVM.changeStretchingTaskChecked(task, checked)},
        )
        DrawResultLayout(
            resultText = selfProgressVM.resultText.value,
            resultColor = selfProgressVM.resultColor.value,
            onButtonClick = { selfProgressVM.сalculatedResult() },
            onNewWeekClick = { selfProgressVM.clearCheckBoxes()})
    }
}




