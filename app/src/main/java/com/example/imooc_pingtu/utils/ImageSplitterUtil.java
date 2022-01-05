package com.example.imooc_pingtu.utils;

import android.graphics.Bitmap;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ImageSplitterUtil
{

	/**
	 * @param bitmap
	 * @param piece
	 *            切成piece*piece块
	 * @return List<ImagePiece>
	 */
	public static List<ImagePiece> splitImage(Bitmap bitmap, int piece)
	{
		List<ImagePiece> imagePieces = new ArrayList<ImagePiece>();

		int width = bitmap.getWidth();
		int height = bitmap.getHeight();

		int pieceWidth = Math.min(width, height) / piece;

		for (int i = 0; i < piece; i++)
		{
			for (int j = 0; j < piece; j++)
			{

				ImagePiece imagePiece = new ImagePiece();
				imagePiece.setIndex(j + i * piece);

				int x = j * pieceWidth;
				int y = i * pieceWidth;
				
				imagePiece.setBitmap(Bitmap.createBitmap(bitmap, x, y,
						pieceWidth, pieceWidth));
				imagePieces.add(imagePiece);
			}
		}

		return imagePieces;
	}
	/**
	 * 随机指定范围内N个不重复的数
	 * 最简单最基本的方法
	 * @param min 指定范围最小值
	 * @param max 指定范围最大值
	 * @param n 随机数个数
	 */
	public static int[] randomCommon(int min, int max, int n){
		if (n > (max - min + 1) || max < min) {
			return null;
		}
		int[] result = new int[n];
		int count = 0;
		while(count < n) {
			int num = (int) (Math.random() * (max - min)) + min;
			boolean flag = true;
			for (int j = 0; j < n; j++) {
				if(num == result[j]){
					flag = false;
					break;
				}
			}
			if(flag){
				result[count] = num;
				count++;
			}
		}
		return result;
	}




}
