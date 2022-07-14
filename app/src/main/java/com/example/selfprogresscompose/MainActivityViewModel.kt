package com.example.selfprogresscompose

import android.content.Context
import android.content.res.Resources
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.ViewModel
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

//////
// Выполненные спотривные активности по дням недели
//////
data class UiState(
    val basicList : MutableList<Boolean> = mutableListOf (false, false, false, false, false, false, false),
    val cardioList : MutableList<Boolean> = mutableListOf (false, false, false, false, false, false, false),
    val pressList : MutableList<Boolean> = mutableListOf (false, false, false, false, false, false, false),
    val stretchingList : MutableList<Boolean> = mutableListOf (false, false, false, false, false, false, false)
)

//////
// Хранит текущее состояние, считает результат, сохраняет и считывает состояние в sharedPreferences
//////
class MainActivityViewModel: ViewModel() {

    //var uiState by mutableStateOf(UiState())
    var resultText = mutableStateOf("Сейчас посчитаем...") //Resources.getSystem().getString(R.string.result_text_unknown)

    private val sharedPreferencesFileName = "selfProgressAppSharedPreferences"


    fun сalculatedResult() {
        val random = java.util.Random().nextInt(5)
        when (random) {
            0 -> resultText.value = "Надо больше стараться!"
            1 -> resultText.value = "Неплохо! Может не все удалось, но ты старалась"
            2 -> resultText.value = "Статус: герой ;)"
            3 -> resultText.value = "Кто будет лениться, тот конфетки не ест ;)"
            4 -> resultText.value = "Отлично! Все получилось!"
        }
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