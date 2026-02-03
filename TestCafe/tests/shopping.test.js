import loginPage from '../pages/LoginPage';
import inventoryPage from '../pages/InventoryPage';
import cartPage from '../pages/CartPage';
import { USERS, URLS, PRODUCTS } from '../data/testData';

fixture `Suite de Compras - SauceDemo`
    .page(URLS.BASE)
    .beforeEach(async t => {
        await t.maximizeWindow();
        await loginPage.login(USERS.STANDARD.username, USERS.STANDARD.password);
    });

test('Flujo completo: Agregar producto y verificar en carrito', async t => {
    const productName = PRODUCTS.BACKPACK;

    // Acciones
    await inventoryPage.addItemToCart(productName);
    await inventoryPage.goToCart();

    // Verificaciones
    const url = await t.eval(() => window.location.href);
    await t.expect(url).contains('/cart.html');
    
    await cartPage.confirmItemIsInTheCart(productName);
});

test('Validar que el contador del carrito aumenta', async t => {
    await inventoryPage.addItemToCart(PRODUCTS.BIKE_LIGHT);
    
    // Verificamos que el badge del carrito diga "1"
    await t.expect(inventoryPage.cartBadge.innerText).eql('1');
});