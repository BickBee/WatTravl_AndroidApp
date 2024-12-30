package com.example.wattravl.viewmodel

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Matrix
import android.graphics.Paint
import android.graphics.RectF
import android.os.Build
import android.view.Display.Mode
import androidx.annotation.RequiresApi
import androidx.lifecycle.MutableLiveData
import com.caverock.androidsvg.RenderOptions
import com.caverock.androidsvg.SVG
import com.example.wattravl.MapActivity
import com.example.wattravl.model.*
import com.example.wattravl.model.DC.ModelDC
import com.example.wattravl.model.MC.HallwayNode
import com.example.wattravl.model.MC.Model
import java.lang.Exception
import java.util.logging.Level
import java.util.logging.Logger
import kotlin.math.atan2
import kotlin.math.cos
import kotlin.math.sin

private val logger = Logger.getLogger("ViewModel")

class ViewModel(
    private val activity: MapActivity,
) {
    var resBitmap: MutableLiveData<Bitmap>? = null
    private lateinit var svg: SVG
    val pathCoordinates: MutableList<Pair<Int, Int>> = mutableListOf()
    val pathFloors: MutableList<Int> = mutableListOf()
    val pathBuildings: MutableList<String>  = mutableListOf()
    var startPathCoord = 0
    var endPathCoord = 0
    var currentFloor = 0
    var building = "MC"

    @RequiresApi(Build.VERSION_CODES.R)
    private fun transform(coord: Pair<Int, Int>, zoomScale: Float, offsetX: Float, offsetY: Float): Pair<Float, Float> {
        val x = coord.first.toFloat()
        val y = coord.second.toFloat()
        // val newX = (x - offsetX) * (zoomScale * 10)
        // val newY = (y - offsetY) * (zoomScale * 10)

        /*
        var newX = x - offsetX
        var newY = y - offsetY
        newX /= activity.densityScale
        newY /= activity.densityScale
        newX *= zoomScale
        newY *= zoomScale
        return Pair(newX, newY) // so that when we render it's in screen coordinates, not pixels

         */


        val invertedMatrix = Matrix()
        activity.matrix.invert(invertedMatrix)

        val tmpCoords = floatArrayOf(x, y);
        invertedMatrix.mapPoints(tmpCoords)

        var newX = tmpCoords[0]
        var newY = tmpCoords[1]
        /*
        newX /= activity.densityScale
        newY /= activity.densityScale
        newX *= zoomScale
        newY *= zoomScale

         */

        return Pair(newX, newY)

    }

    /*
    @RequiresApi(Build.VERSION_CODES.N)
    fun logPath() {
        val hallways = buildGraph()

        // Create the classroom to hallway map
        val classroomToHallwayMap = createClassroomToHallwayMap(hallways)

        // Change these to the desired starting and ending classroom IDs
        val startClassroomId = 1023
        val endClassroomId = 1048

        // Find the corresponding hallway nodes for the start and end classrooms
        val startNodeId = classroomToHallwayMap[startClassroomId] ?: throw IllegalArgumentException("Classroom $startClassroomId does not exist in the map")
        val endNodeId = classroomToHallwayMap[endClassroomId] ?: throw IllegalArgumentException("Classroom $endClassroomId does not exist in the map")

        val startNode = hallways[startNodeId] ?: throw IllegalArgumentException("Hallway node $startNodeId does not exist")
        val endNode = hallways[endNodeId] ?: throw IllegalArgumentException("Hallway node $endNodeId does not exist")

        val distances = dijkstra(startNode)

        val path = getPath(distances, startNode, endNode)
        logger.log(Level.INFO, path.joinToString(" -> ") { it.nodeId.toString() })
    }

     */

    /**
     * These 2 data classes are made just for translating coordinates of the arrow in rendering
     */
    data class Point(var x: Double, var y: Double)

    data class Triangle(var p1: Point, var p2: Point, var p3: Point) {

        fun translate(dx: Double, dy: Double) {
            p1.x += dx
            p1.y += dy
            p2.x += dx
            p2.y += dy
            p3.x += dx
            p3.y += dy
        }

        fun rotate(angle: Double, centerX: Double = 0.0, centerY: Double = 0.0) {
            val radians = Math.toRadians(angle)
            rotatePoint(p1, radians, centerX, centerY)
            rotatePoint(p2, radians, centerX, centerY)
            rotatePoint(p3, radians, centerX, centerY)
        }

        private fun rotatePoint(point: Point, radians: Double, centerX: Double, centerY: Double) {
            val x = point.x - centerX
            val y = point.y - centerY
            val xNew = x * cos(radians) - y * sin(radians) + centerX
            val yNew = x * sin(radians) + y * cos(radians) + centerY
            point.x = xNew
            point.y = yNew
        }
    }

    fun drawArrow(coord1: Pair<Int, Int>, coord2: Pair<Int, Int>): String {
        val midX = (coord2.first + coord1.first).toFloat() / 2f
        val midY = (coord2.second + coord1.second).toFloat() / 2f
        val arrowTriangle = Triangle(Point(-5.0, -5.0), Point(5.0, 0.0), Point(-5.0, 5.0))
        val angle = atan2((coord2.second - coord1.second).toDouble(), (coord2.first - coord1.first).toDouble()) * 180 / Math.PI
        arrowTriangle.rotate(angle, 0.0, 0.0)
        arrowTriangle.translate(midX.toDouble(), midY.toDouble())
        return """
            <polygon id="arrowhead" points="${arrowTriangle.p1.x},${arrowTriangle.p1.y} ${arrowTriangle.p2.x},${arrowTriangle.p2.y} ${arrowTriangle.p3.x},${arrowTriangle.p3.y}"
            fill="red" />
        """.trimIndent()
    }

    @RequiresApi(Build.VERSION_CODES.N)
    fun draw(zoomScale: Float, offsetX: Float, offsetY: Float, width: Int, height: Int): Bitmap {
        var bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
        var canvas = Canvas(bitmap)

        // logger.log(Level.INFO, "Width = " + width + " Height = " + height);
        // logger.log(Level.INFO, "Scale = " + zoomScale + " offsetX = " + offsetX + " offsetY = " + offsetY)
        // logger.log(Level.INFO, svg.renderDPI.toString())
        // logger.log(Level.INFO, svg.documentWidth.toString() + " " + svg.documentHeight.toString())
        // so what's da scale that I move exactly 1 pixel on this SVG?

        // offsetX offsetY is rendered at some random ass point wtf?
        svg.setDocumentViewBox(offsetX, offsetY, width.toFloat() / zoomScale, height.toFloat() / zoomScale)
        // svg.setDocumentViewBox(offsetX, offsetY, width.toFloat(), height.toFloat())
        svg.renderToCanvas(canvas)

        val startCoords = pathCoordinates.first()
        val endCoords = pathCoordinates.last()

        var svgString = """
            <svg xmlns="http://www.w3.org/2000/svg" width="1632" height="1056">
        """.trimIndent()

        var startCircle = ""
        var endCircle = ""

        if (startPathCoord != -1 && endPathCoord != -1) {
            for (i in startPathCoord..(endPathCoord - 1)) {
                val coord1 = pathCoordinates[i]
                val coord2 = pathCoordinates[i + 1]

                svgString += "<line x1=\"" + coord1.first + "\" y1 = \"" + coord1.second + "\" x2 = \"" + coord2.first + "\" y2 = \"" + coord2.second + "\" stroke = \"blue\" stroke-width = \"2\"/>"
                svgString += drawArrow(coord1, coord2)
            }

            /*
            pathCoordinates.zipWithNext().forEach { (coord1, coord2) ->
                svgString += "<line x1=\"" + coord1.first + "\" y1 = \"" + coord1.second + "\" x2 = \"" + coord2.first + "\" y2 = \"" + coord2.second + "\" stroke = \"blue\" stroke-width = \"2\"/>"
                svgString += drawArrow(coord1, coord2)
            }
             */

            startCircle = """
            <circle cx="${startCoords.first}" cy="${startCoords.second}" r="5" fill="red" />"
        """.trimIndent()
            endCircle = """
            <circle cx="${endCoords.first}" cy="${endCoords.second}" r="5" fill="cyan" />
        """.trimIndent()

            if (startPathCoord > 0) {
                val curStartCoords = pathCoordinates[startPathCoord]
                startCircle = """
                <circle cx="${curStartCoords.first}" cy="${curStartCoords.second}" r="5" fill="green" />
            """.trimIndent()
            }
            if (endPathCoord < pathCoordinates.size - 1) {
                val curEndCoords = pathCoordinates[endPathCoord]
                endCircle = """
                <circle cx="${curEndCoords.first}" cy="${curEndCoords.second}" r="5" fill="darkgreen" />
            """.trimIndent()
            }
        }

        svgString += """
            $startCircle
            $endCircle
            </svg>
        """.trimIndent()
        svgString.trimIndent()

        val svg2 = SVG.getFromString(svgString)
        svg2.setDocumentViewBox(offsetX, offsetY, width.toFloat() / zoomScale, height.toFloat() / zoomScale)
        svg2.renderToCanvas(canvas)

        return bitmap

        // svg.renderToPicture()
    }

    fun setPathCoordinates(pathCoords: List<Pair<Int, Int>>) {
        pathCoordinates.clear()
        pathCoordinates.addAll(pathCoords)
    }

    /*
    fun getNodeCoords(id: Int): Pair<Int, Int> {
        if (MapActivity.Companion.nodesToCoords.containsKey(id)) {
            val coords = MapActivity.Companion.nodesToCoords[id]!!
            return Pair((coords.first * 1224 / 1632), (coords.second * 792 / 1056))
        } else if (MapActivity.Companion.nodesToCoords2.containsKey(id)) {
            return MapActivity.Companion.nodesToCoords2[id]!!
        } else {
            throw Exception("Invalid node ID " + id)
        }
    }
     */

    fun getBuildingOfNode(nodeId: Int): String {
        if (nodeId < 1000) {
            return "MC"
        } else {
            return "DC"
        }
    }

    fun getFloorOfNode(nodeId: Int): Int {
        return nodeId.toString().first().digitToInt()
    }

    fun getFloorOfRoom(roomId: Int): Int {
        return roomId.toString().first().digitToInt()
    }

    /**
     * This function assumes all routes of the same floor are consecutive. This should be a correct assumption.
     */
    fun updateFloor(newFloor: Int) {
        if (building == "DC" && newFloor > 3) {
            return
        }
        currentFloor = newFloor

        svg = SVG.getFromInputStream(activity.assets.open("${building}Floor${newFloor}.svg"))

        startPathCoord = -1
        endPathCoord = -1
        for (i in 0..(pathFloors.size - 1)) {
            if (pathFloors[i] == newFloor && pathBuildings[i] == building) {
                if (startPathCoord == -1) {
                    startPathCoord = i
                }
                endPathCoord = i
            }
        }
    }

    fun updateBuilding(newBuilding: String) {
        var oldBuilding = building
        building = newBuilding
        if (oldBuilding == "MC") {
            currentFloor = 2
            svg = SVG.getFromInputStream(activity.assets.open("${building}Floor${currentFloor}.svg"))
        } else {
            currentFloor = 3
            svg = SVG.getFromInputStream(activity.assets.open("${building}Floor${currentFloor}.svg"))
        }

        startPathCoord = -1
        endPathCoord = -1
        for (i in 0..(pathFloors.size - 1)) {
            if (pathFloors[i] == currentFloor && pathBuildings[i] == building) {
                if (startPathCoord == -1) {
                    startPathCoord = i
                }
                endPathCoord = i
            }
        }
    }

    @RequiresApi(Build.VERSION_CODES.N)
    fun drawPath(startBuilding: String, endBuilding: String, start: Int, end: Int, useElevator: Boolean) : String {
        val path : List<HallwayNode>
        var toastMsg = ""
        logger.log(Level.INFO, "${startBuilding} ${endBuilding}")
        if (startBuilding == endBuilding) {
            if (startBuilding == "MC") {
                path = Model.getInstance().getPath(start, end, useElevator)
            } else {
                path = ModelDC.getInstance().getPath(start, end, useElevator)
            }
            if (end.toString().first() != start.toString().first()) {
                toastMsg = "Head to Floor ${end.toString().first()}"
            }
        } else {
            if (startBuilding == "MC") {
                path = Model.getInstance().getPath(start, 30, useElevator) + ModelDC.getInstance().getPath(28521, end, useElevator)
                if (getFloorOfNode(path[0].nodeId) != 3){
                    toastMsg = "Go to Floor 3"
                }
            } else {
                path = Model.getInstance().getPath(start, 28521, useElevator) + Model.getInstance().getPath(30, end, useElevator)
                if (getFloorOfNode(path[0].nodeId) != 2){
                    toastMsg = "Go to Floor 2"
                }
            }
        }
        //val path = Model.getInstance().getPath(start, end, useElevator)
        val coords = mutableListOf<Pair<Int, Int>>()

        path.forEach {
            logger.log(Level.INFO, it.nodeId.toString())
            // coords.add(MapActivity.Companion.nodesToCoords[it.nodeId]!!)
            coords.add(MapActivity.getNodeCoords(it.nodeId))
            pathFloors.add(getFloorOfNode(it.nodeId))
            pathBuildings.add(getBuildingOfNode(it.nodeId))
        }


        /*
        coords.clear()
        coords.add(MapActivity.Companion.nodesToCoords[110]!!)
        coords.add(MapActivity.Companion.nodesToCoords[115]!!)

         */

        // 1632 1056: coordinates you thought
        // 1224 792: coordinates actual


        /*
        setPathCoordinates(coords.map { (x, y) ->
            Pair((x * 1224 / 1632), (y * 792 / 1056))
        })
*/
        setPathCoordinates(coords)
        updateFloor(getFloorOfRoom(start))
        return toastMsg

        /*
        setPathCoordinates(listOf(
            Pair(500, 200),
            Pair(900, 200),
            // Pair(200, 700),
            // Pair(1000, 200)
        ))

         */
    }
}