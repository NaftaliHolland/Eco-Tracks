package com.example.ecotracks.data

import com.example.ecotracks.R
import com.example.ecotracks.model.UserActivity

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
}