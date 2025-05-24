package dev.arabicdictionary.pro.arabicdictsdk.utils

import dev.arabicdictionary.pro.arabicdictsdk.data.words.verb.VerbVoice
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

//object VerbVoiceSerializer : KSerializer<VerbVoice> {
//    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("VerbVoice", PrimitiveKind.INT)
//
//    override fun serialize(encoder: Encoder, value: VerbVoice) = encoder.encodeInt(value.id)
//
//    override fun deserialize(decoder: Decoder): VerbVoice {
//        val id = decoder.decodeInt()
//        return VerbVoice.fromId(id) ?: throw SerializationException("Unknown VerbVoice id: $id")
//    }
//}
