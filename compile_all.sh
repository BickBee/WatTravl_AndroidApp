#!/bin/bash

# Navigate to the src directory
echo "Navigating to the src/main/kotlin directory..."
cd "$(dirname "$0")/src/main/kotlin"
echo "Current directory: $(pwd)"

# Set the source directory
SRC_DIR="com/example/model/MC"

# List of all Kotlin files to compile
FILES=(
    "Dijkstra.kt"
    "main.kt"
    "NodeStructure.kt"
    "floor1.kt"
    "floor2.kt"
    "floor3.kt"
    "floor4.kt"
    "floor5.kt"
    "floor6.kt"
)

# Compile all the Kotlin files
echo "Compiling Kotlin files..."
kotlinc ${FILES[@]/#/$SRC_DIR/} -include-runtime -d ../../../../build/classes/kotlin/main.jar

if [ $? -eq 0 ]; then
    echo "Compilation successful."
    echo "Running the application..."
    # Run the application
    kotlin -classpath ../../../../build/classes/kotlin/main.jar com.example.model.MC.MainKt
else
    echo "Compilation failed."
    exit 1
fi
