package id.taufiq.donasiku.data.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created By Taufiq on 1/22/2021.
 *
 */

@Entity(tableName = "donation_table")
data class DonationEntity(
    @PrimaryKey(autoGenerate = true)
    val id: String,
    @ColumnInfo(name = "created_at")
    val createdAt: String,
    @ColumnInfo(name = "current_donation")
    val currentDonation: Long,
    val description: String,
    val photo: String,
    @ColumnInfo(name = "source_photo")
    val sourcePhoto: String,
    @ColumnInfo(name = "target_donation")
    val targetDonation: Long,
    val title: String
    )
