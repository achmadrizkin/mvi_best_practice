package com.example.mvvm_hilt.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvm_hilt.model.Blog
import com.example.mvvm_hilt.repo.MainRepo
import com.example.mvvm_hilt.utils.DataState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val mainRepo: MainRepo,
) : ViewModel() {

    private val _dataState: MutableLiveData<DataState<List<Blog>>> = MutableLiveData()
    val dataState: LiveData<DataState<List<Blog>>> get() = _dataState

    //
    fun setStateEvent(mainStateEvent: MainStateEvent) {
        viewModelScope.launch {
            when (mainStateEvent) {
                is MainStateEvent.GetBlogEvents -> {
                    mainRepo.getBlog().onEach { dataState ->
                        _dataState.value = dataState
                    }.launchIn(viewModelScope)
                }

                is MainStateEvent.None -> {

                }
            }
        }
    }

    fun setStateEventFromDao(mainStateEvent: MainStateEvent) {
        viewModelScope.launch {
            when(mainStateEvent) {
                is MainStateEvent.GetBlogEvents -> {
                    mainRepo.getBlogFromDao().onEach {
                        dataState -> _dataState.value = dataState
                    }.launchIn(viewModelScope)
                }

                is MainStateEvent.None -> {

                }
            }
        }
    }
}

sealed class MainStateEvent {
    object GetBlogEvents : MainStateEvent()

    object None : MainStateEvent()
}