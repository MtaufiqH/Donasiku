package id.taufiq.donasiku.views

import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import id.taufiq.donasiku.R
import id.taufiq.donasiku.adapter.DonationAdapter
import id.taufiq.donasiku.viewmodel.DonasiViewModel
import kotlinx.android.synthetic.main.activity_main.*

@RequiresApi(Build.VERSION_CODES.M)
class MainActivity : AppCompatActivity() {

    private val viewmodel by viewModels<DonasiViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewmodel.allDonations.observe(this, Observer { data ->
            rv_donations.adapter = DonationAdapter(data) {
                Intent(this, DetailActivity::class.java).run {
                    putExtra("DATA", it)
                }.also {
                    startActivity(it)
                }
            }
        })
    }
}