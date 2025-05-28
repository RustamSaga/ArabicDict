package dev.arabicdictionary.pro.arabicdictsdk.data.downloader

actual class FileStorage(
//    private val baseDir: NSURL,
) {
    actual suspend fun saveData(
        fileName: String,
        bytes: ByteArray,
    ): String {
        TODO()
    }
}
