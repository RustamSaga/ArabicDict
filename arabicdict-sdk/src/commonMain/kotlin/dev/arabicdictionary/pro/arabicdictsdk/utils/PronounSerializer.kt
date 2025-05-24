package dev.arabicdictionary.pro.arabicdictsdk.utils

import dev.arabicdictionary.pro.arabicdictsdk.data.words.verb.Pronoun
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

//object PronounSerializer: KSerializer<Pronoun> {
//    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("Pronoun", PrimitiveKind.INT)
//
//    override fun deserialize(decoder: Decoder): Pronoun {
//        val id = decoder.decodeInt()
//        return Pronoun.findId(id) ?: throw SerializationException("Unknown Pronoun id: $id")
//    }
//
//    override fun serialize(encoder: Encoder, value: Pronoun) {
//        encoder.encodeInt(value.id)
//    }
//}
