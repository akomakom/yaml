/*
 * Copyright (C) 2013 Christian Autermann
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.github.autermann.snakeyaml.api.nodes;

import java.io.OutputStream;
import java.io.Writer;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

import org.joda.time.DateTime;
import org.yaml.snakeyaml.DumperOptions;

import com.github.autermann.snakeyaml.api.Yaml;
import com.github.autermann.snakeyaml.api.YamlNode;

/**
 * TODO JavaDoc
 *
 * @author Christian Autermann <autermann@uni-muenster.de>
 */
public abstract class AbstractYamlNode implements YamlNode {

    @Override
    public YamlMappingNode asMapping() {
        return null;
    }

    @Override
    public YamlOrderedMappingNode asOrderedMapping() {
        return null;
    }

    @Override
    public YamlPairsNode asPairs() {
        return null;
    }

    @Override
    public YamlSequenceNode asSequence() {
        return null;
    }

    @Override
    public YamlSetNode asSet() {
        return null;
    }

    @Override
    public boolean exists() {
        return true;
    }

    @Override
    public boolean isContainer() {
        return false;
    }

    @Override
    public boolean isMapping() {
        return false;
    }

    @Override
    public boolean isOrderedMapping() {
        return false;
    }

    @Override
    public boolean isPairs() {
        return false;
    }

    @Override
    public boolean isSequence() {
        return false;
    }

    @Override
    public boolean isSet() {
        return false;
    }

    @Override
    public boolean isScalar() {
        return false;
    }

    @Override
    public boolean isBinary() {
        return false;
    }

    @Override
    public boolean isBoolean() {
        return false;
    }

    @Override
    public boolean isNull() {
        return false;
    }

    @Override
    public boolean isNumber() {
        return false;
    }

    @Override
    public boolean isString() {
        return false;
    }

    @Override
    public final BigDecimal asBigDecimalValue() {
        return asBigDecimalValue(BigDecimal.ZERO);
    }

    @Override
    public BigDecimal asBigDecimalValue(BigDecimal defaultValue) {
        return defaultValue;
    }

    @Override
    public BigDecimal bigDecimalValue() {
        return null;
    }

    @Override
    public final BigInteger asBigIntegerValue() {
        return asBigIntegerValue(BigInteger.ZERO);
    }

    @Override
    public BigInteger asBigIntegerValue(BigInteger defaultValue) {
        return defaultValue;
    }

    @Override
    public BigInteger bigIntegerValue() {
        return null;
    }

    @Override
    public final boolean asBooleanValue() {
        return asBooleanValue(false);
    }

    @Override
    public boolean asBooleanValue(boolean defaultValue) {
        return defaultValue;
    }

    @Override
    public boolean booleanValue() {
        return false;
    }

    @Override
    public final byte asByteValue() {
        return asByteValue((byte) 0);
    }

    @Override
    public byte asByteValue(byte defaultValue) {
        return defaultValue;
    }

    @Override
    public byte byteValue() {
        return 0;
    }

    @Override
    public final byte[] asBinaryValue() {
        return asBinaryValue(null);
    }

    @Override
    public byte[] asBinaryValue(byte[] defaultValue) {
        return defaultValue;
    }

    @Override
    public byte[] binaryValue() {
        return null;
    }

    @Override
    public final double asDoubleValue() {
        return asDoubleValue(0.0d);
    }

    @Override
    public double asDoubleValue(double defaultValue) {
        return defaultValue;
    }

    @Override
    public double doubleValue() {
        return 0.0d;
    }

    @Override
    public final float asFloatValue() {
        return asFloatValue(0.0f);
    }

    @Override
    public float asFloatValue(float defaultValue) {
        return defaultValue;
    }

    @Override
    public float floatValue() {
        return 0.0f;
    }

    @Override
    public final int asIntValue() {
        return asIntValue(0);
    }

    @Override
    public int asIntValue(int defaultValue) {
        return defaultValue;
    }

    @Override
    public int intValue() {
        return 0;
    }

    @Override
    public final long asLongValue() {
        return asLongValue(0l);
    }

    @Override
    public long asLongValue(long defaultValue) {
        return defaultValue;
    }

    @Override
    public long longValue() {
        return 0l;
    }

    @Override
    public final Number asNumberValue() {
        return asNumberValue(null);
    }

    @Override
    public Number asNumberValue(Number defaultValue) {
        return defaultValue;
    }

    @Override
    public Number numberValue() {
        return null;
    }

    @Override
    public final short asShortValue() {
        return asShortValue((short) 0);
    }

    @Override
    public short asShortValue(short defaultValue) {
        return defaultValue;
    }

    @Override
    public short shortValue() {
        return 0;
    }

    @Override
    public final String asTextValue() {
        return asTextValue("");
    }

    @Override
    public String asTextValue(String defaultValue) {
        return defaultValue;
    }

    @Override
    public String textValue() {
        return null;
    }

    @Override
    public abstract boolean equals(Object o);

    @Override
    public abstract int hashCode();

    @Override
    public abstract String toString();

    @Override
    public final DateTime asDateTimeValue() {
        return asDateTimeValue(null);
    }

    @Override
    public DateTime asDateTimeValue(DateTime defaultValue) {
        return defaultValue;
    }

    @Override
    public DateTime dateTimeValue() {
        return null;
    }

    @Override
    public final Date asDateValue() {
        return asDateValue(null);
    }

    @Override
    public Date asDateValue(Date defaultValue) {
        return defaultValue;
    }

    @Override
    public Date dateValue() {
        return null;
    }

    @Override
    public String dump() {
        return new Yaml().dump(this);
    }

    @Override
    public void dump(Writer output) {
        new Yaml().dump(this, output);
    }

    @Override
    public void dump(OutputStream output) {
        new Yaml().dump(this, output);
    }

    @Override
    public String dump(DumperOptions options) {
        return new Yaml(options).dump(this);
    }

    @Override
    public void dump(Writer output, DumperOptions options) {
        new Yaml(options).dump(this, output);
    }

    @Override
    public void dump(OutputStream output, DumperOptions options) {
        new Yaml(options).dump(this, output);
    }

    @Override
    public String dump(Yaml yaml) {
        return yaml.dump(this);
    }

    @Override
    public void dump(Writer output, Yaml yaml) {
        yaml.dump(this, output);
    }

    @Override
    public void dump(OutputStream output, Yaml yaml) {
        yaml.dump(this, output);
    }

}
