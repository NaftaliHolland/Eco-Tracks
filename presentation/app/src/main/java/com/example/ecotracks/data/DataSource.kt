package com.example.ecotracks.data

import com.example.ecotracks.R
import com.example.ecotracks.model.BottomSheetItem
import com.example.ecotracks.model.UserActivity
import com.example.ecotracks.model.ArticleCategory
import com.example.ecotracks.model.Article
import com.example.ecotracks.model.EmissionActivity
import com.example.ecotracks.model.TransportMethod

class DataSource() {
    fun loadUserActivities() : List<UserActivity> {
        return listOf<UserActivity>(
            UserActivity(
                R.string.activity_name,
                R.string.activity_description,
                R.integer.activity_points,
                R.drawable.directions_walk_24px,
                R.string.activity_carbon_saving_factor
            ),
            UserActivity(
                R.string.activity_name,
                R.string.activity_description,
                R.integer.activity_points,
                R.drawable.directions_walk_24px,
                R.string.activity_carbon_saving_factor
            ),
            UserActivity(
                R.string.activity_name,
                R.string.activity_description,
                R.integer.activity_points,
                R.drawable.directions_walk_24px,
                R.string.activity_carbon_saving_factor
            ),
            UserActivity(
                R.string.activity_name,
                R.string.activity_description,
                R.integer.activity_points,
                R.drawable.directions_walk_24px,
                R.string.activity_carbon_saving_factor
            )
        )
    }

    fun loadBottomSheetItems() : List<BottomSheetItem> {
        return listOf<BottomSheetItem>(
            BottomSheetItem(
                R.string.meal,
                R.drawable.food
            ),
            BottomSheetItem(
                R.string.transport,
                R.drawable.transport
            ),
            BottomSheetItem(
                R.string.home,
                R.drawable.home_24px
            ),
            BottomSheetItem(
                R.string.activity,
                R.drawable.activity
            ),
        )
    }

    fun loadLearnCategories() : List<ArticleCategory> {
        return listOf<ArticleCategory> (
            ArticleCategory(
                R.string.transport
            ),
            ArticleCategory(
                R.string.home
            ),
            ArticleCategory(
                R.string.activity
            )
        )
    }

    fun loadArticles() : List<Article> {
        return listOf<Article> (
            Article(
                title = R.string.article_title,
                content = R.string.article_content,
                timeToRead = R.integer.time_to_read,
                image = R.drawable.karsten_wurth_0w_uta0xz7w_unsplash
            ),
            Article(
                title = R.string.article_title_2,
                content = R.string.article_content_2,
                timeToRead = R.integer.time_to_read,
                image = R.drawable.vitor_monthay_ekedharupts_unsplash
            ),
            Article(
                title = R.string.article_title,
                content = R.string.article_content,
                timeToRead = R.integer.time_to_read,
                image = R.drawable.karsten_wurth_0w_uta0xz7w_unsplash
            ),
            Article(
                title = R.string.article_title,
                content = R.string.article_content,
                timeToRead = R.integer.time_to_read,
                image = R.drawable.karsten_wurth_0w_uta0xz7w_unsplash
            ),
            Article(
                title = R.string.article_title,
                content = R.string.article_content,
                timeToRead = R.integer.time_to_read,
                image = R.drawable.karsten_wurth_0w_uta0xz7w_unsplash
            ),
            Article(
                title = R.string.article_title,
                content = R.string.article_content,
                timeToRead = R.integer.time_to_read,
                image = R.drawable.karsten_wurth_0w_uta0xz7w_unsplash
            ),

        )
    }

    fun loadActivities() : List<EmissionActivity> {
        return listOf<EmissionActivity>(
            EmissionActivity(
                image = R.drawable.transport,
                name = R.string.transport
            ),
            EmissionActivity(
                image = R.drawable.food,
                name = R.string.food
            ),
        )
    }

    fun loadHomeActivities() : List<EmissionActivity> {
        return listOf<EmissionActivity>(
            EmissionActivity(
                image = R.drawable.transport,
                name = R.string.transport,
                amountEmitted = 34.2
            ),
            EmissionActivity(
                image = R.drawable.food,
                name = R.string.food,
                amountEmitted = 22.6
            ),
            EmissionActivity(
                image = R.drawable.food,
                name = R.string.food,
                amountEmitted = 22.6
            ),
            EmissionActivity(
                image = R.drawable.food,
                name = R.string.food,
                amountEmitted = 22.6
            )
        )
    }

    fun loadTransportMethods() : List<TransportMethod> {
        return listOf<TransportMethod> (
            TransportMethod(
                image = R.drawable.cycling,
                name = R.string.cycling
            ),
            TransportMethod(
                image = R.drawable.train,
                name = R.string.train
            ),
            TransportMethod(
                image = R.drawable.transport,
                name = R.string.transport
            ),
            TransportMethod(
                image = R.drawable.transport,
                name = R.string.transport
            ),
            TransportMethod(
                image = R.drawable.transport,
                name = R.string.transport
            )

        )
    }
}