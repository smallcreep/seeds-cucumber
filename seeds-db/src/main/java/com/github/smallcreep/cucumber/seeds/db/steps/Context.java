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

import com.github.smallcreep.cucumber.seeds.Suit;
import com.github.smallcreep.cucumber.seeds.suit.StSimple;

/**
 * Context all tests.
 * It's a workaround, because cucumber doesn't OOP.
 * @since 0.1.1
 * @todo #10:30m/DEV Move this class to the Core module.
 *  Because many modules maybe used it.
 *  Method {@link Context#suit()} should return the same suit every time.
 *  After add implementation of {@link Suit} need replace it.
 */
public final class Context {

    /**
     * Current Suit.
     */
    private static final Suit CURRENT_SUIT = new StSimple();

    /**
     * Ctor.
     */
    private Context() {
        // Nothing. This is utility class.
    }

    /**
     * Get current CURRENT_SUIT.
     * @return Current CURRENT_SUIT
     * @todo #10:45m/DEV Need remove using public static method.
     *  But I don't know how fixed it. This mistake in cucumber.
     *  If not resolved this problem need remove this comment
     *  and add doc why we use it.
     */
    @SuppressWarnings("PMD.ProhibitPublicStaticMethods")
    public static Suit suit() {
        return Context.CURRENT_SUIT;
    }

}
