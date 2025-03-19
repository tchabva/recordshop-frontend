# Record Shop - Android Frontend - Java 🎵

A modern and user-friendly record shop Android application built with XML and Android Views for the
frontend and Spring Boot for the backend.

## Overview

This application provides a digital platform for browsing, searching, and managing a record shop
inventory. The app features a clean, intuitive interface designed with XML and Android Views..

**Note**: Active development is currently happening at [https://github.com/tchabva/Recordshop-Frontend-Compose](https://github.com/tchabva/Recordshop-Frontend-Compose)

## Features ✨

- Full integration with [Record Shop Backend API](https://github.com/tchabva/recordshopbackend)
- Browse record catalogue with cover art and details
- Search functionality with instant results
- Responsive UI for different screen sizes
- Smooth animations and transitions

## Screenshots

<table>
  <!-- Row 1 -->
  <tr>
    <td style="text-align:center">
      <img src="screenshots/home_page.png" alt="Home Screen" width="1080"/>
      <p><em>Record Shop Home Screen</em></p>
    </td>
    <td style="text-align:center">
      <img src="screenshots/add_album.png" alt="Add Album Screen" width="1080"/>
      <p><em>Add Album Detail Screen</em></p>
    </td>
  </tr>

  <!-- Row 2 -->
  <tr>
    <td style="text-align:center">
      <img src="screenshots/view_album.png" alt="View Album Screen" width="1080"/>
      <p><em>View Album Screen Screen</em></p>
    </td>
    <td style="text-align:center">
      <img src="screenshots/view_album_delete_dialog.png" alt="View Album Delete Album Dialog" width="1080"/>
      <p><em>View Album Screen Delete Album Dialog </em></p>
    </td>
  </tr>

  <!-- Row 3 -->
  <tr>
    <td style="text-align:center">
      <img src="screenshots/edit_album.png" alt="Edit Album Screen" width="1080"/>
      <p><em>Edit Album Screen</em></p>
    </td>
    <td style="text-align:center">
      <img src="screenshots/edit_album_delete_dialog.png" alt="Edit Album Screen Delete Album Dialog" width="1080"/>
      <p><em>Edit Album Screen Delete Album Dialog</em></p>
    </td>
  </tr>
</table>

## Tech Stack 🛠️

### Frontend:

- Java
- XML and Android Views
- MVVM Architecture
- Material Design Components
- Networking: Retrofit
- Image Loading: Glide
- Navigation: Fragment Navigation

### Backend:

The application requires the backend service to function properly:

- [Record Shop Backend](https://github.com/tchabva/recordshopbackend)
- Built with Spring Boot using Java
- RESTful API design
- Postgres Database Integration

## Getting Started

### Prerequisites ⚙️

1. Android Studio Flamingo or newer
2. JDK 11+
3. An Android device running API 21 (Lollipop) or higher
4. Backend server running (see setup instructions below)

### Installation

1. Clone the repository:
    ```bash
    git clone https://github.com/tchabva/Recordshop-Frontend-Compose.git
    ```
2. Open the project in Android Studio and let Gradle sync the project.
3. Set up the backend server. Follow the README:
    - Clone and run the [Record Shop Backend](https://github.com/tchabva/recordshopbackend)
4. Update the API Base URL in the frontend - if required
5. Build & run the application on your device or emulator

### Configuration

The app is configured to connect to the backend service. You may need to adjust the backend URL in
the app's configuration based on your setup environment.