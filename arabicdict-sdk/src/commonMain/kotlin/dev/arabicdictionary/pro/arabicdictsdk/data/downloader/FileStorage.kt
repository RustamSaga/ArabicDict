package dev.arabicdictionary.pro.arabicdictsdk.data.downloader

expect class FileStorage {
    suspend fun saveData(
        fileName: String,
        bytes: ByteArray,
    ): String
}
