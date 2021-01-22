package id.taufiq.donasiku.views

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import id.taufiq.donasiku.R
import id.taufiq.donasiku.data.network.response.DonasiItem
import id.taufiq.donasiku.viewmodel.DonasiViewModel
import id.taufiq.donasiku.viewmodel.DonasiViewModelFactory
import kotlinx.android.synthetic.main.activity_add_donasi.*

 class AddDonasiActivity : AppCompatActivity() {
     val factory  by lazy {
         val app  = application
         DonasiViewModelFactory(app)
     }
    private val viewmodel by viewModels<DonasiViewModel>{factory}
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
                        viewmodel.insertDonation(
                            DonasiItem(
                                id,
                                createdAt,
                                currentDonation,
                                description,
                                photo,
                                sourcePhoto,
                                targetDonation,
                                title
                            )
                        )
                        Intent(this@AddDonasiActivity, ActivitySuccessDonation::class.java).run {
                            startActivity(this)

                        }
                    }
                }
            }
        }
    }
}