package com.example.notesappfragments.Model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize
import javax.security.auth.Subject

@Parcelize
@Entity(tableName = "Note")
data class Note(
    @PrimaryKey(autoGenerate = true) val pk: Int,
    @ColumnInfo val title: String?,
    @ColumnInfo val subTitle:String,
    @ColumnInfo val noteDescription: String?,
    @ColumnInfo var date:String = ""
):Parcelable