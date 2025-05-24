package dev.arabicdictionary.pro.arabicdictsdk.data.downloader

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.File

actual class FileStorage(
    private val baseDir: File,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) {
    actual suspend fun saveData(fileName: String, bytes: ByteArray): String =
        withContext(dispatcher) {
            val file = File(baseDir, fileName)
            file.writeBytes(bytes)
            return@withContext file.absolutePath
        }
}