package com.example.ecotracks.ui

import androidx.compose.runtime.Composable
import androidx.compose.foundation.background
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.ecotracks.R
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.graphics.Color
import com.example.ecotracks.ui.components.HeadingTextComponent


@Composable
fun TermsAndConditionsScreen() {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        HeadingTextComponent(stringResource(id = R.string.terms_and_conditions))
    }
}