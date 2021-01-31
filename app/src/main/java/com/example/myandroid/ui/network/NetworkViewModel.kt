package com.example.myandroid.ui.network

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myandroid.data.UserRepository
import com.example.myandroid.data.UserResponse
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class NetworkViewModel constructor(
    private val userRepository: UserRepository
) : ViewModel() {

    val logTag: String
        get() = this::class.java.simpleName

    private val _displayUser = MutableLiveData<UserResponse>()
    val displayUser: LiveData<UserResponse>
        get() = _displayUser

    fun executeGetUser(id: String) {
        viewModelScope.launch {
            userRepository.getUser(id)
                .onStart {
                    Log.d(logTag, "onStart show loading")
                }
                .onCompletion {
                    Log.d(logTag, "onCompletion hide loading")
                }
                .onEach {
                    Log.d(logTag, "onEach")
                }
                .catch {
                    // show error dialog
                    Log.e(logTag, it.message ?: "")
                }
                .collect {
                    // display user data to UI
                    Log.d(logTag, "response: $it")

                    _displayUser.postValue(it)
                }
        }
    }
}