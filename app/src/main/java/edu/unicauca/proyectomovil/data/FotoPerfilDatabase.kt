//package edu.unicauca.proyectomovil.data
//
//import android.content.Context
//import androidx.room.Database
//import androidx.room.Room
//import androidx.room.RoomDatabase
//
//@Database(entities = [FotoPerfil::class], version = 1, exportSchema = false)
//abstract class FotoPerfilDatabase : RoomDatabase() {
//
//    abstract fun fotoPerfilDao(): FotoPerfilDao
//
//    companion object {
//        @Volatile
//        private var INSTANCE: FotoPerfilDatabase? = null
//
//        fun getDatabase(context: Context): FotoPerfilDatabase {
//            return INSTANCE ?: synchronized(this) {
//                val instance = Room.databaseBuilder(
//                    context.applicationContext,
//                    FotoPerfilDatabase::class.java,
//                    "foto_perfil_database"
//                ).build()
//                INSTANCE = instance
//                instance
//            }
//        }
//    }
//}
//
