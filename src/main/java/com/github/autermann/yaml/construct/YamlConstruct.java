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
package com.github.autermann.yaml.construct;

import java.util.Objects;

import org.yaml.snakeyaml.constructor.AbstractConstruct;

import com.github.autermann.yaml.YamlNodeFactory;

/**
 * {@link org.yaml.snakeyaml.constructor.Construct} to construct
 * {@link com.github.autermann.yaml.YamlNode}s using
 * {@link YamlNodeConstructor} and {@link YamlNodeFactory} delegates.
 */
public abstract class YamlConstruct extends AbstractConstruct {

    /**
     * The {@link YamlNodeFactory} to delegate to.
     */
    private final YamlNodeFactory nodeFactory;
    /**
     * The {@link YamlNodeConstructor} to delegate to.
     */
    private final YamlNodeConstructor delegate;

    /**
     * Creates a new {@link YamlConstruct} backed by the specified
     * {@link YamlNodeFactory} and {@link YamlNodeConstructor}.
     *
     * @param nodeFactory the node factory
     * @param delegate    the delegate
     */
    protected YamlConstruct(YamlNodeFactory nodeFactory,
                            YamlNodeConstructor delegate) {
        this.nodeFactory = Objects.requireNonNull(nodeFactory);
        this.delegate = Objects.requireNonNull(delegate);
    }

    /**
     * Gets the {@link YamlNodeFactory} for this construct.
     *
     * @return the node factory
     */
    public YamlNodeFactory getNodeFactory() {
        return nodeFactory;
    }

    /**
     * Gets the {@link YamlNodeConstructor} delegate of this construct.
     *
     * @return the delegate
     */
    public YamlNodeConstructor getDelegate() {
        return delegate;
    }

}
