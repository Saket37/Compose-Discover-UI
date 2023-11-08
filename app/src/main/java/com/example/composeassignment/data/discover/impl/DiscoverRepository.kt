package com.example.composeassignment.data.discover.impl

import com.example.composeassignment.data.Result
import com.example.composeassignment.data.entity.Discover

interface DiscoverRepository {
    suspend fun getAllDiscoverItems(): Result<List<Discover>>
}