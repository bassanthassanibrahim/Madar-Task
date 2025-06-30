package com.example.madartask.data.repository

import com.example.madartask.data.local.UserDao
import com.example.madartask.data.local.UserEntity
import com.example.madartask.domain.model.User
import com.example.madartask.domain.repository.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val dao: UserDao
) : UserRepository {
    override suspend fun addUser(user: User) {
        dao.insertUser(user.toEntity())
    }

    override suspend fun getUsers(): List<User> {
        return dao.getAllUsers().map { it.toDomain() }
    }

    private fun User.toEntity() = UserEntity(
        name = name,
        age = age,
        jobTitle = jobTitle,
        gender = gender
    )

    private fun UserEntity.toDomain() = User(
        id = id,
        name = name,
        age = age,
        jobTitle = jobTitle,
        gender = gender
    )
}