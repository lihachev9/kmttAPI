package kmtt.util

import kmtt.models.enums.Website

internal fun Website.apiURL(version: String = "v2.1"): String = "https://api.${this.baseURL}/$version"
