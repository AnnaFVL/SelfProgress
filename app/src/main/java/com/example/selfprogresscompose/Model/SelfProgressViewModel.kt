package com.example.selfprogresscompose.Model

import androidx.lifecycle.ViewModel
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.toMutableStateList
import com.example.selfprogresscompose.Data.SelfProgressDB
import com.example.selfprogresscompose.ui.theme.*


class SelfProgressViewModel: ViewModel() {

    lateinit var selfProgressDB: SelfProgressDB

    var resultText = mutableStateOf("Сейчас посчитаем...")
    private var resultPercentage : Int = 0
    var resultColor = mutableStateOf(DarkAquamarine)

    private val _basicTasks = getBasicList().toMutableStateList()
    private val _cardioTasks = getCardioList().toMutableStateList()
    private val _pressTasks = getPressList().toMutableStateList()
    private val _stretchingTasks = getStretchingList().toMutableStateList()

    val basicTasks: List<SportTask>
        get() = _basicTasks
    val cardioTasks: List<SportTask>
        get() = _cardioTasks
    val pressTasks: List<SportTask>
        get() = _pressTasks
    val stretchingTasks: List<SportTask>
        get() = _stretchingTasks

    fun changeBasicTaskChecked(item: SportTask, checked: Boolean) {
        basicTasks.find { it.id ==item.id }?.let { task ->task.checked = checked }
        updateTaskInDB(item, checked)
    }
    fun changeCardioTaskChecked(item: SportTask, checked: Boolean) {
        cardioTasks.find { it.id ==item.id }?.let { task ->task.checked = checked }
        updateTaskInDB(item, checked)
    }
    fun changePressTaskChecked(item: SportTask, checked: Boolean) {
        pressTasks.find { it.id ==item.id }?.let { task ->task.checked = checked }
        updateTaskInDB(item, checked)
    }
    fun changeStretchingTaskChecked(item: SportTask, checked: Boolean) {
        stretchingTasks.find { it.id ==item.id }?.let { task ->task.checked = checked }
        updateTaskInDB(item, checked)
    }

    fun clearCheckBoxes() {
        for (index in _basicTasks.indices) {
            _basicTasks[index].checked = false
            _cardioTasks[index].checked = false
            _pressTasks[index].checked = false
            _stretchingTasks[index].checked = false
        }
        updateToUncheckedAllTasksInDB()
    }

    fun calculateResult() {

        calculateResultPercentage()
        resultColor.value = DarkAquamarine
        val random = java.util.Random().nextInt(5)

        if (resultPercentage < 70) {
            when (random) {
                0 -> resultText.value = "Надо больше стараться!"
                1 -> resultText.value = "Кто будет лениться, тот конфетки не ест ;)"
                2 -> resultText.value = "Трудись! На следующей неделе будет труднее..."
                3 -> resultText.value = "Помним про цель и двигаемся к ней!"
                4 -> resultText.value = "Маловато будет ;)"
            }
            resultColor.value = Red
        } else if (resultPercentage < 100) {
            when (random) {
                0 -> resultText.value = "Неплохо! Может не все удалось, но ты старалась"
                1 -> resultText.value = "Еще немного поднажмем!.."
                2 -> resultText.value = "Результат есть, и это прекрасно! ;)"
                3 -> resultText.value = "Перфекционизм, конечно, зло... Порадуемся тому, что есть ;)"
                4 -> resultText.value = "Пироженки и конфетки еще нужно заработать ;)"
            }
            resultColor.value = Orange
        } else {
            when (random) {
                0 -> resultText.value = "Статус: герой ;)"
                1 -> resultText.value = "Отлично! Все получилось!"
                2 -> resultText.value = "Горжусь тобой! и собой ;)"
                3 -> resultText.value = "Ого-го! Супер!!!"
                4 -> resultText.value = "Цель достингута! Бурные аплодисменты ;)"
            }
            resultColor.value = Green
        }

        resultText.value += "\n$resultPercentage% от цели"

        //writeSharePreferences()
        // write all to db

    }

