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
package com.github.autermann.yaml;

import com.github.autermann.yaml.nodes.YamlBinaryNode;
import com.github.autermann.yaml.nodes.YamlBooleanNode;
import com.github.autermann.yaml.nodes.YamlDecimalNode;
import com.github.autermann.yaml.nodes.YamlIntegralNode;
import com.github.autermann.yaml.nodes.YamlMapNode;
import com.github.autermann.yaml.nodes.YamlMappingNode;
import com.github.autermann.yaml.nodes.YamlNullNode;
import com.github.autermann.yaml.nodes.YamlOrderedMapNode;
import com.github.autermann.yaml.nodes.YamlPairsNode;
import com.github.autermann.yaml.nodes.YamlScalarNode;
import com.github.autermann.yaml.nodes.YamlSeqNode;
import com.github.autermann.yaml.nodes.YamlSequenceNode;
import com.github.autermann.yaml.nodes.YamlSetNode;
import com.github.autermann.yaml.nodes.YamlTextNode;
import com.github.autermann.yaml.nodes.YamlTimeNode;

/**
 * Simple {@link ReturningYamlNodeVisitor} implementation to allow smaller
 * implementations. Per default implementations will return null and
 * delegate to one of
 * <ul>
 * <li>{@link #visitMapping(YamlMappingNode)}</li>
 * <li>{@link #visitScalar(YamlScalarNode)}</li>
 * <li>{@link #visitSequence(YamlSequenceNode)}</li>
 * </ul>
 *
 * @param <T> the returned type
 */
public interface SimpleReturningYamlNodeVisitor<T>
        extends ReturningYamlNodeVisitor<T> {

    @Override
    default T visit(YamlMapNode node) {
        return visitMapping(node);
    }

    @Override
    default T visit(YamlOrderedMapNode node) {
        return visitMapping(node);
    }

    @Override
    default T visit(YamlPairsNode node) {
        return visitMapping(node);
    }

    @Override
    default T visit(YamlSeqNode node) {
        return visitSequence(node);
    }

    @Override
    default T visit(YamlSetNode node) {
        return visitSequence(node);
    }

    @Override
    default T visit(YamlBinaryNode node) {
        return visitScalar(node);
    }

    @Override
    default T visit(YamlBooleanNode node) {
        return visitScalar(node);
    }

    @Override
    default T visit(YamlDecimalNode node) {
        return visitScalar(node);
    }

    @Override
    default T visit(YamlIntegralNode node) {
        return visitScalar(node);
    }

    @Override
    default T visit(YamlNullNode node) {
        return visitScalar(node);
    }

    @Override
    default T visit(YamlTextNode node) {
        return visitScalar(node);
    }

    @Override
    default T visit(YamlTimeNode node) {
        return visitScalar(node);
    }

    /**
     * Visit any mapping node.
     *
     * @param node the node to visit
     *
     * @return the returned value
     */
    default T visitMapping(YamlMappingNode<?> node) {
        return null;
    }

    /**
     * Visit any sequence node.
     *
     * @param node the node to visit
     *
     * @return the returned value
     */
    default T visitSequence(YamlSequenceNode<?> node) {
        return null;
    }

    /**
     * Visit any scalar node.
     *
     * @param node the node to visit
     *
     * @return the returned value
     */
    default T visitScalar(YamlScalarNode node) {
        return null;
    }

}
