package com.example.selfprogresscompose

import android.content.Context
import android.content.res.Resources
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.ViewModel
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

data class UiState(
    val tmpList : MutableList<Boolean>  = mutableListOf (false, false, false, false, false, false, false)
)

class MainActivityViewModel: ViewModel() {
    private val sharedPreferencesFileName = "selfProgressAppSharedPreferences"

    private val resultText = "Test" //Resources.getSystem().getString(R.string.result_text_unknown)

    private val basicList = mutableListOf (false, false, false, false, false, false, false)
    private val cardioList = mutableListOf (false, false, false, false, false, false, false)
    private val pressList = mutableListOf (false, false, false, false, false, false, false)
    private val stretchingList = mutableListOf (false, false, false, false, false, false, false)



    var uiState by mutableStateOf(UiState())
        private set


    fun getCalculatedResult(): String {
        return resultText
    }

    fun getBasicList(): MutableList<Boolean> {
        return basicList
    }

    fun getCardioList(): MutableList<Boolean> {
        return cardioList
    }

    fun getPressList(): MutableList<Boolean> {
        return pressList
    }

    fun getStretchingList(): MutableList<Boolean> {
        return stretchingList
    }

    fun getListsValues(context: Context) {
        val sharedPreferences = context.getSharedPreferences(sharedPreferencesFileName, Context.MODE_PRIVATE)
        /*for (index in basicList.indices) {
            if (boolList[index].value)
            basicList[index] = sharedPreferences.getBoolean("basic$index", false)
        }
        for (index in cardioList.indices) {
            cardioList[index] = sharedPreferences.getBoolean("cardio$index", false)
        }
        for (index in pressList.indices) {
            pressList[index] = sharedPreferences.getBoolean("press$index", false)
        }
        for (index in stretchingList.indices) {
            stretchingList[index] = sharedPreferences.getBoolean("stretching$index", false)
        }*/

    }

    fun saveListsValues(context: Context) {
        val sharedPreferences = context.getSharedPreferences(sharedPreferencesFileName, Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()

        /*for (index in basicList.indices) {
            editor.putBoolean("basic$index", basicList[index])
        }
        for (index in cardioList.indices) {
            editor.putBoolean("cardio$index", cardioList[index])
        }
        for (index in pressList.indices) {
            editor.putBoolean("press$index", pressList[index])
        }
        for (index in stretchingList.indices) {
            editor.putBoolean("stretching$index", stretchingList[index])
        }*/
        editor.apply()
    }
}