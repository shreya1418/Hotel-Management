# Hotel Management

An Android app for hotel room booking, built with Java and Firebase. Guests verify their phone number with an OTP, pick a room type, and book a stay; hotel staff can view all bookings from an admin screen.

## Features

- **Phone number login via OTP** — guests sign in with just their mobile number, verified through Firebase Phone Authentication (`SendOTP`, `VerifyOTPActivity`).
- **Room type selection** — browse available room categories (Luxury Deluxe, Super Deluxe, AC, Non-AC) with photos in a swipeable image flipper (`RoomType`).
- **Booking form** — guests enter check-in/check-out date & time, number of guests and children, Aadhaar details, and an optional promo code, then confirm a booking (`MainActivity`).
- **Booking confirmation screen** — shows the guest's saved booking details, room type, and a logout option (`UserDetails`).
- **Admin dashboard** — hotel staff can view a live list of all guest bookings, backed by Firebase Realtime Database (`Admin`, `MainDataBase`, and their respective `RecyclerView` adapters `MyAdapter` / `MyMainAdapter`).
- **Push notifications** — integrated with Firebase Cloud Messaging for booking-related notifications.
- **Local session memory** — the signed-in guest's details and selected room persist across app restarts via `SharedPreferences` (`MemoryData`).

## Tech stack

- **Language:** Java
- **Platform:** Android (min SDK 21, target SDK 32, compiled against SDK 34)
- **Backend:** Firebase — Realtime Database, Phone Authentication, Cloud Messaging
- **UI:** Android Views, RecyclerView, CardView, ViewFlipper, Material Components
- **Build system:** Gradle


## How to Run
1. Clone the repository
```bash
   git clone https://github.com/shreya-User/Hotel-Management.git
   cd Hotel-Management
```
2. Open the project folder in **Android Studio**
3. Add your own `google-services.json` file (from Firebase Console) into the `app/` folder
4. Let Gradle sync automatically
5. Connect an Android device or start an emulator
6. Click **Run** ▶ in Android Studio
## Project Structure
| File | Purpose |
|------|---------|
| `MainActivity.java` | Booking form (dates, guests, Aadhaar, promo code) |
| `SendOTP.java` | Collects name/phone, sends OTP |
| `VerifyOTPActivity.java` | OTP entry and verification |
| `RoomType.java` | Room type selection screen |
| `UserDetails.java` | Guest's booking summary |
| `Admin.java` | Admin: list of all bookings |
| `MainDataBase.java` | Admin: list of all main user records |
| `User.java` | Booking data model |
| `MemoryData.java` | Saves session data on the device |


## Project structure

app/src/main/java/com/example/hotelmanagement/
├── loading.java # Splash/routing screen — decides where to send the user
├── SendOTP.java # Collects name + phone, triggers Firebase OTP
├── VerifyOTPActivity.java # 6-digit OTP entry and verification
├── RoomType.java # Room type gallery/selection
├── MainActivity.java # Booking form (dates, guests, Aadhaar, promo code)
├── UserDetails.java # Guest's confirmed booking summary
├── Admin.java # Admin: list of all "Users" bookings
├── MainDataBase.java # Admin: list of all "Main Users" records
├── MyAdapter.java / MyMainAdapter.java # RecyclerView adapters for the two admin lists
├── User.java # Booking data model
├── MemoryData.java # SharedPreferences helper for session/local storage



## Setup

1. Clone the repo and open the `HotelManagement` folder in **Android Studio**.
2. This project uses **Firebase** — you'll need your own `google-services.json` (from the Firebase console, with Realtime Database, Phone Auth, and Cloud Messaging enabled) placed in `app/`. The one currently in the repo is a placeholder/example and won't connect to a real project.
3. Let Gradle sync, then build and run on an emulator or device (min SDK 21).

## Known limitations

- No hashed/secure admin credential flow yet — admin routing in `loading.java` currently checks the guest's saved name against a couple of hardcoded strings.
- Room pricing/availability is not dynamically checked against existing bookings before confirming.
- No automated tests beyond the default Android boilerplate (`ExampleUnitTest`, `ExampleInstrumentedTest`).

## License

Add a license of your choice (e.g. MIT) if you plan to share or open-source this project.
