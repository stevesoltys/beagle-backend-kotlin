package br.com.zup.beagle.widget.action

import br.com.zup.beagle.analytics.ActionAnalyticsConfig
import br.com.zup.beagle.annotation.RegisterAction
import br.com.zup.beagle.widget.action.Action
import br.com.zup.beagle.widget.action.AnalyticsAction
import br.com.zup.beagle.widget.context.Bind

/**
 * Sign the user out
 *
 * @author Steve Soltys
 */
data class FirebaseSignOut(
    val onSuccess: List<Action>? = null,
    val onError: List<Action>? = null,
    val onFinish: List<Action>? = null,
    override var analytics: ActionAnalyticsConfig? = null
) : AnalyticsAction
