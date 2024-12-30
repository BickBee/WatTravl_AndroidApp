let nodeId = 601;
const nodeMap = {};




document.getElementById('fileInput').addEventListener('change', function(event) {
    const file = event.target.files[0];
    if (file.type !== "image/svg+xml") {
        alert('Please select an SVG file.');
        return;
    }

    const reader = new FileReader();
    reader.onload = function(e) {
        const svgContainer = document.getElementById('svgContainer');
        svgContainer.innerHTML = e.target.result; // Load the SVG into the container

        const svgElement = svgContainer.querySelector('svg');
        if (!svgElement) {
            alert('No SVG found in the file.');
            return;
        }

        svgElement.id = 'mySvg'; // Assign ID required for other operations
        setupSvgInteraction(svgElement);
    };
    reader.readAsText(file);
});


function setupSvgInteraction(svg) {
    svg.addEventListener('click', function(event) {
        const rect = this.getBoundingClientRect();
        const svgX = event.clientX - rect.left;
        const svgY = event.clientY - rect.top;

        // Scale the coordinates if necessary (remove if not required)
        const scaleX = this.viewBox.baseVal.width ? this.viewBox.baseVal.width / rect.width : 1;
        const scaleY = this.viewBox.baseVal.height ? this.viewBox.baseVal.height / rect.height : 1;
        const x = svgX * scaleX;
        const y = svgY * scaleY;


        // Add the node to our map
        nodeMap[nodeId] = { x: Math.round(x), y: Math.round(y), element: [] };

        // Visualize the node
        const circle = document.createElementNS("http://www.w3.org/2000/svg", "circle");
        circle.setAttribute("cx", x);
        circle.setAttribute("cy", y);
        circle.setAttribute("r", 5);
        circle.setAttribute("fill", "red");
        circle.setAttribute("id", 'node-' + nodeId);
        this.appendChild(circle);
        nodeMap[nodeId].element.push(circle);

        // Display node number
        const text = document.createElementNS("http://www.w3.org/2000/svg", "text");
        text.setAttribute("x", x + 10); // Adjust position to not overlap the circle
        text.setAttribute("y", y + 5);
        text.textContent = nodeId;
        text.setAttribute("font-family", "Arial");
        text.setAttribute("font-size", "12px");
        text.setAttribute("fill", "blue");
        text.setAttribute("id", 'text-' + nodeId);
        this.appendChild(text);
        nodeMap[nodeId].element.push(text);

        console.log(`Node ${nodeId}: (${x}, ${y})`);
        nodeId++;
    });

    
    // Implement key event listener for removing nodes and any additional functionalities
}


document.addEventListener('keydown', function(event) {
    if (event.key === 'x' || event.key === 'X') { // Consider uppercase as well
        if (nodeId > 100) {
            nodeId--;
            const lastNode = nodeMap[nodeId];
            if (lastNode) {
                lastNode.element.forEach(el => el.parentNode.removeChild(el));
                delete nodeMap[nodeId];
            }
        }
    }
});


function exportNodes() {
    let kotlinCode = "val nodesToCoords = mapOf(\n";
    Object.keys(nodeMap).forEach((id, index, array) => {
        kotlinCode += `    ${id} to Pair(${nodeMap[id].x}, ${nodeMap[id].y})${index < array.length - 1 ? ',' : ''}\n`;
    });
    kotlinCode += ")";
    console.log(kotlinCode);
}
