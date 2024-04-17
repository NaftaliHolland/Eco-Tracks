package com.example.ecotracks.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ecotracks.R

@Composable
fun TransportDuration(
) {

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        ArticleCardContentComponent(stringResource(id = R.string.date_and_time))
       Row(
           modifier = Modifier
               .fillMaxWidth()
               .height(50.dp)
               .clickable(
                   onClick = { /** TODO **/ }
               ),
           horizontalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_medium)),
           verticalAlignment = Alignment.CenterVertically
        ) {
           Icon(
                painter = painterResource(id = R.drawable.calendar),
                contentDescription = "",
               )
           ArticleCardContentComponent(stringResource(id = R.string.date_travelled))

        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .clickable(
                    onClick = { /** TODO **/ }
                ),
            horizontalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_medium)),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.time),
                contentDescription = "",
            )
            ArticleCardContentComponent(stringResource(id = R.string.time_travelled))
        }
    }
}

@Preview
@Composable
fun TransportDurationPreview() {
    TransportDuration()
}