package com.sopt.lottecinemaaos.presentation.selection

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sopt.lottecinemaaos.data.entity.Cinema
import com.sopt.lottecinemaaos.data.entity.Region

class CinemaSelectionViewModel : ViewModel() {
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

    val regionList: List<Region> =
        listOf(
            Region(1, "MY 영화관", 0),
            Region(2, "가까운 영화관", 1),
            Region(3, "서울", 2),
            Region(4, "경기", 3),
            Region(5, "인천", 4),
            Region(6, "충청", 5),
            Region(7, "전라", 6),
            Region(8, "경북", 7),
            Region(9, "대구", 8),
            Region(10, "경남", 9)

        )

    val cinemaList: List<Cinema> =
        listOf(
            Cinema(1, "1"),
            Cinema(2, "2"),
            Cinema(3, "3"),
            Cinema(4, "4"),
            Cinema(5, "5"),
            Cinema(6, "6"),
            Cinema(7, "7"),
            Cinema(8, "8"),
            Cinema(9, "9"),
            Cinema(10, "10"),
            Cinema(11, "11"),
            Cinema(12, "12"),
            Cinema(13, "13"),
            Cinema(14, "14"),
            Cinema(15, "15"),
            Cinema(16, "16"),
            Cinema(17, "17"),
            Cinema(18, "18"),
            Cinema(19, "19")

        )

    fun updateRegionItemSelected(isSelected: Boolean) {
        _isRegionItemSelected.value = isSelected
    }
}
