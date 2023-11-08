package com.example.composeassignment.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composeassignment.data.Result
import com.example.composeassignment.data.discover.impl.DiscoverRepository
import com.example.composeassignment.data.entity.Discover
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

data class DiscoverUiState(
    val discoverItem: List<Discover> = emptyList()
)

@HiltViewModel
class DiscoverViewModel @Inject constructor(
    private val discoverRepository: DiscoverRepository
) : ViewModel() {
    private val _uiState = MutableStateFlow(DiscoverUiState())
    val uiState get() = _uiState

    init {
        observeData()
    }

    private fun observeData() {
        viewModelScope.launch {
            val result = discoverRepository.getAllDiscoverItems()
            _uiState.update {
                when (result) {
                    is Result.Success -> {
                        it.copy(discoverItem = result.data)
                    }

                    is Result.Error -> {
                        return@launch
                    }
                }
            }

        }
    }
}