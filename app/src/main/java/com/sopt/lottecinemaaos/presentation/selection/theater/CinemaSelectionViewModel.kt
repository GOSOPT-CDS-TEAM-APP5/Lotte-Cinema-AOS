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

    private val _selectedCinemaItemList = MutableLiveData<List<Int>>(emptyList())
    val selectedCinemaItemList: LiveData<List<Int>>
        get() = _selectedCinemaItemList

    fun addCinemaItemSelected(itemPosition: Int) {
        val currentList = _selectedCinemaItemList.value.orEmpty().toMutableList()
        if (!currentList.contains(itemPosition + 1)) {
            currentList.add(itemPosition + 1)
            _isCinemaItemSelected.value = true
            _selectedCinemaItemList.value = currentList.toList()
            Log.d("흠", currentList.toString())
        }
    }

    fun removeCinemaItemSelected(itemPosition: Int) {
        val currentList = _selectedCinemaItemList.value.orEmpty().toMutableList()
        if (currentList.contains(itemPosition + 1)) {
            currentList.remove(itemPosition + 1)
            _isCinemaItemSelected.value = true
            _selectedCinemaItemList.value = currentList.toList()
            Log.d("흠2", currentList.toString())
        }
        if (currentList.isEmpty()) {
            _isCinemaItemSelected.value = false
        }
    }

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

//    val cinemaList: List<Theater> =
//        listOf(
//            Theater(1, "1"),
//            Theater(2, "2"),
//            Theater(3, "3"),
//            Theater(4, "4"),
//            Theater(5, "5"),
//            Theater(6, "6"),
//            Theater(7, "7"),
//            Theater(8, "8"),
//            Theater(9, "9"),
//            Theater(10, "10"),
//            Theater(11, "11"),
//            Theater(12, "12"),
//            Theater(13, "13"),
//            Theater(14, "14"),
//            Theater(15, "15"),
//            Theater(16, "16"),
//            Theater(17, "17"),
//            Theater(18, "18"),
//            Theater(19, "19")
//
//        )

    val testList: List<Int> =
        listOf(1, 2)

    fun updateRegionItemSelected(isSelected: Boolean) {
        _isRegionItemSelected.value = isSelected
    }

    /*
    private fun signUp() {
        val requestSignUpDto = RequestSignUpDto(
            id = id.value.toString(),
            password = pwd.value.toString(),
            name = name.value.toString(),
            skill = skill.value.toString()
        )
        viewModelScope.launch {
            runCatching {
                authRepository.signUp(
                    requestSignUpDto
                )
            }.onSuccess {
                _isSignUpSuccess.value = true
            }.onFailure {
                _isSignUpSuccess.value = false
                _errorMessage.value = it.message
            }
        }
    }
     */
}
