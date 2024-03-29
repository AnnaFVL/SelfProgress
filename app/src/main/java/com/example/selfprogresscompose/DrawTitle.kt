package com.example.selfprogresscompose

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.selfprogresscompose.ui.theme.*

@Composable
fun DrawTitle() {
    Spacer(modifier = Modifier.height(10.dp))
    Text(text= stringResource(id = R.string.header_text),
        style = Typography.subtitle1)
    //Spacer(modifier = Modifier.height(10.dp))

    Spacer(modifier = Modifier.height(6.dp))

    Text(
        text = stringResource(id = R.string.goal_text),
        style = Typography.caption
    )

    Spacer(modifier = Modifier.height(6.dp))
    Column {
        Text(text= stringResource(id = R.string.goal_description1),
            style = Typography.body1, color = DarkPurple)
        Row {
            Text(text= stringResource(id = R.string.goal_description2),
                style = Typography.body1)
            Text(text= stringResource(id = R.string.goal_good),
                style = Typography.body1, modifier = Modifier.padding(start = 4.dp))
        }
        Row {
            Text(text= stringResource(id = R.string.goal_description3),
                style = Typography.body1)
            Text(text= stringResource(id = R.string.goal_normal),
                style = Typography.body1, modifier = Modifier.padding(start = 4.dp))
            Text(text= stringResource(id = R.string.goal_description4),
                style = Typography.body1)
            Text(text= stringResource(id = R.string.goal_bad),
                style = Typography.body1, modifier = Modifier.padding(start = 4.dp))
        }
    }
    Spacer(modifier = Modifier.height(10.dp))
}