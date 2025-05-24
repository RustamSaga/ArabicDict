package dev.arabicdictionary.pro.arabicdictsdk.utils

import dev.arabicdictionary.pro.arabicdictsdk.data.words.ArabicGrammarCase
import dev.arabicdictionary.pro.arabicdictsdk.data.words.verb.PronounType
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

//object PronounTypeSerializer: KSerializer<PronounType> {
//    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("PronounType", PrimitiveKind.INT)
//
//    override fun serialize(encoder: Encoder, value: PronounType) = encoder.encodeInt(value.id)
//
//    override fun deserialize(decoder: Decoder): PronounType {
//        val id = decoder.decodeInt()
//        return PronounType.fromId(id) ?: throw SerializationException("Unknown PronounType id: $id")
//    }
//}
