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

package com.github.smallcreep.cucumber.seeds.storage;

import com.github.smallcreep.cucumber.seeds.context.CxSimple;
import java.util.HashMap;
import java.util.Map;
import org.cactoos.iterable.IterableOf;
import org.cactoos.iterable.StickyIterable;
import org.cactoos.map.MapEntry;
import org.cactoos.map.MapOf;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

/**
 * Test Case for {@link StorageScenarioProperties}.
 * @since 0.2.0
 */
public final class StorageScenarioPropertiesTest {

    /**
     * StorageScenarioProperties save to context all maps value.
     */
    @Test
    public void saveContextAllMapsValue() {
        final String iid = "iid";
        final String another = "another";
        final Map<String, Object> values = new HashMap<>();
        MatcherAssert.assertThat(
            new StickyIterable<>(
                new StorageScenarioProperties(
                    new IterableOf<Map<String, String>>(
                        new MapOf<String, String>(
                            new MapEntry<>(
                                iid,
                                "1"
                            ),
                            new MapEntry<>(
                                another,
                                "2"
                            )
                        ),
                        new MapOf<String, String>(
                            new MapEntry<>(
                                iid,
                                "2"
                            ),
                            new MapEntry<>(
                                another,
                                "3"
                            )
                        )
                    ),
                    new CxSimple(values),
                    "saveContextAllMapsValue"
                )
            ),
            Matchers.allOf(
                Matchers.hasItem(
                    Matchers.hasEntry(
                        Matchers.equalTo(iid),
                        Matchers.equalTo("1")
                    )
                ),
                Matchers.hasItem(
                    Matchers.hasEntry(
                        Matchers.equalTo(iid),
                        Matchers.equalTo("2")
                    )
                ),
                Matchers.hasItem(
                    Matchers.hasEntry(
                        Matchers.equalTo(another),
                        Matchers.equalTo("2")
                    )
                ),
                Matchers.hasItem(
                    Matchers.hasEntry(
                        Matchers.equalTo(another),
                        Matchers.equalTo("3")
                    )
                )
            )
        );
        MatcherAssert.assertThat(
            values,
            Matchers.allOf(
                Matchers.hasEntry(
                    "#Storage#saveContextAllMapsValue#iid=1(another)",
                    "2"
                ),
                Matchers.hasEntry(
                    "#Storage#saveContextAllMapsValue#iid=2(another)",
                    "3"
                ),
                Matchers.hasEntry(
                    "#Storage#saveContextAllMapsValue#iid=1(iid)",
                    "1"
                ),
                Matchers.hasEntry(
                    "#Storage#saveContextAllMapsValue#iid=2(iid)",
                    "2"
                )
            )
        );
    }
}
