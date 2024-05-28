package io.ugochukwu.demoapplication.util

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import com.google.firebase.Firebase
import com.google.firebase.vertexai.type.generationConfig
import com.google.firebase.vertexai.vertexAI
import io.ugochukwu.demoapplication.feature.chat.ChatViewModel

val GenerativeViewModelFactory = object : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(
        modelClass: Class<T>,
        extras: CreationExtras
    ): T {
        val config = generationConfig {
            temperature = 0.7f
        }

        // Initialize a GenerativeModel with the `gemini-pro` AI model for chat
        val generativeModel = Firebase.vertexAI.generativeModel(
            modelName = "gemini-1.5-pro-preview-0409",
            generationConfig = config
        )
        return ChatViewModel(generativeModel) as T
    }
}