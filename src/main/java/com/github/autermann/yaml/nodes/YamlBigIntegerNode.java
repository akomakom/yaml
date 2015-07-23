/*
 * Copyright 2013-2015 Christian Autermann
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.autermann.yaml.nodes;


import java.math.BigInteger;
import java.util.Objects;

import com.github.autermann.yaml.util.Numbers;

/**
 * A {@link com.github.autermann.yaml.YamlNode} for {@link BigInteger}s.
 *
 * @author Christian Autermann
 */
public class YamlBigIntegerNode extends YamlIntegralNode {
    /**
     * The {@link BigInteger} value.
     */
    private final BigInteger value;

    /**
     * Creates a new {@link YamlBigIntegerNode}.
     *
     * @param value the value
     */
    public YamlBigIntegerNode(BigInteger value) {
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public boolean fitsIntoLong() {
        return Numbers.fitsIntoLong(value);
    }

    @Override
    public boolean fitsIntoInt() {
        return Numbers.fitsIntoInt(value);
    }

    @Override
    public boolean fitsIntoByte() {
        return Numbers.fitsIntoByte(value);
    }

    @Override
    public boolean fitsIntoShort() {
        return Numbers.fitsIntoShort(value);
    }

    @Override
    public BigInteger bigIntegerValue() {
        return this.value;
    }

    @Override
    public BigInteger value() {
        return this.value;
    }

}
