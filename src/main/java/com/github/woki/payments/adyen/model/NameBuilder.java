/*
 * Copyright 2015 Willian Oki
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */
package com.github.woki.payments.adyen.model;

/**
 * @author Willian Oki &lt;willian.oki@gmail.com&gt;
 */
public final class NameBuilder {
    private NameBuilder() {
        // utility
    }

    public static ILastName first(String first) {
        return new Builder(first);
    }

    public interface ILastName {
        IBuilder last(String last);
    }

    public interface IBuilder {
        IBuilder gender(GenderType gender);
        IBuilder infix(String infix);
        Name build();
    }

    private static final class Builder implements IBuilder, ILastName {
        private Name name;

        Builder(String first) {
            name = new Name();
            name.setFirstName(first);
        }

        @Override
        public Name build() {
            return name;
        }

        @Override
        public IBuilder last(String last) {
            name.setLastName(last);
            return this;
        }

        @Override
        public IBuilder gender(GenderType gender) {
            name.setGender(gender);
            return this;
        }

        @Override
        public IBuilder infix(String infix) {
            name.setInfix(infix);
            return this;
        }
    }
}
