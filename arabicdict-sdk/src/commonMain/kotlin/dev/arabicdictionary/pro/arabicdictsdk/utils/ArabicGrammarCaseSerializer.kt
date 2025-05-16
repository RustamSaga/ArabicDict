package dev.arabicdictionary.pro.arabicdictsdk.utils

import dev.arabicdictionary.pro.arabicdictsdk.data.words.ArabicGrammarCase
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder


object ArabicGrammarCaseSerializer : KSerializer<ArabicGrammarCase> {
    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("ArabicGrammarCase", PrimitiveKind.INT)

    override fun serialize(encoder: Encoder, value: ArabicGrammarCase) = encoder.encodeInt(value.id)

    override fun deserialize(decoder: Decoder): ArabicGrammarCase {
        val id = decoder.decodeInt()
        return ArabicGrammarCase.fromId(id) ?: throw SerializationException("Unknown ArabicGrammarCase id: $id")
    }
}
