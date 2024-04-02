package com.example.ecotracks.data

import com.example.ecotracks.R
import com.example.ecotracks.model.BottomSheetItem
import com.example.ecotracks.model.UserActivity
import com.example.ecotracks.model.ArticleCategory
import com.example.ecotracks.model.Article

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
            ),
            Article(
                title = R.string.article_title,
                content = R.string.article_content,
                timeToRead = R.integer.time_to_read,
            ),
            Article(
                title = R.string.article_title,
                content = R.string.article_content,
                timeToRead = R.integer.time_to_read,
            ),
            Article(
                title = R.string.article_title,
                content = R.string.article_content,
                timeToRead = R.integer.time_to_read,
            ),
            Article(
                title = R.string.article_title,
                content = R.string.article_content,
                timeToRead = R.integer.time_to_read,
            ),
            Article(
                title = R.string.article_title,
                content = R.string.article_content,
                timeToRead = R.integer.time_to_read,
            ),

        )
    }
}