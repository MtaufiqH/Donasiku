package id.taufiq.donasiku.views

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import id.taufiq.donasiku.R
import id.taufiq.donasiku.adapter.DonationAdapter
import id.taufiq.donasiku.viewmodel.DonasiViewModel
import id.taufiq.donasiku.viewmodel.DonasiViewModelFactory
import kotlinx.android.synthetic.main.activity_history_donate.*

class HistoryDonateActivity : AppCompatActivity() {

    val factory by lazy {
        val app = application
        DonasiViewModelFactory(app)
    }


    private val viewmodel by viewModels<DonasiViewModel> { factory }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history_donate)

        viewmodel.localDonate.observe(this, Observer {
            recyclerView_history.apply {
                layoutManager = LinearLayoutManager(this@HistoryDonateActivity)
                adapter = DonationAdapter(it) {
                }
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.history_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.delete_history -> {
                viewmodel.deleteDonation()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }

    }
}


