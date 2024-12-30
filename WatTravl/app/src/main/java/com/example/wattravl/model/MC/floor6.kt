package com.example.wattravl.model.MC
import com.example.wattravl.model.MC.*

fun buildGraphFloor6(): Map<Int, HallwayNode> {
    println("Floor 6 classrooms created")

    // Create hallway nodes
    val hallways = createHallways6()

    println("Floor 6 hallways created")

    // Connect hallways
    connectHallways6(hallways)

    println("Floor 6 hallways connected")

    // Set distances between hallways in the global distances map
    setDistances6(hallways)

    println("Floor 6 distances set")

    // Connect classrooms to hallways
    connectClassroomsToHallways6(hallways)

    println("Floor 6 classrooms connected\n")

    return hallways
}

fun createHallways6(): Map<Int, HallwayNode> {
    return (601..687).associateWith { HallwayNode(nodeId = it) }
}


fun connectClassroomsToHallways6(hallways: Map<Int, HallwayNode>) {
    hallways[601]?.classrooms?.addAll(listOf(6042, 6044, 6046))
    hallways[602]?.classrooms?.addAll(listOf(6038, 6496, 6036))
    hallways[603]?.classrooms?.addAll(listOf(6036, 6034))
    hallways[604]?.classrooms?.addAll(listOf(6033, 6032, 6029))
    hallways[605]?.classrooms?.addAll(listOf(6028))
    hallways[606]?.classrooms?.addAll(listOf(6024, 6026))
    hallways[607]?.classrooms?.addAll(listOf(6018, 60111, 6027, 6022))
    hallways[608]?.classrooms?.addAll(listOf(6012, 6014))
    hallways[609]?.classrooms?.addAll(listOf(6008))
    hallways[610]?.classrooms?.addAll(listOf(6006, 6004, 6002))
    hallways[611]?.classrooms?.addAll(listOf(6806)) //stairs
    hallways[612]?.classrooms?.addAll(listOf(6496))
    hallways[614]?.classrooms?.addAll(listOf(6029))
    hallways[615]?.classrooms?.addAll(listOf(6027, 60111))
    hallways[616]?.classrooms?.addAll(listOf(6011))
    hallways[618]?.classrooms?.addAll(listOf(6808))
    hallways[619]?.classrooms?.addAll(listOf(6912, 6811)) //6811 is an elevator
    hallways[620]?.classrooms?.add(6138)
    hallways[622]?.classrooms?.addAll(listOf(6136, 6137, 6134))
    hallways[623]?.classrooms?.addAll(listOf(6403))
    hallways[624]?.classrooms?.addAll(listOf(6483))
    hallways[625]?.classrooms?.addAll(listOf(64821, 6302))
    hallways[626]?.classrooms?.addAll(listOf(64824))
    hallways[627]?.classrooms?.addAll(listOf(6133, 6132))
    hallways[628]?.classrooms?.addAll(listOf(6404, 6407, 6408, 6409))
    hallways[629]?.classrooms?.addAll(listOf(6128, 6131))
    hallways[630]?.classrooms?.addAll(listOf(6478))
    hallways[631]?.classrooms?.addAll(listOf(6309, 6303, 6308))
    hallways[632]?.classrooms?.addAll(listOf(6126, 6127, 6124))
    hallways[633]?.classrooms?.addAll(listOf(6412))
    hallways[634]?.classrooms?.addAll(listOf(6501))
    hallways[635]?.classrooms?.addAll(listOf(6503, 6504))
    hallways[636]?.classrooms?.addAll(listOf(6507, 6509, 6508))
    hallways[637]?.classrooms?.addAll(listOf(6511, 6512))
    hallways[638]?.classrooms?.addAll(listOf(6513))
    hallways[639]?.classrooms?.addAll(listOf(6472))
    hallways[640]?.classrooms?.addAll(listOf(6312, 6311, 6313, 6314))
    hallways[641]?.classrooms?.addAll(listOf(6122, 6118, 6123, 6119))
    hallways[642]?.classrooms?.addAll(listOf(6413, 6414))
    hallways[643]?.classrooms?.addAll(listOf(6528, 6526, 6524))
    hallways[644]?.classrooms?.addAll(listOf(6522))
    hallways[645]?.classrooms?.addAll(listOf(6514, 6471, 6516))
    hallways[646]?.classrooms?.addAll(listOf(6473))
    hallways[647]?.classrooms?.addAll(listOf(6316, 6317))
    hallways[648]?.classrooms?.addAll(listOf(6417))
    hallways[649]?.classrooms?.addAll(listOf(6471, 6469, 6460, 6470))
    hallways[650]?.classrooms?.addAll(listOf(6321, 6318, 6322))
    hallways[651]?.classrooms?.addAll(listOf(6116, 6114))
    hallways[652]?.classrooms?.addAll(listOf(6418, 6419, 6421))
    hallways[653]?.classrooms?.addAll(listOf(6467))
    hallways[654]?.classrooms?.addAll(listOf(6323, 6324, 6326))
    hallways[655]?.classrooms?.addAll(listOf(6108, 6112, 6113, 6109))
    hallways[656]?.classrooms?.addAll(listOf(6422, 6423, 6426, 6427, 6428))
    hallways[657]?.classrooms?.addAll(listOf(6461, 6460))
    hallways[658]?.classrooms?.addAll(listOf(6326, 6327))
    hallways[659]?.classrooms?.addAll(listOf(6106, 6104, 6103))
    hallways[660]?.classrooms?.addAll(listOf(6429, 6431, 6432))
    hallways[661]?.classrooms?.addAll(listOf(6459, 6457))
    hallways[662]?.classrooms?.addAll(listOf(6342))
    hallways[663]?.classrooms?.addAll(listOf(6331, 6332, 6328, 6334))
    hallways[664]?.classrooms?.addAll(listOf(6803, 6801, 6901)) //elevator and stairs
    hallways[665]?.classrooms?.addAll(listOf(6101))
    hallways[666]?.classrooms?.addAll(listOf(6434))
    hallways[667]?.classrooms?.addAll(listOf(6436, 6437, 6439))
    hallways[668]?.classrooms?.addAll(listOf(6441, 6443))
    hallways[669]?.classrooms?.addAll(listOf(6447, 6449))
    hallways[670]?.classrooms?.addAll(listOf(6451, 6452))
    hallways[671]?.classrooms?.addAll(listOf(6453, 6454))
    hallways[672]?.classrooms?.addAll(listOf(6917))
    hallways[673]?.classrooms?.addAll(listOf(6902, 6201))
    hallways[674]?.classrooms?.addAll(listOf(64441, 64446))
    hallways[675]?.classrooms?.addAll(listOf(6813)) //stairs
    hallways[676]?.classrooms?.addAll(listOf(6202, 6203))
    hallways[677]?.classrooms?.addAll(listOf(64442, 64443, 64444, 64445))
    hallways[678]?.classrooms?.addAll(listOf(6452, 6254))
    hallways[679]?.classrooms?.addAll(listOf(6204, 6206))
    hallways[680]?.classrooms?.addAll(listOf(6252, 6248))
    hallways[681]?.classrooms?.addAll(listOf(6208, 6212))
    hallways[682]?.classrooms?.addAll(listOf(6217, 6216, 6219, 6218))
    hallways[683]?.classrooms?.addAll(listOf(6221, 6222, 6223, 6224))
    hallways[684]?.classrooms?.addAll(listOf(6227, 6226, 6228, 6229))
    hallways[685]?.classrooms?.addAll(listOf(6231, 6232, 6233, 6234))
    hallways[686]?.classrooms?.addAll(listOf(6237, 6236, 6239, 6238))
    hallways[687]?.classrooms?.addAll(listOf(6244, 6246))
}

