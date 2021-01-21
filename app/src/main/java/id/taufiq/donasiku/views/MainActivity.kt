package id.taufiq.donasiku.views

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import id.taufiq.donasiku.R
import id.taufiq.donasiku.adapter.DonationAdapter
import id.taufiq.donasiku.viewmodel.DonasiViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val viewmodel by viewModels<DonasiViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewmodel.allDonations.observe(this, Observer { data ->
            rv_donations.adapter = DonationAdapter(data) {
                Toast.makeText(this, "clicked ${it.title}", Toast.LENGTH_SHORT).show()
            }
        })
    }
}