package com.sina.covidreportviacompose.di.module
import com.sina.covidreportviacompose.data.service.repository.CovidRepositoryImpl
import com.sina.covidreportviacompose.domain.CovidRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
abstract class RepoModule {

    @Binds
    abstract fun bindCovidRepository(covidRepositoryImpl: CovidRepositoryImpl): CovidRepository

}
