// Centraliza tus datos de prueba para reutilizarlos
export const USERS = {
    STANDARD: {
        username: 'standard_user',
        password: 'secret_sauce'
    },
    LOCKED: {
        username: 'locked_out_user',
        password: 'secret_sauce'
    },
    INVALID: {
        username: 'usuario_falso',
        password: 'password_incorrecto'
    }
};

export const URLS = {
    BASE: 'https://www.saucedemo.com/',
    INVENTORY: 'https://www.saucedemo.com/inventory.html',
    CART: 'https://www.saucedemo.com/cart.html'
};

export const PRODUCTS = {
    BACKPACK: 'Sauce Labs Backpack',
    BIKE_LIGHT: 'Sauce Labs Bike Light',
    BOLT_TSHIRT: 'Sauce Labs Bolt T-Shirt'
};

export const ERROR_MESSAGES = {
    INVALID_CREDENTIALS: 'Username and password do not match',
    NO_CREDENTIALS: 'Username is required',
    LOCKED_OUT: 'Sorry, this user has been locked out.'
};

export const SHIPPING_INFO = {
    FIRST_NAME: 'John',
    LAST_NAME: 'Doe',
    POSTAL_CODE: '12345'
}