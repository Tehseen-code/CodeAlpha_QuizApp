# 📱 Flashcard Quiz App (CodeAlpha Internship - Task 1)

A high-performance, cross-platform Flashcard Quiz Application built using **Kotlin Multiplatform (KMP)** and **Compose Multiplatform**. This app allows users to create study decks, manage flashcards, and conduct interactive study sessions with real-time data persistence.

---

## ✨ Features

- **Dynamic Deck Management:** Create, view, and delete study decks.
- **Full CRUD Operations:** Add, edit, and delete flashcards within each deck.
- **Interactive Quiz Mode:** A dedicated study session UI with show/hide answer logic.
- **Reactive UI:** Real-time data synchronization using **Kotlin Flows**.
- **Local Persistence:** Powered by **Room Database** for seamless offline usage.
- **Cross-Platform:** Shared business logic and UI for both **Android** and **iOS**.

---

## 🛠️ Tech Stack

- **Language:** Kotlin
- **Framework:** Compose Multiplatform (UI shared across Android/iOS)
- **Database:** Room (Multiplatform)
- **Architecture:** MVVM (Model-View-ViewModel)
- **Asynchronous Programming:** Kotlin Coroutines & Flows

---

## 📸 Screenshots

<img width="3807" height="1616" alt="QuizappUi" src="https://github.com/user-attachments/assets/f34d1ea9-cf8a-4d99-a4f2-a15a37fcd732" />

---

## 🏗️ Project Structure

* `/composeApp`: Contains the shared UI and business logic (Kotlin/Compose).
  * `commonMain`: Shared database logic, ViewModels, and UI Components.
  * `androidMain`: Android-specific configurations.
  * `iosMain`: iOS-specific entry points and configurations.
* `/iosApp`: Native iOS project wrapper.

---

## 🧠 Technical Deep Dive: Multiplatform State Management

One of the core challenges in building this cross-platform application was managing the reactive UI state across both Android and iOS from a single codebase while using the Room Multiplatform database layer.

### 1. The Reactive Flow Architecture
To ensure real-time UI synchronization without thread blocking, data is exposed from the Room Data Access Object (DAO) as a cold asynchronous `Flow`. Inside the shared architecture layer, this stream is transformed into a hot execution state wrapper using the `stateIn` pipeline operator. This effectively decouples critical database transaction contexts from platform-specific UI lifecycle adjustments, such as device screen rotations on Android.

```kotlin
// Architectural pattern utilized for exposing reactive database states safely
val uiState: StateFlow<DeckUiState> = repository.getAllDecks()
    .map { decks -> DeckUiState.Success(decks) }
    .stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = DeckUiState.Loading
    )
