package com.example.selfprogresscompose

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.selfprogresscompose.ui.theme.DarkPurple
import com.example.selfprogresscompose.ui.theme.Typography


@Composable
fun DrawResultLayout(resultText: String, onButtonClick: () -> Unit) {
    Spacer(modifier = Modifier.height(10.dp))
    Button(
        onClick = { onButtonClick()}, //{ /*caclResult(model, context)*/ },
        colors = ButtonDefaults.buttonColors(backgroundColor = DarkPurple),
        modifier = Modifier.fillMaxWidth()) {
        Text(stringResource(id = R.string.result_calc_button), style = Typography.button)
    }

    Spacer(modifier = Modifier.height(6.dp))
    Text(text= stringResource(id = R.string.result_text),
        style = Typography.caption)

    Spacer(modifier = Modifier.height(6.dp))
    Text(text=resultText, //model.resultText, // model.getCalculatedResult()
        style = Typography.subtitle1)
    Spacer(modifier = Modifier.height(10.dp))
}
