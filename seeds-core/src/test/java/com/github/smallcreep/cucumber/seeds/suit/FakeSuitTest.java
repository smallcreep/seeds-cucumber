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

import com.github.smallcreep.cucumber.seeds.Scenario;
import com.github.smallcreep.cucumber.seeds.context.CxSimple;
import com.github.smallcreep.cucumber.seeds.scenario.ScSimple;
import org.cactoos.map.MapOf;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Test Case for {@link FakeSuit}.
 * @since 0.2.0
 */
public final class FakeSuitTest {

    /**
     * A rule for handling an exception.
     */
    @Rule
    public final ExpectedException exception = ExpectedException.none();

    /**
     * Check fake suit return context was the same context from constructor.
     */
    @Test
    public void checkContextTheSame() {
        final CxSimple context = new CxSimple(
            new MapOf<String, Object>()
        );
        MatcherAssert.assertThat(
            new FakeSuit(
                context,
                new ScSimple()
            ).context(),
            CoreMatchers.equalTo(context)
        );
    }

    /**
     * Check fake suit return scenario was the same scenario from constructor.
     */
    @Test
    public void checkScenarioTheSame() {
        final Scenario scenario = new ScSimple();
        MatcherAssert.assertThat(
            new FakeSuit(
                new CxSimple(
                    new MapOf<String, Object>()
                ),
                scenario
            ).scenario(),
            CoreMatchers.equalTo(scenario)
        );
    }

    /**
     * Check finish method not supported in Fake suit.
     */
    @Test
    public void checkFinishMethodNotSupported() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage(
            "#finish() is not supported"
        );
        new FakeSuit(
            new CxSimple(
                new MapOf<String, Object>()
            ),
            new ScSimple()
        ).finish();
    }

    /**
     * Check start method not supported in Fake suit.
     */
    @Test
    public void checkStartMethodNotSupported() {
        this.exception.expect(UnsupportedOperationException.class);
        this.exception.expectMessage(
            "#start() is not supported"
        );
        new FakeSuit(
            new CxSimple(
                new MapOf<String, Object>()
            ),
            new ScSimple()
        ).start();
    }
}
