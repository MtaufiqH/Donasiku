package id.taufiq.donasiku.views

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import id.taufiq.donasiku.R
import id.taufiq.donasiku.data.response.DonasiItem
import id.taufiq.donasiku.utils.formatRupiahs
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        intent.getParcelableExtra<DonasiItem>("DATA")?.apply {
            tv_title_detail.text = this.title
            tv_current_detail.text = formatRupiahs(this.currentDonation.toDouble())
            tv_target_detail.text = formatRupiahs(this.targetDonation.toDouble())
            progressBar_detail.max = this.targetDonation.toInt()
            progressBar_detail.progress = this.currentDonation.toInt()
            tv_cerita_detail.text = this.description
            Glide.with(this@DetailActivity).load(this.photo).into(iv_poster_detail)
        }

        btn_donasi.setOnClickListener {
            startActivity(Intent(this,ActivitySuccessDonation::class.java))
        }


    }

}