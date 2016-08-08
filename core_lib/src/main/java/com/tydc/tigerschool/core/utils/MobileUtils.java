package com.tydc.tigerschool.core.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.telephony.TelephonyManager;

/**
 * Created by liwei on 16/7/31.
 */
public class MobileUtils {
    /**
     *
     * 获取设备的ID
     * @param context
     * @return
     * @author
     */
    public static String getDeviceId(Context context){
        String imei ="";
        if(context!=null){
            TelephonyManager telephonyManager = (TelephonyManager)
                    context.getSystemService(Context.TELEPHONY_SERVICE);
            imei = telephonyManager.getDeviceId();
            if(imei==null){
                imei="";
            }
        }
        return imei;
    }
    /**
     * 获取车旺对外发布版本号
     *
     * @return
     */
    public static String extractPltpVersionName(Context mContext) {
        String versionMain;
        try {
            PackageInfo pinfo = mContext.getPackageManager().getPackageInfo(
                    mContext.getPackageName(), PackageManager.GET_CONFIGURATIONS);
            versionMain = pinfo.versionName;
        } catch (Exception e) {
            versionMain = "NO VERSION CODE";
        }
        return versionMain;
    }
}
