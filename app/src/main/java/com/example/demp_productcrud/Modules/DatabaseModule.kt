package com.example.demp_productcrud.Modules

import android.content.Context
import androidx.room.Room
import com.example.demp_productcrud.Room.ProductDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context):ProductDatabase{
        return Room.databaseBuilder(context,ProductDatabase::class.java,"ProductDb").build()
    }
}