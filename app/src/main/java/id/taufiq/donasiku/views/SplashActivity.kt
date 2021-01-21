package id.taufiq.donasiku.views

import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import id.taufiq.donasiku.R
import id.taufiq.donasiku.utils.delayFunction
import id.taufiq.donasiku.utils.startActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        @Suppress("DEPRECATION")
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        delayFunction(
            {
                startActivity(MainActivity::class.java)
                finish()
            },
            3000
        )
    }

}