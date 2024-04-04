package com.example.ecotracks.model

import androidx.annotation.StringRes
import androidx.annotation.DrawableRes

data class EmissionActivity(
    @StringRes var name: Int,
    @DrawableRes var image: Int,
)