fun connectHallways6(hallways: Map<Int, HallwayNode>) {
    hallways[601]?.apply {
        east = hallways[602]
    }
    hallways[602]?.apply {
        west = hallways[601]
        east = hallways[603]
    }
    hallways[603]?.apply {
        west = hallways[602]
        east = hallways[604]
        south = hallways[613]
    }
    hallways[604]?.apply {
        west = hallways[603]
        east = hallways[605]
    }
    hallways[605]?.apply {
        west = hallways[604]
        east = hallways[606]
    }
    hallways[606]?.apply {
        west = hallways[605]
        east = hallways[607]
    }
    hallways[607]?.apply {
        west = hallways[606]
        east = hallways[608]
    }
    hallways[608]?.apply {
        west = hallways[607]
        east = hallways[609]
    }
    hallways[609]?.apply {
        west = hallways[608]
        east = hallways[610]
    }
    hallways[610]?.apply {
        west = hallways[609]
        south = hallways[617]
    }
    hallways[611]?.apply {
        east = hallways[612]
    }
    hallways[612]?.apply {
        west = hallways[611]
        east = hallways[613]
        south = hallways[621]
    }
    hallways[613]?.apply {
        west = hallways[612]
        east = hallways[614]
        south = hallways[623]
    }
    hallways[614]?.apply {
        west = hallways[613]
        east = hallways[615]
    }
    hallways[615]?.apply {
        west = hallways[614]
        east = hallways[616]
    }
    hallways[616]?.apply {
        west = hallways[615]
        east = hallways[617]
        south = hallways[624]
    }
    hallways[617]?.apply {
        north = hallways[610]
        west = hallways[616]
        east = hallways[618]
    }
    hallways[618]?.apply {
        south = hallways[625]
        west = hallways[617]
        east = hallways[619]
    }
    hallways[619]?.apply {
        west = hallways[618]
    }
    hallways[620]?.apply {
        east = hallways[621]
        south = hallways[622]
    }
    hallways[621]?.apply {
        north = hallways[612]
        west = hallways[620]
    }
    hallways[622]?.apply {
        north = hallways[620]
        south = hallways[627]
    }
    hallways[623]?.apply {
        north = hallways[613]
        south = hallways[628]
    }
    hallways[624]?.apply {
        north = hallways[616]
        south = hallways[626]
    }
    hallways[625]?.apply {
        west = hallways[618]
        east = hallways[631]
    }
    hallways[626]?.apply {
        north = hallways[624]
        south = hallways[630]
    }
    hallways[627]?.apply {
        north = hallways[622]
        south = hallways[629]
    }
    hallways[628]?.apply {
        north = hallways[623]
        south = hallways[633]
    }
    hallways[629]?.apply {
        north = hallways[627]
        south = hallways[632]
    }
    hallways[630]?.apply {
        north = hallways[626]
        south = hallways[639]
    }
    hallways[631]?.apply {
        north = hallways[625]
        south = hallways[640]
    }
    hallways[632]?.apply {
        north = hallways[629]
        south = hallways[641]
    }
    hallways[633]?.apply {
        north = hallways[628]
        south = hallways[642]
        east = hallways[634]
    }
    hallways[634]?.apply {
        west = hallways[633]
        east = hallways[635]
        south = hallways[643]
    }
    hallways[635]?.apply {
        west = hallways[634]
        east = hallways[636]
    }
    hallways[636]?.apply {
        west = hallways[635]
        east = hallways[637]
    }
    hallways[637]?.apply {
        west = hallways[636]
        east = hallways[638]
        south = hallways[645]
    }
    hallways[638]?.apply {
        west = hallways[637]
        east = hallways[639]
    }
    hallways[639]?.apply {
        north = hallways[630]
        south = hallways[646]
        west = hallways[638]
    }
    hallways[640]?.apply {
        north = hallways[631]
        south = hallways[647]
    }
    hallways[641]?.apply {
        north = hallways[632]
        south = hallways[651]
    }
    hallways[642]?.apply {
        north = hallways[633]
        south = hallways[648]
    }
    hallways[643]?.apply {
        north = hallways[634]
        east = hallways[644]
    }
    hallways[644]?.apply {
        west = hallways[643]
        east = hallways[645]
    }
    hallways[645]?.apply {
        north = hallways[637]
        west = hallways[644]
    }
    hallways[646]?.apply {
        north = hallways[639]
        south = hallways[649]
    }
    hallways[647]?.apply {
        north = hallways[640]
        south = hallways[650]
    }
    hallways[648]?.apply {
        north = hallways[642]
        south = hallways[652]
    }
    hallways[649]?.apply {
        north = hallways[646]
        south = hallways[653]
    }
    hallways[650]?.apply {
        north = hallways[647]
        east = hallways[654]
    }
    hallways[651]?.apply {
        north = hallways[641]
        south = hallways[655]
    }
    hallways[652]?.apply {
        north = hallways[648]
        south = hallways[656]
    }
    hallways[653]?.apply {
        north = hallways[649]
        south = hallways[657]
    }
    hallways[654]?.apply {
        north = hallways[650]
        south = hallways[658]
    }
    hallways[655]?.apply {
        north = hallways[651]
        south = hallways[659]
    }
    hallways[656]?.apply {
        north = hallways[652]
        south = hallways[660]
    }
    hallways[657]?.apply {
        north = hallways[653]
        south = hallways[661]
    }
    hallways[658]?.apply {
        north = hallways[654]
        south = hallways[663]
    }
    hallways[659]?.apply {
        north = hallways[655]
        south = hallways[664]
    }
    hallways[660]?.apply {
        north = hallways[656]
        south = hallways[666]
    }
    hallways[661]?.apply {
        north = hallways[657]
        south = hallways[671]
        east = hallways[662]
    }
    hallways[662]?.apply {
        west = hallways[661]
        east = hallways[663]
    }
    hallways[663]?.apply {
        north = hallways[658]
        west = hallways[662]
    }
    hallways[664]?.apply {
        east = hallways[665]
    }
    hallways[665]?.apply {
        west = hallways[664]
        east = hallways[666]
        south = hallways[673]
    }
    hallways[666]?.apply {
        west = hallways[665]
        east = hallways[667]
        north = hallways[660]
    }
    hallways[667]?.apply {
        west = hallways[666]
        east = hallways[668]
    }
    hallways[668]?.apply {
        west = hallways[667]
        east = hallways[669]
        south = hallways[674]
    }
    hallways[669]?.apply {
        west = hallways[668]
        east = hallways[670]
    }
    hallways[670]?.apply {
        west = hallways[669]
        east = hallways[671]
    }
    hallways[671]?.apply {
        west = hallways[670]
        east = hallways[672]
        north = hallways[661]
    }
    hallways[672]?.apply {
        west = hallways[671]
        south = hallways[675]
    }
    hallways[673]?.apply {
        north = hallways[665]
        south = hallways[676]
    }
    hallways[674]?.apply {
        north = hallways[668]
        south = hallways[677]
    }
    hallways[675]?.apply {
        north = hallways[672]
        south = hallways[678]
    }
    hallways[676]?.apply {
        north = hallways[673]
        south = hallways[679]
    }
    hallways[677]?.apply {
        north = hallways[674]
    }
    hallways[678]?.apply {
        north = hallways[675]
        south = hallways[680]
    }
    hallways[679]?.apply {
        north = hallways[676]
        south = hallways[681]
    }
    hallways[680]?.apply {
        north = hallways[678]
        south = hallways[687]
    }
    hallways[681]?.apply {
        north = hallways[679]
        east = hallways[682]
    }
    hallways[682]?.apply {
        west = hallways[681]
        east = hallways[683]
    }
    hallways[683]?.apply {
        west = hallways[682]
        east = hallways[684]
    }
    hallways[684]?.apply {
        west = hallways[683]
        east = hallways[685]
    }
    hallways[685]?.apply {
        west = hallways[684]
        east = hallways[686]
    }
    hallways[686]?.apply {
        west = hallways[685]
        east = hallways[687]
    }
    hallways[687]?.apply {
        west = hallways[686]
        north = hallways[680]
    }
}

