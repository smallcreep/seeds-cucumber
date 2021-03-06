/*
 * MIT License
 *
 * Copyright (c) 2018 Ilia Rogozhin (@smallcreep) <ilia.rogozhin@gmail.com>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included
 * in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.github.smallcreep.cucumber.seeds.db.steps;

import cucumber.api.java.en.Given;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.Test;

/**
 * TestCase for {@link StpDefConnection}.
 * @since 0.1.1
 */
public class StpDefConnectionTest {

    /**
     * Check that method {@link StpDefConnection#connect(String)}.
     * has correct define cucumber annotation
     * @throws NoSuchMethodException If Method not found
     * @todo #10:15m/DEV Extract to hamcrest matcher, check value
     *  cucumber annotations, inspect all annotations.
     *  Add configure for checking timeout.
     *  Maybe more than one annotation.
     *  Bad idea use many methods in test.
     */
    @Test
    public void correctDefineAnnotationConnection()
        throws NoSuchMethodException {
        MatcherAssert.assertThat(
            "Step connection to db has correct define cucumber annotation",
            StpDefConnection.class.getDeclaredMethod(
                "connect",
                String.class
            ).getDeclaredAnnotation(Given.class).value(),
            CoreMatchers.equalTo("^The connection to the ([^,]+) database$")
        );
    }
}
