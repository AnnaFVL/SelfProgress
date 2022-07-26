package com.example.selfprogresscompose

import androidx.lifecycle.ViewModel
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.toMutableStateList

class SelfProgressViewModel: ViewModel() {

    var resultText = mutableStateOf("Сейчас посчитаем...")
    var resultPercentage : Double = 0.0

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
    }
    fun changeCardioTaskChecked(item: SportTask, checked: Boolean) {
        cardioTasks.find { it.id ==item.id }?.let { task ->task.checked = checked }
    }
    fun changePressTaskChecked(item: SportTask, checked: Boolean) {
        pressTasks.find { it.id ==item.id }?.let { task ->task.checked = checked }
    }
    fun changeStretchingTaskChecked(item: SportTask, checked: Boolean) {
        stretchingTasks.find { it.id ==item.id }?.let { task ->task.checked = checked }
    }


    fun сalculatedResult() {

        resultPercentage = 0.0

        val random = java.util.Random().nextInt(5)

        for (i in basicTasks.indices) {
            if (basicTasks.get(i).checked) resultPercentage += basicTasks.get(i).weight
            if (cardioTasks.get(i).checked) resultPercentage += cardioTasks.get(i).weight
            if (pressTasks.get(i).checked) resultPercentage += pressTasks.get(i).weight
            if (stretchingTasks.get(i).checked) resultPercentage += stretchingTasks.get(i).weight
        }
        if (resultPercentage < 70) {
            when (random) {
                0 -> resultText.value = "Надо больше стараться!"
                1 -> resultText.value = "Кто будет лениться, тот конфетки не ест ;)"
                2 -> resultText.value = "Трудись! На следующей неделе будет труднее..."
                3 -> resultText.value = "Помним про цель и двигаемся к ней!"
                4 -> resultText.value = "Маловато будет ;)"
            }
        } else if (resultPercentage < 100) {
            when (random) {
                0 -> resultText.value = "Неплохо! Может не все удалось, но ты старалась"
                1 -> resultText.value = "Еще немного поднажмем!.."
                2 -> resultText.value = "Результат есть, и это прекрасно! ;)"
                3 -> resultText.value = "Перфекционизм, конечно, зло... Порадуемся тому, что есть ;)"
                4 -> resultText.value = "Пироженки и конфетки еще нужно заработать ;)"
            }
        } else {
            when (random) {
                0 -> resultText.value = "Статус: герой ;)"
                1 -> resultText.value = "Отлично! Все получилось!"
                2 -> resultText.value = "Горжусь тобой! и собой ;)"
                3 -> resultText.value = "Ого-го! Супер!!!"
                4 -> resultText.value = "Цель достингута! Бурные аплодисменты ;)"
            }
        }

        resultText.value += "\n" + resultPercentage.toString()

        resultText.value += "\n ${basicTasks.get(0).checked} / ${basicTasks.get(1).checked} / ${basicTasks.get(2).checked} / ${basicTasks.get(3).checked} /" +
                "${basicTasks.get(4).checked} / ${basicTasks.get(5).checked} / ${basicTasks.get(6).checked}"
        resultText.value += "\n ${cardioTasks.get(0).checked} / ${cardioTasks.get(1).checked} / ${cardioTasks.get(2).checked} / ${cardioTasks.get(3).checked} /" +
                "${cardioTasks.get(4).checked} / ${cardioTasks.get(5).checked} / ${cardioTasks.get(6).checked}"
        resultText.value += "\n ${pressTasks.get(0).checked} / ${pressTasks.get(1).checked} / ${pressTasks.get(2).checked} / ${pressTasks.get(3).checked} /" +
                "${pressTasks.get(4).checked} / ${pressTasks.get(5).checked} / ${pressTasks.get(6).checked}"
        resultText.value += "\n ${stretchingTasks.get(0).checked} / ${stretchingTasks.get(1).checked} / ${stretchingTasks.get(2).checked} / ${stretchingTasks.get(3).checked} /" +
                "${stretchingTasks.get(4).checked} / ${stretchingTasks.get(5).checked} / ${stretchingTasks.get(6).checked}"
    }


/*
    fun readSharePreferences(context: Context) {
        val sharedPreferences = context.getSharedPreferences(sharedPreferencesFileName, Context.MODE_PRIVATE)
        for (index in uiState.basicList.indices) {
            uiState.basicList[index] = sharedPreferences.getBoolean("basic$index", false)
        }
        for (index in uiState.cardioList.indices) {
            uiState.cardioList[index] = sharedPreferences.getBoolean("cardio$index", false)
        }
        for (index in uiState.pressList.indices) {
            uiState.pressList[index] = sharedPreferences.getBoolean("press$index", false)
        }
        for (index in uiState.stretchingList.indices) {
            uiState.stretchingList[index] = sharedPreferences.getBoolean("stretching$index", false)
        }

    }

    fun writeSharePreferences(context: Context) {
        val sharedPreferences = context.getSharedPreferences(sharedPreferencesFileName, Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()

        for (index in uiState.basicList.indices) {
            editor.putBoolean("basic$index", uiState.basicList[index])
        }
        for (index in uiState.cardioList.indices) {
            editor.putBoolean("cardio$index", uiState.cardioList[index])
        }
        for (index in uiState.pressList.indices) {
            editor.putBoolean("press$index", uiState.pressList[index])
        }
        for (index in uiState.stretchingList.indices) {
            editor.putBoolean("stretching$index", uiState.stretchingList[index])
        }
        editor.apply()
    }*/
}

/*
object SportList {
    val sportList = listOf("basic", "cardio", "press", "stretching")
}*/

class SportTask(val id: Int, val label: String, initialChecked: Boolean = false) {
    var checked by mutableStateOf(initialChecked)
    val weight: Double = when (label) {
        "basic" -> 6.25
        "cardio" -> 6.25
        "press" -> 8.4
        "stretching" -> 8.4
        else -> 1.0
    }
}

private fun getBasicList() = List(7) { i -> SportTask(i, "basic") }
private fun getCardioList() = List(7) { i -> SportTask(i, "cardio") }
private fun getPressList() = List(7) { i -> SportTask(i, "press") }
private fun getStretchingList() = List(7) { i -> SportTask(i, "stretching") }