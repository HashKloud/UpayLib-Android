# UpayLib-Android

Online merchant & Upay on delivery integration documentation. 



[![](https://jitpack.io/v/HashKloud/UpayLib-Android.svg)](https://jitpack.io/#HashKloud/UpayLib-Android)

![UpayLib-Android](https://raw.githubusercontent.com/HashKloud/UpayLib-Android/master/screenshots/upay-on-delivery.gif)

## Usage 

### Step 1. Add the JitPack repository & dependencies to your build file 

- Add below code in your  project level `build.gradle` file,  At the end of repositories: </br> 

```java
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
 ``` 
- Add the dependency to your app level `build.gradle` file. 
```java
	dependencies {
	        implementation 'com.github.HashKloud:UpayLib-Android:V0.1.0'
	}
 ```
  
### Step 2. Add Runtime Permission 

Remember to add below  permission in `Manifest.xml file` .
 ```java
     <uses-permission android:name="android.permission.INTERNET"/>
  ```   
 
 ###  Step 3. For requesting UPay purchase use below code: 
 
 ```java 
    UpayWebBuilder upayWebBuilder = new UpayWebBuilder(this);
    upayWebBuilder.upayOnDeliveryRequest(true, new PurchaseRequestInfo(TOKEN,500),this);
 ```
**Details**
```java
UpayWebBuilder(this); 
```
- Use `this` or Activity `Context`. </br>

```java 
upayOnDeliveryRequest(true, new PurchaseRequestInfo(TOKEN,500),this);
``` 
- **1st Parameter** takes a `boolean` which is for Sanbox Mode `(true/false)`. If `true` sandbox or test environment enable, otherwise production environment will use. 

- **2nd Parameter** takes a object of `PuchaseRequestInfo` which takes two params  **TOKEN** and **Amount**

- **3rd Parameter** takes `this` for listener.  

### Step 4.  Implement listener  for success & failure callback 

```java 
public class MainActivity extends AppCompatActivity implements UpayListener{
        @Override
    public void onSuccess(HashMap<String, String> values) {
        
    }


    @Override
    public void onFailure(HashMap<String,String> values) {
       
    }

} 
```

 <b> You are Good To Go. Happy Coding </b>
 
 
MIT License

Copyright (c) 2018 HashKloud
