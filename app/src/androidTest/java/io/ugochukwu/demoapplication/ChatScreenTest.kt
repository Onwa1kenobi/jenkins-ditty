package io.ugochukwu.demoapplication

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import io.ugochukwu.demoapplication.feature.chat.ChatBubbleItem
import io.ugochukwu.demoapplication.feature.chat.ChatMessage
import io.ugochukwu.demoapplication.feature.chat.Participant
import io.ugochukwu.demoapplication.ui.theme.AppTheme
import org.junit.Rule
import org.junit.Test

class ChatScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    // use createAndroidComposeRule<YourActivity>() if you need access to an activity
//    @get:Rule
//    val composeTestRule = createAndroidComposeRule(MainActivity::class.java)

    @Test
    fun aiModelChatMessageTest() {
        val greeting = "Hello! How are you?"
        val message = ChatMessage(
            participant = Participant.AI_MODEL,
            text = greeting
        )
        composeTestRule.setContent {
            AppTheme {
                ChatBubbleItem(message)
            }
        }

        composeTestRule.onNodeWithText(greeting).assertExists()
        composeTestRule.onNodeWithText(greeting).assertIsDisplayed()
        composeTestRule.onNodeWithText(Participant.AI_MODEL.name).assertExists()
        composeTestRule.onNodeWithText(Participant.AI_MODEL.name).assertIsDisplayed()
    }
}