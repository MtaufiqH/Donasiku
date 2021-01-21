package id.taufiq.donasiku.views

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import id.taufiq.donasiku.R
import id.taufiq.donasiku.data.response.DonasiItem
import kotlinx.android.synthetic.main.activity_add_donasi.*

class AddDonasiActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_donasi)

        intent.getParcelableExtra<DonasiItem>("DATAKU")?.apply {
            val numberOfDonation = et_jumlah_donasi.text.toString()

            btn_add_donasi.setOnClickListener {
                Intent(this@AddDonasiActivity, ActivitySuccessDonation::class.java).run {
                    startActivity(this)
                    if (numberOfDonation.isEmpty()){
                        et_jumlah_donasi.error = "isi jumlah donasi"
                    } else{
                        Log.d("TAG", "donasi empty")
                    }
                    finishAffinity()
                }
            }
        }
    }
}