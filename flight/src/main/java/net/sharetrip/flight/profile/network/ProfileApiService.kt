package net.sharetrip.flight.profile.network

import com.sharetrip.base.network.model.GenericResponse
import net.sharetrip.flight.profile.model.FaqResponse
import net.sharetrip.flight.profile.model.TocResponse
import retrofit2.http.GET

interface ProfileApiService {

    @GET("https://sharetrip-96054.firebaseio.com/flight_admin/faq.json")
    suspend fun getFAQResponse(): GenericResponse<FaqResponse>

    @GET("https://sharetrip-96054.firebaseio.com/flight_admin/toc.json")
    suspend fun getTOCResponse(): GenericResponse<TocResponse>

}
