/**
 * Copyright (c) 2016 Trader Corporation.  All rights reserved.
 * Created by Dave Thomas on 2016-10-28.
 */
package com.daveanthonythomas.gsontest;

import java.security.Key;
import java.util.HashMap;

public class Blocks {

    HashMap<KeyObject, ValueObject> blocks = new HashMap<>();

    public void addBlock(KeyObject key, ValueObject value) {
        blocks.put(key, value);
    }

    public HashMap<KeyObject, ValueObject> getBlocks() {
        return blocks;
    }
}
