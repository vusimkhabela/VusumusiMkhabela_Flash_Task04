[RemoteTestNG] detected TestNG version 7.10.2
SLF4J(W): No SLF4J providers were found.
SLF4J(W): Defaulting to no-operation (NOP) logger implementation
SLF4J(W): See https://www.slf4j.org/codes.html#noProviders for further details.
Dec 22, 2024 5:17:03 AM org.openqa.selenium.devtools.CdpVersionFinder findNearestMatch
WARNING: Unable to find an exact match for CDP version 131, returning the closest version; found: 129; Please update to a Selenium version that supports CDP version 131


---------------------------------------Test Case 01 : Registration-------------------------------------------

1. The user clicks the REGISTER link in the Navigation Bar.
1.1 The user is directed to the registration form.
1.2 The heading is correct: Register.
1.3 The user selects MALE from the gender radio buttons.
1.4 The user enters first name into the first name field: FName_Test
1.5 The user enters last name into the last name field: LName_Test
1.6 The user enters email into the email field: Tester61@flash.co.za
1.7 The user enters password Test into the password field.
1.8 The user confirms the password into the confirm password field.
1.9 Registration was successfull for user: Tester61@flash.co.za


---------------------------------------Test Case 02 : Dashboard & Computers-------------------------------------------

2. The user clicks the COMPUTERS tab in the heading bar.
2.1 The heading is correct: Register.
2.2 The 'Desktop' Category is displaying.
2.3. The user clicked the 'Desktop' category.
2.4 The heading is correct: Desktops.
2.5 The desktops are sorted by Name: A to Z
2.6 The desktops are sorted by Name: Z to A
2.7 The desktops are sorted by Price: Low to High
2.8 The desktops are sorted by Price: High to Low
2.9 The desktops are sorted by : Created on
2.9.1 User selects a desktop
**First item successfully added to cart
2.9.2 User selects a desktop
**second item successfully added to cart
2.9.3 User selects a desktop
Error: User tried adding item without necessary info.
**third item successfully added to cart
2.9.4 User selects a desktop
**Forth item successfully added to cart


---------------------------------------Test Case 03 : Cart & Checkout-------------------------------------------

3. The user clicks the SHOPPING CART link.
3.1 The heading is correct: Shopping cart.
Expected Total: 4695 vs Actual Total: 4695.00
3.2 The user selected item to delete.
3.3 The user clicks update cart to remove item from shopping cart.
3.4 The total price has been successfully updated. New total is: 4695.0
3.5 The user clicks the CHECKOUT button.
3.6 The heading is correct: Checkout.
3.7 The selects a country : South Africa
3.8 The user enters City into the City field: City_Test
3.9 The user enters Address Line 1 into the Address Line 1 field: Address_L1_Test
3.10 The user enters Address Line 2 into the Address Line 2 field: Address_L2_Test
3.11 The user enters zip code into the zip code field: Zip_Test
3.12 The user enters phone number into the phone number field: +27767531710
3.13 The user enters fax number into the fax number field: +27213674611
3.14 The user clicks the continue button.
*** The user clicks pickup in store.
3.15 The order has been successfully placed.
3.16 The user is directed to the order confirmation page..
3.17 The heading is correct: Thank you.
3.18 The user clicks order details link to see order details.
3.19 The user logged out.


---------------------------------------Test Case 04 : Login & Account-------------------------------------------

4. The user clicks the LOG IN link.
4.1 The user has entered details.
4.2 The user logged in successfully.
4.3 The user clicks the ACCOUNT button.
4.4 The user is directed to the Customer Info page form.
4.5 The heading is correct: My account - Customer info.
4.6 The user clicks on the orders menu option.
4.7 The user clicks on the order details link
4.8 [[ChromeDriver: chrome on windows (711252a6dd6ae8da0295cba22a65c661)] -> css selector: div[class='order-number'] strong] has been successfully placed.