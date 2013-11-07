/*
 * Copyright 2013 Christian Autermann
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
package com.github.autermann.snakeyaml.api;

import com.github.autermann.snakeyaml.api.construct.YamlNodeConstructor;
import static com.google.common.base.Preconditions.checkNotNull;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.Iterator;

import org.yaml.snakeyaml.DumperOptions;

import com.google.common.base.Charsets;
import com.google.common.collect.UnmodifiableIterator;

public class Yaml {
    private final org.yaml.snakeyaml.Yaml delegate;

    /**
     * Creates a new {@link Yaml} with default {@link DumperOptions} and
     * {@link YamlNodeFactory}.
     */
    public Yaml() {
        this(new DumperOptions(), YamlNodeFactory.createDefault());
    }

    /**
     * Creates a new {@link Yaml} with default {@link DumperOptions} and the
     * supplied {@link YamlNodeFactory}.
     *
     * @param nodeFactory the node factory
     */
    public Yaml(YamlNodeFactory nodeFactory) {
        this(new DumperOptions(), nodeFactory);
    }

    /**
     * Creates a new {@link Yaml} using a the default {@link YamlNodeFactory}
     * and the supplied {@link DumperOptions}.
     *
     * @param dumperOptions the dumper options
     */
    public Yaml(DumperOptions dumperOptions) {
        this(dumperOptions, YamlNodeFactory.createDefault());
    }

    /**
     * Creates a new {@link Yaml} using the supplied {@link YamlNodeFactory} and
     * {@link DumperOptions}.
     *
     * @param dumperOptions the dumper options
     * @param nodeFactory   the node factory
     */
    public Yaml(DumperOptions dumperOptions, YamlNodeFactory nodeFactory) {
        checkNotNull(nodeFactory);
        checkNotNull(dumperOptions);
        this.delegate = new org.yaml.snakeyaml.Yaml(
                new YamlNodeConstructor(nodeFactory, dumperOptions),
                new YamlNodeRepresenter(dumperOptions),
                dumperOptions);
    }

    public String dump(YamlNode data) {
        return getDelegate().dump(data);
    }

    public void dump(YamlNode data, Writer output) {
        getDelegate().dump(data, output);
    }

    public void dump(YamlNode data, OutputStream output) {
        getDelegate().dump(data, new OutputStreamWriter(output, Charsets.UTF_8));
    }

    public String dumpAll(Iterator<? extends YamlNode> data) {
        return getDelegate().dumpAll(data);
    }

    public void dumpAll(Iterator<? extends YamlNode> data, Writer output) {
        getDelegate().dumpAll(data, output);
    }

    public void dumpAll(Iterator<? extends YamlNode> data, OutputStream output) {
        getDelegate()
                .dumpAll(data, new OutputStreamWriter(output, Charsets.UTF_8));
    }

    public String dumpAll(Iterable<? extends YamlNode> data) {
        return dumpAll(data.iterator());
    }

    public void dumpAll(Iterable<? extends YamlNode> data, Writer output) {
        dumpAll(data.iterator(), output);
    }

    public void dumpAll(Iterable<? extends YamlNode> data, OutputStream output) {
        dumpAll(data.iterator(), output);
    }

    public YamlNode load(String yaml) {
        return (YamlNode) getDelegate().load(yaml);
    }

    public YamlNode load(InputStream io) {
        return (YamlNode) getDelegate().load(io);
    }

    public YamlNode load(Reader io) {
        return (YamlNode) getDelegate().load(io);
    }

    public Iterable<YamlNode> loadAll(Reader yaml) {
        return cast(getDelegate().loadAll(yaml));
    }

    public Iterable<YamlNode> loadAll(String yaml) {
        return cast(getDelegate().loadAll(yaml));
    }

    public Iterable<YamlNode> loadAll(InputStream yaml) {
        return cast(getDelegate().loadAll(yaml));
    }

    private Iterable<YamlNode> cast(final Iterable<Object> nodes) {
        return new Iterable<YamlNode>() {
            @Override
            public Iterator<YamlNode> iterator() {
                return new UnmodifiableIterator<YamlNode>() {
                    private final Iterator<Object> iter = nodes.iterator();

                    @Override
                    public boolean hasNext() {
                        return iter.hasNext();
                    }

                    @Override
                    public YamlNode next() {
                        return (YamlNode) iter.next();
                    }
                };
            }
        };
    }

    protected org.yaml.snakeyaml.Yaml getDelegate() {
        return delegate;
    }
}
