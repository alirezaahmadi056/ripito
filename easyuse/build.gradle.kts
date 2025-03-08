plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
}



android {
    namespace = "com.app.easyuse"
    compileSdk = 35

    defaultConfig {
        minSdk = 21

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    implementation(files("https://objects.githubusercontent.com/github-production-release-asset-2e65be/938262262/3fd3f334-5b0a-46a0-b792-08d238445540?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=releaseassetproduction%2F20250225%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Date=20250225T185747Z&X-Amz-Expires=300&X-Amz-Signature=0a18d8d61dc2e81e66d06ecea88cbc80e7fbddda39fac1463fbe4ce2a102dce5&X-Amz-SignedHeaders=host&response-content-disposition=attachment%3B%20filename%3Deasyuse.aar&response-content-type=application%2Foctet-stream"))

}