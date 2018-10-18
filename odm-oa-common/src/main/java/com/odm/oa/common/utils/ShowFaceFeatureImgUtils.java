package com.odm.oa.common.utils;

public class ShowFaceFeatureImgUtils {
	// data:image/jpg;base64,
	public static String getFaceFeatureImgSrc(String faceFeature) {
		return "data:image/jpg;base64," + faceFeature;
	}
}
