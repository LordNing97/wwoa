package com.xy.wwoa.approval.util;

import java.time.LocalDateTime;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created with IntelliJ IDEA.
 * Description: 审批编号生成器
 * User: leisurexi
 * Date: 2019-08-28
 * Time: 21:56
 */
public class ApprovalNumberDevice {

    private ApprovalNumberDevice() {
    }

    public static String createApprovalNumber() {
        LocalDateTime localDateTime = LocalDateTime.now();
        StringBuilder number = new StringBuilder(localDateTime.getYear() + "");
        number.append(zeroPadding(localDateTime.getMonth().getValue()));
        number.append(zeroPadding(localDateTime.getDayOfMonth()));
        number.append(zeroPadding(localDateTime.getHour()));
        number.append(zeroPadding(localDateTime.getMinute()));
        number.append(zeroPadding(localDateTime.getSecond()));
        return number.append(ThreadLocalRandom.current().nextInt(1000000)).toString();
    }

    private static String zeroPadding(int number) {
        return number < 10 ? "0" + number : "" + number;
    }

}
