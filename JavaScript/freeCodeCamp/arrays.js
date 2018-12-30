var multiDimArr = [["Dog", 2],["Cat", 3],["Deer", 5]];
var first = multiDimArr.shift(); // multiDimArr is [["Cat", 3],["Deer", 5]] now
console.log(first);
var lengthAfterShift = multiDimArr.unshift(["Dog", 2]); // Adds array to beginning of multiDimArr
console.log(lengthAfterShift);
var last = multiDimArr.pop(); // remove last element from array and set last to it
console.log(last);

var arr1 = [1,2,3,4];
var arr2;
arr2 = arr1;
arr1[0] = 5;
console.log(arr2); // will have arr1 contents
arr1[0] = 1; // changed value back
arr2 = [...arr1]; // gets a copy (not a reference) of arr1 elements
arr1[0] = 5;
console.log(arr2); // will have arr1 contents

var arr3 = [1,2,3,4,5];
var [a,b] = arr3 // sets a and b to the values in arr3 in order
console.log(a + ', ' + b);
[a,b] = [b,a]; // swaps array values
console.log(a + ', ' + b);

var arr;
[ ,...arr] = [...arr3]; // skip first element of arr3
console.log(arr);
[ , ,...arr] = [...arr3]; // skip first two elements of arr3
console.log(arr);
