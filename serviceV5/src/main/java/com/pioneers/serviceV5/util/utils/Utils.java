package com.pioneers.serviceV5.util.utils;

import lombok.experimental.UtilityClass;

import java.util.UUID;

@UtilityClass
public class Utils {

    public UUID createRandomId() {
        return UUID.randomUUID();
    }
}
