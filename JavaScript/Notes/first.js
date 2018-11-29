console.log("Hello"); // Prints output
/* alert("Please enter your name"); */ // Gathers user input (browser only)

// Loose vs strict equals/not equals
var a = "42"; // Can be changed to a number data type if needed because JavaScript uses dynamic typing
var b = 42;
if (a == b) // Here type conversion is done if needed so both a and b are of the same type
    console.log("a is loosely equal b");
else if (a != b)
    console.log("a is loosely equal b");
if (a === b) // Here type conversion is not done (ideal)
    console.log("a is strictly equal to b");
else if (a !== b)
    console.log("a is not strictly equal to b");

const TAX_RATE = 0.08; // This value cannot be changed
function total (val) {
    return val + val*TAX_RATE;
}
var amount = 199.993977; // Fixes number value to 2 decimal places
console.log("$" + total(amount).toFixed(2));