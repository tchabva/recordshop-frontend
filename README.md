# Record Shop - Android Frontend - Java 🎵
A modern and user-friendly record shop Android application built with XML and Android Views for the frontend and Spring Boot for the backend.
## Overview
This application provides a digital platform for browsing, searching, and managing a record shop inventory. The app features a clean, intuitive interface designed with XML and Android Views..
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
      <img src="screenshots/home_page.png" alt="Record List" width="200"/>
      <p><em>Record List Screen</em></p>
    </td>
    <td style="text-align:center">
      <img src="screenshots/add_album.png" alt="Record Detail" width="200"/>
      <p><em>Record Detail Screen</em></p>
    </td>
  </tr>

  <!-- Row 2 -->
  <tr>
    <td style="text-align:center">
      <img src="screenshots/view_album.png" alt="Search Screen" width="200"/>
      <p><em>Search Screen</em></p>
    </td>
    <td style="text-align:center">
      <img src="screenshots/view_album_delete_dialog.png" alt="Profile Screen" width="200"/>
      <p><em>Profile Screen</em></p>
    </td>
  </tr>

  <!-- Row 3 -->
  <tr>
    <td style="text-align:center">
      <img src="screenshots/edit_album.png" alt="Settings Screen" width="200"/>
      <p><em>Settings Screen</em></p>
    </td>
    <td style="text-align:center">
      <img src="screenshots/edit_album_delete_dialog.png" alt="About Screen" width="200"/>
      <p><em>About Screen</em></p>
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
The app is configured to connect to the backend service. You may need to adjust the backend URL in the app's configuration based on your setup environment.