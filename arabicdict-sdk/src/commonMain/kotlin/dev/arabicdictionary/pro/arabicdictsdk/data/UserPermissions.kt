package dev.arabicdictionary.pro.arabicdictsdk.data

import kotlinx.serialization.SerialName

data class UserPermissions(
    @SerialName("can_download") val canDownload: Boolean,
)
