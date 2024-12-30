# Navigate to the src/main/kotlin directory
Write-Output "Navigating to the src/main/kotlin directory..."
Set-Location -Path (Join-Path -Path (Split-Path -Parent $MyInvocation.MyCommand.Definition) -ChildPath "src/main/kotlin")
Write-Output "Current directory: $(Get-Location)"

# Set the source directory
$SRC_DIR = "com/example/model"

# List of all Kotlin files to compile
$FILES = @(
    "main.kt"
    "/DC/Dijkstra_DC.kt"
    "/DC/NodeStructure_DC.kt"
    "/DC/floor1_DC.kt"
    "/DC/floor2_DC.kt"
    "/DC/floor3_DC.kt"
    "/DC/wrapper.kt"
    "/MC/Dijkstra.kt"
    "/MC/NodeStructure.kt"
    "/MC/floor1.kt"
    "/MC/floor2.kt"
    "/MC/floor3.kt"
    "/MC/floor4.kt"
    "/MC/floor5.kt"
    "/MC/floor6.kt"
    "/MC/wrapper.kt"
)

# Compile all the Kotlin files
Write-Output "Compiling Kotlin files..."
$FILES_PATHS = $FILES | ForEach-Object { Join-Path -Path $SRC_DIR -ChildPath $_ }
kotlinc @FILES_PATHS -include-runtime -d "../../../../build/classes/kotlin/main.jar"

if ($LASTEXITCODE -eq 0) {
    Write-Output "Compilation successful."
    Write-Output "Running the application..."
    # Run the application
    kotlin -classpath "../../../../build/classes/kotlin/main.jar" com.example.model.MainKt
} else {
    Write-Output "Compilation failed."
    exit 1
}
