package dev.arabicdictionary.pro.arabicdictsdk.utils

import dev.arabicdictionary.pro.arabicdictsdk.data.words.NumberType
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

object NumberTypeSerializer: KSerializer<NumberType> {
    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("NumberType", PrimitiveKind.INT)

    override fun serialize(encoder: Encoder, value: NumberType) = encoder.encodeInt(value.id)

    override fun deserialize(decoder: Decoder): NumberType {
        val id = decoder.decodeInt()
        return NumberType.fromId(id) ?: throw SerializationException("Unknown NumberType id: $id")
    }
}