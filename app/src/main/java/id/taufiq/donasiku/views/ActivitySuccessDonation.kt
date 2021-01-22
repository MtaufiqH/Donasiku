package id.taufiq.donasiku.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import id.taufiq.donasiku.R
import id.taufiq.donasiku.utils.delayFunction

class ActivitySuccessDonation : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_success_donation)

        @Suppress("DEPRECATION")
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        delayFunction({toMain()},3000)
    }

    private fun toMain(){
        Intent(this,MainActivity::class.java).run {
            startActivity(this)
        }
    }
}