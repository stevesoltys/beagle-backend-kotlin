package br.com.zup.beagle.widget.action

import br.com.zup.beagle.analytics.ActionAnalyticsConfig
import br.com.zup.beagle.widget.context.Bind

/**
 * Sign the user in via Firebase authentication.
 *
 * @author Steve Soltys
 */
data class FirebaseSignIn(
    val type: FirebaseSignInType,
    val email: Bind<String>? = null,
    val password: Bind<String>? = null,
    val onSuccess: List<Action>? = null,
    val onError: List<Action>? = null,
    val onFinish: List<Action>? = null,
    override var analytics: ActionAnalyticsConfig? = null
) : AnalyticsAction

enum class FirebaseSignInType {
    EMAIL_PASSWORD, APPLE, GOOGLE
}