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

import com.github.autermann.yaml.YamlNode;

/**
 * Abstract {@link YamlNode} to represent a scalar node.
 *
 * @author Christian Autermann
 */
public abstract class YamlScalarNode implements YamlNode {

    @Override
    public boolean isScalar() {
        return true;
    }

    @Override
    public String toString() {
        return asTextValue();
    }

    @Override
    public abstract String asTextValue(String defaultValue);

    /**
     * Gets the internal value of this scalar.
     *
     * @return the value
     */
    public abstract Object value();

    @Override
    public YamlScalarNode copy() {
        // subclasses are immutable
        return this;
    }

}
