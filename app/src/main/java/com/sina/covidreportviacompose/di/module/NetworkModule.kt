package com.sina.covidreportviacompose.di.module

import android.util.Log
import com.google.gson.Gson
import com.sina.covidreportviacompose.data.service.ApiService
import com.sina.covidreportviacompose.util.Constants
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient):Retrofit{
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL_WHO_COVID)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    @Singleton
    @Provides
    fun provideOkHttp():OkHttpClient = OkHttpClient.Builder()
        .addInterceptor {
            val request=it.request()
            val response = it.proceed(request)
            val gson= Gson()
            val message="""
                url-> ${request.url}
                code ${response.code}
                body ${response.body?.charStream()}
                json body->  ${gson.toJson(response.body)}
                headers ${response.headers}
                success ${response.isSuccessful}
            """.trimIndent()
            Log.d("interceptor", message)
            response
        }
        .build()

    @Provides
    fun provideApiService(retrofit:Retrofit):ApiService=retrofit.create(ApiService::class.java)
}
