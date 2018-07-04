package com.family.prisons.prisonsindex.entity.impl;

import com.chad.library.adapter.base.entity.MultiItemEntity;

public class EntityUtlisWindow implements MultiItemEntity {
    public static final int TYPE_ONE = 1;
    public static final int TYPE_TWO = 2;
    public static final int TYPE_THREE = 3;
    public static final int TYPE_FOUR = 4;
    public static final int TYPE_FIVE = 5;
    public static final int TYPE_SIX = 6;
    public static final int TYPE_SEVEN = 7;
    public static final int TYPE_EIGHT = 8;
    public static final int TYPE_NINE = 9;

    private String prisonName;
    private String prisonCode;


    public void setPrisonCode(String prisonCode) {
        this.prisonCode = prisonCode;
    }

    public String getPrisonCode() {
        return prisonCode;
    }

    public int itemType;
    public String getPrisonName() {
        return prisonName;
    }

    public void setPrisonName(String prisonName) {
        this.prisonName = prisonName;
    }

    public void setItemType(int itemType) {
        this.itemType = itemType;
    }

    @Override
    public int getItemType() {
        return itemType;
    }
}
