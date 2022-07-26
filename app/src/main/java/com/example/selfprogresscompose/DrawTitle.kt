package com.example.selfprogresscompose

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.selfprogresscompose.ui.theme.Typography

@Composable
fun DrawTitle() {
    Spacer(modifier = Modifier.height(10.dp))
    Text(text= stringResource(id = R.string.header_text),
        style = Typography.subtitle1)
    Spacer(modifier = Modifier.height(10.dp))
}