package com.example.imooc_pingtu

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class PicVM : ViewModel() {
    val picLiveData = MutableLiveData<Result<PicBean>>()
    fun picList() = viewModelScope.launch {
        val result: Result<PicBean> = try {
            Result.success(TranslateService.getApi().getPic())
        } catch (e: Exception) {
            Result.failure(e)
        }
        picLiveData.value = result
    }
}