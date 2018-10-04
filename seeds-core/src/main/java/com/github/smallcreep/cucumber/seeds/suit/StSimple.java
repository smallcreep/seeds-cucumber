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
import com.github.smallcreep.cucumber.seeds.Suit;
import com.github.smallcreep.cucumber.seeds.sc.ScSimple;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Simple Suit implementation.
 * @since 0.1.1
 * @todo #18:30m/DEV Redesign class. Suit must be a Singleton class.
 *  This class must two static {@link AtomicReference} fields:
 *  Context suit and Scenario. Scenario should be return context of scenario.
 *  Because we don't want use dependency injection.
 *  For correct using Before and After we can use order feature
 *  @see <a href="http://toolsqa.com/cucumber/execution-order-hooks/">Hooks Ordering</a>
 */
public final class StSimple implements Suit {

    /**
     * Current scenario.
     */
    private final AtomicReference<Scenario> scenario;

    /**
     * Suit context as Scenario context.
     */
    private final Scenario context;

    /**
     * Ctor.
     */
    public StSimple() {
        this(
            new ScSimple(),
            new ScSimple()
        );
    }

    /**
     * Ctor.
     * @param scenario Current Scenario
     * @param context Current Suit context as scenario context
     */
    StSimple(Scenario scenario, final Scenario context) {
        this.scenario = new AtomicReference<>(scenario);
        this.context = context;
    }

    @Override
    public Scenario scenario() {
        return this.scenario.get();
    }

    @Override
    public void finish() {
        this.scenario.lazySet(new ScSimple());
    }

    @Override
    public Object value(final String key) {
        return this.context.value(key);
    }

    @Override
    public void add(final String key, final Object value) {
        this.context.add(key, value);
    }
}
