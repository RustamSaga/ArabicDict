package dev.arabicdictionary.pro.core.uikit.localization

enum class ArabicDictLanguage(
    val iso: String,
    val value: String
) {
    English(iso = "en", value = "English"),
    Russian(iso = "ru", value = "Русский"),
    Arabic(iso = "ar", value = "العربية");

    companion object {
        fun getByIso(iso: String): ArabicDictLanguage {
            return when(iso) {
                "en" -> English
                "ru" -> Russian
                "ar" -> Arabic
                else -> English
            }
        }
    }
}

