/*
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the Free
 * Software Foundation; either version 2 of the License, or (at your option)
 * any later version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License for
 * more details.
 *
 * You should have received a copy of the GNU General Public License along with
 * this program; if not, write to the Free Software Foundation, Inc., 51
 * Franklin Street, Fifth Floor, Boston, MA 02110-1301, USA.
 *
 * Copyright (c) 2014, Purdue University
 * Copyright (c) 2014, 2018, Oracle and/or its affiliates
 *
 * All rights reserved.
 */
package com.oracle.truffle.r.test.builtins;

import org.junit.Test;

import com.oracle.truffle.r.test.TestBase;

// Checkstyle: stop line length check
public class TestBuiltin_abbreviate extends TestBase {

    @Test
    public void testabbreviate1() {
        assertEval("argv <- list('text', 6, TRUE); .Internal(abbreviate(argv[[1]], argv[[2]], argv[[3]]))");
    }

    @Test
    public void testabbreviate2() {
        assertEval("argv <- list(c('Alabama', 'Alaska', 'Arizona', 'Arkansas', 'California', 'Colorado', 'Connecticut', 'Delaware', 'Florida', 'Georgia', 'Hawaii', 'Idaho', 'Illinois', 'Indiana', 'Iowa', 'Kansas', 'Kentucky', 'Louisiana', 'Maine', 'Maryland', 'Massachusetts', 'Michigan', 'Minnesota', 'Mississippi', 'Missouri', 'Montana', 'Nebraska', 'Nevada', 'New Hampshire', 'New Jersey', 'New Mexico', 'New York', 'North Carolina', 'North Dakota', 'Ohio', 'Oklahoma', 'Oregon', 'Pennsylvania', 'Rhode Island', 'South Carolina', 'South Dakota', 'Tennessee', 'Texas', 'Utah', 'Vermont', 'Virginia', 'Washington', 'West Virginia', 'Wisconsin', 'Wyoming'), 3, TRUE); .Internal(abbreviate(argv[[1]], argv[[2]], argv[[3]]))");
    }

    @Test
    public void testabbreviate3() {
        assertEval("argv <- list('glm', 6, TRUE); .Internal(abbreviate(argv[[1]], argv[[2]], argv[[3]]))");
    }

    @Test
    public void testabbreviate4() {
        assertEval("argv <- list(c('(Intercept)', 'sin(2 * pi * Time)', 'cos(2 * pi * Time)'), 6, TRUE); .Internal(abbreviate(argv[[1]], argv[[2]], argv[[3]]))");
    }

    @Test
    public void testabbreviate5() {
        assertEval("argv <- list(c('Alabama', 'Alaska', 'Arizona', 'Arkansas', 'California', 'Colorado', 'Connecticut', 'Delaware', 'Florida', 'Georgia', 'Hawaii', 'Idaho', 'Illinois', 'Indiana', 'Iowa', 'Kansas', 'Kentucky', 'Louisiana', 'Maine', 'Maryland', 'Massachusetts', 'Michigan', 'Minnesota', 'Mississippi', 'Missouri', 'Montana', 'Nebraska', 'Nevada', 'New Hampshire', 'New Jersey', 'New Mexico', 'New York', 'North Carolina', 'North Dakota', 'Ohio', 'Oklahoma', 'Oregon', 'Pennsylvania', 'Rhode Island', 'South Carolina', 'South Dakota', 'Tennessee', 'Texas', 'Utah', 'Vermont', 'Virginia', 'Washington', 'West Virginia', 'Wisconsin', 'Wyoming'), 4L, TRUE); .Internal(abbreviate(argv[[1]], argv[[2]], argv[[3]]))");
    }

    @Test
    public void testabbreviate6() {
        assertEval("argv <- list(c('Alabama', 'Alaska', 'Arizona', 'Arkansas', 'California', 'Colorado', 'Connecticut', 'Delaware', 'Florida', 'Georgia', 'Hawaii', 'Idaho', 'Illinois', 'Indiana', 'Iowa', 'Kansas', 'Kentucky', 'Louisiana', 'Maine', 'Maryland', 'Massachusetts', 'Michigan', 'Minnesota', 'Mississippi', 'Missouri', 'Montana', 'Nebraska', 'Nevada', 'New Hampshire', 'New Jersey', 'New Mexico', 'New York', 'North Carolina', 'North Dakota', 'Ohio', 'Oklahoma', 'Oregon', 'Pennsylvania', 'Rhode Island', 'South Carolina', 'South Dakota', 'Tennessee', 'Texas', 'Utah', 'Vermont', 'Virginia', 'Washington', 'West Virginia', 'Wisconsin', 'Wyoming'), 3L, TRUE); .Internal(abbreviate(argv[[1]], argv[[2]], argv[[3]]))");
    }

    @Test
    public void testabbreviate7() {
        assertEval("argv <- list(c('1_', 'Weight', 'Cylinders4', 'Cylinders5', 'Cylinders6', 'Cylinders8', 'Cylindersrotary', 'TypeLarge', 'TypeMidsize', 'TypeSmall', 'TypeSporty', 'TypeVan', 'EngineSize', 'DriveTrainFront', 'DriveTrainRear'), 4L, TRUE); .Internal(abbreviate(argv[[1]], argv[[2]], argv[[3]]))");
    }

    @Test
    public void testabbreviate8() {
        assertEval("argv <- list(c('Alabama', 'Alaska', 'Arizona', 'Arkansas', 'California', 'Colorado', 'Connecticut', 'Delaware', 'Florida', 'Georgia', 'Hawaii', 'Idaho', 'Illinois', 'Indiana', 'Iowa', 'Kansas', 'Kentucky', 'Louisiana', 'Maine', 'Maryland', 'Massachusetts', 'Michigan', 'Minnesota', 'Mississippi', 'Missouri', 'Montana', 'Nebraska', 'Nevada', 'New Hampshire', 'New Jersey', 'New Mexico', 'New York', 'North Carolina', 'North Dakota', 'Ohio', 'Oklahoma', 'Oregon', 'Pennsylvania', 'Rhode Island', 'South Carolina', 'South Dakota', 'Tennessee', 'Texas', 'Utah', 'Vermont', 'Virginia', 'Washington', 'West Virginia', 'Wisconsin', 'Wyoming'), 1L, TRUE); .Internal(abbreviate(argv[[1]], argv[[2]], argv[[3]]))");
    }

    @Test
    public void testabbreviate9() {
        assertEval("argv <- list(character(0), 4L, TRUE); .Internal(abbreviate(argv[[1]], argv[[2]], argv[[3]]))");
    }

    @Test
    public void testabbreviate10() {
        assertEval("argv <- list('filled.contour', 6, TRUE); .Internal(abbreviate(argv[[1]], argv[[2]], argv[[3]]))");
    }

    @Test
    public void testabbreviate11() {
        assertEval("argv <- list(c('Svansota', 'No. 462', 'Manchuria', 'No. 475', 'Velvet', 'Peatland', 'Glabron', 'No. 457', 'Wisconsin No. 38', 'Trebi'), 5, TRUE); .Internal(abbreviate(argv[[1]], argv[[2]], argv[[3]]))");
    }

    @Test
    public void testabbreviate12() {
        assertEval("argv <- list('dtrMatrix-class', 6, TRUE); .Internal(abbreviate(argv[[1]], argv[[2]], argv[[3]]))");
    }
}
