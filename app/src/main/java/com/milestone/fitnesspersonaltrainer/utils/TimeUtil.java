package com.milestone.fitnesspersonaltrainer.utils;

import java.util.Calendar;

public class TimeUtil {



    /**获取两个时间的间隔mime数组，最小精确到秒(如两个时间间隔：2年3月5天7时18分9秒)
     * @param leftTime
     * @param rightTime
     * @return 返回时间间隔的mime数组，如[年][月][日][时][分][秒],如果leftTime > rightTime返回null
     */
    public static int[] divideBetween(long leftTime, long rightTime) {
        if (leftTime > rightTime) {
            return null;
        }
        Calendar startC = Calendar.getInstance();
        startC.setTimeInMillis(leftTime);

        Calendar tagC = Calendar.getInstance();
        tagC.setTimeInMillis(rightTime);

        int startY = startC.get(Calendar.YEAR);
        int startM = startC.get(Calendar.MONTH) + 1;
        int startD = startC.get(Calendar.DAY_OF_MONTH);
        int startH = startC.get(Calendar.HOUR_OF_DAY);
        int startF = startC.get(Calendar.MINUTE);
        int startS = startC.get(Calendar.SECOND);

        int tagY = tagC.get(Calendar.YEAR);
        int tagM = tagC.get(Calendar.MONTH) + 1;
        int tagD = tagC.get(Calendar.DAY_OF_MONTH);
        int tagH = tagC.get(Calendar.HOUR_OF_DAY);
        int tagF = tagC.get(Calendar.MINUTE);
        int tagS = tagC.get(Calendar.SECOND);

        int dS = tagS - startS;
        if (dS < 0) {
            tagF--;
            dS += 60;
        }

        int dF = tagF - startF;
        if (dF < 0) {
            tagH--;
            dF += 60;
        }

        int dH = tagH - startH;
        if (dH < 0) {
            tagD--;
            dH += 24;
        }

        int dD = tagD - startD;
        if (dD < 0) {
            tagM--;
            tagC.add(Calendar.MONTH, -1);
            dD += tagC.getActualMaximum(Calendar.DAY_OF_MONTH);
            tagC.add(Calendar.MONTH, 1);
        }

        int dM = tagM - startM;
        if (dM < 0) {
            tagY--;
            dM += tagC.getActualMaximum(Calendar.MONTH);
        }

        int dY = tagY - startY;

        return new int[]{dY, dM, dD, dH, dF, dS};
    }

}
