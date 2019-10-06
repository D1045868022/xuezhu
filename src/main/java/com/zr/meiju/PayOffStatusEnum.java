package com.zr.meiju;

/**
 * Created by chenshuai on 2019/8/18.
 */
public enum PayOffStatusEnum {
    ZHENGCHANG("正常",0),JIGOUQUEREN("机构确认",1);

    private final String statusName;
    private final Integer statusValue;

    private PayOffStatusEnum(String statusName, Integer statusValue)
    {
        this.statusName = statusName;
        this.statusValue = statusValue;
    }

    public String getStatusName() {
        return statusName;
    }

    public Integer getStatusValue() {
        return statusValue;
    }


    // 通过值取名称
    public static String getName(int statusValue) {
        for (PayOffStatusEnum c : PayOffStatusEnum.values()) {
            if (c.getStatusValue() == statusValue) {
                return c.statusName;
            }
        }
        return null;
    }
    // 通过名称取值
    public static Integer getValue(String statusName) {
        for (PayOffStatusEnum c : PayOffStatusEnum.values()) {
            if (c.getStatusName().equals(statusName)) {
                return c.getStatusValue();
            }
        }
        return null;
    }
}
