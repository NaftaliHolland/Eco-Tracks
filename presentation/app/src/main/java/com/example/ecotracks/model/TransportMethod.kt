package com.example.ecotracks.model

import androidx.annotation.StringRes
import androidx.annotation.DrawableRes

data class TransportMethod(
    @DrawableRes var image: Int,
    @StringRes var name: Int
)