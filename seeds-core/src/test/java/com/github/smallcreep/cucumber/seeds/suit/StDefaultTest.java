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

package com.github.smallcreep.cucumber.seeds.suit;

import com.github.smallcreep.cucumber.seeds.context.CxSimple;
import org.cactoos.map.MapOf;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.Test;

/**
 * Test Case for {@link StDefault}.
 * @since 0.1.1
 */
public class StDefaultTest {

    /**
     * Check scenario return from origin.
     */
    @Test
    public void checkScenarioTheSameOrigin() {
        MatcherAssert.assertThat(
            new StDefault(
                StSmart.instance()
            ).scenario(),
            CoreMatchers.equalTo(
                StSmart.instance().scenario()
            )
        );
    }

    /**
     * Check System Properties overridden properties from file.
     */
    @Test
    public void checkSystemPropertiesOverriddenInContext() {
        final String value = "overridden";
        final String key = "test.prop";
        System.getProperties().put(key, value);
        MatcherAssert.assertThat(
            new StDefault(
                new StSmart(
                    new CxSimple(
                        new MapOf<String, Object>()
                    )
                )
            ).context().value(key),
            CoreMatchers.equalTo(value)
        );
    }
}
