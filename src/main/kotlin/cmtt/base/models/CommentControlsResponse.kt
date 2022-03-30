package cmtt.base.models

import kotlinx.serialization.json.JsonNames

/**
 *
 *
 * @param result
 * @param message
 */

data class CommentControlsResponse(

    @JsonNames("result")
    val result: EtcControls? = null,

    @JsonNames("message")
    val message: String? = null

)

