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
package com.github.autermann.snakeyaml.api.nodes;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.yaml.snakeyaml.nodes.Tag;

import com.github.autermann.snakeyaml.api.ReturningYamlNodeVisitor;
import com.github.autermann.snakeyaml.api.YamlNodeVisitor;
import com.google.common.base.Preconditions;

public class YamlDecimalNode extends AbstractYamlNumberNode {

    private final BigDecimal value;

    public YamlDecimalNode(BigDecimal value) {
        this.value = Preconditions.checkNotNull(value);
    }

    @Override
    public BigDecimal numberValue() {
        return this.value;
    }

    @Override
    public Tag tag() {
        return Tag.FLOAT;
    }

    @Override
    public boolean isDecimal() {
        return true;
    }

    @Override
    public BigDecimal bigDecimalValue() {
        return numberValue();
    }

    @Override
    public BigInteger bigIntegerValue() {
        return numberValue().toBigInteger();
    }

    @Override
    public void accept(YamlNodeVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public <T> T accept(ReturningYamlNodeVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
