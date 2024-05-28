package io.ugochukwu.demoapplication

import io.ugochukwu.demoapplication.feature.chat.ChatMessage
import io.ugochukwu.demoapplication.feature.chat.Participant
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }
    @Test
    fun default_chat_message_isUSER() {
        val message = ChatMessage()
        assertEquals(message.participant, Participant.USER)
    }
}