package com.example.selfprogresscompose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.selfprogresscompose.ui.theme.*


@Composable
fun SelfProgressScreen(modifier: Modifier = Modifier, selfProgressVM: SelfProgressViewModel = viewModel()) {
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
            onButtonClick = { selfProgressVM.сalculatedResult() })
    }
}

/*
list = wellnessVM.tasks,
            onCheckedTask = { task, checked -> wellnessVM.changeTaskChecked(task, checked)},
 */



