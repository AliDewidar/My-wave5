package com.pioneers.serviceV2.util;

import lombok.experimental.UtilityClass;

import java.util.UUID;

@UtilityClass
public class Utils {

    public String createRandomId() {
        return UUID.randomUUID().toString();
    }
}
