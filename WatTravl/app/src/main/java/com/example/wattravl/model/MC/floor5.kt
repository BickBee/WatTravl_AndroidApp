package com.example.wattravl.model.MC
import com.example.wattravl.model.MC.*

fun buildGraphFloor5(): Map<Int, HallwayNode> {
    println("Floor 5 classrooms created")

    // Create hallway nodes
    val hallways = createHallways5()

    println("Floor 5 hallways created")

    // Connect hallways
    connectHallways5(hallways)

    println("Floor 5 hallways connected")

    // Set distances between hallways in the global distances map
    setDistances5(hallways)

    println("Floor 5 distances set")

    // Connect classrooms to hallways
    connectClassroomsToHallways5(hallways)

    println("Floor 5 classrooms connected\n")

    return hallways
}

fun createHallways5(): Map<Int, HallwayNode> {
    return (501..587).associateWith { HallwayNode(nodeId = it) }
}

fun connectClassroomsToHallways5(hallways: Map<Int, HallwayNode>) {
    hallways[501]?.classrooms?.addAll(listOf(5042, 5044, 5038, 5908))
    hallways[502]?.classrooms?.addAll(listOf(5036, 5034, 5497))
    hallways[503]?.classrooms?.addAll(listOf(5032, 5028, 5031, 5029))
    hallways[504]?.classrooms?.addAll(listOf(5026, 5024, 5027, 5023))
    hallways[505]?.classrooms?.addAll(listOf(5022, 5018, 5021, 5019))
    hallways[506]?.classrooms?.addAll(listOf(5016, 5014, 5017, 5013))
    hallways[507]?.classrooms?.addAll(listOf(5008, 5012, 5011))
    hallways[508]?.classrooms?.addAll(listOf(5006, 5004, 5002))
    hallways[509]?.classrooms?.addAll(listOf(5094, 5806, 5907)) //5806 are stairs
    hallways[510]?.classrooms?.addAll(listOf(5491))
    hallways[511]?.classrooms?.addAll(listOf(5403))
    hallways[512]?.classrooms?.addAll(listOf(5808)) //5808 are stairs
    hallways[514]?.classrooms?.addAll(listOf(5913, 5912, 5811))
    hallways[516]?.classrooms?.addAll(listOf(5494, 5489))
    hallways[517]?.classrooms?.addAll(listOf(5407, 5409, 5301, 5404))
    hallways[518]?.classrooms?.addAll(listOf(5922, 5303))
    hallways[519]?.classrooms?.addAll(listOf(5136, 5134))
    hallways[520]?.classrooms?.addAll(listOf(5133, 5131))
    hallways[521]?.classrooms?.addAll(listOf(5492, 5488, 5489))
    hallways[522]?.classrooms?.addAll(listOf(5411, 5406, 5408))
    hallways[523]?.classrooms?.addAll(listOf(5304, 5307, 5306, 5309))
    hallways[524]?.classrooms?.addAll(listOf(5132, 5128))
    hallways[525]?.classrooms?.addAll(listOf(5129, 5127))
    hallways[526]?.classrooms?.addAll(listOf(5486, 5484))
    hallways[527]?.classrooms?.addAll(listOf(5501))
    hallways[528]?.classrooms?.addAll(listOf(5511))
    hallways[529]?.classrooms?.addAll(listOf(5501))
    hallways[530]?.classrooms?.addAll(listOf(5412, 5414))
    hallways[531]?.classrooms?.addAll(listOf(5311, 5312, 5313, 5314))
    hallways[532]?.classrooms?.addAll(listOf(5126, 5124))
    hallways[533]?.classrooms?.addAll(listOf(5123, 5121))
    hallways[534]?.classrooms?.addAll(listOf(5482, 5121, 5479))
    hallways[535]?.classrooms?.addAll(listOf(5417, 5416, 5418))
    hallways[536]?.classrooms?.addAll(listOf(5319, 5316, 5318))
    hallways[537]?.classrooms?.addAll(listOf(5122, 5118))
    hallways[538]?.classrooms?.addAll(listOf(5119, 5117))
    hallways[539]?.classrooms?.addAll(listOf(5477, 5474))
    hallways[540]?.classrooms?.addAll(listOf(5419, 5422, 5424))
    hallways[541]?.classrooms?.addAll(listOf(5321, 5322, 5323, 5324))
    hallways[542]?.classrooms?.addAll(listOf(5114, 5116))
    hallways[543]?.classrooms?.addAll(listOf(5473, 5471))
    hallways[544]?.classrooms?.addAll(listOf(5421, 5423))
    hallways[545]?.classrooms?.addAll(listOf(5113, 5109))
    hallways[546]?.classrooms?.addAll(listOf(5472, 5471, 5468))
    hallways[547]?.classrooms?.addAll(listOf(5426, 5428))
    hallways[548]?.classrooms?.addAll(listOf(5327, 5326, 5329, 5328))
    hallways[549]?.classrooms?.addAll(listOf(5469, 5467))
    hallways[550]?.classrooms?.addAll(listOf(5427, 5429))
    hallways[551]?.classrooms?.addAll(listOf(5109))
    hallways[552]?.classrooms?.addAll(listOf(5466, 5464))
    hallways[553]?.classrooms?.addAll(listOf(5432, 5434))
    hallways[554]?.classrooms?.addAll(listOf(5331, 5332, 5333, 5334))
    hallways[555]?.classrooms?.addAll(listOf(5106, 5104))
    hallways[556]?.classrooms?.addAll(listOf(5461, 5463))
    hallways[557]?.classrooms?.addAll(listOf(5431, 5433))
    hallways[558]?.classrooms?.addAll(listOf(5337, 5336))
    hallways[559]?.classrooms?.addAll(listOf(5103))
    hallways[560]?.classrooms?.addAll(listOf(5462, 5)) //5 is the court
    hallways[561]?.classrooms?.addAll(listOf(5)) // 5 is the court
    hallways[562]?.classrooms?.addAll(listOf(5338))
    hallways[563]?.classrooms?.addAll(listOf(5803, 5901)) // elevators
    hallways[564]?.classrooms?.addAll(listOf(5801)) //stairs
    hallways[565]?.classrooms?.addAll(listOf(5902))
    hallways[566]?.classrooms?.addAll(listOf(5457, 5453, 5201))
    hallways[567]?.classrooms?.addAll(listOf(5451, 5449, 5446))
    hallways[568]?.classrooms?.addAll(listOf(5447, 5443, 5442, 5438))
    hallways[569]?.classrooms?.addAll(listOf(5441, 5439))
    hallways[570]?.classrooms?.addAll(listOf(5917, 5813)) //stairs
    hallways[572]?.classrooms?.addAll(listOf(5242, 5241, 5238, 5239))
    hallways[573]?.classrooms?.addAll(listOf(5258))
    hallways[574]?.classrooms?.addAll(listOf(5202, 52011, 5204))
    hallways[575]?.classrooms?.addAll(listOf(5211, 5209))
    hallways[576]?.classrooms?.addAll(listOf(5237))
    hallways[577]?.classrooms?.addAll(listOf(5256, 5257, 5251))
    hallways[578]?.classrooms?.addAll(listOf(5236, 5234))
    hallways[579]?.classrooms?.addAll(listOf(5206, 5208))
    hallways[580]?.classrooms?.addAll(listOf(5205, 5210, 5212))
    hallways[581]?.classrooms?.addAll(listOf(5207, 5209))
    hallways[582]?.classrooms?.addAll(listOf(5214, 5226))
    hallways[584]?.classrooms?.addAll(listOf(5226, 5227))
    hallways[585]?.classrooms?.addAll(listOf(5228, 5231))
    hallways[586]?.classrooms?.addAll(listOf(5232, 5244))
    hallways[587]?.classrooms?.addAll(listOf(5246, 5248, 5249))
}

