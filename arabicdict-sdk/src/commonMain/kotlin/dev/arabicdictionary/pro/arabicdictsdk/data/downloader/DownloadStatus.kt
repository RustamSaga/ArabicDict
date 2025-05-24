package dev.arabicdictionary.pro.arabicdictsdk.data.downloader

sealed class DownloadStatus {
    data class Progress(val bytesRead: Long, val totalBytes: Long?) : DownloadStatus()
    data class Success(val savedFilePath: String) : DownloadStatus()
    data class Error(val message: String) : DownloadStatus()
    data object NotPurchased : DownloadStatus()
    data object NetworkUnavailable : DownloadStatus()
    data object Unauthorized : DownloadStatus()
}

