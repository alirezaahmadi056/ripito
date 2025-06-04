# 🚀 Ripito - جایگزین قدرتمند Retrofit برای ارتباطات شبکه‌ای در اندروید

## 🔥 معرفی
**Ripito** یک کتابخانه‌ی فوق‌العاده برای انجام درخواست‌های HTTP در اندروید است که نسبت به Retrofit بسیار **ساده‌تر، سریع‌تر و سبک‌تر** طراحی شده است. این کتابخانه از `HttpURLConnection` و `Kotlin Coroutines` استفاده می‌کند تا تجربه‌ای بهینه و بدون پیچیدگی را ارائه دهد.

## 🎯 ویژگی‌ها
✅ **سادگی در استفاده**: بدون نیاز به ساخت اینترفیس و آنوتیشن‌های پیچیده مانند Retrofit.
✅ **پشتیبانی از GET و POST**: قابلیت ارسال درخواست‌های GET و POST با پارامترهای داینامیک.
✅ **مدیریت ساده JSON**: امکان تبدیل رشته‌های JSON به `JSONObject`.
✅ **سبک و سریع**: بدون وابستگی‌های سنگین و با حداقل استفاده از منابع.
✅ **عدم نیاز به Gson یا Moshi**: برای مدیریت JSON به هیچ کتابخانه‌ی اضافی نیاز نیست.

---

## 🚀 نحوه استفاده

# ویدیو آموزش نحوه استفاده :   https://dl.daneshjooyar.com/mvie/Ahmadi-Alireza/video-news/05-ripito.mp4

### **📌 درخواست GET**

```kotlin
EasyUse.get("https://jsonplaceholder.typicode.com/posts", mapOf("userId" to "1")) { response ->
    println(response)
}
```
🔹 این متد، یک درخواست **GET** به آدرس موردنظر ارسال کرده و نتیجه را در **callback** بازمی‌گرداند.

---

### **📌 درخواست POST**

```kotlin
EasyUse.post("https://jsonplaceholder.typicode.com/posts", mapOf("title" to "Hello", "body" to "This is a test")) { response ->
    println(response)
}
```
🔹 این متد، یک درخواست **POST** ارسال می‌کند و مقدار ارسال‌شده را در پارامترهای درخواست قرار می‌دهد.

---

### **📌 تبدیل رشته به JSON**

```kotlin
val jsonObject = EasyUse.json("{"name":"Ali", "age":25}")
println(jsonObject.getString("name"))
```
🔹 این متد، یک رشته‌ی **JSON** را به `JSONObject` تبدیل می‌کند تا بتوانید راحت‌تر با داده‌ها کار کنید.

---

## 📜 چرا Ripito بهتر از Retrofit است؟

| قابلیت  | Ripito | Retrofit |
|---------|--------|----------|
| سادگی در استفاده | ✅ | ❌ (پیچیدگی در تعریف API) |
| سبکی | ✅ (بدون وابستگی اضافی) | ❌ (نیاز به OkHttp، Gson، Moshi و ...) |
| عملکرد سریع | ✅ | ❌ (نیاز به پردازش‌های اضافی) |
| وابستگی به کتابخانه‌های دیگر | ندارد | دارد |

---

## 🤝 مشارکت
اگر ایده‌ای برای بهبود این کتابخانه دارید، **Pull Request** ارسال کنید یا یک **Issue** جدید باز کنید. 🎉

---

## 🏆 لایسنس
**MIT License** - استفاده از این کتابخانه **کاملاً رایگان** است. ❤️

📌 **نوشته‌شده با ❤️ توسط [GProSelf](https://github.com/GProSelf)**
