package net.sharetrip.flight.profile.view.content

import androidx.lifecycle.MutableLiveData
import net.sharetrip.flight.profile.base.BaseRepository
import net.sharetrip.flight.profile.model.FaqResponse
import net.sharetrip.flight.profile.model.TocResponse
import net.sharetrip.flight.profile.network.ProfileApiService

class ContentRepo(private val apiService: ProfileApiService) : BaseRepository() {

    val liveData = MutableLiveData<FaqResponse>()
    val liveDataToc = MutableLiveData<TocResponse>()

    suspend fun fetchFaq() {
        callApi<FaqResponse>(
            executableCodeBlock = {
                apiService.getFAQResponse()
            },

            onSuccess = {
                liveData.value = it
            },

            onFailed = { _, _ -> }
        )
    }

    suspend fun fetchTermsAndCondition() {
        callApi<TocResponse>(
            executableCodeBlock = {
                apiService.getTOCResponse()
            },

            onSuccess = {
                liveDataToc.value = it
            },

            onFailed = { _, _ -> }
        )
    }
}