fun setDistances6(hallways: Map<Int, HallwayNode>) {
    globalDistances[hallways[601]!! to hallways[602]!!] = 1 * unit
    globalDistances[hallways[602]!! to hallways[601]!!] = 1 * unit

    globalDistances[hallways[602]!! to hallways[603]!!] = 1 * unit
    globalDistances[hallways[603]!! to hallways[602]!!] = 1 * unit

    globalDistances[hallways[603]!! to hallways[604]!!] = 1 * unit
    globalDistances[hallways[604]!! to hallways[603]!!] = 1 * unit

    globalDistances[hallways[603]!! to hallways[613]!!] = 2.5 * unit
    globalDistances[hallways[613]!! to hallways[603]!!] = 2.5 * unit

    globalDistances[hallways[604]!! to hallways[605]!!] = 1 * unit
    globalDistances[hallways[605]!! to hallways[604]!!] = 1 * unit

    globalDistances[hallways[605]!! to hallways[606]!!] = 1 * unit
    globalDistances[hallways[606]!! to hallways[605]!!] = 1 * unit

    globalDistances[hallways[606]!! to hallways[607]!!] = 1 * unit
    globalDistances[hallways[607]!! to hallways[606]!!] = 1 * unit

    globalDistances[hallways[607]!! to hallways[608]!!] = 1 * unit
    globalDistances[hallways[608]!! to hallways[607]!!] = 1 * unit

    globalDistances[hallways[608]!! to hallways[609]!!] = 1 * unit
    globalDistances[hallways[609]!! to hallways[608]!!] = 1 * unit

    globalDistances[hallways[609]!! to hallways[610]!!] = 1 * unit
    globalDistances[hallways[610]!! to hallways[609]!!] = 1 * unit

    globalDistances[hallways[610]!! to hallways[617]!!] = 2.5 * unit
    globalDistances[hallways[617]!! to hallways[610]!!] = 2.5 * unit

    globalDistances[hallways[611]!! to hallways[612]!!] = 1 * unit
    globalDistances[hallways[612]!! to hallways[611]!!] = 1 * unit

    globalDistances[hallways[612]!! to hallways[613]!!] = 1 * unit
    globalDistances[hallways[613]!! to hallways[612]!!] = 1 * unit

    globalDistances[hallways[613]!! to hallways[623]!!] = 1.5 * unit
    globalDistances[hallways[623]!! to hallways[632]!!] = 1.5 * unit

    globalDistances[hallways[612]!! to hallways[621]!!] = 1 * unit
    globalDistances[hallways[621]!! to hallways[612]!!] = 1 * unit

    globalDistances[hallways[613]!! to hallways[614]!!] = 1 * unit
    globalDistances[hallways[614]!! to hallways[613]!!] = 1 * unit

    globalDistances[hallways[614]!! to hallways[615]!!] = 3 * unit
    globalDistances[hallways[615]!! to hallways[614]!!] = 3 * unit

    globalDistances[hallways[615]!! to hallways[616]!!] = 1.5 * unit
    globalDistances[hallways[616]!! to hallways[615]!!] = 1.5 * unit

    globalDistances[hallways[616]!! to hallways[617]!!] = 1.5 * unit
    globalDistances[hallways[617]!! to hallways[616]!!] = 1.5 * unit

    globalDistances[hallways[616]!! to hallways[624]!!] = 1.5 * unit
    globalDistances[hallways[624]!! to hallways[616]!!] = 1.5 * unit

    globalDistances[hallways[617]!! to hallways[618]!!] = 1.5 * unit
    globalDistances[hallways[618]!! to hallways[617]!!] = 1.5 * unit

    globalDistances[hallways[618]!! to hallways[625]!!] = 1.5 * unit
    globalDistances[hallways[625]!! to hallways[618]!!] = 1.5 * unit

    globalDistances[hallways[618]!! to hallways[619]!!] = 1.5 * unit
    globalDistances[hallways[619]!! to hallways[618]!!] = 1.5 * unit

    globalDistances[hallways[620]!! to hallways[621]!!] = 1.5 * unit
    globalDistances[hallways[621]!! to hallways[620]!!] = 1.5 * unit

    globalDistances[hallways[620]!! to hallways[622]!!] = 1 * unit
    globalDistances[hallways[622]!! to hallways[620]!!] = 1 * unit

    globalDistances[hallways[622]!! to hallways[627]!!] = 1.5 * unit
    globalDistances[hallways[627]!! to hallways[622]!!] = 1.5 * unit

    globalDistances[hallways[623]!! to hallways[628]!!] = 1.5 * unit
    globalDistances[hallways[628]!! to hallways[623]!!] = 1.5 * unit

    globalDistances[hallways[624]!! to hallways[626]!!] = 1 * unit
    globalDistances[hallways[626]!! to hallways[624]!!] = 1 * unit

    globalDistances[hallways[625]!! to hallways[631]!!] = 1.5 * unit
    globalDistances[hallways[631]!! to hallways[625]!!] = 1.5 * unit

    globalDistances[hallways[626]!! to hallways[630]!!] = 1.5 * unit
    globalDistances[hallways[630]!! to hallways[626]!!] = 1.5 * unit

    globalDistances[hallways[627]!! to hallways[629]!!] = 1 * unit
    globalDistances[hallways[629]!! to hallways[627]!!] = 1 * unit

    globalDistances[hallways[628]!! to hallways[633]!!] = 2.5 * unit
    globalDistances[hallways[633]!! to hallways[628]!!] = 2.5 * unit

    globalDistances[hallways[629]!! to hallways[632]!!] = 1.5 * unit
    globalDistances[hallways[632]!! to hallways[629]!!] = 1.5 * unit

    globalDistances[hallways[630]!! to hallways[639]!!] = 1.5 * unit
    globalDistances[hallways[639]!! to hallways[630]!!] = 1.5 * unit

    globalDistances[hallways[631]!! to hallways[640]!!] = 1.5 * unit
    globalDistances[hallways[640]!! to hallways[631]!!] = 1.5 * unit

    globalDistances[hallways[632]!! to hallways[641]!!] = 1.5 * unit
    globalDistances[hallways[641]!! to hallways[632]!!] = 1.5 * unit

    globalDistances[hallways[633]!! to hallways[642]!!] = 1.5 * unit
    globalDistances[hallways[642]!! to hallways[633]!!] = 1.5 * unit

    globalDistances[hallways[633]!! to hallways[634]!!] = 1.5 * unit
    globalDistances[hallways[634]!! to hallways[633]!!] = 1.5 * unit

    globalDistances[hallways[634]!! to hallways[635]!!] = 0.5 * unit
    globalDistances[hallways[635]!! to hallways[634]!!] = 0.5 * unit

    globalDistances[hallways[634]!! to hallways[643]!!] = 1.5 * unit
    globalDistances[hallways[643]!! to hallways[634]!!] = 1.5 * unit

    globalDistances[hallways[635]!! to hallways[636]!!] = 0.5 * unit
    globalDistances[hallways[636]!! to hallways[635]!!] = 0.5 * unit

    globalDistances[hallways[636]!! to hallways[637]!!] = 1.5 * unit
    globalDistances[hallways[637]!! to hallways[636]!!] = 1.5 * unit

    globalDistances[hallways[637]!! to hallways[638]!!] = 0.75 * unit
    globalDistances[hallways[638]!! to hallways[637]!!] = 0.75 * unit

    globalDistances[hallways[637]!! to hallways[645]!!] = 1.5 * unit
    globalDistances[hallways[645]!! to hallways[637]!!] = 1.5 * unit

    globalDistances[hallways[638]!! to hallways[639]!!] = 0.75 * unit
    globalDistances[hallways[639]!! to hallways[638]!!] = 0.75 * unit

    globalDistances[hallways[639]!! to hallways[646]!!] = 1 * unit
    globalDistances[hallways[646]!! to hallways[639]!!] = 1 * unit

    globalDistances[hallways[640]!! to hallways[647]!!] = 1.5 * unit
    globalDistances[hallways[647]!! to hallways[640]!!] = 1.5 * unit

    globalDistances[hallways[641]!! to hallways[651]!!] = 1.5 * unit
    globalDistances[hallways[651]!! to hallways[641]!!] = 1.5 * unit

    globalDistances[hallways[642]!! to hallways[648]!!] = 1 * unit
    globalDistances[hallways[648]!! to hallways[642]!!] = 1 * unit

    globalDistances[hallways[643]!! to hallways[644]!!] = 1 * unit
    globalDistances[hallways[644]!! to hallways[643]!!] = 1 * unit

    globalDistances[hallways[644]!! to hallways[645]!!] = 1.5 * unit
    globalDistances[hallways[645]!! to hallways[644]!!] = 1.5 * unit

    globalDistances[hallways[646]!! to hallways[649]!!] = 1.5 * unit
    globalDistances[hallways[649]!! to hallways[646]!!] = 1.5 * unit

    globalDistances[hallways[647]!! to hallways[650]!!] = 1.5 * unit
    globalDistances[hallways[650]!! to hallways[647]!!] = 1.5 * unit

    globalDistances[hallways[648]!! to hallways[652]!!] = 0.5 * unit
    globalDistances[hallways[652]!! to hallways[648]!!] = 0.5 * unit

    globalDistances[hallways[649]!! to hallways[653]!!] = 1 * unit
    globalDistances[hallways[653]!! to hallways[649]!!] = 1 * unit

    globalDistances[hallways[650]!! to hallways[654]!!] = 1.5 * unit
    globalDistances[hallways[654]!! to hallways[650]!!] = 1.5 * unit

    globalDistances[hallways[651]!! to hallways[655]!!] = 1.5 * unit
    globalDistances[hallways[655]!! to hallways[651]!!] = 1.5 * unit

    globalDistances[hallways[652]!! to hallways[656]!!] = 1.5 * unit
    globalDistances[hallways[656]!! to hallways[652]!!] = 1.5 * unit

    globalDistances[hallways[653]!! to hallways[657]!!] = 1 * unit
    globalDistances[hallways[657]!! to hallways[653]!!] = 1 * unit

    globalDistances[hallways[654]!! to hallways[658]!!] = 1 * unit
    globalDistances[hallways[658]!! to hallways[654]!!] = 1 * unit

    globalDistances[hallways[655]!! to hallways[659]!!] = 1.5 * unit
    globalDistances[hallways[659]!! to hallways[655]!!] = 1.5 * unit

    globalDistances[hallways[656]!! to hallways[660]!!] = 1.5 * unit
    globalDistances[hallways[660]!! to hallways[656]!!] = 1.5 * unit

    globalDistances[hallways[657]!! to hallways[661]!!] = 1.5 * unit
    globalDistances[hallways[661]!! to hallways[657]!!] = 1.5 * unit

    globalDistances[hallways[658]!! to hallways[663]!!] = 1.5 * unit
    globalDistances[hallways[663]!! to hallways[658]!!] = 1.5 * unit

    globalDistances[hallways[659]!! to hallways[664]!!] = 2 * unit
    globalDistances[hallways[664]!! to hallways[659]!!] = 2 * unit

    globalDistances[hallways[660]!! to hallways[666]!!] = 2 * unit
    globalDistances[hallways[666]!! to hallways[660]!!] = 2 * unit

    globalDistances[hallways[661]!! to hallways[662]!!] = 1.5 * unit
    globalDistances[hallways[662]!! to hallways[661]!!] = 1.5 * unit

    globalDistances[hallways[662]!! to hallways[663]!!] = 1.5 * unit
    globalDistances[hallways[663]!! to hallways[662]!!] = 1.5 * unit

    globalDistances[hallways[664]!! to hallways[665]!!] = 1.5 * unit
    globalDistances[hallways[665]!! to hallways[664]!!] = 1.5 * unit

    globalDistances[hallways[665]!! to hallways[666]!!] = 1 * unit
    globalDistances[hallways[666]!! to hallways[665]!!] = 1 * unit

    globalDistances[hallways[665]!! to hallways[673]!!] = 1.5 * unit
    globalDistances[hallways[673]!! to hallways[665]!!] = 1.5 * unit

    globalDistances[hallways[666]!! to hallways[667]!!] = 1 * unit
    globalDistances[hallways[667]!! to hallways[666]!!] = 1 * unit

    globalDistances[hallways[667]!! to hallways[668]!!] = 1 * unit
    globalDistances[hallways[668]!! to hallways[667]!!] = 1 * unit

    globalDistances[hallways[668]!! to hallways[669]!!] = 1 * unit
    globalDistances[hallways[669]!! to hallways[668]!!] = 1 * unit

    globalDistances[hallways[668]!! to hallways[674]!!] = 1.5 * unit
    globalDistances[hallways[674]!! to hallways[668]!!] = 1.5 * unit

    globalDistances[hallways[669]!! to hallways[670]!!] = 1 * unit
    globalDistances[hallways[670]!! to hallways[669]!!] = 1 * unit

    globalDistances[hallways[670]!! to hallways[671]!!] = 1.5 * unit
    globalDistances[hallways[671]!! to hallways[670]!!] = 1.5 * unit

    globalDistances[hallways[671]!! to hallways[672]!!] = 1.5 * unit
    globalDistances[hallways[672]!! to hallways[671]!!] = 1.5 * unit

    globalDistances[hallways[671]!! to hallways[661]!!] = 2 * unit
    globalDistances[hallways[661]!! to hallways[671]!!] = 2 * unit

    globalDistances[hallways[672]!! to hallways[675]!!] = 1.5 * unit
    globalDistances[hallways[675]!! to hallways[672]!!] = 1.5 * unit

    globalDistances[hallways[673]!! to hallways[676]!!] = 1.5 * unit
    globalDistances[hallways[676]!! to hallways[673]!!] = 1.5 * unit

    globalDistances[hallways[674]!! to hallways[677]!!] = 1.5 * unit
    globalDistances[hallways[677]!! to hallways[674]!!] = 1.5 * unit

    globalDistances[hallways[675]!! to hallways[678]!!] = 1.5 * unit
    globalDistances[hallways[678]!! to hallways[675]!!] = 1.5 * unit

    globalDistances[hallways[676]!! to hallways[679]!!] = 1 * unit
    globalDistances[hallways[679]!! to hallways[676]!!] = 1 * unit

    globalDistances[hallways[678]!! to hallways[680]!!] = 1 * unit
    globalDistances[hallways[680]!! to hallways[678]!!] = 1 * unit

    globalDistances[hallways[679]!! to hallways[681]!!] = 1 * unit
    globalDistances[hallways[681]!! to hallways[679]!!] = 1 * unit

    globalDistances[hallways[680]!! to hallways[687]!!] = 1 * unit
    globalDistances[hallways[687]!! to hallways[680]!!] = 1 * unit

    globalDistances[hallways[681]!! to hallways[682]!!] = 2 * unit
    globalDistances[hallways[682]!! to hallways[681]!!] = 2 * unit

    globalDistances[hallways[682]!! to hallways[683]!!] = 1.2 * unit
    globalDistances[hallways[683]!! to hallways[682]!!] = 1.2 * unit

    globalDistances[hallways[683]!! to hallways[684]!!] = 1.2 * unit
    globalDistances[hallways[684]!! to hallways[683]!!] = 1.2 * unit

    globalDistances[hallways[684]!! to hallways[685]!!] = 1.2 * unit
    globalDistances[hallways[685]!! to hallways[684]!!] = 1.2 * unit

    globalDistances[hallways[685]!! to hallways[686]!!] = 1.2 * unit
    globalDistances[hallways[686]!! to hallways[685]!!] = 1.2 * unit

    globalDistances[hallways[686]!! to hallways[687]!!] = 1.2 * unit
    globalDistances[hallways[687]!! to hallways[686]!!] = 1.2 * unit
}





fun createClassroomToHallwayMap(hallways: Map<Int, HallwayNode>): Map<Int, List<Int>> {
    val map = mutableMapOf<Int, MutableList<Int>>()
    hallways.forEach { (hallwayId, hallway) ->
        hallway.classrooms.forEach { classroomId ->
            if (map.containsKey(classroomId)) {
                map[classroomId]?.add(hallwayId)
            } else {
                map[classroomId] = mutableListOf(hallwayId)
            }
        }
    }
    return map
}