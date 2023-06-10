package mx.com.cfe.cfecontig.models

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize
import mx.com.cfe.cfecontig.CandyConstants

@Parcelize
@Entity(tableName = CandyConstants.USER_TABLE)
data class User (
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    @ColumnInfo(name = "movement")
    val movement: String,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "dba")
    val dba: String,
    @ColumnInfo(name = "model")
    val model: String,
    @ColumnInfo(name = "boot")
    val boot: String,
    @ColumnInfo(name = "fingerprint")
    val fingerprint: String

    ) : Parcelable