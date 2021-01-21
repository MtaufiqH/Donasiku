package id.taufiq.donasiku.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import id.taufiq.donasiku.R
import id.taufiq.donasiku.data.response.DonasiItem
import id.taufiq.donasiku.utils.formatRupiahs
import kotlinx.android.synthetic.main.donasi_list.view.*

/**
 * Created By Taufiq on 1/20/2021.
 *
 */
class DonationAdapter(
    private val itemList: List<DonasiItem>,
    private val onItemClick: (DonasiItem) -> Unit
) : RecyclerView.Adapter<DonationAdapter.DonasiListItem>() {

    class DonasiListItem constructor(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        fun bind(item: DonasiItem, itemClick: (DonasiItem) -> Unit) {
            itemView.apply {
                this.tv_donation_title.text = item.title
                tv_current_donation.text = formatRupiahs(item.currentDonation.toDouble())
                Glide.with(context).load(item.photo).into(iv_poster)
                progress.max = item.targetDonation.toInt()
                progress.progress = item.currentDonation.toInt()
                setOnClickListener { itemClick(item) }
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DonasiListItem {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.donasi_list, parent, false)
        return DonasiListItem(view)
    }


    override fun onBindViewHolder(holder: DonasiListItem, position: Int) {
        holder.bind(itemList[position], onItemClick)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }


}