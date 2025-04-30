<h1>Sense Device Identity - Android</h1>

<p style="width:100%;">
    <a href="https://github.com/sense-opensource/sense-device-identity-android/blob/main/LICENSE">
        <img width="9%" src="https://custom-icon-badges.demolab.com/github/license/denvercoder1/custom-icon-badges?logo=law">
    </a> 
    <img width="12.6%" src="https://badge-generator.vercel.app/api?icon=Github&label=Last%20Commit&status=May&color=6941C6"/> 
    <a href="https://discord.gg/hzNHTpwt">
        <img width="10%" src="https://badge-generator.vercel.app/api?icon=Discord&label=Discord&status=Live&color=6941C6"> 
    </a>
</p>

<p style="width:100%;">  
<img width="4.5%" src="https://custom-icon-badges.demolab.com/badge/Fork-orange.svg?logo=fork"> <img width="4.5%" src="https://custom-icon-badges.demolab.com/badge/Star-yellow.svg?logo=star"> <img width="6.5%" src="https://custom-icon-badges.demolab.com/badge/Commit-green.svg?logo=git-commit&logoColor=fff"> 
</p>
  

<p> Sense is a client side library that enables you to identify users by pinpointing their hardware and software characteristics. This is done by computing a token that stays consistent in spite of any manipulation.</p>

<h3>Getting started with Sense </h3>


#### Requirements

```kotlin
* Use Android 5.1 (API level 21) and above.
* Use Kotlin version 1.6.10 and above.
* Add READ_PHONE_STATE Permission in Android Manifest for deivce information(Optional)
```

Note: If the application does not have the listed permissions, the values collected using those permissions will be ignored. To provide a valid device details, we recommend employing as much permission as possible based on your use-case.

#### Step 1 - Add Dependency

Add the dependency in the app level build.gradle:

```kotlin
dependencies {
    implementation 'io.github.sense-opensource:SenseOS:0.0.1'
}
```

#### Step 2 - Import SDK

```kotlin
import io.github.sense-opensource.SenseOS
import io.github.sense-opensource.SenseOSConfig
```

#### Step 3 - Initialize SDK

Add the following line of code to initialize it with the api key you obtained from the Sense Client panel. If you don't have a api key create new one.

```kotlin
val config = SenseOSConfig(
    allowGeoLocation = true // true or false
)
SenseOS.initSDK(activity, config)
```

#### Step 4 - Get Device Details

Use the below code to get the Device Details

```kotlin
Sense.getSenseDetails(this)
```

#### Step 5 - Implement Listener

Set and Implement our listener to receive the Callback details

```kotlin
SenseOS.getSenseDetails(object : SenseOS.SenseOSListener {
    override fun onSuccess(data: String) {
        // success callback 
    }
    override fun onFailure(message: String) {
        // failure callback
    }
})
```

#### Step 6 - Location Permission (Optional)

````kotlin
You have to add this permission in AndroidManifest.xml to get Device Location Information and to get Retrieve call state, Network state, Network information, Sim datas from READ_PHONE_STATE and READ_PRIVILEGED_PHONE_STATE.

<uses-permission android:name="android.permission.ACCESS_FINE_LOCATION" />
<uses-permission android:name="android.permission.ACCESS_COARSE_LOCATION" />
<uses-permission android:name="android.permission.READ_PHONE_STATE" />
<uses-permission android:name="android.permission.READ_PRIVILEGED_PHONE_STATE"
tools:ignore="ProtectedPermissions"/>

````

#### Sample Program

Here you can find the demonstration to do the integration.

```kotlin
import io.github.sense-opensource.SenseOS
import io.github.sense-opensource.SenseOSConfig

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val config = SenseOSConfig(
             allowGeoLocation = true // true or false
        )

        //Initialize SDK
        SenseOS.initSDK(this, config)

        // Fetch device details
        getSenseDetails();
    }
    private fun getSenseDetails() {
        SenseOS.getSenseDetails(object : SenseOS.SenseOSListener {
            override fun onSuccess(data: String) {
                // Handle success callback
            }
            override fun onFailure(message: String) {
                // Handle failure callback
            }
        })
    }
}
```

<h4>Plug and play, in just 3 steps</h3>  

1️⃣ Visit the GitHub Repository</br>
2️⃣ Download or Clone the Repository. Use the GitHub interface to download the ZIP file, or run.</br>
3️⃣ Run the Installer / Setup Script. Follow the setup instructions provided below.</br>
4️⃣ Start Testing. Once installed, begin testing and validating the accuracy of the metrics you're interested in.</br>

#### With Sense, you can  

✅ Predict user intent : Identify the good from the bad visitors with precision  
✅ Create user identities : Tokenise events with a particular user and device  
✅ Custom risk signals : Developer specific scripts that perform unique functions  
✅ Protect against Identity spoofing : Prevent users from impersonation  
✅ Stop device or browser manipulation : Detect user behaviour anomalies 

### Resources 

#### MIT license : 

Sense OS is available under the <a href="https://github.com/sense-opensource/sense-device-identity-android/blob/main/LICENSE"> MIT license </a>

#### Contributors code of conduct : 

Thank you for your interest in contributing to this project! We welcome all contributions and are excited to have you join our community. Please read these <a href="https://github.com/sense-opensource/sense-device-identity-android/blob/main/code_of_conduct.md"> Code of conduct </a> to ensure a smooth collaboration.

#### Where you can get support :     
![Gmail](https://img.shields.io/badge/Gmail-D14836?logo=gmail&logoColor=white)       product@getsense.co 

Public Support:

For questions, bug reports, or feature requests, please use the Issues and Discussions sections on our repository. This helps the entire community benefit from shared knowledge and solutions.

Community Chat:

Join our Discord server (link) to connect with other developers, ask questions in real-time, and share your feedback on Sense.

Interested in contributing to Sense?

Please review our <a href="https://github.com/sense-opensource/sense-device-identity-android/blob/main/CONTRIBUTING.md"> Contribution Guidelines </a> to learn how to get started, submit pull requests, or run the project locally. We encourage you to read these guidelines carefully before making any contributions. Your input helps us make Sense better for everyone!
