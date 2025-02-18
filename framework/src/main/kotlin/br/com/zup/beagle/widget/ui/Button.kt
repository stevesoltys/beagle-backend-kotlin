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

package br.com.zup.beagle.widget.ui

import br.com.zup.beagle.widget.Widget
import br.com.zup.beagle.widget.action.Action
import br.com.zup.beagle.widget.context.Bind
import br.com.zup.beagle.widget.context.constant
import br.com.zup.beagle.widget.context.constantNullable

/**
 * Define a button natively using the server driven information received through Beagle
 *
 * @param text define the button text content.
 * @param styleId reference a native style in your local styles file to be applied on this button.
 * @param onPress attribute to define action when onPress
 * @param enabled attribute to define button enabled or disabled
 *
 */
data class Button(
    val text: Bind<String>,
    val textColor: Bind<String>? = null,
    val highlightedTextColor: Bind<String>? = null,
    val textSize: Bind<Int>? = null,
    val highlightedBackgroundColor: Bind<String>? = null,
    val styleId: String? = null,
    val onPress: List<Action>? = null,
    val enabled: Bind<Boolean>? = null
) : Widget() {

    constructor(
        text: String,
        textColor: Bind<String>? = null,
        highlightedTextColor: Bind<String>? = null,
        textSize: Bind<Int>? = null,
        highlightedBackgroundColor: Bind<String>? = null,
        styleId: String? = null,
        onPress: List<Action>? = null,
        enabled: Boolean? = null
    ) : this(
        constant(text),
        textColor,
        highlightedTextColor,
        textSize,
        highlightedBackgroundColor,
        styleId,
        onPress,
        constantNullable(enabled)
    )
}