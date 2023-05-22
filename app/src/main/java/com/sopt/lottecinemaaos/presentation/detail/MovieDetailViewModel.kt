package com.sopt.lottecinemaaos.presentation.detail

import androidx.lifecycle.ViewModel
import com.sopt.lottecinemaaos.R
import com.sopt.lottecinemaaos.domain.model.Poster
import com.sopt.lottecinemaaos.domain.model.Trailer

class MovieDetailViewModel : ViewModel() {
    val trailerList = listOf<Trailer>(
        Trailer(
            src = R.drawable.img_trailer1,
            title = "티저 예고편"
        ),
        Trailer(
            src = R.drawable.img_trailer2,
            title = "메인 예고편"
        ),
        Trailer(
            src = R.drawable.img_trailer3,
            title = "'돌아온 가디언즈' 30초 예고편"
        ),
        Trailer(
            src = R.drawable.img_trailer4,
            title = "Team '가디언즈'가 맞설 마지막 미션!"
        ),
        Trailer(
            src = R.drawable.img_trailer5,
            title = "전 세계 최초 개봉! 전 포맷 예매 오픈!"
        )
    )

    val posterList = listOf<Poster>(
        Poster(
            src = R.drawable.img_poster1
        ),
        Poster(
            src = R.drawable.img_stillcut1
        ),
        Poster(
            src = R.drawable.img_stillcut2
        ),
        Poster(
            src = R.drawable.img_stillcut3
        ),
        Poster(
            src = R.drawable.img_stillcut4
        ),
        Poster(
            src = R.drawable.img_stillcut5
        ),
    )
}
