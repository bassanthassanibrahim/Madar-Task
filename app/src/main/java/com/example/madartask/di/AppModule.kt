package com.example.madartask.di

import android.app.Application
import com.example.madartask.data.local.AppDatabase
import com.example.madartask.data.local.UserDao
import com.example.madartask.data.repository.UserRepositoryImpl
import com.example.madartask.domain.repository.UserRepository
import com.example.madartask.domain.usecase.AddUserUseCase
import com.example.madartask.domain.usecase.GetUsersUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import androidx.room.Room

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDatabase(app: Application): AppDatabase =
        Room.databaseBuilder(app, AppDatabase::class.java, "user_db").build()

    @Provides
    fun provideUserDao(db: AppDatabase): UserDao = db.userDao()

    @Provides
    @Singleton
    fun provideUserRepository(dao: UserDao): UserRepository =
        UserRepositoryImpl(dao)

    @Provides
    fun provideAddUserUseCase(repository: UserRepository): AddUserUseCase =
        AddUserUseCase(repository)

    @Provides
    fun provideGetUsersUseCase(repository: UserRepository): GetUsersUseCase =
        GetUsersUseCase(repository)
}