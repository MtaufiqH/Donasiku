package id.taufiq.donasiku.views

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import id.taufiq.donasiku.R
import id.taufiq.donasiku.data.network.response.DonasiItem
import kotlinx.android.synthetic.main.activity_add_donasi.*

class AddDonasiActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_donasi)

        intent.getParcelableExtra<DonasiItem>("DATAKU")?.apply {
            val numberOfDonation = et_jumlah_donasi.text
            val name = et_nama.text
            val email = et_email.text

            btn_add_donasi.setOnClickListener {
                when {
                    numberOfDonation.isEmpty() -> {
                        et_jumlah_donasi.error = "isi jumlah donasi"
                    }

                    name.isEmpty() -> {
                        et_nama.error = "isi nama anda"
                    }

                    email.isEmpty() -> {
                        et_email.error = "isi email anda"
                    }

                    else -> {
                        Intent(this@AddDonasiActivity, ActivitySuccessDonation::class.java).run {
                            startActivity(this)
                            finish()
                        }
                    }
                }
            }
        }
    }
}