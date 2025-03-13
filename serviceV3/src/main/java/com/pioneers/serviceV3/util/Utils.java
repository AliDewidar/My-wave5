package com.pioneers.serviceV3.util;

import lombok.experimental.UtilityClass;

import java.util.UUID;

@UtilityClass
public class Utils {

    public UUID createRandomId() {
        return UUID.randomUUID();
    }
}
