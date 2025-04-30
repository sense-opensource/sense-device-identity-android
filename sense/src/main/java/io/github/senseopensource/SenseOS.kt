package io.github.senseopensource

import android.app.Activity
import io.github.senseopensource.core.getDetails
import io.github.senseopensource.core.getSenseId
import io.github.senseopensource.utils.Location
import io.github.senseopensource.utils.PermissionManager
import org.json.JSONObject


class SenseOS private constructor(val activity: Activity) {
    private var initData: SenseOSConfig? = null
    companion object {
        private var instance: SenseOS? = null
        fun initSDK(activity: Activity, initData: SenseOSConfig) {
            if (instance == null) {
                instance = SenseOS(activity)
            }
            instance?.apply {
                this.initData = initData
                if (initData.allowGeoLocation == true) {
                    if (PermissionManager().checkLocationPermission(activity)) {
                        Location(activity).getCurrentLocation()
                    }
                }
            }
        }

        fun getSenseDetails(listener: SenseOSListener) {
            val sdk = instance
            val deviceDetails = sdk?.let { getDetails(it.activity) }
            val idDetails = sdk?.let { getSenseId(it.activity) }

            val senseId = Hashing().hashSenseId(idDetails.toString().encodeToByteArray())
            val parameters = JSONObject(
                mapOf(
                    "device_details" to deviceDetails,
                    "sense_id" to senseId
                )
            )
            listener.onSuccess(parameters.toString())
        }
    }

    interface SenseOSListener {
        fun onSuccess(data: String)
        fun onFailure(message: String)
    }
}
