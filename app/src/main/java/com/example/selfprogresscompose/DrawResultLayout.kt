package com.example.selfprogresscompose

//import android.graphics.Color
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.selfprogresscompose.ui.theme.DarkAquamarine
import com.example.selfprogresscompose.ui.theme.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import com.example.selfprogresscompose.ui.theme.Green


@Composable
fun DrawResultLayout(resultText: String, resultColor: Color, onButtonClick: () -> Unit, onNewWeekClick: () -> Unit) {
    Spacer(modifier = Modifier.height(10.dp))
    Button(
        onClick = { onButtonClick()},
        colors = ButtonDefaults.buttonColors(backgroundColor = DarkAquamarine),
        modifier = Modifier.fillMaxWidth()) {
        Text(stringResource(id = R.string.result_calc_button), style = Typography.button)
    }

    Spacer(modifier = Modifier.height(6.dp))
    Text(text= stringResource(id = R.string.result_text),
        style = Typography.caption)

    Spacer(modifier = Modifier.height(6.dp))
    Text(text=resultText,
        style = Typography.subtitle1,
        color = resultColor)
    Spacer(modifier = Modifier.height(10.dp))

    TextButton(onClick = { onNewWeekClick() },
        modifier = Modifier.fillMaxWidth(1f)) {
        Text(
            text = stringResource(id = R.string.new_week),
            style = Typography.caption, color = Green,
            //modifier = Modifier.fillMaxWidth(1f),
            //textAlign = TextAlign.End,
            textDecoration = TextDecoration.Underline
        )
    }
}