fun connectHallways5(hallways: Map<Int, HallwayNode>) {
    hallways[501]?.apply {
        east = hallways[502]
    }
    hallways[502]?.apply {
        west = hallways[501]
        east = hallways[503]
        south = hallways[510]
    }
    hallways[503]?.apply {
        west = hallways[502]
        east = hallways[504]
    }
    hallways[504]?.apply {
        west = hallways[503]
        east = hallways[505]
    }
    hallways[505]?.apply {
        west = hallways[504]
        east = hallways[506]
    }
    hallways[506]?.apply {
        west = hallways[505]
        east = hallways[507]
    }
    hallways[507]?.apply {
        west = hallways[506]
        east = hallways[508]
        south = hallways[511]
    }
    hallways[508]?.apply {
        west = hallways[509]
    }
    hallways[509]?.apply {
        east = hallways[510]
        south = hallways[515]
    }
    hallways[510]?.apply {
        west = hallways[509]
        north = hallways[502]
        south = hallways[516]
    }
    hallways[511]?.apply {
        east = hallways[512]
        north = hallways[507]
    }
    hallways[512]?.apply {
        east = hallways[513]
        west = hallways[511]
        south = hallways[517]
    }
    hallways[513]?.apply {
        west = hallways[512]
        east = hallways[514]
        south = hallways[518]
    }
    hallways[514]?.apply {
        west = hallways[513]
    }
    hallways[515]?.apply {
        north = hallways[509]
        south = hallways[519]
    }
    hallways[516]?.apply {
        north = hallways[510]
        south = hallways[521]
    }
    hallways[517]?.apply {
        north = hallways[511]
        south = hallways[522]
    }
    hallways[518]?.apply {
        south = hallways[523]
        north = hallways[513]
    }
    hallways[519]?.apply {
        north = hallways[515]
        south = hallways[520]
    }
    hallways[520]?.apply {
        north = hallways[519]
        south = hallways[524]
    }
    hallways[521]?.apply {
        north = hallways[516]
        south = hallways[526]
    }
    hallways[522]?.apply {
        north = hallways[517]
        south = hallways[530]
    }
    hallways[523]?.apply {
        north = hallways[518]
        south = hallways[531]
    }
    hallways[524]?.apply {
        north = hallways[520]
        south = hallways[525]
    }
    hallways[525]?.apply {
        north = hallways[524]
        south = hallways[532]
    }
    hallways[526]?.apply {
        north = hallways[521]
        south = hallways[534]
        east = hallways[527]
    }
    hallways[527]?.apply {
        west = hallways[526]
        east = hallways[528]
    }
    hallways[528]?.apply {
        west = hallways[527]
        east = hallways[529]
    }
    hallways[529]?.apply {
        west = hallways[528]
        east = hallways[530]
    }
    hallways[530]?.apply {
        north = hallways[522]
        south = hallways[535]
        west = hallways[529]
    }
    hallways[531]?.apply {
        north = hallways[523]
        south = hallways[536]
    }
    hallways[532]?.apply {
        north = hallways[525]
        south = hallways[533]
    }
    hallways[533]?.apply {
        north = hallways[532]
        south = hallways[537]
    }
    hallways[534]?.apply {
        north = hallways[526]
        south = hallways[539]
    }
    hallways[535]?.apply {
        north = hallways[530]
        south = hallways[540]
    }
    hallways[536]?.apply {
        north = hallways[531]
        south = hallways[541]
    }
    hallways[537]?.apply {
        north = hallways[533]
        south = hallways[538]
    }
    hallways[538]?.apply {
        north = hallways[537]
        south = hallways[542]
    }
    hallways[539]?.apply {
        north = hallways[534]
        south = hallways[543]
    }
    hallways[540]?.apply {
        north = hallways[535]
        south = hallways[544]
    }
    hallways[541]?.apply {
        north = hallways[536]
        south = hallways[548]
    }
    hallways[542]?.apply {
        north = hallways[538]
        south = hallways[545]
    }
    hallways[543]?.apply {
        north = hallways[539]
        south = hallways[546]
    }
    hallways[544]?.apply {
        north = hallways[540]
        south = hallways[547]
    }
    hallways[545]?.apply {
        north = hallways[542]
        south = hallways[551]
    }
    hallways[546]?.apply {
        north = hallways[543]
        south = hallways[549]
    }
    hallways[547]?.apply {
        north = hallways[544]
        south = hallways[550]
    }
    hallways[548]?.apply {
        north = hallways[541]
        south = hallways[554]
    }
    hallways[549]?.apply {
        north = hallways[546]
        south = hallways[552]
    }
    hallways[550]?.apply {
        north = hallways[547]
        south = hallways[553]
    }
    hallways[551]?.apply {
        north = hallways[545]
        south = hallways[555]
    }
    hallways[552]?.apply {
        north = hallways[549]
        south = hallways[556]
    }
    hallways[553]?.apply {
        north = hallways[550]
        south = hallways[557]
    }
    hallways[554]?.apply {
        north = hallways[548]
        south = hallways[558]
    }
    hallways[555]?.apply {
        north = hallways[551]
        south = hallways[559]
    }
    hallways[556]?.apply {
        north = hallways[552]
        south = hallways[560]
    }
    hallways[557]?.apply {
        north = hallways[553]
        south = hallways[561]
    }
    hallways[558]?.apply {
        north = hallways[554]
        south = hallways[562]
    }
    hallways[559]?.apply {
        north = hallways[555]
        south = hallways[564]
    }
    hallways[560]?.apply {
        north = hallways[556]
        south = hallways[565]
    }
    hallways[561]?.apply {
        north = hallways[557]
        south = hallways[570]
        east = hallways[562]
    }
    hallways[562]?.apply {
        west = hallways[561]
    }
    hallways[563]?.apply {
        east = hallways[564]
    }
    hallways[564]?.apply {
        west = hallways[563]
        east = hallways[565]
    }
    hallways[565]?.apply {
        west = hallways[564]
        east = hallways[566]
        north = hallways[560]
        south = hallways[574]
    }
    hallways[566]?.apply {
        west = hallways[565]
        east = hallways[567]
    }

    hallways[567]?.apply {
        west = hallways[566]
        east = hallways[568]
        south = hallways[575]
    }
    hallways[568]?.apply {
        west = hallways[567]
        east = hallways[569]
    }
    hallways[569]?.apply {
        west = hallways[568]
        east = hallways[570]
        south = hallways[572]
    }
    hallways[570]?.apply {
        west = hallways[569]
        north = hallways[561]
        south = hallways[573]
    }
    hallways[572]?.apply {
        north = hallways[568]
        south = hallways[576]
    }
    hallways[573]?.apply {
        north = hallways[570]
        south = hallways[577]
    }
    hallways[574]?.apply {
        north = hallways[565]
        south = hallways[579]
    }
    hallways[575]?.apply {
        north = hallways[567]
        south = hallways[583]
    }
    hallways[576]?.apply {
        north = hallways[572]
        south = hallways[578]
    }
    hallways[577]?.apply {
        north = hallways[573]
        south = hallways[587]
    }
    hallways[578]?.apply {
        north = hallways[576]
        south = hallways[586]
    }
    hallways[579]?.apply {
        north = hallways[574]
        east = hallways[580]
    }
    hallways[580]?.apply {
        west = hallways[579]
        east = hallways[581]
    }
    hallways[581]?.apply {
        west = hallways[580]
        east = hallways[582]
    }
    hallways[582]?.apply {
        west = hallways[581]
        east = hallways[583]
    }
    hallways[583]?.apply {
        west = hallways[582]
        east = hallways[584]
        north = hallways[575]
    }
    hallways[584]?.apply {
        west = hallways[583]
        east = hallways[585]
    }
    hallways[585]?.apply {
        west = hallways[584]
        east = hallways[586]
    }
    hallways[586]?.apply {
        west = hallways[585]
        east = hallways[587]
    }
    hallways[587]?.apply {
        west = hallways[586]
        north = hallways[577]
    }
}


