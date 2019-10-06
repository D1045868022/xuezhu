package com.zr.meiju;

/**
 * Created by chenshuai on 2019/8/18.
 */
public enum EducationEnum {
    DAZHAUNG("大专",0),BENKE("本科",1),YANJIUSHENG("研究生",2);

    private final String statusName;
    private final Integer statusValue;

    private EducationEnum(String statusName, Integer statusValue)
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
        for (EducationEnum c : EducationEnum.values()) {
            if (c.getStatusValue() == statusValue) {
                return c.statusName;
            }
        }
        return null;
    }
    // 通过名称取值
    public static Integer getValue(String statusName) {
        for (EducationEnum c : EducationEnum.values()) {
            if (c.getStatusName().equals(statusName)) {
                return c.getStatusValue();
            }
        }
        return null;
    }
}
