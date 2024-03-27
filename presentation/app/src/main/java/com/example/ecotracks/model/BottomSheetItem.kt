package com.example.ecotracks.model

import androidx.annotation.StringRes
import androidx.annotation.DrawableRes
import androidx.annotation.IntegerRes

data class BottomSheetItem(
    @StringRes val title: Int,
    @DrawableRes val icon: Int
)
