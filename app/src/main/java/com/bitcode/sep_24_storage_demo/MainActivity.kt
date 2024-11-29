package com.bitcode.sep_24_storage_demo

import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.EnvironmentCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.io.FileInputStream
import java.io.FileOutputStream

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        var dataDirectory = Environment.getDataDirectory()
        Log.e("tag","Data Directory -- $dataDirectory -- ${dataDirectory.name} -- ${dataDirectory.path} --${dataDirectory.usableSpace} ${dataDirectory.freeSpace} -- ${dataDirectory.totalSpace}")

        var rootDir = Environment.getRootDirectory()
        Log.e("tag","Root Dir -- $rootDir")

        var storageDir = Environment.getStorageDirectory()
        Log.e("tag", "Storage Dir -- ${storageDir.name} -- ${storageDir.path} -- ${storageDir.absoluteFile} -- ${storageDir.absolutePath} -- ${storageDir.totalSpace} -- ${storageDir.freeSpace}")

        var externalStorageState = Environment.getExternalStorageState()
        Log.e("tag","$externalStorageState")

        var musicDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC)
        Log.e("tag", "${musicDir.path} -- ${musicDir.name} -- ${musicDir.totalSpace} -- ${musicDir.usableSpace} -- ${musicDir.freeSpace} -- ${musicDir.absoluteFile} -- ${musicDir.canonicalPath}")

        var documentsDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS)
        Log.e("tag","${documentsDir.name} -- ${documentsDir.path} -- ${documentsDir.freeSpace} -- ${documentsDir.freeSpace} -- ${documentsDir.usableSpace} -- ${documentsDir.totalSpace}")

        var moviesDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MOVIES)
        Log.e("tag","${moviesDir.path} -- ${moviesDir.name} -- ${moviesDir.freeSpace} -- ${moviesDir.totalSpace} -- ${moviesDir.usableSpace} -- ${moviesDir.absolutePath} -- ${moviesDir.absoluteFile}")

        var testFileInputStream : FileInputStream = openFileInput("test_file.txt")

        var fileOutputStream : FileOutputStream = openFileOutput("test_file.txt", MODE_WORLD_WRITEABLE)
        fileOutputStream.write("Android Sep 24".toByteArray())
        fileOutputStream.write("iOS AUG 24 Batch".toByteArray())

        var count = 0
        var byteArray = ByteArray(1024 * 1)
        var buffer = StringBuffer()

        count = testFileInputStream.read(byteArray)

        while (count != -1){
            buffer.append(String(byteArray,0,count))
            count = testFileInputStream.read(byteArray)
        }

        Log.e("tag", buffer.toString())
        testFileInputStream.close()
    }
}