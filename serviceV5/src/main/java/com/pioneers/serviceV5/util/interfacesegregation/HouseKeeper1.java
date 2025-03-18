package com.pioneers.serviceV5.util.interfacesegregation;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HouseKeeper1 implements KitchenDuties, ClothesDuties, ChildrenCare {
    @Override
    public void makeBreakfast() {
        log.info("Finished Breakfast!!");
    }

    @Override
    public void makeLunch() {
        log.info("Finished Lunch!!");
    }

    @Override
    public void makeDinner() {
        log.info("Finished Dinner!!");
    }

    @Override
    public void washDishes() {
        log.info("Finished Dishes!!");
    }

    @Override
    public void dryDishes() {
        log.info("Finished Dishes!!");
    }

    @Override
    public void washClothes() {
        log.info("Finished washing Clothes!!");
    }

    @Override
    public void dryClothes() {
        log.info("Finished drying Clothes!!");
    }

    @Override
    public void feedChildren() {
        log.debug("Feeding children...");
        log.info("Done feeding children!!");
    }

    @Override
    public void careChildren() {
        log.debug("Care children...");
        log.info("Done care children!!");
    }
}
