package br.com.zup.beagle.widget.ui

import br.com.zup.beagle.widget.Widget
import br.com.zup.beagle.widget.action.Action
import br.com.zup.beagle.widget.context.Bind
import br.com.zup.beagle.widget.context.constantNullable

/**
 * A switch button.
 *
 * @author Steve Soltys
 */
data class Switch(
    val color: Bind<String>? = null,
    val onPress: List<Action>? = null,
    val enabled: Bind<Boolean>? = null
) : Widget() {

    constructor(
        color: Bind<String>? = null,
        onPress: List<Action>? = null,
        enabled: Boolean? = null
    ) : this(
        color,
        onPress,
        constantNullable(enabled)
    )
}