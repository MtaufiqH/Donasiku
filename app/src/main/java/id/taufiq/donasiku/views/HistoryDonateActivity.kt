package id.taufiq.donasiku.views

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import id.taufiq.donasiku.R
import id.taufiq.donasiku.adapter.DonationAdapter
import id.taufiq.donasiku.viewmodel.DonasiViewModel
import kotlinx.android.synthetic.main.activity_history_donate.*

class HistoryDonateActivity : AppCompatActivity() {

    private val viewmodel by viewModels<DonasiViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history_donate)

        viewmodel.localDonate.observe(this, Observer {
            recyclerView_history.apply {
                layoutManager = LinearLayoutManager(this@HistoryDonateActivity)
                adapter = DonationAdapter(it) {
                    Toast.makeText(this@HistoryDonateActivity, "you clicked me", Toast.LENGTH_SHORT)
                        .show()
                }
            }

        })
    }
}
