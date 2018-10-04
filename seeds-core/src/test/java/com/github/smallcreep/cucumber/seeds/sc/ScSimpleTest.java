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

package com.github.smallcreep.cucumber.seeds.sc;

import com.github.smallcreep.cucumber.seeds.Scenario;
import java.util.HashMap;
import javax.management.openmbean.KeyAlreadyExistsException;
import org.cactoos.map.MapEntry;
import org.cactoos.map.MapOf;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.Test;

/**
 * Test Case for {@link ScSimple}.
 */
public final class ScSimpleTest {

    /**
     * Check that value by key returned.
     */
    @Test
    public void checkValueByKey() {
        final Object expected = new Object();
        MatcherAssert.assertThat(
            new ScSimple(
                new MapOf<String, Object>(
                    new MapEntry<>(
                        "key1",
                        expected
                    )
                )
            ).value("key1"),
            CoreMatchers.equalTo(expected)
        );
    }

    /**
     * Check adding new value works.
     */
    @Test
    public void checkAddingNewValue() {
        final HashMap<String, Object> values = new HashMap<>();
        final Scenario scenario = new ScSimple(values);
        final Object expected = new Object();
        scenario.add("key1", expected);
        MatcherAssert.assertThat(
            values.get("key1"),
            CoreMatchers.equalTo(expected)
        );
    }

    /**
     * Check adding existing key threw exception.
     */
    @Test(expected = KeyAlreadyExistsException.class)
    public void checkAddingExistingKey() {
        new ScSimple(
            new MapOf<String, Object>(
                new MapEntry<>(
                    "key1",
                    "first"
                )
            )
        ).add("key1", "second");
    }
}
