package com.sopt.lottecinemaaos.presentation.selection.theater

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sopt.lottecinemaaos.data.repository.MovieSelectionRepositoryImpl
import com.sopt.lottecinemaaos.domain.model.Region
import com.sopt.lottecinemaaos.domain.model.Theater
import kotlinx.coroutines.launch

class CinemaSelectionViewModel(private val movieSelectionRepositoryImpl: MovieSelectionRepositoryImpl) :
    ViewModel() {
    init {
        getRegionData()
        getTheaterData()
    }

    private val _isRegionItemSelected = MutableLiveData<Boolean>()
    val isRegionItemSelected: LiveData<Boolean>
        get() = _isRegionItemSelected

    private val _isCinemaItemSelected = MutableLiveData(false)
    val isCinemaItemSelected: LiveData<Boolean>
        get() = _isCinemaItemSelected

    private var _selectedCinemaItemList = MutableLiveData<List<Int>>(emptyList())
    val selectedCinemaItemList: LiveData<List<Int>>
        get() = _selectedCinemaItemList

    val currentList = _selectedCinemaItemList.value.orEmpty().toMutableList()

    private var _regionData: MutableLiveData<List<Region>> = MutableLiveData()
    val regionData: LiveData<List<Region>>
        get() = _regionData

    private var _theaterData: MutableLiveData<List<Theater>> = MutableLiveData()
    val theaterData: LiveData<List<Theater>>
        get() = _theaterData

    private fun getRegionData() {
        viewModelScope.launch {
            movieSelectionRepositoryImpl.getRegionList().onSuccess { response ->
                Log.d("cinemaSelection", "getRegionData 성공")
                _regionData.value = response
            }.onFailure { error ->
                Log.d("cinemaSelection", "getRegionData 실패: ${error.message}")
            }
        }
    }

    private fun getTheaterData() {
        viewModelScope.launch {
            movieSelectionRepositoryImpl.getTheaterList(1).onSuccess { response ->
                Log.d("cinemaSelection", "getTheaterData 성공")
                _theaterData.value = response
            }.onFailure { error ->
                Log.d("cinemaSelection", "getTheaterData 실패: ${error.message}")
            }
        }
    }

    fun addCinemaItemSelected(itemPosition: Int) {
        if (!currentList.contains(itemPosition + 1)) {
            currentList.add(itemPosition + 1)
            _isCinemaItemSelected.value = true
            _selectedCinemaItemList.value = currentList.toList()
//            Log.d("흠", _selectedCinemaItemList.value.toString())
        }
    }

    fun removeCinemaItemSelected(itemPosition: Int) {
        if (currentList.contains(itemPosition + 1)) {
            currentList.remove(itemPosition + 1)
            _isCinemaItemSelected.value = true
            _selectedCinemaItemList.value = currentList.toList()
//            Log.d("흠2", _selectedCinemaItemList.value.toString())
        }
        if (currentList.isEmpty()) {
            _isCinemaItemSelected.value = false
        }
    }

    val testList: List<Int> =
        listOf(1, 2)

    fun updateRegionItemSelected(isSelected: Boolean) {
        _isRegionItemSelected.value = isSelected
    }
}
