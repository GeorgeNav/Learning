/*  Practice 1 (pg.64)
    Calculate total price of a phone purchase
    Buy phones until running out of money
    Then buy accessories until amount is below mental spending threshold
    Then add in the tax
    Check the amount against your bank
    BONUS: prompt()
*/
const TAX_RATE = 0.08;
const PHONE_PRICE = 560.00;
const ACCESSORY = 35.00;
const SPENDING_THRESHOLD = 15000.00;
var balance = 20000.00;
var amount = 0.00;

function total(oPrice) {
    oPrice += oPrice*TAX_RATE;
    return oPrice;
}
function Dollars(val) {
    return "$" + val.toFixed(2);
}
while (amount < balance) { // Buy phones while you still have money
    amount += PHONE_PRICE;
    if(amount < SPENDING_THRESHOLD) // Buy an accessory for current phone that was just added for purchase
        amount += ACCESSORY; 
}
console.log("Before tax: " + Dollars(amount));
amount = total(amount); // Adds the tax
console.log("After tax: " + Dollars(amount));
if (amount < balance)
    console.log("You can afford this purchase!");
else
    console.log("You cannot afford this purchase");