fun setDistances5(hallways: Map<Int, HallwayNode>) {
    globalDistances[hallways[501]!! to hallways[502]!!] = 1.5 * unit
    globalDistances[hallways[502]!! to hallways[501]!!] = 1.5 * unit

    globalDistances[hallways[502]!! to hallways[503]!!] = 1.6 * unit
    globalDistances[hallways[503]!! to hallways[502]!!] = 1.6 * unit

    globalDistances[hallways[502]!! to hallways[510]!!] = 2 * unit
    globalDistances[hallways[510]!! to hallways[502]!!] = 2 * unit

    globalDistances[hallways[503]!! to hallways[504]!!] = 1.6 * unit
    globalDistances[hallways[504]!! to hallways[503]!!] = 1.6 * unit

    globalDistances[hallways[504]!! to hallways[505]!!] = 1.6 * unit
    globalDistances[hallways[505]!! to hallways[504]!!] = 1.6 * unit

    globalDistances[hallways[505]!! to hallways[506]!!] = 1.6 * unit
    globalDistances[hallways[506]!! to hallways[505]!!] = 1.6 * unit

    globalDistances[hallways[506]!! to hallways[507]!!] = 1.5 * unit
    globalDistances[hallways[507]!! to hallways[506]!!] = 1.6 * unit

    globalDistances[hallways[507]!! to hallways[508]!!] = 1.5 * unit
    globalDistances[hallways[508]!! to hallways[507]!!] = 1.5 * unit

    globalDistances[hallways[507]!! to hallways[511]!!] = 2 * unit
    globalDistances[hallways[511]!! to hallways[507]!!] = 2 * unit

    globalDistances[hallways[509]!! to hallways[510]!!] = 1.5 * unit
    globalDistances[hallways[510]!! to hallways[509]!!] = 1.5 * unit

    globalDistances[hallways[509]!! to hallways[515]!!] = 1.5 * unit
    globalDistances[hallways[515]!! to hallways[509]!!] = 1.5 * unit

    globalDistances[hallways[510]!! to hallways[516]!!] = 1.5 * unit
    globalDistances[hallways[516]!! to hallways[510]!!] = 1.5 * unit

    globalDistances[hallways[511]!! to hallways[512]!!] = 1.5 * unit
    globalDistances[hallways[512]!! to hallways[511]!!] = 1.5 * unit

    globalDistances[hallways[511]!! to hallways[517]!!] = 1.5 * unit
    globalDistances[hallways[517]!! to hallways[511]!!] = 1.5 * unit

    globalDistances[hallways[512]!! to hallways[513]!!] = 1 * unit
    globalDistances[hallways[513]!! to hallways[512]!!] = 1 * unit

    globalDistances[hallways[513]!! to hallways[514]!!] = 1.5 * unit
    globalDistances[hallways[514]!! to hallways[513]!!] = 1.5 * unit

    globalDistances[hallways[513]!! to hallways[518]!!] = 1.5 * unit
    globalDistances[hallways[518]!! to hallways[513]!!] = 1.5 * unit

    globalDistances[hallways[515]!! to hallways[519]!!] = 1.5 * unit
    globalDistances[hallways[519]!! to hallways[515]!!] = 1.5 * unit

    globalDistances[hallways[516]!! to hallways[521]!!] = 2.5 * unit
    globalDistances[hallways[521]!! to hallways[516]!!] = 2.5 * unit

    globalDistances[hallways[517]!! to hallways[522]!!] = 2.5 * unit
    globalDistances[hallways[522]!! to hallways[517]!!] = 2.5 * unit

    globalDistances[hallways[518]!! to hallways[523]!!] = 2.5 * unit
    globalDistances[hallways[523]!! to hallways[518]!!] = 2.5 * unit

    globalDistances[hallways[519]!! to hallways[520]!!] = 1 * unit
    globalDistances[hallways[520]!! to hallways[519]!!] = 1 * unit

    globalDistances[hallways[520]!! to hallways[524]!!] = 1 * unit
    globalDistances[hallways[524]!! to hallways[520]!!] = 1 * unit

    globalDistances[hallways[521]!! to hallways[526]!!] = 2 * unit
    globalDistances[hallways[526]!! to hallways[521]!!] = 2 * unit

    globalDistances[hallways[522]!! to hallways[530]!!] = 2 * unit
    globalDistances[hallways[530]!! to hallways[522]!!] = 2 * unit

    globalDistances[hallways[523]!! to hallways[531]!!] = 2 * unit
    globalDistances[hallways[531]!! to hallways[523]!!] = 2 * unit

    globalDistances[hallways[524]!! to hallways[525]!!] = 1 * unit
    globalDistances[hallways[525]!! to hallways[524]!!] = 1 * unit

    globalDistances[hallways[525]!! to hallways[532]!!] = 1 * unit
    globalDistances[hallways[532]!! to hallways[525]!!] = 1 * unit

    globalDistances[hallways[526]!! to hallways[527]!!] = 3 * unit
    globalDistances[hallways[527]!! to hallways[526]!!] = 3 * unit

    globalDistances[hallways[526]!! to hallways[534]!!] = 2 * unit
    globalDistances[hallways[534]!! to hallways[526]!!] = 2 * unit

    globalDistances[hallways[527]!! to hallways[528]!!] = 1 * unit
    globalDistances[hallways[528]!! to hallways[527]!!] = 1 * unit

    globalDistances[hallways[528]!! to hallways[529]!!] = 1 * unit
    globalDistances[hallways[529]!! to hallways[528]!!] = 1 * unit

    globalDistances[hallways[529]!! to hallways[530]!!] = 3 * unit
    globalDistances[hallways[530]!! to hallways[529]!!] = 3 * unit

    globalDistances[hallways[530]!! to hallways[535]!!] = 2 * unit
    globalDistances[hallways[535]!! to hallways[530]!!] = 2 * unit

    globalDistances[hallways[531]!! to hallways[536]!!] = 2 * unit
    globalDistances[hallways[536]!! to hallways[531]!!] = 2 * unit

    globalDistances[hallways[532]!! to hallways[533]!!] = 1 * unit
    globalDistances[hallways[533]!! to hallways[532]!!] = 1 * unit

    globalDistances[hallways[533]!! to hallways[537]!!] = 1 * unit
    globalDistances[hallways[537]!! to hallways[533]!!] = 1 * unit

    globalDistances[hallways[534]!! to hallways[539]!!] = 2 * unit
    globalDistances[hallways[539]!! to hallways[534]!!] = 2 * unit

    globalDistances[hallways[535]!! to hallways[540]!!] = 2 * unit
    globalDistances[hallways[540]!! to hallways[535]!!] = 2 * unit

    globalDistances[hallways[536]!! to hallways[541]!!] = 2 * unit
    globalDistances[hallways[541]!! to hallways[536]!!] = 2 * unit

    globalDistances[hallways[537]!! to hallways[538]!!] = 1 * unit
    globalDistances[hallways[538]!! to hallways[537]!!] = 1 * unit

    globalDistances[hallways[538]!! to hallways[542]!!] = 1 * unit
    globalDistances[hallways[542]!! to hallways[538]!!] = 1 * unit

    globalDistances[hallways[539]!! to hallways[543]!!] = 1 * unit
    globalDistances[hallways[543]!! to hallways[539]!!] = 1 * unit

    globalDistances[hallways[540]!! to hallways[544]!!] = 1 * unit
    globalDistances[hallways[544]!! to hallways[540]!!] = 1 * unit

    globalDistances[hallways[541]!! to hallways[548]!!] = 2 * unit
    globalDistances[hallways[548]!! to hallways[541]!!] = 2 * unit

    globalDistances[hallways[542]!! to hallways[545]!!] = 1 * unit
    globalDistances[hallways[545]!! to hallways[542]!!] = 1 * unit

    globalDistances[hallways[543]!! to hallways[546]!!] = 1 * unit
    globalDistances[hallways[546]!! to hallways[543]!!] = 1 * unit

    globalDistances[hallways[544]!! to hallways[547]!!] = 1 * unit
    globalDistances[hallways[547]!! to hallways[544]!!] = 1 * unit

    globalDistances[hallways[545]!! to hallways[551]!!] = 1.5 * unit
    globalDistances[hallways[551]!! to hallways[545]!!] = 1.5 * unit

    globalDistances[hallways[546]!! to hallways[549]!!] = 0.75 * unit
    globalDistances[hallways[549]!! to hallways[546]!!] = 0.75 * unit

    globalDistances[hallways[547]!! to hallways[550]!!] = 0.75 * unit
    globalDistances[hallways[550]!! to hallways[547]!!] = 0.75 * unit

    globalDistances[hallways[548]!! to hallways[554]!!] = 1.5 * unit
    globalDistances[hallways[554]!! to hallways[548]!!] = 1.5 * unit

    globalDistances[hallways[549]!! to hallways[552]!!] = 0.75 * unit
    globalDistances[hallways[552]!! to hallways[549]!!] = 0.75 * unit

    globalDistances[hallways[550]!! to hallways[553]!!] = 0.75 * unit
    globalDistances[hallways[553]!! to hallways[550]!!] = 0.75 * unit

    globalDistances[hallways[551]!! to hallways[555]!!] = 1 * unit
    globalDistances[hallways[555]!! to hallways[551]!!] = 1 * unit

    globalDistances[hallways[552]!! to hallways[556]!!] = 1 * unit
    globalDistances[hallways[556]!! to hallways[552]!!] = 1 * unit

    globalDistances[hallways[553]!! to hallways[557]!!] = 1 * unit
    globalDistances[hallways[557]!! to hallways[553]!!] = 1 * unit

    globalDistances[hallways[554]!! to hallways[558]!!] = 1 * unit
    globalDistances[hallways[558]!! to hallways[554]!!] = 1 * unit

    globalDistances[hallways[555]!! to hallways[559]!!] = 1 * unit
    globalDistances[hallways[559]!! to hallways[555]!!] = 1 * unit

    globalDistances[hallways[556]!! to hallways[560]!!] = 1 * unit
    globalDistances[hallways[560]!! to hallways[556]!!] = 1 * unit

    globalDistances[hallways[557]!! to hallways[561]!!] = 1 * unit
    globalDistances[hallways[561]!! to hallways[557]!!] = 1 * unit

    globalDistances[hallways[558]!! to hallways[562]!!] = 1 * unit
    globalDistances[hallways[562]!! to hallways[558]!!] = 1 * unit

    globalDistances[hallways[559]!! to hallways[564]!!] = 1 * unit
    globalDistances[hallways[564]!! to hallways[559]!!] = 1 * unit

    globalDistances[hallways[560]!! to hallways[565]!!] = 1 * unit
    globalDistances[hallways[565]!! to hallways[560]!!] = 1 * unit

    globalDistances[hallways[561]!! to hallways[562]!!] = 2 * unit
    globalDistances[hallways[562]!! to hallways[561]!!] = 2 * unit

    globalDistances[hallways[561]!! to hallways[570]!!] = 1 * unit
    globalDistances[hallways[570]!! to hallways[561]!!] = 1 * unit

    globalDistances[hallways[563]!! to hallways[564]!!] = 1 * unit
    globalDistances[hallways[564]!! to hallways[563]!!] = 1 * unit

    globalDistances[hallways[564]!! to hallways[565]!!] = 2 * unit
    globalDistances[hallways[565]!! to hallways[564]!!] = 2 * unit

    globalDistances[hallways[565]!! to hallways[566]!!] = 1.75 * unit
    globalDistances[hallways[566]!! to hallways[565]!!] = 1.75 * unit

    globalDistances[hallways[565]!! to hallways[574]!!] = 2 * unit
    globalDistances[hallways[574]!! to hallways[565]!!] = 2 * unit

    globalDistances[hallways[566]!! to hallways[567]!!] = 1.5 * unit
    globalDistances[hallways[567]!! to hallways[566]!!] = 1.5 * unit

    globalDistances[hallways[567]!! to hallways[575]!!] = 2 * unit
    globalDistances[hallways[575]!! to hallways[567]!!] = 2 * unit

    globalDistances[hallways[567]!! to hallways[568]!!] = 1.5 * unit
    globalDistances[hallways[568]!! to hallways[567]!!] = 1.5 * unit

    globalDistances[hallways[568]!! to hallways[569]!!] = 1.5 * unit
    globalDistances[hallways[569]!! to hallways[568]!!] = 1.5 * unit

    globalDistances[hallways[569]!! to hallways[570]!!] = 1.75 * unit
    globalDistances[hallways[570]!! to hallways[569]!!] = 1.75 * unit

    globalDistances[hallways[569]!! to hallways[572]!!] = 1 * unit
    globalDistances[hallways[572]!! to hallways[569]!!] = 1 * unit

    globalDistances[hallways[570]!! to hallways[573]!!] = 1.5 * unit
    globalDistances[hallways[573]!! to hallways[570]!!] = 1.5 * unit

    globalDistances[hallways[572]!! to hallways[576]!!] = 1 * unit
    globalDistances[hallways[576]!! to hallways[572]!!] = 1 * unit

    globalDistances[hallways[573]!! to hallways[577]!!] = 0.5 * unit
    globalDistances[hallways[577]!! to hallways[573]!!] = 0.5 * unit

    globalDistances[hallways[574]!! to hallways[579]!!] = 2 * unit
    globalDistances[hallways[579]!! to hallways[574]!!] = 2 * unit

    globalDistances[hallways[575]!! to hallways[583]!!] = 2 * unit
    globalDistances[hallways[583]!! to hallways[575]!!] = 2 * unit

    globalDistances[hallways[576]!! to hallways[578]!!] = 1 * unit
    globalDistances[hallways[578]!! to hallways[576]!!] = 1 * unit

    globalDistances[hallways[577]!! to hallways[587]!!] = 2 * unit
    globalDistances[hallways[587]!! to hallways[577]!!] = 2 * unit

    globalDistances[hallways[578]!! to hallways[586]!!] = 1 * unit
    globalDistances[hallways[586]!! to hallways[578]!!] = 1 * unit

    globalDistances[hallways[579]!! to hallways[580]!!] = 1.25 * unit
    globalDistances[hallways[580]!! to hallways[579]!!] = 1.25 * unit

    globalDistances[hallways[580]!! to hallways[581]!!] = 0.5 * unit
    globalDistances[hallways[581]!! to hallways[580]!!] = 0.5 * unit

    globalDistances[hallways[581]!! to hallways[582]!!] = 0.75 * unit
    globalDistances[hallways[582]!! to hallways[581]!!] = 0.75 * unit

    globalDistances[hallways[582]!! to hallways[583]!!] = 0.75* unit
    globalDistances[hallways[583]!! to hallways[582]!!] = 0.75* unit

    globalDistances[hallways[583]!! to hallways[584]!!] = 1 * unit
    globalDistances[hallways[584]!! to hallways[583]!!] = 1 * unit

    globalDistances[hallways[584]!! to hallways[585]!!] = 1 * unit
    globalDistances[hallways[585]!! to hallways[584]!!] = 1 * unit

    globalDistances[hallways[585]!! to hallways[586]!!] = 1 * unit
    globalDistances[hallways[586]!! to hallways[585]!!] = 1 * unit

    globalDistances[hallways[586]!! to hallways[587]!!] = 1.75 * unit
    globalDistances[hallways[587]!! to hallways[586]!!] = 1.75 * unit
}



fun createClassroomToHallwayMap5(hallways: Map<Int, HallwayNode>): Map<Int, List<Int>> {
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







