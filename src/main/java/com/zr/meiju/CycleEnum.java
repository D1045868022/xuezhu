package com.zr.meiju;

/**
 * Created by chenshuai on 2019/8/18.
 */
public enum CycleEnum {
    SAN("三个月",0),LIU("六个月",1),JIU("九个月",2),SHIER("十二个月",3);

    private final String statusName;
    private final Integer statusValue;

    private CycleEnum(String statusName, Integer statusValue)
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
        for (CycleEnum c : CycleEnum.values()) {
            if (c.getStatusValue() == statusValue) {
                return c.statusName;
            }
        }
        return null;
    }
    // 通过名称取值
    public static Integer getValue(String statusName) {
        for (CycleEnum c : CycleEnum.values()) {
            if (c.getStatusName().equals(statusName)) {
                return c.getStatusValue();
            }
        }
        return null;
    }
}
