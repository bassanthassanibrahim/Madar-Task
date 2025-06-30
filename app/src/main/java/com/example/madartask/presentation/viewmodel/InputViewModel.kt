package com.example.madartask.presentation.viewmodel

import androidx.compose.runtime.getValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.madartask.domain.model.User
import com.example.madartask.domain.usecase.AddUserUseCase
import com.example.madartask.presentation.state.InputUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

@HiltViewModel
class InputViewModel @Inject constructor(
    private val addUserUseCase: AddUserUseCase
) : ViewModel() {

    var uiState by mutableStateOf(InputUiState())

    fun onNameChange(value: String) {
        uiState = uiState.copy(name = value)
    }

    fun onAgeChange(value: String) {
        uiState = uiState.copy(age = value)
    }

    fun onJobChange(value: String) {
        uiState = uiState.copy(jobTitle = value)
    }

    fun onGenderChange(value: String) {
        uiState = uiState.copy(gender = value)
    }

    fun addUser(onSuccess: () -> Unit) {
        if (uiState.name.isBlank() || uiState.age.isBlank() || uiState.jobTitle.isBlank()) return
        viewModelScope.launch {
            addUserUseCase(
                User(
                    name = uiState.name,
                    age = uiState.age.toIntOrNull() ?: 0,
                    jobTitle = uiState.jobTitle,
                    gender = uiState.gender
                )
            )
            onSuccess()
        }
    }
}