    private fun calculateResultPercentage() {
        var resultPercentageDouble = 0.0
        var tasksAmount = 0
        val significantAmountOfBasicCardio = 4
        val significantAmountOfPressStretching = 3

        for (i in basicTasks.indices) {
            if (basicTasks[i].checked && tasksAmount < significantAmountOfBasicCardio) {
                resultPercentageDouble += basicTasks[i].weight
                tasksAmount++
            }
        }
        tasksAmount = 0
        for (i in cardioTasks.indices) {
            if (cardioTasks[i].checked && tasksAmount < significantAmountOfBasicCardio) {
                resultPercentageDouble += cardioTasks[i].weight
                tasksAmount++
            }
        }
        tasksAmount = 0
        for (i in pressTasks.indices) {
            if (pressTasks[i].checked && tasksAmount < significantAmountOfPressStretching) {
                resultPercentageDouble += pressTasks[i].weight
                tasksAmount++
            }
        }
        tasksAmount = 0
        for (i in stretchingTasks.indices) {
            if (stretchingTasks[i].checked && tasksAmount < significantAmountOfPressStretching) {
                resultPercentageDouble += stretchingTasks[i].weight
                tasksAmount++
            }
        }
        resultPercentage = resultPercentageDouble.toInt()
    //resultPercentage = Math.round(resultPercentage*100.0)/100.0
    //resultPercentage = String.format("%.2f", resultPercentage).toDouble()
    }


    fun getAllTasksFromDBIfExists() {
        val taskListFomDB : List<SportTask>? = selfProgressDB.sportDAO?.getAllSportTasks()
        if (taskListFomDB != null) {
            for (item in taskListFomDB) {
                if (item.sportActivity == "basic") { basicTasks.find { it.dayOfWeek ==item.dayOfWeek }?.let { task ->task.checked = item.checked } }
                if (item.sportActivity == "cardio") { cardioTasks.find { it.dayOfWeek ==item.dayOfWeek }?.let { task ->task.checked = item.checked } }
                if (item.sportActivity == "press") { pressTasks.find { it.dayOfWeek ==item.dayOfWeek }?.let { task ->task.checked = item.checked } }
                if (item.sportActivity == "stretching") { stretchingTasks.find { it.dayOfWeek ==item.dayOfWeek }?.let { task ->task.checked = item.checked } }
            }
        } else {
            addAllTasksToDB()
        }
    }

    /*
    private fun deleteAllTasksFromDB() {
        for (item in basicTasks) { selfProgressDB.sportDAO?.deleteSportTask(item) }
        for (item in cardioTasks) { selfProgressDB.sportDAO?.deleteSportTask(item) }
        for (item in pressTasks) { selfProgressDB.sportDAO?.deleteSportTask(item) }
        for (item in stretchingTasks) { selfProgressDB.sportDAO?.deleteSportTask(item) }
    }*/

    private fun updateToUncheckedAllTasksInDB() {
        for (item in basicTasks) { selfProgressDB.sportDAO?.updateSportTask(item) }
        for (item in cardioTasks) { selfProgressDB.sportDAO?.updateSportTask(item) }
        for (item in pressTasks) { selfProgressDB.sportDAO?.updateSportTask(item) }
        for (item in stretchingTasks) { selfProgressDB.sportDAO?.updateSportTask(item) }
    }

    private fun addAllTasksToDB() {
        for (item in basicTasks) { selfProgressDB.sportDAO?.addSportTask(item) }
        for (item in cardioTasks) { selfProgressDB.sportDAO?.addSportTask(item) }
        for (item in pressTasks) { selfProgressDB.sportDAO?.addSportTask(item) }
        for (item in stretchingTasks) { selfProgressDB.sportDAO?.addSportTask(item) }
    }

    private fun updateTaskInDB(item: SportTask, checked: Boolean) {
        item.checked = checked
        selfProgressDB.sportDAO?.updateSportTask(item)
    }
}


private fun getBasicList() = List(7) { i -> SportTask(sportActivity = "basic", dayOfWeek = i, checked = false, weight = 6.25) }
private fun getCardioList() = List(7) { i -> SportTask(sportActivity = "cardio", dayOfWeek = i, checked = false, weight = 6.25) }
private fun getPressList() = List(7) { i -> SportTask(sportActivity = "press", dayOfWeek = i, checked = false, weight = 8.4) }
private fun getStretchingList() = List(7) { i -> SportTask(sportActivity = "stretching", dayOfWeek = i, checked = false, weight = 8.4) }