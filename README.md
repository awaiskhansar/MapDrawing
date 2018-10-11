# MapDrawing

Add
1) Add to your app(build.gradle)

    implementation "com.android.support:appcompat-v7:$rootProject.ext.SupportLibVersion",
                    "com.android.support:design:$rootProject.ext.SupportLibVersion"
    implementation "com.google.android.gms:play-services-maps:$rootProject.ext.playServicesVersion",
                     "com.google.android.gms:play-services-location:$rootProject.ext.playServicesVersion"

    implementation project(':maplibrary')
    implementation project(':maplibraryUtil')

2) Add to your project(build.gradle)
ext{
    //dependencies
    SupportLibVersion = '27.1.1'
    playServicesVersion = '16.0.0'
}

