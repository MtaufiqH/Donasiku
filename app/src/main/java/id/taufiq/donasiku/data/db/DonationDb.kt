package id.taufiq.donasiku.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

/**
 * Created By Taufiq on 1/22/2021.
 *
 */


@Database(entities = [DonationEntity::class], version = 1, exportSchema = false)
abstract class DonationDb : RoomDatabase() {
    abstract fun donateDao(): DonationDao

    companion object {
        @Volatile
        private var INSTANCE: DonationDb? = null
        private const val DB_NAME = "donate_db"

        @Synchronized
        fun getInstance(context: Context): DonationDb {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context, DonationDb::class.java, DB_NAME).build()
            }

            return INSTANCE!!
        }
    }

}