package com.pioneers.serviceV5.util.interfacesegregation;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Wife implements WifeDuties {

    @Override
    public void careHusband() {
        log.trace("Mwaaa mwaaa mwaaa mwaaa mwaaa");
    }

    @Override
    public void danceToHusband() {
        log.trace("4ek 4ek 4ek 4ek 4ek 4ek 4ek 4ek 4ek 4ek 4ek 4ek 4ek 4ek 4ek 4ek 4ek 4ek 4ek 4ek 4ek 4ek 4ek 4ek");
    }
}
