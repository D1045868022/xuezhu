package com.zr.meiju;

/**
 * Created by chenshuai on 2019/8/18.
 */
public enum OpeningBankEnum {
    GONGSHANG("工商银行",0),youzheng("邮政银行",1);

    private final String statusName;
    private final Integer statusValue;

    private OpeningBankEnum(String statusName, Integer statusValue)
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
        for (OpeningBankEnum c : OpeningBankEnum.values()) {
            if (c.getStatusValue() == statusValue) {
                return c.statusName;
            }
        }
        return null;
    }
    // 通过名称取值
    public static Integer getValue(String statusName) {
        for (OpeningBankEnum c : OpeningBankEnum.values()) {
            if (c.getStatusName().equals(statusName)) {
                return c.getStatusValue();
            }
        }
        return null;
    }
}
