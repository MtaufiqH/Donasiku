package id.taufiq.donasiku.data.network.response


import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "donation_table")
data class DonasiItem(
    @SerializedName("id")
    @PrimaryKey
    val id: String,

    @ColumnInfo(name = "created_at")
    @SerializedName("createdAt")
    val createdAt: String,

    @ColumnInfo(name = "current_donation")
    @SerializedName("currentDonation")
    val currentDonation: Long,

    @SerializedName("description")
    val description: String,

    @SerializedName("photo")
    val photo: String,

    @ColumnInfo(name = "source_photo")
    @SerializedName("source_photo")
    val sourcePhoto: String,

    @ColumnInfo(name = "target_donation")
    @SerializedName("targetDonation")
    val targetDonation: Long,

    @SerializedName("title")
    val title: String
) : Parcelable