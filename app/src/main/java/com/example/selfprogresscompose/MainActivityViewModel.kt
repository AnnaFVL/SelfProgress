package com.example.selfprogresscompose

import androidx.lifecycle.ViewModel

class MainActivityViewModel: ViewModel() {
    private val resultText = "Text text from View Model"

    fun getCalculatedResult(): String {
        return resultText
    }
}