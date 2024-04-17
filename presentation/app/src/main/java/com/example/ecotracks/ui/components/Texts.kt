package com.example.ecotracks.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.res.dimensionResource
import com.example.ecotracks.R
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.text.ClickableText
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.style.TextOverflow

@Composable
fun NormalTextComponent(value: String) {
    Text(
        text = value,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 40.dp),
        style = MaterialTheme.typography.bodyLarge,
        textAlign = TextAlign.Center
    )
}

@Composable
fun HeadingTextComponent(value: String) {
    Text(
        text = value,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(),
        style = MaterialTheme.typography.titleLarge,
        textAlign = TextAlign.Center
    )
}

@Composable
fun ArticleTitleComponent(value: String) {
    Text(
        text = value,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(),
        style = MaterialTheme.typography.titleLarge,
        //textAlign = TextAlign.Start
    )
}

@Composable
fun ArticleCardContentComponent(value: String) {
    Text(
        text = value,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(),
        style = MaterialTheme.typography.bodyMedium,
        maxLines = 3,
        overflow = TextOverflow.Ellipsis
        //textAlign = TextAlign.Start
    )
}

@Composable
fun ArticleContentComponent(value: String) {
    Text(
        text = value,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(),
        style = MaterialTheme.typography.bodyMedium,
        //color = MaterialTheme.colorScheme.onSurface
        color = Color.Gray
        //textAlign = TextAlign.Start
    )
}

@Composable
fun SmallTextComponent(value: String) {
    Text(
        text = value,
        modifier = Modifier
            .fillMaxWidth(),
        style = MaterialTheme.typography.labelSmall,
        textAlign = TextAlign.Start,
    )
}

@Composable
fun ClickText(value: String) {
    ClickableText(
        text = AnnotatedString(value),
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 40.dp)
            .padding(top = dimensionResource(id = R.dimen.padding_small)),
        style = MaterialTheme.typography.labelSmall,
        //onClick = { /* TODO */}
    ) {
    }
}

@Composable
fun ErrorTextComponent(value: String) {
    Text(
        text = value,
        modifier = Modifier.fillMaxWidth(),
        color = MaterialTheme.colorScheme.error
    )
}

