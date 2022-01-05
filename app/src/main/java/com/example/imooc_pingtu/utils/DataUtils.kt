package com.example.imooc_pingtu.utils

import android.graphics.Bitmap
import com.example.imooc_pingtu.R
import java.util.*

class DataUtils {

    companion object {
        @JvmStatic
        fun splitImage(bitmap: Bitmap, piece: Int): List<ImagePiece> {
            val imagePieces = ArrayList<ImagePiece>()

            val width = bitmap.width
            val height = bitmap.height

            val pieceWidth = Math.min(width, height) / piece

            for (i in 0 until piece) {
                for (j in 0 until piece) {

                    val imagePiece = ImagePiece()
                    imagePiece.index = j + i * piece

                    val x = j * pieceWidth
                    val y = i * pieceWidth

                    imagePiece.bitmap = Bitmap.createBitmap(
                        bitmap, x, y,
                        pieceWidth, pieceWidth
                    )
                    imagePieces.add(imagePiece)
                }
            }

            return imagePieces
        }

        @JvmStatic
        fun createData(): Int {
            val ints = arrayListOf<Int>(
                R.drawable.frame_001,
                R.drawable.frame_002,
                R.drawable.frame_003,
                R.drawable.frame_004,
                R.drawable.frame_005,
                R.drawable.frame_006,
                R.drawable.qq14,
                R.drawable.qq15,
                R.drawable.qq16,
                R.drawable.qq17,
                R.drawable.qq18,
                R.drawable.qq19,
                R.drawable.qq20,
                R.drawable.qq21,
                R.drawable.qq23
            )

            val random = Random()
            val i = random.nextInt(ints.size)
            ints.sortWith(Comparator { a, b -> if (Math.random() > 0.5) 1 else -1 })
            return ints[i]
        }



    }

}