package com.zr.meiju;

/**
 * Created by chenshuai on 2019/8/18.
 */
public enum LiveStatusEnum {
    BENDI("本地",0),WAIDI("外地",1);

    private final String statusName;
    private final Integer statusValue;

    private LiveStatusEnum(String statusName, Integer statusValue)
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
        for (LiveStatusEnum c : LiveStatusEnum.values()) {
            if (c.getStatusValue() == statusValue) {
                return c.statusName;
            }
        }
        return null;
    }
    // 通过名称取值
    public static Integer getValue(String statusName) {
        for (LiveStatusEnum c : LiveStatusEnum.values()) {
            if (c.getStatusName().equals(statusName)) {
                return c.getStatusValue();
            }
        }
        return null;
    }
}
