package dev.arabicdictionary.pro.arabicdictsdk.utils

import dev.arabicdictionary.pro.arabicdictsdk.data.words.verb.VerbConfirmed
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

//object VerbEmphasisSerializer : KSerializer<VerbConfirmed> {
//    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("VerbEmphasis", PrimitiveKind.INT)
//
//    override fun serialize(encoder: Encoder, value: VerbConfirmed) = encoder.encodeInt(value.id)
//
//    override fun deserialize(decoder: Decoder): VerbConfirmed {
//        val id = decoder.decodeInt()
//        return VerbConfirmed.fromId(id) ?: throw SerializationException("Unknown VerbEmphasis id: $id")
//    }
//}

