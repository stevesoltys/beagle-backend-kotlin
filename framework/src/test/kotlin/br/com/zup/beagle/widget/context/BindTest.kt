/*
 * Copyright 2020 ZUP IT SERVICOS EM TECNOLOGIA E INOVACAO SA
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
 */

package br.com.zup.beagle.widget.context

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Given a Bind")
internal class BindTest {

    @DisplayName("When call static function expression")
    @Nested
    inner class ExpressionTest {
        @Test
        @DisplayName("Then should return a bind")
        fun testBindStaticFunctionExpression() {
            // Given
            val expression = "@{test}"

            // When
            val result = Bind.expression<String>(expression)

            // Then
            val actual = Bind.Expression<String>(expression)
            assertEquals(actual, result)
        }
    }

    @DisplayName("When call static function value")
    @Nested
    inner class ValueTest {
        @Test
        @DisplayName("Then should return a bind")
        fun testBindStaticFunctionValue() {
            // Given
            val value = "@{test}"

            // When
            val result = Bind.constant(value)

            // Then
            val actual = Bind.Value(value)
            assertEquals(actual, result)
        }
    }

    @DisplayName("When call static function value nullable")
    @Nested
    inner class ValueNullableTest {
        @Test
        @DisplayName("Then should return a bind")
        fun testBindStaticFunctionValueNullable() {
            // Given
            val value = null

            // When
            val result = Bind.constantNullable(value)

            // Then
            assertEquals(null, result)
        }
    }
}