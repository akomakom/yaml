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
package com.github.autermann.yaml.nodes;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.yaml.snakeyaml.nodes.Tag;

import com.github.autermann.yaml.ReturningYamlNodeVisitor;
import com.github.autermann.yaml.YamlNodeVisitor;

/**
 * A {@link com.github.autermann.yaml.YamlNode} for {@code boolean} values.
 *
 * @author Christian Autermann
 */
public abstract class YamlBooleanNode extends AbstractYamlScalarNode {
    /**
     * Singleton for {@code true}.
     */
    private static final YamlBooleanNode TRUE = new TrueNode();
    /**
     * Singleton for {@code false}.
     */
    private static final YamlBooleanNode FALSE = new FalseNode();

    @Override
    public int hashCode() {
        return Boolean.valueOf(booleanValue()).hashCode();
    }

    @Override
    public boolean equals(Object o) {
        return o == this;
    }

    @Override
    public Tag tag() {
        return Tag.BOOL;
    }

    @Override
    public void accept(YamlNodeVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public <T> T accept(ReturningYamlNodeVisitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public Boolean value() {
        return booleanValue();
    }

    @Override
    public abstract boolean booleanValue();

    @Override
    public abstract Number asNumberValue(Number defaultValue);

    @Override
    public abstract BigDecimal asBigDecimalValue(BigDecimal defaultValue);

    @Override
    public abstract double asDoubleValue(double defaultValue);

    @Override
    public abstract float asFloatValue(float defaultValue);

    @Override
    public abstract BigInteger asBigIntegerValue(BigInteger defaultValue);

    @Override
    public abstract long asLongValue(long defaultValue);

    @Override
    public abstract int asIntValue(int defaultValue);

    @Override
    public abstract short asShortValue(short defaultValue);

    @Override
    public abstract byte asByteValue(byte defaultValue);

    @Override
    public abstract String asTextValue(String defaultValue);

    @Override
    public abstract boolean asBooleanValue(boolean defaultValue);

    @Override
    public boolean isBoolean() {
        return true;
    }

    /**
     * Gets the a instance of {@link YamlBooleanNode} for the supplied
     * {@code boolean}.
     *
     * @param value the value
     *
     * @return the {@link YamlBooleanNode}
     */
    public static YamlBooleanNode of(boolean value) {
        return value ? TRUE : FALSE;
    }

    /**
     * Implementation for {@code true}.
     */
    private static final class TrueNode extends YamlBooleanNode {

        /**
         * Private singleton constructor.
         */
        private TrueNode() {
        }

        @Override
        public boolean booleanValue() {
            return true;
        }

        @Override
        public Number asNumberValue(Number defaultValue) {
            return 1;
        }

        @Override
        public BigDecimal asBigDecimalValue(BigDecimal defaultValue) {
            return BigDecimal.ONE;
        }

        @Override
        public double asDoubleValue(double defaultValue) {
            return 1.0d;
        }

        @Override
        public float asFloatValue(float defaultValue) {
            return 1.0f;
        }

        @Override
        public BigInteger asBigIntegerValue(BigInteger defaultValue) {
            return BigInteger.ONE;
        }

        @Override
        public long asLongValue(long defaultValue) {
            return 1L;
        }

        @Override
        public int asIntValue(int defaultValue) {
            return 1;
        }

        @Override
        public short asShortValue(short defaultValue) {
            return (short) 1;
        }

        @Override
        public byte asByteValue(byte defaultValue) {
            return (byte) 1;
        }

        @Override
        public String asTextValue(String defaultValue) {
            return "true";
        }

        @Override
        public boolean asBooleanValue(boolean defaultValue) {
            return true;
        }
    }

    /**
     * Implementation for {@code false}.
     */
    private static final class FalseNode extends YamlBooleanNode {
        /**
         * Private singleton constructor.
         */
        private FalseNode() {
        }

        @Override
        public boolean booleanValue() {
            return false;
        }

        @Override
        public Number asNumberValue(Number defaultValue) {
            return 0;
        }

        @Override
        public BigDecimal asBigDecimalValue(BigDecimal defaultValue) {
            return BigDecimal.ZERO;
        }

        @Override
        public double asDoubleValue(double defaultValue) {
            return 0.0d;
        }

        @Override
        public float asFloatValue(float defaultValue) {
            return 0.0f;
        }

        @Override
        public BigInteger asBigIntegerValue(BigInteger defaultValue) {
            return BigInteger.ZERO;
        }

        @Override
        public long asLongValue(long defaultValue) {
            return 0L;
        }

        @Override
        public int asIntValue(int defaultValue) {
            return 0;
        }

        @Override
        public short asShortValue(short defaultValue) {
            return (short) 0;
        }

        @Override
        public byte asByteValue(byte defaultValue) {
            return (byte) 0;
        }

        @Override
        public String asTextValue(String defaultValue) {
            return "false";
        }

        @Override
        public boolean asBooleanValue(boolean defaultValue) {
            return false;
        }
    }
}
