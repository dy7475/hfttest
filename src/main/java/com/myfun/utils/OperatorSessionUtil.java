package com.myfun.utils;

import java.util.Date;

public class OperatorSessionUtil {

    public static Integer isSuperUser(Integer superUser, Date superEnd) {
        try {
            if (superEnd == null) {
                superUser = 0;
            } else if ("1".equals(superUser)) {
                Date nowDate = DateTimeHelper.getSystemDate();
                if (DateTimeHelper.compareTwoDate(nowDate, superEnd) < 0){
                    superUser = 0;
                }
            }
            return superUser;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
