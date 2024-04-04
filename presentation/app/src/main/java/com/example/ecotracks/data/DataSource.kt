package com.example.ecotracks.data

import com.example.ecotracks.R
import com.example.ecotracks.model.BottomSheetItem
import com.example.ecotracks.model.UserActivity
import com.example.ecotracks.model.ArticleCategory
import com.example.ecotracks.model.Article
import com.example.ecotracks.model.EmissionActivity

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
}