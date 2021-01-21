package id.taufiq.donasiku.data.response


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DonasiItem(
    @SerializedName("createdAt")
    val createdAt: String,
    @SerializedName("currentDonation")
    val currentDonation: Long,
    @SerializedName("description")
    val description: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("photo")
    val photo: String,
    @SerializedName("source_photo")
    val sourcePhoto: String,
    @SerializedName("targetDonation")
    val targetDonation: Long,
    @SerializedName("title")
    val title: String
) : Parcelable