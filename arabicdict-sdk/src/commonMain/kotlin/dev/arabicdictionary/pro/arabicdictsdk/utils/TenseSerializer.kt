package dev.arabicdictionary.pro.arabicdictsdk.utils

import dev.arabicdictionary.pro.arabicdictsdk.data.words.verb.Tense
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

//object TenseSerializer : KSerializer<Tense> {
//    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("Tense", PrimitiveKind.INT)
//
//    override fun serialize(encoder: Encoder, value: Tense) = encoder.encodeInt(value.id)
//
//    override fun deserialize(decoder: Decoder): Tense {
//        val id = decoder.decodeInt()
//        return Tense.fromId(id) ?: throw SerializationException("Unknown Tense id: $id")
//    }
//}
