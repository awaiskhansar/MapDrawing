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
![alt text](https://github.com/awaiskhansar/MapDrawing/blob/master/images/Screenshot_20181011-161952_MapDrawing.jpg)
![alt text](https://github.com/awaiskhansar/MapDrawing/blob/master/images/Screenshot_20181011-162020_MapDrawing.jpg)
![alt text](https://github.com/awaiskhansar/MapDrawing/blob/master/images/Screenshot_20181011-162025_MapDrawing.jpg)

