package dev.arabicdictionary.pro.arabicdictsdk.utils

import dev.arabicdictionary.pro.arabicdictsdk.data.words.GenderType
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

//object GenderTypeSerializer: KSerializer<GenderType> {
//    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("GenderType", PrimitiveKind.INT)
//
//    override fun deserialize(decoder: Decoder): GenderType {
//        val id = decoder.decodeInt()
//        return GenderType.findId(id) ?: throw SerializationException("Unknown GenderType id: $id")
//    }
//
//    override fun serialize(encoder: Encoder, value: GenderType) {
//        encoder.encodeInt(value.id)
//    }
//}
