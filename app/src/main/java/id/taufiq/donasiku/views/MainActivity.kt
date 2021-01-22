package id.taufiq.donasiku.views

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import id.taufiq.donasiku.R
import id.taufiq.donasiku.adapter.DonationAdapter
import id.taufiq.donasiku.utils.startActivity
import id.taufiq.donasiku.viewmodel.DonasiViewModel
import id.taufiq.donasiku.viewmodel.DonasiViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val factory  by lazy {
        val app  = application
        DonasiViewModelFactory(app)
    }
    private val viewmodel by viewModels<DonasiViewModel> {factory}

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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.donate_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_history -> {
                startActivity(HistoryDonateActivity::class.java)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }

    }
}