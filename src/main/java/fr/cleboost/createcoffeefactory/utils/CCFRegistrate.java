package fr.cleboost.createcoffeefactory.utils;

import com.simibubi.create.foundation.data.CreateRegistrate;

public class CCFRegistrate extends CreateRegistrate {
    
    protected CCFRegistrate(String modid) {
        super(modid);
    }

    public static CCFRegistrate create(String modid) {
        return new CCFRegistrate(modid);
    }
}
