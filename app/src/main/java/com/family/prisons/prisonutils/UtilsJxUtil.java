package com.family.prisons.prisonutils;

import android.graphics.Bitmap;

import java.util.Arrays;

import jx.vein.javajar.JXFVJavaInterface;

public class UtilsJxUtil {

    /**
     * 指静脉SDK组装结束符
     **/
    public static final String VEIN_ID_SEPARATOR_END = "#";

    /**
     * 指静脉SDK组装分隔符，用于分割用户ID和指静脉编号
     **/
    public static final String VEIN_ID_SEPARATOR_MIDDLE = "_";

    /**
     * 字符串转字节数组
     **/
    public static byte[] string2bytes(String str, int length) {
        if (str.length() >= length) {
            throw new IllegalArgumentException(str + ": is too long!");
        }

        byte[] bytes = new byte[length];

        byte[] strBytes = str.getBytes();

        for (int i = 0; i < strBytes.length; i++) {
            bytes[i] = strBytes[i];
        }

        return bytes;
    }

    /**
     * 字节数组转字符串
     **/
    public static String bytes2string(byte[] bytes) {
        StringBuffer stringBuffer = new StringBuffer();

        for (int i = 0; i < bytes.length; i++) {
            if (bytes[i] != 0) {
                char c = (char) bytes[i];
                stringBuffer.append(c);
            }
        }

        return stringBuffer.toString();
    }

    /**
     * id
     **/
    public static byte[] veinId2Bytes(String id, int fingerNo, String group) {

        if (group.equals("0")) {
            group = "0";    // 管理员
        } else if (group.endsWith("#")) {
            group = "1";     // 狱警
        } else {
            group = "2";    // 犯人
        }

        String veinId = id + VEIN_ID_SEPARATOR_MIDDLE + fingerNo + VEIN_ID_SEPARATOR_END + group;
        byte[] bytes = string2bytes(veinId, JXFVJavaInterface.veinIDLength);

        return bytes;
    }

    public static String bytes2VeinId(byte[] id) {
        String veinId = bytes2string(id);
        String str = veinId.substring(0, veinId.indexOf(VEIN_ID_SEPARATOR_MIDDLE));

        return str;
    }


    /**
     * group
     **/
    public static byte[] groupId2Bytes(String id) {
        byte[] bytes = string2bytes(id, JXFVJavaInterface.groupIDLength);

        return bytes;
    }

    public static String bytes2GroupId(byte[] id) {
        String groupId = bytes2string(id);

        return groupId;
    }


    /**
     * 指静脉原始图像数据转图片
     **/
    public static Bitmap veinDataToBitmap(byte[] imgBytes) {
        return veinDataToBitmap(imgBytes, JXFVJavaInterface.imgCols, JXFVJavaInterface.imgRows);
    }

    /**
     * 指静脉原始图像数据转图片
     **/
    public static Bitmap veinDataToBitmap(byte[] imgBytes, int width, int height) {
        if (imgBytes == null || imgBytes.length == 0) {
            return null;
        }

        int[] imgByteToInt = new int[imgBytes.length];

        for (int i = 0; i < imgByteToInt.length; i++) {
            //关键代码
            imgByteToInt[i] = imgBytes[i] * 256 * 256 + imgBytes[i] * 256 + imgBytes[i] + 0xFF000000;
        }

        Bitmap bitmap = Bitmap.createBitmap(imgByteToInt, JXFVJavaInterface.imgCols, JXFVJavaInterface.imgRows, Bitmap.Config.ARGB_8888);

        // 旋转
        // UtilsImage.rotate(bitmap1, 90, 0, 0);

        return UtilsImage.scale(bitmap, 400, 400);
    }


    public static boolean compareVeinId(byte[] veinIds, int length) {
        if (veinIds == null || length == 0 || veinIds.length % length != 0) {
            return false;
        }

        byte[] src = new byte[length];
        System.arraycopy(veinIds, 0, src, 0, length);

        byte[] bytes = new byte[length];

        for (int i = 1; i < veinIds.length / length; i++) {
            System.arraycopy(veinIds, 0, bytes, 0, length);
            if (!Arrays.equals(src, bytes)) {
                return false;
            }
        }

        return true;

    }

}
