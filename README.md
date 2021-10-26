# EasyDatePickerLibrary
You can use Date Picker more easily with this library.

Download 🚀
--------

```gradle
allprojects {
    repositories {
	...
	maven { url 'https://jitpack.io' }
    }
}

dependencies {
	implementation 'com.github.cemaltuysuz:EasyDatePickerLibrary:1.0'
}
```

Build 🏗️
-----

```kotlin
class EasyDatePicker (
    private val activity:Activity,
    private var style: Int = R.style.DefaultDatePickerStyle,
    private var pattern:String = "yyyy-MM-dd",
    private var listener: OnDateSelectListener? = null)
```



How do I use EasyDatePickerLibrary? 👨‍🏫
-----------------------------------
This library primarily needs an activity and onDateSelectListener interface. 

The example usage below represents simple and trouble-free usage :

### Activity

```kotlin
class MainActivity : AppCompatActivity() {
      ...

        val myDatePickerDialog =
            EasyDatePicker(this)
                .setListener(object : OnDateSelectListener{
                    override fun isSelected(date: String) {
                        // Your Code
                    }
                })
}
```

### Fragment


```kotlin
class MainActivity : AppCompatActivity() {
      ...

        val myDatePickerDialog =
            EasyDatePicker(requireActivity())
                .setListener(object : OnDateSelectListener{
                    override fun isSelected(date: String) {
                        // Your Code
                    }
                })
}
```

Customize 🧑‍🎨
---------

Sample Colors.xml :


```xml
    <color name="white">#FFFFFFFF</color>
    <color name="green_700">#1D454A</color>
    <color name="green_500">#225157</color>
    <color name="grey_200">#EAEAEA</color>
```
Sample Style.xml

```xml
<style name="DefaultDatePickerStyle" parent="Theme.AppCompat.Light.Dialog">
        <item name="colorAccent">@color/green_500</item>
        <!--selected Item color-->
        <item name="colorControlActivated">@color/green_700</item>
        <!-- arrow bordercolor(<>)-->
        <item name="android:selectableItemBackgroundBorderless">@color/green_700</item>
        <!-- Highlight item color-->
        <item name="colorControlHighlight">@color/green_700</item>
        <!--Calender Background color -->
        <item name="android:windowBackground">@color/green_500</item>
        <!-- Ok Cancel Color-->
        <item name="android:textColor">@color/grey_200</item>
        <!-- Week TextColor-->
        <item name="android:textColorSecondary">@color/white</item>
        <!-- Calender Number color arrow color (< >) -->
        <item name="android:textColorPrimary">@color/white</item>
        <!--day , month-->
        <item name="android:textColorPrimaryInverse">@color/white</item>
        <!-- year-->
        <item name="android:textColorSecondaryInverse">@color/green_500</item>
        <!-- Positive Button-->
        <item name="android:buttonBarPositiveButtonStyle">@style/positiveButton</item>
        <!-- Negative Button-->
        <item name="android:buttonBarNegativeButtonStyle">@style/negativeButton</item>
    </style>

    <style name="positiveButton" parent="Widget.AppCompat.Button.ButtonBar.AlertDialog">
        <item name="android:backgroundTint">@color/green_700</item>
    </style>

    <style name="negativeButton" parent="Widget.AppCompat.Button.ButtonBar.AlertDialog">
        <item name="android:backgroundTint">@android:color/transparent</item>
    </style>
```



License
-------

[LICENSE](https://github.com/cemaltuysuz/EasyDatePickerLibrary/blob/main/LICENSE)


