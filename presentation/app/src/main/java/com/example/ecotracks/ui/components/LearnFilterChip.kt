package com.example.ecotracks.ui.components

import androidx.compose.foundation.layout.size
import androidx.compose.ui.res.stringResource
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun LearnFilterChip(
    category: Int,
) {
    var selected by remember { mutableStateOf(false) }

    FilterChip(
        onClick = {
            selected = !selected
            /* TODO ADD SEARCH */
                  },
        label = {
            Text(stringResource(id = category))
        },
        selected = selected,
        leadingIcon = if (selected) {
            {
                Icon(
                    imageVector = Icons.Filled.Done,
                    contentDescription = "Done icon",
                    modifier = Modifier.size(FilterChipDefaults.IconSize)
                )
            }
        } else {
            null
        },
    )
}

@Preview(showBackground = true)
@Composable
fun LearnFilterChipPreview() {
}
