// incorrect
function cutTheTree(data, edges) {
  let minDiff = Infinity;
  edges.forEach(edge => {
    // take each edge
    let tempEdges = [...edges];
    let index = tempEdges.indexOf(edge);
    tempEdges.splice(index, 1); // remove it from search
    let leftSum = data[edge[0] - 1];
    let rightSum = data[edge[1] - 1];
    let leftArray = [], rightArray = []; //an array to store the child nodes
    for (let i = 0; i<tempEdges.length;){
      if (tempEdges[i].includes(edge[0]) || tempEdges[i].includes(edge[1])){ // if edge has child node
      if (tempEdges[i].includes(edge[0])){
        if (tempEdges[i][0] == edge[0]) {
          leftSum += data[tempEdges[i][1] - 1];
          leftArray.push(tempEdges[i][1]); // store the nodes to search it later
          index = tempEdges.indexOf(tempEdges[i]);
          tempEdges.splice(index, 1); //remove the node from edge to avoid repeated search
          i = 0;
        }
        else if (tempEdges[i][1] == edge[0]) {
          leftSum += data[tempEdges[i][0] - 1];
          leftArray.push(tempEdges[i][0]);
          index = tempEdges.indexOf(tempEdges[i]);
          tempEdges.splice(index, 1);
          i = 0;
        }
      }
      if (tempEdges[i].includes(edge[1])){
        if (tempEdges[i][0] == edge[1]) {
          rightSum += data[tempEdges[i][1] - 1];
          rightArray.push(tempEdges[i][1]);
          index = tempEdges.indexOf(tempEdges[i]);
          tempEdges.splice(index, 1);
          i = 0;
        }
        else if (tempEdges[i][1] == edge[1]) {
          rightSum += data[tempEdges[i][0] - 1];
          rightArray.push(tempEdges[i][0]);
          index = tempEdges.indexOf(tempEdges[i]);
          tempEdges.splice(index, 1);
          i = 0
        }
      }
    }else i++;
    }
    //using the child nodes, find their child nodes
    for (let node of leftArray){
      for(let i = 0; i < tempEdges.length;){
        if (tempEdges[i].includes(node)){
          if (node == tempEdges[i][0]) {
            leftSum += data[tempEdges[i][1] - 1];
            leftArray.push(tempEdges[i][1]);
            index = tempEdges.indexOf(tempEdges[i]);
            tempEdges.splice(index, 1);
            i = 0
          }
          else if (node == tempEdges[i][1]) {
            leftSum += data[tempEdges[i][0] - 1];
            leftArray.push(tempEdges[i][0]);
            index = tempEdges.indexOf(tempEdges[i]);
            tempEdges.splice(index, 1);
            i = 0
          }
        }else i++;
      }
    }
    for (let node of rightArray) {
      for(let i = 0; i < tempEdges.length;){
        if (tempEdges[i].includes(node)){
          if (node == tempEdges[i][0]) {
            rightSum += data[tempEdges[i][1] - 1];
            rightArray.push(tempEdges[i][1]);
            index = tempEdges.indexOf(tempEdges[i]);
            tempEdges.splice(index, 1);
            i = 0
          }
          else if (node == tempEdges[i][1]) {
            leftSum += data[tempEdges[i][0] - 1];
            leftArray.push(tempEdges[i][0]);
            index = tempEdges.indexOf(tempEdges[i]);
            tempEdges.splice(index, 1);
            i = 0
          }
        }else i++;
      }
    }
    let diff = Math.abs(rightSum - leftSum);
    //console.log(rightSum, leftSum, diff)
    if (diff < minDiff) minDiff = diff;
  })
  return minDiff;
}

console.log(cutTheTree([1,2,3,4,5,6], [[1,2],[1,3],[2,6],[3,4],[3,5]]));