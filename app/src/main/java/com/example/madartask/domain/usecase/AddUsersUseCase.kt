package com.example.madartask.domain.usecase

import com.example.madartask.domain.model.User
import com.example.madartask.domain.repository.UserRepository
import javax.inject.Inject

class AddUserUseCase @Inject constructor(
    private val repository: UserRepository
) {
    suspend operator fun invoke(user: User) {
        repository.addUser(user)
    }
}