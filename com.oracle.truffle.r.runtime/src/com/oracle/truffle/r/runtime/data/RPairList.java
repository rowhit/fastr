/*
 * Copyright (c) 2014, 2015, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */
package com.oracle.truffle.r.runtime.data;

import com.oracle.truffle.api.*;
import com.oracle.truffle.r.runtime.*;
import com.oracle.truffle.r.runtime.data.model.*;
import com.oracle.truffle.r.runtime.gnur.*;

/**
 * Denotes the (rarely seen) {@code pairlist} type in R.
 *
 * {@code null} is never allowed as a value for the tag, car or cdr, only the type.
 */
public class RPairList extends RAttributeStorage implements RAttributable, RAbstractContainer {
    private Object car = RUnboundValue.instance;
    private Object cdr = RUnboundValue.instance;
    private Object tag = RUnboundValue.instance;

    /**
     * Denotes the (GnuR) typeof entity that the pairlist represents.
     */
    private SEXPTYPE type;

    /**
     * Variant used in unserialization to record the GnuR type the pairlist denotes.
     */
    RPairList(Object car, Object cdr, Object tag, SEXPTYPE type) {
        assert car != null;
        assert cdr != null;
        assert tag != null;
        this.car = car;
        this.cdr = cdr;
        this.tag = tag;
        this.type = type;
    }

    public RType getRType() {
        return RType.PairList;
    }

    @Override
    public String toString() {
        CompilerAsserts.neverPartOfCompilation();
        return String.format("type=%s, tag=%s, car=%s, cdr=%s", type, tag, toStringHelper(car), toStringHelper(cdr));
    }

    private static String toStringHelper(Object obj) {
        return obj == null ? "null" : obj.getClass().getSimpleName();
    }

    public Object car() {
        return car;
    }

    public Object cdr() {
        return cdr;
    }

    public void setCar(Object newCar) {
        assert car == RUnboundValue.instance;
        assert newCar != null;
        car = newCar;
    }

    public void setCdr(Object newCdr) {
        assert cdr == RUnboundValue.instance;
        assert newCdr != null;
        cdr = newCdr;
    }

    public Object cadr() {
        RPairList cdrpl = (RPairList) cdr;
        return cdrpl.car;
    }

    public Object cddr() {
        RPairList cdrpl = (RPairList) cdr;
        return cdrpl.cdr;
    }

    public Object caddr() {
        RPairList pl = (RPairList) cddr();
        return pl.car;
    }

    public Object getTag() {
        return tag;
    }

    public void setTag(Object newTag) {
        assert tag == RUnboundValue.instance;
        assert newTag != null;
        this.tag = newTag;
    }

    public void setType(SEXPTYPE type) {
        assert this.type == null || this.type.equals(type);
        this.type = type;
    }

    public boolean isNullTag() {
        return tag == RUnboundValue.instance || tag == RNull.instance;
    }

    public SEXPTYPE getType() {
        return type;
    }

    public boolean isComplete() {
        RInternalError.shouldNotReachHere();
        return false;
    }

    @Override
    public int getLength() {
        int result = 1;
        Object tcdr = cdr;
        while (!isNull(tcdr)) {
            if (tcdr instanceof RPairList) {
                tcdr = ((RPairList) tcdr).cdr;
            }
            result++;
        }
        return result;
    }

    @Override
    public RAbstractContainer resize(int size) {
        throw RInternalError.shouldNotReachHere();
    }

    public boolean hasDimensions() {
        return true;
    }

    public int[] getDimensions() {
        return new int[]{1};
    }

    @Override
    public void setDimensions(int[] newDimensions) {
        throw RInternalError.shouldNotReachHere();
    }

    public Class<?> getElementClass() {
        return null;
    }

    @Override
    public RVector materializeNonShared() {
        RInternalError.shouldNotReachHere();
        return null;
    }

    public RShareable materializeToShareable() {
        RInternalError.shouldNotReachHere();
        return null;
    }

    public Object getDataAtAsObject(int index) {
        RPairList pl = this;
        int i = 0;
        while (!isNull(pl) && i < index) {
            pl = (RPairList) pl.cdr;
            i++;
        }
        return pl.car;
    }

    public static boolean isNull(Object obj) {
        return obj == RNull.instance || obj == RUnboundValue.instance;
    }

    @Override
    public RStringVector getNames(RAttributeProfiles attrProfiles) {
        int l = getLength();
        String[] data = new String[l];
        RPairList pl = this;
        boolean complete = RDataFactory.COMPLETE_VECTOR;
        int i = 0;
        while (true) {
            data[i] = pl.tag.toString();
            if (pl.tag == RRuntime.STRING_NA) {
                complete = false;
            }
            if (isNull(pl.cdr)) {
                break;
            }
            pl = (RPairList) pl.cdr;
            i++;
        }
        return RDataFactory.createStringVector(data, complete);
    }

    @Override
    public void setNames(RStringVector newNames) {
        throw RInternalError.shouldNotReachHere();
    }

    @Override
    public RList getDimNames(RAttributeProfiles attrProfiles) {
        throw RInternalError.shouldNotReachHere();
    }

    @Override
    public void setDimNames(RList newDimNames) {
        throw RInternalError.shouldNotReachHere();
    }

    @Override
    public Object getRowNames(RAttributeProfiles attrProfiles) {
        throw RInternalError.shouldNotReachHere();
    }

    @Override
    public void setRowNames(RAbstractVector rowNames) {
        throw RInternalError.shouldNotReachHere();
    }

    public RStringVector getClassHierarchy() {
        return RDataFactory.createStringVector(RType.PairList.getName());
    }

    public boolean isObject(RAttributeProfiles attrProfiles) {
        return false;
    }
}
