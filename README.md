# Navigation App for University of Waterloo

[🎥 **View Demo Here**](https://youtu.be/HgO7-DJSpcg)

## 📜 Project Overview
This project is a navigation application designed to enhance the experience of students and staff at the University of Waterloo. It provides efficient pathfinding within the MC and DC buildings, with features that support scalability, accessibility, and usability. The application combines modern UI/UX design with robust functionality, ensuring a seamless navigation experience.

---

## 🌟 Features

### 1. Internal Building Pathing for MC and DC
- Calculate the shortest path between classrooms and destinations within MC and DC.
- Support for outdoor, tunnel, bridge, and accessibility options based on user preferences.

### 2. Scalable Model
- Highly scalable design to easily add more buildings without major redesigns.
- Prepared for future expansions to cover the entire campus.

### 3. Outdoor Google Maps Support
- Integrated with Google Maps for outdoor navigation.
- Seamlessly transitions between indoor and outdoor navigation for a better user experience.

### 4. Interactive Map with Gesture Support
- Pinch-to-zoom and swipe gestures for intuitive map interaction.
- Clear visualization of start and end points with easy-to-follow directions.

### 5. Modern Aesthetic and Easy-to-Use UI
- Responsive design with a consistent color scheme and a modern aesthetic.
- Features like toast notifications to guide users across floors and buildings.

### 6. Security Measures
- Email verification ensures only University of Waterloo students and staff can access the app.
- Privacy considerations restrict searches for individual offices, focusing solely on classrooms.

---

## 🚧 Functionality Not Yet Implemented

### 1. Additional Buildings
- Currently focuses on MC and DC buildings only due to time constraints.
- Modelling additional buildings is planned for future updates.

### 2. Interweaved Outdoor and Indoor Pathing
- Transitioning seamlessly between indoor and outdoor paths remains a challenge due to geolocation accuracy and user view-switching issues.

### 3. Elevation, Geolocation, and Other Data
- Indoor pathing lacks elevation and geolocation data integration due to mapping complexity.

### 4. Recognizable Icons
- Icon-based navigation was deprioritized to focus on core functionalities.

### 5. Distance and Time Metrics
- Distance and time metrics for trips were not implemented due to the real-world measurement complexity of hallway nodes.

---

## 🛡️ Harms Mitigation

### 1. Security Concerns
- **Restricting Access**: A two-step email verification process limits app usage to University of Waterloo students and staff.
- **Privacy Protection**: Office searches are disabled to prevent privacy invasions.

### 2. Maintenance and Updates
- Paths are manually drawn, ensuring easy updates to accommodate campus changes like construction.

---

## ✅ Conclusion
The app successfully delivers essential navigation functionalities and provides a scalable foundation for future enhancements. Despite unimplemented features, the project addresses the key navigation challenges within the MC and DC buildings, offering a valuable tool for the University of Waterloo community.

---

## 👥 Team Contributions

### **Omar, Edmond, Nick, Duc, Roshan, David**
- Contributed to all aspects of the project, including development, documentation, and presentation.
- Specific contributions span UI design, algorithm implementation, model development, and app integration.

### **Model Team**
- Developed the internal Dijkstra's algorithm and modeled MC and DC buildings.
- Designed paths, nodes, and floor plans.

### **View Team**
- Designed the UI and implemented Google Maps integration.
- Developed an intuitive interactive map interface.

### **ViewModel Team**
- Integrated Model and View code.
- Created rendering features for interactive maps and handled path visualization.

### **Proofreading and Documentation**
- Various team members contributed to proofreading, feedback, and refining documentation.

---

This README serves as an overview of the project's current state and roadmap, reflecting the collaborative effort and dedication of the entire team.