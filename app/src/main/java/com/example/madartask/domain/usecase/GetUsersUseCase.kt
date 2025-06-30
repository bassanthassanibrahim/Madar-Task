package com.example.madartask.domain.usecase

import com.example.madartask.domain.model.User
import com.example.madartask.domain.repository.UserRepository
import javax.inject.Inject

class GetUsersUseCase @Inject constructor(
    private val repository: UserRepository
) {
    suspend operator fun invoke(): List<User> {
        return repository.getUsers()
    }
}