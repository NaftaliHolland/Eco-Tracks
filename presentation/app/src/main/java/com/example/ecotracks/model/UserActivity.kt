package com.example.ecotracks.model

import androidx.annotation.StringRes
import androidx.annotation.DrawableRes
import androidx.annotation.IntegerRes

data class UserActivity(
    @StringRes var name: Int,
    @StringRes var description: Int,
    @IntegerRes var points: Int,
    @DrawableRes var imageResourceId: Int,
    @StringRes var carbonSavingFactor: Int
)
