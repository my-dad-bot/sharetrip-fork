package net.sharetrip.flight.shared.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import net.sharetrip.flight.shared.model.GuestLoginListener

data class GuestPopUpData (
    @StringRes
    val title: Int,
    @StringRes
    val detail: Int,
    @DrawableRes val icon: Int,
    val listener: GuestLoginListener?
)
