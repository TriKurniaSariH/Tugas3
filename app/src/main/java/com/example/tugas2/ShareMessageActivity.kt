package com.example.tugas2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class ShareMessageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_share_message)

        val etMessage = findViewById<EditText>(R.id.etMessage)
        val btnShare = findViewById<Button>(R.id.btnShare)

        btnShare.setOnClickListener {
            val message = etMessage.text.toString()
            if (message.isNotEmpty()) {
                shareText(message)
            }
        }
    }

    private fun shareText(message: String) {
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "text/plain"
        intent.putExtra(Intent.EXTRA_TEXT, message)
        startActivity(Intent.createChooser(intent, "Share via"))
    }
}