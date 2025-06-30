package com.example.madartask.domain.repository

import com.example.madartask.domain.model.User

interface UserRepository {
    suspend fun addUser(user: User)
    suspend fun getUsers(): List<User>
}