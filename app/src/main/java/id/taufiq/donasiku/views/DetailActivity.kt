package id.taufiq.donasiku.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import id.taufiq.donasiku.R
import id.taufiq.donasiku.data.response.DonasiItem
import kotlinx.android.synthetic.main.donasi_list.*

class DetailActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)


        val data = intent.getParcelableExtra<DonasiItem>("DATA")
        if (data != null) {

        }


    }

}