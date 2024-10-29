package edu.unicauca.proyectomovil.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [HorariosDisponibles::class], version = 1, exportSchema = false)
abstract class HorariosDisponiblesDatabase : RoomDatabase() {

    abstract fun horariosDao(): HorariosDisponiblesDao

    companion object {
        @Volatile
        private var INSTANCE: HorariosDisponiblesDatabase? = null

        fun getDatabase(context: Context): HorariosDisponiblesDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    HorariosDisponiblesDatabase::class.java,
                    "horarios_disponibles_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
