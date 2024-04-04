package com.example.ecotracks.model

import androidx.annotation.StringRes
import androidx.annotation.DrawableRes
import androidx.annotation.IntegerRes

data class Article(
    @StringRes var title: Int,
    @StringRes var content: Int,
    @IntegerRes var timeToRead: Int,
    @DrawableRes var image: Int
)