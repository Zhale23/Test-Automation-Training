import { Selector } from 'testcafe';
import loginPage from '../pages/LoginPage.js';
import inventoryPage from '../pages/InventoryPage.js';
import cartPage from '../pages/CartPage.js';
import checkoutPage from '../pages/CheckoutPage.js';
import { USERS, URLS, PRODUCTS, SHIPPING_INFO } from '../data/testData';


fixture`Suite de Compras - SauceDemo`
    .page(URLS.BASE)
    .beforeEach(async t => {
        await t.maximizeWindow();
        await loginPage.login(USERS.STANDARD.username, USERS.STANDARD.password);
    });
test('Reto Pro: Validación de Suma de Precios', async t => {

    // 1. Login
    // 2. Agregar 3 productos y guardar sus precios
    const result = await inventoryPage.addRandomItemsToCart(3);
    // 3. Ir a Checkout
    await inventoryPage.goToCart();
    await cartPage.goToCheckout();
    // 4. Llenar info
    await checkoutPage.fillCheckoutInformation(SHIPPING_INFO.FIRST_NAME, SHIPPING_INFO.LAST_NAME, SHIPPING_INFO.POSTAL_CODE);
    await checkoutPage.continueCheckout();
    // 5. ASSERT: Suma de guardados === Item Total de la página
    // Borra el .ok() del final
    await t.expect(await checkoutPage.returnItemsTotal()).eql(result, "Los totales no coinciden"); 
    await checkoutPage.finishCheckout();
});