package com.family.prisons.prisonsindex.entity;

import com.chad.library.adapter.base.entity.MultiItemEntity;

/**
 * Created by ThinkPad on 2018/6/13.
 */

public class EntityRegister implements MultiItemEntity {
    public static final int TYPE_ONE = 1;
    public static final int TYPE_TWO = 2;
    public static final int TYPE_THREE = 3;
    public static final int TYPE_FOUR = 4;
    public static final int TYPE_FIVE = 5;
    public static final int TYPE_SIX = 6;
    public static final int TYPE_SEVEN = 7;
    public static final int TYPE_EIGHT = 8;
    public static final int TYPE_NINE = 9;

    //省份
    public String province;
    //监狱
    public String prison;
    //监区
    public String prisonArea;
    //安装位置
    public String  position;

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public void setPrison(String prison) {
        this.prison = prison;
    }

    public void setPrisonArea(String prisonArea) {
        this.prisonArea = prisonArea;
    }

    public String getProvince() {
        return province;
    }

    public String getPrison() {
        return prison;
    }

    public String getPrisonArea() {
        return prisonArea;
    }

    public int itemType;

    public void setItemType(int itemType) {
        this.itemType = itemType;
    }

    @Override
    public int getItemType() {
        return itemType;
    }
}
