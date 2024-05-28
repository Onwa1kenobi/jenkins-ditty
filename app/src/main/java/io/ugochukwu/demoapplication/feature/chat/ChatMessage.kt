package io.ugochukwu.demoapplication.feature.chat

import java.util.UUID

enum class Participant {
    USER, AI_MODEL, ERROR
}

data class ChatMessage(
    val id: String = UUID.randomUUID().toString(),
    var text: String = "",
    val participant: Participant = Participant.USER,
    var isPending: Boolean = false
)