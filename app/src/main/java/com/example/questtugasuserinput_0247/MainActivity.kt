package com.example.questtugasuserinput_0247

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.ui.Modifier
import com.example.questtugasuserinput_0247.ui.theme.QuestTugasUserInput_0247Theme
import com.example.questtugasuserinput_0247.ui.theme.act5

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            QuestTugasUserInput_0247Theme {
                act5(modifier = Modifier)
            }
        }
    }
}
