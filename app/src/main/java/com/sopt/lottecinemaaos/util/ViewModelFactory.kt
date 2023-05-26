package com.sopt.lottecinemaaos.util

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sopt.lottecinemaaos.data.datasource.remote.MovieSelectionRemoteDataSource
import com.sopt.lottecinemaaos.data.repository.MovieSelectionRepositoryImpl
import com.sopt.lottecinemaaos.presentation.selection.movietime.MovieTimeSelectionViewModel
import com.sopt.lottecinemaaos.presentation.selection.theater.CinemaSelectionViewModel

class ViewModelFactory(private val context: Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CinemaSelectionViewModel::class.java)) {
            return CinemaSelectionViewModel(
                MovieSelectionRepositoryImpl(
                    MovieSelectionRemoteDataSource()
                )
            ) as T
        }
        if (modelClass.isAssignableFrom(MovieTimeSelectionViewModel::class.java)) {
            return MovieTimeSelectionViewModel(
                MovieSelectionRepositoryImpl(
                    MovieSelectionRemoteDataSource()
                )
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}
