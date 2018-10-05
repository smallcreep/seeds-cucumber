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

import com.github.smallcreep.cucumber.seeds.Context;
import com.github.smallcreep.cucumber.seeds.Scenario;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.Test;

/**
 * Test Case for {@link StSimple}.
 * @since 0.1.1
 */
public class StSimpleTest {

    /**
     * Check suit return context.
     */
    @Test
    public void checkContext() {
        MatcherAssert.assertThat(
            StSimple.instance().context(),
            CoreMatchers.notNullValue(Context.class)
        );
    }

    /**
     * Check suit return current scenario.
     */
    @Test
    public void checkScenario() {
        MatcherAssert.assertThat(
            StSimple.instance().scenario(),
            CoreMatchers.notNullValue(Scenario.class)
        );
    }

    /**
     * Check suit return new scenario after finish current.
     */
    @Test
    public void checkNewScenarioAfterFinish() {
        final Scenario first = StSimple.instance().scenario();
        StSimple.instance().finish();
        MatcherAssert.assertThat(
            StSimple.instance().scenario(),
            CoreMatchers.not(
                CoreMatchers.equalTo(first)
            )
        );
    }
}
