package com.example.composeassignment.data.discover.impl

import com.example.composeassignment.data.Result
import com.example.composeassignment.data.entity.Discover
import javax.inject.Inject

class FakeDiscoverRepository @Inject constructor() : DiscoverRepository {
    override suspend fun getAllDiscoverItems(): Result<List<Discover>> {
        return Result.Success(discoverItems)
    }

}