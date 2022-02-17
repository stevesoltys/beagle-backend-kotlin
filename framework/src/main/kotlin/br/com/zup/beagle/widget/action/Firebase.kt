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

package br.com.zup.beagle.widget.action

import br.com.zup.beagle.analytics.ActionAnalyticsConfig
import br.com.zup.beagle.widget.context.Bind

/**
 * Create a Firebase email/password account.
 */
data class FirebaseSignUp(
    val name: Bind<String>? = null,
    val email: Bind<String>? = null,
    val password: Bind<String>? = null,
    val onSuccess: List<Action>? = null,
    val onError: List<Action>? = null,
    val onFinish: List<Action>? = null,
    override var analytics: ActionAnalyticsConfig? = null
) : AnalyticsAction

/**
 * The sign in type to use for a FirebaseSignIn.
 */
enum class FirebaseSignInType {
    EMAIL_PASSWORD, APPLE, GOOGLE
}

/**
 * Sign the user in via Firebase authentication.
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

/**
 * Sign the user out from Firebase authentication.
 */
data class FirebaseSignOut(
    val onSuccess: List<Action>? = null,
    val onError: List<Action>? = null,
    val onFinish: List<Action>? = null,
    override var analytics: ActionAnalyticsConfig? = null
) : AnalyticsAction

/**
 * Fetch a user's Firebase account information.
 */
data class FirebaseFetchUserDetails(
    val onSuccess: List<Action>? = null,
    val onError: List<Action>? = null,
    val onFinish: List<Action>? = null,
    override var analytics: ActionAnalyticsConfig? = null
) : AnalyticsAction

/**
 * Send a verification email to a user.
 */
data class FirebaseSendVerificationEmail(
    val onSuccess: List<Action>? = null,
    val onError: List<Action>? = null,
    val onFinish: List<Action>? = null,
    override var analytics: ActionAnalyticsConfig? = null
) : AnalyticsAction

/**
 * Send a forgot password email to a user.
 */
data class FirebaseForgotPassword(
    val email: Bind<String>?,
    val onSuccess: List<Action>? = null,
    val onError: List<Action>? = null,
    val onFinish: List<Action>? = null,
    override var analytics: ActionAnalyticsConfig? = null
) : AnalyticsAction
